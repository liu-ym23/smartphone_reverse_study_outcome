package com.ss.android.lark.blueprint;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class w<ViewType extends View> implements k<ViewType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewType f410659a;

    @Override // com.ss.android.lark.blueprint.k
    public final ViewType getView() {
        return this.f410659a;
    }

    public w(ViewType r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f410659a = r100;
    }
}
