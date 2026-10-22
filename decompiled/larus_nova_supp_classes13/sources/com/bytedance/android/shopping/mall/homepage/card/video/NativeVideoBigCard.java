package com.bytedance.android.shopping.mall.homepage.card.video;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.j;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder;
import com.bytedance.android.ec.hybrid.ui.IHybridVideoBoxView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.k;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yj.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/NativeVideoBigCard;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NativeVideoBigCard extends BaseViewHolder {
    public static final /* synthetic */ int C = 0;
    public final Integer A;
    public final g93.a B;
    public final FrameLayout o;
    public final SimpleDraweeView p;
    public final ImageView q;
    public final ProgressBar r;
    public final ConstraintLayout s;
    public IHybridVideoBoxView t;
    public VideoCardModel u;
    public VideoCardData v;
    public String w;
    public final String x;
    public long y;
    public long z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ NativeVideoBigCard a;

        public b(NativeVideoBigCard r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            NativeVideoBigCard r3 = this.a;
            String r0 = r3.w;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r3.B == null) goto L9;
            boolean r4 = !g93.a.a(r0);
            g93.a.b(r0, r4);
            this.a.r4(r4);
            return;
        }
    }

    static {
    }

    public final boolean C3() {
        return true;
    }

    public final void D() {
        ((BaseViewHolder) this).a = IHybridListViewHolder.ECCardPlayState.IDLE;
        q4();
    }

    public final void onShow() {
        ECHybridListItemVO r0 = ((BaseViewHolder) this).c;
        if (r0 == null) goto L6;
        r0.K = false;
        return;
    }

    public final void q4() {
        IHybridVideoBoxView r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        r0.f();
    L7:
        IHybridVideoBoxView r1 = this.t;
        if (r1 == null) goto L10;
        r1.a();
    L10:
        this.o.removeView(this.t);
        this.o.removeAllViews();
        this.t = null;
        j4(IHybridListViewHolder.ECCardPlayState.IDLE);
    }

    public final void onHide() {
        q4();
    }

    public final void D1(Long r4) {
        ((BaseViewHolder) this).a = IHybridListViewHolder.ECCardPlayState.PLAYING;
        t r5 = com.bytedance.android.shopping.api.mall.common.tools.h.b.getHybridLynxHostService();
        VideoCardData.Video r1 = null;
        if (r5 == null) goto L5;
        IHybridVideoBoxView r6 = r5.getHybridVideoBoxView(((RecyclerView.ViewHolder) this).itemView.getContext(), true);
    L6:
        this.t = r6;
        this.o.addView(r6);
        Gson r7 = new Gson();
        VideoCardData r2 = this.v;
        if (r2 == null) goto L9;
        r1 = r2.getVideo();
    L9:
        String r8 = GsonProtectorUtils.toJson(r7, r1);
        IHybridVideoBoxView r3 = this.t;
        if (r3 == null) goto L12;
        r3.setStateChangeReporter(new NativeVideoBigCard$playVideo$1(this));
    L12:
        IHybridVideoBoxView r9 = this.t;
        if (r9 == null) goto L15;
        r9.setVideoData(r8);
    L15:
        String r10 = this.w;
        if (r10 != null) goto L18;
    L20:
        IHybridVideoBoxView r11 = this.t;
        if (r11 == null) goto L23;
        r11.setLoop(true);
    L23:
        IHybridVideoBoxView r12 = this.t;
        if (r12 == null) goto L26;
        int r0 = IHybridVideoBoxView.a;
        r12.g();
    L26:
        this.y = System.currentTimeMillis();
        return;
    L18:
        if (this.B == null) goto L20;
        r4(g93.a.a(r10));
        goto L20
    L5:
        r6 = null;
        goto L6
    }

    public final void r4(boolean r3) {
        IHybridVideoBoxView r0 = this.t;
        if (r0 == null) goto L5;
        r0.setMuted(r3);
    L5:
        IHybridVideoBoxView r1 = this.t;
        if (r1 == null) goto L8;
        int r2 = IHybridVideoBoxView.a;
        r1.e();
    L8:
        if (r3 == false) goto L10;
        this.q.setImageResource(2131248018);
        return;
    L10:
        this.q.setImageResource(2131248019);
    }

    public NativeVideoBigCard(View r2, Integer r3, g93.a r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.A = r3;
        this.B = r4;
        this.x = "";
        this.y = System.currentTimeMillis();
        this.z = System.currentTimeMillis();
        Lazy r5 = ToolsKt.a;
        Intrinsics.checkNotNullParameter(r2, "$this$setRadius");
        r2.setOutlineProvider(new k(UIUtils.dip2Px(r2.getContext(), 9.0f)));
        r2.setClipToOutline(true);
        FrameLayout r6 = (FrameLayout) r2.findViewById(2131379498);
        this.o = r6;
        this.p = r2.findViewById(2131379506);
        ImageView r7 = (ImageView) r2.findViewById(2131379495);
        this.q = r7;
        this.r = (ProgressBar) r2.findViewById(2131379507);
        this.s = r2.findViewById(2131379499);
        r6.setOnClickListener(new NativeVideoBigCard$cardClickListener$1(this, r2));
        r7.setOnClickListener(new b(this));
    }

    public final void b4(Object r7, String r8, com.bytedance.android.ec.hybrid.list.entity.k.a r9) {
        Intrinsics.checkNotNullParameter(r8, "itemId");
        super.b4(r7, r8, r9);
        String r10 = null;
        if ((r7 instanceof VideoCardData) == true) goto L5;
        r7 = null;
    L5:
        VideoCardData r11 = (VideoCardData) r7;
        if (r11 != null) goto L8;
        return;
    L8:
        this.v = r11;
        ECHybridListAdapter r12 = ((BaseViewHolder) this).g;
        boolean r13 = false;
        if (r12 == null) goto L21;
        j r14 = r12.C2();
        if (r14 == null) goto L21;
        Double r0 = r14.a;
        if (r0 == null) goto L15;
        int r1 = b0.c(r0);
    L16:
        Double r15 = r14.b;
        if (r15 == null) goto L19;
        int r16 = b0.c(r15);
    L20:
        this.s.setLayoutParams(new ViewGroup.LayoutParams(-1, (UIUtils.getScreenWidth(((RecyclerView.ViewHolder) this).itemView.getContext()) - (r1 + r16)) / ((int) 1.21d)));
        goto L21
    L19:
        r16 = 0;
        goto L20
    L15:
        r1 = 0;
    L21:
        VideoCardData r17 = this.v;
        if (r17 == null) goto L38;
        VideoCardModel r18 = h.a(r17);
        this.u = r18;
        String r2 = r18.getVideo().getId();
        this.w = r2;
        if (r2 != null) goto L26;
    L36:
        this.p.setImageURI(r18.getVideo().getCover());
        ToolsKt.y(this.o, r18.getVideo().getAccessibilityLabel());
        return;
    L26:
        if (this.B == null) goto L29;
        HashMap<String, Boolean> r3 = g93.a.a;
        Intrinsics.checkNotNullParameter(r2, "id");
        if (g93.a.a.containsKey(r2) != true) goto L29;
    L30:
        if (r13 == false) goto L32;
        r10 = r2;
    L32:
        if (r10 == null) goto L36;
        if (this.B == null) goto L36;
        g93.a.b(r10, true);
    L29:
        r13 = true;
        goto L30
    }
}
