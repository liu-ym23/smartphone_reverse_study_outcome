package com.bytedance.ee.bear.doc.blockeditpanel.view;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class GradientColorConfig {
    public final List<Integer> a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/doc/blockeditpanel/view/GradientColorConfig$Direction;", "", "<init>", "(Ljava/lang/String;I)V", "TO_RIGHT", "TO_BOTTOM_RIGHT", "TO_BOTTOM", "TO_BOTTOM_LEFT", "TO_LEFT", "TO_TOP_LEFT", "TO_TOP", "TO_TOP_RIGHT", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Direction extends Enum<Direction> {
        public static final Direction TO_BOTTOM = null;
        public static final Direction TO_BOTTOM_LEFT = null;
        public static final Direction TO_BOTTOM_RIGHT = null;
        public static final Direction TO_LEFT = null;
        public static final Direction TO_RIGHT = null;
        public static final Direction TO_TOP = null;
        public static final Direction TO_TOP_LEFT = null;
        public static final Direction TO_TOP_RIGHT = null;
        public static final /* synthetic */ Direction[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Direction> getEntries() {
            return b;
        }

        static {
            Direction r0 = new Direction("TO_RIGHT", 0);
            TO_RIGHT = r0;
            Direction r1 = new Direction("TO_BOTTOM_RIGHT", 1);
            TO_BOTTOM_RIGHT = r1;
            Direction r3 = new Direction("TO_BOTTOM", 2);
            TO_BOTTOM = r3;
            Direction r5 = new Direction("TO_BOTTOM_LEFT", 3);
            TO_BOTTOM_LEFT = r5;
            Direction r7 = new Direction("TO_LEFT", 4);
            TO_LEFT = r7;
            Direction r9 = new Direction("TO_TOP_LEFT", 5);
            TO_TOP_LEFT = r9;
            Direction r11 = new Direction("TO_TOP", 6);
            TO_TOP = r11;
            Direction r13 = new Direction("TO_TOP_RIGHT", 7);
            TO_TOP_RIGHT = r13;
            Direction[] r16 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r16;
            b = EnumEntriesKt.enumEntries(r16);
        }

        public static Direction[] values() {
            return (Direction[]) a.clone();
        }

        public static Direction valueOf(String r1) {
            return (Direction) r27.a.a(Direction.class, r1);
        }

        public Direction(String r1, int r2) {
            super(r1, r2);
        }
    }

    public GradientColorConfig(List<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "colorResList");
        this.a = CollectionsKt.emptyList();
        Direction r0 = Direction.TO_RIGHT;
        this.a = r2;
    }
}
