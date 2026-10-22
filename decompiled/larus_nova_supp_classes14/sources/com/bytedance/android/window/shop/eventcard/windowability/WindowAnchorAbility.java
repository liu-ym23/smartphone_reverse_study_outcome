package com.bytedance.android.window.shop.eventcard.windowability;

import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowAnchorAbility {
    public static final b e = null;
    public final String a;
    public final int b;
    public final AnchorPosition c;
    public final List<f> d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/eventcard/windowability/WindowAnchorAbility$AnchorPosition;", "", "BEFORE", "AFTER", "ABOVE", "BELOW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnchorPosition extends Enum<AnchorPosition> {

        @SerializedName("above")
        public static final AnchorPosition ABOVE = null;

        @SerializedName("after")
        public static final AnchorPosition AFTER = null;

        @SerializedName("before")
        public static final AnchorPosition BEFORE = null;

        @SerializedName("below")
        public static final AnchorPosition BELOW = null;
        public static final /* synthetic */ AnchorPosition[] a = null;

        static {
            AnchorPosition r1 = new AnchorPosition("BEFORE", 0);
            BEFORE = r1;
            AnchorPosition r2 = new AnchorPosition("AFTER", 1);
            AFTER = r2;
            AnchorPosition r3 = new AnchorPosition("ABOVE", 2);
            ABOVE = r3;
            AnchorPosition r4 = new AnchorPosition("BELOW", 3);
            BELOW = r4;
            a = new AnchorPosition[]{r1, r2, r3, r4};
        }

        public static AnchorPosition valueOf(String r1) {
            return (AnchorPosition) r27.a.a(AnchorPosition.class, r1);
        }

        public static AnchorPosition[] values() {
            return (AnchorPosition[]) a.clone();
        }

        public AnchorPosition(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/window/shop/eventcard/windowability/WindowAnchorAbility$a;", "", "", "anchorTarget", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "anchorIndex", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "Lcom/bytedance/android/window/shop/eventcard/windowability/WindowAnchorAbility$AnchorPosition;", "anchorPosition", "Lcom/bytedance/android/window/shop/eventcard/windowability/WindowAnchorAbility$AnchorPosition;", "b", "()Lcom/bytedance/android/window/shop/eventcard/windowability/WindowAnchorAbility$AnchorPosition;", "Lcom/google/gson/JsonArray;", "cards", "Lcom/google/gson/JsonArray;", "d", "()Lcom/google/gson/JsonArray;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("anchor_index")
        private final Integer anchorIndex;

        @SerializedName("anchor_position")
        private final AnchorPosition anchorPosition;

        @SerializedName("anchor_target")
        private final String anchorTarget;

        @SerializedName("mix_full_items")
        private final JsonArray cards;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L14;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.anchorTarget, r4.anchorTarget) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.anchorIndex, r4.anchorIndex) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.anchorPosition, r4.anchorPosition) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.cards, r4.cards) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r0 = this.anchorTarget;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.anchorIndex;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            AnchorPosition r7 = this.anchorPosition;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            JsonArray r10 = this.cards;
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
            return "AbilityDTO(anchorTarget=" + this.anchorTarget + ", anchorIndex=" + this.anchorIndex + ", anchorPosition=" + this.anchorPosition + ", cards=" + this.cards + ")";
        }

        public final Integer a() {
            return this.anchorIndex;
        }

        public final AnchorPosition b() {
            return this.anchorPosition;
        }

        public final String c() {
            return this.anchorTarget;
        }

        public final JsonArray d() {
            return this.cards;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        e = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowAnchorAbility(String r2, int r3, AnchorPosition r4, List<? extends f> r5) {
        Intrinsics.checkNotNullParameter(r2, "anchorTarget");
        Intrinsics.checkNotNullParameter(r4, "anchorPosition");
        Intrinsics.checkNotNullParameter(r5, "cardList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
