package com.ss.android.lark.chat.entity.wallpaper;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 72\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0003789B]\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010%\u001a\u00020\nH\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010)\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0000H\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J%\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jp\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020'2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006:"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "id", "", "imageEntity", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;", "componentScene", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;", "name", "", "i18nName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "themeType", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$ThemeType;", "<init>", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;Ljava/lang/String;Ljava/util/HashMap;Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$ThemeType;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getImageEntity", "()Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;", "setImageEntity", "(Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;)V", "getComponentScene", "()Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;", "setComponentScene", "(Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getI18nName", "()Ljava/util/HashMap;", "getThemeType", "()Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$ThemeType;", "toString", "isItemSame", "", "diffable", "isContentSame", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;Ljava/lang/String;Ljava/util/HashMap;Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$ThemeType;)Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo;", "equals", "other", "", "hashCode", "", "Companion", "ThemeType", "Scene", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatThemeInfo implements Serializable, b<ChatThemeInfo> {
    public static final a Companion = null;
    public static final long FAKE_ID = -10000;
    private Scene componentScene;
    private final HashMap<String, String> i18nName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final Long f415375id;
    private ChatBackgroundEntity imageEntity;
    private String name;
    private final ThemeType themeType;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$Scene;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "DEFAULT_SCENE", "DARK", "BRIGHT", "toString", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scene extends Enum<Scene> {
        public static final Scene BRIGHT = null;
        public static final a Companion = null;
        public static final Scene DARK = null;
        public static final Scene DEFAULT_SCENE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scene[] f415376a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415377b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Scene> getEntries() {
            return f415377b;
        }

        static {
            Scene r100 = new Scene("DEFAULT_SCENE", 0, 0);
            DEFAULT_SCENE = r100;
            Scene r101 = new Scene("DARK", 1, 1);
            DARK = r101;
            Scene r102 = new Scene("BRIGHT", 2, 2);
            BRIGHT = r102;
            Scene[] r103 = {r100, r101, r102};
            f415376a = r103;
            f415377b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static Scene[] values() {
            return (Scene[]) f415376a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return name();
        }

        public final int getNumber() {
            return this.number;
        }

        @JvmStatic
        public static final Scene fromValue(int r100) {
            Companion.getClass();
            if (r100 == 0) goto L12;
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L14;
            return null;
        L14:
            return BRIGHT;
        L15:
            return DARK;
        L12:
            return DEFAULT_SCENE;
        }

        public static Scene valueOf(String r100) {
            return (Scene) r27.a.a(Scene.class, r100);
        }

        public Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeInfo$ThemeType;", "", "themeType", "", "<init>", "(Ljava/lang/String;II)V", "getThemeType", "()I", "UNKNOWN_TYPE", "SYSTEM_THEME", "CUSTOMIZE_THEME", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ThemeType extends Enum<ThemeType> {
        public static final ThemeType CUSTOMIZE_THEME = null;
        public static final a Companion = null;
        public static final ThemeType SYSTEM_THEME = null;
        public static final ThemeType UNKNOWN_TYPE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ThemeType[] f415378a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415379b = null;
        private final int themeType;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static ThemeType a(Integer r100) {
                if (r100 != null) goto L5;
            L7:
                if (r100 != null) goto L10;
            L12:
                if (r100 != null) goto L15;
            L17:
                return null;
            L15:
                if (r100.intValue() != 2) goto L17;
                return ThemeType.CUSTOMIZE_THEME;
            L10:
                if (r100.intValue() != 1) goto L12;
                return ThemeType.SYSTEM_THEME;
            L5:
                if (r100.intValue() != 0) goto L7;
                return ThemeType.UNKNOWN_TYPE;
            }
        }

        @JvmStatic
        public static final ThemeType fromValue(Integer r100) {
            Companion.getClass();
            return a.a(r100);
        }

        public static EnumEntries<ThemeType> getEntries() {
            return f415379b;
        }

        static {
            ThemeType r100 = new ThemeType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            ThemeType r101 = new ThemeType("SYSTEM_THEME", 1, 1);
            SYSTEM_THEME = r101;
            ThemeType r102 = new ThemeType("CUSTOMIZE_THEME", 2, 2);
            CUSTOMIZE_THEME = r102;
            ThemeType[] r103 = {r100, r101, r102};
            f415378a = r103;
            f415379b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static ThemeType[] values() {
            return (ThemeType[]) f415378a.clone();
        }

        public final int getThemeType() {
            return this.themeType;
        }

        public static ThemeType valueOf(String r100) {
            return (ThemeType) r27.a.a(ThemeType.class, r100);
        }

        public ThemeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.themeType = r102;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatThemeInfo copy$default(ChatThemeInfo r100, Long r101, ChatBackgroundEntity r102, Scene r103, String r104, HashMap r105, ThemeType r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f415375id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.imageEntity;
    L8:
        ChatBackgroundEntity r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.componentScene;
    L11:
        Scene r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.name;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.i18nName;
    L17:
        HashMap r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.themeType;
    L20:
        Long r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Long component1() {
        return this.f415375id;
    }

    public final ChatBackgroundEntity component2() {
        return this.imageEntity;
    }

    public final Scene component3() {
        return this.componentScene;
    }

    public final String component4() {
        return this.name;
    }

    public final HashMap<String, String> component5() {
        return this.i18nName;
    }

    public final ThemeType component6() {
        return this.themeType;
    }

    public final ChatThemeInfo copy(Long r100, ChatBackgroundEntity r110, Scene r111, String r112, HashMap<String, String> r113, ThemeType r114) {
        Intrinsics.checkNotNullParameter(r113, "i18nName");
        return new ChatThemeInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatThemeInfo) == true) goto L8;
        return false;
    L8:
        ChatThemeInfo r101 = (ChatThemeInfo) r100;
        if (Intrinsics.areEqual(this.f415375id, r101.f415375id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageEntity, r101.imageEntity) == true) goto L15;
        return false;
    L15:
        if (this.componentScene == r101.componentScene) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.i18nName, r101.i18nName) == true) goto L24;
        return false;
    L24:
        if (this.themeType == r101.themeType) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r100 = this.f415375id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ChatBackgroundEntity r104 = this.imageEntity;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Scene r107 = this.componentScene;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.name;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.i18nName.hashCode()) * 31;
        ThemeType r113 = this.themeType;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @JvmStatic
    public static final ChatThemeInfo fake() {
        Companion.getClass();
        return new ChatThemeInfo(null, new ChatBackgroundEntity(ChatBackgroundEntity.BackgroundMode.IMAGE_MODE, null, null, null), null, null, new HashMap(), ThemeType.CUSTOMIZE_THEME);
    }

    public String toString() {
        return "ChatThemeInfo(id=" + this.f415375id + ", imageEntity=" + this.imageEntity + ", componentScene=" + this.componentScene + ", name=" + this.name + ')';
    }

    public final Scene getComponentScene() {
        return this.componentScene;
    }

    public final HashMap<String, String> getI18nName() {
        return this.i18nName;
    }

    public final Long getId() {
        return this.f415375id;
    }

    public final ChatBackgroundEntity getImageEntity() {
        return this.imageEntity;
    }

    public final String getName() {
        return this.name;
    }

    public final ThemeType getThemeType() {
        return this.themeType;
    }

    public boolean isContentSame(ChatThemeInfo r100) {
        if (Intrinsics.areEqual(this, r100) == false) goto L5;
        return true;
    L5:
        Long r101 = this.f415375id;
        HashMap<String, String> r102 = null;
        if (r100 == null) goto L8;
        Long r103 = r100.f415375id;
    L10:
        if (Intrinsics.areEqual(r101, r103) == true) goto L12;
        return false;
    L12:
        ChatBackgroundEntity r104 = this.imageEntity;
        if (r104 == null) goto L20;
        if (r100 == null) goto L16;
        ChatBackgroundEntity r105 = r100.imageEntity;
    L18:
        if (r104.isContentSame(r105) == true) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == false) goto L23;
        return false;
    L23:
        Scene r107 = this.componentScene;
        if (r100 == null) goto L26;
        Scene r108 = r100.componentScene;
    L27:
        if (r107 == r108) goto L29;
        return false;
    L29:
        String r109 = this.name;
        if (r100 == null) goto L32;
        String r110 = r100.name;
    L34:
        if (Intrinsics.areEqual(r109, r110) == true) goto L36;
        return false;
    L36:
        HashMap<String, String> r111 = this.i18nName;
        if (r100 == null) goto L40;
        r102 = r100.i18nName;
    L40:
        if (Intrinsics.areEqual(r111, r102) == true) goto L42;
        return false;
    L42:
        return true;
    L32:
        r110 = null;
        goto L34
    L26:
        r108 = null;
        goto L27
    L16:
        r105 = null;
    L20:
        r106 = false;
        goto L21
    L8:
        r103 = null;
        goto L10
    }

    public boolean isItemSame(ChatThemeInfo r100) {
        Long r101 = this.f415375id;
        if (r100 == null) goto L5;
        Long r102 = r100.f415375id;
    L7:
        return Intrinsics.areEqual(r101, r102);
    L5:
        r102 = null;
        goto L7
    }

    public final void setComponentScene(Scene r100) {
        this.componentScene = r100;
    }

    public final void setImageEntity(ChatBackgroundEntity r100) {
        this.imageEntity = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((ChatThemeInfo) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((ChatThemeInfo) r100);
    }

    public ChatThemeInfo(Long r100, ChatBackgroundEntity r101, Scene r102, String r103, HashMap<String, String> r104, ThemeType r105) {
        Intrinsics.checkNotNullParameter(r104, "i18nName");
        this.f415375id = r100;
        this.imageEntity = r101;
        this.componentScene = r102;
        this.name = r103;
        this.i18nName = r104;
        this.themeType = r105;
    }
}
