package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageBgImageNewUserGuideBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f317882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f317883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f317884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f317885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NovaTitleBarEx f317886e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317882a;
    }

    public LarusPageBgImageNewUserGuideBinding(ConstraintLayout r100, View r101, SimpleDraweeView r102, TextView r103, NovaTitleBarEx r104) {
        this.f317882a = r100;
        this.f317883b = r101;
        this.f317884c = r102;
        this.f317885d = r103;
        this.f317886e = r104;
    }
}
