package com.larus.chat.search.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.widget.LoadingWithRetryView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusFragmentChatSearchBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f325570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LoadingWithRetryView f325571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SearchBar f325572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScrollView f325573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f325574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f325575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f325576g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f325570a;
    }

    public LarusFragmentChatSearchBinding(RelativeLayout r100, LoadingWithRetryView r101, SearchBar r102, ScrollView r103, LinearLayout r104, RecyclerView r105, RecyclerView r106) {
        this.f325570a = r100;
        this.f325571b = r101;
        this.f325572c = r102;
        this.f325573d = r103;
        this.f325574e = r104;
        this.f325575f = r105;
        this.f325576g = r106;
    }
}
