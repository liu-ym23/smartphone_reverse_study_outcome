package com.larus.profile.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.larus.profile.impl.view.BotProfileView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemProfileBotBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f366470a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366470a;
    }

    public LarusItemProfileBotBinding(FrameLayout r100) {
        this.f366470a = r100;
    }

    public static LarusItemProfileBotBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_profile_bot, r101, false);
        if (((BotProfileView) ViewBindings.findChildViewById(r102, R.id.bot_profile)) == null) goto L7;
        return new LarusItemProfileBotBinding((FrameLayout) r102);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.bot_profile)));
    }
}
