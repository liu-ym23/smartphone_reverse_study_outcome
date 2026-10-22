package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.standarduikit.clarification.view.InteractionAskAttachmentView;
import ij8.i;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusInteractionAskBlockViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InteractionAskAttachmentView f358658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f358659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f358660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f358661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f358662f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358657a;
    }

    public LarusInteractionAskBlockViewBinding(i r100, InteractionAskAttachmentView r101, LinearLayout r102, AppCompatImageView r103, LinearLayout r104, TextView r105) {
        this.f358657a = r100;
        this.f358658b = r101;
        this.f358659c = r102;
        this.f358660d = r103;
        this.f358661e = r104;
        this.f358662f = r105;
    }
}
