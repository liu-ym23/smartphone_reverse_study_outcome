package com.ss.lark.android.avatar.statistics;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import com.ss.lark.android.avatar.ui.AvatarSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;
import s5c.d;
import s5c.e;

/* JADX INFO: loaded from: classes40.dex */
public final class AvatarHit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Object, e> f456660a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/lark/android/avatar/statistics/AvatarHit$Click;", "Lcom/ss/android/lark/statistics/extensions/IClickParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHANGE", "SHOT", "FROM_ALBUM", "CANCEL", "AVATAR_CHANGE", "AVATAR_DECORATE", "DEFAULT_AVATAR", "PHOTO_SAVE", "CONFIRM", "avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Click extends Enum<Click> implements d {
        public static final Click AVATAR_CHANGE = null;
        public static final Click AVATAR_DECORATE = null;
        public static final Click CANCEL = null;
        public static final Click CHANGE = null;
        public static final Click CONFIRM = null;
        public static final Click DEFAULT_AVATAR = null;
        public static final Click FROM_ALBUM = null;
        public static final Click PHOTO_SAVE = null;
        public static final Click SHOT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Click[] f456661a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f456662b = null;
        private final String value;

        public static EnumEntries<Click> getEntries() {
            return f456662b;
        }

        @Override // s5c.d
        public String getKey() {
            return "click";
        }

