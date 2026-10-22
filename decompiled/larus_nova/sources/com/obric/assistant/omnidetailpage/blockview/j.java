package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.q3;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
public final class j extends RecyclerView.ViewHolder implements com.obric.assistant.omnidetailpage.localmedia.y {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f390632q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f390633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.assistant.omnidetailpage.localmedia.w f390634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f390635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f390636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f390637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VideoPlayView f390638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SimpleDraweeView f390639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f390640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f390641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ifa.c f390642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ifa.c.b f390643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IVideoController f390644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Job f390645m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f390646n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f390647o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f390648p;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.omnidetailpage.localmedia.y
    public final void R3() {
        if (this.f390643k == null) goto L5;
        this.f390639g.setVisibility(0);
    L5:
        VideoPlayView.z(this.f390638f, 0, 2);
        this.f390646n = false;
    }

    public final void T3() {
        IVideoController r100 = this.f390644l;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        IVideoController r102 = null;
        IVideoController r103 = q3.b("OmniDetailLocalVideo", null, 6);
        if (r103 == null) goto L13;
        com.larus.video.impl.sdk.o r104 = (com.larus.video.impl.sdk.o) r103;
        r104.I(true);
        r104.C(true);
        r102 = r103;
    L13:
        this.f390644l = r102;
        return;
    L5:
        if (r100.isReleased() == true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.obric.assistant.omnidetailpage.localmedia.y
    public final void i3() {
        Job r100 = this.f390645m;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f390645m = null;
        this.f390638f.N();
        this.f390638f.setVideoEngineCallback(null);
        IVideoController r101 = this.f390644l;
        if (r101 != null) goto L14;
    L12:
        this.f390644l = null;
        this.f390643k = null;
        this.f390642j = null;
        this.f390646n = false;
        this.f390647o = false;
        this.f390648p = false;
        this.f390639g.setVisibility(0);
        return;
    L14:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        r101.stop();     // Catch: Throwable -> L9
        r101.release();     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Result.m9448boximpl(r103);
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.obric.assistant.omnidetailpage.localmedia.y
    public final void r0() {
        if (this.f390643k != null) goto L5;
        return;
    L5:
        T3();
        this.f390638f.setIsMuted(true);
        if (this.f390643k == null) goto L9;
        this.f390639g.setVisibility(0);
    L9:
        if (this.f390647o == false) goto L19;
        IVideoController r100 = this.f390644l;
        if (r100 == null) goto L13;
        IVideoController.PlayType r101 = r100.d();
    L15:
        if (r101 != IVideoController.PlayType.PAUSE) goto L19;
        VideoPlayView.H(this.f390638f, 0, 2);
        if (this.f390648p == false) goto L21;
        this.f390639g.post(new d(this));
        return;
    L21:
        return;
    L13:
        r101 = null;
    L19:
        this.f390638f.M();
    }

    @Override // com.obric.assistant.omnidetailpage.localmedia.y
    public final View H0() {
        return this.itemView;
    }

    public static void U3(ImageView r100, String r101) {
        int r102 = r100.getContext().getResources().getIdentifier(r101, "drawable", r100.getContext().getPackageName());
        if (r102 == 0) goto L5;
        r100.setImageResource(r102);
        return;
    L5:
        int r103 = ColorProtector.parseColor("#99000000");
        float r104 = i5.h();
        GradientDrawable r105 = new GradientDrawable();
        r105.setColor(r103);
        r105.setCornerRadius(r104);
        r100.setBackground(r105);
    }

    public j(Context r100, com.obric.assistant.omnidetailpage.localmedia.w r101, Object r102, CoroutineScope r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "autoPlayManager");
        Intrinsics.checkNotNullParameter(r102, "owner");
        Intrinsics.checkNotNullParameter(r103, "scope");
        FrameLayout r104 = new FrameLayout(r100);
        r104.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        int r105 = ColorProtector.parseColor("#F5F6F7");
        float r106 = i5.r0();
        GradientDrawable r107 = new GradientDrawable();
        r107.setColor(r105);
        r107.setCornerRadius(r106);
        r104.setBackground(r107);
        r104.setClipToOutline(true);
        super(r104);
        this.f390633a = r100;
        this.f390634b = r101;
        this.f390635c = r102;
        this.f390636d = r103;
        SimpleDraweeView r108 = new SimpleDraweeView(r100);
        r108.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        this.f390637e = r108;
        VideoPlayView r109 = new VideoPlayView(r100, null, 6, 0);
        r109.setIsMuted(true);
        r109.setShowCoverWhenPause(false);
        r109.setBanInnerDismiss(true);
        r109.setIgnoreClick(true);
        r109.setEnableCreationPreviewCoverLoadOpt(true);
        r109.setForceRefreshSurface(true);
        this.f390638f = r109;
        SimpleDraweeView r110 = new SimpleDraweeView(r100);
        ((GenericDraweeHierarchy) r110.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        int r111 = ColorProtector.parseColor("#F5F6F7");
        float r112 = i5.r0();
        GradientDrawable r113 = new GradientDrawable();
        r113.setColor(r111);
        r113.setCornerRadius(r112);
        r110.setBackground(r113);
        this.f390639g = r110;
        ImageView r114 = new ImageView(r100);
        r114.setScaleType(ImageView.ScaleType.CENTER);
        U3(r114, "larus_action_button_icon");
        this.f390640h = r114;
        ImageView r115 = new ImageView(r100);
        U3(r115, "larus_ic_download_white_shadow");
        int r116 = r115.getContext().getResources().getIdentifier("larus_bg_gray_btn_radius_8", "drawable", r115.getContext().getPackageName());
        if (r116 == 0) goto L5;
        r115.setBackgroundResource(r116);
    L6:
        this.f390641i = r115;
        View r117 = this.itemView;
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r118 = (FrameLayout) r117;
        r118.addView(r108, new FrameLayout.LayoutParams(-1, -1));
        r118.addView(r109, new FrameLayout.LayoutParams(-1, -1));
        r118.addView(r110, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams r119 = new FrameLayout.LayoutParams(i5.O(), i5.O(), 8388661);
        r119.topMargin = i5.h();
        r119.setMarginEnd(i5.h());
        Unit r120 = Unit.INSTANCE;
        r118.addView(r114, r119);
        FrameLayout.LayoutParams r121 = new FrameLayout.LayoutParams(i5.O(), i5.O(), 8388691);
        r121.leftMargin = i5.r0();
        r121.bottomMargin = i5.r0();
        r118.addView(r115, r121);
        r114.setOnClickListener(new e(this));
        r115.setOnClickListener(new f(this));
        r109.setOnClickListener(new g(this));
        return;
    L5:
        int r122 = ColorProtector.parseColor("#99000000");
        float r123 = i5.r0();
        GradientDrawable r124 = new GradientDrawable();
        r124.setColor(r122);
        r124.setCornerRadius(r123);
        r115.setBackground(r124);
        goto L6
    }
}
