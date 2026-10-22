package fq1;

import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i f478405a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int a() {
        return this.f478405a.a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int c() {
        return this.f478405a.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final Gson d() {
        return this.f478405a.d();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int f() {
        return this.f478405a.f();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int g() {
        return this.f478405a.g();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        return (T) this.f478405a.getService(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int h() {
        return this.f478405a.h();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public k(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i r100) {
        Intrinsics.checkNotNullParameter(r100, "networkService");
        this.f478405a = r100;
    }
}
