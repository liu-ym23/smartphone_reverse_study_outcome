package com.bytedance.pia.core.utils;

import android.util.Log;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.ss.android.agilelogger.ALog;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f266396a = 0;

    static {
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        f(r100, null, null, 14);
    }

    @JvmStatic
    public static final void d(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        f(r100, r101, null, 12);
    }

    @JvmStatic
    public static final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        l(r100, null, 14);
    }

    @JvmStatic
    public static final void j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        l(r100, r101, 12);
    }

    @JvmStatic
    public static final void n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        p(r100, null, null, 14);
    }

    @JvmStatic
    public static final String h() {
        StringBuilder r100 = new StringBuilder("02");
        r100.append(System.currentTimeMillis());
        r100.append("ffffffffffffffffffffffffffffffff");
        char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', OthersPermission.STICKY, Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO};
        char[] r102 = new char[6];
        ThreadLocalRandom r103 = ThreadLocalRandom.current();
        int r104 = 0;
    L3:
        if (r104 >= 6) goto L5;
        r102[r104] = r101[r103.nextInt(36)];
        r104 = r104 + 1;
        goto L3
    L5:
        r100.append(new String(r102));
        return r100.toString();
    }

    public static String g(String r100, String r101) {
        boolean r102 = false;
        if (StringsKt.startsWith$default(r100, "[PIA]", false, 2, null) == false) goto L5;
        return r100;
    L5:
        if (r101 != null) goto L7;
    L8:
        r102 = true;
    L9:
        if (r102 == false) goto L12;
        return "[PIA] " + r100;
    L12:
        return "[PIA][" + r101 + "] " + r100;
    L7:
        if (r101.length() != 0) goto L9;
        goto L8
    }

    public static /* synthetic */ void b(String r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 8) == 0) goto L8;
        String r103 = "PiaCore";
    L9:
        a(r100, r101, null, r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public static /* synthetic */ void l(String r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 8) == 0) goto L8;
        String r103 = "PiaCore";
    L9:
        k(r100, r101, null, r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    @JvmStatic
    public static final void a(String r100, String r101, Throwable r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r103, "tag");
        ALog.d(r103, g(r100, r101) + Log.getStackTraceString(r102));
    }

    @JvmStatic
    public static final void e(String r100, Throwable r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r103, "tag");
        ALog.e(r103, g(r100, r102) + Log.getStackTraceString(r101));
    }

    public static /* synthetic */ void f(String r100, Throwable r101, String r102, int r103) {
        String r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r104 = "PiaCore";
    L11:
        e(r100, r101, r102, r104);
    }

    @JvmStatic
    public static final void k(String r100, String r101, Throwable r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r103, "tag");
        String r104 = g(r100, r101);
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.m(r103, r104 + Log.getStackTraceString(r102), null, null, 12);
    }

    @JvmStatic
    public static final void m(String r100, String r101, Throwable r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r103, "tag");
        ALog.v(r103, g(r100, r101) + Log.getStackTraceString(r102));
    }

    @JvmStatic
    public static final void o(String r100, String r101, Throwable r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r103, "tag");
        ALog.w(r103, g(r100, r101) + Log.getStackTraceString(r102));
    }

    public static /* synthetic */ void p(String r100, String r101, Throwable r102, int r103) {
        String r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r104 = "PiaCore";
    L11:
        o(r100, r101, r102, r104);
    }
}
