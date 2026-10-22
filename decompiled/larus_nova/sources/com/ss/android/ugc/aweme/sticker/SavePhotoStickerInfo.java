package com.ss.android.ugc.aweme.sticker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.creative.CreativePath;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014JD\u0010\u001d\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020 HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\f¨\u0006+"}, d2 = {"Lcom/ss/android/ugc/aweme/sticker/SavePhotoStickerInfo;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "capturedPhotoPaths", "", "", "stickerToast", "capturedPhotoDir", "shouldRemoveLabel", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getCapturedPhotoDir", "()Ljava/lang/String;", "setCapturedPhotoDir", "(Ljava/lang/String;)V", "getCapturedPhotoPaths", "()Ljava/util/List;", "setCapturedPhotoPaths", "(Ljava/util/List;)V", "getShouldRemoveLabel", "()Ljava/lang/Boolean;", "setShouldRemoveLabel", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getStickerToast", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/ss/android/ugc/aweme/sticker/SavePhotoStickerInfo;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class SavePhotoStickerInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<SavePhotoStickerInfo> CREATOR = null;

    @SerializedName(alternate = {"c"}, value = "capturedPhotoDir")
    private String capturedPhotoDir;

    @SerializedName(alternate = {BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY}, value = "capturedPhotoPaths")
    @CreativePath
    private List<String> capturedPhotoPaths;

    @SerializedName(alternate = {"d"}, value = "shouldRemoveLabel")
    private Boolean shouldRemoveLabel;

    @SerializedName(alternate = {"b"}, value = "stickerToast")
    private final String stickerToast;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<SavePhotoStickerInfo> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final SavePhotoStickerInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            ArrayList<String> r101 = r100.createStringArrayList();
            String r102 = r100.readString();
            String r103 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Boolean r104 = null;
        L11:
            return new SavePhotoStickerInfo(r101, r102, r103, r104);
        L5:
            if (r100.readInt() == 0) goto L7;
            boolean r105 = true;
        L8:
            r104 = Boolean.valueOf(r105);
            goto L11
        L7:
            r105 = false;
            goto L8
        }

        @Override // android.os.Parcelable.Creator
        public final SavePhotoStickerInfo[] newArray(int r100) {
            return new SavePhotoStickerInfo[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SavePhotoStickerInfo copy$default(SavePhotoStickerInfo r100, List r101, String r102, String r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.capturedPhotoPaths;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.stickerToast;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.capturedPhotoDir;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.shouldRemoveLabel;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<String> component1() {
        return this.capturedPhotoPaths;
    }

    public final String component2() {
        return this.stickerToast;
    }

    public final String component3() {
        return this.capturedPhotoDir;
    }

    public final Boolean component4() {
        return this.shouldRemoveLabel;
    }

    public final SavePhotoStickerInfo copy(List<String> r100, String r101, String r102, Boolean r103) {
        return new SavePhotoStickerInfo(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SavePhotoStickerInfo) == false) goto L14;
        SavePhotoStickerInfo r101 = (SavePhotoStickerInfo) r100;
        if (Intrinsics.areEqual(this.capturedPhotoPaths, r101.capturedPhotoPaths) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.stickerToast, r101.stickerToast) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.capturedPhotoDir, r101.capturedPhotoDir) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shouldRemoveLabel, r101.shouldRemoveLabel) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.capturedPhotoPaths;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.stickerToast;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.capturedPhotoDir;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.shouldRemoveLabel;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SavePhotoStickerInfo(capturedPhotoPaths=" + this.capturedPhotoPaths + ", stickerToast=" + this.stickerToast + ", capturedPhotoDir=" + this.capturedPhotoDir + ", shouldRemoveLabel=" + this.shouldRemoveLabel + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeStringList(this.capturedPhotoPaths);
        r100.writeString(this.stickerToast);
        r100.writeString(this.capturedPhotoDir);
        Boolean r102 = this.shouldRemoveLabel;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        ?? r103 = r102.booleanValue();
    L6:
        r100.writeInt(r103);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final String getCapturedPhotoDir() {
        return this.capturedPhotoDir;
    }

    public final List<String> getCapturedPhotoPaths() {
        return this.capturedPhotoPaths;
    }

    public final Boolean getShouldRemoveLabel() {
        return this.shouldRemoveLabel;
    }

    public final String getStickerToast() {
        return this.stickerToast;
    }

    public final void setCapturedPhotoDir(String r100) {
        this.capturedPhotoDir = r100;
    }

    public final void setCapturedPhotoPaths(List<String> r100) {
        this.capturedPhotoPaths = r100;
    }

    public final void setShouldRemoveLabel(Boolean r100) {
        this.shouldRemoveLabel = r100;
    }

    public SavePhotoStickerInfo(List<String> r100, String r101, String r102, Boolean r103) {
        this.capturedPhotoPaths = r100;
        this.stickerToast = r101;
        this.capturedPhotoDir = r102;
        this.shouldRemoveLabel = r103;
    }
}
