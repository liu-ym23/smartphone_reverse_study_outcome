package com.ss.android.lark.blueprint;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class b<ViewBindingType extends ViewBinding> implements k<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewBindingType f410635a;

    @Override // com.ss.android.lark.blueprint.k
    public final View getView() {
        return this.f410635a.getRoot();
    }

    public b(ViewBindingType r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        this.f410635a = r100;
    }
}
