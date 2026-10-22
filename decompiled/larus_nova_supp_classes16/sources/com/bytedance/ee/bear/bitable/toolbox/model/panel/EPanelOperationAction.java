package com.bytedance.ee.bear.bitable.toolbox.model.panel;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/EPanelOperationAction;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SET_FILTER", "SORT_RECORD", "CLOSE_FILTER_PANEL", "CLOSE_SORT_PANEL", "SET_LAYOUT", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EPanelOperationAction extends Enum<EPanelOperationAction> {
    public static final EPanelOperationAction CLOSE_FILTER_PANEL = null;
    public static final EPanelOperationAction CLOSE_SORT_PANEL = null;
    public static final a Companion = null;
    public static final EPanelOperationAction SET_FILTER = null;
    public static final EPanelOperationAction SET_LAYOUT = null;
    public static final EPanelOperationAction SORT_RECORD = null;
    public static final /* synthetic */ EPanelOperationAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<EPanelOperationAction> getEntries() {
        return b;
    }

    static {
        EPanelOperationAction r0 = new EPanelOperationAction("SET_FILTER", 0, "SetFilter");
        SET_FILTER = r0;
        EPanelOperationAction r1 = new EPanelOperationAction("SORT_RECORD", 1, "SortRecord");
        SORT_RECORD = r1;
        EPanelOperationAction r3 = new EPanelOperationAction("CLOSE_FILTER_PANEL", 2, "CloseFilterPanel");
        CLOSE_FILTER_PANEL = r3;
        EPanelOperationAction r5 = new EPanelOperationAction("CLOSE_SORT_PANEL", 3, "CloseSortPanel");
        CLOSE_SORT_PANEL = r5;
        EPanelOperationAction r7 = new EPanelOperationAction("SET_LAYOUT", 4, "SetLayout");
        SET_LAYOUT = r7;
        EPanelOperationAction[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static EPanelOperationAction[] values() {
        return (EPanelOperationAction[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final EPanelOperationAction lookup(String r5) {
        Companion.getClass();
        EPanelOperationAction[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        EPanelOperationAction r3 = r0[r2];
        if (TextUtils.equals(r3.getValue(), r5) == true) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return r3;
    L8:
        return null;
    }

    public static EPanelOperationAction valueOf(String r1) {
        return (EPanelOperationAction) r27.a.a(EPanelOperationAction.class, r1);
    }

    public EPanelOperationAction(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
