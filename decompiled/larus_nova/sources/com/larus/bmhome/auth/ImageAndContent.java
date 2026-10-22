package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006%"}, d2 = {"Lcom/larus/bmhome/auth/ImageAndContent;", "Landroid/os/Parcelable;", "name", "Lcom/larus/bmhome/auth/StarlingContent;", SocialConstants.PARAM_APP_DESC, "imgUri", "", "imgUrl", EventConstant.Key.RETAIN_PROMPT, "<init>", "(Lcom/larus/bmhome/auth/StarlingContent;Lcom/larus/bmhome/auth/StarlingContent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Lcom/larus/bmhome/auth/StarlingContent;", "getDesc", "getImgUri", "()Ljava/lang/String;", "getImgUrl", "getPrompt", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageAndContent implements Parcelable {
    public static final Parcelable.Creator<ImageAndContent> CREATOR = null;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final StarlingContent desc;

    @SerializedName(VideoThumbInfo.KEY_IMG_URI)
    private final String imgUri;

    @SerializedName(VideoThumbInfo.KEY_IMG_URL)
    private final String imgUrl;

    @SerializedName("name")
    private final StarlingContent name;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private final String prompt;

    public static final class a implements Parcelable.Creator<ImageAndContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImageAndContent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            StarlingContent r101 = null;
            if (r100.readInt() != 0) goto L5;
            StarlingContent r102 = null;
        L6:
            StarlingContent r103 = r102;
            if (r100.readInt() == 0) goto L11;
            r101 = StarlingContent.CREATOR.createFromParcel(r100);
        L11:
            return new ImageAndContent(r103, r101, r100.readString(), r100.readString(), r100.readString());
        L5:
            r102 = StarlingContent.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ImageAndContent[] newArray(int r100) {
            return new ImageAndContent[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ImageAndContent() {
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
        if ((r100 instanceof ImageAndContent) == true) goto L8;
        return false;
    L8:
        ImageAndContent r101 = (ImageAndContent) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imgUri, r101.imgUri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imgUrl, r101.imgUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.prompt, r101.prompt) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        StarlingContent r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        StarlingContent r104 = this.desc;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.imgUri;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.imgUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.prompt;
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
        return "ImageAndContent(name=" + this.name + ", desc=" + this.desc + ", imgUri=" + this.imgUri + ", imgUrl=" + this.imgUrl + ", prompt=" + this.prompt + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        StarlingContent r102 = this.name;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        StarlingContent r103 = this.desc;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.imgUri);
        r100.writeString(this.imgUrl);
        r100.writeString(this.prompt);
        return;
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final String a() {
        return this.imgUrl;
    }

    public final StarlingContent b() {
        return this.name;
    }

    public ImageAndContent(StarlingContent r100, StarlingContent r101, String r102, String r103, String r104) {
        this.name = r100;
        this.desc = r101;
        this.imgUri = r102;
        this.imgUrl = r103;
        this.prompt = r104;
    }
}
