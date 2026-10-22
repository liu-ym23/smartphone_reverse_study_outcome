package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.model.response.anchorv3.AdInfoStruct;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3GuessULikeFeedbackView;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3GuessULikeProductView;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/guess/AnchorV4GuessProductVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/guess/AnchorV4GuessBaseVH;", "Lcom/bytedance/android/shopping/anchorv4/log/c;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4GuessProductVH extends AnchorV4GuessBaseVH implements com.bytedance.android.shopping.anchorv4.log.c {
    public static final /* synthetic */ int z = 0;
    public final int q;
    public final int r;
    public final ViewGroup s;
    public final CompositeDisposable t;
    public final RecyclerView.Adapter<?> u;
    public final RecyclerView v;
    public final LifecycleOwner w;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d x;
    public final h y;

    public final void E0() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof AnchorV3GuessULikeProductView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV3GuessULikeProductView r1 = (AnchorV3GuessULikeProductView) r0;
        if (r1 == null) goto L17;
        AnchorV3GuessULikeFeedbackView r2 = r1.a(2131362670);
        if (r2.v == false) goto L17;
        RecyclerView r3 = r2.a;
        if (r3 == null) goto L12;
        r3.removeOnScrollListener(r2.t);
    L12:
        RecyclerView r4 = r2.a;
        if (r4 == null) goto L15;
        r4.removeOnItemTouchListener(r2.u);
    L15:
        r2.v = false;
    L17:
        if (((j63.c) getItem()).a() == null) goto L32;
        View r5 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r5 instanceof AnchorV3GuessULikeProductView) == true) goto L21;
        r5 = null;
    L21:
        AnchorV3GuessULikeProductView r6 = (AnchorV3GuessULikeProductView) r5;
        if (r6 != null) goto L24;
        return;
    L24:
        if (r6.i == false) goto L36;
        j63.c r7 = r6.c;
        if (r7 != null) goto L29;
        return;
    L29:
        if (r7.a() == null) goto L35;
        r6.i = false;
        r6.h = true;
        int r8 = com.bytedance.android.shopping.anchorv3.utils.g.a;
        com.bytedance.android.shopping.anchorv3.utils.g.c("show_over", r6.c, Long.valueOf(SystemClock.elapsedRealtime() - r6.g), null);
        return;
    L35:
        return;
    L36:
        return;
    }

    public final void onShow() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof AnchorV3GuessULikeProductView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV3GuessULikeProductView r1 = (AnchorV3GuessULikeProductView) r0;
        if (r1 == null) goto L17;
        AnchorV3GuessULikeFeedbackView r2 = r1.a(2131362670);
        if (r2.v == true) goto L17;
        RecyclerView r3 = r2.a;
        if (r3 == null) goto L12;
        r3.addOnScrollListener(r2.t);
    L12:
        RecyclerView r4 = r2.a;
        if (r4 == null) goto L15;
        r4.addOnItemTouchListener(r2.u);
    L15:
        r2.v = true;
    L17:
        if (((j63.c) getItem()).a() == null) goto L32;
        View r5 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r5 instanceof AnchorV3GuessULikeProductView) == true) goto L21;
        r5 = null;
    L21:
        AnchorV3GuessULikeProductView r6 = (AnchorV3GuessULikeProductView) r5;
        if (r6 != null) goto L24;
        return;
    L24:
        if (r6.h == false) goto L36;
        j63.c r7 = r6.c;
        if (r7 == null) goto L34;
        AdInfoStruct r8 = r7.a();
        if (r8 == null) goto L35;
        r6.h = false;
        r6.i = true;
        r6.g = SystemClock.elapsedRealtime();
        int r9 = com.bytedance.android.shopping.anchorv3.utils.g.a;
        com.bytedance.android.shopping.anchorv3.utils.g.c("show", r6.c, null, null);
        com.bytedance.android.shopping.anchorv3.utils.g.d("show", r8);
        return;
    L35:
        return;
    L34:
        return;
    L36:
        return;
    }

    public final String h4() {
        int r0 = getAdapterPosition();
        RecyclerView.Adapter r1 = this.v.getAdapter();
        if (r1 == null) goto L5;
        int r2 = r1.getItemCount();
    L7:
        return "a1.b8094.c7615.d7024_i" + (((r0 - r2) + this.p.C()) + 1);
    L5:
        r2 = 0;
        goto L7
    }

    public final int q0() {
        return this.q;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH
    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final int v1() {
        return this.r;
    }

    public static final /* synthetic */ j63.c g4(AnchorV4GuessProductVH r0) {
        return (j63.c) r0.getItem();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH
    public final /* bridge */ /* synthetic */ void a4(Object r1) {
        e4((j63.c) r1);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH
    public final void e4(j63.c r14) {
        Intrinsics.checkNotNullParameter(r14, "item");
        ExtKt.b("AnchorV4GuessProductVH", "onBind (" + h4() + ')');
        AnchorV3GuessULikeProductView r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L31;
        AnchorV3GuessULikeProductView r1 = r0;
        if (r14 == null) goto L29;
        CompositeDisposable r3 = this.t;
        Function1<Integer, Unit> r4 = new AnchorV4GuessProductVH$onBind$1(this);
        RecyclerView.Adapter<?> r5 = this.u;
        RecyclerView r6 = this.v;
        Function0<Unit> r7 = new AnchorV4GuessProductVH$onBind$2(this);
        Integer r8 = Integer.valueOf(r14.b);
        String r2 = this.p.f();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        String r9 = r2;
        CommonMeta r10 = this.p.a();
        Boolean r11 = null;
        if (r10 == null) goto L12;
        String r12 = r10.getEntranceInfo();
    L13:
        JSONObject r13 = k.w(r12);
        if (r13 == null) goto L16;
        String r15 = r13.optString("ecom_scene_id");
    L17:
        AnchorV4GuessBaseVH.a r16 = this.m;
        CommonMeta r17 = this.y.a();
        if (r17 == null) goto L20;
        r11 = Boolean.valueOf(r17.getEnablePDPOptimize());
    L20:
        AnchorV3GuessULikeProductView.f(r1, r14, r3, r4, r5, r6, r7, r8, r9, r15, r16, k.i(r11));
        View r18 = ((RecyclerView.ViewHolder) this).itemView;
        String r19 = h4();
        Object r20 = getItem();
        a r21 = new a(this);
        if (r19.length() != 0) goto L23;
        boolean r22 = true;
    L24:
        if (r22 == false) goto L26;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L26:
        com.bytedance.android.bst.api.d r23 = new com.bytedance.android.bst.api.d(r18);
        r23.a = r19;
        r23.b = "show_product";
        r23.c = r20;
        r23.d = "shopping";
        r23.e = -1;
        r23.f = r21;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.a(r23);
        this.m.q("show_ecom_card", h4(), PageFinder.via(this.v), false);
        this.x.a(this);
        return;
    L23:
        r22 = false;
        goto L24
    L16:
        r15 = null;
        goto L17
    L12:
        r12 = null;
        goto L13
    L29:
        throw new IllegalStateException("Required value was null.".toString());
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.view.AnchorV3GuessULikeProductView");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH
    public final /* bridge */ /* synthetic */ void b4(Object r1, int r2, List r3) {
        f4((j63.c) r1, r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH
    public final void f4(j63.c r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "item");
        super.f4(r2, r3, r4);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.contains("hide_feedback") == false) goto L14;
        View r5 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r5 instanceof AnchorV3GuessULikeProductView) == true) goto L9;
        r5 = null;
    L9:
        AnchorV3GuessULikeProductView r6 = (AnchorV3GuessULikeProductView) r5;
        if (r6 == null) goto L15;
        r6.a(2131362670).T5(false, r6, "4");
        return;
    L15:
        return;
    }

    public AnchorV4GuessProductVH(ViewGroup r6, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r7, CompositeDisposable r8, JediBaseMultiTypeAdapter r9, RecyclerView r10, LifecycleOwner r11, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r12, h r13) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "compositeDisposable");
        Intrinsics.checkNotNullParameter(r9, "adapter");
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        Intrinsics.checkNotNullParameter(r12, "gulShowManager");
        Intrinsics.checkNotNullParameter(r13, "viewModel");
        int r0 = AnchorV3GuessULikeProductView.j;
        Context r1 = r6.getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        super(new AnchorV3GuessULikeProductView(r1, null, 6, 0), r7, r10, r13);
        this.s = r6;
        this.t = r8;
        this.u = r9;
        this.v = r10;
        this.w = r11;
        this.x = r12;
        this.y = r13;
        this.q = ((int) UIUtils.dip2Px(((RecyclerView.ViewHolder) this).itemView.getContext(), 132.0f)) - k1.q();
        this.r = (int) UIUtils.dip2Px(((RecyclerView.ViewHolder) this).itemView.getContext(), 60.0f);
    }
}
