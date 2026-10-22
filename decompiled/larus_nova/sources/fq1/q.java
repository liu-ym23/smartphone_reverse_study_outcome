package fq1;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e f478408a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void a(StackTraceElement[] r100) {
        Intrinsics.checkNotNullParameter(r100, "traceElements");
        this.f478408a.a(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void c(String r100, Map<String, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f478408a.c(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final String d() {
        return this.f478408a.d();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "dataString");
        this.f478408a.d(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "dataString");
        this.f478408a.e(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final String f() {
        return this.f478408a.f();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "dataString");
        this.f478408a.i(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void logV3(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter("feed_enter_room", "eventName");
        Intrinsics.checkNotNullParameter(r101, "map");
        this.f478408a.logV3("feed_enter_room", r101);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public q(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e r100) {
        Intrinsics.checkNotNullParameter(r100, "liveTraceService");
        this.f478408a = r100;
    }
}
