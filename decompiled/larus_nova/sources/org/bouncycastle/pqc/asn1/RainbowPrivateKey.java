package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.crypto.rainbow.Layer;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowPrivateKey extends ASN1Object {

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private byte[] f525512b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private byte[] f525513b2;
    private byte[][] invA1;
    private byte[][] invA2;
    private Layer[] layers;
    private ASN1ObjectIdentifier oid;
    private ASN1Integer version;

    /* JADX INFO: renamed from: vi, reason: collision with root package name */
    private byte[] f525514vi;

    private RainbowPrivateKey(ASN1Sequence r110) {
        int r100 = 0;
        if ((r110.getObjectAt(0) instanceof ASN1Integer) == false) goto L5;
        this.version = ASN1Integer.getInstance(r110.getObjectAt(0));
    L6:
        ASN1Sequence r101 = (ASN1Sequence) r110.getObjectAt(1);
        this.invA1 = new byte[r101.size()][];
        int r102 = 0;
    L8:
        if (r102 >= r101.size()) goto L10;
        this.invA1[r102] = ((ASN1OctetString) r101.getObjectAt(r102)).getOctets();
        r102 = r102 + 1;
        goto L8
    L10:
        this.f525512b1 = ((ASN1OctetString) ((ASN1Sequence) r110.getObjectAt(2)).getObjectAt(0)).getOctets();
        ASN1Sequence r103 = (ASN1Sequence) r110.getObjectAt(3);
        this.invA2 = new byte[r103.size()][];
        int r104 = 0;
    L12:
        if (r104 >= r103.size()) goto L14;
        this.invA2[r104] = ((ASN1OctetString) r103.getObjectAt(r104)).getOctets();
        r104 = r104 + 1;
        goto L12
    L14:
        this.f525513b2 = ((ASN1OctetString) ((ASN1Sequence) r110.getObjectAt(4)).getObjectAt(0)).getOctets();
        this.f525514vi = ((ASN1OctetString) ((ASN1Sequence) r110.getObjectAt(5)).getObjectAt(0)).getOctets();
        ASN1Sequence r105 = (ASN1Sequence) r110.getObjectAt(6);
        byte[][][][] r106 = new byte[r105.size()][][][];
        byte[][][][] r107 = new byte[r105.size()][][][];
        byte[][][] r108 = new byte[r105.size()][][];
        byte[][] r109 = new byte[r105.size()][];
        int r111 = 0;
    L16:
        if (r111 >= r105.size()) goto L38;
        ASN1Sequence r112 = (ASN1Sequence) r105.getObjectAt(r111);
        ASN1Sequence r113 = (ASN1Sequence) r112.getObjectAt(r100);
        r106[r111] = new byte[r113.size()][][];
        int r114 = 0;
    L19:
        if (r114 >= r113.size()) goto L25;
        ASN1Sequence r115 = (ASN1Sequence) r113.getObjectAt(r114);
        r106[r111][r114] = new byte[r115.size()][];
        int r116 = 0;
    L22:
        if (r116 >= r115.size()) goto L24;
        r106[r111][r114][r116] = ((ASN1OctetString) r115.getObjectAt(r116)).getOctets();
        r116 = r116 + 1;
        goto L22
    L24:
        r114 = r114 + 1;
        goto L19
    L25:
        ASN1Sequence r117 = (ASN1Sequence) r112.getObjectAt(1);
        r107[r111] = new byte[r117.size()][][];
        int r118 = 0;
    L27:
        if (r118 >= r117.size()) goto L33;
        ASN1Sequence r119 = (ASN1Sequence) r117.getObjectAt(r118);
        r107[r111][r118] = new byte[r119.size()][];
        int r120 = 0;
    L30:
        if (r120 >= r119.size()) goto L32;
        r107[r111][r118][r120] = ((ASN1OctetString) r119.getObjectAt(r120)).getOctets();
        r120 = r120 + 1;
        goto L30
    L32:
        r118 = r118 + 1;
        goto L27
    L33:
        ASN1Sequence r121 = (ASN1Sequence) r112.getObjectAt(2);
        r108[r111] = new byte[r121.size()][];
        int r122 = 0;
    L35:
        if (r122 >= r121.size()) goto L37;
        r108[r111][r122] = ((ASN1OctetString) r121.getObjectAt(r122)).getOctets();
        r122 = r122 + 1;
        goto L35
    L37:
        r109[r111] = ((ASN1OctetString) r112.getObjectAt(3)).getOctets();
        r111 = r111 + 1;
        r100 = 0;
        goto L16
    L38:
        int r123 = this.f525514vi.length - 1;
        this.layers = new Layer[r123];
        int r124 = 0;
    L39:
        if (r124 >= r123) goto L41;
        byte[] r125 = this.f525514vi;
        int r126 = r124 + 1;
        Layer r127 = new Layer(r125[r124], r125[r126], RainbowUtil.convertArray(r106[r124]), RainbowUtil.convertArray(r107[r124]), RainbowUtil.convertArray(r108[r124]), RainbowUtil.convertArray(r109[r124]));
        this.layers[r124] = r127;
        r124 = r126;
        goto L39
    L41:
        return;
    L5:
        this.oid = ASN1ObjectIdentifier.getInstance(r110.getObjectAt(0));
        goto L6
    }

    public RainbowPrivateKey(short[][] r100, short[] r101, short[][] r102, short[] r103, int[] r104, Layer[] r105) {
        this.version = new ASN1Integer(1);
        this.invA1 = RainbowUtil.convertArray(r100);
        this.f525512b1 = RainbowUtil.convertArray(r101);
        this.invA2 = RainbowUtil.convertArray(r102);
        this.f525513b2 = RainbowUtil.convertArray(r103);
        this.f525514vi = RainbowUtil.convertIntArray(r104);
        this.layers = r105;
    }

    public static RainbowPrivateKey getInstance(Object r100) {
        if ((r100 instanceof RainbowPrivateKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RainbowPrivateKey(ASN1Sequence.getInstance(r100));
    L5:
        return (RainbowPrivateKey) r100;
    }

    public short[] getB1() {
        return RainbowUtil.convertArray(this.f525512b1);
    }

    public short[] getB2() {
        return RainbowUtil.convertArray(this.f525513b2);
    }

    public short[][] getInvA1() {
        return RainbowUtil.convertArray(this.invA1);
    }

    public short[][] getInvA2() {
        return RainbowUtil.convertArray(this.invA2);
    }

    public Layer[] getLayers() {
        return this.layers;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public int[] getVi() {
        return RainbowUtil.convertArraytoInt(this.f525514vi);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        ASN1Encodable r101 = this.version;
        if (r101 != null) goto L6;
        r101 = this.oid;
    L6:
        r100.add(r101);
        ASN1EncodableVector r102 = new ASN1EncodableVector();
        int r103 = 0;
    L7:
        byte[][] r104 = this.invA1;
        if (r103 >= r104.length) goto L10;
        r102.add(new DEROctetString(r104[r103]));
        r103 = r103 + 1;
        goto L7
    L10:
        r100.add(new DERSequence(r102));
        ASN1EncodableVector r105 = new ASN1EncodableVector();
        r105.add(new DEROctetString(this.f525512b1));
        r100.add(new DERSequence(r105));
        ASN1EncodableVector r106 = new ASN1EncodableVector();
        int r107 = 0;
    L11:
        byte[][] r108 = this.invA2;
        if (r107 >= r108.length) goto L14;
        r106.add(new DEROctetString(r108[r107]));
        r107 = r107 + 1;
        goto L11
    L14:
        r100.add(new DERSequence(r106));
        ASN1EncodableVector r109 = new ASN1EncodableVector();
        r109.add(new DEROctetString(this.f525513b2));
        r100.add(new DERSequence(r109));
        ASN1EncodableVector r110 = new ASN1EncodableVector();
        r110.add(new DEROctetString(this.f525514vi));
        r100.add(new DERSequence(r110));
        ASN1EncodableVector r111 = new ASN1EncodableVector();
        int r112 = 0;
    L16:
        if (r112 >= this.layers.length) goto L38;
        ASN1EncodableVector r113 = new ASN1EncodableVector();
        byte[][][] r114 = RainbowUtil.convertArray(this.layers[r112].getCoeffAlpha());
        ASN1EncodableVector r115 = new ASN1EncodableVector();
        int r116 = 0;
    L19:
        if (r116 >= r114.length) goto L25;
        ASN1EncodableVector r117 = new ASN1EncodableVector();
        int r118 = 0;
    L21:
        byte[][] r119 = r114[r116];
        if (r118 >= r119.length) goto L24;
        r117.add(new DEROctetString(r119[r118]));
        r118 = r118 + 1;
        goto L21
    L24:
        r115.add(new DERSequence(r117));
        r116 = r116 + 1;
        goto L19
    L25:
        r113.add(new DERSequence(r115));
        byte[][][] r120 = RainbowUtil.convertArray(this.layers[r112].getCoeffBeta());
        ASN1EncodableVector r121 = new ASN1EncodableVector();
        int r122 = 0;
    L27:
        if (r122 >= r120.length) goto L33;
        ASN1EncodableVector r123 = new ASN1EncodableVector();
        int r124 = 0;
    L29:
        byte[][] r125 = r120[r122];
        if (r124 >= r125.length) goto L32;
        r123.add(new DEROctetString(r125[r124]));
        r124 = r124 + 1;
        goto L29
    L32:
        r121.add(new DERSequence(r123));
        r122 = r122 + 1;
        goto L27
    L33:
        r113.add(new DERSequence(r121));
        byte[][] r126 = RainbowUtil.convertArray(this.layers[r112].getCoeffGamma());
        ASN1EncodableVector r127 = new ASN1EncodableVector();
        int r128 = 0;
    L35:
        if (r128 >= r126.length) goto L37;
        r127.add(new DEROctetString(r126[r128]));
        r128 = r128 + 1;
        goto L35
    L37:
        r113.add(new DERSequence(r127));
        r113.add(new DEROctetString(RainbowUtil.convertArray(this.layers[r112].getCoeffEta())));
        r111.add(new DERSequence(r113));
        r112 = r112 + 1;
        goto L16
    L38:
        r100.add(new DERSequence(r111));
        return new DERSequence(r100);
    }
}
