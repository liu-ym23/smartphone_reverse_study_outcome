package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/SubViewType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NativeGrid", "NativeCard", "NativeGallery", "NativeFrom", "LynxCalendar", "FasterGrid", "FasterGantt", "FasterGallery", "FasterKanban", "FasterCalendar", "NewFrom", "Query", "WidgetView", "Task", "Invalid", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SubViewType extends Enum<SubViewType> {
    public static final a Companion = null;
    public static final SubViewType FasterCalendar = null;
    public static final SubViewType FasterGallery = null;
    public static final SubViewType FasterGantt = null;
    public static final SubViewType FasterGrid = null;
    public static final SubViewType FasterKanban = null;
    public static final SubViewType Invalid = null;
    public static final SubViewType LynxCalendar = null;
    public static final SubViewType NativeCard = null;
    public static final SubViewType NativeFrom = null;
    public static final SubViewType NativeGallery = null;
    public static final SubViewType NativeGrid = null;
    public static final SubViewType NewFrom = null;
    public static final SubViewType Query = null;
    public static final SubViewType Task = null;
    public static final SubViewType WidgetView = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubViewType[] f213300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f213301b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<SubViewType> getEntries() {
        return f213301b;
    }

    static {
        SubViewType r100 = new SubViewType("NativeGrid", 0, SceneModel.NativeGrid);
        NativeGrid = r100;
        SubViewType r101 = new SubViewType("NativeCard", 1, SceneModel.NativeCard);
        NativeCard = r101;
        SubViewType r102 = new SubViewType("NativeGallery", 2, SceneModel.NativeGallery);
        NativeGallery = r102;
        SubViewType r103 = new SubViewType("NativeFrom", 3, "native_form");
        NativeFrom = r103;
        SubViewType r104 = new SubViewType("LynxCalendar", 4, "lynx_calendar");
        LynxCalendar = r104;
        SubViewType r105 = new SubViewType("FasterGrid", 5, "faster_grid");
        FasterGrid = r105;
        SubViewType r110 = new SubViewType("FasterGantt", 6, "faster_gantt");
        FasterGantt = r110;
        SubViewType r111 = new SubViewType("FasterGallery", 7, "faster_gallery");
        FasterGallery = r111;
        SubViewType r112 = new SubViewType("FasterKanban", 8, "faster_kanban");
        FasterKanban = r112;
        SubViewType r113 = new SubViewType("FasterCalendar", 9, "faster_calendar");
        FasterCalendar = r113;
        SubViewType r106 = new SubViewType("NewFrom", 10, "new_form");
        NewFrom = r106;
        SubViewType r107 = new SubViewType("Query", 11, "query");
        Query = r107;
        SubViewType r108 = new SubViewType("WidgetView", 12, "widget_view");
        WidgetView = r108;
        SubViewType r109 = new SubViewType("Task", 13, "task");
        Task = r109;
        SubViewType r114 = new SubViewType("Invalid", 14, "invalid");
        Invalid = r114;
        SubViewType[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109, r114};
        f213300a = r115;
        f213301b = EnumEntriesKt.enumEntries(r115);
        Companion = new a();
    }

    public static SubViewType[] values() {
        return (SubViewType[]) f213300a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static SubViewType valueOf(String r100) {
        return (SubViewType) r27.a.a(SubViewType.class, r100);
    }

    public SubViewType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
