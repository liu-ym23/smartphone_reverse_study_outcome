package com.ss.android.ugc.aweme.shortvideo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0002\u0010\u000fJ\t\u0010'\u001a\u00020\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J[\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001J\t\u00100\u001a\u00020\nHÖ\u0001J\u0013\u00101\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\nHÖ\u0001J\t\u00105\u001a\u00020\bHÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\nHÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001a¨\u0006<"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/model/LivePhotoModel;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "isOpen", "", "effect", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, "", "videoWidth", "", "videoHeight", "photoPath", "photoWidth", "photoHeight", "(ZLcom/ss/android/ugc/effectmanager/effect/model/Effect;Ljava/lang/String;IILjava/lang/String;II)V", "getEffect", "()Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "setEffect", "(Lcom/ss/android/ugc/effectmanager/effect/model/Effect;)V", "()Z", "setOpen", "(Z)V", "getPhotoHeight", "()I", "setPhotoHeight", "(I)V", "getPhotoPath", "()Ljava/lang/String;", "setPhotoPath", "(Ljava/lang/String;)V", "getPhotoWidth", "setPhotoWidth", "getVideoHeight", "setVideoHeight", "getVideoPath", "setVideoPath", "getVideoWidth", "setVideoWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class LivePhotoModel implements Parcelable, Serializable {
    public static final Parcelable.Creator<LivePhotoModel> CREATOR = null;
    public static final Companion Companion = null;
    public static final long serialVersionUID = 1;
    private Effect effect;
    private boolean isOpen;
    private int photoHeight;
    private String photoPath;
    private int photoWidth;
    private int videoHeight;
    private String videoPath;
    private int videoWidth;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/model/LivePhotoModel$Companion;", "", "()V", "serialVersionUID", "", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<LivePhotoModel> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final LivePhotoModel createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            if (r110.readInt() == 0) goto L5;
            boolean r100 = true;
        L7:
            return new LivePhotoModel(r100, (Effect) r110.readParcelable(LivePhotoModel.class.getClassLoader()), r110.readString(), r110.readInt(), r110.readInt(), r110.readString(), r110.readInt(), r110.readInt());
        L5:
            r100 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final LivePhotoModel[] newArray(int r100) {
            return new LivePhotoModel[r100];
        }
    }

    static {
        Companion = new Companion(0);
        CREATOR = new Creator();
    }

    public LivePhotoModel() {
        this(false, null, null, 0, 0, null, 0, 0, 255, null);
    }

    public static /* synthetic */ LivePhotoModel copy$default(LivePhotoModel r100, boolean r110, Effect r111, String r112, int r113, int r114, String r115, int r116, int r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = r100.isOpen;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Effect r102 = r100.effect;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.videoPath;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.videoWidth;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.videoHeight;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.photoPath;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = r100.photoWidth;
    L31:
        if ((r118 & 128) == 0) goto L33;
        int r108 = r100.photoHeight;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final boolean component1() {
        return this.isOpen;
    }

    public final Effect component2() {
        return this.effect;
    }

    public final String component3() {
        return this.videoPath;
    }

    public final int component4() {
        return this.videoWidth;
    }

    public final int component5() {
        return this.videoHeight;
    }

    public final String component6() {
        return this.photoPath;
    }

    public final int component7() {
        return this.photoWidth;
    }

    public final int component8() {
        return this.photoHeight;
    }

    public final LivePhotoModel copy(boolean r110, Effect r111, String r112, int r113, int r114, String r115, int r116, int r117) {
        Intrinsics.checkNotNullParameter(r112, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        Intrinsics.checkNotNullParameter(r115, "photoPath");
        return new LivePhotoModel(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LivePhotoModel) == false) goto L22;
        LivePhotoModel r101 = (LivePhotoModel) r100;
        if (this.isOpen == r101.isOpen) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.effect, r101.effect) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.videoPath, r101.videoPath) == true) goto L12;
        return false;
    L12:
        if (this.videoWidth == r101.videoWidth) goto L14;
        return false;
    L14:
        if (this.videoHeight == r101.videoHeight) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.photoPath, r101.photoPath) == true) goto L18;
        return false;
    L18:
        if (this.photoWidth == r101.photoWidth) goto L20;
        return false;
    L20:
        if (this.photoHeight == r101.photoHeight) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        boolean r100 = this.isOpen;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Effect r103 = this.effect;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.videoPath;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (((((r106 + r108) * 31) + this.videoWidth) * 31) + this.videoHeight) * 31;
        String r110 = this.photoPath;
        if (r110 == null) goto L17;
        r104 = r110.hashCode();
    L17:
        return ((((r109 + r104) * 31) + this.photoWidth) * 31) + this.photoHeight;
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "LivePhotoModel(isOpen=" + this.isOpen + ", effect=" + this.effect + ", videoPath=" + this.videoPath + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", photoPath=" + this.photoPath + ", photoWidth=" + this.photoWidth + ", photoHeight=" + this.photoHeight + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.isOpen ? 1 : 0);
        r100.writeParcelable(this.effect, r101);
        r100.writeString(this.videoPath);
        r100.writeInt(this.videoWidth);
        r100.writeInt(this.videoHeight);
        r100.writeString(this.photoPath);
        r100.writeInt(this.photoWidth);
        r100.writeInt(this.photoHeight);
    }

    public final Effect getEffect() {
        return this.effect;
    }

    public final int getPhotoHeight() {
        return this.photoHeight;
    }

    public final String getPhotoPath() {
        return this.photoPath;
    }

    public final int getPhotoWidth() {
        return this.photoWidth;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final String getVideoPath() {
        return this.videoPath;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final void setEffect(Effect r100) {
        this.effect = r100;
    }

    public final void setOpen(boolean r100) {
        this.isOpen = r100;
    }

    public final void setPhotoHeight(int r100) {
        this.photoHeight = r100;
    }

    public final void setPhotoPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.photoPath = r100;
    }

    public final void setPhotoWidth(int r100) {
        this.photoWidth = r100;
    }

    public final void setVideoHeight(int r100) {
        this.videoHeight = r100;
    }

    public final void setVideoPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoPath = r100;
    }

    public final void setVideoWidth(int r100) {
        this.videoWidth = r100;
    }

    public LivePhotoModel(boolean r100, Effect r101, String r102, int r103, int r104, String r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r102, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        Intrinsics.checkNotNullParameter(r105, "photoPath");
        this.isOpen = r100;
        this.effect = r101;
        this.videoPath = r102;
        this.videoWidth = r103;
        this.videoHeight = r104;
        this.photoPath = r105;
        this.photoWidth = r106;
        this.photoHeight = r107;
    }

    public /* synthetic */ LivePhotoModel(boolean r110, Effect r111, String r112, int r113, int r114, String r115, int r116, int r117, int r118, DefaultConstructorMarker r119) {
        int r100 = 0;
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Effect r102 = null;
    L10:
        String r103 = "";
        if ((r118 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r106 = 0;
    L23:
        if ((r118 & 32) != 0) goto L27;
        r103 = r115;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r104, r105, r106, r103, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
