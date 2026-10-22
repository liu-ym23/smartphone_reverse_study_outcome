package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.layout.widget.AtMostHeightLinearLayout;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusMdThinkEmphasizeSearchReferenceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtMostHeightLinearLayout f358754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtMostHeightLinearLayout f358755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f358756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtMostHeightRecyclerView f358757d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358754a;
    }

    public LarusMdThinkEmphasizeSearchReferenceBinding(AtMostHeightLinearLayout r100, DeepThinkCommonToolHeader r101, AtMostHeightLinearLayout r102, TextView r103, AtMostHeightRecyclerView r104) {
        this.f358754a = r100;
        this.f358755b = r102;
        this.f358756c = r103;
        this.f358757d = r104;
    }
}
