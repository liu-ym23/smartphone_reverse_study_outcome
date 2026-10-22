package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class X9ECPoint extends ASN1Object {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ECCurve f525097c;
    private final ASN1OctetString encoding;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ECPoint f525098p;

    public X9ECPoint(ECCurve r100, ASN1OctetString r101) {
        this(r100, r101.getOctets());
    }

    public X9ECPoint(ECCurve r100, byte[] r101) {
        this.f525097c = r100;
        this.encoding = new DEROctetString(Arrays.clone(r101));
    }

    public X9ECPoint(ECPoint r100, boolean r101) {
        this.f525098p = r100.normalize();
        this.encoding = new DEROctetString(r100.getEncoded(r101));
    }

    public synchronized ECPoint getPoint() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f525098p != null) goto L6;
        this.f525098p = this.f525097c.decodePoint(this.encoding.getOctets()).normalize();     // Catch: Throwable -> L9
    L6:
        ECPoint r100 = this.f525098p;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public byte[] getPointEncoding() {
        return Arrays.clone(this.encoding.getOctets());
    }

    public boolean isPointCompressed() {
        byte[] r100 = this.encoding.getOctets();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length <= 0) goto L13;
        byte r101 = r100[0];
        if (r101 != 2) goto L9;
    L10:
        return true;
    L9:
        if (r101 == 3) goto L10;
        return false;
    L13:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }
}
