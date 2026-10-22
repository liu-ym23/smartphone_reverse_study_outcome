package com.larus.voicecall.impl.continue_talk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.ChatContinuousAudioVisualizerOpt;
import com.larus.nova.R;
import com.larus.voicecall.impl.databinding.LarusLayoutContinousBottomControllerBinding;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 B2\u00020\u0001:\u0001BB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J*\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0018J\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u0018J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u0018J\u0006\u0010$\u001a\u00020\u0018J\u0010\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u000bJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020\u0018H\u0002J\u0012\u00101\u001a\u00020\u00182\b\b\u0002\u00102\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u0018H\u0002J\u0012\u00106\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u000bH\u0002J\b\u00107\u001a\u00020\u0018H\u0002J\b\u00108\u001a\u00020\u0018H\u0002J\b\u00109\u001a\u00020\u0018H\u0002J\b\u0010:\u001a\u00020\u0018H\u0002J\b\u0010;\u001a\u00020\u0018H\u0002J\b\u0010<\u001a\u00020\u0018H\u0002J\b\u0010=\u001a\u00020\u0018H\u0002J\b\u0010>\u001a\u00020\u0018H\u0002J\u0010\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u000bH\u0002J\b\u0010A\u001a\u00020\u0018H\u0014R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/larus/voicecall/impl/continue_talk/ChatContinuousTalkLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSupportMute", "", "()Z", "isSupportMute$delegate", "Lkotlin/Lazy;", "bottomBinding", "Lcom/larus/voicecall/impl/databinding/LarusLayoutContinousBottomControllerBinding;", "delayShowInterruptBtnJob", "Lkotlinx/coroutines/Job;", "getMuteState", "Lkotlin/Function0;", "getCurrentState", "isImmersiveBackground", "resetFiled", "", "updateTheme", "onConnecting", "onResume", "onListening", "onThinking", "onSpeaking", "onPause", "onWaiting", "onNetworkError", "onMute", "onUnMute", "onQueryBegin", "onQueryEnd", "isForceResetText", "getRightIcon", "Landroid/view/View;", "getLeftIcon", "getHotArea", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getIsSupportMute", "onAudioDataReceive", "data", "Lcom/larus/audio/audiov3/audio/record/RecordedAudioData;", "refreshConnectionStatusContainer", "refreshSpeakingStatusContainer", "force", "modifyListeningRunnable", "Ljava/lang/Runnable;", "modifyListeningText", "resetModifyListeningText", "refreshListeningStatusContainer", "refreshPausedStatusContainer", "refreshWaitingStatusContainer", "refreshNetworkErrorStatusContainer", "refreshMuteStatusContainer", "refreshUnMuteStatusContainer", "resumeStatusContainerOnUnMute", "delayShowInterrupt", "switchLeftBackground", "isMute", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatContinuousTalkLayout extends LinearLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f378101e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f378102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusLayoutContinousBottomControllerBinding f378103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f378104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j1 f378105d;

    public static final class a {
    }

    static {
    }

    public ChatContinuousTalkLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatContinuousTalkLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final ConstraintLayout getHotArea() {
        return this.f378103b.f378248b;
    }

    public final boolean getIsSupportMute() {
        return ((Boolean) this.f378102a.getValue()).booleanValue();
    }

    public final View getLeftIcon() {
        return this.f378103b.f378250d;
    }

    public final View getRightIcon() {
        return this.f378103b.f378254h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job r100 = this.f378104c;
        if (r100 == null) goto L6;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
        return;
    }

    public final void a(boolean r100) {
        Job r101 = this.f378104c;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isActive() != true) goto L7;
    L8:
        if (r102 == false) goto L11;
        if (r100 == true) goto L11;
        return;
    L11:
        LarusLayoutContinousBottomControllerBinding r103 = this.f378103b;
        TextView r104 = r103.f378255i;
        r104.setTextColor(ContextCompat.getColor(r104.getContext(), v19.c.b(R.attr.larus_neutral_100, r104.getContext(), R.color.larus_neutral_100)));
        r104.setAlpha(1.0f);
        int r105 = c4a.e.f22426a;
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.f379457v == false) goto L14;
        String r106 = AppHost.f326268a.getApplication().getString(R.string.larus_call_TapSpeak_to_interrupt);
        Intrinsics.checkNotNull(r106);
    L15:
        r104.setText(r106);
        r104.setVisibility(0);
        r103.f378251e.f328162k.clear();
        r103.f378249c.setVisibility(0);
        r103.f378252f.setVisibility(8);
        r103.f378251e.setVisibility(8);
        r103.f378253g.setVisibility(8);
        b(false);
        return;
    L14:
        r106 = AppHost.f326268a.getApplication().getString(R.string.larus_Realtime_call_Tap_to_interrupt);
        Intrinsics.checkNotNull(r106);
    L7:
        r102 = false;
        goto L8
    }

    public final void b(boolean r100) {
        boolean r101 = v19.h.f552477a;
        boolean r102 = !v19.h.b(getContext());
        if (r100 == false) goto L6;
        if (r102 == false) goto L6;
        int r103 = R.drawable.larus_ic_chat_continuous_bottom_mute;
    L11:
        this.f378103b.f378250d.setBackground(ContextCompat.getDrawable(getContext(), r103));
        return;
    L6:
        if (r100 == false) goto L8;
        r103 = R.drawable.larus_ic_chat_continuous_bottom_mute_dark;
        goto L11
    L8:
        if (r102 == false) goto L10;
        r103 = R.drawable.larus_ic_chat_continuous_bottom_unmute;
        goto L11
    L10:
        r103 = R.drawable.larus_ic_chat_continuous_bottom_unmute_dark;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r12v15, types: [com.larus.voicecall.impl.continue_talk.j1] */
    public ChatContinuousTalkLayout(final Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f378102a = LazyKt.lazy(new i1());
        LayoutInflater.from(r110).inflate(R.layout.larus_layout_continous_bottom_controller, this);
        int r113 = R.id.continuous_talk_container;
        ConstraintLayout r100 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.continuous_talk_container);
        if (r100 == null) goto L21;
        r113 = R.id.continuous_talk_interrupt;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.continuous_talk_interrupt);
        if (r101 == null) goto L21;
        r113 = R.id.continuous_talk_left_icon;
        View r102 = ViewBindings.findChildViewById(this, R.id.continuous_talk_left_icon);
        if (r102 == null) goto L21;
        r113 = R.id.continuous_talk_listening_anim;
        ChatContinuousAudioVisualizerOpt r103 = (ChatContinuousAudioVisualizerOpt) ViewBindings.findChildViewById(this, R.id.continuous_talk_listening_anim);
        if (r103 == null) goto L21;
        r113 = R.id.continuous_talk_loading;
        ProgressBar r104 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.continuous_talk_loading);
        if (r104 == null) goto L21;
        r113 = R.id.continuous_talk_pause_or_error;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.continuous_talk_pause_or_error);
        if (r105 == null) goto L21;
        r113 = R.id.continuous_talk_right_icon;
        View r106 = ViewBindings.findChildViewById(this, R.id.continuous_talk_right_icon);
        if (r106 == null) goto L21;
        r113 = R.id.continuous_talk_status_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(this, R.id.continuous_talk_status_text);
        if (r107 == null) goto L21;
        this.f378103b = new LarusLayoutContinousBottomControllerBinding(this, r100, r101, r102, r103, r104, r105, r106, r107);
        this.f378105d = new j1(this, r110);
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public /* synthetic */ ChatContinuousTalkLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
