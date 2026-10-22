package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDialogInputBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f326671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f326672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f326673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EditText f326674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f326675e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326671a;
    }

    public LarusDialogInputBinding(LinearLayout r100, TextView r101, TextView r102, EditText r103, TextView r104) {
        this.f326671a = r100;
        this.f326672b = r101;
        this.f326673c = r102;
        this.f326674d = r103;
        this.f326675e = r104;
    }
}
