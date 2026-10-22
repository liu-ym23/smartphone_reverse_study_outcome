package com.bytedance.salamander.anniex;

import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.anniex.bd.foundation.impl.m f268070d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.anniex.bd.foundation.impl.m f268071e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.anniex.bd.foundation.impl.m f268072f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.anniex.bd.foundation.impl.m f268073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.anniex.bd.foundation.impl.m f268074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.anniex.bd.foundation.impl.m f268075c;

    public static final class a {
        public static g a() {
            g r100 = new g();
            com.bytedance.anniex.bd.foundation.impl.m r101 = g.f268071e;
            if (r101 == null) goto L5;
            r100.f268075c = r101;
        L5:
            com.bytedance.anniex.bd.foundation.impl.m r102 = g.f268070d;
            if (r102 == null) goto L8;
            r100.f268074b = r102;
        L8:
            if (r102 == null) goto L10;
            r100.f268073a = r102;
        L10:
            return r100;
        }

        public static g b() {
            g r100 = new g();
            com.bytedance.anniex.bd.foundation.impl.m r101 = g.f268070d;
            if (r101 == null) goto L5;
            r100.f268075c = r101;
        L5:
            com.bytedance.anniex.bd.foundation.impl.m r102 = g.f268071e;
            if (r102 == null) goto L8;
            r100.f268074b = r102;
        L8:
            if (r102 == null) goto L10;
            r100.f268073a = r102;
        L10:
            return r100;
        }

        public static g c() {
            g r100 = new g();
            com.bytedance.anniex.bd.foundation.impl.m r101 = g.f268072f;
            if (r101 == null) goto L5;
            r100.f268075c = r101;
        L5:
            if (r101 == null) goto L7;
            r100.f268074b = r101;
        L7:
            if (r101 == null) goto L9;
            r100.f268073a = r101;
        L9:
            return r100;
        }
    }

    public g() {
    }

    static {
        f268070d = new com.bytedance.anniex.bd.foundation.impl.m(CustomHeaderConfig.COLOR_LIGHT);
        f268071e = new com.bytedance.anniex.bd.foundation.impl.m("#161823");
        f268072f = new com.bytedance.anniex.bd.foundation.impl.m("#00000000");
    }

    public static long a(g r100) {
        com.bytedance.anniex.bd.foundation.impl.m r101 = r100.b(null);
        r101.getClass();
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        long r103 = ((com.bytedance.rts.foundation.k.d(r102, r101.f190149d) << 24) | (com.bytedance.rts.foundation.k.d(r102, r101.f190146a) << 16)) | (com.bytedance.rts.foundation.k.d(r102, r101.f190147b) << 8);
        return com.bytedance.rts.foundation.k.d(r102, r101.f190148c) | r103;
    }

    public final com.bytedance.anniex.bd.foundation.impl.m b(AnnieXAppTheme r100) {
        if (r100 != null) goto L7;
        r1 r101 = r1.f268341d;
        r1 r102 = r1.f268341d;
        int r103 = s1.f268368a;
        k3 r104 = r102.a("AppThemeService");
        if (r104 == null) goto L7;
        r100 = ((e3) r104).getAppTheme();
    L7:
        if (r100 != AnnieXAppTheme.Light) goto L19;
        com.bytedance.anniex.bd.foundation.impl.m r105 = this.f268074b;
        if (r105 == null) goto L12;
        Intrinsics.checkNotNull(r105);
        return r105;
    L12:
        com.bytedance.anniex.bd.foundation.impl.m r106 = this.f268073a;
        if (r106 == null) goto L17;
        Intrinsics.checkNotNull(r106);
        return r106;
    L17:
        return f268070d;
    L19:
        if (r100 != AnnieXAppTheme.Dark) goto L30;
        com.bytedance.anniex.bd.foundation.impl.m r107 = this.f268075c;
        if (r107 == null) goto L24;
        Intrinsics.checkNotNull(r107);
        return r107;
    L24:
        com.bytedance.anniex.bd.foundation.impl.m r108 = this.f268073a;
        if (r108 == null) goto L29;
        Intrinsics.checkNotNull(r108);
        return r108;
    L29:
        return f268071e;
    L30:
        com.bytedance.anniex.bd.foundation.impl.m r109 = this.f268073a;
        if (r109 == null) goto L33;
        return r109;
    L33:
        return f268070d;
    }
}
