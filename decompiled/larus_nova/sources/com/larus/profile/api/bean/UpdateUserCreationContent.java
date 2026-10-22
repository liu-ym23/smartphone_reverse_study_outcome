package com.larus.profile.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.api.creation.UpdateUserCreationMusic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/larus/profile/api/bean/UpdateUserCreationContent;", "Landroid/os/Parcelable;", "musicContent", "Lcom/larus/platform/api/creation/UpdateUserCreationMusic;", "<init>", "(Lcom/larus/platform/api/creation/UpdateUserCreationMusic;)V", "getMusicContent", "()Lcom/larus/platform/api/creation/UpdateUserCreationMusic;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateUserCreationContent implements Parcelable {
    public static final Parcelable.Creator<UpdateUserCreationContent> CREATOR = null;

    @SerializedName(MusicAppletPage.KEY_MUSIC_CONTENT)
    private final UpdateUserCreationMusic musicContent;

    public static final class a implements Parcelable.Creator<UpdateUserCreationContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UpdateUserCreationContent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new UpdateUserCreationContent((UpdateUserCreationMusic) r100.readParcelable(UpdateUserCreationContent.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final UpdateUserCreationContent[] newArray(int r100) {
            return new UpdateUserCreationContent[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public UpdateUserCreationContent() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateUserCreationContent) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.musicContent, ((UpdateUserCreationContent) r100).musicContent) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        UpdateUserCreationMusic r100 = this.musicContent;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "UpdateUserCreationContent(musicContent=" + this.musicContent + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeParcelable(this.musicContent, r101);
    }

    public UpdateUserCreationContent(UpdateUserCreationMusic r100) {
        this.musicContent = r100;
    }
}
