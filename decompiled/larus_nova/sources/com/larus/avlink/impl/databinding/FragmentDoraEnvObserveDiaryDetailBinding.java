package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes25.dex */
public final class FragmentDoraEnvObserveDiaryDetailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutCompat f293118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f293119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f293120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f293121d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293118a;
    }

    public FragmentDoraEnvObserveDiaryDetailBinding(LinearLayoutCompat r100, RecyclerView r101, ProgressBar r102, NovaTitleBarEx r103) {
        this.f293118a = r100;
        this.f293119b = r101;
        this.f293120c = r102;
        this.f293121d = r103;
    }
}
