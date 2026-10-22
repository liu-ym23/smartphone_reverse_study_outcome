package com.ss.android.lark.chat.entity.wallpaper;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002()B5\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0019\u001a\u00020\bH\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0000H\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006*"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "backgroundMode", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$BackgroundMode;", "colorInfo", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;", "imageKey", "", "fsUnit", "<init>", "(Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$BackgroundMode;Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundMode", "()Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$BackgroundMode;", "setBackgroundMode", "(Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$BackgroundMode;)V", "getColorInfo", "()Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;", "setColorInfo", "(Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;)V", "getImageKey", "()Ljava/lang/String;", "setImageKey", "(Ljava/lang/String;)V", "getFsUnit", "toString", "isItemSame", "", "diffable", "isContentSame", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "BackgroundMode", "ColorInfo", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatBackgroundEntity implements Serializable, b<ChatBackgroundEntity> {
    private BackgroundMode backgroundMode;
    private ColorInfo colorInfo;
    private final String fsUnit;
    private String imageKey;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$BackgroundMode;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "ORIGIN_MODE", "COLOR_MODE", "IMAGE_MODE", "toString", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BackgroundMode extends Enum<BackgroundMode> {
        public static final BackgroundMode COLOR_MODE = null;
        public static final a Companion = null;
        public static final BackgroundMode IMAGE_MODE = null;
        public static final BackgroundMode ORIGIN_MODE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BackgroundMode[] f415373a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415374b = null;
        private final int number;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static BackgroundMode a(int r100) {
                if (r100 == 0) goto L11;
                if (r100 == 1) goto L14;
                if (r100 == 2) goto L13;
                return BackgroundMode.ORIGIN_MODE;
            L13:
                return BackgroundMode.IMAGE_MODE;
            L14:
                return BackgroundMode.COLOR_MODE;
            L11:
                return BackgroundMode.ORIGIN_MODE;
            }
        }

        @JvmStatic
        public static final BackgroundMode fromValue(int r100) {
            Companion.getClass();
            return a.a(r100);
        }

        public static EnumEntries<BackgroundMode> getEntries() {
            return f415374b;
        }

        static {
            BackgroundMode r100 = new BackgroundMode("ORIGIN_MODE", 0, 0);
            ORIGIN_MODE = r100;
            BackgroundMode r101 = new BackgroundMode("COLOR_MODE", 1, 1);
            COLOR_MODE = r101;
            BackgroundMode r102 = new BackgroundMode("IMAGE_MODE", 2, 2);
            IMAGE_MODE = r102;
            BackgroundMode[] r103 = {r100, r101, r102};
            f415373a = r103;
            f415374b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static BackgroundMode[] values() {
            return (BackgroundMode[]) f415373a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return name();
        }

        public final int getNumber() {
            return this.number;
        }

        @JvmStatic
        public static final BackgroundMode valueOf(int r100) {
            Companion.getClass();
            return a.a(r100);
        }

        public static BackgroundMode valueOf(String r100) {
            return (BackgroundMode) r27.a.a(BackgroundMode.class, r100);
        }

        public BackgroundMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ2\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "udToken", "", "lightColor", "", "darkColor", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getUdToken", "()Ljava/lang/String;", "setUdToken", "(Ljava/lang/String;)V", "getLightColor", "()Ljava/lang/Integer;", "setLightColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDarkColor", "setDarkColor", "toString", "isItemSame", "", "diffable", "isContentSame", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity$ColorInfo;", "equals", "other", "", "hashCode", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ColorInfo implements Serializable, b<ColorInfo> {
        private Integer darkColor;
        private Integer lightColor;
        private String udToken;

        public static /* synthetic */ ColorInfo copy$default(ColorInfo r100, String r101, Integer r102, Integer r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.udToken;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.lightColor;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.darkColor;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.udToken;
        }

        public final Integer component2() {
            return this.lightColor;
        }

        public final Integer component3() {
            return this.darkColor;
        }

        public final ColorInfo copy(String r100, Integer r101, Integer r102) {
            return new ColorInfo(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ColorInfo) == true) goto L8;
            return false;
        L8:
            ColorInfo r101 = (ColorInfo) r100;
            if (Intrinsics.areEqual(this.udToken, r101.udToken) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.lightColor, r101.lightColor) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.darkColor, r101.darkColor) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r100 = this.udToken;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.lightColor;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.darkColor;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "ColorInfo(udToken=" + this.udToken + ", lightColor=" + this.lightColor + ", darkColor=" + this.darkColor + ')';
        }

        public final Integer getDarkColor() {
            return this.darkColor;
        }

        public final Integer getLightColor() {
            return this.lightColor;
        }

        public final String getUdToken() {
            return this.udToken;
        }

        public boolean isContentSame(ColorInfo r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<ColorInfo> r101 = ColorInfo.class;
        L10:
            if (Intrinsics.areEqual(ColorInfo.class, r101) == true) goto L13;
            return false;
        L13:
            if (Intrinsics.areEqual(this.udToken, r100.udToken) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.lightColor, r100.lightColor) == true) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(this.darkColor, r100.darkColor) == true) goto L21;
            return false;
        L21:
            return true;
        L8:
            r101 = null;
            goto L10
        }

        @Override // y28.b
        public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
            return isItemSame((ColorInfo) r100);
        }

        public final void setDarkColor(Integer r100) {
            this.darkColor = r100;
        }

        public final void setLightColor(Integer r100) {
            this.lightColor = r100;
        }

        public final void setUdToken(String r100) {
            this.udToken = r100;
        }

        @Override // y28.b
        public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
            return isContentSame((ColorInfo) r100);
        }

        public boolean isItemSame(ColorInfo r100) {
            return isContentSame(r100);
        }

        public ColorInfo(String r100, Integer r101, Integer r102) {
            this.udToken = r100;
            this.lightColor = r101;
            this.darkColor = r102;
        }
    }

    public static /* synthetic */ ChatBackgroundEntity copy$default(ChatBackgroundEntity r100, BackgroundMode r101, ColorInfo r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.backgroundMode;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.colorInfo;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.imageKey;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.fsUnit;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final BackgroundMode component1() {
        return this.backgroundMode;
    }

    public final ColorInfo component2() {
        return this.colorInfo;
    }

    public final String component3() {
        return this.imageKey;
    }

    public final String component4() {
        return this.fsUnit;
    }

    public final ChatBackgroundEntity copy(BackgroundMode r100, ColorInfo r101, String r102, String r103) {
        return new ChatBackgroundEntity(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatBackgroundEntity) == true) goto L8;
        return false;
    L8:
        ChatBackgroundEntity r101 = (ChatBackgroundEntity) r100;
        if (this.backgroundMode == r101.backgroundMode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.colorInfo, r101.colorInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageKey, r101.imageKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fsUnit, r101.fsUnit) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        BackgroundMode r100 = this.backgroundMode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ColorInfo r104 = this.colorInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.imageKey;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.fsUnit;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "ChatBackgroundEntity(backgroundMode=" + this.backgroundMode + ", colorInfo=" + this.colorInfo + ", imageKey=" + this.imageKey + ", fsUnit=" + this.fsUnit + ')';
    }

    public final BackgroundMode getBackgroundMode() {
        return this.backgroundMode;
    }

    public final ColorInfo getColorInfo() {
        return this.colorInfo;
    }

    public final String getFsUnit() {
        return this.fsUnit;
    }

    public final String getImageKey() {
        return this.imageKey;
    }

    public boolean isContentSame(ChatBackgroundEntity r100) {
        if (Intrinsics.areEqual(this, r100) == false) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<ChatBackgroundEntity> r101 = ChatBackgroundEntity.class;
    L10:
        if (Intrinsics.areEqual(ChatBackgroundEntity.class, r101) == true) goto L13;
        return false;
    L13:
        if (this.backgroundMode == r100.backgroundMode) goto L15;
        return false;
    L15:
        ColorInfo r102 = this.colorInfo;
        if (r102 != null) goto L18;
    L20:
        boolean r103 = false;
    L21:
        if (r103 == false) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.imageKey, r100.imageKey) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fsUnit, r100.fsUnit) == true) goto L29;
        return false;
    L29:
        return true;
    L18:
        if (r102.isContentSame(r100.colorInfo) == true) goto L20;
        r103 = true;
        goto L21
    L8:
        r101 = null;
        goto L10
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((ChatBackgroundEntity) r100);
    }

    public final void setBackgroundMode(BackgroundMode r100) {
        this.backgroundMode = r100;
    }

    public final void setColorInfo(ColorInfo r100) {
        this.colorInfo = r100;
    }

    public final void setImageKey(String r100) {
        this.imageKey = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((ChatBackgroundEntity) r100);
    }

    public boolean isItemSame(ChatBackgroundEntity r100) {
        return isContentSame(r100);
    }

    public ChatBackgroundEntity(BackgroundMode r100, ColorInfo r101, String r102, String r103) {
        this.backgroundMode = r100;
        this.colorInfo = r101;
        this.imageKey = r102;
        this.fsUnit = r103;
    }

    public /* synthetic */ ChatBackgroundEntity(BackgroundMode r100, ColorInfo r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
