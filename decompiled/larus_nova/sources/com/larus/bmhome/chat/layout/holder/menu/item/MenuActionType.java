package com.larus.bmhome.chat.layout.holder.menu.item;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/menu/item/MenuActionType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "SAVE_IMAGE", "SAVE_SEARCH_IMAGE", "SHARE_MESSAGE", "SHARE_IMAGE", "SHARE_SEARCH_IMAGE", OpenNetMethod.REPORT, "REPORT_MUSIC", "EXPORT_FILE", "MORE", "SAVE_VIDEO", "SHARE_VIDEO", "PODCAST", "DOWNLOAD_FILE", "FULLSCREEN_CODE", "COPY_CODE", "SAVE_CODE_IMAGE", "COPY_CODE_IMAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MenuActionType extends Enum<MenuActionType> {
    public static final MenuActionType COPY_CODE = null;
    public static final MenuActionType COPY_CODE_IMAGE = null;
    public static final MenuActionType DOWNLOAD_FILE = null;
    public static final MenuActionType EXPORT_FILE = null;
    public static final MenuActionType FULLSCREEN_CODE = null;
    public static final MenuActionType MORE = null;
    public static final MenuActionType PODCAST = null;
    public static final MenuActionType REPORT = null;
    public static final MenuActionType REPORT_MUSIC = null;
    public static final MenuActionType SAVE_CODE_IMAGE = null;
    public static final MenuActionType SAVE_IMAGE = null;
    public static final MenuActionType SAVE_SEARCH_IMAGE = null;
    public static final MenuActionType SAVE_VIDEO = null;
    public static final MenuActionType SHARE_IMAGE = null;
    public static final MenuActionType SHARE_MESSAGE = null;
    public static final MenuActionType SHARE_SEARCH_IMAGE = null;
    public static final MenuActionType SHARE_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MenuActionType[] f303975a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f303976b = null;
    private final int type;

    public static EnumEntries<MenuActionType> getEntries() {
        return f303976b;
    }

    static {
        MenuActionType r100 = new MenuActionType("SAVE_IMAGE", 0, 3);
        SAVE_IMAGE = r100;
        MenuActionType r101 = new MenuActionType("SAVE_SEARCH_IMAGE", 1, 4);
        SAVE_SEARCH_IMAGE = r101;
        MenuActionType r102 = new MenuActionType("SHARE_MESSAGE", 2, 5);
        SHARE_MESSAGE = r102;
        MenuActionType r103 = new MenuActionType("SHARE_IMAGE", 3, 6);
        SHARE_IMAGE = r103;
        MenuActionType r110 = new MenuActionType("SHARE_SEARCH_IMAGE", 4, 7);
        SHARE_SEARCH_IMAGE = r110;
        MenuActionType r111 = new MenuActionType(OpenNetMethod.REPORT, 5, 8);
        REPORT = r111;
        MenuActionType r112 = new MenuActionType("REPORT_MUSIC", 6, 9);
        REPORT_MUSIC = r112;
        MenuActionType r104 = new MenuActionType("EXPORT_FILE", 7, 10);
        EXPORT_FILE = r104;
        MenuActionType r113 = new MenuActionType("MORE", 8, 11);
        MORE = r113;
        MenuActionType r114 = new MenuActionType("SAVE_VIDEO", 9, 12);
        SAVE_VIDEO = r114;
        MenuActionType r115 = new MenuActionType("SHARE_VIDEO", 10, 13);
        SHARE_VIDEO = r115;
        MenuActionType r105 = new MenuActionType("PODCAST", 11, 14);
        PODCAST = r105;
        MenuActionType r106 = new MenuActionType("DOWNLOAD_FILE", 12, 15);
        DOWNLOAD_FILE = r106;
        MenuActionType r107 = new MenuActionType("FULLSCREEN_CODE", 13, 16);
        FULLSCREEN_CODE = r107;
        MenuActionType r108 = new MenuActionType("COPY_CODE", 14, 17);
        COPY_CODE = r108;
        MenuActionType r109 = new MenuActionType("SAVE_CODE_IMAGE", 15, 18);
        SAVE_CODE_IMAGE = r109;
        MenuActionType r116 = new MenuActionType("COPY_CODE_IMAGE", 16, 19);
        COPY_CODE_IMAGE = r116;
        MenuActionType[] r117 = {r100, r101, r102, r103, r110, r111, r112, r104, r113, r114, r115, r105, r106, r107, r108, r109, r116};
        f303975a = r117;
        f303976b = EnumEntriesKt.enumEntries(r117);
    }

    public static MenuActionType[] values() {
        return (MenuActionType[]) f303975a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static MenuActionType valueOf(String r100) {
        return (MenuActionType) r27.a.a(MenuActionType.class, r100);
    }

    public MenuActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
