package com.ss.android.lark.base.embedded;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import com.ss.android.lark.utils.CarUtils;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f409756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f409757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f409758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap<Object, Integer> f409759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f409760e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f409761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f409762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f409763c;

        public b() {
            this(false, false, false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f409761a == r101.f409761a) goto L12;
            return false;
        L12:
            if (this.f409762b == r101.f409762b) goto L15;
            return false;
        L15:
            if (this.f409763c == r101.f409763c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f409761a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f409762b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f409763c == true) goto L15;
            r100 = 1237;
        L15:
            return r104 + r100;
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "ForsetiParams(optimizeHuaweiPadFullScreen=" + this.f409761a + ", isHuaweiPad=" + this.f409762b + ", isHuaweiTripleFold=" + this.f409763c + ')';
        }

        public b(boolean r100, boolean r101, boolean r102) {
            this.f409761a = r100;
            this.f409762b = r101;
            this.f409763c = r102;
        }
    }

    static {
    }

    public final void a(int r100) {
        if (CarUtils.c() == false) goto L5;
        return;
    L5:
        this.f409760e = true;
        this.f409756a.setRequestedOrientation(r100);     // Catch: Throwable -> L9
        this.f409760e = false;
        return;
    L9:
        th = move-exception;
        this.f409760e = false;
        throw th;
    }

    public final void b(Configuration r100) {
        if (CarUtils.c() == false) goto L6;
        return;
    L6:
        if (this.f409757b.f409761a == false) goto L10;
        hac.b.f484427a.b("ScreenOrientationEvaluator", "setOrientationAccordingToConfiguration returns for optimizeHuaweiPadFullScreen");
        return;
    L10:
        if (this.f409756a.isTaskRoot() == true) goto L12;
        return;
    L12:
        ActivityInfo r101 = this.f409756a.getPackageManager().getActivityInfo(this.f409756a.getComponentName(), 128);
        if (Intrinsics.areEqual(this.f409756a.getPackageName(), r101.taskAffinity) == true) goto L15;
        return;
    L15:
        int r102 = this.f409756a.getRequestedOrientation();
        if (this.f409759d.values().contains(Integer.valueOf(r102)) == false) goto L18;
        return;
    L18:
        int r103 = 3;
        if (r101.screenOrientation != 3) goto L35;
        int r104 = r100.smallestScreenWidthDp;
        if (r104 < 600) goto L24;
    L32:
        if (r102 == r103) goto L36;
        hac.b.f484427a.b("ScreenOrientationEvaluator", "onConfigurationChanged: currentActivityRequestedOrientation " + r102 + ", requestedOrientation " + r103);
        a(r103);
        return;
    L36:
        return;
    L24:
        if (r104 > 320) goto L27;
    L31:
        r103 = 1;
        goto L32
    L27:
        if (Build.VERSION.SDK_INT <= 30) goto L31;
        LKSplitController r105 = LKSplitController.f409739b;
        if (LKSplitController.a.a().e() == true) goto L32;
    }

    public g(Activity r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "forsetiParams");
        this.f409756a = r100;
        this.f409757b = r101;
        this.f409758c = -1;
        this.f409759d = new WeakHashMap();
    }
}
