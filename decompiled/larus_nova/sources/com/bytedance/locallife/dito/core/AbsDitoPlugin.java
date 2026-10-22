package com.bytedance.locallife.dito.core;

import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/core/AbsDitoPlugin;", "Lcom/bytedance/locallife/dito/core/d0;", "<init>", "()V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsDitoPlugin implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DitoViewModel f257746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f257747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DitoFragment f257748c;

    public final DitoDataCenter e() {
        return (DitoDataCenter) this.f257747b.getValue();
    }

    public final DitoFragment f() {
        DitoFragment r100 = this.f257748c;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.f257746a == null) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        this.f257748c = g().f258035a;
    L12:
        return this.f257748c;
    L8:
        r101 = false;
        goto L9
    }

    public final DitoViewModel g() {
        DitoViewModel r100 = this.f257746a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public AbsDitoPlugin() {
        this.f257747b = LazyKt.lazy(new AbsDitoPlugin$dataCenter$2(this));
    }

    @Override // com.bytedance.locallife.dito.core.d0
    public String getName() {
        return getClass().getName();
    }

    public void h() {
        g().f258046l.b(new ArrayList());
    }

    @Override // com.bytedance.locallife.dito.core.d0
    public void c(DitoViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "ditoViewModel");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f257746a = r100;
        DitoViewModel r101 = g();
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f257746a = r101;
        h();
    }
}
