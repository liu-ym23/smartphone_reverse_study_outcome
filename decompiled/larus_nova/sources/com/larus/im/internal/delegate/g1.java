package com.larus.im.internal.delegate;

import com.larus.im.internal.database.entity.MessageEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g1 implements hd9.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g1 f348229b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hd9.l f348230a;

    static {
        f348229b = new g1();
    }

    @Override // hd9.l
    public final String a(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "messageEntity");
        return this.f348230a.a(r100);
    }

    @Override // hd9.l
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dbName");
        this.f348230a.b(r100);
    }

    @Override // hd9.l
    public final String c() {
        return this.f348230a.c();
    }

    @Override // hd9.l
    public final hd9.i d() {
        return this.f348230a.d();
    }

    @Override // hd9.l
    public final hd9.m e() {
        return this.f348230a.e();
    }

    @Override // hd9.l
    public final hd9.k f() {
        return this.f348230a.f();
    }

    @Override // hd9.l
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dbName");
        this.f348230a.g(r100);
    }

    public g1() {
        this.f348230a = sc9.a.a().b();
    }
}
