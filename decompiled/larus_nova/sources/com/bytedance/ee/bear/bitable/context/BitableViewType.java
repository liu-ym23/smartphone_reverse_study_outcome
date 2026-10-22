package com.bytedance.ee.bear.bitable.context;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/context/BitableViewType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNSPECIFIED", "GRID", "KANBAN", "FORM", "GALLERY", "GANTT", "HIERARCHY", "CALENDAR", "QUERY_FORM", "WIDGET_VIEW", "Companion", "docs-bitable-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableViewType extends Enum<BitableViewType> {
    public static final BitableViewType CALENDAR = null;
    public static final a Companion = null;
    public static final BitableViewType FORM = null;
    public static final BitableViewType GALLERY = null;
    public static final BitableViewType GANTT = null;
    public static final BitableViewType GRID = null;
    public static final BitableViewType HIERARCHY = null;
    public static final BitableViewType KANBAN = null;
    public static final BitableViewType QUERY_FORM = null;
    public static final BitableViewType UNSPECIFIED = null;
    public static final BitableViewType WIDGET_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableViewType[] f210066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f210067b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BitableViewType> getEntries() {
        return f210067b;
    }

    static {
        BitableViewType r100 = new BitableViewType("UNSPECIFIED", 0, 0);
        UNSPECIFIED = r100;
        BitableViewType r101 = new BitableViewType("GRID", 1, 1);
        GRID = r101;
        BitableViewType r102 = new BitableViewType("KANBAN", 2, 2);
        KANBAN = r102;
        BitableViewType r103 = new BitableViewType("FORM", 3, 3);
        FORM = r103;
        BitableViewType r104 = new BitableViewType("GALLERY", 4, 4);
        GALLERY = r104;
        BitableViewType r105 = new BitableViewType("GANTT", 5, 5);
        GANTT = r105;
        BitableViewType r110 = new BitableViewType("HIERARCHY", 6, 6);
        HIERARCHY = r110;
        BitableViewType r111 = new BitableViewType("CALENDAR", 7, 7);
        CALENDAR = r111;
        BitableViewType r112 = new BitableViewType("QUERY_FORM", 8, 8);
        QUERY_FORM = r112;
        BitableViewType r113 = new BitableViewType("WIDGET_VIEW", 9, 9);
        WIDGET_VIEW = r113;
        BitableViewType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f210066a = r114;
        f210067b = EnumEntriesKt.enumEntries(r114);
        Companion = new a();
    }

    public static BitableViewType[] values() {
        return (BitableViewType[]) f210066a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BitableViewType valueOf(String r100) {
        return (BitableViewType) r27.a.a(BitableViewType.class, r100);
    }

    public BitableViewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
