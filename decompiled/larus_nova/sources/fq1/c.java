package fq1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b f478401a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void a(String r100, Map<String, String> r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f478401a.a(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void c(Context r100, Uri r101, Bundle r102) {
        this.f478401a.c(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void d(FragmentActivity r100, Fragment r101, boolean r102) {
        this.f478401a.d(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void f(Context r100, IRoom r101, Bundle r102) {
        this.f478401a.f(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void g(Activity r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "bindPhoneListener");
        this.f478401a.g(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final xu1.a getColorWeakModelEffectInfo() {
        this.f478401a.getColorWeakModelEffectInfo();
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final boolean h() {
        return this.f478401a.h();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void handleSchema(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        this.f478401a.handleSchema(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void handleSchema(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "uriString");
        this.f478401a.handleSchema(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final boolean isNeedProtectUnderage() {
        return this.f478401a.isNeedProtectUnderage();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final boolean isNetworkStateChanged() {
        return this.f478401a.isNetworkStateChanged();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void startLive(Context r100, long r101, Bundle r102) {
        this.f478401a.startLive(r100, r101, r102);
    }

    public c(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b r100) {
        Intrinsics.checkNotNullParameter(r100, "hostAction");
        this.f478401a = r100;
    }
}
