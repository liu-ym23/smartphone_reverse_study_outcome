package com.bytedance.gkfs.io;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f245212a = 0;

    static {
    }

    public static Pair a(PolarisFileInputStreamWrapper r110, com.bytedance.gkfs.c r111) throws IOException {
        byte[] r100 = new byte[15];
        int r101 = r110.read(r100);
        if (r101 < 15) goto L31;
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100);
        char[] r103 = q.f245249a;
        int r104 = 0;
    L6:
        if (r104 >= 4) goto L12;
        char r105 = r103[r104];
        char r106 = (char) r102.read();
        if (r106 != r105) goto L11;
        r104 = r104 + 1;
        goto L6
    L11:
        throw new IOException("Read unexpected magic number value " + r106 + " in index " + r104 + ", " + r105 + " is correct!");
    L12:
        int r107 = r102.read();
        if (r107 < 1) goto L29;
        long r108 = ULong.m9623constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) UByte.m9467constructorimpl((byte) r102.read())) & 255) << 56) + ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) UByte.m9467constructorimpl((byte) r102.read())) & 255) << 48)) + ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) UByte.m9467constructorimpl((byte) r102.read())) & 255) << 40)) + ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) UByte.m9467constructorimpl((byte) r102.read())) & 255) << 32)) + ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) UByte.m9467constructorimpl((byte) r102.read())) & 255) << 24)) + ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) UByte.m9467constructorimpl((byte) r102.read())) & 255) << 16)) + ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) UByte.m9467constructorimpl((byte) r102.read())) & 255) << 8)) + ULong.m9623constructorimpl(255 & ((long) UByte.m9467constructorimpl((byte) r102.read()))));
        if (r108 <= 0) goto L27;
        int r109 = UShort.m9730constructorimpl((short) UInt.m9544constructorimpl(UInt.m9544constructorimpl(UInt.m9544constructorimpl(UByte.m9467constructorimpl((byte) r102.read()) & UByte.MAX_VALUE) << 8) + UInt.m9544constructorimpl(UByte.m9467constructorimpl((byte) r102.read()) & UByte.MAX_VALUE))) & 65535;
        if (r109 <= 0) goto L25;
        int r112 = r109 * 44;
        byte[] r113 = new byte[r112];
        int r114 = r110.read(r113);
        if (r114 < r112) goto L23;
        return TuplesKt.to(new m(r107, r108, r112 + 15), new g(r113, r109, r111));
    L23:
        throw new IOException("read chunks info failed, except " + r112 + " but received " + r114);
    L25:
        throw new IOException("Invalid chunk count " + r109 + '!');
    L27:
        throw new IOException("origin size from header is " + r108 + '!');
    L29:
        throw new IOException("Minimum version of SDK be able to support is 1, but file version is " + r107);
    L31:
        throw new IOException("read header meta failed, except  15 but received " + r101);
    }
}
