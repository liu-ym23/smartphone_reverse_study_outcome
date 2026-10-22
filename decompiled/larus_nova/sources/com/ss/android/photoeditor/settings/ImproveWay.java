package com.ss.android.photoeditor.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/ss/android/photoeditor/settings/ImproveWay;", "", "reduceColor", "", "", "releasePreBitmap", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getReduceColor", "()Ljava/util/List;", "setReduceColor", "(Ljava/util/List;)V", "getReleasePreBitmap", "setReleasePreBitmap", "toString", "", "photoeditor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImproveWay {

    @SerializedName("reduce_color")
    private List<Integer> reduceColor;

    @SerializedName("release_pre_bitmap")
    private List<Integer> releasePreBitmap;

    /* JADX WARN: Multi-variable type inference failed */
    public ImproveWay() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public String toString() {
        return "reduceColor=" + this.reduceColor + ",releasePreBitmap=" + this.releasePreBitmap;
    }

    public final List<Integer> getReduceColor() {
        return this.reduceColor;
    }

    public final List<Integer> getReleasePreBitmap() {
        return this.releasePreBitmap;
    }

    public final void setReduceColor(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reduceColor = r100;
    }

    public final void setReleasePreBitmap(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.releasePreBitmap = r100;
    }

    public ImproveWay(List<Integer> r100, List<Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "reduceColor");
        Intrinsics.checkNotNullParameter(r101, "releasePreBitmap");
        this.reduceColor = r100;
        this.releasePreBitmap = r101;
    }

    public /* synthetic */ ImproveWay(List r110, List r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r110 = CollectionsKt.mutableListOf(new Integer[]{2, 3, 4, 5});
    L6:
        if ((r112 & 2) == 0) goto L8;
        r111 = CollectionsKt.mutableListOf(new Integer[]{2, 3, 4, 5});
    L8:
        this(r110, r111);
    }
}
