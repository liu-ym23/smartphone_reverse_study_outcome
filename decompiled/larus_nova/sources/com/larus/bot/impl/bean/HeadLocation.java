package com.larus.bot.impl.bean;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import com.vivo.push.PushClientConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003Jn\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\"2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u00063"}, d2 = {"Lcom/larus/bot/impl/bean/HeadLocation;", "Ljava/io/Serializable;", "x1", "", "y1", "x2", "y2", "dedupTag", "", "prob", "classId", "", PushClientConstants.TAG_CLASS_NAME, "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;)V", "getX1", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getY1", "getX2", "getY2", "getDedupTag", "()Ljava/lang/String;", "getProb", "getClassId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getClassName", "centerX", "getCenterX", "()D", "centerY", "getCenterY", "isValidLocation", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;)Lcom/larus/bot/impl/bean/HeadLocation;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadLocation implements Serializable {

    @SerializedName("class_id")
    private final Long classId;

    @SerializedName("class_name")
    private final String className;

    @SerializedName("dedup_tag")
    private final String dedupTag;

    @SerializedName("prob")
    private final Double prob;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    @SerializedName("x1")
    private final Double f317659x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    @SerializedName("x2")
    private final Double f317660x2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    @SerializedName("y1")
    private final Double f317661y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    @SerializedName("y2")
    private final Double f317662y2;

    public HeadLocation() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ HeadLocation copy$default(HeadLocation r100, Double r110, Double r111, Double r112, Double r113, String r114, Double r115, Long r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Double r101 = r100.f317659x1;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Double r102 = r100.f317661y1;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Double r103 = r100.f317660x2;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Double r104 = r100.f317662y2;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.dedupTag;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Double r106 = r100.prob;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Long r107 = r100.classId;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.className;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final Double component1() {
        return this.f317659x1;
    }

    public final Double component2() {
        return this.f317661y1;
    }

    public final Double component3() {
        return this.f317660x2;
    }

    public final Double component4() {
        return this.f317662y2;
    }

    public final String component5() {
        return this.dedupTag;
    }

    public final Double component6() {
        return this.prob;
    }

    public final Long component7() {
        return this.classId;
    }

    public final String component8() {
        return this.className;
    }

    public final HeadLocation copy(Double r110, Double r111, Double r112, Double r113, String r114, Double r115, Long r116, String r117) {
        return new HeadLocation(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HeadLocation) == true) goto L8;
        return false;
    L8:
        HeadLocation r101 = (HeadLocation) r100;
        if (Intrinsics.areEqual(this.f317659x1, r101.f317659x1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f317661y1, r101.f317661y1) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f317660x2, r101.f317660x2) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f317662y2, r101.f317662y2) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.dedupTag, r101.dedupTag) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.prob, r101.prob) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.classId, r101.classId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.className, r101.className) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        Double r100 = this.f317659x1;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.f317661y1;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Double r107 = this.f317660x2;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.f317662y2;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.dedupTag;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Double r116 = this.prob;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.classId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.className;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "HeadLocation(x1=" + this.f317659x1 + ", y1=" + this.f317661y1 + ", x2=" + this.f317660x2 + ", y2=" + this.f317662y2 + ", dedupTag=" + this.dedupTag + ", prob=" + this.prob + ", classId=" + this.classId + ", className=" + this.className + ')';
    }

    public final boolean isValidLocation() {
        if (this.f317659x1 != null) goto L5;
    L15:
        return false;
    L5:
        if (this.f317661y1 == null) goto L15;
        Double r100 = this.f317660x2;
        if (r100 == null) goto L15;
        if (this.f317662y2 == null) goto L15;
        if (r100.doubleValue() <= this.f317659x1.doubleValue()) goto L15;
        if (this.f317662y2.doubleValue() <= this.f317661y1.doubleValue()) goto L15;
        return true;
    }

    public final double getCenterX() {
        boolean r100 = isValidLocation();
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == false) goto L13;
        Double r102 = this.f317659x1;
        if (r102 == null) goto L7;
        double r103 = r102.doubleValue();
    L8:
        Double r104 = this.f317660x2;
        if (r104 == null) goto L12;
        r101 = r104.doubleValue();
    L12:
        return (r103 + r101) * 0.5d;
    L7:
        r103 = 0.0d;
        goto L8
    L13:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final double getCenterY() {
        boolean r100 = isValidLocation();
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == false) goto L13;
        Double r102 = this.f317661y1;
        if (r102 == null) goto L7;
        double r103 = r102.doubleValue();
    L8:
        Double r104 = this.f317662y2;
        if (r104 == null) goto L12;
        r101 = r104.doubleValue();
    L12:
        return (r103 + r101) * 0.5d;
    L7:
        r103 = 0.0d;
        goto L8
    L13:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final Long getClassId() {
        return this.classId;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getDedupTag() {
        return this.dedupTag;
    }

    public final Double getProb() {
        return this.prob;
    }

    public final Double getX1() {
        return this.f317659x1;
    }

    public final Double getX2() {
        return this.f317660x2;
    }

    public final Double getY1() {
        return this.f317661y1;
    }

    public final Double getY2() {
        return this.f317662y2;
    }

    public HeadLocation(Double r100, Double r101, Double r102, Double r103, String r104, Double r105, Long r106, String r107) {
        this.f317659x1 = r100;
        this.f317661y1 = r101;
        this.f317660x2 = r102;
        this.f317662y2 = r103;
        this.dedupTag = r104;
        this.prob = r105;
        this.classId = r106;
        this.className = r107;
    }

    public /* synthetic */ HeadLocation(Double r110, Double r111, Double r112, Double r113, String r114, Double r115, Long r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Double r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Double r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Double r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Double r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Double r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Long r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
