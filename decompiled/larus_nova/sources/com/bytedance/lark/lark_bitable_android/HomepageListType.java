package com.bytedance.lark.lark_bitable_android;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/HomepageListType;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/HomepageListType;", "intoInt", "", "Recent", WikiFolderPushPlugin.PIN, "Favorite", "Workspace", "Unknown", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum HomepageListType extends Enum<HomepageListType> {
    public static final a Companion = null;
    public static final HomepageListType Favorite = null;
    public static final HomepageListType Pin = null;
    public static final HomepageListType Recent = null;
    public static final HomepageListType Unknown = null;
    public static final HomepageListType Workspace = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HomepageListType[] f252961a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252962b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252963a = null;

        static {
            int[] r100 = new int[HomepageListType.values().length];
            r100[HomepageListType.Recent.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[HomepageListType.Pin.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[HomepageListType.Favorite.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[HomepageListType.Workspace.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[HomepageListType.Unknown.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f252963a = r100;
        }
    }

    public static EnumEntries<HomepageListType> getEntries() {
        return f252962b;
    }

    public static HomepageListType valueOf(String r100) {
        return (HomepageListType) r27.a.a(HomepageListType.class, r100);
    }

    public static HomepageListType[] values() {
        return (HomepageListType[]) f252961a.clone();
    }

    static {
        HomepageListType r100 = new HomepageListType("Recent", 0);
        Recent = r100;
        HomepageListType r101 = new HomepageListType(WikiFolderPushPlugin.PIN, 1);
        Pin = r101;
        HomepageListType r102 = new HomepageListType("Favorite", 2);
        Favorite = r102;
        HomepageListType r103 = new HomepageListType("Workspace", 3);
        Workspace = r103;
        HomepageListType r104 = new HomepageListType("Unknown", 4);
        Unknown = r104;
        HomepageListType[] r105 = {r100, r101, r102, r103, r104};
        f252961a = r105;
        f252962b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public final lark_bitable.proto.HomepageListType into() {
        int r100 = b.f252963a[ordinal()];
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L23;
        if (r100 == 3) goto L22;
        if (r100 == 4) goto L21;
        if (r100 != 5) goto L14;
        return lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_UNKNOWN;
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_WORKSPACE;
    L22:
        return lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_FAVORITE;
    L23:
        return lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_PIN;
    L19:
        return lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_RECENT;
    }

    public final int intoInt() {
        int r100 = b.f252963a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L7;
        return 1;
    L7:
        if (r100 != 3) goto L9;
        return 2;
    L9:
        if (r100 != 4) goto L11;
        return 3;
    L11:
        if (r100 != 5) goto L14;
        return 4;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final HomepageListType fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L19;
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L21;
        if (r100 != 4) goto L14;
        return Unknown;
    L14:
        throw new RuntimeException("Unmatched primitive enum value: HomepageListType with ");
    L21:
        return Workspace;
    L22:
        return Favorite;
    L23:
        return Pin;
    L19:
        return Recent;
    }

    public HomepageListType(String r100, int r101) {
        super(r100, r101);
    }
}
