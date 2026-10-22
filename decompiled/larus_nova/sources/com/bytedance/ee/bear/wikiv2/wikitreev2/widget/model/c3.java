package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class c3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiDatabase f241782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f241783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f241784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f241785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f241786e;

    public c3(WikiDatabase r100, String r101, String r102, String r103, Ref.BooleanRef r104) {
        this.f241782a = r100;
        this.f241783b = r101;
        this.f241784c = r102;
        this.f241785d = r103;
        this.f241786e = r104;
    }

    public final void a() {
        yq5.f r100 = this.f241782a.d();
        yq5.a r101 = r100.h(this.f241783b);
        if (r101 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r101.f568775x, this.f241784c) == true) goto L9;
        return;
    L9:
        if (TextUtils.equals(r101.f568777z, this.f241785d) == false) goto L11;
        return;
    L11:
        r101.f568777z = this.f241785d;
        r100.k(r101);
        this.f241786e.element = true;
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
