package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0003J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/larus/bmhome/auth/DouyinFeedEntrance;", "Landroid/os/Parcelable;", "entranceType", "", "sceneId", "", "quotaConfig", "Lcom/larus/bmhome/auth/QuotaConfig;", "<init>", "(ILjava/lang/String;Lcom/larus/bmhome/auth/QuotaConfig;)V", "getEntranceType", "()I", "setEntranceType", "(I)V", "getSceneId", "()Ljava/lang/String;", "setSceneId", "(Ljava/lang/String;)V", "getQuotaConfig", "()Lcom/larus/bmhome/auth/QuotaConfig;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouyinFeedEntrance implements Parcelable {
    public static final Parcelable.Creator<DouyinFeedEntrance> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QuotaConfig f295723a;

    @SerializedName(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE)
    private int entranceType;

    @SerializedName("scene_id")
    private String sceneId;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<DouyinFeedEntrance> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DouyinFeedEntrance createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            QuotaConfig r103 = null;
        L7:
            return new DouyinFeedEntrance(r101, r102, r103);
        L5:
            r103 = QuotaConfig.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final DouyinFeedEntrance[] newArray(int r100) {
            return new DouyinFeedEntrance[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public DouyinFeedEntrance() {
        this(0, "", null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DouyinFeedEntrance) == true) goto L8;
        return false;
    L8:
        DouyinFeedEntrance r101 = (DouyinFeedEntrance) r100;
        if (this.entranceType == r101.entranceType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneId, r101.sceneId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295723a, r101.f295723a) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.entranceType * 31;
        String r101 = this.sceneId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        QuotaConfig r105 = this.f295723a;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DouyinFeedEntrance(entranceType=" + this.entranceType + ", sceneId=" + this.sceneId + ", quotaConfig=" + this.f295723a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.entranceType);
        r100.writeString(this.sceneId);
        QuotaConfig r102 = this.f295723a;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
    }

    public final int a() {
        return this.entranceType;
    }

    public final String b() {
        return this.sceneId;
    }

    public DouyinFeedEntrance(int r100, String r101, QuotaConfig r102) {
        this.entranceType = r100;
        this.sceneId = r101;
        this.f295723a = r102;
    }
}
