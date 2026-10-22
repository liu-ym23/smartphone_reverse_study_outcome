package com.ss.android.lark.search.dto;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/search/dto/UserGroupType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, "GROUP_TYPE_NORMAL", "GROUP_TYPE_DYNAMIC", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserGroupType extends Enum<UserGroupType> {
    public static final a Companion = null;
    public static final UserGroupType GROUP_TYPE_DYNAMIC = null;
    public static final UserGroupType GROUP_TYPE_NORMAL = null;
    public static final UserGroupType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserGroupType[] f440130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440131b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static UserGroupType a(int r100) {
            if (r100 == 0) goto L11;
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L13;
            return UserGroupType.NONE;
        L13:
            return UserGroupType.GROUP_TYPE_DYNAMIC;
        L14:
            return UserGroupType.GROUP_TYPE_NORMAL;
        L11:
            return UserGroupType.NONE;
        }
    }

    @JvmStatic
    public static final UserGroupType forNumber(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<UserGroupType> getEntries() {
        return f440131b;
    }

    static {
        UserGroupType r100 = new UserGroupType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        UserGroupType r101 = new UserGroupType("GROUP_TYPE_NORMAL", 1, 1);
        GROUP_TYPE_NORMAL = r101;
        UserGroupType r102 = new UserGroupType("GROUP_TYPE_DYNAMIC", 2, 2);
        GROUP_TYPE_DYNAMIC = r102;
        UserGroupType[] r103 = {r100, r101, r102};
        f440130a = r103;
        f440131b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static UserGroupType[] values() {
        return (UserGroupType[]) f440130a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final UserGroupType valueOf(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static UserGroupType valueOf(String r100) {
        return (UserGroupType) r27.a.a(UserGroupType.class, r100);
    }

    public UserGroupType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
