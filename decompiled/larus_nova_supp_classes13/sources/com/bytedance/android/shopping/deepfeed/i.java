package com.bytedance.android.shopping.deepfeed;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductAdapter;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import he3.n0;
import he3.z0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ DeepFeedProductFragment a;

    public i(DeepFeedProductFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r14) {
        Pair r15 = (Pair) r14;
        if (r15 == null) goto L73;
        List r0 = (List) r15.getFirst();
        final com.bytedance.android.shopping.deepfeed.data.a r16 = (com.bytedance.android.shopping.deepfeed.data.a) r15.getSecond();
        List r1 = r0;
        if ((!r1.isEmpty()) == false) goto L74;
        FrameLayout r2 = this.a.o;
        final boolean r3 = false;
        if (r2 != null) goto L9;
    L17:
        final ArrayList r4 = new ArrayList();
        r4.addAll(r1);
        if (r4.size() <= 1) goto L44;
        DeepFeedProductFragment r5 = this.a;
        r5.getClass();
        if (DeepFeedProductFragment.ha0(r4) == true) goto L44;
        InFeedProductV2 r6 = (InFeedProductV2) CollectionsKt.firstOrNull(r4);
        if (r6 == null) goto L28;
        z0 r7 = r6.getRespExtra();
        if (r7 == null) goto L28;
        if (r7.a != true) goto L28;
        boolean r8 = true;
    L29:
        if (r8 == false) goto L44;
        com.bytedance.android.shopping.deepfeed.ui.ability.a r9 = (com.bytedance.android.shopping.deepfeed.ui.ability.a) r5.D.getValue();
        r9.b();
        ConstraintLayout r10 = r9.a;
        if (r10 == null) goto L34;
        r10.setVisibility(8);
    L34:
        if (tc3.f.b() == false) goto L41;
        View r11 = r9.d;
        if (r11 == null) goto L38;
        r11.setVisibility(0);
    L38:
        View r12 = r9.c;
        if (r12 == null) goto L44;
        r12.setVisibility(8);
        goto L44
    L41:
        View r13 = r9.c;
        if (r13 == null) goto L44;
        r13.setVisibility(0);
    L28:
        r8 = false;
    L44:
        DeepFeedProductAdapter r17 = this.a.n;
        if (r17 == null) goto L53;
        List r18 = DiffableAdapter.DefaultImpls.getCurrentList(r17);
        if (r18 == null) goto L53;
        if (r18.isEmpty() == true) goto L53;
        r3 = DeepFeedProductFragment.ha0(r18);
    L53:
        InFeedProductV2 r19 = (InFeedProductV2) CollectionsKt.firstOrNull(r4);
        if (r19 != null) goto L56;
    L64:
        DeepFeedProductAdapter r20 = this.a.n;
        if (r20 == null) goto L67;
        Function0<Unit> r21 = new DeepFeedProductFragment$initSubscribe$2$$special$$inlined$let$lambda$1(r16, r4, r3, this);
        Intrinsics.checkNotNullParameter(r4, "list");
        DiffableAdapter.DefaultImpls.submitList(r20, r4, r21);
    L67:
        DeepFeedProductFragment r110 = this.a;
        if (r110.L == false) goto L70;
        return;
    L70:
        if (com.bytedance.android.shopping.extensions.k.c(r110.ca0(r110.V)) == false) goto L76;
        this.a.L = true;
        Lazy r111 = UIUtils.a;
        UIUtils.c().post(new h(this));
        return;
    L76:
        return;
    L56:
        if (r19.isCacheData() == false) goto L64;
        n0 r22 = r19.slcCard();
        if (r22 == null) goto L64;
        Map<String, Map<String, Object>> r23 = r22.f();
        if (r23 == null) goto L64;
        Map<String, Object> r24 = r23.get("top_bar_card");
        if (r24 == null) goto L64;
        com.bytedance.android.shopping.deepfeed.action.b r25 = this.a.aa0();
        com.bytedance.android.shopping.deepfeed.data.e r112 = new com.bytedance.android.shopping.deepfeed.data.e(r24, null, 0, true, r19.getDynamicData().p, null);
        r25.getClass();
        Intrinsics.checkNotNullParameter(r112, "data");
        Intrinsics.checkNotNullParameter(r112, "data");
        goto L64
    L9:
        if (r2.getVisibility() != 0) goto L11;
        boolean r26 = true;
    L12:
        if (r26 == false) goto L14;
        r2.setVisibility(8);
    L14:
        RecyclerView r27 = this.a.l;
        if (r27 == null) goto L17;
        r27.setVisibility(0);
        goto L17
    L11:
        r26 = false;
        goto L12
    L74:
        return;
    }
}
