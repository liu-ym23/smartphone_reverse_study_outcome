package com.bytedance.android.shopping.deepfeed.ui;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.deepfeed.action.h;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.deepfeed.slice.e;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductView;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.bytedance.android.shopping.jedi.JediBaseSingleTypeAdapter;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import he3.k1;
import he3.p0;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductAdapter;", "Lcom/bytedance/android/shopping/jedi/JediBaseSingleTypeAdapter;", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductAdapter extends JediBaseSingleTypeAdapter<InFeedProductV2> {
    public boolean A;
    public Function1<? super AbsDeepFeedProductVH, Unit> B;
    public Function1<? super AbsDeepFeedProductVH, Unit> C;
    public boolean D;
    public AbsDeepFeedProductVH E;
    public boolean F;
    public final Lazy G;
    public final Lazy H;
    public final LifecycleOwner I;
    public final h J;
    public final HashMap<InFeedProductV2, re3.a> w;
    public AbsDeepFeedProductVH x;
    public AbsDeepFeedProductVH y;
    public boolean z;

    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductView] */
    @Override // com.bytedance.android.shopping.jedi.JediBaseSingleTypeAdapter
    public final AbsDeepFeedProductVH C2(ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        this.J.m();
        LifecycleOwner r2 = this.I;
        ?? r3 = new DeepFeedProductView(r8.getContext(), null, 6, 0);
        r3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r9 = Unit.INSTANCE;
        return new DeepFeedProductVH(r2, r3, this.w, (r) this.G.getValue(), this.J);
    }

    public final void E2(AbsDeepFeedProductVH r2) {
        if ((!Intrinsics.areEqual(r2, this.y)) == false) goto L8;
        this.y = r2;
        if (r2 == null) goto L9;
        r2.d4();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onBindFooterViewHolder(r3);
        if (Build.VERSION.SDK_INT > 23) goto L5;
        return;
    L5:
        if (this.D == false) goto L9;
        View r4 = r3.itemView;
        r4.setBackgroundResource(2131247407);
        r4.setVisibility(0);
        return;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
        if ((r2 instanceof AbsDeepFeedProductVH) == false) goto L6;
        ((AbsDeepFeedProductVH) r2).q4();
        return;
    }

    public DeepFeedProductAdapter(LifecycleOwner r2, e r3, com.bytedance.android.shopping.deepfeed.action.b r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "slcManager");
        Intrinsics.checkNotNullParameter(r4, "deepFeedContext");
        super(r2);
        this.I = r2;
        this.J = r4;
        this.w = new HashMap();
        this.G = LazyKt.lazy(DeepFeedProductAdapter$imageCallerContext$2.INSTANCE);
        this.H = LazyKt.lazy(DeepFeedProductAdapter$idleUpdateTop$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7, List<Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r8, "payloads");
        super.onBindViewHolder(r6, r7, r8);
        if ((r6 instanceof AbsDeepFeedProductVH) == false) goto L38;
        if (r7 == 0) goto L6;
    L13:
        if (r7 == 0) goto L15;
    L25:
        if (r7 != 1) goto L38;
        if (this.z == true) goto L33;
        E2((AbsDeepFeedProductVH) r6);
        Function1<? super AbsDeepFeedProductVH, Unit> r9 = this.C;
        if (r9 == null) goto L31;
        Unit r10 = (Unit) r9.invoke(r6);
    L31:
        this.z = true;
    L33:
        if (Intrinsics.areEqual(this.y, this.E) == false) goto L37;
        E2((AbsDeepFeedProductVH) r6);
        Function1<? super AbsDeepFeedProductVH, Unit> r11 = this.C;
        if (r11 == null) goto L37;
        Unit r12 = (Unit) r11.invoke(r6);
    L37:
        this.E = (AbsDeepFeedProductVH) r6;
        goto L38
    L15:
        if (this.A == true) goto L25;
        InFeedProductV2 r13 = (InFeedProductV2) DiffableAdapter.DefaultImpls.getItem$default(this, r7, false, 2, null);
        if (r13 == null) goto L19;
        boolean r14 = r13.isCacheData();
    L20:
        if (r14 == true) goto L25;
        D2(0, (AbsDeepFeedProductVH) r6, false, false);
        Function1<? super AbsDeepFeedProductVH, Unit> r15 = this.B;
        if (r15 == null) goto L24;
        Unit r16 = (Unit) r15.invoke(r6);
    L24:
        this.A = true;
        goto L25
    L19:
        r14 = false;
        goto L20
    L6:
        if (this.F == true) goto L13;
        InFeedProductV2 r17 = (InFeedProductV2) DiffableAdapter.DefaultImpls.getItem$default(this, r7, false, 2, null);
        if (r17 == null) goto L10;
        boolean r18 = r17.isCacheData();
    L11:
        if (r18 == true) goto L13;
        ((AbsDeepFeedProductVH) r6).v4();
        this.F = true;
        goto L13
    L10:
        r18 = false;
    L38:
        InFeedProductV2 r19 = (InFeedProductV2) DiffableAdapter.DefaultImpls.getItem$default(this, r7, false, 2, null);
        if (r19 != null) goto L41;
    L43:
        int r20 = 0;
    L44:
        if (r20 > 1) goto L65;
        InFeedProductV2 r21 = (InFeedProductV2) DiffableAdapter.DefaultImpls.getItem$default(this, r7 + r20, false, 2, null);
        if (r21 == null) goto L64;
        InFeedProductPackData r22 = r21.getPackData();
        if (r22 == null) goto L58;
        InFeedProductPackDataElements r23 = r22.getElements();
        if (r23 == null) goto L58;
        List<p0> r24 = r23.getProducts();
        if (r24 == null) goto L58;
        p0 r25 = (p0) CollectionsKt.firstOrNull(r24);
        if (r25 == null) goto L58;
        k1 r26 = r25.g();
        if (r26 == null) goto L58;
        List<InFeedUrlModel> r27 = r26.b();
    L59:
        if (r27 == null) goto L64;
        InFeedUrlModel r28 = (InFeedUrlModel) CollectionsKt.firstOrNull(r27);
        if (r28 == null) goto L64;
        h0.i(r28, (r) this.G.getValue());
    L58:
        r27 = null;
    L64:
        r20 = r20 + 1;
        goto L44
    L65:
        return;
    L41:
        if (r19.isSkeletonData() == true) goto L43;
        this.J.z();
        goto L43
    }

    public final void D2(int r2, AbsDeepFeedProductVH r3, boolean r4, boolean r5) {
        if (r4 == false) goto L12;
        if (((Boolean) this.H.getValue()).booleanValue() == false) goto L12;
        if (Intrinsics.areEqual(r3, this.x) == false) goto L12;
        AbsDeepFeedProductVH r6 = this.y;
        if (r6 == null) goto L12;
        r6.w4(0);
    L12:
        if ((!Intrinsics.areEqual(this.x, r3)) == true) goto L15;
        if (r5 == true) goto L15;
    L28:
        DeepFeedFoldHelper.d();
        return;
    L15:
        if ((r3 instanceof AbsDeepFeedProductVH) == false) goto L28;
        if ((!Intrinsics.areEqual(this.x, r3)) == false) goto L22;
        AbsDeepFeedProductVH r7 = this.x;
        if (r7 == null) goto L21;
        r7.u4(false);
    L21:
        this.x = r3;
    L22:
        AbsDeepFeedProductVH r8 = this.x;
        if (r8 == null) goto L25;
        r8.u4(true);
    L25:
        AbsDeepFeedProductVH r9 = this.x;
        if (r9 == null) goto L28;
        r9.w4(1);
        goto L28
    }
}
