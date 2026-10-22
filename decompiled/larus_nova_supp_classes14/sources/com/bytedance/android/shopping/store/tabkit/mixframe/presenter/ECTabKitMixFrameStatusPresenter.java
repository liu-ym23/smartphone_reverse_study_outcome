package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.tabkit.mixframe.MixFrameViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECTabKitMixFrameStatusPresenter extends QFragmentPresenter {
    public final Lazy f;
    public StatusView g;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECTabKitMixFrameStatusPresenter a;
        public final /* synthetic */ ECHybridListContainer b;

        public a(ECTabKitMixFrameStatusPresenter r1, ECHybridListContainer r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            LoadStatus r3 = (LoadStatus) r2;
            if (r3 == LoadStatus.InitializeEmpty) goto L7;
            if (r3 == LoadStatus.InitializeError) goto L7;
        L16:
            if (r3 != LoadStatus.InitializeSuccess) goto L23;
            StatusView r4 = this.a.g;
            if (r4 == null) goto L20;
            ExtensionsKt.gone(r4);
        L20:
            ExtensionsKt.visible(this.b);
            return;
        L23:
            return;
        L7:
            if (((MixFrameViewModel) this.a.f.getValue()).getFirstRequestSuccess() == true) goto L16;
            StatusView r5 = this.a.g;
            if (r5 == null) goto L11;
            ExtensionsKt.visible(r5);
        L11:
            StatusView r6 = this.a.g;
            if (r6 == null) goto L14;
            r6.setVisibility(0);
            r6.setECStatus(2);
        L14:
            ExtensionsKt.gone(this.b);
        }
    }

    public ECTabKitMixFrameStatusPresenter(final Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ECTabKitMixFrameStatusPresenter$viewModel$2(this, r2));
    }

    public final void b0(QModel r4) {
        StatusView r5 = a0().findViewById(2131371110);
        this.g = r5;
        if (r5 == null) goto L8;
        View r0 = th.a.c(Y().c(), 2131564809, r5, false);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        Unit r2 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        View r3 = r0.findViewById(2131387440);
        if (r3 == null) goto L7;
        r3.setOnClickListener(new e(this));
    L7:
        r5.b(null, r0, true);
    L8:
        ECHybridListContainer r6 = Z().b(2131371111).f();
        ((MixFrameViewModel) this.f.getValue()).getLoadStatus().b(Y().e(), new a(this, r6));
    }
}
