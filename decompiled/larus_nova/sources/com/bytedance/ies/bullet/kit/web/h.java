package com.bytedance.ies.bullet.kit.web;

import android.view.ActionMode;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActionMode f246960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h16.b.a f246961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f246962c;

    public h(ActionMode r100, h16.b.a r101, String r102) {
        this.f246960a = r100;
        this.f246961b = r101;
        this.f246962c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f246960a.finish();     // Catch: Throwable -> L4
        this.f246961b.getClass();     // Catch: Throwable -> L4
        StringsKt.removeSurrounding(this.f246962c, "\"");     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
