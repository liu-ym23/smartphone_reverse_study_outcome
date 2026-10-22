package com.bytedance.ee.bear.office.list.selectpanel;

import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelAction;", "", "<init>", "(Ljava/lang/String;I)V", "ASK_DOUBAO", "SHARE", HttpMethod.DOWNLOAD, "RENAME", "MOVE_TO", "DELETE_SOURCE", "REMOVE_RECENT", "FAVORITE", "CANCEL_FAVORITE", "COPY_LINK", "CREATE_COPY", "ADD_SHORTCUT", "OFFLINE", "FOLLOW_UPDATE", "SECURITY_LEVEL", "toListAction", "Lcom/bytedance/ee/bear/list/list/multiselect/ListSelectPanelAction;", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSelectPanelAction[] f235953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235954b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235955a = null;

        static {
            int[] r100 = new int[OfficeSelectPanelAction.values().length];
            r100[OfficeSelectPanelAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r100[OfficeSelectPanelAction.FAVORITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r100[OfficeSelectPanelAction.COPY_LINK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[OfficeSelectPanelAction.SHARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[OfficeSelectPanelAction.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[OfficeSelectPanelAction.RENAME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r100[OfficeSelectPanelAction.MOVE_TO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r100[OfficeSelectPanelAction.DELETE_SOURCE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r100[OfficeSelectPanelAction.REMOVE_RECENT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[OfficeSelectPanelAction.CANCEL_FAVORITE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r100[OfficeSelectPanelAction.CREATE_COPY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r100[OfficeSelectPanelAction.ADD_SHORTCUT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[OfficeSelectPanelAction.OFFLINE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r100[OfficeSelectPanelAction.FOLLOW_UPDATE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r100[OfficeSelectPanelAction.SECURITY_LEVEL.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            f235955a = r100;
        }
    }

    public static EnumEntries<OfficeSelectPanelAction> getEntries() {
        return f235954b;
    }

    static {
        OfficeSelectPanelAction r100 = new OfficeSelectPanelAction("ASK_DOUBAO", 0);
        ASK_DOUBAO = r100;
        OfficeSelectPanelAction r101 = new OfficeSelectPanelAction("SHARE", 1);
        SHARE = r101;
        OfficeSelectPanelAction r102 = new OfficeSelectPanelAction(HttpMethod.DOWNLOAD, 2);
        DOWNLOAD = r102;
        OfficeSelectPanelAction r103 = new OfficeSelectPanelAction("RENAME", 3);
        RENAME = r103;
        OfficeSelectPanelAction r104 = new OfficeSelectPanelAction("MOVE_TO", 4);
        MOVE_TO = r104;
        OfficeSelectPanelAction r105 = new OfficeSelectPanelAction("DELETE_SOURCE", 5);
        DELETE_SOURCE = r105;
        OfficeSelectPanelAction r110 = new OfficeSelectPanelAction("REMOVE_RECENT", 6);
        REMOVE_RECENT = r110;
        OfficeSelectPanelAction r111 = new OfficeSelectPanelAction("FAVORITE", 7);
        FAVORITE = r111;
        OfficeSelectPanelAction r112 = new OfficeSelectPanelAction("CANCEL_FAVORITE", 8);
        CANCEL_FAVORITE = r112;
        OfficeSelectPanelAction r113 = new OfficeSelectPanelAction("COPY_LINK", 9);
        COPY_LINK = r113;
        OfficeSelectPanelAction r114 = new OfficeSelectPanelAction("CREATE_COPY", 10);
        CREATE_COPY = r114;
        OfficeSelectPanelAction r115 = new OfficeSelectPanelAction("ADD_SHORTCUT", 11);
        ADD_SHORTCUT = r115;
        OfficeSelectPanelAction r106 = new OfficeSelectPanelAction("OFFLINE", 12);
        OFFLINE = r106;
        OfficeSelectPanelAction r107 = new OfficeSelectPanelAction("FOLLOW_UPDATE", 13);
        FOLLOW_UPDATE = r107;
        OfficeSelectPanelAction r108 = new OfficeSelectPanelAction("SECURITY_LEVEL", 14);
        SECURITY_LEVEL = r108;
        OfficeSelectPanelAction[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        f235953a = r109;
        f235954b = EnumEntriesKt.enumEntries(r109);
    }

    public static OfficeSelectPanelAction[] values() {
        return (OfficeSelectPanelAction[]) f235953a.clone();
    }

    public final ListSelectPanelAction toListAction() {
        switch(a.f235955a[ordinal()]) {
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

    public static OfficeSelectPanelAction valueOf(String r100) {
        return (OfficeSelectPanelAction) r27.a.a(OfficeSelectPanelAction.class, r100);
    }

    public OfficeSelectPanelAction(String r100, int r101) {
        super(r100, r101);
    }
}
