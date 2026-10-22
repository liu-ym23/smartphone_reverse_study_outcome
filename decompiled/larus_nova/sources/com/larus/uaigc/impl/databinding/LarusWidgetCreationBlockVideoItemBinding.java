package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusWidgetCreationBlockVideoItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f373260a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373260a;
    }

    public LarusWidgetCreationBlockVideoItemBinding(ConstraintLayout r100) {
        this.f373260a = r100;
    }

    public static LarusWidgetCreationBlockVideoItemBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_widget_creation_block_video_item, r101, false);
        if (r102 == null) goto L7;
        return new LarusWidgetCreationBlockVideoItemBinding((ConstraintLayout) r102);
    L7:
        throw new NullPointerException("rootView");
    }
}
