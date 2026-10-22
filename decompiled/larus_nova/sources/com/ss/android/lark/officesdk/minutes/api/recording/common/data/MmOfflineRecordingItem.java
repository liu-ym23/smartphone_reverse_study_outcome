package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmOfflineRecordingItem;", "Ljava/io/Serializable;", "recordingId", "", "startTimeMs", "", "isRecording", "", "source", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "<init>", "(Ljava/lang/String;JZLcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;)V", "getRecordingId", "()Ljava/lang/String;", "getStartTimeMs", "()J", "()Z", "getSource", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmOfflineRecordingItem implements Serializable {
    private final boolean isRecording;
    private final String recordingId;
    private final MmRecordingSource source;
    private final long startTimeMs;

    public static /* synthetic */ MmOfflineRecordingItem copy$default(MmOfflineRecordingItem r100, String r101, long r102, boolean r103, MmRecordingSource r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.recordingId;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.startTimeMs;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.isRecording;
    L11:
        boolean r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.source;
    L14:
        String r107 = r101;
        return r100.copy(r107, r106, r111, r104);
    }

    public final String component1() {
        return this.recordingId;
    }

    public final long component2() {
        return this.startTimeMs;
    }

    public final boolean component3() {
        return this.isRecording;
    }

    public final MmRecordingSource component4() {
        return this.source;
    }

    public final MmOfflineRecordingItem copy(String r100, long r101, boolean r110, MmRecordingSource r111) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        return new MmOfflineRecordingItem(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmOfflineRecordingItem) == true) goto L8;
        return false;
    L8:
        MmOfflineRecordingItem r101 = (MmOfflineRecordingItem) r100;
        if (Intrinsics.areEqual(this.recordingId, r101.recordingId) == true) goto L12;
        return false;
    L12:
        if (this.startTimeMs == r101.startTimeMs) goto L15;
        return false;
    L15:
        if (this.isRecording == r101.isRecording) goto L18;
        return false;
    L18:
        if (this.source == r101.source) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.recordingId.hashCode() * 31;
        long r101 = this.startTimeMs;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.isRecording == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        MmRecordingSource r105 = this.source;
        if (r105 != null) goto L9;
        int r106 = 0;
    L11:
        return r104 + r106;
    L9:
        r106 = r105.hashCode();
        goto L11
    L5:
        r103 = 1237;
        goto L6
    }

    public String toString() {
        return "MmOfflineRecordingItem(recordingId=" + this.recordingId + ", startTimeMs=" + this.startTimeMs + ", isRecording=" + this.isRecording + ", source=" + this.source + ')';
    }

    public final String getRecordingId() {
        return this.recordingId;
    }

    public final MmRecordingSource getSource() {
        return this.source;
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final boolean isRecording() {
        return this.isRecording;
    }

    public MmOfflineRecordingItem(String r100, long r101, boolean r102, MmRecordingSource r103) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        this.recordingId = r100;
        this.startTimeMs = r101;
        this.isRecording = r102;
        this.source = r103;
    }

    public /* synthetic */ MmOfflineRecordingItem(String r100, long r101, boolean r110, MmRecordingSource r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r110, r111);
    }
}
