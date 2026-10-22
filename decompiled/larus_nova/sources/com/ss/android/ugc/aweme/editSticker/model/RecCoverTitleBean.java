package com.ss.android.ugc.aweme.editSticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/editSticker/model/RecCoverTitleBean;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "id", "", "content", "", "(JLjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class RecCoverTitleBean implements Parcelable, Serializable {
    public static final Parcelable.Creator<RecCoverTitleBean> CREATOR = null;

    @SerializedName("content")
    private String content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f450800id;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<RecCoverTitleBean> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final RecCoverTitleBean createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new RecCoverTitleBean(r100.readLong(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final RecCoverTitleBean[] newArray(int r100) {
            return new RecCoverTitleBean[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public RecCoverTitleBean() {
        this(0, null, 3, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeLong(this.f450800id);
        r100.writeString(this.content);
    }

    public final String getContent() {
        return this.content;
    }

    public final long getId() {
        return this.f450800id;
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setId(long r100) {
        this.f450800id = r100;
    }

    public RecCoverTitleBean(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f450800id = r100;
        this.content = r101;
    }

    public /* synthetic */ RecCoverTitleBean(long r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
