package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraOActivityMemoryEventDetailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f338345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f338346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScrollView f338347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f338348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f338349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OFloatingTitleBar f338350f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f338345a;
    }

    public DoraOActivityMemoryEventDetailBinding(ConstraintLayout r100, TextView r101, ScrollView r102, TextView r103, TextView r104, OFloatingTitleBar r105) {
        this.f338345a = r100;
        this.f338346b = r101;
        this.f338347c = r102;
        this.f338348d = r103;
        this.f338349e = r104;
        this.f338350f = r105;
    }
}
