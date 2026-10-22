package org.bouncycastle.crypto.util;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.SecureRandom;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public class JournaledAlgorithm implements Encodable, Serializable {
    private transient AlgorithmIdentifier algID;
    private transient JournalingSecureRandom journaling;

    public JournaledAlgorithm(AlgorithmIdentifier r100, JournalingSecureRandom r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L8;
        this.journaling = r101;
        this.algID = r100;
        return;
    L8:
        throw new NullPointerException("JournalingSecureRandom passed to JournaledAlgorithm is null");
    L10:
        throw new NullPointerException("AlgorithmIdentifier passed to JournaledAlgorithm is null");
    }

    public JournaledAlgorithm(byte[] r100) {
        this(r100, CryptoServicesRegistrar.getSecureRandom());
    }

    public JournaledAlgorithm(byte[] r100, SecureRandom r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L8;
        initFromEncoding(r100, r101);
        return;
    L8:
        throw new NullPointerException("random passed to JournaledAlgorithm is null");
    L10:
        throw new NullPointerException("encoding passed to JournaledAlgorithm is null");
    }

    public static JournaledAlgorithm getState(File r100, SecureRandom r101) throws IOException, ClassNotFoundException {
        if (r100 == null) goto L11;
        BufferedInputStream r102 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));
        JournaledAlgorithm r103 = new JournaledAlgorithm(Streams.readAll(r102), r101);     // Catch: Throwable -> L7
        r102.close();
        return r103;
    L7:
        th = move-exception;
        r102.close();
        throw th;
    L11:
        throw new NullPointerException("File for loading is null in JournaledAlgorithm");
    }

    public static JournaledAlgorithm getState(InputStream r100, SecureRandom r101) throws IOException, ClassNotFoundException {
        if (r100 == null) goto L11;
        BufferedInputStream r102 = new BufferedInputStream(r100);
        JournaledAlgorithm r103 = new JournaledAlgorithm(Streams.readAll(r102), r101);     // Catch: Throwable -> L7
        r102.close();
        return r103;
    L7:
        th = move-exception;
        r102.close();
        throw th;
    L11:
        throw new NullPointerException("stream for loading is null in JournaledAlgorithm");
    }

    private void initFromEncoding(byte[] r100, SecureRandom r101) {
        ASN1Sequence r102 = ASN1Sequence.getInstance(r100);
        this.algID = AlgorithmIdentifier.getInstance(r102.getObjectAt(0));
        this.journaling = new JournalingSecureRandom(ASN1OctetString.getInstance(r102.getObjectAt(1)).getOctets(), r101);
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        initFromEncoding((byte[]) r100.readObject(), CryptoServicesRegistrar.getSecureRandom());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(getEncoded());
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.algID;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(this.algID);
        r100.add(new DEROctetString(this.journaling.getFullTranscript()));
        return new DERSequence(r100).getEncoded();
    }

    public JournalingSecureRandom getJournalingSecureRandom() {
        return this.journaling;
    }

    public void storeState(File r100) throws IOException {
        if (r100 == null) goto L11;
        PolarisFileOutputStreamWrapper r101 = new PolarisFileOutputStreamWrapper(r100);
        storeState(r101);     // Catch: Throwable -> L7
        r101.close();
        return;
    L7:
        th = move-exception;
        r101.close();
        throw th;
    L11:
        throw new NullPointerException("file for storage is null in JournaledAlgorithm");
    }

    public void storeState(OutputStream r100) throws IOException {
        if (r100 == null) goto L6;
        r100.write(getEncoded());
        return;
    L6:
        throw new NullPointerException("output stream for storage is null in JournaledAlgorithm");
    }
}
