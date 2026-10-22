package com.ss.android.lark.contact.base.contact_search;

import android.widget.EditText;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f418813a;

    @Override // java.lang.Runnable
    public final void run() {
        KeyboardUtils.showKeyboard(this.f418813a.f418825r);     // Catch: Throwable -> L4
        EditText r100 = this.f418813a.f418825r;     // Catch: Throwable -> L4
        r100.setSelection(r100.getText().length());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(s r100) {
        this.f418813a = r100;
    }
}
