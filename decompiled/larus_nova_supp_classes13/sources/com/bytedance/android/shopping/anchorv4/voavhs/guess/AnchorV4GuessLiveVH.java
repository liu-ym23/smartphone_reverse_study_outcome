package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.AdInfoStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardLiveStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardProductStruct;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3GuessULikeFeedbackView;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3GuessULikeLiveView;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.utility.UIUtils;
import com.google.gson.internal.LinkedTreeMap;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/guess/AnchorV4GuessLiveVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/guess/AnchorV4GuessBaseVH;", "Lcom/bytedance/android/shopping/anchorv4/log/c;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4GuessLiveVH extends AnchorV4GuessBaseVH implements com.bytedance.android.shopping.anchorv4.log.c {
    public final int q;
    public final int r;
    public final ViewGroup s;
    public final CompositeDisposable t;
    public final RecyclerView.Adapter<?> u;
    public final RecyclerView v;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d w;
    public final h x;

    public final void E0() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        AnchorV3GuessULikeLiveView r2 = null;
        if ((r0 instanceof AnchorV3GuessULikeLiveView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV3GuessULikeLiveView r1 = (AnchorV3GuessULikeLiveView) r0;
        if (r1 == null) goto L17;
        AnchorV3GuessULikeFeedbackView r3 = r1.a(2131362670);
        if (r3.v == false) goto L17;
        RecyclerView r4 = r3.a;
        if (r4 == null) goto L12;
        r4.removeOnScrollListener(r3.t);
    L12:
        RecyclerView r5 = r3.a;
        if (r5 == null) goto L15;
        r5.removeOnItemTouchListener(r3.u);
    L15:
        r3.v = false;
    L17:
        if (((j63.c) getItem()).a() == null) goto L33;
        AnchorV3GuessULikeLiveView r6 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r6 instanceof AnchorV3GuessULikeLiveView) == false) goto L22;
        r2 = r6;
    L22:
        AnchorV3GuessULikeLiveView r7 = r2;
        if (r7 != null) goto L25;
        return;
    L25:
        if (r7.j == false) goto L37;
        j63.c r8 = r7.c;
        if (r8 != null) goto L30;
        return;
    L30:
        if (r8.a() == null) goto L36;
        r7.j = false;
        r7.i = true;
        return;
    L36:
        return;
    L37:
        return;
    }

    public final void onShow() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof AnchorV3GuessULikeLiveView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV3GuessULikeLiveView r1 = (AnchorV3GuessULikeLiveView) r0;
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
        if ((r5 instanceof AnchorV3GuessULikeLiveView) == true) goto L21;
        r5 = null;
    L21:
        AnchorV3GuessULikeLiveView r6 = (AnchorV3GuessULikeLiveView) r5;
        if (r6 != null) goto L24;
        return;
    L24:
        if (r6.i == false) goto L36;
        j63.c r7 = r6.c;
        if (r7 == null) goto L34;
        AdInfoStruct r8 = r7.a();
        if (r8 == null) goto L35;
        r6.i = false;
        r6.j = true;
        SystemClock.elapsedRealtime();
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

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH
    public final /* bridge */ /* synthetic */ void a4(Object r1) {
        e4((j63.c) r1);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH
    public final void e4(j63.c r15) {
        Intrinsics.checkNotNullParameter(r15, "item");
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        String r2 = null;
        if ((r0 instanceof AnchorV3GuessULikeLiveView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV3GuessULikeLiveView r3 = (AnchorV3GuessULikeLiveView) r0;
        if (r3 == null) goto L15;
        CompositeDisposable r5 = this.t;
        RecyclerView.Adapter<?> r6 = this.u;
        RecyclerView r7 = this.v;
        String r8 = r15.getRequestId();
        Function0<Unit> r9 = new AnchorV4GuessLiveVH$onBind$1(this);
        String r1 = this.p.f();
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        String r10 = r1;
        AnchorV4GuessBaseVH.a r11 = this.m;
        int r12 = r15.b;
        CommonMeta r4 = this.x.a();
        if (r4 == null) goto L13;
        Boolean r13 = Boolean.valueOf(r4.getEnablePDPOptimize());
    L14:
        AnchorV3GuessULikeLiveView.c(r3, r15, r5, r6, r7, r8, r9, r10, r11, r12, k.i(r13));
        goto L15
    L13:
        r13 = null;
    L15:
        this.w.a(this);
        f.a.a(this.m, "show_ecom_card", null, null, 6);
        h r14 = this.p;
        Pair[] r16 = new Pair[7];
        ItemCardLiveStruct r17 = r15.b();
        if (r17 == null) goto L18;
        String r18 = r17.getUid();
    L19:
        r16[0] = TuplesKt.to("anchor_id", r18);
        ItemCardLiveStruct r19 = r15.b();
        if (r19 == null) goto L22;
        String r20 = r19.getRoomId();
    L23:
        r16[1] = TuplesKt.to("room_id", r20);
        ItemCardProductStruct r21 = r15.d();
        if (r21 == null) goto L26;
        String r22 = r21.getProductId();
    L27:
        r16[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r22);
        ItemCardLiveStruct r23 = r15.b();
        if (r23 == null) goto L33;
        Integer r24 = r23.getStatus();
        if (r24 == null) goto L33;
        String r25 = String.valueOf(r24.intValue());
        if (r25 == null) goto L33;
    L34:
        r16[3] = TuplesKt.to("live_status", r25);
        r16[4] = TuplesKt.to("enter_from_merge", "guessyoulike_product_detail");
        r16[5] = TuplesKt.to("enter_method", "native");
        LinkedTreeMap<String, Object> r26 = this.p.b();
        if (r26 == null) goto L37;
        Object r27 = r26.get("entrance_info");
    L39:
        if ((r27 instanceof String) == true) goto L41;
        r27 = null;
    L41:
        String r28 = (String) r27;
        if (r28 == null) goto L46;
        JSONObject r29 = z1.g(r28);
        if (r29 == null) goto L46;
        r29.remove("creative_id");
        r29.remove("is_other_channel");
        r29.remove("log_extra");
        Unit r30 = Unit.INSTANCE;
        r2 = r29.toString();
    L46:
        r16[6] = TuplesKt.to("entrance_info", r2);
        Map r31 = MapsKt.mutableMapOf(r16);
        AnchorV4GuessBaseVH.d4(r15.a(), Integer.valueOf(r15.b), r31);
        Unit r110 = Unit.INSTANCE;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r14, "livesdk_live_show", r31, false, null, null, null, null, 252);
        return;
    L37:
        r27 = null;
    L33:
        r25 = "0";
        goto L34
    L26:
        r22 = null;
        goto L27
    L22:
        r20 = null;
        goto L23
    L18:
        r18 = null;
        goto L19
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
        if ((r5 instanceof AnchorV3GuessULikeLiveView) == true) goto L9;
        r5 = null;
    L9:
        AnchorV3GuessULikeLiveView r6 = (AnchorV3GuessULikeLiveView) r5;
        if (r6 == null) goto L15;
        r6.a(2131362670).T5(false, r6, "4");
        return;
    L15:
        return;
    }

    public AnchorV4GuessLiveVH(ViewGroup r6, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r7, CompositeDisposable r8, JediBaseMultiTypeAdapter r9, RecyclerView r10, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r11, h r12) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "compositeDisposable");
        Intrinsics.checkNotNullParameter(r9, "adapter");
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        Intrinsics.checkNotNullParameter(r11, "gulShowManager");
        Intrinsics.checkNotNullParameter(r12, "viewModel");
        int r0 = AnchorV3GuessULikeLiveView.l;
        Context r1 = r6.getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        super(new AnchorV3GuessULikeLiveView(r1, null, 6, 0), r7, r10, r12);
        this.s = r6;
        this.t = r8;
        this.u = r9;
        this.v = r10;
        this.w = r11;
        this.x = r12;
        this.q = ((int) UIUtils.dip2Px(((RecyclerView.ViewHolder) this).itemView.getContext(), 132.0f)) - k1.q();
        this.r = (int) UIUtils.dip2Px(((RecyclerView.ViewHolder) this).itemView.getContext(), 60.0f);
    }
}
