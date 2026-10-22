package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusDialogPersonalMemoryEditBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f293189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f293190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f293191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f293192e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293188a;
    }

    public LarusDialogPersonalMemoryEditBinding(ConstraintLayout r100, EditText r101, TextView r102, TextView r103, TextView r104) {
        this.f293188a = r100;
        this.f293189b = r101;
        this.f293190c = r102;
        this.f293191d = r103;
        this.f293192e = r104;
    }
}
