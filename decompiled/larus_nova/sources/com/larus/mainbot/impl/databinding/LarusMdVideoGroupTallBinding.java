package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusMdVideoGroupTallBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f358769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MarkdownSourceImageView f358770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f358771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f358772f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358767a;
    }

    public LarusMdVideoGroupTallBinding(LinearLayout r100, SimpleDraweeView r101, SimpleDraweeView r102, MarkdownSourceImageView r103, TextView r104, TextView r105) {
        this.f358767a = r100;
        this.f358768b = r101;
        this.f358769c = r102;
        this.f358770d = r103;
        this.f358771e = r104;
        this.f358772f = r105;
    }
}
