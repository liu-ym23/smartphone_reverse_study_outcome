package com.larus.mirabridge.api.pluginservice;

import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/larus/mirabridge/api/pluginservice/VideoStabilizeResult;", "", "success", "", "code", "", b.C, "", "realMasks", "<init>", "(ZILjava/lang/String;I)V", "getSuccess", "()Z", "getCode", "()I", "getSdkVersion", "()Ljava/lang/String;", "getRealMasks", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoStabilizeResult {
    private final int code;
    private final int realMasks;
    private final String sdkVersion;
    private final boolean success;

    public static /* synthetic */ VideoStabilizeResult copy$default(VideoStabilizeResult r100, boolean r101, int r102, String r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.success;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.code;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.sdkVersion;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.realMasks;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.success;
    }

    public final int component2() {
        return this.code;
    }

    public final String component3() {
        return this.sdkVersion;
    }

    public final int component4() {
        return this.realMasks;
    }

    public final VideoStabilizeResult copy(boolean r100, int r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, b.C);
        return new VideoStabilizeResult(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoStabilizeResult) == true) goto L8;
        return false;
    L8:
        VideoStabilizeResult r101 = (VideoStabilizeResult) r100;
        if (this.success == r101.success) goto L12;
        return false;
    L12:
        if (this.code == r101.code) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sdkVersion, r101.sdkVersion) == true) goto L18;
        return false;
    L18:
        if (this.realMasks == r101.realMasks) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.success == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((r100 * 31) + this.code) * 31) + this.sdkVersion.hashCode()) * 31) + this.realMasks;
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "VideoStabilizeResult(success=" + this.success + ", code=" + this.code + ", sdkVersion=" + this.sdkVersion + ", realMasks=" + this.realMasks + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final int getRealMasks() {
        return this.realMasks;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public VideoStabilizeResult(boolean r100, int r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, b.C);
        this.success = r100;
        this.code = r101;
        this.sdkVersion = r102;
        this.realMasks = r103;
    }

    public /* synthetic */ VideoStabilizeResult(boolean r100, int r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = 0;
    L8:
        this(r100, r101, r102, r103);
    }
}
