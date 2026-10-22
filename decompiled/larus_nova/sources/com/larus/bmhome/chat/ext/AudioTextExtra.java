package com.larus.bmhome.chat.ext;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/ext/AudioTextExtra;", "", "recordPath", "", RemoteMessageConst.SEND_TIME, "", "recordTime", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getRecordPath", "()Ljava/lang/String;", "getSendTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRecordTime", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/bmhome/chat/ext/AudioTextExtra;", "equals", "", "other", "hashCode", "", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioTextExtra {

    @SerializedName("p")
    private final String recordPath;

    @SerializedName("r")
    private final Long recordTime;

    @SerializedName("t")
    private final Long sendTime;

    public AudioTextExtra() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AudioTextExtra copy$default(AudioTextExtra r100, String r101, Long r102, Long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.recordPath;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.sendTime;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.recordTime;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.recordPath;
    }

    public final Long component2() {
        return this.sendTime;
    }

    public final Long component3() {
        return this.recordTime;
    }

    public final AudioTextExtra copy(String r100, Long r101, Long r102) {
        return new AudioTextExtra(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioTextExtra) == true) goto L8;
        return false;
    L8:
        AudioTextExtra r101 = (AudioTextExtra) r100;
        if (Intrinsics.areEqual(this.recordPath, r101.recordPath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sendTime, r101.sendTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.recordTime, r101.recordTime) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.recordPath;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.sendTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.recordTime;
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

    public String toString() {
        return "AudioTextExtra(recordPath=" + this.recordPath + ", sendTime=" + this.sendTime + ", recordTime=" + this.recordTime + ')';
    }

    public final String getRecordPath() {
        return this.recordPath;
    }

    public final Long getRecordTime() {
        return this.recordTime;
    }

    public final Long getSendTime() {
        return this.sendTime;
    }

    public AudioTextExtra(String r100, Long r101, Long r102) {
        this.recordPath = r100;
        this.sendTime = r101;
        this.recordTime = r102;
    }

    public /* synthetic */ AudioTextExtra(String r100, Long r101, Long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
