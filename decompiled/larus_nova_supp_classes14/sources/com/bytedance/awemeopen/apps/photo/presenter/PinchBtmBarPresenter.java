package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PinchBtmBarPresenter extends f04.a<Unit> {
    public static final /* synthetic */ int h = 0;
    public final a14.a d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    @Override // f04.a
    public final void k() {
    }

    public PinchBtmBarPresenter(a14.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = LazyKt.lazy(new PinchBtmBarPresenter$pagePinchVM$2(this));
        this.f = LazyKt.lazy(new PinchBtmBarPresenter$view$2(this));
        this.g = LazyKt.lazy(new PinchBtmBarPresenter$vClose$2(this));
    }

    @Override // f04.a
    public final void j(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        ((View) this.f.getValue()).setOnClickListener(new c1());
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c r3 = new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c();
        View r0 = (View) this.g.getValue();
        r0.setOnTouchListener(r3);
        r0.setOnClickListener(new d1(r0, this));
    }
}
