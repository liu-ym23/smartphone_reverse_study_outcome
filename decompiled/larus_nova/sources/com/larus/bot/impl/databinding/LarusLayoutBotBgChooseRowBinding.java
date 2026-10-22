package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutBotBgChooseRowBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f317817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f317818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusLayoutAiGenBgChooseCheckBoxBinding f317819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f317820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LarusLayoutAiGenBgChooseCheckBoxBinding f317821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f317822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LarusLayoutAiGenBgChooseCheckBoxBinding f317823g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317817a;
    }

    public static LarusLayoutBotBgChooseRowBinding a(View r110) {
        int r100 = R.id.center;
        SimpleDraweeView r101 = (SimpleDraweeView) ViewBindings.findChildViewById(r110, R.id.center);
        if (r101 == null) goto L17;
        r100 = R.id.center_check_box;
        View r102 = ViewBindings.findChildViewById(r110, R.id.center_check_box);
        if (r102 == null) goto L17;
        LarusLayoutAiGenBgChooseCheckBoxBinding r103 = LarusLayoutAiGenBgChooseCheckBoxBinding.a(r102);
        r100 = R.id.left;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r110, R.id.left);
        if (r104 == null) goto L17;
        r100 = R.id.left_check_box;
        View r105 = ViewBindings.findChildViewById(r110, R.id.left_check_box);
        if (r105 == null) goto L17;
        LarusLayoutAiGenBgChooseCheckBoxBinding r106 = LarusLayoutAiGenBgChooseCheckBoxBinding.a(r105);
        r100 = R.id.right;
        SimpleDraweeView r107 = (SimpleDraweeView) ViewBindings.findChildViewById(r110, R.id.right);
        if (r107 == null) goto L17;
        r100 = R.id.right_check_box;
        View r108 = ViewBindings.findChildViewById(r110, R.id.right_check_box);
        if (r108 == null) goto L17;
        LinearLayout r109 = (LinearLayout) r110;
        return new LarusLayoutBotBgChooseRowBinding(r109, r101, r103, r104, r106, r107, LarusLayoutAiGenBgChooseCheckBoxBinding.a(r108));
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public LarusLayoutBotBgChooseRowBinding(LinearLayout r100, SimpleDraweeView r101, LarusLayoutAiGenBgChooseCheckBoxBinding r102, SimpleDraweeView r103, LarusLayoutAiGenBgChooseCheckBoxBinding r104, SimpleDraweeView r105, LarusLayoutAiGenBgChooseCheckBoxBinding r106) {
        this.f317817a = r100;
        this.f317818b = r101;
        this.f317819c = r102;
        this.f317820d = r103;
        this.f317821e = r104;
        this.f317822f = r105;
        this.f317823g = r106;
    }
}
