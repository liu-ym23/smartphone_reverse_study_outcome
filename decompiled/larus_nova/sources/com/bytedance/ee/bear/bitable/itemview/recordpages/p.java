package com.bytedance.ee.bear.bitable.itemview.recordpages;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes15.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ItemViewRecordFooterData f214220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214221b;

    public p(ItemViewRecordFooterData r100, t r101) {
        this.f214220a = r100;
        this.f214221b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<ActionPayload> r100 = this.f214220a.getButtonActionList();     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        ActionPayload r101 = (ActionPayload) com.bytedance.ee.bear.bitable.m.j(r100, 1, null);     // Catch: Throwable -> L10
        if (r101 == null) goto L17;
        gv4.a r102 = this.f214221b;     // Catch: Throwable -> L10
        if (r102 == null) goto L18;
        r102.a(r101);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
