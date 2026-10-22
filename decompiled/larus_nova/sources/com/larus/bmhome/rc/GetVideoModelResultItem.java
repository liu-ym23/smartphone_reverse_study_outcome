package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/rc/GetVideoModelResultItem;", "", "params", "Lcom/larus/bmhome/rc/GetVideoModelParam;", "videoModelResult", "Lcom/larus/bmhome/rc/VideoModelResult;", "videoUrlResult", "Lcom/larus/bmhome/rc/VideoUrlResult;", "<init>", "(Lcom/larus/bmhome/rc/GetVideoModelParam;Lcom/larus/bmhome/rc/VideoModelResult;Lcom/larus/bmhome/rc/VideoUrlResult;)V", "getParams", "()Lcom/larus/bmhome/rc/GetVideoModelParam;", "getVideoModelResult", "()Lcom/larus/bmhome/rc/VideoModelResult;", "getVideoUrlResult", "()Lcom/larus/bmhome/rc/VideoUrlResult;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetVideoModelResultItem {

    @SerializedName("params")
    private final GetVideoModelParam params;

    @SerializedName("video_model_result")
    private final VideoModelResult videoModelResult;

    @SerializedName("video_url_result")
    private final VideoUrlResult videoUrlResult;

    public GetVideoModelResultItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ GetVideoModelResultItem copy$default(GetVideoModelResultItem r100, GetVideoModelParam r101, VideoModelResult r102, VideoUrlResult r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.params;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.videoModelResult;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.videoUrlResult;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final GetVideoModelParam component1() {
        return this.params;
    }

    public final VideoModelResult component2() {
        return this.videoModelResult;
    }

    public final VideoUrlResult component3() {
        return this.videoUrlResult;
    }

    public final GetVideoModelResultItem copy(GetVideoModelParam r100, VideoModelResult r101, VideoUrlResult r102) {
        return new GetVideoModelResultItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetVideoModelResultItem) == true) goto L8;
        return false;
    L8:
        GetVideoModelResultItem r101 = (GetVideoModelResultItem) r100;
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videoModelResult, r101.videoModelResult) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.videoUrlResult, r101.videoUrlResult) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        GetVideoModelParam r100 = this.params;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        VideoModelResult r104 = this.videoModelResult;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        VideoUrlResult r107 = this.videoUrlResult;
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
        return "GetVideoModelResultItem(params=" + this.params + ", videoModelResult=" + this.videoModelResult + ", videoUrlResult=" + this.videoUrlResult + ')';
    }

    public final GetVideoModelParam getParams() {
        return this.params;
    }

    public final VideoModelResult getVideoModelResult() {
        return this.videoModelResult;
    }

    public final VideoUrlResult getVideoUrlResult() {
        return this.videoUrlResult;
    }

    public GetVideoModelResultItem(GetVideoModelParam r100, VideoModelResult r101, VideoUrlResult r102) {
        this.params = r100;
        this.videoModelResult = r101;
        this.videoUrlResult = r102;
    }

    public /* synthetic */ GetVideoModelResultItem(GetVideoModelParam r100, VideoModelResult r101, VideoUrlResult r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
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
