package com.bytedance.forest.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Date;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f244527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f244528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f244529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f244530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f244531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f244532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f244533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ HashMap f244534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Throwable f244535i;

    public d(c r100, long r101, Ref.ObjectRef r102, int r103, String r104, boolean r105, String r106, HashMap r107, Throwable r110) {
        this.f244527a = r100;
        this.f244528b = r101;
        this.f244529c = r102;
        this.f244530d = r103;
        this.f244531e = r104;
        this.f244532f = r105;
        this.f244533g = r106;
        this.f244534h = r107;
        this.f244535i = r110;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [T, java.lang.String] */
    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(c.f244512e.format(new Date(this.f244528b)));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        this.f244529c.element = "[" + r102 + ']' + ((String) this.f244529c.element);
        int r103 = this.f244530d;
        if (r103 != 3) goto L16;
        i r104 = i.f244548a;
        i.a(this.f244531e, (String) this.f244529c.element, this.f244532f, this.f244527a.f244513a, this.f244533g, this.f244534h);
        return;
    L16:
        if (r103 == 4) goto L18;
        i r105 = i.f244548a;
        i.d(this.f244531e, (String) this.f244529c.element, this.f244535i, this.f244532f, this.f244527a.f244513a, this.f244533g, this.f244534h);
        return;
    L18:
        i r106 = i.f244548a;
        i.g(this.f244531e, (String) this.f244529c.element, this.f244532f, this.f244527a.f244513a, this.f244533g, this.f244534h);
        return;
    L4:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
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
