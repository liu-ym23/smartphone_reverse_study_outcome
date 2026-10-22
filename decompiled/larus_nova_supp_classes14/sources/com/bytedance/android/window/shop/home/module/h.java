package com.bytedance.android.window.shop.home.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.presenter.ECWindowCroppedStyleAnimationPresenter;
import com.bytedance.android.window.shop.home.presenter.ECWindowCroppedStyleBackGroundPresenter;
import com.bytedance.android.window.shop.home.presenter.ECWindowCroppedStyleRootPresenter;
import com.bytedance.android.window.shop.home.presenter.ECWindowCroppedStyleRootPresenterV2;
import com.bytedance.android.window.shop.home.presenter.ECWindowDialogFloatLivePresenter;
import com.bytedance.android.window.shop.home.presenter.ECWindowDialogStyleRootPresenter;
import com.bytedance.android.window.shop.home.presenter.ECWindowDialogStyledBackgroundPresenter;
import com.bytedance.android.window.shop.home.presenter.ECWindowRootPresenter;
import com.bytedance.android.window.shop.home.presenter.ECWindowTopInfoBarEnhancedPresenter;
import com.bytedance.android.window.shop.home.presenter.ECWindowTopInfoBarPresenter;
import com.bytedance.android.window.shop.home.presenter.t0;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zq3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends a {
    public final boolean m;
    public final boolean n;
    public final Function0<Integer> o;

    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        if (this.m == false) goto L9;
        r0.a(new ECWindowDialogFloatLivePresenter());
        if (this.n == false) goto L7;
        r0.a(new ECWindowCroppedStyleRootPresenterV2());
        r0.a(new ECWindowCroppedStyleAnimationPresenter());
        r0.a(new ECWindowCroppedStyleBackGroundPresenter());
    L8:
        r0.a(new ECWindowDialogStyleRootPresenter());
    L11:
        if (l.b() == false) goto L13;
        r0.a(new ECWindowTopInfoBarEnhancedPresenter((ViewGroup) l().findViewById(2131370975)));
    L14:
        r0.a(new t0());
        return r0;
    L13:
        r0.a(new ECWindowTopInfoBarPresenter());
        goto L14
    L7:
        r0.a(new ECWindowDialogStyledBackgroundPresenter());
        r0.a(new ECWindowCroppedStyleRootPresenter());
        goto L8
    L9:
        r0.a(new com.bytedance.android.window.shop.home.presenter.e());
        r0.a(new com.bytedance.android.window.shop.home.presenter.i());
        r0.a(new ECWindowRootPresenter());
        goto L11
    }

    public final List<QUIModule> i() {
        ArrayList r0 = new ArrayList();
        if (this.m == false) goto L5;
        r0.add(new e());
        r0.add(new i(l().findViewById(2131370858)));
        r0.add(new j());
        r0.add(new c(this.o));
        r0.add(new b(this.o));
        r0.add(new d());
        r0.add(new g());
    L6:
        return r0;
    L5:
        r0.add(new e());
        r0.add(new i(l().findViewById(2131370858)));
        r0.add(new f(this.o));
        r0.add(new c(this.o));
        r0.add(new b(this.o));
        r0.add(new d());
        r0.add(new g());
        goto L6
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r1) {
        return l();
    }

    public h(View r2, boolean r3, boolean r4, Function0<Integer> r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r5, "getViewHeight");
        super(null);
        this.m = r3;
        this.n = r4;
        this.o = r5;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }
}
