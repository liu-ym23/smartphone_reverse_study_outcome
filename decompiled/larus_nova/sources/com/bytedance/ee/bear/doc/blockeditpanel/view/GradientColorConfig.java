package com.bytedance.ee.bear.doc.blockeditpanel.view;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class GradientColorConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f217652a;

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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Direction[] f217653a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f217654b = null;

        public static EnumEntries<Direction> getEntries() {
            return f217654b;
        }

        static {
            Direction r100 = new Direction("TO_RIGHT", 0);
            TO_RIGHT = r100;
            Direction r101 = new Direction("TO_BOTTOM_RIGHT", 1);
            TO_BOTTOM_RIGHT = r101;
            Direction r102 = new Direction("TO_BOTTOM", 2);
            TO_BOTTOM = r102;
            Direction r103 = new Direction("TO_BOTTOM_LEFT", 3);
            TO_BOTTOM_LEFT = r103;
            Direction r104 = new Direction("TO_LEFT", 4);
            TO_LEFT = r104;
            Direction r105 = new Direction("TO_TOP_LEFT", 5);
            TO_TOP_LEFT = r105;
            Direction r110 = new Direction("TO_TOP", 6);
            TO_TOP = r110;
            Direction r111 = new Direction("TO_TOP_RIGHT", 7);
            TO_TOP_RIGHT = r111;
            Direction[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f217653a = r112;
            f217654b = EnumEntriesKt.enumEntries(r112);
        }

        public static Direction[] values() {
            return (Direction[]) f217653a.clone();
        }

        public static Direction valueOf(String r100) {
            return (Direction) r27.a.a(Direction.class, r100);
        }

        public Direction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public GradientColorConfig(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "colorResList");
        this.f217652a = CollectionsKt.emptyList();
        Direction r101 = Direction.TO_RIGHT;
        this.f217652a = r100;
    }
}
