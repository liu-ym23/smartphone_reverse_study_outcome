package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraODialogDiaryStyleInputBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f338351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f338352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f338353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EditText f338354d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f338351a;
    }

    public DoraODialogDiaryStyleInputBinding(LinearLayout r100, EditText r101, TextView r102, EditText r103) {
        this.f338351a = r100;
        this.f338352b = r101;
        this.f338353c = r102;
        this.f338354d = r103;
    }
}
