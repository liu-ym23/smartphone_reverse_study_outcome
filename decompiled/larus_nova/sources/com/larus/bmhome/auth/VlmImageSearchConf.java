package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001fHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006+"}, d2 = {"Lcom/larus/bmhome/auth/VlmImageSearchConf;", "Landroid/os/Parcelable;", "showSearchReference", "", "showImageAndVideo", "imageBeforeVideo", "videoBeforeImage", "showAnimation", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getShowSearchReference", "()Ljava/lang/Boolean;", "setShowSearchReference", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getShowImageAndVideo", "setShowImageAndVideo", "getImageBeforeVideo", "setImageBeforeVideo", "getVideoBeforeImage", "setVideoBeforeImage", "getShowAnimation", "setShowAnimation", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/bmhome/auth/VlmImageSearchConf;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VlmImageSearchConf implements Parcelable {
    public static final Parcelable.Creator<VlmImageSearchConf> CREATOR = null;

    @SerializedName("image_before_video")
    private Boolean imageBeforeVideo;

    @SerializedName("show_animation")
    private Boolean showAnimation;

    @SerializedName("show_image_and_video")
    private Boolean showImageAndVideo;

    @SerializedName("show_search_reference")
    private Boolean showSearchReference;

    @SerializedName("video_before_image")
    private Boolean videoBeforeImage;

    public static final class a implements Parcelable.Creator<VlmImageSearchConf> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VlmImageSearchConf createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            boolean r100 = false;
            if (r110.readInt() != 0) goto L6;
            Boolean r101 = null;
        L11:
            if (r110.readInt() != 0) goto L14;
            Boolean r102 = null;
        L19:
            if (r110.readInt() != 0) goto L22;
            Boolean r103 = null;
        L27:
            if (r110.readInt() != 0) goto L30;
            Boolean r104 = null;
        L35:
            if (r110.readInt() != 0) goto L38;
            Boolean r111 = null;
        L42:
            return new VlmImageSearchConf(r101, r102, r103, r104, r111);
        L38:
            if (r110.readInt() == 0) goto L40;
            r100 = true;
        L40:
            r111 = Boolean.valueOf(r100);
            goto L42
        L30:
            if (r110.readInt() == 0) goto L32;
            boolean r105 = true;
        L33:
            r104 = Boolean.valueOf(r105);
            goto L35
        L32:
            r105 = false;
            goto L33
        L22:
            if (r110.readInt() == 0) goto L24;
            boolean r106 = true;
        L25:
            r103 = Boolean.valueOf(r106);
            goto L27
        L24:
            r106 = false;
            goto L25
        L14:
            if (r110.readInt() == 0) goto L16;
            boolean r107 = true;
        L17:
            r102 = Boolean.valueOf(r107);
            goto L19
        L16:
            r107 = false;
            goto L17
        L6:
            if (r110.readInt() == 0) goto L8;
            boolean r108 = true;
        L9:
            r101 = Boolean.valueOf(r108);
            goto L11
        L8:
            r108 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final VlmImageSearchConf[] newArray(int r100) {
            return new VlmImageSearchConf[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public VlmImageSearchConf() {
        this(null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VlmImageSearchConf) == true) goto L8;
        return false;
    L8:
        VlmImageSearchConf r101 = (VlmImageSearchConf) r100;
        if (Intrinsics.areEqual(this.showSearchReference, r101.showSearchReference) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showImageAndVideo, r101.showImageAndVideo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageBeforeVideo, r101.imageBeforeVideo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoBeforeImage, r101.videoBeforeImage) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showAnimation, r101.showAnimation) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.showSearchReference;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.showImageAndVideo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.imageBeforeVideo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.videoBeforeImage;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.showAnimation;
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

    public final String toString() {
        return "VlmImageSearchConf(showSearchReference=" + this.showSearchReference + ", showImageAndVideo=" + this.showImageAndVideo + ", imageBeforeVideo=" + this.imageBeforeVideo + ", videoBeforeImage=" + this.videoBeforeImage + ", showAnimation=" + this.showAnimation + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Boolean r102 = this.showSearchReference;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.showImageAndVideo;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Boolean r104 = this.imageBeforeVideo;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Boolean r105 = this.videoBeforeImage;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        Boolean r106 = this.showAnimation;
        if (r106 != null) goto L21;
        r100.writeInt(0);
        return;
    L21:
        r100.writeInt(1);
        r100.writeInt(r106.booleanValue() ? 1 : 0);
        return;
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.booleanValue() ? 1 : 0);
        goto L18
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.booleanValue() ? 1 : 0);
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

    public final Boolean a() {
        return this.imageBeforeVideo;
    }

    public final Boolean b() {
        return this.showAnimation;
    }

    public final Boolean c() {
        return this.videoBeforeImage;
    }

    public VlmImageSearchConf(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104) {
        this.showSearchReference = r100;
        this.showImageAndVideo = r101;
        this.imageBeforeVideo = r102;
        this.videoBeforeImage = r103;
        this.showAnimation = r104;
    }
}
