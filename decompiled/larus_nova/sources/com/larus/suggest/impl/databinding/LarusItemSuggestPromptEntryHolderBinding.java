package com.larus.suggest.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemSuggestPromptEntryHolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f369816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f369817b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f369816a;
    }

    public LarusItemSuggestPromptEntryHolderBinding(LinearLayout r100, SimpleDraweeView r101, TextView r102) {
        this.f369816a = r100;
        this.f369817b = r102;
    }
}
