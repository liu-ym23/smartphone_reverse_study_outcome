package com.bytedance.ee.bear.office.export.space;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.ss.android.download.api.config.HttpMethod;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceLongPressAction;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "ASK_DOUBAO", "SHARE", HttpMethod.DOWNLOAD, "EXPORT_AS", "MULTI_SELECT", "FAVORITE", "COPY_LINK", "MORE", "RENAME", "MOVE_TO", "ADD_SHORTCUT", "SECURITY_SETTING", "DELETE", "SORT", LocalSubStickerItem.BEAUTY_TYPE_FILTER, "TOGGLE_DISPLAY_MODE", "MAKE_COPY", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceLongPressAction extends Enum<OfficeSpaceLongPressAction> implements Serializable {
    public static final OfficeSpaceLongPressAction ADD_SHORTCUT = null;
    public static final OfficeSpaceLongPressAction ASK_DOUBAO = null;
    public static final OfficeSpaceLongPressAction COPY_LINK = null;
    public static final OfficeSpaceLongPressAction DELETE = null;
    public static final OfficeSpaceLongPressAction DOWNLOAD = null;
    public static final OfficeSpaceLongPressAction EXPORT_AS = null;
    public static final OfficeSpaceLongPressAction FAVORITE = null;
    public static final OfficeSpaceLongPressAction FILTER = null;
    public static final OfficeSpaceLongPressAction MAKE_COPY = null;
    public static final OfficeSpaceLongPressAction MORE = null;
    public static final OfficeSpaceLongPressAction MOVE_TO = null;
    public static final OfficeSpaceLongPressAction MULTI_SELECT = null;
    public static final OfficeSpaceLongPressAction RENAME = null;
    public static final OfficeSpaceLongPressAction SECURITY_SETTING = null;
    public static final OfficeSpaceLongPressAction SHARE = null;
    public static final OfficeSpaceLongPressAction SORT = null;
    public static final OfficeSpaceLongPressAction TOGGLE_DISPLAY_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSpaceLongPressAction[] f235461a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235462b = null;

    public static EnumEntries<OfficeSpaceLongPressAction> getEntries() {
        return f235462b;
    }

    static {
        OfficeSpaceLongPressAction r100 = new OfficeSpaceLongPressAction("ASK_DOUBAO", 0);
        ASK_DOUBAO = r100;
        OfficeSpaceLongPressAction r101 = new OfficeSpaceLongPressAction("SHARE", 1);
        SHARE = r101;
        OfficeSpaceLongPressAction r102 = new OfficeSpaceLongPressAction(HttpMethod.DOWNLOAD, 2);
        DOWNLOAD = r102;
        OfficeSpaceLongPressAction r103 = new OfficeSpaceLongPressAction("EXPORT_AS", 3);
        EXPORT_AS = r103;
        OfficeSpaceLongPressAction r104 = new OfficeSpaceLongPressAction("MULTI_SELECT", 4);
        MULTI_SELECT = r104;
        OfficeSpaceLongPressAction r105 = new OfficeSpaceLongPressAction("FAVORITE", 5);
        FAVORITE = r105;
        OfficeSpaceLongPressAction r110 = new OfficeSpaceLongPressAction("COPY_LINK", 6);
        COPY_LINK = r110;
        OfficeSpaceLongPressAction r111 = new OfficeSpaceLongPressAction("MORE", 7);
        MORE = r111;
        OfficeSpaceLongPressAction r112 = new OfficeSpaceLongPressAction("RENAME", 8);
        RENAME = r112;
        OfficeSpaceLongPressAction r113 = new OfficeSpaceLongPressAction("MOVE_TO", 9);
        MOVE_TO = r113;
        OfficeSpaceLongPressAction r114 = new OfficeSpaceLongPressAction("ADD_SHORTCUT", 10);
        ADD_SHORTCUT = r114;
        OfficeSpaceLongPressAction r115 = new OfficeSpaceLongPressAction("SECURITY_SETTING", 11);
        SECURITY_SETTING = r115;
        OfficeSpaceLongPressAction r106 = new OfficeSpaceLongPressAction("DELETE", 12);
        DELETE = r106;
        OfficeSpaceLongPressAction r107 = new OfficeSpaceLongPressAction("SORT", 13);
        SORT = r107;
        OfficeSpaceLongPressAction r108 = new OfficeSpaceLongPressAction(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 14);
        FILTER = r108;
        OfficeSpaceLongPressAction r109 = new OfficeSpaceLongPressAction("TOGGLE_DISPLAY_MODE", 15);
        TOGGLE_DISPLAY_MODE = r109;
        OfficeSpaceLongPressAction r116 = new OfficeSpaceLongPressAction("MAKE_COPY", 16);
        MAKE_COPY = r116;
        OfficeSpaceLongPressAction[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
        f235461a = r117;
        f235462b = EnumEntriesKt.enumEntries(r117);
    }

    public static OfficeSpaceLongPressAction[] values() {
        return (OfficeSpaceLongPressAction[]) f235461a.clone();
    }

    public static OfficeSpaceLongPressAction valueOf(String r100) {
        return (OfficeSpaceLongPressAction) r27.a.a(OfficeSpaceLongPressAction.class, r100);
    }

    public OfficeSpaceLongPressAction(String r100, int r101) {
        super(r100, r101);
    }
}
