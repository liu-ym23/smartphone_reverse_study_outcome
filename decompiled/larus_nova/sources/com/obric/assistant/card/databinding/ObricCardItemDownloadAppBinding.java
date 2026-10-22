package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardItemDownloadAppBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundRelativeLayout f386090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f386091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f386092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OButton f386093d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386090a;
    }

    public ObricCardItemDownloadAppBinding(RoundRelativeLayout r100, SimpleDraweeView r101, TextView r102, OButton r103) {
        this.f386090a = r100;
        this.f386091b = r101;
        this.f386092c = r102;
        this.f386093d = r103;
    }
}
