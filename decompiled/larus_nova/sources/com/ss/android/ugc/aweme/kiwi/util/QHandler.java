package com.ss.android.ugc.aweme.kiwi.util;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/util/QHandler;", "", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public final class QHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f450932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f450933b;

    public final void a(final Function0<Unit> r100) {
        if (this.f450933b == false) goto L5;
        r100.invoke();
        return;
    L5:
        this.f450932a.post(new QHandler$sam$java_lang_Runnable$0(r100));
    }

    public QHandler(Handler r100, boolean r101) {
        this.f450932a = r100;
        this.f450933b = r101;
    }
}
