package com.bytedance.ee.bear.lark.sidebar;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/lark/sidebar/SidebarCommonMoreId;", "", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SHARE_WITH_ME", "FAVORITES", "SORT", LocalSubStickerItem.BEAUTY_TYPE_FILTER, "STYLE", "TEMPLATE", "OFFLINE", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SidebarCommonMoreId extends Enum<SidebarCommonMoreId> {
    public static final SidebarCommonMoreId FAVORITES = null;
    public static final SidebarCommonMoreId FILTER = null;
    public static final SidebarCommonMoreId OFFLINE = null;
    public static final SidebarCommonMoreId SHARE_WITH_ME = null;
    public static final SidebarCommonMoreId SORT = null;
    public static final SidebarCommonMoreId STYLE = null;
    public static final SidebarCommonMoreId TEMPLATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SidebarCommonMoreId[] f227515a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f227516b = null;

    public static EnumEntries<SidebarCommonMoreId> getEntries() {
        return f227516b;
    }

    static {
        SidebarCommonMoreId r100 = new SidebarCommonMoreId("SHARE_WITH_ME", 0);
        SHARE_WITH_ME = r100;
        SidebarCommonMoreId r101 = new SidebarCommonMoreId("FAVORITES", 1);
        FAVORITES = r101;
        SidebarCommonMoreId r102 = new SidebarCommonMoreId("SORT", 2);
        SORT = r102;
        SidebarCommonMoreId r103 = new SidebarCommonMoreId(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 3);
        FILTER = r103;
        SidebarCommonMoreId r104 = new SidebarCommonMoreId("STYLE", 4);
        STYLE = r104;
        SidebarCommonMoreId r105 = new SidebarCommonMoreId("TEMPLATE", 5);
        TEMPLATE = r105;
        SidebarCommonMoreId r110 = new SidebarCommonMoreId("OFFLINE", 6);
        OFFLINE = r110;
        SidebarCommonMoreId[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f227515a = r111;
        f227516b = EnumEntriesKt.enumEntries(r111);
    }

    public static SidebarCommonMoreId[] values() {
        return (SidebarCommonMoreId[]) f227515a.clone();
    }

    public static SidebarCommonMoreId valueOf(String r100) {
        return (SidebarCommonMoreId) r27.a.a(SidebarCommonMoreId.class, r100);
    }

    public SidebarCommonMoreId(String r100, int r101) {
        super(r100, r101);
    }
}
