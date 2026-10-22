package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;

/* JADX INFO: loaded from: classes25.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f299008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChatInputMentionPanelController f299009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MentionFilePickerType f299010c;

    public o(View r100, ChatInputMentionPanelController r101, MentionFilePickerType r102) {
        this.f299008a = r100;
        this.f299009b = r101;
        this.f299010c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f299008a.isAttachedToWindow() == false) goto L9;
        this.f299009b.f298574a.f298612u.invoke(this.f299010c);     // Catch: Throwable -> L6
        return;
    }
}
