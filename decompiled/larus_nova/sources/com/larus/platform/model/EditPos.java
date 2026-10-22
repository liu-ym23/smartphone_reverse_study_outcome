package com.larus.platform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"Jv\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0006\u00101\u001a\u000202J\u0013\u00103\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000202HÖ\u0001J\t\u00107\u001a\u000208HÖ\u0001J\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000202R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"¨\u0006?"}, d2 = {"Lcom/larus/platform/model/EditPos;", "Landroid/os/Parcelable;", "name", "", "modelDescription", "humanDescription", "iconUri", "modelType", "voiceType", "delete", "botLanguage", "firstMet", "bioEdit", "<init>", "(ZZZZZZZZLjava/lang/Boolean;Ljava/lang/Boolean;)V", "getName", "()Z", "setName", "(Z)V", "getModelDescription", "setModelDescription", "getHumanDescription", "setHumanDescription", "getIconUri", "setIconUri", "getModelType", "setModelType", "getVoiceType", "setVoiceType", "getDelete", "setDelete", "getBotLanguage", "setBotLanguage", "getFirstMet", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBioEdit", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ZZZZZZZZLjava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/platform/model/EditPos;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditPos implements Parcelable {
    public static final Parcelable.Creator<EditPos> CREATOR = null;

    @SerializedName("user_edit_bio")
    private final Boolean bioEdit;

    @SerializedName("bot_language")
    private boolean botLanguage;

    @SerializedName("delete")
    private boolean delete;

    @SerializedName("first_met")
    private final Boolean firstMet;

    @SerializedName("description_for_human")
    private boolean humanDescription;

    @SerializedName("icon_uri")
    private boolean iconUri;

    @SerializedName("description_for_model")
    private boolean modelDescription;

    @SerializedName(AdDownloadModel.JsonKey.MODEL_TYPE)
    private boolean modelType;

    @SerializedName("name")
    private boolean name;

    @SerializedName("voice_type")
    private boolean voiceType;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<EditPos> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final EditPos createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            boolean r100 = false;
            if (r110.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r102 = true;
        L11:
            if (r110.readInt() == 0) goto L13;
            boolean r103 = true;
        L15:
            if (r110.readInt() == 0) goto L17;
            boolean r104 = true;
        L19:
            if (r110.readInt() == 0) goto L21;
            boolean r105 = true;
        L23:
            if (r110.readInt() == 0) goto L25;
            boolean r106 = true;
        L27:
            if (r110.readInt() == 0) goto L29;
            boolean r111 = true;
        L31:
            if (r110.readInt() == 0) goto L33;
            boolean r112 = true;
        L35:
            if (r110.readInt() != 0) goto L38;
            Boolean r113 = null;
        L43:
            if (r110.readInt() != 0) goto L46;
            Boolean r114 = null;
        L50:
            return new EditPos(r101, r102, r103, r104, r105, r106, r111, r112, r113, r114);
        L46:
            if (r110.readInt() == 0) goto L48;
            r100 = true;
        L48:
            r114 = Boolean.valueOf(r100);
            goto L50
        L38:
            if (r110.readInt() == 0) goto L40;
            boolean r107 = true;
        L41:
            r113 = Boolean.valueOf(r107);
            goto L43
        L40:
            r107 = false;
            goto L41
        L33:
            r112 = false;
            goto L35
        L29:
            r111 = false;
            goto L31
        L25:
            r106 = false;
            goto L27
        L21:
            r105 = false;
            goto L23
        L17:
            r104 = false;
            goto L19
        L13:
            r103 = false;
            goto L15
        L9:
            r102 = false;
            goto L11
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final EditPos[] newArray(int r100) {
            return new EditPos[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    public EditPos() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EditPos) == true) goto L8;
        return false;
    L8:
        EditPos r101 = (EditPos) r100;
        if (this.name == r101.name) goto L12;
        return false;
    L12:
        if (this.modelDescription == r101.modelDescription) goto L15;
        return false;
    L15:
        if (this.humanDescription == r101.humanDescription) goto L18;
        return false;
    L18:
        if (this.iconUri == r101.iconUri) goto L21;
        return false;
    L21:
        if (this.modelType == r101.modelType) goto L24;
        return false;
    L24:
        if (this.voiceType == r101.voiceType) goto L27;
        return false;
    L27:
        if (this.delete == r101.delete) goto L30;
        return false;
    L30:
        if (this.botLanguage == r101.botLanguage) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.firstMet, r101.firstMet) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bioEdit, r101.bioEdit) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.name == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.modelDescription == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.humanDescription == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.iconUri == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.modelType == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.voiceType == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.delete == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.botLanguage == true) goto L34;
        r100 = 1237;
    L34:
        int r115 = (r114 + r100) * 31;
        Boolean r116 = this.firstMet;
        int r117 = 0;
        if (r116 != null) goto L37;
        int r118 = 0;
    L38:
        int r119 = (r115 + r118) * 31;
        Boolean r120 = this.bioEdit;
        if (r120 == null) goto L43;
        r117 = r120.hashCode();
    L43:
        return r119 + r117;
    L37:
        r118 = r116.hashCode();
        goto L38
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "EditPos(name=" + this.name + ", modelDescription=" + this.modelDescription + ", humanDescription=" + this.humanDescription + ", iconUri=" + this.iconUri + ", modelType=" + this.modelType + ", voiceType=" + this.voiceType + ", delete=" + this.delete + ", botLanguage=" + this.botLanguage + ", firstMet=" + this.firstMet + ", bioEdit=" + this.bioEdit + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.name ? 1 : 0);
        r100.writeInt(this.modelDescription ? 1 : 0);
        r100.writeInt(this.humanDescription ? 1 : 0);
        r100.writeInt(this.iconUri ? 1 : 0);
        r100.writeInt(this.modelType ? 1 : 0);
        r100.writeInt(this.voiceType ? 1 : 0);
        r100.writeInt(this.delete ? 1 : 0);
        r100.writeInt(this.botLanguage ? 1 : 0);
        Boolean r102 = this.firstMet;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.bioEdit;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public final Boolean a() {
        return this.bioEdit;
    }

    public final boolean b() {
        return this.botLanguage;
    }

    public final boolean c() {
        return this.delete;
    }

    public final Boolean d() {
        return this.firstMet;
    }

    public final boolean e() {
        return this.humanDescription;
    }

    public final boolean g() {
        return this.iconUri;
    }

    public final boolean h() {
        return this.modelDescription;
    }

    public final boolean i() {
        return this.name;
    }

    public final boolean j() {
        return this.voiceType;
    }

    public /* synthetic */ EditPos(int r110) {
        this(false, false, false, false, false, false, false, false, null, null);
    }

    public EditPos(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, Boolean r108, Boolean r110) {
        this.name = r100;
        this.modelDescription = r101;
        this.humanDescription = r102;
        this.iconUri = r103;
        this.modelType = r104;
        this.voiceType = r105;
        this.delete = r106;
        this.botLanguage = r107;
        this.firstMet = r108;
        this.bioEdit = r110;
    }
}
