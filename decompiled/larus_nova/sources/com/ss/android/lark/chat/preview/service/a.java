package com.ss.android.lark.chat.preview.service;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f416306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap<String, UrlCardPreviewEntity> f416307b;

    public a(d r100, HashMap<String, UrlCardPreviewEntity> r101) {
        this.f416306a = r100;
        this.f416307b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<ucb.a> r100 = this.f416306a.f416310a;     // Catch: Throwable -> L7
        HashMap<String, UrlCardPreviewEntity> r101 = this.f416307b;     // Catch: Throwable -> L7
        Iterator<ucb.a> r102 = r100.iterator();     // Catch: Throwable -> L7
    L4:
        if (r102.hasNext() == false) goto L16;
        r102.next().a(r101);     // Catch: Throwable -> L7
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
