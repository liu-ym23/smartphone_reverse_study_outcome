package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasPerfData;", "Ljava/io/Serializable;", "imageDisplayDuration", "", "receiveImageDuration", "receiveReviewResultDuration", "logId", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "Ljava/lang/Long;", DyPayConstant.KEY_START_TIME, "getStartTime", "()J", "setStartTime", "(J)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasPerfData implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient long f323806a;

    @SerializedName("image_display_duration")
    public Long imageDisplayDuration;

    @SerializedName("log_id")
    public String logId;

    @SerializedName("receive_image_duration")
    public Long receiveImageDuration;

    @SerializedName("receive_review_result_duration")
    public Long receiveReviewResultDuration;

    public CanvasPerfData() {
        this(null, null, null, null, 15, null);
    }

    public final long getStartTime() {
        return this.f323806a;
    }

    public final void setStartTime(long r100) {
        this.f323806a = r100;
    }

    public CanvasPerfData(Long r100, Long r101, Long r102, String r103) {
        this.imageDisplayDuration = r100;
        this.receiveImageDuration = r101;
        this.receiveReviewResultDuration = r102;
        this.logId = r103;
    }

    public /* synthetic */ CanvasPerfData(Long r100, Long r101, Long r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
