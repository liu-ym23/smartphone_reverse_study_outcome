package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationTrackMeta;", "Ljava/io/Serializable;", "kolAllVideoCnt", "", "contentSource", "", "(ILjava/lang/String;)V", "getContentSource", "()Ljava/lang/String;", "getKolAllVideoCnt", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4KolEvaluationTrackMeta implements Serializable {

    @SerializedName("content_source")
    private final String contentSource;

    @SerializedName("kol_video_cnt")
    private final int kolAllVideoCnt;

    public AnchorV4KolEvaluationTrackMeta() {
        String r0 = null;
        int r2 = 0;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ AnchorV4KolEvaluationTrackMeta copy$default(AnchorV4KolEvaluationTrackMeta r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.kolAllVideoCnt;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.contentSource;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.kolAllVideoCnt;
    }

    public final String component2() {
        return this.contentSource;
    }

    public final AnchorV4KolEvaluationTrackMeta copy(int r2, String r3) {
        return new AnchorV4KolEvaluationTrackMeta(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4KolEvaluationTrackMeta) == false) goto L10;
        AnchorV4KolEvaluationTrackMeta r4 = (AnchorV4KolEvaluationTrackMeta) r3;
        if (this.kolAllVideoCnt == r4.kolAllVideoCnt) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.contentSource, r4.contentSource) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r0 = this.kolAllVideoCnt * 31;
        String r1 = this.contentSource;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "AnchorV4KolEvaluationTrackMeta(kolAllVideoCnt=" + this.kolAllVideoCnt + ", contentSource=" + this.contentSource + ")";
    }

    public final String getContentSource() {
        return this.contentSource;
    }

    public final int getKolAllVideoCnt() {
        return this.kolAllVideoCnt;
    }

    public AnchorV4KolEvaluationTrackMeta(int r1, String r2) {
        this.kolAllVideoCnt = r1;
        this.contentSource = r2;
    }

    public /* synthetic */ AnchorV4KolEvaluationTrackMeta(int r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
