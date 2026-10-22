package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.os.SystemClock;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.google.gson.internal.LinkedTreeMap;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TopNavigationComponentV1$dependency$1 implements a0 {
    public final /* synthetic */ TopNavigationComponentV1 a;

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.l, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.k
    public final CommonMeta a() {
        return this.a.O1().d().getData().a().a();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final LinkedTreeMap<String, Object> b() {
        PageMeta r0 = (PageMeta) this.a.O1().d().getData().b.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTrackMeta();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final V4NativeParams c() {
        return this.a.g2().getNativeParams();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final CompositeDisposable compositeDisposable() {
        return this.a.n;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final boolean e() {
        return this.a.g2().getNativeParams().getFullMode();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.l
    public final String getSessionId() {
        return this.a.g2().getSessionId();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final boolean isExpanded() {
        return !Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).b.d.a(), Boolean.FALSE);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final boolean n() {
        return this.a.O1().b().e0();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final long p() {
        return this.a.v;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.l, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.k
    public final long getDuration() {
        return SystemClock.uptimeMillis() - this.a.v;
    }

    public TopNavigationComponentV1$dependency$1(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.l, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.k
    public final void d(Function1<? super vg3.z, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "function");
        this.a.Z1(vg3.w.class, new TopNavigationComponentV1$dependency$1$tracker$1(r5, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final void o(String r3) {
        Intrinsics.checkNotNullParameter("share_with_head", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.O1().a().appendEventParamToEntranceInfo("share_with_head", r3);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final void openSchema(String r3) {
        if (r3 == null) goto L7;
        f0 r0 = (f0) this.a.N1(f0.class);
        if (r0 == null) goto L8;
        r0.openSchema(r3);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final void s(boolean r2) {
        TopNavigationComponentV1 r0 = this.a;
        r0.o = Boolean.valueOf(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final void t(com.bytedance.android.shopping.prepurchase.arch.container.ability.b r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        this.a.O1().b().e1(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.l
    public final void u(String r5) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        this.a.Z1(vg3.w.class, new TopNavigationComponentV1$dependency$1$logLubanV1$1(r5, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.a0
    public final void q(com.bytedance.android.shopping.anchorv4.log.d r5, Object r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "watcher");
        Intrinsics.checkNotNullParameter(r6, "identifier");
        this.a.Z1(vg3.m.class, new TopNavigationComponentV1$dependency$1$attachWatch$1(r5, r6, r7, null));
    }
}
