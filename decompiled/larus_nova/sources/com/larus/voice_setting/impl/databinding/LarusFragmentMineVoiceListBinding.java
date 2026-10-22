package com.larus.voice_setting.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusFragmentMineVoiceListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f376098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusMyVoiceListEmptyBinding f376099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusVoiceListErrorBinding f376100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NestedScrollView f376101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f376102e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f376098a;
    }

    public static LarusFragmentMineVoiceListBinding a(LayoutInflater r110, ViewGroup r111) {
        View r112 = r110.inflate(R.layout.larus_fragment_mine_voice_list, r111, false);
        int r113 = R.id.voice_empty;
        View r100 = ViewBindings.findChildViewById(r112, R.id.voice_empty);
        if (r100 == null) goto L25;
        ConstraintLayout r114 = (ConstraintLayout) r100;
        int r101 = R.id.voice_empty_icon;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.voice_empty_icon);
        if (r102 == null) goto L23;
        r101 = R.id.voice_empty_text;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.voice_empty_text);
        if (r103 == null) goto L23;
        LarusMyVoiceListEmptyBinding r104 = new LarusMyVoiceListEmptyBinding(r114, r114, r102, r103);
        r113 = R.id.voice_error;
        View r105 = ViewBindings.findChildViewById(r112, R.id.voice_error);
        if (r105 == null) goto L25;
        int r115 = R.id.profile_info_error_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r105, R.id.profile_info_error_icon)) == null) goto L21;
        r115 = R.id.profile_info_error_text;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r105, R.id.profile_info_error_text)) == null) goto L21;
        ConstraintLayout r106 = (ConstraintLayout) r105;
        LarusVoiceListErrorBinding r107 = new LarusVoiceListErrorBinding(r106, r106);
        r113 = R.id.voice_exception_view;
        NestedScrollView r108 = (NestedScrollView) ViewBindings.findChildViewById(r112, R.id.voice_exception_view);
        if (r108 == null) goto L25;
        r113 = R.id.voice_recycler;
        RecyclerView r116 = (RecyclerView) ViewBindings.findChildViewById(r112, R.id.voice_recycler);
        if (r116 == null) goto L25;
        return new LarusFragmentMineVoiceListBinding((ConstraintLayout) r112, r104, r107, r108, r116);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r105.getResources().getResourceName(r115)));
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    public LarusFragmentMineVoiceListBinding(ConstraintLayout r100, LarusMyVoiceListEmptyBinding r101, LarusVoiceListErrorBinding r102, NestedScrollView r103, RecyclerView r104) {
        this.f376098a = r100;
        this.f376099b = r101;
        this.f376100c = r102;
        this.f376101d = r103;
        this.f376102e = r104;
    }
}
