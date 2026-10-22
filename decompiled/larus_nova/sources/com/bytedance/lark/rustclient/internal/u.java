package com.bytedance.lark.rustclient.internal;

import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.tool.v1.MakeUserOfflineV2Request;
import com.bytedance.lark.pb.tool.v1.MakeUserOnlineV2Request;
import com.bytedance.lark.pb.tool.v1.SwitchUserStateRequest;
import com.bytedance.lark.sdk.InvokeResponse;
import com.bytedance.lark.sdk.refactor.state.LoginState;
import io.reactivex.Observable;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Deprecated(message = "replace with IRustInvoker after the FG 100%")
public final class u implements n, com.bytedance.lark.sdk.refactor.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.sdk.refactor.o f254028a;

    @Override // com.bytedance.lark.sdk.refactor.n
    public final Long a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return null;
    }

    @Override // com.bytedance.lark.sdk.refactor.e
    public final boolean b() {
        return false;
    }

    @Override // com.bytedance.lark.sdk.refactor.e
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.lark.sdk.refactor.n
    public final Pair i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return null;
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final int l(String r100, byte[] r101) {
        return -1;
    }

    @Override // com.bytedance.lark.sdk.refactor.n
    public final int m(String r100, byte[] r101) {
        return -1;
    }

    @Override // com.bytedance.lark.sdk.refactor.e
    public final void s(q.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
    }

    @Override // com.bytedance.lark.sdk.refactor.n
    public final void u(List r100) {
        Intrinsics.checkNotNullParameter(r100, "commands");
    }

    @Override // com.bytedance.lark.rustclient.internal.n
    public final boolean g() {
        return com.bytedance.lark.sdk.d.f254151r.get();
    }

    @Override // com.bytedance.lark.rustclient.internal.n
    public final boolean hasInit() {
        Map<Long, se6.b> r100 = com.bytedance.lark.sdk.d.f254138e;
        com.bytedance.lark.sdk.d.f.f254166a.getClass();
        if (com.bytedance.lark.sdk.d.f254149p < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public u(com.bytedance.lark.sdk.refactor.o r100) {
        Intrinsics.checkNotNullParameter(r100, "definition");
        this.f254028a = r100;
    }

    @Override // com.bytedance.lark.sdk.refactor.n
    public final LoginState f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return LoginState.OFFLINE;
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final void j(se6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Map<Long, se6.b> r101 = com.bytedance.lark.sdk.d.f254138e;
        com.bytedance.lark.sdk.d.f.f254166a.g(r100.f541567a, r100.f541568b, r100.f541571e, r100.f541569c.getValue());
    }

    @Override // com.bytedance.lark.rustclient.internal.n
    public final void n(v.a r100) {
        Intrinsics.checkNotNullParameter(r100, "onSwitchState");
        Set<WeakReference<se6.e>> r101 = com.bytedance.lark.sdk.d.f254152s;
        monitor-enter(r101);
        HashSet r102 = (HashSet) r101;     // Catch: Throwable -> L7
        r102.add(new WeakReference(r100));     // Catch: Throwable -> L7
        r100.a(com.bytedance.lark.sdk.d.f254151r.get());     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final InvokeResponse r(se6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return com.bytedance.lark.sdk.d.i(r100.f541567a, r100.f541568b, r100.f541569c.getValue());
    }

    @Override // com.bytedance.lark.sdk.refactor.n
    public final Observable<Boolean> w(InitSDKRequest.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "requestBuilder");
        return Observable.just(Boolean.FALSE);
    }

    @Override // com.bytedance.lark.rustclient.internal.n
    public final void x(s.a r100) {
        Intrinsics.checkNotNullParameter(r100, "onInit");
        Map<Long, se6.b> r101 = com.bytedance.lark.sdk.d.f254138e;
        com.bytedance.lark.sdk.d.f.f254166a.getClass();
        Set<se6.d> r102 = com.bytedance.lark.sdk.d.f254150q;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (com.bytedance.lark.sdk.d.f254149p < 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        r100.onInit();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L10:
        ((HashSet) r102).add(r100);     // Catch: Throwable -> L13
        goto L11
    L7:
        r103 = false;
        goto L8
    }

    @Override // com.bytedance.lark.sdk.refactor.n
    public final Observable<Boolean> h(String r100, SwitchUserStateRequest.Builder r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "requestBuilder");
        return Observable.just(Boolean.FALSE);
    }

    @Override // com.bytedance.lark.sdk.refactor.n
    public final Observable<Boolean> t(String r100, SwitchUserStateRequest.Builder r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "requestBuilder");
        return Observable.just(Boolean.FALSE);
    }

    @Override // com.bytedance.lark.sdk.refactor.n
    public final Observable<Boolean> q(String r100, MakeUserOfflineV2Request.Builder r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "requestBuilder");
        return Observable.just(Boolean.FALSE);
    }

    @Override // com.bytedance.lark.sdk.refactor.n
    public final Observable<Boolean> k(String r100, MakeUserOnlineV2Request.Builder r101, com.ss.android.lark.sdk.h r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "requestBuilder");
        return Observable.just(Boolean.FALSE);
    }
}
