package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ItemAnimationController;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.BtmPositionResult;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.b;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.f;
import java.util.List;
import java.util.Map;
import kk.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ChannelBaseVH extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int g = 0;
    public ChannelVO a;
    public final Context b;
    public final View c;
    public View d;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a e;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ChannelBaseVH a;

        public a(ChannelBaseVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            long r0 = System.currentTimeMillis();
            ChannelBaseVH r6 = this.a;
            int r2 = ChannelBaseVH.g;
            r6.U3(-1, r0, null);
        }
    }

    public final void W3() {
        ChannelVO r0 = this.a;
        if (r0 == null) goto L5;
        r0.getComponentId();
    L5:
        com.bytedance.android.ec.hybrid.a.e();
        long r1 = System.currentTimeMillis();
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = null;
        final String r3 = "";
        if ("".length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L19;
        d.c(new ChannelBaseVH$updateControlRecord$1(r2, r3));
        ItemAnimationController.ChannelSwiperStorageStruct r5 = (ItemAnimationController.ChannelSwiperStorageStruct) r2.element;
        if (r5 == null) goto L18;
        List<Long> r6 = r5.getClickTimes();
        if (r6 == null) goto L18;
        if (r6.size() < 3) goto L17;
        CollectionsKt.sort(r6);
        List r7 = CollectionsKt.takeLast(r6, 2);
        r6.clear();
        r6.addAll(r7);
        r6.add(Long.valueOf(r1));
        goto L18
    L17:
        r6.add(Long.valueOf(r1));
    L18:
        com.bytedance.android.ec.hybrid.a.e();
        return;
    L19:
        com.bytedance.android.ec.hybrid.a.e();
        return;
    L8:
        r4 = false;
        goto L9
    }

    public final Context getContext() {
        return this.b;
    }

    public void T3(ChannelVO r4) {
        this.a = r4;
        View r5 = this.c;
        StringBuilder r0 = new StringBuilder("channel-card-content-");
        ChannelVO r1 = this.a;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getComponentId();
    L6:
        r0.append(r3);
        r5.setTag(r0.toString());
        View r6 = this.d;
        StringBuilder r7 = new StringBuilder("channel-card-title-");
        ChannelVO r8 = this.a;
        if (r8 == null) goto L9;
        r2 = r8.getComponentId();
    L9:
        r7.append(r2);
        r6.setTag(r7.toString());
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void V3(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public ChannelBaseVH(View r2, com.bytedance.android.shopping.mall.homepage.card.headercard.a r3, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r4) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        Intrinsics.checkNotNullParameter(r3, "mallContext");
        Intrinsics.checkNotNullParameter(r4, "action");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.b = r3.getContext();
        View r5 = ((RecyclerView.ViewHolder) this).itemView;
        this.c = r5;
        this.d = r5;
        r2.setOnClickListener(new a(this));
    }

    public void U3(int r12, long r13, Map<String, ? extends Object> r15) {
        ChannelVO r8 = this.a;
        if (r8 != null) goto L5;
        return;
    L5:
        Integer r0 = r8.getOriginChannelCardFIndex();
        if (r0 == null) goto L8;
        int r1 = r0.intValue();
    L9:
        int r3 = r1 - 1;
        if (r3 < 0) goto L15;
        BtmData r2 = this.e.j;
        String r4 = r8.getComponentId();
        if (r4 != null) goto L14;
        r4 = "0";
    L14:
        BtmPositionResult r5 = b.a(r2, false, r3, r12, r4, 1);
    L16:
        BtmPositionResult r9 = r5;
        Map<String, ? extends Object> r10 = this.e.h.A1.getGlobalProps();
        int r6 = f.a;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r7 = this.e;
        if (r9 == null) goto L19;
        String r11 = r9.getBtm();
    L20:
        f.a(r7, r8, r12, r11, r8.getBcm(), r10, r13);
        this.f.b(r8, r9, r12, r10, r15);
        return;
    L19:
        r11 = null;
        goto L20
    L15:
        r5 = new BtmPositionResult(null, null, null, 7, null);
        goto L16
    L8:
        r1 = 0;
        goto L9
    }
}
