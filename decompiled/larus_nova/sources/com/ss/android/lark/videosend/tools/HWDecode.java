package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR.\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/videosend/tools/HWDecode;", "", "whiteListPlus", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "minSide", "", "fpsLowerLimit", "highFPSMinSide", "<init>", "(Ljava/util/ArrayList;III)V", "getWhiteListPlus", "()Ljava/util/ArrayList;", "setWhiteListPlus", "(Ljava/util/ArrayList;)V", "getMinSide", "()I", "setMinSide", "(I)V", "getFpsLowerLimit", "setFpsLowerLimit", "getHighFPSMinSide", "setHighFPSMinSide", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HWDecode {

    @SerializedName("fpsLowerLimit")
    private int fpsLowerLimit;

    @SerializedName("highfps_min_side")
    private int highFPSMinSide;

    @SerializedName("min_side")
    private int minSide;

    @SerializedName("white_list_plus")
    private ArrayList<String> whiteListPlus;

    public HWDecode() {
        this(null, 0, 0, 0, 15, null);
    }

    public final int getFpsLowerLimit() {
        return this.fpsLowerLimit;
    }

    public final int getHighFPSMinSide() {
        return this.highFPSMinSide;
    }

    public final int getMinSide() {
        return this.minSide;
    }

    public final ArrayList<String> getWhiteListPlus() {
        return this.whiteListPlus;
    }

    public final void setFpsLowerLimit(int r100) {
        this.fpsLowerLimit = r100;
    }

    public final void setHighFPSMinSide(int r100) {
        this.highFPSMinSide = r100;
    }

    public final void setMinSide(int r100) {
        this.minSide = r100;
    }

    public final void setWhiteListPlus(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.whiteListPlus = r100;
    }

    public HWDecode(ArrayList<String> r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "whiteListPlus");
        this.whiteListPlus = r100;
        this.minSide = r101;
        this.fpsLowerLimit = r102;
        this.highFPSMinSide = r103;
    }

    public /* synthetic */ HWDecode(ArrayList r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 1090;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 40;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = TTVideoEngineInterface.PLAYER_OPTION_DECODE_EXTERN_INFO;
    L14:
        this(r100, r101, r102, r103);
    }
}
