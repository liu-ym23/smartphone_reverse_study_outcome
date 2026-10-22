package com.larus.av_call.view;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.databinding.LarusLayoutRealtimeCallTopBinding;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.larus.common_ui.view.NoSpaceTextView;
import com.larus.common_ui.widget.roundlayout.CustomRoundImageView;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJX\u0010$\u001a\u00020%2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001a\u001a\u00020\u0010J\u000e\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0010J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020\u0015J\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u00102\b\b\u0002\u00104\u001a\u00020\u0010J\"\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\u00102\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020%08J\u0006\u00109\u001a\u00020.J\b\u0010:\u001a\u00020%H\u0002J\u0018\u0010;\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H\u0002J\u0010\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\bH\u0016J\u000e\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\u0010J\u000e\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\u0010J\u0006\u0010B\u001a\u00020%J \u0010C\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H\u0002J\u001e\u0010D\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010J\u001e\u0010E\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010J&\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010J\u000e\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020JJ\u0010\u0010M\u001a\u00020%2\u0006\u0010I\u001a\u00020JH\u0002J\u0012\u0010N\u001a\u00020%2\b\b\u0001\u0010O\u001a\u00020\bH\u0002J\b\u0010P\u001a\u00020%H\u0002J\b\u0010Q\u001a\u00020%H\u0014J\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020UJ \u0010V\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H\u0016J\u001a\u0010W\u001a\u00020%*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010X\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0018R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/larus/av_call/view/VoiceCallTopLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/av_call/view/IRealCallDayNight;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "topBinding", "Lcom/larus/av_call/databinding/LarusLayoutRealtimeCallTopBinding;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "forceDarkMode", "", "botName", "", "isShowChooseScene", "realtimeCallSceneButtonCenter", "Landroid/view/View;", "value", "isChooseSceneEnable", "()Z", "isSubtitleOpen", "hideTopActionIcons", "mainHandler", "Landroid/os/Handler;", "forceEnableStatusAnim", "runtimeData", "Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "configDependency", "Lcom/larus/av_call/service/IRealtimeCallConfigDependency;", "shouldHideTopActionIcons", "getShouldHideTopActionIcons", "initView", "", "realtimeCallSceneButton", "enableSubtitle", "hasRecordPermission", "subtitleUseCC", "enableAudioBgSimpleColor", "setMoreBtnVisibility", "visible", "getLeftTakePhotoBtn", "Landroid/widget/ImageView;", "getMoreBtn", "getTitleView", "Landroidx/appcompat/widget/AppCompatTextView;", "setupMoreBtnResource", "isFullVideo", "disable", "setupMoreBtn", "isVisible", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "getSwitchCameraView", "setupTitle", "setupChooseScene", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "switchSceneButtonCallName", "isVideoFullMode", "setChooseSceneEnable", "enable", "hideChooseSceneEnable", "setupSubtitle", "onOpenSubtitle", "onCloseSubtitle", "setupViews", "hasPermission", "onUpdateMajorState", "state", "Lcom/larus/audio/call/mgr/MajorState;", "showThinkingRunnable", "Ljava/lang/Runnable;", "updateImmersBotTitle", "showStatusAnim", "rawRes", "hideStatusAnim", "onDetachedFromWindow", "getSceneButtonTop", "Lcom/larus/av_call/view/SceneModeButton;", "getSubtitleButton", "Lcom/larus/common_ui/widget/roundlayout/CustomRoundImageView;", "refreshThemeDayNight", "setDarkMode", "shouldNotShowNameAndStatus", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallTopLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f290617o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutRealtimeCallTopBinding f290618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThemeType f290619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f290620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f290621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f290622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f290623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f290624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f290625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f290626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f290627j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f290628k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h88.b f290629l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final IRealtimeCallConfigDependency f290630m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d1 f290631n;

    public VoiceCallTopLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VoiceCallTopLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        if (b6(this.f290619b) == false) goto L5;
        return;
    L5:
        this.f290627j.removeCallbacks(this.f290631n);
        com.larus.utils.e1.o(this.f290618a.f290557f);
    }

    public final ImageView getLeftTakePhotoBtn() {
        return this.f290618a.f290559h;
    }

    public final View getMoreBtn() {
        return this.f290618a.f290558g;
    }

    public final SceneModeButton getSceneButtonTop() {
        return this.f290618a.f290555d;
    }

    public final CustomRoundImageView getSubtitleButton() {
        return this.f290618a.f290556e;
    }

    public final ImageView getSwitchCameraView() {
        return this.f290618a.f290560i;
    }

    public final AppCompatTextView getTitleView() {
        return this.f290618a.f290553b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f290627j.removeCallbacks(this.f290631n);
    }

    private final boolean getShouldHideTopActionIcons() {
        return this.f290626i;
    }

    public final void T5(MajorState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        ThemeType r101 = this.f290619b;
        if (r101 == ThemeType.IMMERS_BOT) goto L9;
        if (this.f290628k == true) goto L9;
        R5();
        return;
    L9:
        if (b6(r101) == false) goto L12;
        return;
    L12:
        if ((r100 instanceof MajorState.i) == false) goto L15;
        R5();
        this.f290627j.postDelayed(this.f290631n, 2000);
        return;
    L15:
        if (Intrinsics.areEqual(r100, MajorState.h.f289190c) == false) goto L17;
        c6(R.raw.larus_voice_playing_darkmode);
        return;
    L17:
        R5();
    }

    public final boolean b6(ThemeType r100) {
        if (r100 != ThemeType.MAIN_BOT) goto L13;
        IRealtimeCallConfigDependency r101 = this.f290630m;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r101.m() != true) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }

    public final void c6(int r100) {
        if (b6(this.f290619b) == false) goto L5;
        return;
    L5:
        this.f290627j.removeCallbacks(this.f290631n);
        LottieAdapterView r101 = this.f290618a.f290557f;
        Intrinsics.checkNotNull(r101);
        com.larus.utils.e1.x(r101);
        r101.setAnimation(r100);
        r101.playAnimation();
    }

    public final void i6(boolean r100) {
        this.f290628k = r100;
        if (r100 == true) goto L6;
        R5();
    L6:
        if (this.f290619b == ThemeType.MAIN_BOT) goto L8;
        return;
    L8:
        SceneModeButton r101 = this.f290618a.f290555d;
        boolean r102 = true;
        int r103 = 0;
        if (r100 == false) goto L11;
    L13:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L17;
        int r105 = 0;
    L18:
        r101.setVisibility(r105);
        NoSpaceTextView r106 = this.f290618a.f290553b;
        if (r100 == true) goto L21;
    L23:
        r102 = false;
    L24:
        if (r102 == true) goto L27;
        r103 = 8;
    L27:
        r106.setVisibility(r103);
        return;
    L21:
        if (b6(this.f290619b) == true) goto L23;
    L17:
        r105 = 8;
        goto L18
    L11:
        if (this.f290622e == false) goto L13;
        r104 = true;
        goto L15
    }

    public final void setChooseSceneEnable(boolean r100) {
        if (this.f290624g != r100) goto L5;
        return;
    L5:
        SceneModeButton r101 = this.f290618a.f290555d;
        float r102 = 1.0f;
        if (r100 == false) goto L8;
        float r103 = 1.0f;
    L9:
        r101.setAlpha(r103);
        View r104 = this.f290623f;
        if (r104 == null) goto L15;
        if (r100 == true) goto L14;
        r102 = 0.6f;
    L14:
        r104.setAlpha(r102);
    L15:
        this.f290624g = r100;
        return;
    L8:
        r103 = 0.6f;
        goto L9
    }

    public final void setMoreBtnVisibility(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        com.larus.utils.e1.o(this.f290618a.f290558g);
        return;
    L4:
        if (getShouldHideTopActionIcons() == true) goto L6;
        com.larus.utils.e1.x(this.f290618a.f290558g);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
    }

    public static void Y5(VoiceCallTopLayout r100, boolean r101) {
        r100.getClass();
        Application r102 = i88.e.f488685a;
        AppCompatImageView r103 = r100.f290618a.f290558g;
        ThemeType r104 = r100.f290619b;
        boolean r105 = r100.f290620c;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r104, "themeType");
        IRealtimeCallConfigDependency r106 = i88.e.f488686b;
        if (r106 == null) goto L7;
        boolean r107 = true;
        if (r106.m() != true) goto L7;
    L8:
        if (r107 == false) goto L15;
        if (r105 == false) goto L11;
    L14:
        int r108 = R.drawable.larus_ic_call_setting_dark;
    L23:
        r103.setImageResource(r108);
        return;
    L11:
        if (i88.e.o(r104) == true) goto L14;
        r108 = R.drawable.larus_ic_call_setting_light;
        goto L23
    L15:
        if (r101 == false) goto L17;
        r108 = R.drawable.larus_ic_bot_setting_full;
        goto L23
    L17:
        if (r105 == false) goto L19;
    L22:
        r108 = R.drawable.larus_ic_bot_setting_dark;
        goto L23
    L19:
        if (i88.e.o(r104) == true) goto L22;
        r108 = R.drawable.larus_ic_bot_setting_light;
    L7:
        r107 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.av_call.view.d1] */
    public VoiceCallTopLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f290619b = ThemeType.DEFAULT;
        this.f290621d = "";
        boolean r103 = true;
        this.f290624g = true;
        this.f290627j = new Handler(Looper.getMainLooper());
        IRealtimeCallConfigDependency r104 = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        this.f290630m = r104;
        if (r104 != null) goto L5;
    L7:
        r103 = false;
    L8:
        if (r103 == false) goto L10;
        LarusLayoutRealtimeCallTopBinding r105 = LarusLayoutRealtimeCallTopBinding.a(LayoutInflater.from(r100).inflate(R.layout.larus_layout_realtime_call_top_new, this));
        Intrinsics.checkNotNull(r105);
    L11:
        this.f290618a = r105;
        this.f290631n = new d1(this);
        return;
    L10:
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_realtime_call_top, this);
        r105 = LarusLayoutRealtimeCallTopBinding.a(this);
        Intrinsics.checkNotNull(r105);
        goto L11
    L5:
        if (r104.m() != true) goto L7;
        goto L7
    }

    public final void U5(boolean r100, boolean r110, boolean r111) {
        this.f290620c = r100;
        Application r112 = i88.e.f488685a;
        CustomRoundImageView r101 = this.f290618a.f290556e;
        ThemeType r102 = this.f290619b;
        boolean r103 = this.f290625h;
        h88.b r113 = this.f290629l;
        boolean r104 = false;
        if (r113 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        i88.e.j(r101, r102, r103, r100, r110, r105);
        V5(this.f290618a, this.f290619b, r100);
        this.f290618a.f290555d.a(r100);
        h88.b r106 = this.f290629l;
        if (r106 != null) goto L11;
    L13:
        Y5(this, r104);
        return;
    L11:
        if (r106.f484277r != true) goto L13;
        r104 = true;
        goto L13
    L5:
        if (r113.f484277r != true) goto L7;
        r105 = true;
        goto L8
    }

    public final void V5(LarusLayoutRealtimeCallTopBinding r100, ThemeType r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "themeType");
        if (b6(r101) == false) goto L5;
        return;
    L5:
        if (r102 == false) goto L7;
    L10:
        r100.f290553b.setTextColor(ContextCompat.getColor(getContext(), R.color.larus_static_white));
        return;
    L7:
        if (i88.e.o(r101) == true) goto L10;
        r100.f290553b.setTextColor(ColorProtector.parseColor("#CC000000"));
    }

    public /* synthetic */ VoiceCallTopLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void Z5(boolean r100, boolean r110, boolean r111, boolean r112) {
        int r113 = 8;
        if (r100 == true) goto L5;
        NoSpaceTextView r101 = this.f290618a.f290553b;
        if ((!b6(this.f290619b)) == false) goto L44;
        r113 = 0;
    L44:
        r101.setVisibility(r113);
        com.larus.utils.e1.o(this.f290618a.f290555d);
        com.larus.utils.e1.o(this.f290618a.f290556e);
        View r102 = this.f290623f;
        if (r102 == null) goto L50;
        com.larus.utils.e1.o(r102);
        return;
    L50:
        return;
    L5:
        if (b6(this.f290619b) == false) goto L7;
        com.larus.utils.e1.o(this.f290618a.f290553b);
        com.larus.utils.e1.o(this.f290618a.f290557f);
    L15:
        if (this.f290622e == false) goto L24;
        SceneModeButton r103 = this.f290618a.f290555d;
        ThemeType r114 = this.f290619b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r114, "themeType");
        r103.f290580b = r114;
        r103.a(false);
        if (this.f290619b != ThemeType.MAIN_BOT) goto L21;
        com.larus.utils.e1.x(this.f290618a.f290555d);
        View r104 = this.f290623f;
        if (r104 == null) goto L30;
        com.larus.utils.e1.o(r104);
    L30:
        if (r110 == true) goto L32;
    L40:
        com.larus.utils.e1.o(this.f290618a.f290556e);
        return;
    L32:
        if (getShouldHideTopActionIcons() == true) goto L40;
        this.f290625h = false;
        com.larus.utils.e1.x(this.f290618a.f290556e);
        Application r105 = i88.e.f488685a;
        CustomRoundImageView r106 = this.f290618a.f290556e;
        ThemeType r107 = this.f290619b;
        boolean r108 = this.f290625h;
        boolean r109 = this.f290620c;
        h88.b r115 = this.f290629l;
        if (r115 != null) goto L36;
    L38:
        boolean r116 = false;
    L39:
        i88.e.j(r106, r107, r108, r109, r111, r116);
        return;
    L36:
        if (r115.f484277r != true) goto L38;
        r116 = true;
        goto L39
    L21:
        com.larus.utils.e1.o(this.f290618a.f290555d);
        View r117 = this.f290623f;
        if (r117 == null) goto L30;
        com.larus.utils.e1.x(r117);
        goto L30
    L24:
        NoSpaceTextView r118 = this.f290618a.f290553b;
        if ((!b6(this.f290619b)) == false) goto L27;
        r113 = 0;
    L27:
        r118.setVisibility(r113);
        com.larus.utils.e1.o(this.f290618a.f290555d);
        View r119 = this.f290623f;
        if (r119 == null) goto L30;
        com.larus.utils.e1.o(r119);
        goto L30
    L7:
        this.f290618a.f290553b.setText(this.f290621d);
        if (this.f290619b != ThemeType.MAIN_BOT) goto L10;
        com.larus.utils.e1.o(this.f290618a.f290553b);
    L11:
        com.larus.utils.e1.o(this.f290618a.f290557f);
        if (this.f290619b != ThemeType.IMMERS_BOT) goto L15;
        this.f290618a.f290553b.setAlpha(0.8f);
        this.f290618a.f290557f.setAlpha(0.8f);
        goto L15
    L10:
        com.larus.utils.e1.x(this.f290618a.f290553b);
        goto L11
    }

    public final void S5(ThemeType r100, String r101, boolean r102, View r103, boolean r104, boolean r105, boolean r106, boolean r107, h88.b r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "themeType");
        Intrinsics.checkNotNullParameter(r101, "botName");
        Intrinsics.checkNotNullParameter(r103, "realtimeCallSceneButton");
        Intrinsics.checkNotNullParameter(r110, "runtimeData");
        this.f290619b = r100;
        this.f290621d = r101;
        this.f290622e = r102;
        this.f290623f = r103;
        this.f290629l = r110;
        this.f290626i = r111;
        V5(this.f290618a, r100, this.f290620c);
        Z5(r105, r104, r106, r107);
    }
}
