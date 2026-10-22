package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardItemStyleScheduleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f386149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f386150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f386151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f386152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f386153e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386149a;
    }

    public ObricCardItemStyleScheduleBinding(ConstraintLayout r100, SimpleDraweeView r101, TextView r102, TextView r103, TextView r104) {
        this.f386149a = r100;
        this.f386150b = r101;
        this.f386151c = r102;
        this.f386152d = r103;
        this.f386153e = r104;
    }
}
