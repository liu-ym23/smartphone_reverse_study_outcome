package com.bytedance.android.shopping.store.marquee;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreTopMultiMarqueeItemVO {
    public static final /* synthetic */ int b = 0;
    public final List<b> a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/marquee/ECStoreTopMultiMarqueeItemVO$MarqueeType;", "", "", "type", "I", "getType", "()I", "OrderMarquee", "RateMarquee", "FootMarquee", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MarqueeType extends Enum<MarqueeType> {
        public static final MarqueeType FootMarquee = null;
        public static final MarqueeType OrderMarquee = null;
        public static final MarqueeType RateMarquee = null;
        public static final /* synthetic */ MarqueeType[] a = null;
        private final int type;

        static {
            MarqueeType r2 = new MarqueeType("OrderMarquee", 0, 1);
            OrderMarquee = r2;
            MarqueeType r3 = new MarqueeType("RateMarquee", 1, 2);
            RateMarquee = r3;
            MarqueeType r4 = new MarqueeType("FootMarquee", 2, 3);
            FootMarquee = r4;
            a = new MarqueeType[]{r2, r3, r4};
        }

        public static MarqueeType valueOf(String r1) {
            return (MarqueeType) r27.a.a(MarqueeType.class, r1);
        }

        public static MarqueeType[] values() {
            return (MarqueeType[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public MarqueeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final List<ECUrlModel> b;
        public final String c;
        public final Integer d;

        public b() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L14;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<ECUrlModel> r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.d;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "MultiMarqueeBubbleItemVO(nickName=" + this.a + ", userAvatars=" + this.b + ", marqueeText=" + this.c + ", marqueeType=" + this.d + ")";
        }

        public b(String r1, List<? extends ECUrlModel> r2, String r3, Integer r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public ECStoreTopMultiMarqueeItemVO(List<b> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.a = r2;
    }
}
