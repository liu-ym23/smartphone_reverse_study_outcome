package fq1;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k f478406a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k
    public final void a(Context r100) {
        this.f478406a.a(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k
    public final boolean c(Context r100) {
        return this.f478406a.c(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k
    public final boolean d(Context r100) {
        return this.f478406a.d(r100);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public m(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k r100) {
        Intrinsics.checkNotNullParameter(r100, "replayPermissionService");
        this.f478406a = r100;
    }
}
