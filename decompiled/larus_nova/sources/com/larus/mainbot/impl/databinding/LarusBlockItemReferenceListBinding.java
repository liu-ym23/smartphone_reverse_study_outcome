package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockItemReferenceListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f358492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtMostHeightRecyclerView f358493d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358490a;
    }

    public LarusBlockItemReferenceListBinding(LinearLayout r100, SimpleDraweeView r101, TextView r102, AtMostHeightRecyclerView r103) {
        this.f358490a = r100;
        this.f358491b = r101;
        this.f358492c = r102;
        this.f358493d = r103;
    }
}
