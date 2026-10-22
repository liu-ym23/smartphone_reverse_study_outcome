package fq1;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.utils.rxutils.autodispose.v;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m f478409a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return this.f478409a.a(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final IBaseUser b() {
        return this.f478409a.b();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final boolean c() {
        return this.f478409a.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final void f(py.t r100) {
        Intrinsics.checkNotNullParameter(r100, "userAttr");
        this.f478409a.f(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable<IFollowPair> followStateChanged() {
        return this.f478409a.followStateChanged();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable g(String r100, Activity r101, LiveFollowScene r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter("", "requestId");
        Intrinsics.checkNotNullParameter("live_detail", "enterLiveSource");
        Intrinsics.checkNotNullParameter("", "fromLabel");
        Intrinsics.checkNotNullParameter("", "roomLabels");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        Intrinsics.checkNotNullParameter("follow", "scene");
        Intrinsics.checkNotNullParameter(r102, "followScene");
        return this.f478409a.g(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String getCurrentUserId() {
        return this.f478409a.getCurrentUserId();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final py.k h() {
        return this.f478409a.h();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String i() {
        return this.f478409a.i();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final boolean isLogin() {
        return this.f478409a.isLogin();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final int j() {
        return this.f478409a.j();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String k() {
        return this.f478409a.k();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final void n(Fragment r100, bm1.b r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f478409a.n(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final boolean o() {
        return this.f478409a.o();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Single q(HashMap r100, String r101, Long r102, String r103) {
        return this.f478409a.q(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String s() {
        return this.f478409a.s();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable w(String r100, Activity r101, LiveFollowScene r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter("", "fromLabel");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        Intrinsics.checkNotNullParameter("unfollow", "scene");
        Intrinsics.checkNotNullParameter(r102, "followScene");
        return this.f478409a.w(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final v<UserEvent> x(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        return this.f478409a.x(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable<IBaseUser> y(Context r100, String r110, String r111, String r112, String r113, int r114, String r115) {
        return this.f478409a.y(r100, r110, r111, r112, r113, r114, r115);
    }

    public s(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m r100) {
        Intrinsics.checkNotNullParameter(r100, "userService");
        this.f478409a = r100;
    }
}
