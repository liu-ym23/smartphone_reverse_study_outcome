package com.ss.android.lark.todo.impl.features.detail.at;

import android.widget.EditText;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f442776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoAtController f442777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f442778c;

    public a(EditText r100, TodoAtController r101, String r102) {
        this.f442776a = r100;
        this.f442777b = r101;
        this.f442778c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f442776a.requestFocus();     // Catch: Throwable -> L6
        KeyboardUtils.showKeyboard(this.f442776a);     // Catch: Throwable -> L6
        TodoAtController.b r100 = this.f442777b.f442760c;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.d(this.f442778c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
