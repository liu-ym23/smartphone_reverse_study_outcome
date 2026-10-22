package com.bytedance.badger.utils;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
final class r extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f199279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f199280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f199281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f199282d;

    public r(Object r100, Ref.BooleanRef r101, Ref.BooleanRef r102, Context r103) {
        this.f199279a = r100;
        this.f199280b = r101;
        this.f199281c = r102;
        this.f199282d = r103;
        super(2);
    }

    public final void a(ServiceConnection r100, ServiceConnection r101) {
        Object r102 = this.f199279a;
        monitor-enter(r102);
        Ref.BooleanRef r103 = this.f199280b;     // Catch: Throwable -> L18
        boolean r104 = r103.element;     // Catch: Throwable -> L18
        Ref.BooleanRef r105 = this.f199281c;     // Catch: Throwable -> L18
        boolean r106 = r105.element;     // Catch: Throwable -> L18
        r103.element = false;     // Catch: Throwable -> L18
        r105.element = false;     // Catch: Throwable -> L18
        monitor-exit(r102);
        if (r104 == true) goto L24;
    L12:
        if (r106 == false) goto L28;
        this.f199282d.unbindService(r100);     // Catch: Throwable -> L15 IllegalArgumentException -> L21
        goto L30
    L29:
        return;
    L15:
        th = move-exception;
        com.bytedance.badger.e.c("vivo#", "Failed to unbind account service", th);
        return;
    L30:
        return;
    L28:
        return;
    L24:
        this.f199282d.unbindService(r101);     // Catch: Throwable -> L9 IllegalArgumentException -> L11
    L9:
        th = move-exception;
        com.bytedance.badger.e.c("vivo#", "Failed to unbind isolated service", th);
    L18:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        a((ServiceConnection) r100, (ServiceConnection) r101);
        return Unit.INSTANCE;
    }
}
