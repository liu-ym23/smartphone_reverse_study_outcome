package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.TextAnswerSingleActionButton;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutTextMessageActionButtonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f324042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f324043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieAdapterView f324044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f324045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f324046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f324047f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324042a;
    }

    public LarusLayoutTextMessageActionButtonBinding(TextAnswerSingleActionButton r100, SimpleDraweeView r101, LottieAdapterView r102, AppCompatTextView r103, LinearLayout r104, SimpleDraweeView r105) {
        this.f324042a = r100;
        this.f324043b = r101;
        this.f324044c = r102;
        this.f324045d = r103;
        this.f324046e = r104;
        this.f324047f = r105;
    }
}
