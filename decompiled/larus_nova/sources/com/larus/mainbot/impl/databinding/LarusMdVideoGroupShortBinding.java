package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusMdVideoGroupShortBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f358763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MarkdownSourceImageView f358764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f358765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f358766f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358761a;
    }

    public LarusMdVideoGroupShortBinding(LinearLayout r100, SimpleDraweeView r101, SimpleDraweeView r102, MarkdownSourceImageView r103, TextView r104, TextView r105) {
        this.f358761a = r100;
        this.f358762b = r101;
        this.f358763c = r102;
        this.f358764d = r103;
        this.f358765e = r104;
        this.f358766f = r105;
    }
}
