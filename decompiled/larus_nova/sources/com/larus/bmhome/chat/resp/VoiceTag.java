package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/resp/VoiceTag;", "Landroid/os/Parcelable;", "tagId", "", "tagType", "tagValue", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getTagId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTagType", "getTagValue", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/bmhome/chat/resp/VoiceTag;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceTag implements Parcelable {
    public static final Parcelable.Creator<VoiceTag> CREATOR = null;

    @SerializedName("tag_id")
    private final Integer tagId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    private final Integer tagType;

    @SerializedName("tag_value")
    private final String tagValue;

    public static final class a implements Parcelable.Creator<VoiceTag> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VoiceTag createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Integer r101 = null;
            if (r100.readInt() != 0) goto L5;
            Integer r102 = null;
        L7:
            if (r100.readInt() == 0) goto L11;
            r101 = Integer.valueOf(r100.readInt());
        L11:
            return new VoiceTag(r102, r101, r100.readString());
        L5:
            r102 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final VoiceTag[] newArray(int r100) {
            return new VoiceTag[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public VoiceTag() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoiceTag) == true) goto L8;
        return false;
    L8:
        VoiceTag r101 = (VoiceTag) r100;
        if (Intrinsics.areEqual(this.tagId, r101.tagId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tagType, r101.tagType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tagValue, r101.tagValue) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.tagId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.tagType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tagValue;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceTag(tagId=" + this.tagId + ", tagType=" + this.tagType + ", tagValue=" + this.tagValue + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this.tagId;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.tagType;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.tagValue);
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

    public VoiceTag(Integer r100, Integer r101, String r102) {
        this.tagId = r100;
        this.tagType = r101;
        this.tagValue = r102;
    }
}
