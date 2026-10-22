package com.larus.livetutor.impl.databinding;

import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveTutorSettingsDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoordinatorLayout f355984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SeekBar f355985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f355986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SeekBar f355987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f355988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f355989f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f355984a;
    }

    public LiveTutorSettingsDialogBinding(CoordinatorLayout r100, SeekBar r101, AppCompatTextView r102, SeekBar r103, AppCompatTextView r104, ItemTextToggle r105, View r106) {
        this.f355984a = r100;
        this.f355985b = r101;
        this.f355986c = r102;
        this.f355987d = r103;
        this.f355988e = r104;
        this.f355989f = r106;
    }
}
