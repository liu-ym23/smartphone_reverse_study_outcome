package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.view.AvatarListView;
import com.larus.common_ui.widget.GradientTextView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemAwemeViewMoreBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f310953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AvatarListView f310954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f310955c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310953a;
    }

    public LarusItemAwemeViewMoreBinding(LinearLayout r100, AvatarListView r101, GradientTextView r102, LinearLayout r103) {
        this.f310953a = r100;
        this.f310954b = r101;
        this.f310955c = r103;
    }
}
