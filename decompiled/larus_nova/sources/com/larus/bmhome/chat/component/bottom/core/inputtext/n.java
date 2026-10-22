package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;

/* JADX INFO: loaded from: classes25.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f298998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f298999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ChatInputMentionPanelController f299000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MentionFilePickerType f299001d;

    public n(View r100, View r101, ChatInputMentionPanelController r102, MentionFilePickerType r103) {
        this.f298998a = r100;
        this.f298999b = r101;
        this.f299000c = r102;
        this.f299001d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f298999b;     // Catch: Throwable -> L4
        r100.post(new o(r100, this.f299000c, this.f299001d));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
