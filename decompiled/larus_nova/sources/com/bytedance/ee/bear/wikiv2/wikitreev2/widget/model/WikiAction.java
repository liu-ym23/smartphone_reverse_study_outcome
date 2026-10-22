package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiAction;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "INIT_LOAD", "RELOAD", "EXPAND", "COLLAPSE", "ADD", "DEL", "DEL_CURRENT_ONLY", "FAVORITE", "UNFAVORITE", "PIN", "UNPIN", "MOV", "SHORTCUT", "MAKE_COPY", "RENAME", "REFRESH", "PUSH_ADD", "PUSH_BATCH_ADD", "PUSH_DEL", "PUSH_MOV", "PUSH_BATCH_MOV", "PUSH_UDE_NAME_ICON", "PUSH_UDE_NODE_PERM", "PUSH_DES", "PUSH_FAVORITE", "PUSH_TOKEN", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WikiAction extends Enum<WikiAction> {
    public static final WikiAction ADD = null;
    public static final WikiAction COLLAPSE = null;
    public static final WikiAction DEL = null;
    public static final WikiAction DEL_CURRENT_ONLY = null;
    public static final WikiAction EXPAND = null;
    public static final WikiAction FAVORITE = null;
    public static final WikiAction INIT_LOAD = null;
    public static final WikiAction MAKE_COPY = null;
    public static final WikiAction MOV = null;
    public static final WikiAction PIN = null;
    public static final WikiAction PUSH_ADD = null;
    public static final WikiAction PUSH_BATCH_ADD = null;
    public static final WikiAction PUSH_BATCH_MOV = null;
    public static final WikiAction PUSH_DEL = null;
    public static final WikiAction PUSH_DES = null;
    public static final WikiAction PUSH_FAVORITE = null;
    public static final WikiAction PUSH_MOV = null;
    public static final WikiAction PUSH_TOKEN = null;
    public static final WikiAction PUSH_UDE_NAME_ICON = null;
    public static final WikiAction PUSH_UDE_NODE_PERM = null;
    public static final WikiAction REFRESH = null;
    public static final WikiAction RELOAD = null;
    public static final WikiAction RENAME = null;
    public static final WikiAction SHORTCUT = null;
    public static final WikiAction UNFAVORITE = null;
    public static final WikiAction UNKNOWN = null;
    public static final WikiAction UNPIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WikiAction[] f241749a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f241750b = null;

    public static EnumEntries<WikiAction> getEntries() {
        return f241750b;
    }

    static {
        WikiAction r100 = new WikiAction("UNKNOWN", 0);
        UNKNOWN = r100;
        WikiAction r101 = new WikiAction("INIT_LOAD", 1);
        INIT_LOAD = r101;
        WikiAction r102 = new WikiAction("RELOAD", 2);
        RELOAD = r102;
        WikiAction r103 = new WikiAction("EXPAND", 3);
        EXPAND = r103;
        WikiAction r104 = new WikiAction("COLLAPSE", 4);
        COLLAPSE = r104;
        WikiAction r105 = new WikiAction("ADD", 5);
        ADD = r105;
        WikiAction r110 = new WikiAction("DEL", 6);
        DEL = r110;
        WikiAction r111 = new WikiAction("DEL_CURRENT_ONLY", 7);
        DEL_CURRENT_ONLY = r111;
        WikiAction r112 = new WikiAction("FAVORITE", 8);
        FAVORITE = r112;
        WikiAction r113 = new WikiAction("UNFAVORITE", 9);
        UNFAVORITE = r113;
        WikiAction r114 = new WikiAction("PIN", 10);
        PIN = r114;
        WikiAction r115 = new WikiAction("UNPIN", 11);
        UNPIN = r115;
        WikiAction r106 = new WikiAction("MOV", 12);
        MOV = r106;
        WikiAction r107 = new WikiAction("SHORTCUT", 13);
        SHORTCUT = r107;
        WikiAction r108 = new WikiAction("MAKE_COPY", 14);
        MAKE_COPY = r108;
        WikiAction r109 = new WikiAction("RENAME", 15);
        RENAME = r109;
        WikiAction r116 = new WikiAction("REFRESH", 16);
        REFRESH = r116;
        WikiAction r117 = new WikiAction("PUSH_ADD", 17);
        PUSH_ADD = r117;
        WikiAction r118 = new WikiAction("PUSH_BATCH_ADD", 18);
        PUSH_BATCH_ADD = r118;
        WikiAction r119 = new WikiAction("PUSH_DEL", 19);
        PUSH_DEL = r119;
        WikiAction r120 = new WikiAction("PUSH_MOV", 20);
        PUSH_MOV = r120;
        WikiAction r121 = new WikiAction("PUSH_BATCH_MOV", 21);
        PUSH_BATCH_MOV = r121;
        WikiAction r122 = new WikiAction("PUSH_UDE_NAME_ICON", 22);
        PUSH_UDE_NAME_ICON = r122;
        WikiAction r123 = new WikiAction("PUSH_UDE_NODE_PERM", 23);
        PUSH_UDE_NODE_PERM = r123;
        WikiAction r124 = new WikiAction("PUSH_DES", 24);
        PUSH_DES = r124;
        WikiAction r125 = new WikiAction("PUSH_FAVORITE", 25);
        PUSH_FAVORITE = r125;
        WikiAction r126 = new WikiAction("PUSH_TOKEN", 26);
        PUSH_TOKEN = r126;
        WikiAction[] r127 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126};
        f241749a = r127;
        f241750b = EnumEntriesKt.enumEntries(r127);
    }

    public static WikiAction[] values() {
        return (WikiAction[]) f241749a.clone();
    }

    public static WikiAction valueOf(String r100) {
        return (WikiAction) r27.a.a(WikiAction.class, r100);
    }

    public WikiAction(String r100, int r101) {
        super(r100, r101);
    }
}
