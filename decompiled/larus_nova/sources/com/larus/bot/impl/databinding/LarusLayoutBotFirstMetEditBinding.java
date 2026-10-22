package com.larus.bot.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bot.impl.feature.edit.feature.firstmet.tts.BotCreateTtsPlayerView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutBotFirstMetEditBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f317863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatEditText f317864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusBotCreateDescSkeletonBinding f317865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f317866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f317867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ItemTextArrow f317868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BotCreateTtsPlayerView f317869g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317863a;
    }

    public LarusLayoutBotFirstMetEditBinding(ConstraintLayout r100, AppCompatEditText r101, LarusBotCreateDescSkeletonBinding r102, View r103, AppCompatTextView r104, ItemTextArrow r105, BotCreateTtsPlayerView r106) {
        this.f317863a = r100;
        this.f317864b = r101;
        this.f317865c = r102;
        this.f317866d = r103;
        this.f317867e = r104;
        this.f317868f = r105;
        this.f317869g = r106;
    }
}
