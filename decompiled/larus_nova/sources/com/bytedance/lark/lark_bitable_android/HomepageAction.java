package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/HomepageAction;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/HomepageAction;", "intoInt", "", "Refresh", "LoadMore", "Delete", "CancelFavorite", "CancelPin", "OpenShare", "OpenMore", "OpenBitable", "SwitchListType", "OpenWorkSpacePanel", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum HomepageAction extends Enum<HomepageAction> {
    public static final HomepageAction CancelFavorite = null;
    public static final HomepageAction CancelPin = null;
    public static final a Companion = null;
    public static final HomepageAction Delete = null;
    public static final HomepageAction LoadMore = null;
    public static final HomepageAction OpenBitable = null;
    public static final HomepageAction OpenMore = null;
    public static final HomepageAction OpenShare = null;
    public static final HomepageAction OpenWorkSpacePanel = null;
    public static final HomepageAction Refresh = null;
    public static final HomepageAction SwitchListType = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HomepageAction[] f252958a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252959b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252960a = null;

        static {
            int[] r100 = new int[HomepageAction.values().length];
            r100[HomepageAction.Refresh.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[HomepageAction.LoadMore.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[HomepageAction.Delete.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[HomepageAction.CancelFavorite.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[HomepageAction.CancelPin.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[HomepageAction.OpenShare.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[HomepageAction.OpenMore.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[HomepageAction.OpenBitable.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[HomepageAction.SwitchListType.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[HomepageAction.OpenWorkSpacePanel.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f252960a = r100;
        }
    }

    public static EnumEntries<HomepageAction> getEntries() {
        return f252959b;
    }

    public static HomepageAction valueOf(String r100) {
        return (HomepageAction) r27.a.a(HomepageAction.class, r100);
    }

    public static HomepageAction[] values() {
        return (HomepageAction[]) f252958a.clone();
    }

    static {
        HomepageAction r100 = new HomepageAction("Refresh", 0);
        Refresh = r100;
        HomepageAction r101 = new HomepageAction("LoadMore", 1);
        LoadMore = r101;
        HomepageAction r102 = new HomepageAction("Delete", 2);
        Delete = r102;
        HomepageAction r103 = new HomepageAction("CancelFavorite", 3);
        CancelFavorite = r103;
        HomepageAction r104 = new HomepageAction("CancelPin", 4);
        CancelPin = r104;
        HomepageAction r105 = new HomepageAction("OpenShare", 5);
        OpenShare = r105;
        HomepageAction r110 = new HomepageAction("OpenMore", 6);
        OpenMore = r110;
        HomepageAction r111 = new HomepageAction("OpenBitable", 7);
        OpenBitable = r111;
        HomepageAction r112 = new HomepageAction("SwitchListType", 8);
        SwitchListType = r112;
        HomepageAction r113 = new HomepageAction("OpenWorkSpacePanel", 9);
        OpenWorkSpacePanel = r113;
        HomepageAction[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f252958a = r114;
        f252959b = EnumEntriesKt.enumEntries(r114);
        Companion = new a();
    }

    public final lark_bitable.proto.HomepageAction into() {
        switch(b.f252960a[ordinal()]) {
            case 1: goto L16;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L17:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_WORK_SPACE_PANEL;
    L18:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_SWITCH_LIST_TYPE;
    L19:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_BITABLE;
    L20:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_MORE;
    L21:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_SHARE;
    L22:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_CANCEL_PIN;
    L23:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_CANCEL_FAVORITE;
    L24:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_DELETE;
    L25:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_LOAD_MORE;
    L16:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_REFRESH;
    }

    public final int intoInt() {
        switch(b.f252960a[ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        return 9;
    L7:
        return 8;
    L8:
        return 7;
    L9:
        return 6;
    L10:
        return 5;
    L11:
        return 4;
    L12:
        return 3;
    L13:
        return 2;
    L14:
        return 1;
    L15:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final HomepageAction fromInt(int r100) {
        Companion.getClass();
        switch(r100) {
            case 0: goto L16;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("Unmatched primitive enum value: HomepageAction with ");
    L17:
        return OpenWorkSpacePanel;
    L18:
        return SwitchListType;
    L19:
        return OpenBitable;
    L20:
        return OpenMore;
    L21:
        return OpenShare;
    L22:
        return CancelPin;
    L23:
        return CancelFavorite;
    L24:
        return Delete;
    L25:
        return LoadMore;
    L16:
        return Refresh;
    }

    public HomepageAction(String r100, int r101) {
        super(r100, r101);
    }
}
