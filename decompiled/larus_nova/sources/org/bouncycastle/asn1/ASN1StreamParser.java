package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1StreamParser {
    private final InputStream _in;
    private final int _limit;
    private final byte[][] tmpBuffers;

    public ASN1StreamParser(InputStream r100) {
        this(r100, StreamUtil.findLimit(r100));
    }

    public ASN1StreamParser(InputStream r100, int r101) {
        this._in = r100;
        this._limit = r101;
        this.tmpBuffers = new byte[11][];
    }

    public ASN1StreamParser(byte[] r100) {
        this(new ByteArrayInputStream(r100), r100.length);
    }

    private void set00Check(boolean r100) {
        InputStream r101 = this._in;
        if ((r101 instanceof IndefiniteLengthInputStream) == false) goto L6;
        ((IndefiniteLengthInputStream) r101).setEofOn00(r100);
        return;
    }

    public ASN1Encodable readImplicit(boolean r100, int r101) throws IOException {
        InputStream r102 = this._in;
        if ((r102 instanceof IndefiniteLengthInputStream) == false) goto L10;
        if (r100 == false) goto L8;
        return readIndef(r101);
    L8:
        throw new IOException("indefinite-length primitive encoding encountered");
    L10:
        if (r100 == false) goto L20;
        if (r101 == 4) goto L19;
        if (r101 == 16) goto L17;
        if (r101 != 17) goto L24;
        return new DLSetParser(this);
    L24:
        throw new ASN1Exception("implicit tagging not implemented");
    L17:
        return new DLSequenceParser(this);
    L19:
        return new BEROctetStringParser(this);
    L20:
        if (r101 == 4) goto L30;
        if (r101 == 16) goto L28;
        if (r101 != 17) goto L24;
        throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
    L28:
        throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
    L30:
        return new DEROctetStringParser((DefiniteLengthInputStream) r102);
    }

    public ASN1Encodable readIndef(int r100) throws IOException {
        if (r100 == 4) goto L19;
        if (r100 == 8) goto L17;
        if (r100 == 16) goto L15;
        if (r100 != 17) goto L13;
        return new BERSetParser(this);
    L13:
        throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(r100));
    L15:
        return new BERSequenceParser(this);
    L17:
        return new DERExternalParser(this);
    L19:
        return new BEROctetStringParser(this);
    }

    public ASN1Encodable readObject() throws IOException {
        int r100 = this._in.read();
        if (r100 != (-1)) goto L6;
        return null;
    L6:
        boolean r101 = false;
        set00Check(false);
        int r102 = ASN1InputStream.readTagNumber(this._in, r100);
        if ((r100 & 32) == 0) goto L9;
        boolean r103 = true;
    L10:
        InputStream r104 = this._in;
        int r105 = this._limit;
        if (r102 == 4) goto L15;
        if (r102 == 16) goto L15;
        if (r102 == 17) goto L15;
        if (r102 == 8) goto L15;
    L16:
        int r106 = ASN1InputStream.readLength(r104, r105, r101);
        if (r106 >= 0) goto L31;
        if (r103 == false) goto L30;
        ASN1StreamParser r107 = new ASN1StreamParser(new IndefiniteLengthInputStream(this._in, this._limit), this._limit);
        if ((r100 & 64) == 0) goto L24;
        return new BERApplicationSpecificParser(r102, r107);
    L24:
        if ((r100 & 128) == 0) goto L28;
        return new BERTaggedObjectParser(true, r102, r107);
    L28:
        return r107.readIndef(r102);
    L30:
        throw new IOException("indefinite-length primitive encoding encountered");
    L31:
        DefiniteLengthInputStream r108 = new DefiniteLengthInputStream(this._in, r106, this._limit);
        if ((r100 & 64) == 0) goto L36;
        return new DLApplicationSpecific(r103, r102, r108.toByteArray());
    L36:
        if ((r100 & 128) != 0) goto L38;
        if (r103 == false) goto L54;
        if (r102 == 4) goto L53;
        if (r102 == 8) goto L51;
        if (r102 == 16) goto L49;
        if (r102 != 17) goto L47;
        return new DLSetParser(new ASN1StreamParser(r108));
    L47:
        throw new IOException("unknown tag " + r102 + " encountered");
    L49:
        return new DLSequenceParser(new ASN1StreamParser(r108));
    L51:
        return new DERExternalParser(new ASN1StreamParser(r108));
    L53:
        return new BEROctetStringParser(new ASN1StreamParser(r108));
    L54:
        if (r102 == 4) goto L61;
        return ASN1InputStream.createPrimitiveDERObject(r102, r108, this.tmpBuffers);
    L57:
        e = move-exception;
        throw new ASN1Exception("corrupted stream detected", e);
    L61:
        return new DEROctetStringParser(r108);
    L38:
        return new BERTaggedObjectParser(r103, r102, new ASN1StreamParser(r108));
    L15:
        r101 = true;
        goto L16
    L9:
        r103 = false;
        goto L10
    }

    public ASN1Primitive readTaggedObject(boolean r100, int r101) throws IOException {
        if (r100 == false) goto L5;
        ASN1EncodableVector r102 = readVector();
        if ((this._in instanceof IndefiniteLengthInputStream) == false) goto L14;
        if (r102.size() != 1) goto L12;
        return new BERTaggedObject(true, r101, r102.get(0));
    L12:
        return new BERTaggedObject(false, r101, BERFactory.createSequence(r102));
    L14:
        if (r102.size() != 1) goto L17;
        return new DLTaggedObject(true, r101, r102.get(0));
    L17:
        return new DLTaggedObject(false, r101, DLFactory.createSequence(r102));
    L5:
        return new DLTaggedObject(false, r101, new DEROctetString(((DefiniteLengthInputStream) this._in).toByteArray()));
    }

    public ASN1EncodableVector readVector() throws IOException {
        ASN1Encodable r100 = readObject();
        if (r100 == null) goto L5;
        ASN1EncodableVector r101 = new ASN1EncodableVector();
    L8:
        if ((r100 instanceof InMemoryRepresentable) == false) goto L10;
        ASN1Primitive r102 = ((InMemoryRepresentable) r100).getLoadedObject();
    L11:
        r101.add(r102);
        r100 = readObject();
        if (r100 != null) goto L8;
        return r101;
    L10:
        r102 = r100.toASN1Primitive();
        goto L11
    L5:
        return new ASN1EncodableVector(0);
    }
}
