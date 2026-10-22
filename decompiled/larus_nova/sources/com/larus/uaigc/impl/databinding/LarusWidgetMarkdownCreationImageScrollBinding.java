package com.larus.uaigc.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusWidgetMarkdownCreationImageScrollBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f373265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f373266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageCardNestedScrollableHost f373267c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373265a;
    }

    public LarusWidgetMarkdownCreationImageScrollBinding(ConstraintLayout r100, RecyclerView r101, ImageCardNestedScrollableHost r102) {
        this.f373265a = r100;
        this.f373266b = r101;
        this.f373267c = r102;
    }
}
