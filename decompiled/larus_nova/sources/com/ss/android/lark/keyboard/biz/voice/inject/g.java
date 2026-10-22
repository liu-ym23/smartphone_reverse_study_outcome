package com.ss.android.lark.keyboard.biz.voice.inject;

import android.widget.EditText;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceInputPreviewDelegate f428636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f428637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EditText f428638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ VoiceInputPreviewDelegate.PreviewOriginMode f428639d;

    public g(VoiceInputPreviewDelegate r100, boolean r101, EditText r102, VoiceInputPreviewDelegate.PreviewOriginMode r103) {
        this.f428636a = r100;
        this.f428637b = r101;
        this.f428638c = r102;
        this.f428639d = r103;
    }

    public final void a() {
        if (this.f428636a.f428596d.invoke().booleanValue() == false) goto L6;
        return;
    L6:
        if (this.f428637b == false) goto L9;
        this.f428638c.requestFocus();
        KeyboardUtils.showKeyboard(this.f428638c);
        return;
    L9:
        if (this.f428639d != VoiceInputPreviewDelegate.PreviewOriginMode.VOICE_MODE) goto L11;
        this.f428636a.f428595c.invoke();
        return;
    L11:
        this.f428638c.clearFocus();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
