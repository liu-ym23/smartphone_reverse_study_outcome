package com.larus.feedback.impl.manager;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larus.feedback.impl.gateway.FlowFeedbackRemoteGateway;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import kotlin.jvm.internal.Intrinsics;
import q99.i;

/* JADX INFO: loaded from: classes27.dex */
public final class a extends p99.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f343095b = 0;

    /* JADX INFO: renamed from: com.larus.feedback.impl.manager.a$a, reason: collision with other inner class name */
    public static final class C4310a {
    }

    static {
    }

    public a(FlowFeedbackRemoteGateway r100) {
        Intrinsics.checkNotNullParameter(r100, "gateway");
        super(r100);
    }

    @Override // p99.c
    public final void b(q99.e r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        Intrinsics.checkNotNullParameter(r101, "host");
        super.b(r100, r101);
        t99.a.b(r100.f532147d, r101.f532155d, r100.f532145b, AppConstants.BUNDLE_DISLIKE, r101.f532167p.invoke("feedback_popup_click", r100), 32);
    }

    @Override // p99.c
    public final void c(q99.e r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        Intrinsics.checkNotNullParameter(r101, "host");
        super.c(r100, r101);
        t99.a.b(r100.f532147d, r101.f532155d, r100.f532145b, IStrategyStateSupplier.KEY_INFO_LIKE, r101.f532167p.invoke("feedback_popup_click", r100), 32);
    }

    @Override // p99.c
    public final void d(q99.e r100, i r101, q99.a r102) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        Intrinsics.checkNotNullParameter(r101, "host");
        Intrinsics.checkNotNullParameter(r102, "result");
        t99.a.a(r100.f532147d, r101.f532167p.invoke("complete_dislike_reason", r100));
    }
}
