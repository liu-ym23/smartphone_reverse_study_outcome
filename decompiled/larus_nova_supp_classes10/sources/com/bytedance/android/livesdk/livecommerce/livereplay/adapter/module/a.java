package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends QUIModule {
    public final ni2.b l;

    public final List<QUIModule> i() {
        return CollectionsKt.listOf(new QUIModule[]{new f(this.l), new g(this.l)});
    }

    public final QIPresenter h() {
        return new com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter.a();
    }

    public a(ni2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        super(0);
        this.l = r2;
    }

    public final View f(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        FrameLayout r5 = new FrameLayout(r3);
        r5.setLayoutParams(new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.d(112), UtilityKotlinExtentionsKt.d(112)));
        return r5;
    }
}
