package com.bytedance.kmp.ec.yata.view.render.delegate.v1;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.r;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f252023a;

    public b(r r100) {
        Intrinsics.checkNotNullParameter(r100, "viewInfo");
        this.f252023a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.delegate.v1.a
    public final void setExtra(Map<String, ? extends Object> r100) {
        this.f252023a.f50699a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.delegate.v1.a
    public final void a(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Map<String, ? extends Object> r102 = SliceRender.a(r100);
        this.f252023a.a(r102, r101);
    }
}
