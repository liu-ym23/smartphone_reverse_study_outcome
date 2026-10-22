package qn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements a.InterfaceC7365a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f533989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ pn0.d f533990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ pn0.g f533991c;

    @Override // qn0.a.InterfaceC7365a
    public final void a(LayoutConfigModel r100) {
        Intrinsics.checkNotNullParameter(r100, "uiLayoutConfig");
        this.f533989a.d(this.f533990b.e(), "onSuccess, load layoutConfig from geckoOffline success!");
        sn0.a r101 = this.f533989a.f533981a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(this.f533990b, this.f533991c, r100, ProducerResStep.GeckoOffline);
    }

    @Override // qn0.a.InterfaceC7365a
    public final void onFailed(Throwable r100) {
        this.f533989a.d(this.f533990b.e(), "GeckoOfflineResProducer#onFailed, throwable = " + r100);
        sn0.a r101 = this.f533989a.f533981a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.c(this.f533990b, this.f533991c);
    }

    public c(a r100, pn0.d r101, pn0.g r102) {
        this.f533989a = r100;
        this.f533990b = r101;
        this.f533991c = r102;
    }
}
