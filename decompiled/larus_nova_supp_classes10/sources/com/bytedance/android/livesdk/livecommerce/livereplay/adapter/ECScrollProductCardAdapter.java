package com.bytedance.android.livesdk.livecommerce.livereplay.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.paging.ECPagedListAdapter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oi2.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/adapter/ECScrollProductCardAdapter;", "Lcom/bytedance/android/livesdk/livecommerce/paging/ECPagedListAdapter;", "Lni2/a;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/adapter/ECScrollProductCardViewHolder;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardAdapter extends ECPagedListAdapter<ni2.a, ECScrollProductCardViewHolder> {
    public static final ECScrollProductCardAdapter$Companion$DIFF_CALLBACK$1 e = null;
    public c b;
    public final ni2.b c;
    public final RecyclerView d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECScrollProductCardAdapter a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;

        public b(ECScrollProductCardAdapter r1, int r2, Object r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECScrollProductCardAdapter r0 = this.a;     // Catch: Throwable -> L4
            int r1 = this.b;     // Catch: Throwable -> L4
            Object r2 = this.c;     // Catch: Throwable -> L4
            ECScrollProductCardAdapter$Companion$DIFF_CALLBACK$1 r3 = ECScrollProductCardAdapter.e;     // Catch: Throwable -> L4
            r0.z2(r1, r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.livecommerce.livereplay.adapter.ECScrollProductCardAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        e = new ECScrollProductCardAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        ECScrollProductCardViewHolder r3 = (ECScrollProductCardViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r3);
        r3.a.r(com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module.a.class);
    }

    public ECScrollProductCardAdapter(ni2.b r2, RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super(e);
        this.c = r2;
        this.d = r3;
        this.b = new c(0);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        ECScrollProductCardViewHolder r7 = (ECScrollProductCardViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        ni2.a r0 = (ni2.a) getItem(r6);
        JSONObject r1 = null;
        if (r0 != null) goto L58;
        r0 = null;
    L31:
        r7.a.r(com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module.a.class);
        int r8 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(r7.b.h) == false) goto L56;
        if (r0 == null) goto L56;
        if (r0.a == false) goto L56;
        Integer r9 = r0.g;
        if (r9 == null) goto L39;
        r7.b.g.put("is_replay_default_product", r9.intValue());
    L39:
        ECUIPromotion r10 = r0.j;
        if (r10 == null) goto L44;
        String r11 = r10.getPromotionId();
        if (r11 == null) goto L44;
        r7.b.g.put("promotion_id", r11);
    L44:
        ExplainPlaybackVideoInfo r12 = r0.d;
        if (r12 == null) goto L50;
        String r13 = r12.getFragmentId();
        if (r13 == null) goto L50;
        r7.b.g.put("fragment_id", r13);
    L50:
        if (r7.b.g.has("product_id") == false) goto L56;
        ECUIPromotion r14 = r0.j;
        if (r14 == null) goto L56;
        String r15 = r14.getProductId();
        if (r15 == null) goto L56;
        r7.b.g.put("product_id", r15);
    L56:
        r7.a.c(com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module.a.class, r0);
        return;
    L58:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        ECUIPromotion r3 = r0.j;     // Catch: Throwable -> L11
        if (r3 == null) goto L9;
        JSONObject r4 = r3.getExtraTransmissibleLogParams();     // Catch: Throwable -> L11
        if (r4 == null) goto L9;
        r1 = r4.put("is_from_explain", r0.b);     // Catch: Throwable -> L11
    L9:
        Object r16 = Result.constructor-impl(r1);     // Catch: Throwable -> L11
    L13:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L16;
        ECExceptionMonitor.e(r17);
    L16:
        int r18 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(this.c.h) == true) goto L21;
        ECUIPromotion r19 = r0.j;
        if (r19 == null) goto L21;
        r19.setIronIndex(r6 + 1);
    L21:
        c r20 = this.b;
        if (r20.c == true) goto L24;
    L26:
        boolean r21 = false;
    L27:
        if (r21 == false) goto L29;
        r0.b = true;
    L29:
        r0.a = r21;
        r0.c = r6;
        Unit r22 = Unit.INSTANCE;
        goto L31
    L24:
        if (r6 != r20.a) goto L26;
        r21 = true;
    L11:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        int r15 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(this.c.h) == false) goto L5;
        int r16 = ECScrollProductCardViewHolder.c;
        Context r17 = r13.getContext();
        ni2.b r18 = this.c;
        JSONObject r8 = x0.a(r18.g);
        int r2 = r18.a;
        ml.b r3 = r18.b;
        il.a r4 = r18.c;
        ml.a r5 = r18.d;
        String r6 = r18.e;
        String r7 = r18.f;
        String r9 = r18.h;
        xk.a r10 = r18.i;
        ViewModelProvider.Factory r11 = r18.j;
        Intrinsics.checkNotNullParameter(r3, "liveInfo");
        Intrinsics.checkNotNullParameter(r4, "eventMap");
        Intrinsics.checkNotNullParameter(r5, "btmInfo");
        Intrinsics.checkNotNullParameter(r6, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r7, "replayId");
        Intrinsics.checkNotNullParameter(r8, "queryEntranceInfo");
        Intrinsics.checkNotNullParameter(r9, "enterFrom");
        Intrinsics.checkNotNullParameter(r10, "replayParams");
        Intrinsics.checkNotNullParameter(r11, "factory");
        return ECScrollProductCardViewHolder.a.a(r17, new ni2.b(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11));
    L5:
        int r19 = ECScrollProductCardViewHolder.c;
        return ECScrollProductCardViewHolder.a.a(r13.getContext(), this.c);
    }

    public final void z2(int r3, Object r4) {
        if (this.d.isComputingLayout() == false) goto L5;
        this.d.post(new b(this, r3, r4));
        return;
    L5:
        notifyItemChanged(r3, r4);
    }
}
