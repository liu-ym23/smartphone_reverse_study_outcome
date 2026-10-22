package com.bytedance.kmp.ec.yata.store.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class q implements com.bytedance.kmp.ec.yata.store.redux.j<Object> {

    public static final class a implements com.bytedance.kmp.ec.yata.store.redux.i<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.kmp.ec.yata.store.redux.i<Object> f251758a;

        public a(com.bytedance.kmp.ec.yata.store.redux.i<Object> r100) {
            this.f251758a = r100;
        }

        @Override // com.bytedance.kmp.ec.yata.store.redux.i
        public final com.bytedance.kmp.ec.yata.store.redux.h a(com.bytedance.kmp.ec.yata.store.redux.g r100, l r101) {
            Intrinsics.checkNotNullParameter(r100, "reducer");
            return new YataStore(this.f251758a.a(r100, r101));
        }
    }

    public q() {
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.j
    public final com.bytedance.kmp.ec.yata.store.redux.i<Object> a(com.bytedance.kmp.ec.yata.store.redux.i<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "storeCreator");
        return new a(r100);
    }
}
