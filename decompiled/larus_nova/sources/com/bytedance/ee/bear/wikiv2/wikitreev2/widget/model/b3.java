package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class b3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiDatabase f241772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f241773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a3 f241774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WikiHomePageV2 f241775d;

    public b3(WikiDatabase r100, String r101, a3 r102, WikiHomePageV2 r103) {
        this.f241772a = r100;
        this.f241773b = r101;
        this.f241774c = r102;
        this.f241775d = r103;
    }

    public final void a() {
        yq5.f r100 = this.f241772a.d();
        yq5.a r101 = r100.h(this.f241773b);
        if (r101 != null) goto L5;
        return;
    L5:
        a3 r102 = this.f241774c;
        WikiHomePageV2 r103 = this.f241775d;
        r102.getClass();
        r101.f568773v = r103.objToken;
        r101.f568774w = r103.objType;
        r101.f568775x = r103.wikiToken;
        r101.f568776y = r103.url;
        r101.f568777z = r103.title;
        r100.k(r101);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
