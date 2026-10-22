package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006("}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/RealtimeCallQuotaData;", "Landroid/os/Parcelable;", "configRequestExpireTime", "", "audioDurationLimit", "Lcom/larus/voicecall/impl/degrade/bean/DurationLimit;", "videoDurationLimit", "audioQuotaInfo", "Lcom/larus/voicecall/impl/degrade/bean/QuotaInfo;", "videoQuotaInfo", "<init>", "(JLcom/larus/voicecall/impl/degrade/bean/DurationLimit;Lcom/larus/voicecall/impl/degrade/bean/DurationLimit;Lcom/larus/voicecall/impl/degrade/bean/QuotaInfo;Lcom/larus/voicecall/impl/degrade/bean/QuotaInfo;)V", "getConfigRequestExpireTime", "()J", "getAudioDurationLimit", "()Lcom/larus/voicecall/impl/degrade/bean/DurationLimit;", "getVideoDurationLimit", "getAudioQuotaInfo", "()Lcom/larus/voicecall/impl/degrade/bean/QuotaInfo;", "getVideoQuotaInfo", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallQuotaData implements Parcelable {
    public static final Parcelable.Creator<RealtimeCallQuotaData> CREATOR = null;

    @SerializedName("audio_duration_limit")
    private final DurationLimit audioDurationLimit;

    @SerializedName("audio_quota_info")
    private final QuotaInfo audioQuotaInfo;

    @SerializedName("request_expire_time")
    private final long configRequestExpireTime;

    @SerializedName("video_duration_limit")
    private final DurationLimit videoDurationLimit;

    @SerializedName("video_quota_info")
    private final QuotaInfo videoQuotaInfo;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<RealtimeCallQuotaData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RealtimeCallQuotaData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            long r101 = r100.readLong();
            QuotaInfo r102 = null;
            if (r100.readInt() != 0) goto L5;
            DurationLimit r103 = null;
        L6:
            DurationLimit r104 = r103;
            if (r100.readInt() != 0) goto L9;
            DurationLimit r105 = null;
        L10:
            DurationLimit r106 = r105;
            if (r100.readInt() != 0) goto L13;
            QuotaInfo r107 = null;
        L14:
            QuotaInfo r108 = r107;
            if (r100.readInt() == 0) goto L19;
            r102 = QuotaInfo.CREATOR.createFromParcel(r100);
        L19:
            return new RealtimeCallQuotaData(r101, r104, r106, r108, r102);
        L13:
            r107 = QuotaInfo.CREATOR.createFromParcel(r100);
            goto L14
        L9:
            r105 = DurationLimit.CREATOR.createFromParcel(r100);
            goto L10
        L5:
            r103 = DurationLimit.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final RealtimeCallQuotaData[] newArray(int r100) {
            return new RealtimeCallQuotaData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public RealtimeCallQuotaData() {
        this(0, null, null, null, null, 31, null);
    }

    public static /* synthetic */ RealtimeCallQuotaData copy$default(RealtimeCallQuotaData r100, long r101, DurationLimit r110, DurationLimit r111, QuotaInfo r112, QuotaInfo r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.configRequestExpireTime;
    L5:
        long r102 = r101;
        if ((r114 & 2) == 0) goto L8;
        r110 = r100.audioDurationLimit;
    L8:
        DurationLimit r103 = r110;
        if ((r114 & 4) == 0) goto L11;
        r111 = r100.videoDurationLimit;
    L11:
        DurationLimit r104 = r111;
        if ((r114 & 8) == 0) goto L14;
        r112 = r100.audioQuotaInfo;
    L14:
        QuotaInfo r105 = r112;
        if ((r114 & 16) == 0) goto L18;
        r113 = r100.videoQuotaInfo;
    L18:
        return r100.copy(r102, r103, r104, r105, r113);
    }

    public final long component1() {
        return this.configRequestExpireTime;
    }

    public final DurationLimit component2() {
        return this.audioDurationLimit;
    }

    public final DurationLimit component3() {
        return this.videoDurationLimit;
    }

    public final QuotaInfo component4() {
        return this.audioQuotaInfo;
    }

    public final QuotaInfo component5() {
        return this.videoQuotaInfo;
    }

    public final RealtimeCallQuotaData copy(long r100, DurationLimit r110, DurationLimit r111, QuotaInfo r112, QuotaInfo r113) {
        return new RealtimeCallQuotaData(r100, r110, r111, r112, r113);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RealtimeCallQuotaData) == true) goto L8;
        return false;
    L8:
        RealtimeCallQuotaData r101 = (RealtimeCallQuotaData) r100;
        if (this.configRequestExpireTime == r101.configRequestExpireTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.audioDurationLimit, r101.audioDurationLimit) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.videoDurationLimit, r101.videoDurationLimit) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.audioQuotaInfo, r101.audioQuotaInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.videoQuotaInfo, r101.videoQuotaInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        long r100 = this.configRequestExpireTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        DurationLimit r102 = this.audioDurationLimit;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        DurationLimit r106 = this.videoDurationLimit;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        QuotaInfo r109 = this.audioQuotaInfo;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        QuotaInfo r112 = this.videoQuotaInfo;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        return r111 + r103;
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "RealtimeCallQuotaData(configRequestExpireTime=" + this.configRequestExpireTime + ", audioDurationLimit=" + this.audioDurationLimit + ", videoDurationLimit=" + this.videoDurationLimit + ", audioQuotaInfo=" + this.audioQuotaInfo + ", videoQuotaInfo=" + this.videoQuotaInfo + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.configRequestExpireTime);
        DurationLimit r102 = this.audioDurationLimit;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        DurationLimit r103 = this.videoDurationLimit;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        QuotaInfo r104 = this.audioQuotaInfo;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        QuotaInfo r105 = this.videoQuotaInfo;
        if (r105 != null) goto L17;
        r100.writeInt(0);
        return;
    L17:
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        return;
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L14
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final DurationLimit getAudioDurationLimit() {
        return this.audioDurationLimit;
    }

    public final QuotaInfo getAudioQuotaInfo() {
        return this.audioQuotaInfo;
    }

    public final long getConfigRequestExpireTime() {
        return this.configRequestExpireTime;
    }

    public final DurationLimit getVideoDurationLimit() {
        return this.videoDurationLimit;
    }

    public final QuotaInfo getVideoQuotaInfo() {
        return this.videoQuotaInfo;
    }

    public RealtimeCallQuotaData(long r100, DurationLimit r101, DurationLimit r102, QuotaInfo r103, QuotaInfo r104) {
        this.configRequestExpireTime = r100;
        this.audioDurationLimit = r101;
        this.videoDurationLimit = r102;
        this.audioQuotaInfo = r103;
        this.videoQuotaInfo = r104;
    }

    public /* synthetic */ RealtimeCallQuotaData(long r100, DurationLimit r110, DurationLimit r111, QuotaInfo r112, QuotaInfo r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        r100 = -1;
    L5:
        long r101 = r100;
        if ((r114 & 2) == 0) goto L8;
        DurationLimit r102 = null;
    L10:
        if ((r114 & 4) == 0) goto L12;
        DurationLimit r103 = null;
    L14:
        if ((r114 & 8) == 0) goto L16;
        QuotaInfo r104 = null;
    L18:
        if ((r114 & 16) == 0) goto L20;
        QuotaInfo r105 = null;
    L21:
        this(r101, r102, r103, r104, r105);
        return;
    L20:
        r105 = r113;
        goto L21
    L16:
        r104 = r112;
        goto L18
    L12:
        r103 = r111;
        goto L14
    L8:
        r102 = r110;
        goto L10
    }
}
