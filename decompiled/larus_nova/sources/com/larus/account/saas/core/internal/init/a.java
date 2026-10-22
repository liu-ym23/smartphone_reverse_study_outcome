package com.larus.account.saas.core.internal.init;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends wqa.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f286244e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f286245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f286246d;

    /* JADX INFO: renamed from: com.larus.account.saas.core.internal.init.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class C3941a {
    }

    static {
    }

    @Override // wqa.f
    public final go2.g c() {
        return new go2.g();
    }

    @Override // wqa.f
    public final void d() {
    }

    @Override // wqa.f
    public final void e() {
    }

    @Override // wqa.f
    public final void isLocalTest() {
    }

    @Override // wqa.f
    public final d b() {
        return new d();
    }

    @Override // wqa.f
    public final b f() {
        return new b();
    }

    @Override // wqa.f
    public final e getLogger() {
        return new e();
    }

    @Override // wqa.f
    public final int appId() {
        c48.a.a().a();
        return com.larus.init.task.accountsdk.a.f351133a.a();
    }

    @Override // wqa.f
    public final String S() {
        return this.f286245c;
    }

    @Override // wqa.f
    public final Context getApplicationContext() {
        return this.f286246d;
    }

    public a(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "applicationContext");
        this.f286245c = r100;
        this.f286246d = r101;
    }
}
