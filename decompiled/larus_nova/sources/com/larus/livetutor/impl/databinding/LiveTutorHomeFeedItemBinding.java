package com.larus.livetutor.impl.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveTutorHomeFeedItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f355969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f355970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f355971c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f355969a;
    }

    public LiveTutorHomeFeedItemBinding(RelativeLayout r100, SimpleDraweeView r101, TextView r102) {
        this.f355969a = r100;
        this.f355970b = r101;
        this.f355971c = r102;
    }
}
