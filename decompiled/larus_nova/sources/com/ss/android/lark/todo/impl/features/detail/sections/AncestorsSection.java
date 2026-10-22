package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class AncestorsSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> f443111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f443112d;

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getShowAncestors(), new AncestorsSection$initViewObserver$1$1(this));
        k(r100.getAncestorStatus(), new AncestorsSection$initViewObserver$1$2(this));
    }

    public AncestorsSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r101) {
        Intrinsics.checkNotNullParameter(r100, "ancestorsView");
        Intrinsics.checkNotNullParameter(r101, "viewAbility");
        super(r101);
        this.f443110b = r100;
        this.f443111c = r101;
        this.f443112d = LazyKt.lazy(new AncestorsSection$viewArray$2(this));
    }
}
