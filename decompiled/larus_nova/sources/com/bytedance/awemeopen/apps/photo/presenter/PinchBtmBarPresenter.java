package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class PinchBtmBarPresenter extends f04.a<Unit> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f197931h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a14.a f197932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f197933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f197934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f197935g;

    @Override // f04.a
    public final void k() {
    }

    public PinchBtmBarPresenter(a14.a r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f1367b);
        this.f197932d = r100;
        this.f197933e = LazyKt.lazy(new PinchBtmBarPresenter$pagePinchVM$2(this));
        this.f197934f = LazyKt.lazy(new PinchBtmBarPresenter$view$2(this));
        this.f197935g = LazyKt.lazy(new PinchBtmBarPresenter$vClose$2(this));
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ((View) this.f197934f.getValue()).setOnClickListener(new c1());
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c r101 = new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c();
        View r102 = (View) this.f197935g.getValue();
        r102.setOnTouchListener(r101);
        r102.setOnClickListener(new d1(r102, this));
    }
}
