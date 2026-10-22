package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.h;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioLottieTrashButton;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioWaveformWidget;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 K2\u00020\u0001:\u0001KB!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010<\u001a\u0002082\u0006\u0010=\u001a\u000205H\u0016J\u0018\u0010>\u001a\u0002082\u000e\u0010?\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010@H\u0016J\u0010\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020\u000fH\u0016J\u0018\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u000205H\u0016J\b\u0010F\u001a\u000208H\u0016J\u0010\u0010G\u001a\u0002082\u0006\u0010H\u001a\u000205H\u0016J\u0010\u0010I\u001a\u0002082\u0006\u0010J\u001a\u000205H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b \u0010\u001dR\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0019\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0019\u001a\u0004\b-\u0010\u001dR\u001b\u0010/\u001a\u0002008TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0019\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/AudioRecordPopupView;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/abs/AbsAudioPopupView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "mController", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;", "mDisplayMode", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;)V", "mTag", "", "getMTag", "()Ljava/lang/String;", "mCompleteLayoutId", "", "getMCompleteLayoutId", "()I", "mSimpleLayoutId", "getMSimpleLayoutId", "mBgLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMBgLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mBgLayout$delegate", "Lkotlin/Lazy;", "mDurationTv", "Landroidx/appcompat/widget/AppCompatTextView;", "getMDurationTv", "()Landroidx/appcompat/widget/AppCompatTextView;", "mDurationTv$delegate", "mHintCancelTv", "getMHintCancelTv", "mHintCancelTv$delegate", "mWaveformWidget", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveformWidget;", "getMWaveformWidget", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveformWidget;", "mWaveformWidget$delegate", "mTrashBtn", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioLottieTrashButton;", "getMTrashBtn", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioLottieTrashButton;", "mTrashBtn$delegate", "mHintTv", "getMHintTv", "mHintTv$delegate", "mMainBtn", "Lcom/larksuite/component/universe_design/button/UDButton;", "getMMainBtn", "()Lcom/larksuite/component/universe_design/button/UDButton;", "mMainBtn$delegate", "mIsFinishing", "", "mIsCancelState", "onMainBtnMoveEvent", "", "event", "Landroid/view/MotionEvent;", "onMainBtnUpOrCancelEvent", "onSysKeyboardShowOrHide", "keyboardIsShown", "dismiss", "onDismiss", "Lkotlin/Function0;", "setVolume", ITTVideoEngineEventSource.KEY_VOLUME, "setDuration", "duration", "isElapseCountDown", "resetUI", "updateUIOnRecordStateChanged", "isRecording", "onCancelStateChanged", "isCanceled", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioRecordPopupView extends AbsAudioPopupView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f429963d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f429964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f429965c;

    public static final class a {
    }

    static {
    }

    public final void Y5() {
        V5(false);
        int r100 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.b(true, new View[]{getMDurationTv(), getMWaveformWidget(), getMHintTv()});
        getMDurationTv().setText("0:00");
        getMHintCancelTv().setVisibility(4);
        getMWaveformWidget().R5();
        AudioLottieTrashButton r101 = getMTrashBtn();
        r101.getClass();
        Log.i("AudioLottieTrashButton", BasicTestActionHandler.TEST_ACTION_RESET);
        r101.l();
        r101.cancelAnimation();
        r101.setMinFrame(0);
        r101.setProgress(0.0f);
        r101.m(0.0f);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public int getMCompleteLayoutId() {
        return 0;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public int getMSimpleLayoutId() {
        return 0;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public String getMTag() {
        return null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public final void T5() {
        super.T5();
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public /* bridge */ /* synthetic */ ViewGroup getMBgLayout() {
        return getMBgLayout();
    }

    private final AppCompatTextView getMDurationTv() {
        throw null;
    }

    private final AppCompatTextView getMHintCancelTv() {
        throw null;
    }

    private final AppCompatTextView getMHintTv() {
        throw null;
    }

    private final AudioLottieTrashButton getMTrashBtn() {
        throw null;
    }

    private final AudioWaveformWidget getMWaveformWidget() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public UDButton getMMainBtn() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public ConstraintLayout getMBgLayout() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public final void S5(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        float r101 = r100.getRawY();
        if (r101 > getMMainBtnTop()) goto L9;
        float r102 = getMMainBtnTop() - r101;
        if (r102 < getMTrashBtn().getMaxDeltaY()) goto L7;
        V5(true);
        return;
    L7:
        getMTrashBtn().m(r102);
        V5(false);
        return;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public final void U5(boolean r100) {
        T5();
    }

    public final void V5(boolean r100) {
        if (this.f429965c != r100) goto L5;
        return;
    L5:
        Log.i(getMTag(), "onCancelStateChanged / isCanceled = " + r100);
        this.f429965c = r100;
        if (r100 == true) goto L8;
        int r101 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.b(!r100, new View[]{getMDurationTv(), getMWaveformWidget(), getMHintTv()});
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a(getMHintCancelTv(), r100);
        int r102 = h.f429940a;
        throw null;
    L8:
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public void setVolume(int r100) {
        super.setVolume(r100);
        getMWaveformWidget().T5(r100);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a
    public final void t5(Function0<Unit> r100) {
        if (this.f429964b == false) goto L7;
        Log.e(getMTag(), "dismiss / isFinishing");
        return;
    L7:
        throw null;
    }
}
