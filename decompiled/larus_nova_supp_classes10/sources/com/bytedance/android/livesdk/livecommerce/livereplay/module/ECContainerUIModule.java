package com.bytedance.android.livesdk.livecommerce.livereplay.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.livereplay.presenter.ECContainerUIPresenter;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECContainerUIModule extends QUIModule {
    public final String l;
    public final ViewModelProvider.Factory m;

    public static final class a {
    }

    static {
    }

    public final QIPresenter h() {
        return new ECContainerUIPresenter(this.l, this.m);
    }

    public final void g(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if ((r4 instanceof RecyclerView) == true) goto L5;
        r4 = null;
    L5:
        RecyclerView r5 = (RecyclerView) r4;
        if (r5 == null) goto L9;
        r5.setLayoutManager(new LinearLayoutManager(r5.getContext(), 0, false));
        r5.addItemDecoration(new ECContainerUIModule$onViewCreated$$inlined$also$lambda$1(this));
        return;
    }

    public ECContainerUIModule(String r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "factory");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        RecyclerView r5 = new RecyclerView(r3);
        r5.setId(2131384942);
        ViewGroup.MarginLayoutParams r6 = new ViewGroup.MarginLayoutParams(-1, -2);
        r6.setMargins(0, UtilityKotlinExtentionsKt.d(13), 0, 0);
        Unit r0 = Unit.INSTANCE;
        r5.setLayoutParams(r6);
        return r5;
    }
}
