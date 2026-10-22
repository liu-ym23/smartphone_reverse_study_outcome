package com.larus.business.search.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.widget.LoadingWithRetryView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusFragmentGlobalSearchBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f321219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LoadingWithRetryView f321220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SearchBar f321221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f321222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ScrollView f321223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f321224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f321225g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321219a;
    }

    public LarusFragmentGlobalSearchBinding(RelativeLayout r100, LoadingWithRetryView r101, SearchBar r102, View r103, ScrollView r104, LinearLayout r105, RecyclerView r106) {
        this.f321219a = r100;
        this.f321220b = r101;
        this.f321221c = r102;
        this.f321222d = r103;
        this.f321223e = r104;
        this.f321224f = r105;
        this.f321225g = r106;
    }
}
