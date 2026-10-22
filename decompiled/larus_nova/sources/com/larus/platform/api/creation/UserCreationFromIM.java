package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jb\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0006J\u0013\u0010%\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006/"}, d2 = {"Lcom/larus/platform/api/creation/UserCreationFromIM;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "creationId", "", "creationType", "", "privateStatus", EventConstant.Key.RETAIN_PROMPT, "refContent", "awemeAnchor", "materialId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreationId", "()Ljava/lang/String;", "getCreationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrivateStatus", "getPrompt", "getRefContent", "getAwemeAnchor", "getMaterialId", "isValid", "", "isVideo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/api/creation/UserCreationFromIM;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserCreationFromIM implements Parcelable, Serializable {
    public static final Parcelable.Creator<UserCreationFromIM> CREATOR = null;

    @SerializedName("aweme_anchor")
    private final String awemeAnchor;

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("creation_type")
    private final Integer creationType;

    @SerializedName("material_id")
    private final String materialId;

    @SerializedName("private_status")
    private final Integer privateStatus;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private final String prompt;

    @SerializedName("ref_content")
    private final String refContent;

    public static final class a implements Parcelable.Creator<UserCreationFromIM> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationFromIM createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Integer r101 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Integer r102 = null;
        L11:
            return new UserCreationFromIM(r100, r101, r102, r110.readString(), r110.readString(), r110.readString(), r110.readString());
        L9:
            r102 = Integer.valueOf(r110.readInt());
            goto L11
        L5:
            r101 = Integer.valueOf(r110.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationFromIM[] newArray(int r100) {
            return new UserCreationFromIM[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public UserCreationFromIM() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ UserCreationFromIM copy$default(UserCreationFromIM r100, String r101, Integer r102, Integer r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.creationId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.creationType;
    L8:
        Integer r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.privateStatus;
    L11:
        Integer r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.prompt;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.refContent;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.awemeAnchor;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.materialId;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.creationId;
    }

    public final Integer component2() {
        return this.creationType;
    }

    public final Integer component3() {
        return this.privateStatus;
    }

    public final String component4() {
        return this.prompt;
    }

    public final String component5() {
        return this.refContent;
    }

    public final String component6() {
        return this.awemeAnchor;
    }

    public final String component7() {
        return this.materialId;
    }

    public final UserCreationFromIM copy(String r110, @UserCreationType Integer r111, Integer r112, String r113, String r114, String r115, String r116) {
        return new UserCreationFromIM(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserCreationFromIM) == true) goto L8;
        return false;
    L8:
        UserCreationFromIM r101 = (UserCreationFromIM) r100;
        if (Intrinsics.areEqual(this.creationId, r101.creationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationType, r101.creationType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.privateStatus, r101.privateStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prompt, r101.prompt) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refContent, r101.refContent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.awemeAnchor, r101.awemeAnchor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.materialId, r101.materialId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.creationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.creationType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.privateStatus;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.prompt;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.refContent;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.awemeAnchor;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.materialId;
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

    public final boolean isValid() {
        return true;
    }

    public String toString() {
        return "UserCreationFromIM(creationId=" + this.creationId + ", creationType=" + this.creationType + ", privateStatus=" + this.privateStatus + ", prompt=" + this.prompt + ", refContent=" + this.refContent + ", awemeAnchor=" + this.awemeAnchor + ", materialId=" + this.materialId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.creationId);
        Integer r102 = this.creationType;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.privateStatus;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.prompt);
        r100.writeString(this.refContent);
        r100.writeString(this.awemeAnchor);
        r100.writeString(this.materialId);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final boolean isVideo() {
        Integer r100 = this.creationType;
        if (r100 != null) goto L6;
    L7:
        Integer r101 = this.creationType;
        if (r101 != null) goto L11;
    L12:
        Integer r102 = this.creationType;
        if (r102 != null) goto L16;
    L17:
        Integer r103 = this.creationType;
        if (r103 != null) goto L21;
    L22:
        Integer r104 = this.creationType;
        if (r104 != null) goto L26;
    L28:
        return false;
    L26:
        if (r104.intValue() != 12) goto L28;
    L29:
        return true;
    L21:
        if (r103.intValue() == 10) goto L29;
    L16:
        if (r102.intValue() == 11) goto L29;
    L11:
        if (r101.intValue() == 6) goto L29;
    L6:
        if (r100.intValue() == 7) goto L29;
        goto L7
    }

    public final String getAwemeAnchor() {
        return this.awemeAnchor;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final Integer getCreationType() {
        return this.creationType;
    }

    public final String getMaterialId() {
        return this.materialId;
    }

    public final Integer getPrivateStatus() {
        return this.privateStatus;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getRefContent() {
        return this.refContent;
    }

    public UserCreationFromIM(String r100, @UserCreationType Integer r101, Integer r102, String r103, String r104, String r105, String r106) {
        this.creationId = r100;
        this.creationType = r101;
        this.privateStatus = r102;
        this.prompt = r103;
        this.refContent = r104;
        this.awemeAnchor = r105;
        this.materialId = r106;
    }

    public /* synthetic */ UserCreationFromIM(String r100, Integer r101, Integer r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Integer r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Integer r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
