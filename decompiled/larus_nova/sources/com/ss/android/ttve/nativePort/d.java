package com.ss.android.ttve.nativePort;

import com.ss.android.vesdk.VELogUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes38.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f449974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f449975b;

    public final boolean a() {
        if ((this.f449975b + 4) <= this.f449974a.length) goto L7;
        VELogUtil.e("TEParcel", "out of border");
        return false;
    L7:
        if (c() == 0) goto L10;
        return true;
    L10:
        return false;
    }

    public final float b() {
        if ((this.f449975b + 4) <= this.f449974a.length) goto L7;
        VELogUtil.e("TEParcel", "out of border");
        return -1.0f;
    L7:
        return Float.intBitsToFloat(c());
    }

    public final int c() {
        int r100 = this.f449975b;
        int r101 = r100 + 4;
        byte[] r102 = this.f449974a;
        if (r101 <= r102.length) goto L6;
        VELogUtil.e("TEParcel", "out of border");
        return -1;
    L6:
        int r103 = (((r102[r100] & UByte.MAX_VALUE) | ((r102[r100 + 1] & UByte.MAX_VALUE) << 8)) | ((r102[r100 + 2] & UByte.MAX_VALUE) << 16)) | ((r102[r100 + 3] & ByteCompanionObject.MAX_VALUE) << 24);
        if ((r102[r100 + 3] >> 7) == 0) goto L10;
        r103 = r103 - Integer.MIN_VALUE;
    L10:
        this.f449975b = r100 + 4;
        return r103;
    }

    public final Long e() {
        int r100 = this.f449975b;
        int r101 = r100 + 8;
        byte[] r102 = this.f449974a;
        if (r101 <= r102.length) goto L6;
        VELogUtil.e("TEParcel", "out of border");
        return null;
    L6:
        ByteBuffer r103 = ByteBuffer.wrap(r102, r100, 8);
        r103.order(ByteOrder.LITTLE_ENDIAN);
        this.f449975b += 8;
        return Long.valueOf(r103.getLong());
    }

    public final String f() {
        int r100 = c();
        return d(r100, r100);
    }

    public d(byte[] r100) {
        this.f449974a = r100;
        this.f449975b = 0;
    }

    public final String g(int r100) {
        return d(c(), r100);
    }

    public final String d(int r100, int r101) {
        int r102 = this.f449975b;
        int r103 = r102 + r101;
        byte[] r104 = this.f449974a;
        if (r103 <= r104.length) goto L6;
        VELogUtil.e("TEParcel", "readString out of bound(data size=" + this.f449974a.length + ", start=" + this.f449975b + ", len=" + r101 + ")");
        return null;
    L6:
        String r105 = new String(r104, r102, r100, Charset.forName("UTF-8"));
        this.f449975b += r101;
        return r105;
    }
}
