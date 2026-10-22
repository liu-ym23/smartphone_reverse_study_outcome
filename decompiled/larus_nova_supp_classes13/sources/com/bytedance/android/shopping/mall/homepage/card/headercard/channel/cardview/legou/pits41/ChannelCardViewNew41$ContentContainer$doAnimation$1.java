package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import android.os.Handler;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.api.mall.common.tools.a0;
import com.bytedance.android.shopping.api.mall.common.tools.z;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.ChannelItemActivity;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ChannelCardViewNew41$ContentContainer$doAnimation$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ChannelCardViewNew41.a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.ChannelCardViewNew41$ContentContainer$doAnimation$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ ChannelCardViewNew41$ContentContainer$doAnimation$1 this$0;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.ChannelCardViewNew41$ContentContainer$doAnimation$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
        public static final class C00931 extends Lambda implements Function0<Unit> {
            final /* synthetic */ AnonymousClass1 this$0;

            public C00931(AnonymousClass1 r1) {
                this.this$0 = r1;
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1251invoke() {
                Handler r0 = a0.a;
                Function0<Unit> r1 = new C00941(this);
                Intrinsics.checkNotNullParameter(r1, "method");
                a0.a.postDelayed(new z(r1), 1500);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1251invoke();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(ChannelCardViewNew41$ContentContainer$doAnimation$1 r1) {
            this.this$0 = r1;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1250invoke() {
            this.this$0.this$0.d.setVisibility(8);
            int r0 = hf3.a.a;
            ChannelItemActivity r1 = this.this$0.this$0.c;
            C00931 r2 = new C00931(this);
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
            r1.setVisibility(0);
            hf3.a.a(r1, 0.1f, 1.0f, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m1250invoke();
            return Unit.INSTANCE;
        }
    }

    public ChannelCardViewNew41$ContentContainer$doAnimation$1(ChannelCardViewNew41.a r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1249invoke() {
        ECCommonCard r0 = this.this$0.getItem();
        if (r0 == null) goto L11;
        Map<Integer, ECCommonCard.AnimItem> r1 = r0.getAnimItems();
        if (r1 == null) goto L11;
        ECCommonCard.AnimItem r2 = r1.get(0);
        if (r2 == null) goto L11;
        Long r3 = r2.getTimes();
        if (r3 == null) goto L11;
        long r4 = r3.longValue();
    L12:
        this.this$0.getItemLoopTimes();
        if (this.this$0.getItemLoopTimes() < r4) goto L16;
        this.this$0.a();
        return;
    L16:
        ChannelCardViewNew41.a r5 = this.this$0;
        r5.setItemLoopTimes(r5.getItemLoopTimes() + 1);
        int r6 = hf3.a.a;
        LinearLayout r7 = this.this$0.d;
        AnonymousClass1 r8 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        hf3.a.a(r7, 1.0f, 0.2f, r8);
        return;
    L11:
        r4 = 0;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1249invoke();
        return Unit.INSTANCE;
    }
}