        static {
            Click r100 = new Click("CHANGE", 0, "change");
            CHANGE = r100;
            Click r101 = new Click("SHOT", 1, "shot");
            SHOT = r101;
            Click r102 = new Click("FROM_ALBUM", 2, "from_album");
            FROM_ALBUM = r102;
            Click r103 = new Click("CANCEL", 3, "cancel");
            CANCEL = r103;
            Click r104 = new Click("AVATAR_CHANGE", 4, "avatar_change");
            AVATAR_CHANGE = r104;
            Click r105 = new Click("AVATAR_DECORATE", 5, "avatar_decorate");
            AVATAR_DECORATE = r105;
            Click r110 = new Click("DEFAULT_AVATAR", 6, "default_avatar");
            DEFAULT_AVATAR = r110;
            Click r111 = new Click("PHOTO_SAVE", 7, "photo_save");
            PHOTO_SAVE = r111;
            Click r112 = new Click("CONFIRM", 8, "confirm");
            CONFIRM = r112;
            Click[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
            f456661a = r113;
            f456662b = EnumEntriesKt.enumEntries(r113);
        }

        public static Click[] values() {
            return (Click[]) f456661a.clone();
        }

        @Override // s5c.d
        public JSONObject toJson() {
            return d.b.c(this);
        }

        @Override // s5c.d
        public String getValue() {
            return this.value;
        }

        public static Click valueOf(String r100) {
            return (Click) a.a(Click.class, r100);
        }

        @Override // s5c.d
        public d plus(Map<String, ? extends Object> r100) {
            return d.b.a(this, r100);
        }

        @Override // s5c.d
        public d plus(d r100) {
            return d.b.b(this, r100);
        }

        public Click(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/lark/android/avatar/statistics/AvatarHit$ProfilePhotoSettingClick;", "Lcom/ss/android/lark/statistics/extensions/IClickParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHANGE_PROFILE_PHOTO", "SET_AS_PROFILE_PHOTO", "OPEN_PREVIOUS_PROFILE_PHOTO", "avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ProfilePhotoSettingClick extends Enum<ProfilePhotoSettingClick> implements d {
        public static final ProfilePhotoSettingClick CHANGE_PROFILE_PHOTO = null;
        public static final ProfilePhotoSettingClick OPEN_PREVIOUS_PROFILE_PHOTO = null;
        public static final ProfilePhotoSettingClick SET_AS_PROFILE_PHOTO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ProfilePhotoSettingClick[] f456663a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f456664b = null;
        private final String value;

        public static EnumEntries<ProfilePhotoSettingClick> getEntries() {
            return f456664b;
        }

        @Override // s5c.d
        public String getKey() {
            return "click";
        }

        static {
            ProfilePhotoSettingClick r100 = new ProfilePhotoSettingClick("CHANGE_PROFILE_PHOTO", 0, "change_profile_photo");
            CHANGE_PROFILE_PHOTO = r100;
            ProfilePhotoSettingClick r101 = new ProfilePhotoSettingClick("SET_AS_PROFILE_PHOTO", 1, "set_as_profile_photo");
            SET_AS_PROFILE_PHOTO = r101;
            ProfilePhotoSettingClick r102 = new ProfilePhotoSettingClick("OPEN_PREVIOUS_PROFILE_PHOTO", 2, "open_previous_profile_photo");
            OPEN_PREVIOUS_PROFILE_PHOTO = r102;
            ProfilePhotoSettingClick[] r103 = {r100, r101, r102};
            f456663a = r103;
            f456664b = EnumEntriesKt.enumEntries(r103);
        }

        public static ProfilePhotoSettingClick[] values() {
            return (ProfilePhotoSettingClick[]) f456663a.clone();
        }

        @Override // s5c.d
        public JSONObject toJson() {
            return d.b.c(this);
        }

        @Override // s5c.d
        public String getValue() {
            return this.value;
        }

        public static ProfilePhotoSettingClick valueOf(String r100) {
            return (ProfilePhotoSettingClick) a.a(ProfilePhotoSettingClick.class, r100);
        }

        @Override // s5c.d
        public d plus(Map<String, ? extends Object> r100) {
            return d.b.a(this, r100);
        }

        @Override // s5c.d
        public d plus(d r100) {
            return d.b.b(this, r100);
        }

        public ProfilePhotoSettingClick(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/lark/android/avatar/statistics/AvatarHit$Target;", "Lcom/ss/android/lark/statistics/extensions/ITargetParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BACKGROUND_CHANGE_VIEW", "PUBLIC_PHOTOTGRAPH_VIEW", "IM_CHAT_ALBUM_LIST_VIEW", "PROFILE_BACKGROUND_MAIN_VIEW", UserProfileEvent.POSITION_NONE, "IM_AVATAR_CHANGE_VIEW", "IM_AVATAR_DECORATE_VIEW", "IM_AVATAR_CONFIRM_VIEW", "avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Target extends Enum<Target> implements e {
        public static final Target BACKGROUND_CHANGE_VIEW = null;
        public static final Target IM_AVATAR_CHANGE_VIEW = null;
        public static final Target IM_AVATAR_CONFIRM_VIEW = null;
        public static final Target IM_AVATAR_DECORATE_VIEW = null;
        public static final Target IM_CHAT_ALBUM_LIST_VIEW = null;
        public static final Target NONE = null;
        public static final Target PROFILE_BACKGROUND_MAIN_VIEW = null;
        public static final Target PUBLIC_PHOTOTGRAPH_VIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Target[] f456665a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f456666b = null;
        private final String value;

        public static EnumEntries<Target> getEntries() {
            return f456666b;
        }

        @Override // s5c.d
        public String getKey() {
            return PickerReporterConstants.KEY.TARGET;
        }

        static {
            Target r100 = new Target("BACKGROUND_CHANGE_VIEW", 0, "profile_background_change_view");
            BACKGROUND_CHANGE_VIEW = r100;
            Target r101 = new Target("PUBLIC_PHOTOTGRAPH_VIEW", 1, "public_photograph_view");
            PUBLIC_PHOTOTGRAPH_VIEW = r101;
            Target r102 = new Target("IM_CHAT_ALBUM_LIST_VIEW", 2, "im_chat_album_list_view");
            IM_CHAT_ALBUM_LIST_VIEW = r102;
            Target r103 = new Target("PROFILE_BACKGROUND_MAIN_VIEW", 3, "profile_background_main_view");
            PROFILE_BACKGROUND_MAIN_VIEW = r103;
            Target r104 = new Target(UserProfileEvent.POSITION_NONE, 4, "none");
            NONE = r104;
            Target r105 = new Target("IM_AVATAR_CHANGE_VIEW", 5, "im_avatar_change_view");
            IM_AVATAR_CHANGE_VIEW = r105;
            Target r110 = new Target("IM_AVATAR_DECORATE_VIEW", 6, "im_avatar_decorate_view");
            IM_AVATAR_DECORATE_VIEW = r110;
            Target r111 = new Target("IM_AVATAR_CONFIRM_VIEW", 7, "im_avatar_confirm_view");
            IM_AVATAR_CONFIRM_VIEW = r111;
            Target[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f456665a = r112;
            f456666b = EnumEntriesKt.enumEntries(r112);
        }

        public static Target[] values() {
            return (Target[]) f456665a.clone();
        }

        @Override // s5c.d
        public JSONObject toJson() {
            return d.b.c(this);
        }

        @Override // s5c.d
        public String getValue() {
            return this.value;
        }

        public static Target valueOf(String r100) {
            return (Target) a.a(Target.class, r100);
        }

        @Override // s5c.d
        public d plus(Map<String, ? extends Object> r100) {
            return d.b.a(this, r100);
        }

        @Override // s5c.d
        public d plus(d r100) {
            return d.b.b(this, r100);
        }

        public Target(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        Click r100 = Click.SHOT;
        Target r101 = Target.NONE;
        f456660a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, r101), TuplesKt.to(Click.FROM_ALBUM, r101), TuplesKt.to(Click.DEFAULT_AVATAR, Target.IM_AVATAR_CONFIRM_VIEW), TuplesKt.to(Click.PHOTO_SAVE, r101)});
    }

    @JvmStatic
    public static final void a(AvatarSource r100, Click r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "click");
        if (r100 != AvatarSource.SELF_AVATAR) goto L8;
        e r102 = f456660a.get(r101);
        if (r102 == null) goto L9;
        Statistics.sendEvent("im_avatar_change_click", r101.plus(r102).toJson());
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void b(AvatarSource r100, ProfilePhotoSettingClick r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "click");
        if (r100 != AvatarSource.SELF_AVATAR) goto L6;
        Statistics.sendEvent("profile_photo_setting_click", r101.toJson());
        return;
    }
}
