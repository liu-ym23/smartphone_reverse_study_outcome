package com.larus.mainbot.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusMdImageGroupJoin3Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CardView f358723a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358723a;
    }

    public LarusMdImageGroupJoin3Binding(CardView r100, SimpleDraweeView r101, AppCompatTextView r102, SimpleDraweeView r103, SimpleDraweeView r104, MarkdownSourceImageView r105) {
        this.f358723a = r100;
    }
}
