package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageModelSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f311236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f311237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f311238c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311236a;
    }

    public LarusPageModelSettingsBinding(LinearLayout r100, RecyclerView r101, NovaTitleBarEx r102) {
        this.f311236a = r100;
        this.f311237b = r101;
        this.f311238c = r102;
    }
}
