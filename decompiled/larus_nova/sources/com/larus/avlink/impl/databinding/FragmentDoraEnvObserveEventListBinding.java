package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.avlink.record.ui.RecordMinutesLoadingOrRetryView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;

/* JADX INFO: loaded from: classes25.dex */
public final class FragmentDoraEnvObserveEventListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutCompat f293140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f293141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SuperSwipeRefreshLayout f293142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f293143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecordMinutesLoadingOrRetryView f293144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NovaTitleBarEx f293145f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293140a;
    }

    public FragmentDoraEnvObserveEventListBinding(LinearLayoutCompat r100, RecyclerView r101, SuperSwipeRefreshLayout r102, TextView r103, RecordMinutesLoadingOrRetryView r104, NovaTitleBarEx r105) {
        this.f293140a = r100;
        this.f293141b = r101;
        this.f293142c = r102;
        this.f293143d = r103;
        this.f293144e = r104;
        this.f293145f = r105;
    }
}
