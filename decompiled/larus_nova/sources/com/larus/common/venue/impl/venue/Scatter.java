package com.larus.common.venue.impl.venue;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003Jz\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006'"}, d2 = {"Lcom/larus/common/venue/impl/venue/Scatter;", "", "probs", "", "blockProbs", "lotteryFront", "lotteryRear", DBDefinition.SEGMENT_TABLE_NAME, "", "Lcom/larus/common/venue/impl/venue/Segment;", "beginSegment", "nonLotterySegments", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getProbs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBlockProbs", "getLotteryFront", "getLotteryRear", "getSegments", "()Ljava/util/List;", "getBeginSegment", "getNonLotterySegments", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/larus/common/venue/impl/venue/Scatter;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Scatter {

    @SerializedName("beginSegments")
    private final List<Segment> beginSegment;

    @SerializedName("blockProbs")
    private final Integer blockProbs;

    @SerializedName("lotteryFront")
    private final Integer lotteryFront;

    @SerializedName("lotteryRear")
    private final Integer lotteryRear;

    @SerializedName("nonLotterySegments")
    private final List<Segment> nonLotterySegments;

    @SerializedName("probs")
    private final Integer probs;

    @SerializedName(DBDefinition.SEGMENT_TABLE_NAME)
    private final List<Segment> segments;

    public Scatter() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Scatter copy$default(Scatter r100, Integer r101, Integer r102, Integer r103, Integer r104, List r110, List r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.probs;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.blockProbs;
    L8:
        Integer r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.lotteryFront;
    L11:
        Integer r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.lotteryRear;
    L14:
        Integer r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.segments;
    L17:
        List r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.beginSegment;
    L20:
        List r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.nonLotterySegments;
    L23:
        Integer r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Integer component1() {
        return this.probs;
    }

    public final Integer component2() {
        return this.blockProbs;
    }

    public final Integer component3() {
        return this.lotteryFront;
    }

    public final Integer component4() {
        return this.lotteryRear;
    }

    public final List<Segment> component5() {
        return this.segments;
    }

    public final List<Segment> component6() {
        return this.beginSegment;
    }

    public final List<Segment> component7() {
        return this.nonLotterySegments;
    }

    public final Scatter copy(Integer r110, Integer r111, Integer r112, Integer r113, List<Segment> r114, List<Segment> r115, List<Segment> r116) {
        return new Scatter(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Scatter) == true) goto L8;
        return false;
    L8:
        Scatter r101 = (Scatter) r100;
        if (Intrinsics.areEqual(this.probs, r101.probs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockProbs, r101.blockProbs) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lotteryFront, r101.lotteryFront) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lotteryRear, r101.lotteryRear) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.segments, r101.segments) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.beginSegment, r101.beginSegment) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.nonLotterySegments, r101.nonLotterySegments) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.probs;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.blockProbs;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.lotteryFront;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.lotteryRear;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<Segment> r113 = this.segments;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<Segment> r116 = this.beginSegment;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<Segment> r119 = this.nonLotterySegments;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Scatter(probs=" + this.probs + ", blockProbs=" + this.blockProbs + ", lotteryFront=" + this.lotteryFront + ", lotteryRear=" + this.lotteryRear + ", segments=" + this.segments + ", beginSegment=" + this.beginSegment + ", nonLotterySegments=" + this.nonLotterySegments + ')';
    }

    public final List<Segment> getBeginSegment() {
        return this.beginSegment;
    }

    public final Integer getBlockProbs() {
        return this.blockProbs;
    }

    public final Integer getLotteryFront() {
        return this.lotteryFront;
    }

    public final Integer getLotteryRear() {
        return this.lotteryRear;
    }

    public final List<Segment> getNonLotterySegments() {
        return this.nonLotterySegments;
    }

    public final Integer getProbs() {
        return this.probs;
    }

    public final List<Segment> getSegments() {
        return this.segments;
    }

    public Scatter(Integer r100, Integer r101, Integer r102, Integer r103, List<Segment> r104, List<Segment> r105, List<Segment> r106) {
        this.probs = r100;
        this.blockProbs = r101;
        this.lotteryFront = r102;
        this.lotteryRear = r103;
        this.segments = r104;
        this.beginSegment = r105;
        this.nonLotterySegments = r106;
    }

    public /* synthetic */ Scatter(Integer r100, Integer r101, Integer r102, Integer r103, List r110, List r111, List r112, int r113, DefaultConstructorMarker r114) {
        Integer r104 = 0;
        if ((r113 & 1) == 0) goto L5;
        Integer r115 = r104;
    L7:
        if ((r113 & 2) != 0) goto L11;
        r104 = r101;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r102 = -1;
    L13:
        Integer r105 = r102;
        if ((r113 & 8) == 0) goto L16;
        r103 = -1;
    L16:
        Integer r106 = r103;
        if ((r113 & 16) == 0) goto L19;
        List r107 = null;
    L21:
        if ((r113 & 32) == 0) goto L23;
        List r108 = null;
    L25:
        if ((r113 & 64) == 0) goto L27;
        List r116 = null;
    L28:
        this(r115, r104, r105, r106, r107, r108, r116);
        return;
    L27:
        r116 = r112;
        goto L28
    L23:
        r108 = r111;
        goto L25
    L19:
        r107 = r110;
        goto L21
    L5:
        r115 = r100;
        goto L7
    }
}
