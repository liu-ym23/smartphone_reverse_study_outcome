package com.bytedance.android.livesdk.livecommerce.intro.auction;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIAction;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends QUIModule {
    public final IntroAuctionPresenter l;
    public final oh2.e m;
    public final oh2.c n;

    public static final class a {
    }

    static {
    }

    public final String b() {
        return "INTRO_CARD";
    }

    public final void e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final int j(QModel r1) {
        return 4;
    }

    public final QIPresenter h() {
        IntroAuctionPresenter r0 = this.l;
        if ((r0 instanceof oh2.a) == true) goto L5;
        Object r1 = null;
    L6:
        oh2.a r2 = (oh2.a) r1;
        if (r2 == null) goto L9;
        r2.f = this.m;
        r2.g = this.n;
    L9:
        return r0;
    L5:
        r1 = r0;
        goto L6
    }

    public final QUIAction c(ArrayList r2) {
        Intrinsics.checkNotNullParameter(r2, "conflictModule");
        return QUIAction.REPLACE;
    }

    public final View f(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        FrameLayout r5 = new FrameLayout(r3);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r5;
    }

    public f(IntroAuctionViewModel r2, oh2.e r3, oh2.c r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "argument");
        Intrinsics.checkNotNullParameter(r4, "containerAbility");
        super(0);
        this.m = r3;
        this.n = r4;
        this.l = new IntroAuctionPresenter(r3, r4);
    }
}
