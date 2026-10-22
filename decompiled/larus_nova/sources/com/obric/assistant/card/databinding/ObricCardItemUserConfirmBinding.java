package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardItemUserConfirmBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundRelativeLayout f386180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f386181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f386182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f386183d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386180a;
    }

    public ObricCardItemUserConfirmBinding(RoundRelativeLayout r100, LinearLayout r101, TextView r102, TextView r103) {
        this.f386180a = r100;
        this.f386181b = r101;
        this.f386182c = r102;
        this.f386183d = r103;
    }
}
