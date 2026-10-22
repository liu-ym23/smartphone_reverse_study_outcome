package com.larus.setting.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusPageBlockListSettingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f368163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f368164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f368165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f368166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NovaTitleBarEx f368167e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368163a;
    }

    public LarusPageBlockListSettingBinding(LinearLayout r100, TextView r101, RecyclerView r102, LinearLayout r103, NovaTitleBarEx r104) {
        this.f368163a = r100;
        this.f368164b = r101;
        this.f368165c = r102;
        this.f368166d = r103;
        this.f368167e = r104;
    }
}
