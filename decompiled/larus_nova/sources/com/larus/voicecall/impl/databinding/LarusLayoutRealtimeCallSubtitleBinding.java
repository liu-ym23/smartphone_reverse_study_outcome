package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.FastScrollButton;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusLayoutRealtimeCallSubtitleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f378298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f378299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f378300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FastScrollButton f378301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f378302e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378298a;
    }

    public LarusLayoutRealtimeCallSubtitleBinding(View r100, View r101, RecyclerView r102, FastScrollButton r103, TextView r104) {
        this.f378298a = r100;
        this.f378299b = r101;
        this.f378300c = r102;
        this.f378301d = r103;
        this.f378302e = r104;
    }
}
