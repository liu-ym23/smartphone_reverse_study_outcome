package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.standarduikit.clarification.view.InteractionAskAttachmentView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusItemClarificationAnswerDetailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f358685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InteractionAskAttachmentView f358686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f358687d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358684a;
    }

    public LarusItemClarificationAnswerDetailBinding(LinearLayout r100, TextView r101, InteractionAskAttachmentView r102, TextView r103) {
        this.f358684a = r100;
        this.f358685b = r101;
        this.f358686c = r102;
        this.f358687d = r103;
    }
}
