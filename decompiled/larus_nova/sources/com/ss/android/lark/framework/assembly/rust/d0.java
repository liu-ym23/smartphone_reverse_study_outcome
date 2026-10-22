package com.ss.android.lark.framework.assembly.rust;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d0<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f425693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Object> f425694b;

    public d0(String r100, com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Object> r101) {
        this.f425693a = r100;
        this.f425694b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        String r101 = this.f425693a;
        ThreadLocal<String> r102 = qqb.a.f534506a;
        Intrinsics.checkNotNullParameter(r101, "contextId");
        String r103 = qqb.a.b(r101);
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        r103 = qqb.a.d();
    L8:
        qqb.a.g(r103);
        r100.onNext(this.f425694b);
        r100.onComplete();
        qqb.a.a();
        return;
    L5:
        r104 = false;
        goto L6
    }
}
