package com.ss.android.lark.officesdk.plugin;

import io.reactivex.Completable;
import io.reactivex.functions.Action;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConcurrentHashMap<String, Completable> f437141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f437142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Completable> f437143c;

    public c(ConcurrentHashMap<String, Completable> r100, String r101, Ref.ObjectRef<Completable> r102) {
        this.f437141a = r100;
        this.f437142b = r101;
        this.f437143c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        ConcurrentHashMap<String, Completable> r100 = this.f437141a;
        String r101 = this.f437142b;
        Ref.ObjectRef<Completable> r102 = this.f437143c;
        monitor-enter(r100);
        Completable r103 = r100.get(r101);     // Catch: Throwable -> L13
        Completable r104 = r102.element;     // Catch: Throwable -> L13
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("task");     // Catch: Throwable -> L13
        Completable r105 = null;
    L8:
        if (r103 != r105) goto L10;
        r100.remove(r101);     // Catch: Throwable -> L13
    L10:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r100);
        return;
    L7:
        r105 = r104;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
