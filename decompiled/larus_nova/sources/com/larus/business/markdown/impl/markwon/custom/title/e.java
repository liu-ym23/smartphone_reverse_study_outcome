package com.larus.business.markdown.impl.markwon.custom.title;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.jvm.internal.Intrinsics;
import lsc.h;
import lsc.t;
import lsc.u;
import lsc.x;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f320681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f320682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f320683c;

    @Override // lsc.x
    public final Object a(h r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        u r102 = (u) r101;
        return new d(r100.f510591a, this.f320682b, this.f320681a, (Integer) r102.a(f.f320684a), this.f320683c);
    }

    public e(int r100, float r101, int r102) {
        this.f320681a = r100;
        this.f320682b = r101;
        this.f320683c = r102;
    }
}
