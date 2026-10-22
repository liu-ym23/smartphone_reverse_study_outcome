package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.sdk.InvokeResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e0 implements com.bytedance.lark.rustclient.api.m {

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f425695a;

        public a(String r100) {
            this.f425695a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.s r101 = (com.bytedance.lark.rustclient.api.s) r100;
            Intrinsics.checkNotNullParameter(r101, "value");
            return Observable.create(new d0(this.f425695a, r101));
        }
    }

    @Inject
    public e0() {
    }

    @Override // com.bytedance.lark.rustclient.api.m
    public final <Resp> Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Resp>> a(com.bytedance.lark.rustclient.api.n<Resp> r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        com.bytedance.lark.rustclient.api.b<Resp> r101 = r100.f253917c;
        String r102 = r101.f253903a.f253893b;
        return (Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Resp>>) r100.b(r101).flatMap(new a(r102));
    }

    @Override // com.bytedance.lark.rustclient.api.m
    public final <Resp> com.bytedance.lark.rustclient.api.s<InvokeResponse, Resp> b(com.bytedance.lark.rustclient.api.n<Resp> r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        return r100.a(r100.f253917c);
    }
}
