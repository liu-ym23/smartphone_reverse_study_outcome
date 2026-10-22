package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR.\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/videosend/tools/InternalSetting;", "", "encodeResolutionAlign4", "", "hideVEMetaData", "useByte264", "others", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(IIILjava/util/ArrayList;)V", "getEncodeResolutionAlign4", "()I", "setEncodeResolutionAlign4", "(I)V", "getHideVEMetaData", "setHideVEMetaData", "getUseByte264", "setUseByte264", "getOthers", "()Ljava/util/ArrayList;", "setOthers", "(Ljava/util/ArrayList;)V", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InternalSetting {

    @SerializedName("ve_enable_render_encode_resolution_align4")
    private int encodeResolutionAlign4;

    @SerializedName("ve_compile_hide_ve_metadata")
    private int hideVEMetaData;

    @SerializedName("others")
    private ArrayList<String> others;

    @SerializedName("use_byte264")
    private int useByte264;

    public InternalSetting() {
        this(0, 0, 0, null, 15, null);
    }

    public final int getEncodeResolutionAlign4() {
        return this.encodeResolutionAlign4;
    }

    public final int getHideVEMetaData() {
        return this.hideVEMetaData;
    }

    public final ArrayList<String> getOthers() {
        return this.others;
    }

    public final int getUseByte264() {
        return this.useByte264;
    }

    public final void setEncodeResolutionAlign4(int r100) {
        this.encodeResolutionAlign4 = r100;
    }

    public final void setHideVEMetaData(int r100) {
        this.hideVEMetaData = r100;
    }

    public final void setOthers(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.others = r100;
    }

    public final void setUseByte264(int r100) {
        this.useByte264 = r100;
    }

    public InternalSetting(int r100, int r101, int r102, ArrayList<String> r103) {
        Intrinsics.checkNotNullParameter(r103, "others");
        this.encodeResolutionAlign4 = r100;
        this.hideVEMetaData = r101;
        this.useByte264 = r102;
        this.others = r103;
    }

    public /* synthetic */ InternalSetting(int r100, int r101, int r102, ArrayList r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new ArrayList();
    L14:
        this(r100, r101, r102, r103);
    }
}
