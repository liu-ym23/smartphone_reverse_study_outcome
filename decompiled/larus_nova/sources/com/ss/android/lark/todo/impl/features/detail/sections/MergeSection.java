package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class MergeSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> f443253c;

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        k(e().getReferResourceLv(), new MergeSection$initViewObserver$1$1(this));
    }

    public MergeSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r101) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "viewAbility");
        super(r101);
        this.f443252b = r100;
        this.f443253c = r101;
    }
}
