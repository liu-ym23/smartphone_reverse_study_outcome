package com.bytedance.ies.bullet.kit.web;

import android.view.ActionMode;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActionMode f247069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SSWebView f247070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f247071c;

    public m(ActionMode r100, SSWebView r101, String r102) {
        this.f247069a = r100;
        this.f247070b = r101;
        this.f247071c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f247069a.finish();     // Catch: Throwable -> L6
        h16.b r100 = this.f247070b.f246887n;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.g0(StringsKt.replace$default(this.f247071c, "\"", "", false, 4, null));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
