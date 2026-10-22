package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricBlockLocalSearchItemWithRowBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f386074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f386075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f386076c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386074a;
    }

    public ObricBlockLocalSearchItemWithRowBinding(LinearLayout r100, RecyclerView r101, TextView r102) {
        this.f386074a = r100;
        this.f386075b = r101;
        this.f386076c = r102;
    }
}
