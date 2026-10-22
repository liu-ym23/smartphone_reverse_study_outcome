package com.ss.android.ugc.aweme.shortvideo.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/ui/EmbaddedWindowInfo;", "Landroid/os/Parcelable;", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "x", "getX", "setX", "y", "getY", "setY", "start", "getStart", "setStart", "end", "getEnd", "setEnd", "<init>", "()V", "CREATOR", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class EmbaddedWindowInfo implements Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName("e")
    private int end;

    @SerializedName("h")
    private int height;

    @SerializedName("s")
    private int start;

    @SerializedName("w")
    private int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private int f454269x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private int f454270y;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/ui/EmbaddedWindowInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/shortvideo/ui/EmbaddedWindowInfo;", "", "DUET_END_TIME", "I", "DUET_START_POSITION_X", "DUET_START_POSITION_Y", "DUET_START_TIME", "<init>", "()V", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class CREATOR implements Parcelable.Creator<EmbaddedWindowInfo> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(int r100) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final EmbaddedWindowInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new EmbaddedWindowInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final EmbaddedWindowInfo[] newArray(int r100) {
            return new EmbaddedWindowInfo[r100];
        }
    }

    static {
        CREATOR = new CREATOR(0);
    }

    public EmbaddedWindowInfo() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public EmbaddedWindowInfo(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.width = r100.readInt();
        this.height = r100.readInt();
        this.f454269x = r100.readInt();
        this.f454270y = r100.readInt();
        this.start = r100.readInt();
        this.end = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeInt(this.f454269x);
        r100.writeInt(this.f454270y);
        r100.writeInt(this.start);
        r100.writeInt(this.end);
    }
}
