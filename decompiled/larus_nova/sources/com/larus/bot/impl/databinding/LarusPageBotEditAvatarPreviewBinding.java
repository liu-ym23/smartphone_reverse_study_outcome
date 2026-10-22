package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ChatCheckBox;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget.BotBgImagePreviewView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageBotEditAvatarPreviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f317919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f317920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f317921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f317922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BotBgImagePreviewView f317923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f317924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ChatCheckBox f317925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f317926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f317927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NovaTitleBarEx f317928j;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317919a;
    }

    public LarusPageBotEditAvatarPreviewBinding(ConstraintLayout r100, SimpleDraweeView r101, FrameLayout r102, ProgressBar r103, BotBgImagePreviewView r104, TextView r105, ChatCheckBox r106, LinearLayout r107, TextView r108, NovaTitleBarEx r110) {
        this.f317919a = r100;
        this.f317920b = r101;
        this.f317921c = r102;
        this.f317922d = r103;
        this.f317923e = r104;
        this.f317924f = r105;
        this.f317925g = r106;
        this.f317926h = r107;
        this.f317927i = r108;
        this.f317928j = r110;
    }
}
