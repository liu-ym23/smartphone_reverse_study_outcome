package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricBlockLocalSearchItemWithRowImageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundRelativeLayout f386077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f386078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f386079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f386080d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386077a;
    }

    public ObricBlockLocalSearchItemWithRowImageBinding(RoundRelativeLayout r100, SimpleDraweeView r101, TextView r102, View r103) {
        this.f386077a = r100;
        this.f386078b = r101;
        this.f386079c = r102;
        this.f386080d = r103;
    }
}
