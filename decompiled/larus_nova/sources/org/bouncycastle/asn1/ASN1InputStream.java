package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1InputStream extends FilterInputStream implements BERTags {
    private final boolean lazyEvaluate;
    private final int limit;
    private final byte[][] tmpBuffers;

    public ASN1InputStream(InputStream r100) {
        this(r100, StreamUtil.findLimit(r100));
    }

    public ASN1InputStream(InputStream r100, int r101) {
        this(r100, r101, false);
    }

    public ASN1InputStream(InputStream r100, int r101, boolean r102) {
        super(r100);
        this.limit = r101;
        this.lazyEvaluate = r102;
        this.tmpBuffers = new byte[11][];
    }

    public ASN1InputStream(InputStream r100, boolean r101) {
        this(r100, StreamUtil.findLimit(r100), r101);
    }

    public ASN1InputStream(byte[] r100) {
        this(new ByteArrayInputStream(r100), r100.length);
    }

    public ASN1InputStream(byte[] r100, boolean r101) {
        this(new ByteArrayInputStream(r100), r100.length, r101);
    }

    public static ASN1Primitive createPrimitiveDERObject(int r100, DefiniteLengthInputStream r101, byte[][] r102) throws IOException {
        if (r100 == 10) goto L51;
        if (r100 == 12) goto L49;
        if (r100 == 30) goto L47;
        switch(r100) {
            case 1: goto L45;
            case 2: goto L43;
            case 3: goto L41;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L35;
            default: goto L9;
        };
    L9:
        switch(r100) {
            case 18: goto L33;
            case 19: goto L31;
            case 20: goto L29;
            case 21: goto L27;
            case 22: goto L25;
            case 23: goto L23;
            case 24: goto L21;
            case 25: goto L19;
            case 26: goto L17;
            case 27: goto L15;
            case 28: goto L13;
            default: goto L11;
        };
    L11:
        throw new IOException("unknown tag " + r100 + " encountered");
    L13:
        return new DERUniversalString(r101.toByteArray());
    L15:
        return new DERGeneralString(r101.toByteArray());
    L17:
        return new DERVisibleString(r101.toByteArray());
    L19:
        return new DERGraphicString(r101.toByteArray());
    L21:
        return new ASN1GeneralizedTime(r101.toByteArray());
    L23:
        return new ASN1UTCTime(r101.toByteArray());
    L25:
        return new DERIA5String(r101.toByteArray());
    L27:
        return new DERVideotexString(r101.toByteArray());
    L29:
        return new DERT61String(r101.toByteArray());
    L31:
        return new DERPrintableString(r101.toByteArray());
    L33:
        return new DERNumericString(r101.toByteArray());
    L35:
        return ASN1ObjectIdentifier.fromOctetString(getBuffer(r101, r102));
    L37:
        return DERNull.INSTANCE;
    L39:
        return new DEROctetString(r101.toByteArray());
    L41:
        return ASN1BitString.fromInputStream(r101.getRemaining(), r101);
    L43:
        return new ASN1Integer(r101.toByteArray(), false);
    L45:
        return ASN1Boolean.fromOctetString(getBuffer(r101, r102));
    L47:
        return new DERBMPString(getBMPCharBuffer(r101));
    L49:
        return new DERUTF8String(r101.toByteArray());
    L51:
        return ASN1Enumerated.fromOctetString(getBuffer(r101, r102));
    }

    private static char[] getBMPCharBuffer(DefiniteLengthInputStream r110) throws IOException {
        int r100 = r110.getRemaining();
        if ((r100 & 1) != 0) goto L28;
        int r101 = r100 / 2;
        char[] r102 = new char[r101];
        byte[] r103 = new byte[8];
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r100 < 8) goto L12;
        if (Streams.readFully(r110, r103, 0, 8) != 8) goto L11;
        r102[r105] = (char) ((r103[0] << 8) | (r103[1] & UByte.MAX_VALUE));
        r102[r105 + 1] = (char) ((r103[2] << 8) | (r103[3] & UByte.MAX_VALUE));
        r102[r105 + 2] = (char) ((r103[4] << 8) | (r103[5] & UByte.MAX_VALUE));
        r102[r105 + 3] = (char) ((r103[6] << 8) | (r103[7] & UByte.MAX_VALUE));
        r105 = r105 + 4;
        r100 = r100 - 8;
        goto L6
    L11:
        throw new EOFException("EOF encountered in middle of BMPString");
    L12:
        if (r100 <= 0) goto L22;
        if (Streams.readFully(r110, r103, 0, r100) != r100) goto L20;
    L15:
        int r106 = r104 + 1;
        int r107 = r106 + 1;
        int r108 = r105 + 1;
        r102[r105] = (char) ((r103[r104] << 8) | (r103[r106] & UByte.MAX_VALUE));
        if (r107 >= r100) goto L17;
        r104 = r107;
        r105 = r108;
        goto L15
    L17:
        r105 = r108;
        goto L22
    L20:
        throw new EOFException("EOF encountered in middle of BMPString");
    L22:
        if (r110.getRemaining() != 0) goto L26;
        if (r101 != r105) goto L26;
        return r102;
    L26:
        throw new IllegalStateException();
    L28:
        throw new IOException("malformed BMPString encoding encountered");
    }

    private static byte[] getBuffer(DefiniteLengthInputStream r100, byte[][] r101) throws IOException {
        int r102 = r100.getRemaining();
        if (r102 >= r101.length) goto L5;
        byte[] r103 = r101[r102];
        if (r103 != null) goto L9;
        r103 = new byte[r102];
        r101[r102] = r103;
    L9:
        r100.readAllIntoByteArray(r103);
        return r103;
    L5:
        return r100.toByteArray();
    }

    public static int readLength(InputStream r100, int r101, boolean r102) throws IOException {
        int r103 = r100.read();
        if (r103 < 0) goto L32;
        if (r103 != 128) goto L9;
        return -1;
    L9:
        if (r103 <= 127) goto L30;
        int r104 = r103 & 127;
        if (r104 > 4) goto L29;
        int r105 = 0;
        int r106 = 0;
    L13:
        if (r106 >= r104) goto L19;
        int r107 = r100.read();
        if (r107 < 0) goto L18;
        r105 = (r105 << 8) + r107;
        r106 = r106 + 1;
        goto L13
    L18:
        throw new EOFException("EOF found reading length");
    L19:
        if (r105 < 0) goto L27;
        if (r105 < r101) goto L35;
        if (r102 == true) goto L35;
        throw new IOException("corrupted stream - out of bounds length found: " + r105 + " >= " + r101);
    L35:
        return r105;
    L27:
        throw new IOException("corrupted stream - negative length found");
    L29:
        throw new IOException("DER length more than 4 bytes: " + r104);
    L30:
        return r103;
    L32:
        throw new EOFException("EOF found when length expected");
    }

    public static int readTagNumber(InputStream r100, int r101) throws IOException {
        int r102 = r101 & 31;
        if (r102 != 31) goto L17;
        int r103 = r100.read();
        if ((r103 & 127) == 0) goto L16;
        int r104 = 0;
    L7:
        if (r103 < 0) goto L11;
        if ((r103 & 128) == 0) goto L11;
        r104 = ((r103 & 127) | r104) << 7;
        r103 = r100.read();
    L11:
        if (r103 < 0) goto L14;
        return r104 | (r103 & 127);
    L14:
        throw new EOFException("EOF found inside tag value.");
    L16:
        throw new IOException("corrupted stream - invalid high tag number found");
    L17:
        return r102;
    }

    public ASN1Primitive buildObject(int r100, int r101, int r102) throws IOException {
        int r103 = 0;
        if ((r100 & 32) == 0) goto L5;
        boolean r104 = true;
    L6:
        DefiniteLengthInputStream r105 = new DefiniteLengthInputStream(this, r102, this.limit);
        if ((r100 & 64) == 0) goto L11;
        return new DLApplicationSpecific(r104, r101, r105.toByteArray());
    L11:
        if ((r100 & 128) != 0) goto L13;
        if (r104 == false) goto L45;
        if (r101 != 4) goto L18;
        ASN1EncodableVector r106 = readVector(r105);
        int r107 = r106.size();
        ASN1OctetString[] r108 = new ASN1OctetString[r107];
    L36:
        if (r103 == r107) goto L43;
        ASN1Encodable r109 = r106.get(r103);
        if ((r109 instanceof ASN1OctetString) == false) goto L41;
        r108[r103] = (ASN1OctetString) r109;
        r103 = r103 + 1;
        goto L36
    L41:
        throw new ASN1Exception("unknown object encountered in constructed OCTET STRING: " + r109.getClass());
    L43:
        return new BEROctetString(r108);
    L18:
        if (r101 == 8) goto L34;
        if (r101 == 16) goto L28;
        if (r101 != 17) goto L26;
        return DLFactory.createSet(readVector(r105));
    L26:
        throw new IOException("unknown tag " + r101 + " encountered");
    L28:
        if (this.lazyEvaluate == false) goto L32;
        return new LazyEncodedSequence(r105.toByteArray());
    L32:
        return DLFactory.createSequence(readVector(r105));
    L34:
        return new DLExternal(readVector(r105));
    L45:
        return createPrimitiveDERObject(r101, r105, this.tmpBuffers);
    L13:
        return new ASN1StreamParser(r105).readTaggedObject(r104, r101);
    L5:
        r104 = false;
        goto L6
    }

    public int getLimit() {
        return this.limit;
    }

    public void readFully(byte[] r100) throws IOException {
        if (Streams.readFully(this, r100) != r100.length) goto L6;
        return;
    L6:
        throw new EOFException("EOF encountered in middle of object");
    }

    public int readLength() throws IOException {
        return readLength(this, this.limit, false);
    }

    public ASN1Primitive readObject() throws IOException {
        int r100 = read();
        if (r100 > 0) goto L9;
        if (r100 == 0) goto L8;
        return null;
    L8:
        throw new IOException("unexpected end-of-contents marker");
    L9:
        int r101 = readTagNumber(this, r100);
        if ((r100 & 32) == 0) goto L12;
        boolean r102 = true;
    L13:
        int r103 = readLength();
        if (r103 >= 0) goto L49;
        if (r102 == false) goto L43;
        ASN1StreamParser r104 = new ASN1StreamParser(new IndefiniteLengthInputStream(this, this.limit), this.limit);
        if ((r100 & 64) == 0) goto L21;
        return new BERApplicationSpecificParser(r101, r104).getLoadedObject();
    L21:
        if ((r100 & 128) == 0) goto L25;
        return new BERTaggedObjectParser(true, r101, r104).getLoadedObject();
    L25:
        if (r101 == 4) goto L41;
        if (r101 == 8) goto L39;
        if (r101 == 16) goto L37;
        if (r101 != 17) goto L35;
        return new BERSetParser(r104).getLoadedObject();
    L35:
        throw new IOException("unknown BER object encountered");
    L37:
        return new BERSequenceParser(r104).getLoadedObject();
    L39:
        return new DERExternalParser(r104).getLoadedObject();
    L41:
        return new BEROctetStringParser(r104).getLoadedObject();
    L43:
        throw new IOException("indefinite-length primitive encoding encountered");
    L49:
        return buildObject(r100, r101, r103);
    L46:
        e = move-exception;
        throw new ASN1Exception("corrupted stream detected", e);
    L12:
        r102 = false;
        goto L13
    }

    public ASN1EncodableVector readVector(DefiniteLengthInputStream r100) throws IOException {
        if (r100.getRemaining() < 1) goto L5;
        ASN1InputStream r101 = new ASN1InputStream(r100);
        ASN1EncodableVector r102 = new ASN1EncodableVector();
    L7:
        ASN1Primitive r103 = r101.readObject();
        if (r103 == null) goto L10;
        r102.add(r103);
        goto L7
    L10:
        return r102;
    L5:
        return new ASN1EncodableVector(0);
    }
}
