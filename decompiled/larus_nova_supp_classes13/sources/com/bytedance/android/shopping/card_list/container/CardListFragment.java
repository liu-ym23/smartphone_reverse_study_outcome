package com.bytedance.android.shopping.card_list.container;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.container.init.BaseCardListContainer;
import com.bytedance.android.shopping.card_list.container.init.g;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;
import com.bytedance.android.shopping.jedi.JediBaseFragment;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/card_list/container/CardListFragment;", "Lcom/bytedance/android/shopping/jedi/JediBaseFragment;", "Lcom/bytedance/android/shopping/card_list/widgets/CardListRootFrameLayoutContainer$a;", "", "Lcom/bytedance/android/shopping/card_list/container/init/g;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListFragment extends JediBaseFragment implements CardListRootFrameLayoutContainer.a, g {
    public final Lazy g;
    public final BaseCardListContainer h;

    public static final class a {
    }

    static {
    }

    public CardListFragment() {
        this.g = LazyKt.lazy(new CardListFragment$schemaData$2(this));
        this.h = new BaseCardListContainer();
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.g
    public final int k4() {
        return k1.m(requireContext());
    }

    public final void onDestroy() {
        super.onDestroy();
        this.h.h();
    }

    public final void onResume() {
        super.onResume();
        this.h.c();
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.g
    public final int x20() {
        return k1.j(requireContext());
    }

    @Override // com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer.a
    public final void c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        this.h.a(r2);
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super.onSaveInstanceState(r3);
        r3.putBoolean("CARD_LIST_PAGE_LOAD_AGAIN", true);
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, FreqActions.ACTION_VIEW);
        super.onViewCreated(r12, r13);
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Serializable r1 = r0.getSerializable("page_config");
    L6:
        if (r1 == null) goto L25;
        CardListContainerConfig r6 = (CardListContainerConfig) r1;
        Bundle r2 = getArguments();
        if (r2 == null) goto L11;
        String r3 = r2.getString("PrefetchSessionId");
        if (r3 == null) goto L11;
    L12:
        String r7 = r3;
        View r4 = getView();
        if (r4 == null) goto L15;
        this.h.b(r13, r4, (CardPassThroughData) this.g.getValue(), r6, r7, null, this, this);
    L15:
        new CollectPersonAdapter(this.h.f());
        boolean r14 = r12 instanceof CardListRootFrameLayoutContainer;
        Object r15 = r12;
        if (r14 == true) goto L18;
        r15 = null;
    L18:
        CardListRootFrameLayoutContainer r16 = (CardListRootFrameLayoutContainer) r15;
        if (r16 == null) goto L26;
        Intrinsics.checkNotNullParameter(this, "listener");
        if (((ArrayList) r16.e).contains(this) == true) goto L27;
        ((ArrayList) r16.e).add(this);
        return;
    L27:
        return;
    L26:
        return;
    L11:
        r3 = "";
        goto L12
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig");
    L5:
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return th.a.c(requireContext(), 2131559255, r3, false);
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }
}
