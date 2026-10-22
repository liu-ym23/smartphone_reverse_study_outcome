package com.bytedance.badger.x;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class t extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f0 f199403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f199404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ z f199405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ a0 f199406d;

    public t(f0 r100, long r101, z r102, a0 r103) {
        this.f199403a = r100;
        this.f199404b = r101;
        this.f199405c = r102;
        this.f199406d = r103;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        a((a0) r100);
        return Unit.INSTANCE;
    }

    public final void a(a0 r110) {
        if (r110.f199366a == false) goto L6;
        f0 r100 = this.f199403a;
        long r101 = this.f199404b;
        z r102 = this.f199405c;
        String r111 = r110.f199367b;
        r100.f199388f.getClass();
        r100.c(r101, new y(0, "success", r102, r111, "service", 32), f0.a(this.f199403a, this.f199406d.f199369d, "provider: "), f0.a(this.f199403a, r110.f199369d, "service: "));
        return;
    L6:
        StringBuilder r103 = new StringBuilder("provider: ");
        Throwable r104 = (Throwable) CollectionsKt.firstOrNull(this.f199406d.f199369d);
        String r105 = null;
        if (r104 == null) goto L9;
        String r106 = r104.getMessage();
    L10:
        r103.append(r106);
        r103.append(" service: ");
        Throwable r107 = (Throwable) CollectionsKt.firstOrNull(r110.f199369d);
        if (r107 == null) goto L13;
        r105 = r107.getMessage();
    L13:
        r103.append(r105);
        String r108 = r103.toString();
        f0 r109 = this.f199403a;
        r109.c(this.f199404b, new y(-1000, r108, this.f199405c, null, null, 56), f0.a(r109, this.f199406d.f199369d, "provider: "), f0.a(this.f199403a, r110.f199369d, "service: "));
        return;
    L9:
        r106 = null;
        goto L10
    }
}
