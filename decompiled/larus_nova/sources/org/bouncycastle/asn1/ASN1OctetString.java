package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1OctetString extends ASN1Primitive implements ASN1OctetStringParser {
    byte[] string;

    public ASN1OctetString(byte[] r100) {
        if (r100 == null) goto L7;
        this.string = r100;
        return;
    L7:
        throw new NullPointerException("'string' cannot be null");
    }

    public static ASN1OctetString getInstance(Object r100) {
        if (r100 == null) goto L22;
        if ((r100 instanceof ASN1OctetString) == true) goto L22;
        if ((r100 instanceof byte[]) == false) goto L14;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L10:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e.getMessage());
    L14:
        if ((r100 instanceof ASN1Encodable) == false) goto L20;
        ASN1Primitive r101 = ((ASN1Encodable) r100).toASN1Primitive();
        if ((r101 instanceof ASN1OctetString) == false) goto L20;
        return (ASN1OctetString) r101;
    L20:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L22:
        return (ASN1OctetString) r100;
    }

    public static ASN1OctetString getInstance(ASN1TaggedObject r100, boolean r101) {
        if (r101 == true) goto L4;
        ASN1Primitive r102 = r100.getObject();
        if (r100.isExplicit() == false) goto L18;
        ASN1OctetString r103 = getInstance(r102);
        if ((r100 instanceof BERTaggedObject) == false) goto L16;
        return new BEROctetString(new ASN1OctetString[]{r103});
    L16:
        return (ASN1OctetString) new BEROctetString(new ASN1OctetString[]{r103}).toDLObject();
    L18:
        if ((r102 instanceof ASN1OctetString) == false) goto L25;
        ASN1OctetString r104 = (ASN1OctetString) r102;
        if ((r100 instanceof BERTaggedObject) == false) goto L23;
        return r104;
    L23:
        return (ASN1OctetString) r104.toDLObject();
    L25:
        if ((r102 instanceof ASN1Sequence) == false) goto L33;
        ASN1Sequence r105 = (ASN1Sequence) r102;
        if ((r100 instanceof BERTaggedObject) == false) goto L31;
        return BEROctetString.fromSequence(r105);
    L31:
        return (ASN1OctetString) BEROctetString.fromSequence(r105).toDLObject();
    L33:
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(r100.getClass().getName()));
    L4:
        if (r100.isExplicit() == false) goto L8;
        return getInstance(r100.getObject());
    L8:
        throw new IllegalArgumentException("object implicit - explicit expected.");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1OctetString) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.string, ((ASN1OctetString) r100).string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream r100, boolean r101) throws IOException;

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    @Override // org.bouncycastle.asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.string);
    }

    public byte[] getOctets() {
        return this.string;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(getOctets());
    }

    public ASN1OctetStringParser parser() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DEROctetString(this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DEROctetString(this.string);
    }

    public String toString() {
        return "#" + Strings.fromByteArray(Hex.encode(this.string));
    }
}
