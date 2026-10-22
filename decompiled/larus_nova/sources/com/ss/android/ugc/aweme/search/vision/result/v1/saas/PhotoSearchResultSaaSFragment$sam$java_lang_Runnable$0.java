package com.ss.android.ugc.aweme.search.vision.result.v1.saas;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
public final class PhotoSearchResultSaaSFragment$sam$java_lang_Runnable$0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f454014a;

    public PhotoSearchResultSaaSFragment$sam$java_lang_Runnable$0(Function0 r100) {
        this.f454014a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f454014a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
