package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import com.bytedance.lark.rustclient.api.t;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.pb.improto.Command;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements com.ss.android.lark.officesdk.minutes.service.foundation.network.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f433913a;

    public e(d r100) {
        this.f433913a = r100;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final void c(Command r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Disposable r101 = this.f433913a.f433909e.remove(r100);
        if (r101 == null) goto L5;
        lvb.a.e("MmNetPushHandler", "unRegisterServerPush command=" + r100 + ", disposable=" + r101);
        r101.dispose();
    L5:
        MutableSharedFlow<?> r102 = this.f433913a.f433911g.remove(r100);
        if (r102 == null) goto L9;
        lvb.a.e("MmNetPushHandler", "unRegisterServerPush command=" + r100 + ", flow=" + r102);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final void d(com.bytedance.lark.pb.basic.v1.Command r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Disposable r101 = this.f433913a.f433908d.remove(r100);
        if (r101 == null) goto L5;
        lvb.a.e("MmNetPushHandler", "unRegisterPush command=" + r100 + ", disposable=" + r101);
        r101.dispose();
    L5:
        MutableSharedFlow<?> r102 = this.f433913a.f433910f.remove(r100);
        if (r102 == null) goto L9;
        lvb.a.e("MmNetPushHandler", "unRegisterPush command=" + r100 + ", flow=" + r102);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final <R> d1<R> a(Command r100, Class<R> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "respType");
        MutableSharedFlow<?> r102 = this.f433913a.f433911g.get(r100);
        if ((r102 instanceof MutableSharedFlow) == false) goto L5;
        MutableSharedFlow<?> r103 = r102;
    L6:
        if (r103 != null) goto L10;
        lvb.a.e("MmNetPushHandler", "registerServerPush new, command=" + r100 + ", respType=" + r101);
        final d r104 = this.f433913a;
        ProtoAdapter r105 = ProtoAdapter.get(r101);
        r104.getClass();
        final MutableSharedFlow<?> r106 = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.SUSPEND);
        Disposable r107 = t.g(r104.f433905a.c(r100, r105), new MmNetPushHandler$transformServerFlow$subtitleDisposable$1(r104, r106), MmNetPushHandler$transformServerFlow$subtitleDisposable$2.INSTANCE);
        r104.f433911g.put(r100, r106);
        r104.f433909e.put(r100, r107);
        return r106;
    L10:
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final <R> d1<R> b(com.bytedance.lark.pb.basic.v1.Command r100, Class<R> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "respType");
        MutableSharedFlow<?> r102 = this.f433913a.f433910f.get(r100);
        if ((r102 instanceof MutableSharedFlow) == false) goto L5;
        MutableSharedFlow<?> r103 = r102;
    L6:
        if (r103 != null) goto L10;
        lvb.a.e("MmNetPushHandler", "registerClientPush new, command=" + r100 + ", respType=" + r101);
        final d r104 = this.f433913a;
        ProtoAdapter r105 = ProtoAdapter.get(r101);
        r104.getClass();
        final MutableSharedFlow<?> r106 = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.SUSPEND);
        Disposable r107 = t.g(r104.f433905a.i(r100, r105), new MmNetPushHandler$transformFlow$subtitleDisposable$1(r104, r106), MmNetPushHandler$transformFlow$subtitleDisposable$2.INSTANCE);
        r104.f433910f.put(r100, r106);
        r104.f433908d.put(r100, r107);
        return r106;
    L10:
        return r103;
    L5:
        r103 = null;
        goto L6
    }
}
