package com.larus.settings.provider.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 Q2\u00020\u0001:\u0001QB¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u0019\u0010\u001dJ\u0018\u00108\u001a\u0002092\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0003H\u0016J\b\u0010;\u001a\u00020\u0003H\u0016J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010?\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J¶\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\u0003HÖ\u0001J\t\u0010P\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b7\u0010\"¨\u0006R"}, d2 = {"Lcom/larus/settings/provider/creation/CreationUpdateDialogItemConfig;", "Landroid/os/Parcelable;", "instructionType", "", "uniqueId", "", "enterAlbum", "", EventConstant.Key.RETAIN_PROMPT, "", "mediaConfig", "Lcom/larus/settings/provider/creation/MediaConfig;", "titleConfig", "Lcom/larus/settings/provider/creation/TitleConfig;", "descriptionConfig", "Lcom/larus/settings/provider/creation/DescriptionConfig;", "backgroundConfig", "Lcom/larus/settings/provider/creation/BackgroundConfig;", "buttonConfig", "Lcom/larus/settings/provider/creation/ButtonConfig;", "imageUrl", "title", "content", "buttonText", "defaultModelId", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/settings/provider/creation/MediaConfig;Lcom/larus/settings/provider/creation/TitleConfig;Lcom/larus/settings/provider/creation/DescriptionConfig;Lcom/larus/settings/provider/creation/BackgroundConfig;Lcom/larus/settings/provider/creation/ButtonConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getInstructionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUniqueId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnterAlbum", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPrompt", "()Ljava/lang/String;", "getMediaConfig", "()Lcom/larus/settings/provider/creation/MediaConfig;", "getTitleConfig", "()Lcom/larus/settings/provider/creation/TitleConfig;", "getDescriptionConfig", "()Lcom/larus/settings/provider/creation/DescriptionConfig;", "getBackgroundConfig", "()Lcom/larus/settings/provider/creation/BackgroundConfig;", "getButtonConfig", "()Lcom/larus/settings/provider/creation/ButtonConfig;", "getImageUrl", "getTitle", "getContent", "getButtonText", "getDefaultModelId", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/settings/provider/creation/MediaConfig;Lcom/larus/settings/provider/creation/TitleConfig;Lcom/larus/settings/provider/creation/DescriptionConfig;Lcom/larus/settings/provider/creation/BackgroundConfig;Lcom/larus/settings/provider/creation/ButtonConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/larus/settings/provider/creation/CreationUpdateDialogItemConfig;", "equals", "other", "", "hashCode", "toString", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationUpdateDialogItemConfig implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("background_config")
    private final BackgroundConfig backgroundConfig;

    @SerializedName("button_config")
    private final ButtonConfig buttonConfig;

    @SerializedName("button_text")
    private final String buttonText;

    @SerializedName("content")
    private final String content;

    @SerializedName("default_model_id")
    private final Long defaultModelId;

    @SerializedName("description_config")
    private final DescriptionConfig descriptionConfig;

    @SerializedName("enter_album")
    private final Boolean enterAlbum;

    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("instruction_type")
    private final Integer instructionType;

    @SerializedName("media_config")
    private final MediaConfig mediaConfig;

    @SerializedName("default_prompt")
    private final String prompt;

    @SerializedName("title")
    private final String title;

    @SerializedName("title_config")
    private final TitleConfig titleConfig;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    private final Long uniqueId;

    public static final class a implements Parcelable.Creator<CreationUpdateDialogItemConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationUpdateDialogItemConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Object r100 = r110.readValue(Integer.TYPE.getClassLoader());
            if ((r100 instanceof Integer) == false) goto L5;
            Integer r101 = (Integer) r100;
        L6:
            Class r102 = Long.TYPE;
            Object r103 = r110.readValue(r102.getClassLoader());
            if ((r103 instanceof Long) == false) goto L9;
            Long r104 = (Long) r103;
        L10:
            Object r105 = r110.readValue(Boolean.TYPE.getClassLoader());
            if ((r105 instanceof Boolean) == false) goto L13;
            Boolean r106 = (Boolean) r105;
        L14:
            String r107 = r110.readString();
            MediaConfig r108 = (MediaConfig) r110.readParcelable(MediaConfig.class.getClassLoader());
            TitleConfig r109 = (TitleConfig) r110.readParcelable(TitleConfig.class.getClassLoader());
            DescriptionConfig r111 = (DescriptionConfig) r110.readParcelable(DescriptionConfig.class.getClassLoader());
            BackgroundConfig r112 = (BackgroundConfig) r110.readParcelable(BackgroundConfig.class.getClassLoader());
            ButtonConfig r113 = (ButtonConfig) r110.readParcelable(ButtonConfig.class.getClassLoader());
            String r114 = r110.readString();
            String r115 = r110.readString();
            String r116 = r110.readString();
            String r117 = r110.readString();
            Object r118 = r110.readValue(r102.getClassLoader());
            if ((r118 instanceof Long) == false) goto L17;
            Long r119 = (Long) r118;
        L19:
            return new CreationUpdateDialogItemConfig(r101, r104, r106, r107, r108, r109, r111, r112, r113, r114, r115, r116, r117, r119);
        L17:
            r119 = null;
            goto L19
        L13:
            r106 = null;
            goto L14
        L9:
            r104 = null;
            goto L10
        L5:
            r101 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CreationUpdateDialogItemConfig[] newArray(int r100) {
            return new CreationUpdateDialogItemConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CreationUpdateDialogItemConfig() {
        this(-1, -1L, Boolean.FALSE, null, null, null, null, null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationUpdateDialogItemConfig) == true) goto L8;
        return false;
    L8:
        CreationUpdateDialogItemConfig r101 = (CreationUpdateDialogItemConfig) r100;
        if (Intrinsics.areEqual(this.instructionType, r101.instructionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uniqueId, r101.uniqueId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enterAlbum, r101.enterAlbum) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prompt, r101.prompt) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mediaConfig, r101.mediaConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.titleConfig, r101.titleConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.descriptionConfig, r101.descriptionConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.backgroundConfig, r101.backgroundConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.buttonConfig, r101.buttonConfig) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.buttonText, r101.buttonText) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.defaultModelId, r101.defaultModelId) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.instructionType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.uniqueId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.enterAlbum;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.prompt;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        MediaConfig r113 = this.mediaConfig;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        TitleConfig r116 = this.titleConfig;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        DescriptionConfig r119 = this.descriptionConfig;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        BackgroundConfig r122 = this.backgroundConfig;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        ButtonConfig r125 = this.buttonConfig;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.imageUrl;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.title;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.content;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.buttonText;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Long r140 = this.defaultModelId;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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

    public final String toString() {
        return "CreationUpdateDialogItemConfig(instructionType=" + this.instructionType + ", uniqueId=" + this.uniqueId + ", enterAlbum=" + this.enterAlbum + ", prompt=" + this.prompt + ", mediaConfig=" + this.mediaConfig + ", titleConfig=" + this.titleConfig + ", descriptionConfig=" + this.descriptionConfig + ", backgroundConfig=" + this.backgroundConfig + ", buttonConfig=" + this.buttonConfig + ", imageUrl=" + this.imageUrl + ", title=" + this.title + ", content=" + this.content + ", buttonText=" + this.buttonText + ", defaultModelId=" + this.defaultModelId + ')';
    }

    public final BackgroundConfig a() {
        return this.backgroundConfig;
    }

    public final ButtonConfig b() {
        return this.buttonConfig;
    }

    public final DescriptionConfig c() {
        return this.descriptionConfig;
    }

    public final String d() {
        return this.imageUrl;
    }

    public final Integer e() {
        return this.instructionType;
    }

    public final MediaConfig g() {
        return this.mediaConfig;
    }

    public final TitleConfig h() {
        return this.titleConfig;
    }

    public final Long i() {
        return this.uniqueId;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeValue(this.instructionType);
        r100.writeValue(this.uniqueId);
        r100.writeValue(this.enterAlbum);
        r100.writeString(this.prompt);
        r100.writeParcelable(this.mediaConfig, r101);
        r100.writeParcelable(this.titleConfig, r101);
        r100.writeParcelable(this.descriptionConfig, r101);
        r100.writeParcelable(this.backgroundConfig, r101);
        r100.writeParcelable(this.buttonConfig, r101);
        r100.writeString(this.imageUrl);
        r100.writeString(this.title);
        r100.writeString(this.content);
        r100.writeString(this.buttonText);
        r100.writeValue(this.defaultModelId);
    }

    public CreationUpdateDialogItemConfig(Integer r100, Long r101, Boolean r102, String r103, MediaConfig r104, TitleConfig r105, DescriptionConfig r106, BackgroundConfig r107, ButtonConfig r108, String r110, String r111, String r112, String r113, Long r114) {
        this.instructionType = r100;
        this.uniqueId = r101;
        this.enterAlbum = r102;
        this.prompt = r103;
        this.mediaConfig = r104;
        this.titleConfig = r105;
        this.descriptionConfig = r106;
        this.backgroundConfig = r107;
        this.buttonConfig = r108;
        this.imageUrl = r110;
        this.title = r111;
        this.content = r112;
        this.buttonText = r113;
        this.defaultModelId = r114;
    }
}
