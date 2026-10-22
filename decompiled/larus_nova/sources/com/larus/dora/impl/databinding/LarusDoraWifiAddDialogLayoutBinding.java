package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraWifiAddDialogLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f333319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraTextView f333320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraTextView f333321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f333322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatEditText f333323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f333324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ItemGroupTitle f333325g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333319a;
    }

    public LarusDoraWifiAddDialogLayoutBinding(LinearLayout r100, DoraTextView r101, DoraTextView r102, ProgressBar r103, AppCompatEditText r104, ImageView r105, ItemGroupTitle r106) {
        this.f333319a = r100;
        this.f333320b = r101;
        this.f333321c = r102;
        this.f333322d = r103;
        this.f333323e = r104;
        this.f333324f = r105;
        this.f333325g = r106;
    }
}
