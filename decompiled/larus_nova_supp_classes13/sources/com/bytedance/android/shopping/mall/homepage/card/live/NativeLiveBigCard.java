package com.bytedance.android.shopping.mall.homepage.card.live;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder;
import com.bytedance.android.ec.hybrid.ui.IHybridLiveBoxView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.tools.MallServiceUtil;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.mall.homepage.tools.c0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yj.t;
import yj.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/NativeLiveBigCard;", "Lcom/bytedance/android/shopping/mall/homepage/card/live/BaseLiveViewHolder;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NativeLiveBigCard extends BaseLiveViewHolder {
    public static final /* synthetic */ int U = 0;
    public final FrameLayout M;
    public final SimpleDraweeView N;
    public final ImageView O;
    public final ConstraintLayout P;
    public IHybridLiveBoxView Q;
    public boolean R;
    public final String S;
    public final boolean T;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ NativeLiveBigCard a;
        public final /* synthetic */ View b;

        public b(NativeLiveBigCard r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            NativeLiveBigCard r6 = this.a;
            int r0 = NativeLiveBigCard.U;
            String r7 = r6.F4();
            IHybridLiveBoxView r1 = this.a.Q;
            if (r1 == null) goto L5;
            r1.enterDetail(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("schema", r7)}));
        L6:
            NativeLiveBigCard r8 = this.a;
            o.a(r8, r8.u, null, 6);
            return;
        L5:
            com.bytedance.android.shopping.api.mall.common.tools.k.b.d(this.b.getContext(), r7, null);
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ NativeLiveBigCard a;
        public final /* synthetic */ g93.a b;

        public c(NativeLiveBigCard r1, g93.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r4 = this.a.v;
            if (r4 != null) goto L5;
            return;
        L5:
            if (this.b == null) goto L14;
            boolean r0 = !g93.a.a(r4);
            g93.a.b(r4, r0);
            NativeLiveBigCard r5 = this.a;
            int r1 = NativeLiveBigCard.U;
            IHybridLiveBoxView r2 = r5.Q;
            if (r2 == null) goto L9;
            r2.setMute(r0);
        L9:
            if (r0 == false) goto L11;
            r5.O.setImageResource(2131248018);
            return;
        L11:
            r5.O.setImageResource(2131248019);
            return;
        }
    }

    static {
    }

    public final void D() {
        ((BaseViewHolder) this).a = IHybridListViewHolder.ECCardPlayState.IDLE;
        E4();
    }

    public final void E4() {
        IHybridLiveBoxView r0 = this.Q;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        r0.setMute(true);
    L7:
        IHybridLiveBoxView r1 = this.Q;
        if (r1 == null) goto L10;
        r1.destroy();
    L10:
        this.M.removeAllViews();
        this.Q = null;
        System.currentTimeMillis();
        j4(IHybridListViewHolder.ECCardPlayState.IDLE);
    }

    public final String F4() {
        Map<String, Object> r0 = c0.a;
        ECHybridListItemVO r1 = ((BaseViewHolder) this).c;
        if (r1 == null) goto L8;
        ECNAMallCardExtra r2 = r1.c();
        if (r2 == null) goto L8;
        Map r3 = r2.getSchemaMap();
        if (r3 == null) goto L8;
    L10:
        return c0.a(r3, false, ToolsKt.g(this), new NativeLiveBigCard$getLiveClickSchema$1(this));
    L8:
        r3 = MapsKt.emptyMap();
        goto L10
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.live.BaseLiveViewHolder
    public final String A4() {
        return F4();
    }

    public final void onHide() {
        E4();
        System.currentTimeMillis();
    }

    public final void D1(Long r9) {
        ((BaseViewHolder) this).a = IHybridListViewHolder.ECCardPlayState.PLAYING;
        if (this.T == false) goto L11;
        u r10 = MallServiceUtil.a();
        if (r10 != null) goto L7;
    L8:
        this.z = System.currentTimeMillis();
        this.A = System.currentTimeMillis();
        o.c(this, 1, 0, null, 2, 6);
        return;
    L7:
        if (r10.a() != true) goto L8;
    L11:
        if (com.bytedance.android.shopping.api.mall.common.tools.h.b.liveSdkInitFinished() == true) goto L13;
        return;
    L13:
        E4();
        t r11 = com.bytedance.android.ec.hybrid.a.g();
        if (r11 == null) goto L16;
        IHybridLiveBoxView r12 = r11.getHybridLiveBoxView(((RecyclerView.ViewHolder) this).itemView.getContext());
    L17:
        this.Q = r12;
        Gson r13 = new Gson();
        LiveCardData r1 = this.u;
        if (r1 == null) goto L21;
        Object r2 = r1.getLive();
        if (r2 == null) goto L21;
    L22:
        String r14 = GsonProtectorUtils.toJson(r13, r2);
        String r3 = this.v;
        if (r3 != null) goto L25;
    L32:
        IHybridLiveBoxView r4 = this.Q;
        if (r4 == null) goto L35;
        r4.setLiveData(r14);
    L35:
        this.R = true;
        this.z = System.currentTimeMillis();
        IHybridLiveBoxView r15 = this.Q;
        if (r15 == null) goto L38;
        r15.stream(new NativeLiveBigCard$playVideo$2(this));
    L38:
        View r16 = this.Q;
        if (r16 == null) goto L42;
        this.M.addView(r16, new FrameLayout.LayoutParams(-1, -1));
        return;
    L42:
        return;
    L25:
        if (this.J == null) goto L32;
        boolean r5 = g93.a.a(r3);
        IHybridLiveBoxView r6 = this.Q;
        if (r6 == null) goto L29;
        r6.setMute(r5);
    L29:
        if (r5 == false) goto L31;
        this.O.setImageResource(2131248018);
        goto L32
    L31:
        this.O.setImageResource(2131248019);
    L21:
        r2 = "";
        goto L22
    L16:
        r12 = null;
        goto L17
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.live.BaseLiveViewHolder
    public final void b4(Object r7, String r8, com.bytedance.android.ec.hybrid.list.entity.k.a r9) {
        Intrinsics.checkNotNullParameter(r8, "itemId");
        super.b4(r7, r8, r9);
        String r10 = null;
        if ((r7 instanceof LiveCardData) == true) goto L5;
        r7 = null;
    L5:
        LiveCardData r11 = (LiveCardData) r7;
        if (r11 != null) goto L8;
        return;
    L8:
        this.u = r11;
        ECHybridListAdapter r12 = ((BaseViewHolder) this).g;
        if (r12 == null) goto L21;
        com.bytedance.android.ec.hybrid.list.entity.j r13 = r12.C2();
        if (r13 == null) goto L21;
        Double r0 = r13.a;
        if (r0 == null) goto L15;
        int r1 = b0.c(r0);
    L16:
        Double r14 = r13.b;
        if (r14 == null) goto L19;
        int r15 = b0.c(r14);
    L20:
        this.P.setLayoutParams(new ViewGroup.LayoutParams(-1, (UIUtils.getScreenWidth(((RecyclerView.ViewHolder) this).itemView.getContext()) - (r1 + r15)) / ((int) 1.21d)));
        goto L21
    L19:
        r15 = 0;
        goto L20
    L15:
        r1 = 0;
    L21:
        LiveCardData r16 = this.u;
        if (r16 == null) goto L24;
        this.N.setImageURI(d.a(r16, "", "").getLive().getCover());
    L24:
        LiveCardData r17 = this.u;
        if (r17 == null) goto L29;
        LiveCardData.Live r18 = r17.getLive();
        if (r18 == null) goto L29;
        String r19 = r18.getRoomId();
    L30:
        this.v = r19;
        if (r19 == null) goto L45;
        boolean r2 = true;
        if (this.J == null) goto L38;
        HashMap<String, Boolean> r3 = g93.a.a;
        Intrinsics.checkNotNullParameter(r19, "id");
        if (g93.a.a.containsKey(r19) != true) goto L38;
        r2 = false;
    L38:
        if (r2 == false) goto L40;
        r10 = r19;
    L40:
        if (r10 != null) goto L42;
        return;
    L42:
        if (this.J == null) goto L47;
        g93.a.b(r10, false);
        return;
    L47:
        return;
    L45:
        return;
    L29:
        r19 = null;
        goto L30
    }

    public NativeLiveBigCard(View r13, Fragment r14, View r15, boolean r16, int r17, Integer r18, n r19, g93.a r20) {
        Intrinsics.checkNotNullParameter(r13, "itemView");
        Intrinsics.checkNotNullParameter(r19, "pageStateChangeObserver");
        super(r13, r14, r15, r17, r18, r19, r20, null, null);
        this.T = r16;
        this.R = true;
        System.currentTimeMillis();
        System.currentTimeMillis();
        this.S = "";
        Lazy r1 = ToolsKt.a;
        Intrinsics.checkNotNullParameter(r13, "$this$setRadius");
        r13.setOutlineProvider(new com.bytedance.android.shopping.api.mall.common.homepage.card.common.k(UIUtils.dip2Px(r13.getContext(), 9.0f)));
        r13.setClipToOutline(true);
        FrameLayout r0 = (FrameLayout) r13.findViewById(2131379497);
        this.M = r0;
        this.N = r13.findViewById(2131379505);
        ImageView r2 = (ImageView) r13.findViewById(2131379495);
        this.O = r2;
        this.P = r13.findViewById(2131379496);
        r0.setOnClickListener(new b(this, r13));
        r2.setOnClickListener(new c(this, r20));
    }
}
