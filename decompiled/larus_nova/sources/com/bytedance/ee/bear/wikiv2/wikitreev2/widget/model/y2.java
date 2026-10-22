package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class y2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiDatabase f242165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f242166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f242167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a3 f242168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f242169e;

    public y2(WikiDatabase r100, String r101, String r102, a3 r103, Ref.BooleanRef r104) {
        this.f242165a = r100;
        this.f242166b = r101;
        this.f242167c = r102;
        this.f242168d = r103;
        this.f242169e = r104;
    }

    public final void a() {
        yq5.f r100 = this.f242165a.d();
        yq5.a r101 = r100.h(this.f242166b);
        if (r101 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r101.f568775x, this.f242167c) == true) goto L8;
        return;
    L8:
        this.f242168d.getClass();
        r101.f568773v = "";
        r101.f568774w = 0;
        r101.f568775x = "";
        r101.f568776y = "";
        r101.f568777z = "";
        r100.k(r101);
        this.f242169e.element = true;
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
