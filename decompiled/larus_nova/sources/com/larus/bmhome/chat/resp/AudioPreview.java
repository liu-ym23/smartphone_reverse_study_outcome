package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006%"}, d2 = {"Lcom/larus/bmhome/chat/resp/AudioPreview;", "Landroid/os/Parcelable;", "version", "", "previewText", "previewAudio", "md5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getPreviewText", "setPreviewText", "getPreviewAudio", "setPreviewAudio", "getMd5", "setMd5", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioPreview implements Parcelable {
    public static final Parcelable.Creator<AudioPreview> CREATOR = null;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @SerializedName("md5")
    private String f308546md5;

    @SerializedName("preview_audio")
    private String previewAudio;

    @SerializedName("preview_text")
    private String previewText;

    @SerializedName("version")
    private String version;

    public static final class a implements Parcelable.Creator<AudioPreview> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AudioPreview createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new AudioPreview(r100.readString(), r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final AudioPreview[] newArray(int r100) {
            return new AudioPreview[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioPreview) == true) goto L8;
        return false;
    L8:
        AudioPreview r101 = (AudioPreview) r100;
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previewText, r101.previewText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewAudio, r101.previewAudio) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f308546md5, r101.f308546md5) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.version;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.previewText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.previewAudio;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f308546md5;
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

    public final String toString() {
        return "AudioPreview(version=" + this.version + ", previewText=" + this.previewText + ", previewAudio=" + this.previewAudio + ", md5=" + this.f308546md5 + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.version);
        r100.writeString(this.previewText);
        r100.writeString(this.previewAudio);
        r100.writeString(this.f308546md5);
    }

    public AudioPreview() {
        this("", "", "", "");
    }

    public AudioPreview(String r100, String r101, String r102, String r103) {
        this.version = r100;
        this.previewText = r101;
        this.previewAudio = r102;
        this.f308546md5 = r103;
    }
}
