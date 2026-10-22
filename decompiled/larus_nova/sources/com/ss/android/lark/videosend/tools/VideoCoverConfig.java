package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/videosend/tools/VideoCoverConfig;", "", "concurrenceUploadEnable", "", "coverFileLimit", "Lcom/ss/android/lark/videosend/tools/VideoCoverLimit;", "<init>", "(ILcom/ss/android/lark/videosend/tools/VideoCoverLimit;)V", "getConcurrenceUploadEnable", "()I", "setConcurrenceUploadEnable", "(I)V", "getCoverFileLimit", "()Lcom/ss/android/lark/videosend/tools/VideoCoverLimit;", "setCoverFileLimit", "(Lcom/ss/android/lark/videosend/tools/VideoCoverLimit;)V", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoCoverConfig {

    @SerializedName("concurrence_upload_enable")
    private int concurrenceUploadEnable;

    @SerializedName("cover_file_limit")
    private VideoCoverLimit coverFileLimit;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoCoverConfig() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public final int getConcurrenceUploadEnable() {
        return this.concurrenceUploadEnable;
    }

    public final VideoCoverLimit getCoverFileLimit() {
        return this.coverFileLimit;
    }

    public final void setConcurrenceUploadEnable(int r100) {
        this.concurrenceUploadEnable = r100;
    }

    public final void setCoverFileLimit(VideoCoverLimit r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.coverFileLimit = r100;
    }

    public VideoCoverConfig(int r100, VideoCoverLimit r101) {
        Intrinsics.checkNotNullParameter(r101, "coverFileLimit");
        this.concurrenceUploadEnable = r100;
        this.coverFileLimit = r101;
    }

    public /* synthetic */ VideoCoverConfig(int r100, VideoCoverLimit r101, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r101 = new VideoCoverLimit(0, 0, 0, 0, 15, null);
    L8:
        this(r100, r101);
    }
}
