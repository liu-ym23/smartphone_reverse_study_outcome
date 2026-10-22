package org.bouncycastle.jce;

import java.io.IOException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.MacData;
import org.bouncycastle.asn1.pkcs.Pfx;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS12Util {
    public PKCS12Util() {
    }

    private static byte[] calculatePbeMac(ASN1ObjectIdentifier r100, byte[] r101, int r102, char[] r103, byte[] r104, String r105) throws Exception {
        SecretKeyFactory r106 = SecretKeyFactory.getInstance(r100.getId(), r105);
        PBEParameterSpec r107 = new PBEParameterSpec(r101, r102);
        SecretKey r108 = r106.generateSecret(new PBEKeySpec(r103));
        Mac r109 = Mac.getInstance(r100.getId(), r105);
        r109.init(r108, r107);
        r109.update(r104);
        return r109.doFinal();
    }

    public static byte[] convertToDefiniteLength(byte[] r100) throws IOException {
        return Pfx.getInstance(r100).getEncoded(ASN1Encoding.DER);
    }

    public static byte[] convertToDefiniteLength(byte[] r110, char[] r111, String r112) throws IOException {
        Pfx r113 = Pfx.getInstance(r110);
        ContentInfo r100 = r113.getAuthSafe();
        ContentInfo r101 = new ContentInfo(r100.getContentType(), new DEROctetString(ASN1Primitive.fromByteArray(ASN1OctetString.getInstance(r100.getContent()).getOctets()).getEncoded(ASN1Encoding.DER)));
        MacData r114 = r113.getMacData();
        int r102 = r114.getIterationCount().intValue();     // Catch: Exception -> L6
        return new Pfx(r101, new MacData(new DigestInfo(new AlgorithmIdentifier(r114.getMac().getAlgorithmId().getAlgorithm(), DERNull.INSTANCE), calculatePbeMac(r114.getMac().getAlgorithmId().getAlgorithm(), r114.getSalt(), r102, r111, ASN1OctetString.getInstance(r101.getContent()).getOctets(), r112)), r114.getSalt(), r102)).getEncoded(ASN1Encoding.DER);
    L6:
        e = move-exception;
        throw new IOException("error constructing MAC: " + e.toString());
    }
}
