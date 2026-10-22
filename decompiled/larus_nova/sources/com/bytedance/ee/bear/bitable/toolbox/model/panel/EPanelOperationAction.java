package com.bytedance.ee.bear.bitable.toolbox.model.panel;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/EPanelOperationAction;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SET_FILTER", "SORT_RECORD", "CLOSE_FILTER_PANEL", "CLOSE_SORT_PANEL", "SET_LAYOUT", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EPanelOperationAction extends Enum<EPanelOperationAction> {
    public static final EPanelOperationAction CLOSE_FILTER_PANEL = null;
    public static final EPanelOperationAction CLOSE_SORT_PANEL = null;
    public static final a Companion = null;
    public static final EPanelOperationAction SET_FILTER = null;
    public static final EPanelOperationAction SET_LAYOUT = null;
    public static final EPanelOperationAction SORT_RECORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EPanelOperationAction[] f216000a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f216001b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<EPanelOperationAction> getEntries() {
        return f216001b;
    }

    static {
        EPanelOperationAction r100 = new EPanelOperationAction("SET_FILTER", 0, "SetFilter");
        SET_FILTER = r100;
        EPanelOperationAction r101 = new EPanelOperationAction("SORT_RECORD", 1, "SortRecord");
        SORT_RECORD = r101;
        EPanelOperationAction r102 = new EPanelOperationAction("CLOSE_FILTER_PANEL", 2, "CloseFilterPanel");
        CLOSE_FILTER_PANEL = r102;
        EPanelOperationAction r103 = new EPanelOperationAction("CLOSE_SORT_PANEL", 3, "CloseSortPanel");
        CLOSE_SORT_PANEL = r103;
        EPanelOperationAction r104 = new EPanelOperationAction("SET_LAYOUT", 4, "SetLayout");
        SET_LAYOUT = r104;
        EPanelOperationAction[] r105 = {r100, r101, r102, r103, r104};
        f216000a = r105;
        f216001b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static EPanelOperationAction[] values() {
        return (EPanelOperationAction[]) f216000a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final EPanelOperationAction lookup(String r100) {
        Companion.getClass();
        EPanelOperationAction[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        EPanelOperationAction r104 = r101[r103];
        if (TextUtils.equals(r104.getValue(), r100) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return null;
    }

    public static EPanelOperationAction valueOf(String r100) {
        return (EPanelOperationAction) r27.a.a(EPanelOperationAction.class, r100);
    }

    public EPanelOperationAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
