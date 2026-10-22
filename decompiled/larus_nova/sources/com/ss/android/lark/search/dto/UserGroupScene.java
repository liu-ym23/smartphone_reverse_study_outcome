package com.ss.android.lark.search.dto;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/search/dto/UserGroupScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, "GROUP_SCENE_CCM", "GROUP_SCENE_CALENDAR", "GROUP_SCENE_HELP_DESK", "GROUP_SCENE_APPROVAL", "GROUP_SCENE_SUBSCRIPTIONS", "GROUP_SCENE_OKR", "GROUP_SCENE_OPEN_PLATFORM", "GROUP_SCENE_DICTIONARY", "GROUP_SCENE_APP_CENTER", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserGroupScene extends Enum<UserGroupScene> {
    public static final a Companion = null;
    public static final String DEFAULT_NAME_SPACE = "admin";
    public static final UserGroupScene GROUP_SCENE_APPROVAL = null;
    public static final UserGroupScene GROUP_SCENE_APP_CENTER = null;
    public static final UserGroupScene GROUP_SCENE_CALENDAR = null;
    public static final UserGroupScene GROUP_SCENE_CCM = null;
    public static final UserGroupScene GROUP_SCENE_DICTIONARY = null;
    public static final UserGroupScene GROUP_SCENE_HELP_DESK = null;
    public static final UserGroupScene GROUP_SCENE_OKR = null;
    public static final UserGroupScene GROUP_SCENE_OPEN_PLATFORM = null;
    public static final UserGroupScene GROUP_SCENE_SUBSCRIPTIONS = null;
    public static final UserGroupScene NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserGroupScene[] f440128a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440129b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<UserGroupScene> getEntries() {
        return f440129b;
    }

    static {
        UserGroupScene r100 = new UserGroupScene(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        UserGroupScene r101 = new UserGroupScene("GROUP_SCENE_CCM", 1, 1);
        GROUP_SCENE_CCM = r101;
        UserGroupScene r102 = new UserGroupScene("GROUP_SCENE_CALENDAR", 2, 2);
        GROUP_SCENE_CALENDAR = r102;
        UserGroupScene r103 = new UserGroupScene("GROUP_SCENE_HELP_DESK", 3, 3);
        GROUP_SCENE_HELP_DESK = r103;
        UserGroupScene r104 = new UserGroupScene("GROUP_SCENE_APPROVAL", 4, 4);
        GROUP_SCENE_APPROVAL = r104;
        UserGroupScene r105 = new UserGroupScene("GROUP_SCENE_SUBSCRIPTIONS", 5, 5);
        GROUP_SCENE_SUBSCRIPTIONS = r105;
        UserGroupScene r110 = new UserGroupScene("GROUP_SCENE_OKR", 6, 6);
        GROUP_SCENE_OKR = r110;
        UserGroupScene r111 = new UserGroupScene("GROUP_SCENE_OPEN_PLATFORM", 7, 7);
        GROUP_SCENE_OPEN_PLATFORM = r111;
        UserGroupScene r112 = new UserGroupScene("GROUP_SCENE_DICTIONARY", 8, 8);
        GROUP_SCENE_DICTIONARY = r112;
        UserGroupScene r113 = new UserGroupScene("GROUP_SCENE_APP_CENTER", 9, 9);
        GROUP_SCENE_APP_CENTER = r113;
        UserGroupScene[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f440128a = r114;
        f440129b = EnumEntriesKt.enumEntries(r114);
        Companion = new a();
    }

    public static UserGroupScene[] values() {
        return (UserGroupScene[]) f440128a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserGroupScene valueOf(String r100) {
        return (UserGroupScene) r27.a.a(UserGroupScene.class, r100);
    }

    public UserGroupScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
