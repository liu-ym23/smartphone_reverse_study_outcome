package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioAsrLanguageSwitcher f429932a;

    public b(AudioAsrLanguageSwitcher r100) {
        this.f429932a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioAsrLanguageSwitcher r100 = this.f429932a;     // Catch: Throwable -> L7
        Iterator r101 = ((ArrayList) r100.f429845d).iterator();     // Catch: Throwable -> L7
    L4:
        if (r101.hasNext() == false) goto L16;
        ((AudioAsrLanguageSwitcher.b) r101.next()).c(r100.f429847f, r100.f429846e, true);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
