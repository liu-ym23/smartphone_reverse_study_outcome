package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010&\u001a\u00020'H\u0004J\b\u0010(\u001a\u00020'H\u0004J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0010H\u0017J\u001a\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\f2\b\b\u0002\u0010-\u001a\u00020\"H\u0016J\u0010\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\"H\u0016J\u000e\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u0010J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\"H\u0016J\u0018\u00104\u001a\u00020'2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020'\u0018\u000106H\u0016J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020'H&J\b\u0010:\u001a\u00020'H\u0016J\u0010\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020'H\u0016J\b\u0010?\u001a\u00020'H\u0016J\b\u0010@\u001a\u00020'H\u0004J\u0010\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020\u0010H\u0017J\u0010\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020\u0010H\u0017J\u000e\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020\u0010J\u0010\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020\"H\u0016J\b\u0010I\u001a\u00020'H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0010X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0012\u0010\u0017\u001a\u00020\u0010X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0012\u0010\u0019\u001a\u00020\u001aX¤\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001eX¤\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%¨\u0006J"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/abs/AbsAudioPopupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/abs/IAudioPopupView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "mController", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;", "mDisplayMode", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;)V", "mTag", "", "getMTag", "()Ljava/lang/String;", "mMainBtnTop", "", "getMMainBtnTop", "()I", "setMMainBtnTop", "(I)V", "mCompleteLayoutId", "getMCompleteLayoutId", "mSimpleLayoutId", "getMSimpleLayoutId", "mBgLayout", "Landroid/view/ViewGroup;", "getMBgLayout", "()Landroid/view/ViewGroup;", "mMainBtn", "Lcom/larksuite/component/universe_design/button/UDButton;", "getMMainBtn", "()Lcom/larksuite/component/universe_design/button/UDButton;", "isPopupViewShowing", "", "()Z", "setPopupViewShowing", "(Z)V", "inflateLayout", "", "initUI", "setVolume", ITTVideoEngineEventSource.KEY_VOLUME, "setDuration", "duration", "isElapseCountDown", "setIsSingleClick", "isSingleClick", "setPadding", GXTemplateKey.FLEXBOX_PADDING, "onSysKeyboardShowOrHide", "keyboardIsShown", "dismiss", "onDismiss", "Lkotlin/Function0;", "getContentView", "Landroid/view/View;", "resetUI", "onMainBtnDownEvent", "onMainBtnMoveEvent", "event", "Landroid/view/MotionEvent;", "onMainBtnUpOrCancelEvent", "onPause", "setMainBtnIcon", "setBgHeight", "height", "setMainBtnBottomMargin", "bottomMargin", "setMainBtnTopRawY", "y", "updateUIOnRecordStateChanged", "isRecording", "onAsrLastFrameTimeOut", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsAudioPopupView extends ConstraintLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f429972a;

    public void R5() {
    }

    public void S5(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a
    public View getContentView() {
        return this;
    }

    public abstract ViewGroup getMBgLayout();

    public abstract int getMCompleteLayoutId();

    public abstract UDButton getMMainBtn();

    public abstract int getMSimpleLayoutId();

    public abstract String getMTag();

    public void setIsSingleClick(boolean r100) {
    }

    public final void setPopupViewShowing(boolean r100) {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a
    public Pair<Integer, Integer> getLayoutParamAttributes() {
        return new Pair(-1, -2);
    }

    public void T5() {
        Log.i(getMTag(), "onMainBtnUpOrCancelEvent");
    }

    public final int getMMainBtnTop() {
        return this.f429972a;
    }

    public void U5(boolean r100) {
        if (r100 == true) goto L7;
        setPadding(0);
        return;
    L7:
        throw null;
    }

    public void setBgHeight(final int r100) {
        int r101 = c.f430003a;
        c.p(getMBgLayout(), new AnonymousClass1(r100));
    }

    public final void setMMainBtnTop(int r100) {
        this.f429972a = r100;
    }

    public void setMainBtnBottomMargin(final int r100) {
        int r101 = c.f430003a;
        c.p(getMMainBtn(), new C119041(r100));
    }

    public final void setMainBtnTopRawY(int r100) {
        this.f429972a = r100;
    }

    public final void setPadding(int r100) {
        Log.i(getMTag(), "onSysKeyboardShowOrHide / Set bottom padding: " + r100);
        setPadding(0, 0, 0, r100);
    }

    public void setVolume(int r100) {
        if (r100 <= 500) goto L6;
        Log.i(getMTag(), "setVolume / Volume: " + r100);
        return;
    }

    public void t5(Function0<Unit> r100) {
        Log.i(getMTag(), "dismiss");
        throw null;
    }
}
