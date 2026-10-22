package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs;

import android.widget.EditText;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.d;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\"\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001dH\u0017J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0015H\u0017J\u0006\u0010'\u001a\u00020\u000bJ\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u0015H\u0017J\b\u0010,\u001a\u00020\u001dH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/abs/AbsAudioPopupViewWithEditText;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/abs/AbsAudioPopupView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "mController", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;", "mDisplayMode", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;)V", "mHintString", "", "mForegroundColorSpan", "Landroid/text/style/ForegroundColorSpan;", "mLoadingCallback", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/SpannableStringUtils$DrawableCallback;", "getMLoadingCallback", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/SpannableStringUtils$DrawableCallback;", "mLoadingCallback$delegate", "Lkotlin/Lazy;", "mHasAsrResult", "", "getMHasAsrResult", "()Z", "setMHasAsrResult", "(Z)V", "getEditText", "Landroid/widget/EditText;", "showHintText", "", "clearLoadingDrawable", "setText", "asrText", "isFinish", "diffIndex", "", "onAsrLastFrameTimeOut", "updateUIOnAsrFinish", "isAsrTimeOut", "getStringText", "getRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "updateUIOnRecordStateChanged", "isRecording", "onPause", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsAudioPopupViewWithEditText extends AbsAudioPopupView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f429973b;

    public abstract EditText getEditText();

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView
    public void R5() {
        Log.i(getMTag(), "ASR timeout");
        V5();
        if (KeyboardVoiceFGUtils.h() == true) goto L5;
        fwa.a.a(false, "timeout");
    L5:
        Y5(true);
    }

    public final void V5() {
        getEditText();
        Lazy r100 = SpannableStringUtils.f429999a;
        SpannableStringUtils.c(getEditText().getEditableText());
    }

    public final RichText getRichText() {
        return ExtensionEditTextCompatKt.f(getEditText());
    }

    public final String getStringText() {
        EditText r100 = getEditText();
        if ((r100 instanceof FunctionEditText) == false) goto L6;
        return ((d) ((FunctionEditText) r100).q(d.f429100g)).m(0, r100.length());
    L6:
        return r100.getText().toString();
    }

    private final SpannableStringUtils.a getMLoadingCallback() {
        throw null;
    }

    public final boolean getMHasAsrResult() {
        return this.f429973b;
    }

    public void Y5(boolean r100) {
        Log.i(getMTag(), "updateUIOnAsrFinish");
    }

    public final void setMHasAsrResult(boolean r100) {
        this.f429973b = r100;
    }
}
