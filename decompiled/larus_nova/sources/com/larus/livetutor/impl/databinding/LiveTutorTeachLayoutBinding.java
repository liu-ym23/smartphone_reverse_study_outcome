package com.larus.livetutor.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.venus.ShapeLinearLayout;
import com.larus.livetutor.impl.view.LiveTutorVoiceView;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveTutorTeachLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f355990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f355991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShapeLinearLayout f355992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f355993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f355994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LiveTutorVoiceView f355995f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f355990a;
    }

    public LiveTutorTeachLayoutBinding(View r100, FrameLayout r101, ShapeLinearLayout r102, ImageView r103, FrameLayout r104, LiveTutorVoiceView r105) {
        this.f355990a = r100;
        this.f355991b = r101;
        this.f355992c = r102;
        this.f355993d = r103;
        this.f355994e = r104;
        this.f355995f = r105;
    }
}
