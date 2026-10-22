package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.PromptInputButtonView;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.ReferenceImageContainer;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageBotBgImageGenerateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f317887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f317888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PromptInputButtonView f317889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f317890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f317891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ReferenceImageContainer f317892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NovaTitleBarEx f317893g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317887a;
    }

    public LarusPageBotBgImageGenerateBinding(ConstraintLayout r100, TextView r101, PromptInputButtonView r102, TextView r103, RecyclerView r104, ReferenceImageContainer r105, NovaTitleBarEx r106) {
        this.f317887a = r100;
        this.f317888b = r101;
        this.f317889c = r102;
        this.f317890d = r103;
        this.f317891e = r104;
        this.f317892f = r105;
        this.f317893g = r106;
    }
}
