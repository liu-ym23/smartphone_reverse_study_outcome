package com.bytedance.ee.bear.bitable.toolbox.model.panel;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/EPanelAction;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SHOW_FILTER_PANEL", "CLOSE_FILTER_PANEL", "SHOW_SORT_PANEL", "CLOSE_SORT_PANEL", "TABLE_MODEL_CHANGED", "FILTER_INFO_CHANGED", "SORT_INFO_CHANGED", "SHOW_LAYOUT_PANEL", "LAYOUT_INFO_CHANGE", "CLOSE_LAYOUT_PANEL", "SHOW_COMPOSITE", "CLOSE_COMPOSITE", "UPDATE_COMPOSITE_TOP_BAR_BUTTON", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EPanelAction extends Enum<EPanelAction> {
    public static final EPanelAction CLOSE_COMPOSITE = null;
    public static final EPanelAction CLOSE_FILTER_PANEL = null;
    public static final EPanelAction CLOSE_LAYOUT_PANEL = null;
    public static final EPanelAction CLOSE_SORT_PANEL = null;
    public static final a Companion = null;
    public static final EPanelAction FILTER_INFO_CHANGED = null;
    public static final EPanelAction LAYOUT_INFO_CHANGE = null;
    public static final EPanelAction SHOW_COMPOSITE = null;
    public static final EPanelAction SHOW_FILTER_PANEL = null;
    public static final EPanelAction SHOW_LAYOUT_PANEL = null;
    public static final EPanelAction SHOW_SORT_PANEL = null;
    public static final EPanelAction SORT_INFO_CHANGED = null;
    public static final EPanelAction TABLE_MODEL_CHANGED = null;
    public static final EPanelAction UPDATE_COMPOSITE_TOP_BAR_BUTTON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EPanelAction[] f215998a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215999b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<EPanelAction> getEntries() {
        return f215999b;
    }

    static {
        EPanelAction r100 = new EPanelAction("SHOW_FILTER_PANEL", 0, "ShowFilterPanel");
        SHOW_FILTER_PANEL = r100;
        EPanelAction r101 = new EPanelAction("CLOSE_FILTER_PANEL", 1, "CloseFilterPanel");
        CLOSE_FILTER_PANEL = r101;
        EPanelAction r102 = new EPanelAction("SHOW_SORT_PANEL", 2, "ShowSortPanel");
        SHOW_SORT_PANEL = r102;
        EPanelAction r103 = new EPanelAction("CLOSE_SORT_PANEL", 3, "CloseSortPanel");
        CLOSE_SORT_PANEL = r103;
        EPanelAction r104 = new EPanelAction("TABLE_MODEL_CHANGED", 4, "TableModelChanged");
        TABLE_MODEL_CHANGED = r104;
        EPanelAction r105 = new EPanelAction("FILTER_INFO_CHANGED", 5, "FilterInfoChanged");
        FILTER_INFO_CHANGED = r105;
        EPanelAction r110 = new EPanelAction("SORT_INFO_CHANGED", 6, "SortInfoChanged");
        SORT_INFO_CHANGED = r110;
        EPanelAction r111 = new EPanelAction("SHOW_LAYOUT_PANEL", 7, "ShowLayoutPanel");
        SHOW_LAYOUT_PANEL = r111;
        EPanelAction r112 = new EPanelAction("LAYOUT_INFO_CHANGE", 8, "LayoutInfoChanged");
        LAYOUT_INFO_CHANGE = r112;
        EPanelAction r113 = new EPanelAction("CLOSE_LAYOUT_PANEL", 9, "CloseLayoutPanel");
        CLOSE_LAYOUT_PANEL = r113;
        EPanelAction r106 = new EPanelAction("SHOW_COMPOSITE", 10, "ShowComposite");
        SHOW_COMPOSITE = r106;
        EPanelAction r107 = new EPanelAction("CLOSE_COMPOSITE", 11, "CloseComposite");
        CLOSE_COMPOSITE = r107;
        EPanelAction r108 = new EPanelAction("UPDATE_COMPOSITE_TOP_BAR_BUTTON", 12, "UpdateTitleButton");
        UPDATE_COMPOSITE_TOP_BAR_BUTTON = r108;
        EPanelAction[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108};
        f215998a = r109;
        f215999b = EnumEntriesKt.enumEntries(r109);
        Companion = new a();
    }

    public static EPanelAction[] values() {
        return (EPanelAction[]) f215998a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final EPanelAction lookup(String r100) {
        Companion.getClass();
        EPanelAction[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        EPanelAction r104 = r101[r103];
        if (TextUtils.equals(r104.getValue(), r100) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return null;
    }

    public static EPanelAction valueOf(String r100) {
        return (EPanelAction) r27.a.a(EPanelAction.class, r100);
    }

    public EPanelAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
