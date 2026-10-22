package com.ss.android.photoeditor.settings;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/ss/android/photoeditor/settings/QualityItem;", "", a.KEY_SCORE, "", "", "bigSideMax", "smallSideMax", "<init>", "(Ljava/util/List;II)V", "getScore", "()Ljava/util/List;", "setScore", "(Ljava/util/List;)V", "getBigSideMax", "()I", "setBigSideMax", "(I)V", "getSmallSideMax", "setSmallSideMax", "toString", "", "photoeditor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QualityItem {

    @SerializedName("big_side_max")
    private int bigSideMax;

    @SerializedName(a.KEY_SCORE)
    private List<Integer> score;

    @SerializedName("small_side_max")
    private int smallSideMax;

    public QualityItem() {
        this(null, 0, 0, 7, null);
    }

    public String toString() {
        return "score=" + this.score + ",bigSideMax=" + this.bigSideMax + ",smallSideMax=" + this.smallSideMax;
    }

    public final int getBigSideMax() {
        return this.bigSideMax;
    }

    public final List<Integer> getScore() {
        return this.score;
    }

    public final int getSmallSideMax() {
        return this.smallSideMax;
    }

    public final void setBigSideMax(int r100) {
        this.bigSideMax = r100;
    }

    public final void setScore(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.score = r100;
    }

    public final void setSmallSideMax(int r100) {
        this.smallSideMax = r100;
    }

    public QualityItem(List<Integer> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, a.KEY_SCORE);
        this.score = r100;
        this.bigSideMax = r101;
        this.smallSideMax = r102;
    }

    public /* synthetic */ QualityItem(List r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = CollectionsKt.mutableListOf(new Integer[]{4, 5});
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 1280;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 720;
    L11:
        this(r100, r101, r102);
    }
}
