package com.bytedance.ee.bear.office.list.selectpanel;

import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelAction;", "", "<init>", "(Ljava/lang/String;I)V", "ASK_DOUBAO", "SHARE", "DOWNLOAD", "RENAME", "MOVE_TO", "DELETE_SOURCE", "REMOVE_RECENT", "FAVORITE", "CANCEL_FAVORITE", "COPY_LINK", "CREATE_COPY", "ADD_SHORTCUT", "OFFLINE", "FOLLOW_UPDATE", "SECURITY_LEVEL", "toListAction", "Lcom/bytedance/ee/bear/list/list/multiselect/ListSelectPanelAction;", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSelectPanelAction extends Enum<OfficeSelectPanelAction> {
    public static final OfficeSelectPanelAction ADD_SHORTCUT = null;
    public static final OfficeSelectPanelAction ASK_DOUBAO = null;
    public static final OfficeSelectPanelAction CANCEL_FAVORITE = null;
    public static final OfficeSelectPanelAction COPY_LINK = null;
    public static final OfficeSelectPanelAction CREATE_COPY = null;
    public static final OfficeSelectPanelAction DELETE_SOURCE = null;
    public static final OfficeSelectPanelAction DOWNLOAD = null;
    public static final OfficeSelectPanelAction FAVORITE = null;
    public static final OfficeSelectPanelAction FOLLOW_UPDATE = null;
    public static final OfficeSelectPanelAction MOVE_TO = null;
    public static final OfficeSelectPanelAction OFFLINE = null;
    public static final OfficeSelectPanelAction REMOVE_RECENT = null;
    public static final OfficeSelectPanelAction RENAME = null;
    public static final OfficeSelectPanelAction SECURITY_LEVEL = null;
    public static final OfficeSelectPanelAction SHARE = null;
    public static final /* synthetic */ OfficeSelectPanelAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSelectPanelAction.values().length];
            r0[OfficeSelectPanelAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r0[OfficeSelectPanelAction.FAVORITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r0[OfficeSelectPanelAction.COPY_LINK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[OfficeSelectPanelAction.SHARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[OfficeSelectPanelAction.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[OfficeSelectPanelAction.RENAME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r0[OfficeSelectPanelAction.MOVE_TO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r0[OfficeSelectPanelAction.DELETE_SOURCE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r0[OfficeSelectPanelAction.REMOVE_RECENT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r0[OfficeSelectPanelAction.CANCEL_FAVORITE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r0[OfficeSelectPanelAction.CREATE_COPY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r0[OfficeSelectPanelAction.ADD_SHORTCUT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r0[OfficeSelectPanelAction.OFFLINE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r0[OfficeSelectPanelAction.FOLLOW_UPDATE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r0[OfficeSelectPanelAction.SECURITY_LEVEL.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            a = r0;
        }
    }

    public static EnumEntries<OfficeSelectPanelAction> getEntries() {
        return b;
    }

    static {
        OfficeSelectPanelAction r0 = new OfficeSelectPanelAction("ASK_DOUBAO", 0);
        ASK_DOUBAO = r0;
        OfficeSelectPanelAction r1 = new OfficeSelectPanelAction("SHARE", 1);
        SHARE = r1;
        OfficeSelectPanelAction r3 = new OfficeSelectPanelAction("DOWNLOAD", 2);
        DOWNLOAD = r3;
        OfficeSelectPanelAction r5 = new OfficeSelectPanelAction("RENAME", 3);
        RENAME = r5;
        OfficeSelectPanelAction r7 = new OfficeSelectPanelAction("MOVE_TO", 4);
        MOVE_TO = r7;
        OfficeSelectPanelAction r9 = new OfficeSelectPanelAction("DELETE_SOURCE", 5);
        DELETE_SOURCE = r9;
        OfficeSelectPanelAction r11 = new OfficeSelectPanelAction("REMOVE_RECENT", 6);
        REMOVE_RECENT = r11;
        OfficeSelectPanelAction r13 = new OfficeSelectPanelAction("FAVORITE", 7);
        FAVORITE = r13;
        OfficeSelectPanelAction r15 = new OfficeSelectPanelAction("CANCEL_FAVORITE", 8);
        CANCEL_FAVORITE = r15;
        OfficeSelectPanelAction r14 = new OfficeSelectPanelAction("COPY_LINK", 9);
        COPY_LINK = r14;
        OfficeSelectPanelAction r12 = new OfficeSelectPanelAction("CREATE_COPY", 10);
        CREATE_COPY = r12;
        OfficeSelectPanelAction r10 = new OfficeSelectPanelAction("ADD_SHORTCUT", 11);
        ADD_SHORTCUT = r10;
        OfficeSelectPanelAction r8 = new OfficeSelectPanelAction("OFFLINE", 12);
        OFFLINE = r8;
        OfficeSelectPanelAction r6 = new OfficeSelectPanelAction("FOLLOW_UPDATE", 13);
        FOLLOW_UPDATE = r6;
        OfficeSelectPanelAction r4 = new OfficeSelectPanelAction("SECURITY_LEVEL", 14);
        SECURITY_LEVEL = r4;
        OfficeSelectPanelAction[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static OfficeSelectPanelAction[] values() {
        return (OfficeSelectPanelAction[]) a.clone();
    }

    public final ListSelectPanelAction toListAction() {
        switch(a.a[ordinal()]) {
            case 1: goto L18;
            case 2: goto L18;
            case 3: goto L18;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L20;
            default: goto L5;
        };
    L18:
        return null;
    L5:
        throw new NoWhenBranchMatchedException();
    L20:
        return ListSelectPanelAction.SECURITY_LEVEL;
    L21:
        return ListSelectPanelAction.FOLLOW_UPDATE;
    L22:
        return ListSelectPanelAction.OFFLINE;
    L23:
        return ListSelectPanelAction.ADD_SHORTCUT;
    L24:
        return ListSelectPanelAction.CREATE_COPY;
    L25:
        return ListSelectPanelAction.CANCEL_FAVORITE;
    L26:
        return ListSelectPanelAction.REMOVE_RECENT;
    L27:
        return ListSelectPanelAction.DELETE_SOURCE;
    L28:
        return ListSelectPanelAction.MOVE_TO;
    L29:
        return ListSelectPanelAction.RENAME;
    L30:
        return ListSelectPanelAction.DOWNLOAD;
    L31:
        return ListSelectPanelAction.SHARE;
    }

    public static OfficeSelectPanelAction valueOf(String r1) {
        return (OfficeSelectPanelAction) r27.a.a(OfficeSelectPanelAction.class, r1);
    }

    public OfficeSelectPanelAction(String r1, int r2) {
        super(r1, r2);
    }
}
