package com.bytedance.locallife.poi.newdetail;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.model.poi.resp.PoiDistanceModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f263262a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f263263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f263264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f263265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f263266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f263267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f263268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f263269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f263270i;

    static {
        f263262a = new h();
    }

    public h() {
    }

    public static int d() {
        int r100 = f263265d;
        if (r100 != 0) goto L6;
        r100 = com.bytedance.locallife.biz.common.utils.e.b();
    L6:
        if (f263267f != 0) goto L9;
        f263267f = (r100 * 212) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
    L9:
        return f263267f;
    }

    public final int a() {
        if (f263270i != 0) goto L6;
        Context r100 = getContext();
        f263270i = ((int) UIUtils.dip2Px(r100, 12.0f)) + g(r100);
    L6:
        return f263270i;
    }

    public final int b() {
        if (f263268g != 0) goto L6;
        j();
    L6:
        return f263268g;
    }

    public final int e() {
        if (f263266e != 0) goto L6;
        f263266e = (int) UIUtils.dip2Px(getContext(), 160.0f);
    L6:
        return f263266e;
    }

    private final Context getContext() {
        ss6.c r100 = HostServiceUtilsKt.E();
        Activity r101 = r100.getCurrentActivity();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return r100.getApplicationContext();
    }

    public final void j() {
        Context r100 = getContext();
        f263268g = ((int) UIUtils.dip2Px(r100, 20.0f)) + g(r100);
        f263269h = (int) (com.bytedance.locallife.biz.common.utils.e.a() * 0.2f);
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r101 = (Activity) r100;
    L6:
        if (r101 == null) goto L9;
        f263269h = (int) ((com.bytedance.locallife.biz.common.utils.e.a() - HostServiceUtilsKt.v().e(r101)) * 0.2f);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static int g(Context r100) {
        return i(r100) + h(r100);
    }

    public static int h(Context r100) {
        if (f263264c != 0) goto L6;
        f263264c = UIUtils.getStatusBarHeight(r100);
    L6:
        return f263264c;
    }

    public static int i(Context r100) {
        if (f263263b != 0) goto L11;
        if (r100 == null) goto L8;
        Resources r101 = r100.getResources();
        if (r101 == null) goto L8;
        int r102 = r101.getDimensionPixelSize(R.dimen.uikit_default_title_bar_height);
    L9:
        f263263b = r102;
    L8:
        r102 = 0;
    L11:
        return f263263b;
    }

    public static int c(PoiDistanceModel r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r102 = (int) UIUtils.dip2Px(r101, Math.abs(r100.getDistance()));
        if (r100.getDistance() >= 0) goto L5;
        r102 = -r102;
    L5:
        int r103 = f263265d;
        if (r103 != 0) goto L9;
        r103 = com.bytedance.locallife.biz.common.utils.e.b();
    L9:
        return (((((int) (h(r101) * r100.getStatusBar())) + ((int) (i(r101) * r100.getNaviBar()))) + ((int) (com.bytedance.locallife.biz.common.utils.e.a() * r100.getScreenHeight()))) + ((int) (r103 * r100.getScreenWidth()))) + r102;
    }

    public static int f(Integer r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "mobParam");
        if (r100 != null) goto L5;
        return r101;
    L5:
        if (r100.intValue() > 0) goto L7;
        return r101;
    L7:
        if ((r101 + 50) <= r100.intValue()) goto L12;
        int r103 = r100.intValue() - 50;
        int r104 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r105 = new mq6.c();
        mq6.a r106 = mq6.c.a.f514894a;
        r105.g("interact_fault", r102);
        com.bytedance.locallife.biz.mob.a.C3646a.c("poi_light_page_landing_error", r105.f514893a);
        return r103;
    L12:
        return r101;
    }
}
