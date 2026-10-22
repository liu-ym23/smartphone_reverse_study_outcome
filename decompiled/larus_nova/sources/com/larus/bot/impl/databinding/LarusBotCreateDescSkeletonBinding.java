package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusBotCreateDescSkeletonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f317714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f317715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f317716c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317714a;
    }

    public static LarusBotCreateDescSkeletonBinding a(View r100) {
        int r101 = R.id.skeleton_1;
        View r102 = ViewBindings.findChildViewById(r100, R.id.skeleton_1);
        if (r102 == null) goto L9;
        r101 = R.id.skeleton_2;
        View r103 = ViewBindings.findChildViewById(r100, R.id.skeleton_2);
        if (r103 == null) goto L9;
        return new LarusBotCreateDescSkeletonBinding((LinearLayout) r100, r102, r103);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusBotCreateDescSkeletonBinding(LinearLayout r100, View r101, View r102) {
        this.f317714a = r100;
        this.f317715b = r101;
        this.f317716c = r102;
    }
}
