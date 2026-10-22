package sn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f542633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ pn0.d f542634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ pn0.g f542635c;

    @Override // sn0.b.a
    public final void a(LayoutConfigModel r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutConfig");
        this.f542633a.d(this.f542634b.e(), "onSuccess, load layoutConfig from geckoOffline success!");
        a r101 = this.f542633a.f542618a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(this.f542634b, this.f542635c, r100, ProducerResStep.GeckoOffline);
    }

    @Override // sn0.b.a
    public final void onFailed(Throwable r100) {
        this.f542633a.d(this.f542634b.e(), "GeckoOfflineResProducer#onFailed, throwable = " + r100);
        a r101 = this.f542633a.f542618a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.c(this.f542634b, this.f542635c);
    }

    public f(b r100, pn0.d r101, pn0.g r102) {
        this.f542633a = r100;
        this.f542634b = r101;
        this.f542635c = r102;
    }
}
