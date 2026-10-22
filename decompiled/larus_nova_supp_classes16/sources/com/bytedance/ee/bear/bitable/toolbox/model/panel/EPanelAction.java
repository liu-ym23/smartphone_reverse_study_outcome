package com.bytedance.ee.bear.bitable.toolbox.model.panel;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final /* synthetic */ EPanelAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<EPanelAction> getEntries() {
        return b;
    }

    static {
        EPanelAction r0 = new EPanelAction("SHOW_FILTER_PANEL", 0, "ShowFilterPanel");
        SHOW_FILTER_PANEL = r0;
        EPanelAction r1 = new EPanelAction("CLOSE_FILTER_PANEL", 1, "CloseFilterPanel");
        CLOSE_FILTER_PANEL = r1;
        EPanelAction r3 = new EPanelAction("SHOW_SORT_PANEL", 2, "ShowSortPanel");
        SHOW_SORT_PANEL = r3;
        EPanelAction r5 = new EPanelAction("CLOSE_SORT_PANEL", 3, "CloseSortPanel");
        CLOSE_SORT_PANEL = r5;
        EPanelAction r7 = new EPanelAction("TABLE_MODEL_CHANGED", 4, "TableModelChanged");
        TABLE_MODEL_CHANGED = r7;
        EPanelAction r9 = new EPanelAction("FILTER_INFO_CHANGED", 5, "FilterInfoChanged");
        FILTER_INFO_CHANGED = r9;
        EPanelAction r11 = new EPanelAction("SORT_INFO_CHANGED", 6, "SortInfoChanged");
        SORT_INFO_CHANGED = r11;
        EPanelAction r13 = new EPanelAction("SHOW_LAYOUT_PANEL", 7, "ShowLayoutPanel");
        SHOW_LAYOUT_PANEL = r13;
        EPanelAction r12 = new EPanelAction("LAYOUT_INFO_CHANGE", 8, "LayoutInfoChanged");
        LAYOUT_INFO_CHANGE = r12;
        EPanelAction r10 = new EPanelAction("CLOSE_LAYOUT_PANEL", 9, "CloseLayoutPanel");
        CLOSE_LAYOUT_PANEL = r10;
        EPanelAction r8 = new EPanelAction("SHOW_COMPOSITE", 10, "ShowComposite");
        SHOW_COMPOSITE = r8;
        EPanelAction r6 = new EPanelAction("CLOSE_COMPOSITE", 11, "CloseComposite");
        CLOSE_COMPOSITE = r6;
        EPanelAction r4 = new EPanelAction("UPDATE_COMPOSITE_TOP_BAR_BUTTON", 12, "UpdateTitleButton");
        UPDATE_COMPOSITE_TOP_BAR_BUTTON = r4;
        EPanelAction[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
        Companion = new a();
    }

    public static EPanelAction[] values() {
        return (EPanelAction[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final EPanelAction lookup(String r5) {
        Companion.getClass();
        EPanelAction[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        EPanelAction r3 = r0[r2];
        if (TextUtils.equals(r3.getValue(), r5) == true) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return r3;
    L8:
        return null;
    }

    public static EPanelAction valueOf(String r1) {
        return (EPanelAction) r27.a.a(EPanelAction.class, r1);
    }

    public EPanelAction(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
