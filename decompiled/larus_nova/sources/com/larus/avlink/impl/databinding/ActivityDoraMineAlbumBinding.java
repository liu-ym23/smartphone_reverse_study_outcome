package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes25.dex */
public final class ActivityDoraMineAlbumBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutCompat f293104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f293105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f293106c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293104a;
    }

    public ActivityDoraMineAlbumBinding(LinearLayoutCompat r100, FrameLayout r101, NovaTitleBarEx r102) {
        this.f293104a = r100;
        this.f293105b = r101;
        this.f293106c = r102;
    }
}
