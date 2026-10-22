package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f210485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.core.d f210486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f210487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f210488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f210489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OfficeBaseMainStatusBarMode f210490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f210491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f210492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f210493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f210494j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f210495k;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f210496a = null;

        static {
            int[] r100 = new int[OfficeBaseMainStatusBarMode.values().length];
            r100[OfficeBaseMainStatusBarMode.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[OfficeBaseMainStatusBarMode.KEEP_TRANSPARENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[OfficeBaseMainStatusBarMode.FULLSCREEN_TRANSPARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[OfficeBaseMainStatusBarMode.DASHBOARD_FULLSCREEN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f210496a = r100;
        }
    }

    static {
    }

    public final void b(boolean r100) {
        if (this.f210489e == true) goto L5;
        return;
    L5:
        OfficeBaseMainStatusBarMode r101 = this.f210490f;
        int[] r102 = b.f210496a;
        int r103 = r102[r101.ordinal()];
        if (r103 == 1) goto L13;
        if (r103 == 2) goto L13;
        if (r103 == 3) goto L13;
        if (r103 != 4) goto L12;
        int r104 = ContextCompat.getColor(this.f210485a, R.color.bg_body);
    L14:
        int r105 = r102[this.f210490f.ordinal()];
        if (r105 == 1) goto L23;
        if (r105 == 2) goto L22;
        if (r105 == 3) goto L22;
        if (r105 == 4) goto L22;
        throw new NoWhenBranchMatchedException();
    L22:
        int r106 = 0;
    L28:
        if (r100 == true) goto L35;
        Integer r107 = this.f210495k;
        if (r107 == null) goto L35;
        if (r107.intValue() != r106) goto L35;
    L38:
        a(r104, false, r100);
        return;
    L35:
        this.f210495k = Integer.valueOf(r106);
        View r108 = this.f210487c;
        if (r108 == null) goto L38;
        r108.setBackgroundColor(r106);
        goto L38
    L23:
        int r109 = this.f210488d;
        if (this.f210492h == false) goto L26;
        float r110 = 0.0f;
    L27:
        r106 = com.bytedance.ee.bear.bitable.m.l(r109, r110);
        goto L28
    L26:
        r110 = this.f210491g;
        goto L27
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        r104 = 0;
        goto L14
    }

    public s(Context r100, com.bytedance.ee.bear.bitable.core.d r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "statusBarAbility");
        this.f210485a = r100;
        this.f210486b = r101;
        this.f210487c = r102;
        this.f210488d = ContextCompat.getColor(r100, R.color.transparent_50);
        this.f210490f = OfficeBaseMainStatusBarMode.DEFAULT;
    }

    public final void a(int r100, boolean r101, boolean r102) {
        if (r102 == true) goto L11;
        Integer r103 = this.f210493i;
        if (r103 == null) goto L11;
        if (r103.intValue() != r100) goto L11;
        if (Intrinsics.areEqual(this.f210494j, Boolean.TRUE) == false) goto L11;
        return;
    L11:
        this.f210493i = Integer.valueOf(r100);
        this.f210494j = Boolean.TRUE;
        tt5.a.h("OfficeBaseMainStatusBarController", "applyStatusBar color:" + r100 + ", consumeStatusBar:true, saveStateEnable:" + r101);
        this.f210486b.l8(Integer.valueOf(r100), r101);
    }
}
