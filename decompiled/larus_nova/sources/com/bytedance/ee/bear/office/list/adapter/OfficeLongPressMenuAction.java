package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuAction;", "", "<init>", "(Ljava/lang/String;I)V", "ASK_DOUBAO", "SHARE", HttpMethod.DOWNLOAD, "EXPORT_AS", "MULTI_SELECT", "STAR", "COPY_LINK", "MORE", "RENAME", "MAKE_COPY", "MOVE_TO", "ADD_SHORTCUT", "SECRET_SETTING", "DELETE_SOURCE", "REMOVE_RECENT", "SORT", LocalSubStickerItem.BEAUTY_TYPE_FILTER, "TOGGLE_DISPLAY_MODE", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeLongPressMenuAction extends Enum<OfficeLongPressMenuAction> {
    public static final OfficeLongPressMenuAction ADD_SHORTCUT = null;
    public static final OfficeLongPressMenuAction ASK_DOUBAO = null;
    public static final OfficeLongPressMenuAction COPY_LINK = null;
    public static final OfficeLongPressMenuAction DELETE_SOURCE = null;
    public static final OfficeLongPressMenuAction DOWNLOAD = null;
    public static final OfficeLongPressMenuAction EXPORT_AS = null;
    public static final OfficeLongPressMenuAction FILTER = null;
    public static final OfficeLongPressMenuAction MAKE_COPY = null;
    public static final OfficeLongPressMenuAction MORE = null;
    public static final OfficeLongPressMenuAction MOVE_TO = null;
    public static final OfficeLongPressMenuAction MULTI_SELECT = null;
    public static final OfficeLongPressMenuAction REMOVE_RECENT = null;
    public static final OfficeLongPressMenuAction RENAME = null;
    public static final OfficeLongPressMenuAction SECRET_SETTING = null;
    public static final OfficeLongPressMenuAction SHARE = null;
    public static final OfficeLongPressMenuAction SORT = null;
    public static final OfficeLongPressMenuAction STAR = null;
    public static final OfficeLongPressMenuAction TOGGLE_DISPLAY_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeLongPressMenuAction[] f235689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235690b = null;

    public static EnumEntries<OfficeLongPressMenuAction> getEntries() {
        return f235690b;
    }

    static {
        OfficeLongPressMenuAction r100 = new OfficeLongPressMenuAction("ASK_DOUBAO", 0);
        ASK_DOUBAO = r100;
        OfficeLongPressMenuAction r101 = new OfficeLongPressMenuAction("SHARE", 1);
        SHARE = r101;
        OfficeLongPressMenuAction r102 = new OfficeLongPressMenuAction(HttpMethod.DOWNLOAD, 2);
        DOWNLOAD = r102;
        OfficeLongPressMenuAction r103 = new OfficeLongPressMenuAction("EXPORT_AS", 3);
        EXPORT_AS = r103;
        OfficeLongPressMenuAction r104 = new OfficeLongPressMenuAction("MULTI_SELECT", 4);
        MULTI_SELECT = r104;
        OfficeLongPressMenuAction r105 = new OfficeLongPressMenuAction("STAR", 5);
        STAR = r105;
        OfficeLongPressMenuAction r110 = new OfficeLongPressMenuAction("COPY_LINK", 6);
        COPY_LINK = r110;
        OfficeLongPressMenuAction r111 = new OfficeLongPressMenuAction("MORE", 7);
        MORE = r111;
        OfficeLongPressMenuAction r112 = new OfficeLongPressMenuAction("RENAME", 8);
        RENAME = r112;
        OfficeLongPressMenuAction r113 = new OfficeLongPressMenuAction("MAKE_COPY", 9);
        MAKE_COPY = r113;
        OfficeLongPressMenuAction r114 = new OfficeLongPressMenuAction("MOVE_TO", 10);
        MOVE_TO = r114;
        OfficeLongPressMenuAction r115 = new OfficeLongPressMenuAction("ADD_SHORTCUT", 11);
        ADD_SHORTCUT = r115;
        OfficeLongPressMenuAction r106 = new OfficeLongPressMenuAction("SECRET_SETTING", 12);
        SECRET_SETTING = r106;
        OfficeLongPressMenuAction r107 = new OfficeLongPressMenuAction("DELETE_SOURCE", 13);
        DELETE_SOURCE = r107;
        OfficeLongPressMenuAction r108 = new OfficeLongPressMenuAction("REMOVE_RECENT", 14);
        REMOVE_RECENT = r108;
        OfficeLongPressMenuAction r109 = new OfficeLongPressMenuAction("SORT", 15);
        SORT = r109;
        OfficeLongPressMenuAction r116 = new OfficeLongPressMenuAction(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 16);
        FILTER = r116;
        OfficeLongPressMenuAction r117 = new OfficeLongPressMenuAction("TOGGLE_DISPLAY_MODE", 17);
        TOGGLE_DISPLAY_MODE = r117;
        OfficeLongPressMenuAction[] r118 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
        f235689a = r118;
        f235690b = EnumEntriesKt.enumEntries(r118);
    }

    public static OfficeLongPressMenuAction[] values() {
        return (OfficeLongPressMenuAction[]) f235689a.clone();
    }

    public static OfficeLongPressMenuAction valueOf(String r100) {
        return (OfficeLongPressMenuAction) r27.a.a(OfficeLongPressMenuAction.class, r100);
    }

    public OfficeLongPressMenuAction(String r100, int r101) {
        super(r100, r101);
    }
}
