package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010Jj\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0006J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0006R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0004\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0007\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\b\u0010\u0010R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\f\u0010\u0010¨\u0006+"}, d2 = {"Lcom/larus/bmhome/auth/BgImageStep;", "Landroid/os/Parcelable;", "botGenAddImageSetting", "", "isAiImageWorkflow", "bgImageOpenMode", "", "isImageGuide", "isStepGenByCharacterBot", "showBotType", "", "", "isIndependentVoiceSetting", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;)V", "getBotGenAddImageSetting", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBgImageOpenMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowBotType", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/bmhome/auth/BgImageStep;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgImageStep implements Parcelable {
    public static final Parcelable.Creator<BgImageStep> CREATOR = null;

    @SerializedName("bg_image_open_mode")
    private final Integer bgImageOpenMode;

    @SerializedName("bot_gen_add_image_setting")
    private final Boolean botGenAddImageSetting;

    @SerializedName("is_ai_image_workflow")
    private final Boolean isAiImageWorkflow;

    @SerializedName("is_image_guide")
    private final Boolean isImageGuide;

    @SerializedName("is_independent_voice_setting")
    private final Boolean isIndependentVoiceSetting;

    @SerializedName("is_step_gen_by_character_bot")
    private final Boolean isStepGenByCharacterBot;

    @SerializedName("show_bot_type")
    private final List<String> showBotType;

    public static final class a implements Parcelable.Creator<BgImageStep> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BgImageStep createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            boolean r100 = false;
            if (r110.readInt() != 0) goto L6;
            Boolean r101 = null;
        L11:
            if (r110.readInt() != 0) goto L14;
            Boolean r102 = null;
        L19:
            if (r110.readInt() != 0) goto L21;
            Integer r103 = null;
        L23:
            if (r110.readInt() != 0) goto L26;
            Boolean r104 = null;
        L31:
            if (r110.readInt() != 0) goto L34;
            Boolean r105 = null;
        L38:
            ArrayList<String> r111 = r110.createStringArrayList();
            if (r110.readInt() != 0) goto L42;
            Boolean r112 = null;
        L46:
            return new BgImageStep(r101, r102, r103, r104, r105, r111, r112);
        L42:
            if (r110.readInt() == 0) goto L44;
            r100 = true;
        L44:
            r112 = Boolean.valueOf(r100);
            goto L46
        L34:
            if (r110.readInt() == 0) goto L36;
            boolean r106 = true;
        L37:
            r105 = Boolean.valueOf(r106);
            goto L38
        L36:
            r106 = false;
            goto L37
        L26:
            if (r110.readInt() == 0) goto L28;
            boolean r107 = true;
        L29:
            r104 = Boolean.valueOf(r107);
            goto L31
        L28:
            r107 = false;
            goto L29
        L21:
            r103 = Integer.valueOf(r110.readInt());
            goto L23
        L14:
            if (r110.readInt() == 0) goto L16;
            boolean r108 = true;
        L17:
            r102 = Boolean.valueOf(r108);
            goto L19
        L16:
            r108 = false;
            goto L17
        L6:
            if (r110.readInt() == 0) goto L8;
            boolean r109 = true;
        L9:
            r101 = Boolean.valueOf(r109);
            goto L11
        L8:
            r109 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final BgImageStep[] newArray(int r100) {
            return new BgImageStep[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BgImageStep() {
        this(null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BgImageStep) == true) goto L8;
        return false;
    L8:
        BgImageStep r101 = (BgImageStep) r100;
        if (Intrinsics.areEqual(this.botGenAddImageSetting, r101.botGenAddImageSetting) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isAiImageWorkflow, r101.isAiImageWorkflow) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgImageOpenMode, r101.bgImageOpenMode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isImageGuide, r101.isImageGuide) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isStepGenByCharacterBot, r101.isStepGenByCharacterBot) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showBotType, r101.showBotType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isIndependentVoiceSetting, r101.isIndependentVoiceSetting) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.botGenAddImageSetting;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isAiImageWorkflow;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.bgImageOpenMode;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isImageGuide;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isStepGenByCharacterBot;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.showBotType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.isIndependentVoiceSetting;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "BgImageStep(botGenAddImageSetting=" + this.botGenAddImageSetting + ", isAiImageWorkflow=" + this.isAiImageWorkflow + ", bgImageOpenMode=" + this.bgImageOpenMode + ", isImageGuide=" + this.isImageGuide + ", isStepGenByCharacterBot=" + this.isStepGenByCharacterBot + ", showBotType=" + this.showBotType + ", isIndependentVoiceSetting=" + this.isIndependentVoiceSetting + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Boolean r102 = this.botGenAddImageSetting;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.isAiImageWorkflow;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Integer r104 = this.bgImageOpenMode;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Boolean r105 = this.isImageGuide;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        Boolean r106 = this.isStepGenByCharacterBot;
        if (r106 != null) goto L21;
        r100.writeInt(0);
    L22:
        r100.writeStringList(this.showBotType);
        Boolean r107 = this.isIndependentVoiceSetting;
        if (r107 != null) goto L25;
        r100.writeInt(0);
        return;
    L25:
        r100.writeInt(1);
        r100.writeInt(r107.booleanValue() ? 1 : 0);
        return;
    L21:
        r100.writeInt(1);
        r100.writeInt(r106.booleanValue() ? 1 : 0);
        goto L22
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.booleanValue() ? 1 : 0);
        goto L18
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public BgImageStep(Boolean r100, Boolean r101, Integer r102, Boolean r103, Boolean r104, List<String> r105, Boolean r106) {
        this.botGenAddImageSetting = r100;
        this.isAiImageWorkflow = r101;
        this.bgImageOpenMode = r102;
        this.isImageGuide = r103;
        this.isStepGenByCharacterBot = r104;
        this.showBotType = r105;
        this.isIndependentVoiceSetting = r106;
    }
}
