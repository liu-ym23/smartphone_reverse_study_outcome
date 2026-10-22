package com.larksuite.component.blockit.hashtag.add;

import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes24.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f283017a;

    public h(b r100) {
        this.f283017a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KeyboardUtils.showKeyboard(this.f283017a.f283002a.findViewById(R.id.etSearchHashTag));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
