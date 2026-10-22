package com.larus.platform.model.office;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/office/LarkMinutesRecordingConfig;", "", "startRecordingTimeoutInSec", "", "moaStartRecordingTimeoutInSec", "enableOfficeSdkLoginOpt", "", "<init>", "(JJZ)V", "getStartRecordingTimeoutInSec", "()J", "getMoaStartRecordingTimeoutInSec", "getEnableOfficeSdkLoginOpt", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkMinutesRecordingConfig {

    @SerializedName("enable_office_sdk_login_opt")
    private final boolean enableOfficeSdkLoginOpt;

    @SerializedName("moa_start_recording_timeout_in_sec")
    private final long moaStartRecordingTimeoutInSec;

    @SerializedName("start_recording_timeout_in_sec")
    private final long startRecordingTimeoutInSec;

    public LarkMinutesRecordingConfig() {
        this(0, 0, false, 7, null);
    }

    public static /* synthetic */ LarkMinutesRecordingConfig copy$default(LarkMinutesRecordingConfig r100, long r101, long r102, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.startRecordingTimeoutInSec;
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.moaStartRecordingTimeoutInSec;
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L12;
        r110 = r100.enableOfficeSdkLoginOpt;
    L12:
        return r100.copy(r103, r104, r110);
    }

    public final long component1() {
        return this.startRecordingTimeoutInSec;
    }

    public final long component2() {
        return this.moaStartRecordingTimeoutInSec;
    }

    public final boolean component3() {
        return this.enableOfficeSdkLoginOpt;
    }

    public final LarkMinutesRecordingConfig copy(long r100, long r110, boolean r111) {
        return new LarkMinutesRecordingConfig(r100, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkMinutesRecordingConfig) == true) goto L8;
        return false;
    L8:
        LarkMinutesRecordingConfig r101 = (LarkMinutesRecordingConfig) r100;
        if (this.startRecordingTimeoutInSec == r101.startRecordingTimeoutInSec) goto L12;
        return false;
    L12:
        if (this.moaStartRecordingTimeoutInSec == r101.moaStartRecordingTimeoutInSec) goto L15;
        return false;
    L15:
        if (this.enableOfficeSdkLoginOpt == r101.enableOfficeSdkLoginOpt) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = this.startRecordingTimeoutInSec;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.moaStartRecordingTimeoutInSec;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        if (this.enableOfficeSdkLoginOpt == false) goto L5;
        int r104 = 1231;
    L7:
        return r103 + r104;
    L5:
        r104 = 1237;
        goto L7
    }

    public String toString() {
        return "LarkMinutesRecordingConfig(startRecordingTimeoutInSec=" + this.startRecordingTimeoutInSec + ", moaStartRecordingTimeoutInSec=" + this.moaStartRecordingTimeoutInSec + ", enableOfficeSdkLoginOpt=" + this.enableOfficeSdkLoginOpt + ')';
    }

    public final boolean getEnableOfficeSdkLoginOpt() {
        return this.enableOfficeSdkLoginOpt;
    }

    public final long getMoaStartRecordingTimeoutInSec() {
        return this.moaStartRecordingTimeoutInSec;
    }

    public final long getStartRecordingTimeoutInSec() {
        return this.startRecordingTimeoutInSec;
    }

    public LarkMinutesRecordingConfig(long r100, long r101, boolean r102) {
        this.startRecordingTimeoutInSec = r100;
        this.moaStartRecordingTimeoutInSec = r101;
        this.enableOfficeSdkLoginOpt = r102;
    }

    public /* synthetic */ LarkMinutesRecordingConfig(long r100, long r101, boolean r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = 30;
    L5:
        long r102 = r100;
        if ((r111 & 2) == 0) goto L8;
        r101 = 180;
    L8:
        long r103 = r101;
        if ((r111 & 4) == 0) goto L11;
        boolean r104 = true;
    L12:
        this(r102, r103, r104);
        return;
    L11:
        r104 = r110;
        goto L12
    }
}
