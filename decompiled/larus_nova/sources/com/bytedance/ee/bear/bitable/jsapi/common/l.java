package com.bytedance.ee.bear.bitable.jsapi.common;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l<T> implements FlowableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l<T> f214417a = null;

    public static final class a implements com.bytedance.ee.bear.lark.dependency.h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowableEmitter<String> f214418a;

        @Override // com.bytedance.ee.bear.lark.dependency.h.a
        public final void a() {
            tt5.a.h("NewLarkForm", "docSdkInit success");
            ((com.bytedance.ee.bear.lark.dependency.h) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.h.class, null, null, 6)).c();
            this.f214418a.onNext("");
            this.f214418a.onComplete();
        }

        public a(FlowableEmitter<String> r100) {
            this.f214418a = r100;
        }
    }

    static {
        f214417a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        com.bytedance.ee.bear.lark.dependency.h r101 = (com.bytedance.ee.bear.lark.dependency.h) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.h.class, null, null, 6);
        tt5.a.h("NewLarkForm", "docSdkInit begin");
        r101.b(new a(r100));
        r101.a();
    }
}
