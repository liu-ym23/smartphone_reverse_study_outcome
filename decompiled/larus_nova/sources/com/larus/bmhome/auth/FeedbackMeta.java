package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0003J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/auth/FeedbackMeta;", "Landroid/os/Parcelable;", "feedbackType", "", "feedbackDetailType", "feedbackDisplay", "", "<init>", "(IILjava/lang/String;)V", "getFeedbackType", "()I", "getFeedbackDetailType", "getFeedbackDisplay", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackMeta implements Parcelable {
    public static final Parcelable.Creator<FeedbackMeta> CREATOR = null;

    @SerializedName("feedback_detail_type")
    private final int feedbackDetailType;

    @SerializedName("feedback_display")
    private final String feedbackDisplay;

    @SerializedName("feedback_type")
    private final int feedbackType;

    public static final class a implements Parcelable.Creator<FeedbackMeta> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeedbackMeta createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new FeedbackMeta(r100.readInt(), r100.readInt(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final FeedbackMeta[] newArray(int r100) {
            return new FeedbackMeta[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FeedbackMeta() {
        this(0, 0, "");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedbackMeta) == true) goto L8;
        return false;
    L8:
        FeedbackMeta r101 = (FeedbackMeta) r100;
        if (this.feedbackType == r101.feedbackType) goto L12;
        return false;
    L12:
        if (this.feedbackDetailType == r101.feedbackDetailType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.feedbackDisplay, r101.feedbackDisplay) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.feedbackType * 31) + this.feedbackDetailType) * 31;
        String r101 = this.feedbackDisplay;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FeedbackMeta(feedbackType=" + this.feedbackType + ", feedbackDetailType=" + this.feedbackDetailType + ", feedbackDisplay=" + this.feedbackDisplay + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.feedbackType);
        r100.writeInt(this.feedbackDetailType);
        r100.writeString(this.feedbackDisplay);
    }

    public final int a() {
        return this.feedbackDetailType;
    }

    public final String b() {
        return this.feedbackDisplay;
    }

    public final int c() {
        return this.feedbackType;
    }

    public FeedbackMeta(int r100, int r101, String r102) {
        this.feedbackType = r100;
        this.feedbackDetailType = r101;
        this.feedbackDisplay = r102;
    }
}
