package com.bytedance.locallife.dito.provider;

import android.content.Context;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.m;
import com.bytedance.locallife.dito.data.r;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, r> f258671a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.dito.provider.h
    public final Map<String, r> a() {
        return this.f258671a;
    }

    public d(int r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "ditoViewMap");
        this.f258671a = r101;
        com.bytedance.locallife.dito.a.a("DitoSpiViewProvider", new DitoSpiViewProvider$1(this));
    }

    @Override // com.bytedance.locallife.dito.provider.h
    public final BaseDitoModel<?> c(DitoViewModel r100, m r101) {
        return h.a.a(this, r100, r101);
    }

    @Override // com.bytedance.locallife.dito.provider.h
    public final BaseDitoView<?> b(Context r100, m r101, DitoViewModel r102, BaseDitoModel<?> r103) {
        return h.a.b(this, r100, r101, r102, r103);
    }
}
