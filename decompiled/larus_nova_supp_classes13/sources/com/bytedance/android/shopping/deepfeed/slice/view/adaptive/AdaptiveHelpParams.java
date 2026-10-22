package com.bytedance.android.shopping.deepfeed.slice.view.adaptive;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AdaptiveHelpParams {
    public final int a;
    public final String b;
    public final Gravity c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/adaptive/AdaptiveHelpParams$Gravity;", "", "LEFT", "RIGHT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Gravity extends Enum<Gravity> {
        public static final Gravity LEFT = null;
        public static final Gravity RIGHT = null;
        public static final /* synthetic */ Gravity[] a = null;

        static {
            Gravity r1 = new Gravity("LEFT", 0);
            LEFT = r1;
            Gravity r2 = new Gravity("RIGHT", 1);
            RIGHT = r2;
            a = new Gravity[]{r1, r2};
        }

        public static Gravity valueOf(String r1) {
            return (Gravity) a.a(Gravity.class, r1);
        }

        public static Gravity[] values() {
            return (Gravity[]) a.clone();
        }

        public Gravity(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AdaptiveHelpParams) == false) goto L12;
        AdaptiveHelpParams r4 = (AdaptiveHelpParams) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Gravity r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "AdaptiveHelpParams(priority=" + this.a + ", tag=" + this.b + ", gravity=" + this.c + ")";
    }

    public AdaptiveHelpParams(int r2, String r3, Gravity r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "gravity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
