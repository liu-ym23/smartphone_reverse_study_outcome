package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDialogNlApplistBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundConstraintLayout f332466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f332467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f332468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f332469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f332470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EditText f332471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NovaTitleBarEx f332472g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332466a;
    }

    public LarusDoraDialogNlApplistBinding(RoundConstraintLayout r100, AppCompatTextView r101, LinearLayout r102, RecyclerView r103, AppCompatTextView r104, EditText r105, NovaTitleBarEx r106) {
        this.f332466a = r100;
        this.f332467b = r101;
        this.f332468c = r102;
        this.f332469d = r103;
        this.f332470e = r104;
        this.f332471f = r105;
        this.f332472g = r106;
    }
}
