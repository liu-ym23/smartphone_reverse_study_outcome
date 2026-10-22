package com.bytedance.lark.sdk.refactor;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.sdk.InvokeResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class RustCommunicator implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f254213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<i> f254214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.lark.sdk.refactor.state.i f254215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RustBarrier f254216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f254217e;

    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RustCommunicator f254218a;

        public a(RustCommunicator r100) {
            this.f254218a = r100;
        }

        @Override // com.bytedance.lark.sdk.refactor.h
        public final void v(q r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Iterator r101 = CollectionsKt.toList(this.f254218a.f254214b).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((i) r101.next()).v(r100);
            goto L4
        }

        @Override // com.bytedance.lark.sdk.refactor.h
        public final void y(b r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Iterator r101 = CollectionsKt.toList(this.f254218a.f254214b).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((i) r101.next()).y(r100);
            goto L4
        }
    }

    @Override // com.bytedance.lark.sdk.refactor.k
    public final r o() {
        return this.f254217e;
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final void j(se6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        this.f254216d.j(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final int p(InitSDKRequest.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "requestBuilder");
        return this.f254216d.p(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final InvokeResponse r(se6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return this.f254216d.r(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void v(q r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f254216d.v(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void y(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f254216d.y(r100);
    }

    public RustCommunicator(Context r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "definition");
        this.f254213a = r101;
        this.f254214b = new CopyOnWriteArrayList();
        com.bytedance.lark.sdk.refactor.state.i r102 = new com.bytedance.lark.sdk.refactor.state.i(new c(r100, new a(this), r101.f()));
        this.f254215c = r102;
        this.f254216d = new RustBarrier(r102, new RustCommunicator$barrier$1(r101));
        this.f254217e = new r(this, r101.g(), r101.c());
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final int l(String r100, byte[] r101) {
        return this.f254216d.l(r100, r101);
    }
}
