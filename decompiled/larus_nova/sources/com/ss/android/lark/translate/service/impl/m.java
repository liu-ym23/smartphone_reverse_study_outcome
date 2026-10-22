package com.ss.android.lark.translate.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.m0;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TranslateLanguageSetting f444340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f444341b;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f444341b.f444344c).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((m0) r100.next()).onPushTranslateLanguageSetting(this.f444340a);     // Catch: Throwable -> L7
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

    public m(n r100, TranslateLanguageSetting r101) {
        this.f444341b = r100;
        this.f444340a = r101;
    }
}
