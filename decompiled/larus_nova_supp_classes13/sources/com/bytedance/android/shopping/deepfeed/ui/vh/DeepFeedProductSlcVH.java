package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.deepfeed.slice.service.DeepFeedSlcCommonService;
import com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcList;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView;
import com.bytedance.android.shopping.deepfeed.utlis.DataUtilsKt$createDefaultIAction$1;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import he3.h2;
import he3.k0;
import he3.n0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductSlcVH;", "Lcom/bytedance/android/shopping/deepfeed/ui/vh/AbsDeepFeedProductVH;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DeepFeedProductSlcVH extends AbsDeepFeedProductVH {
    public static final /* synthetic */ int k0 = 0;
    public Map<String, Object> Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public DeepFeedSlcCommonService X;
    public DeepFeedSlcList Y;
    public boolean Z;

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void d4() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void e4() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void f4() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void g4() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final boolean l4() {
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void v4() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    @Deprecated(message = "在 slice 场景不需要这个方法了")
    public final void w4(int r1) {
    }

    public final DeepFeedSlcList C4() {
        DeepFeedSlcList r0 = this.Y;
        if (r0 != null) goto L9;
        DeepFeedSlcList r1 = B4(((RecyclerView.ViewHolder) this).itemView);
        if (r1 == null) goto L7;
        this.Y = r1;
        return r1;
    L7:
        return null;
    L9:
        return r0;
    }

    public final void H4() {
        InFeedProductV2 r0 = this.m;
        if (r0 == null) goto L9;
        he3.v r1 = r0.getDynamicData();
        if (r1 == null) goto L9;
        if (r1.n != true) goto L9;
        return;
    L9:
        InFeedProductV2 r2 = this.m;
        if (r2 == null) goto L14;
        he3.v r3 = r2.getDynamicData();
        if (r3 == null) goto L14;
        r3.n = true;
    L14:
        Integer r4 = i4().findReportCardIndex(this.m);
        if (r4 == null) goto L24;
        int r5 = r4.intValue();
        InFeedProductV2 r6 = this.m;
        if (r6 == null) goto L19;
        Map<String, Object> r7 = com.bytedance.android.shopping.deepfeed.utlis.a.b(r6, "show_product");
    L20:
        Map<String, Object> r8 = r7;
        DeepFeedProductEventTracker r9 = i4().getEventTracker();
        if (r9 == null) goto L25;
        r9.z(r5, this.m, this.q, null, this.n, r8);
        return;
    L25:
        return;
    L19:
        r7 = null;
        goto L20
    }

    public final void Z1() {
        InFeedProductV2 r0 = this.m;
        if (r0 == null) goto L7;
        he3.v r1 = r0.getDynamicData();
        if (r1 == null) goto L7;
        String r2 = r1.l;
    L8:
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        if (r2.length() != 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return;
    L16:
        getAdapterPosition();
        getAdapterPosition();
        i4().curNoFullScreenCount();
        if (this.o == false) goto L21;
        throw null;
    L21:
        throw null;
    L13:
        r3 = false;
    L7:
        r2 = null;
        goto L8
    }

    public final void onDestroy() {
        if (this.X != null) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public void q4() {
        super.q4();
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static DeepFeedSlcList B4(View r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$findDeepFeedSlcList");
        if ((r3 instanceof DeepFeedSlcList) == false) goto L7;
        return (DeepFeedSlcList) r3;
    L7:
        if ((r3 instanceof ViewGroup) == false) goto L14;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L18;
        DeepFeedSlcList r2 = B4(r4.getChildAt(r1));
        if (r2 != null) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return r2;
    L18:
        return null;
    L14:
        return null;
    }

    public final String A4(String r2) {
        Intrinsics.checkNotNullParameter(r2, "area");
        switch(r2.hashCode()) {
            case -1476195426: goto L45;
            case -1335224239: goto L42;
            case -1236338690: goto L39;
            case -906336856: goto L36;
            case -425218655: goto L33;
            case 97926: goto L30;
            case 3046176: goto L27;
            case 3529462: goto L24;
            case 106934601: goto L21;
            case 110371416: goto L18;
            case 798171989: goto L15;
            case 810061429: goto L12;
            case 949444906: goto L9;
            case 950398559: goto L6;
            default: goto L47;
        };
    L47:
        return null;
    L6:
        if (r2.equals("comment") == false) goto L47;
        return this.x;
    L9:
        if (r2.equals("collect") == false) goto L47;
        return this.w;
    L12:
        if (r2.equals("main_video") == false) goto L47;
        return this.q;
    L15:
        if (r2.equals("main_image") == false) goto L47;
        return this.q;
    L18:
        if (r2.equals("title") == false) goto L47;
        return this.B;
    L21:
        if (r2.equals("price") == false) goto L47;
        return this.q;
    L24:
        if (r2.equals("shop") == false) goto L47;
        return this.u;
    L27:
        if (r2.equals("cart") == false) goto L47;
        return this.s;
    L30:
        if (r2.equals("buy") == false) goto L47;
        return this.t;
    L33:
        if (r2.equals("product_detail") == false) goto L47;
        return this.q;
    L36:
        if (r2.equals("search") == false) goto L47;
        return this.v;
    L39:
        if (r2.equals("add_cart") == false) goto L47;
        return this.s;
    L42:
        if (r2.equals("detail") == false) goto L47;
        return this.A;
    L45:
        if (r2.equals("display_image") == false) goto L47;
        return this.z;
    }

    public void E4(InFeedProductV2 r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        this.m = r4;
        DeepFeedSlcCommonService r5 = this.X;
        if (r5 == null) goto L11;
        WeakReference<View> r2 = r5.d;
        if (r2 == null) goto L7;
        r2.clear();
    L7:
        WeakReference<View> r3 = r5.e;
        if (r3 == null) goto L10;
        r3.clear();
    L10:
        r5.d = null;
        r5.e = null;
        r5.f = null;
        r5.g = false;
    L11:
        this.Y = null;
        this.U = false;
        this.V = false;
        this.W = false;
        throw null;
    }

    public final void I4(final List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        Function0<Unit> r0 = new DeepFeedProductSlcVH$tagFromRecommend$1(this, r3);
        Intrinsics.checkNotNullParameter(r0, "method");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r0.invoke();
        return;
    L5:
        this.p.post(new e(r0));
    }

    public /* bridge */ /* synthetic */ void a4(Object r1) {
        E4((InFeedProductV2) r1);
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void c4(int r1) {
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void n4(boolean r2) {
        if (r2 != com.bytedance.android.shopping.deepfeed.utlis.f.b) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void s4(String r13) {
        Intrinsics.checkNotNullParameter(r13, "finishMethod");
        DeepFeedSlcCommonService r1 = this.X;
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(r13, "finishMethod");
        int r0 = com.bytedance.android.shopping.deepfeed.event.f.a;
        String r2 = com.bytedance.android.shopping.deepfeed.event.f.a(r1.h.m);
        if (r2 == null) goto L16;
        DeepFeedSliceVideoView.q.getClass();
        if (DeepFeedSliceVideoView.o.add(r2) == true) goto L11;
        return;
    L11:
        if (((DeepFeedSliceVideoView.a.C0058a) ((LinkedHashMap) DeepFeedSliceVideoView.p).get(r2)) == null) goto L18;
        DeepFeedProductViewModel r3 = r1.h.i4();
        DeepFeedProductSlcVH r4 = r1.h;
        r3.reportCardVideoProgress(r4.m, 0, 0, false, r13, r4.q, ((RecyclerView.ViewHolder) r4).itemView);
        return;
    L18:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void u4(boolean r6) {
        this.o = r6;
        if (r6 == false) goto L40;
        boolean r2 = true;
        if (this.U == true) goto L9;
        this.U = true;
        Function0<Unit> r7 = this.M;
        if (r7 == null) goto L9;
        Unit r8 = (Unit) r7.invoke();
    L9:
        i4().onFocusInFeedProductChange(this.m);
        Map<String, Object> r9 = this.Q;
        if (r9 == null) goto L12;
        this.p.post(new q(r9, this));
    L12:
        Boolean r3 = Boolean.TRUE;
        Map<String, ? extends Object> r10 = MapsKt.mapOf(new Pair[]{TuplesKt.to("visible", r3), TuplesKt.to("mute", Boolean.valueOf(com.bytedance.android.shopping.deepfeed.utlis.f.b)), TuplesKt.to("is_playing", r3)});
        InFeedProductV2 r1 = this.m;
        if (r1 == null) goto L19;
        n0 r4 = r1.slcCard();
        if (r4 == null) goto L19;
        com.bytedance.android.shopping.deepfeed.slice.c r5 = r4.d;
        if (r5 == null) goto L19;
        r5.a(r10);
    L19:
        int r11 = ie3.b.a;
        ie3.b.a("show", "");
        j4();
        DeepFeedProductEventTracker r12 = i4().getEventTracker();
        if (r12 == null) goto L31;
        InFeedProductV2 r0 = this.m;
        if (r0 != null) goto L24;
    L27:
        r2 = false;
    L28:
        if (r2 == true) goto L31;
    L37:
        Z1();
        return;
    L24:
        if (r12.a.contains(r0) == true) goto L27;
        r12.a.add(r0);
    L31:
        if (this.Z == false) goto L33;
        H4();
    L34:
        InFeedProductV2 r13 = this.m;
        if (r13 == null) goto L37;
        i4().onCardShow(r13);
        goto L37
    L33:
        this.p.post(new n(this));
        goto L34
    L40:
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH
    public final void y4(he3.l r5, com.bytedance.android.shopping.deepfeed.action.h r6) {
        Intrinsics.checkNotNullParameter(r5, "couponResp");
        Intrinsics.checkNotNullParameter(r6, "dfContext");
        InFeedProductV2 r7 = this.m;
        if (r7 == null) goto L7;
        he3.v r8 = r7.getDynamicData();
        if (r8 == null) goto L7;
        r8.d = r5;
    L7:
        InFeedProductV2 r9 = this.m;
        if (r9 == null) goto L14;
        n0 r10 = r9.slcCard();
        if (r10 == null) goto L14;
        k0 r11 = r10.e();
        if (r11 == null) goto L14;
        h2 r12 = r11.f();
    L15:
        this.V = com.bytedance.android.shopping.deepfeed.utlis.h.c(r12);
        Map<Long, he3.j> r13 = r5.b();
        if (r13 == null) goto L53;
        Set<Long> r14 = r13.keySet();
        if (r14 == null) goto L54;
        Iterator<T> r15 = r14.iterator();
        if (r15.hasNext() == false) goto L55;
        he3.j r16 = r5.b().get(Long.valueOf(((Number) r15.next()).longValue()));
        if (r16 == null) goto L56;
        String r17 = u0.d(r16);
        if (r17 != null) goto L51;
        return;
    L51:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L47
        InFeedProductV2 r19 = this.m;     // Catch: Throwable -> L47
        if (r19 == null) goto L34;
        n0 r20 = r19.slcCard();     // Catch: Throwable -> L47
        if (r20 == null) goto L34;
        com.bytedance.android.shopping.deepfeed.slice.c r21 = r20.d;     // Catch: Throwable -> L47
        if (r21 == null) goto L34;
        Map<String, ? extends Object> r22 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("coupon", xc3.b.b(new JSONObject(r17))), TuplesKt.to("show_waist_coupon", Boolean.valueOf(this.V))});     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r22, "data");     // Catch: Throwable -> L47
        r21.c(r22);     // Catch: Throwable -> L47
        r21.b();     // Catch: Throwable -> L47
    L34:
        if (this.V == true) goto L36;
    L45:
        Object r23 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Result.box-impl(r23);
        return;
    L36:
        if (this.W == true) goto L45;
        this.W = true;     // Catch: Throwable -> L47
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L47
        if (r24 == null) goto L45;
        yj.s r25 = r24.getIHybridHostUserService();     // Catch: Throwable -> L47
        if (r25 == null) goto L45;
        String r26 = r25.getCurrentUserId();     // Catch: Throwable -> L47
        if (r26 == null) goto L45;
        com.bytedance.android.shopping.deepfeed.utlis.h.a.put(r26, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L47
        int r27 = ed3.b.a;     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter("mall_deep_feed_popup.".concat(r26), "key");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L14:
        r12 = null;
        goto L15
    }

    public final void F4(String r3, Map<String, ? extends Object> r4, View r5) {
        Intrinsics.checkNotNullParameter(r3, "actionName");
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "actionName");
        new DataUtilsKt$createDefaultIAction$1(r3, r4);
        throw null;
    }
}
