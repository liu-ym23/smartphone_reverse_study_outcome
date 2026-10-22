package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardItemDownloadAppV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f386094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OButton f386095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f386096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f386097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f386098e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386094a;
    }

    public ObricCardItemDownloadAppV2Binding(ConstraintLayout r100, OButton r101, SimpleDraweeView r102, TextView r103, TextView r104) {
        this.f386094a = r100;
        this.f386095b = r101;
        this.f386096c = r102;
        this.f386097d = r103;
        this.f386098e = r104;
    }
}
