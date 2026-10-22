package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraGRebindOpItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f332664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraTextView f332665b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332664a;
    }

    public LarusDoraGRebindOpItemBinding(LinearLayout r100, DoraTextView r101) {
        this.f332664a = r100;
        this.f332665b = r101;
    }
}
