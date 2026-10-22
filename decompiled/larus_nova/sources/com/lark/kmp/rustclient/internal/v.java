package com.lark.kmp.rustclient.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class v extends WaitConditionInterceptor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.lark.kmp.rustclient.barrier.a f282562d;

    public static final class a implements com.lark.kmp.rustclient.barrier.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f282563a;

        public a(v r100) {
            this.f282563a = r100;
        }

        @Override // com.lark.kmp.rustclient.barrier.b
        public final Object a(boolean r100, Continuation<? super Unit> r101) {
            if (r100 == true) goto L9;
            Object r102 = this.f282563a.e(r101);
            if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
            return r102;
        L7:
            return Unit.INSTANCE;
        L9:
            return Unit.INSTANCE;
        }
    }

    public v(com.lark.kmp.rustclient.barrier.a r100) {
        Intrinsics.checkNotNullParameter(r100, "rustBarrier");
        super(0);
        this.f282562d = r100;
        r100.a(new a(this));
    }

    @Override // com.lark.kmp.rustclient.internal.WaitConditionInterceptor
    public final <T> boolean c(com.lark.kmp.rustclient.api.a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return !this.f282562d.c();
    }
}
