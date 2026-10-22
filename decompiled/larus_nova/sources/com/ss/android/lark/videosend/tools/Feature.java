package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/videosend/tools/Feature;", "", "hwDecode264", "Lcom/ss/android/lark/videosend/tools/HWDecode;", "hwDecode265", "hwEncode264", "Lcom/ss/android/lark/videosend/tools/HWEncode;", "enableRemuxVideoForRotation", "", "<init>", "(Lcom/ss/android/lark/videosend/tools/HWDecode;Lcom/ss/android/lark/videosend/tools/HWDecode;Lcom/ss/android/lark/videosend/tools/HWEncode;I)V", "getHwDecode264", "()Lcom/ss/android/lark/videosend/tools/HWDecode;", "setHwDecode264", "(Lcom/ss/android/lark/videosend/tools/HWDecode;)V", "getHwDecode265", "setHwDecode265", "getHwEncode264", "()Lcom/ss/android/lark/videosend/tools/HWEncode;", "setHwEncode264", "(Lcom/ss/android/lark/videosend/tools/HWEncode;)V", "getEnableRemuxVideoForRotation", "()I", "setEnableRemuxVideoForRotation", "(I)V", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Feature {

    @SerializedName("remux_video_for_rotation")
    private int enableRemuxVideoForRotation;

    @SerializedName("hw_decode_264")
    private HWDecode hwDecode264;

    @SerializedName("hw_decode_265")
    private HWDecode hwDecode265;

    @SerializedName("hw_encode_264")
    private HWEncode hwEncode264;

    public Feature() {
        this(null, null, null, 0, 15, null);
    }

    public final int getEnableRemuxVideoForRotation() {
        return this.enableRemuxVideoForRotation;
    }

    public final HWDecode getHwDecode264() {
        return this.hwDecode264;
    }

    public final HWDecode getHwDecode265() {
        return this.hwDecode265;
    }

    public final HWEncode getHwEncode264() {
        return this.hwEncode264;
    }

    public final void setEnableRemuxVideoForRotation(int r100) {
        this.enableRemuxVideoForRotation = r100;
    }

    public final void setHwDecode264(HWDecode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hwDecode264 = r100;
    }

    public final void setHwDecode265(HWDecode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hwDecode265 = r100;
    }

    public final void setHwEncode264(HWEncode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hwEncode264 = r100;
    }

    public Feature(HWDecode r100, HWDecode r101, HWEncode r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "hwDecode264");
        Intrinsics.checkNotNullParameter(r101, "hwDecode265");
        Intrinsics.checkNotNullParameter(r102, "hwEncode264");
        this.hwDecode264 = r100;
        this.hwDecode265 = r101;
        this.hwEncode264 = r102;
        this.enableRemuxVideoForRotation = r103;
    }

    public /* synthetic */ Feature(HWDecode r100, HWDecode r101, HWEncode r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = new HWDecode(null, 0, 0, 0, 15, null);
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = new HWDecode(null, 0, 0, 0, 15, null);
    L9:
        if ((r112 & 4) == 0) goto L12;
        r110 = new HWEncode(null, 1, null);
    L12:
        if ((r112 & 8) == 0) goto L14;
        r111 = 1;
    L14:
        this(r100, r101, r110, r111);
    }
}
