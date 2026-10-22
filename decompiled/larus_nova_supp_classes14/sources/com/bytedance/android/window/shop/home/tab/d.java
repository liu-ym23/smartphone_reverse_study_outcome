package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.ec.hybrid.card.util.q;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends IECLynxCardLifeCycle.Base {
    public final /* synthetic */ WindowLynxTabPresenter a;

    public final void onLoadStart() {
        nj.d r0 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r0 != null) goto L5;
        return;
    L5:
        WindowLynxTabPresenter r1 = this.a;
        KProperty[] r2 = WindowLynxTabPresenter.q;
        l0.c(r1.u().c());
        r0.g();
    }

    public final void onRuntimeReady() {
        WindowLynxTabPresenter r0 = this.a;
        KProperty[] r1 = WindowLynxTabPresenter.q;
        ECLynxCard r2 = r0.G();
        if (r2 == null) goto L6;
        r2.n();
        return;
    }

    public final void onFirstScreen() {
        super.onFirstScreen();
    }

    public d(WindowLynxTabPresenter r1) {
        this.a = r1;
    }

    public final void onPreCreateView(boolean r5) {
        WindowLynxTabPresenter r0 = this.a;
        r0.h = r5;
        r0.getClass();
        String r1 = String.valueOf(null);
        if (r5 == false) goto L5;
        String r6 = CommentScene.COMMENTSCENE_NO_AWEME;
    L6:
        r0.D().doEventAction("ec_window_hit_preload", new Pair[]{TuplesKt.to("item_type", r1), TuplesKt.to("use_preload", r6)});
        return;
    L5:
        r6 = "0";
        goto L6
    }

    public final void onTimingSetupPref(k r4) {
        WindowLynxTabPresenter r0 = this.a;
        KProperty[] r1 = WindowLynxTabPresenter.q;
        r0.getClass();
        int r2 = com.bytedance.android.window.shop.lifecycle.a.a;
        ECWindowViewModel r3 = this.a.D();
        int r5 = com.bytedance.android.window.shop.b.a;
        this.a.getClass();
        com.bytedance.android.window.shop.lifecycle.a.a(r3, r4, String.valueOf(0), this.a.h);
    }

    public final void onTimingUpdatePref(k r5) {
        WindowLynxTabPresenter r0 = this.a;
        KProperty[] r1 = WindowLynxTabPresenter.q;
        r0.getClass();
        int r2 = com.bytedance.android.window.shop.lifecycle.a.a;
        ECWindowViewModel r3 = this.a.D();
        this.a.getClass();
        String r4 = q.c(UriProtector.parse(""), "first_screen_flag");
        int r6 = com.bytedance.android.window.shop.b.a;
        this.a.getClass();
        com.bytedance.android.window.shop.lifecycle.a.b(r3, r5, r4, String.valueOf(0), this.a.h);
    }

    public final void onLoadFailed(ECLynxCardErrorType r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        WindowLynxTabPresenter r5 = this.a;
        KProperty[] r6 = WindowLynxTabPresenter.q;
        r5.m.setValue(r5, WindowLynxTabPresenter.q[0], null);
    }
}
