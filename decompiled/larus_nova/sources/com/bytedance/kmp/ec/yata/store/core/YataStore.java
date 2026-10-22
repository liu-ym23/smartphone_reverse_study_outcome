package com.bytedance.kmp.ec.yata.store.core;

import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper$initStoreStateSubscribe$1;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class YataStore<TState> implements com.bytedance.kmp.ec.yata.store.redux.h<TState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.store.redux.h<TState> f251712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.platform.m f251713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.kmp.ec.yata.store.redux.b f251714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<TState> f251715d;

    public static final class a implements com.bytedance.kmp.ec.yata.store.redux.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ YataStore<TState> f251716a;

        public a(YataStore<TState> r100) {
            this.f251716a = r100;
        }

        @Override // com.bytedance.kmp.ec.yata.store.redux.b
        public final com.bytedance.kmp.ec.yata.store.redux.a a(com.bytedance.kmp.ec.yata.store.redux.a r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            YataStore<TState> r101 = this.f251716a;
            ReentrantLock r102 = r101.f251713b.f251546a;
            r102.lock();
            com.bytedance.kmp.ec.yata.store.redux.a r103 = r101.f251712a.b().a(r100);     // Catch: Throwable -> L6
            r102.unlock();
            return r103;
        L6:
            th = move-exception;
            r102.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.h
    public final com.bytedance.kmp.ec.yata.store.redux.b b() {
        return this.f251714c;
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.h
    public final Function0<TState> d() {
        return this.f251715d;
    }

    public YataStore(com.bytedance.kmp.ec.yata.store.redux.h<TState> r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        this.f251712a = r100;
        this.f251713b = new com.bytedance.kmp.ec.yata.common.platform.m();
        this.f251714c = new a(this);
        this.f251715d = new YataStore$getState$1(this);
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.h
    public final com.bytedance.kmp.ec.yata.store.redux.o a(YataStoreWrapper$initStoreStateSubscribe$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        ReentrantLock r101 = this.f251713b.f251546a;
        r101.lock();
        com.bytedance.kmp.ec.yata.store.redux.o r102 = this.f251712a.a(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.h
    public final void c(com.bytedance.kmp.ec.yata.store.redux.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f251714c = r100;
    }
}
