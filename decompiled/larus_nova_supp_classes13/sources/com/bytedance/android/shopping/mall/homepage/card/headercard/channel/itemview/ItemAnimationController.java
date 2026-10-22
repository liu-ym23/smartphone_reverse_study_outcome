package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import android.animation.AnimatorSet;
import android.view.View;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import java.util.List;
import kk.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ItemAnimationController {
    public CoroutineScope a;
    public AnimatorSet b;
    public AnimatorSet c;
    public ChannelVO d;
    public ChannelVO.Animation e;
    public int f;
    public int g;
    public int h;
    public int i;
    public long j;
    public long k;
    public long l;
    public final a m;
    public final View n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ItemAnimationController$ChannelSwiperStorageStruct;", "", "clickTimes", "", "", "(Ljava/util/List;)V", "getClickTimes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChannelSwiperStorageStruct {
        private final List<Long> clickTimes;

        public ChannelSwiperStorageStruct() {
            List r0 = null;
            this(r0, 1, r0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelSwiperStorageStruct copy$default(ChannelSwiperStorageStruct r0, List r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.clickTimes;
        L6:
            return r0.copy(r1);
        }

        public final List<Long> component1() {
            return this.clickTimes;
        }

        public final ChannelSwiperStorageStruct copy(List<Long> r2) {
            return new ChannelSwiperStorageStruct(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof ChannelSwiperStorageStruct) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.clickTimes, ((ChannelSwiperStorageStruct) r2).clickTimes) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            List<Long> r0 = this.clickTimes;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "ChannelSwiperStorageStruct(clickTimes=" + this.clickTimes + ")";
        }

        public final List<Long> getClickTimes() {
            return this.clickTimes;
        }

        public ChannelSwiperStorageStruct(List<Long> r1) {
            this.clickTimes = r1;
        }

        public /* synthetic */ ChannelSwiperStorageStruct(List r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    public interface a {
        void L1(int r1, int r2);
    }

    public final void a() {
        d.c(new ItemAnimationController$cancelAnimation$1(this));
    }

    public final void c() {
        if (this.f >= 0) goto L5;
    L17:
        boolean r0 = false;
    L18:
        if (r0 == true) goto L20;
        return;
    L20:
        a();
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(JobKt.Job$default(null, 1, null)));
        this.a = r3;
        if (r3 == null) goto L24;
        BuildersKt.launch$default(r3, null, null, new ItemAnimationController$startAnimationInner$1(this, null), 3, null);
        return;
    L24:
        return;
    L5:
        if (this.g < 0) goto L17;
        int r1 = this.h;
        if (r1 <= 0) goto L17;
        if (this.i < r1) goto L17;
        if (this.j <= 0) goto L17;
        if (this.k <= 0) goto L17;
        if (this.l < 0) goto L17;
        r0 = true;
        goto L18
    }

    public ItemAnimationController(a r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "itemChangedListener");
        Intrinsics.checkNotNullParameter(r3, "targetView");
        this.m = r2;
        this.n = r3;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
    }

    public final void b(ChannelVO r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "channel");
        this.d = r5;
        ChannelVO.Data r0 = r5.getData();
        if (r0 == null) goto L19;
        ChannelVO.Animation r1 = r0.getAnimation();
        if (r1 == null) goto L25;
        this.e = r1;
        ChannelVO.Layout r2 = r5.getLayout();
        if (r2 == null) goto L20;
        Integer r3 = r2.getHSpan();
        if (r3 == null) goto L21;
        this.h = r3.intValue();
        ChannelVO.Data r7 = r5.getData();
        if (r7 == null) goto L22;
        List<ECCommonCard> r8 = r7.getItems();
        if (r8 == null) goto L23;
        this.i = r8.size();
        Long r9 = r1.getCarouselPeriod();
        if (r9 == null) goto L24;
        long r4 = r9.longValue() * 1000;
        this.j = r4;
        this.f = r6;
        this.g = r6;
        int r10 = this.h;
        this.k = ((long) r10) * r4;
        this.l = ((long) (r10 - r6)) * r4;
        c();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L25:
        return;
    }
}
