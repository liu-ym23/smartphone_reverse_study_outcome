package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003Js\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\rHÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityTime;", "Ljava/io/Serializable;", "serverTime", "", "startTime", "endTime", "preStartTime", "restBeginTime", "restEndTime", "activityDesc", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "countdownInterval", "countDownTextBgColor", "", "countDownTextStyle", "Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "(JJJJJJLcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;JLjava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;)V", "getActivityDesc", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getCountDownTextBgColor", "()Ljava/lang/String;", "getCountDownTextStyle", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "getCountdownInterval", "()J", "getEndTime", "getPreStartTime", "getRestBeginTime", "getRestEndTime", "getServerTime", "getStartTime", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityTime implements Serializable {

    @SerializedName("activity_desc")
    private final TextElement activityDesc;

    @SerializedName("count_down_text_bg_color")
    private final String countDownTextBgColor;

    @SerializedName("count_down_text_style")
    private final FontStyle countDownTextStyle;

    @SerializedName("interval_time")
    private final long countdownInterval;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("pre_start_time")
    private final long preStartTime;

    @SerializedName("rest_begin_time")
    private final long restBeginTime;

    @SerializedName("rest_end_time")
    private final long restEndTime;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName("start_time")
    private final long startTime;

    public ActivityTime() {
        this(0, 0, 0, 0, 0, 0, null, 0, null, null, 1023, null);
    }

    public static /* synthetic */ ActivityTime copy$default(ActivityTime r16, long r17, long r19, long r21, long r23, long r25, long r27, TextElement r29, long r30, String r32, FontStyle r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        long r2 = r16.serverTime;
    L7:
        if ((r34 & 2) == 0) goto L9;
        long r4 = r16.startTime;
    L11:
        if ((r34 & 4) == 0) goto L13;
        long r6 = r16.endTime;
    L15:
        if ((r34 & 8) == 0) goto L17;
        long r8 = r16.preStartTime;
    L19:
        if ((r34 & 16) == 0) goto L21;
        long r10 = r16.restBeginTime;
    L23:
        if ((r34 & 32) == 0) goto L25;
        long r12 = r16.restEndTime;
    L27:
        if ((r34 & 64) == 0) goto L29;
        TextElement r14 = r16.activityDesc;
    L30:
        TextElement r210 = r14;
        if ((r34 & 128) == 0) goto L33;
        long r15 = r16.countdownInterval;
    L34:
        long r31 = r15;
        if ((r34 & 256) == 0) goto L37;
        String r18 = r16.countDownTextBgColor;
    L39:
        if ((r34 & 512) == 0) goto L41;
        FontStyle r1 = r16.countDownTextStyle;
    L43:
        return r16.copy(r2, r4, r6, r8, r10, r12, r210, r31, r18, r1);
    L41:
        r1 = r33;
        goto L43
    L37:
        r18 = r32;
        goto L39
    L33:
        r15 = r30;
        goto L34
    L29:
        r14 = r29;
        goto L30
    L25:
        r12 = r27;
        goto L27
    L21:
        r10 = r25;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long component1() {
        return this.serverTime;
    }

    public final FontStyle component10() {
        return this.countDownTextStyle;
    }

    public final long component2() {
        return this.startTime;
    }

    public final long component3() {
        return this.endTime;
    }

    public final long component4() {
        return this.preStartTime;
    }

    public final long component5() {
        return this.restBeginTime;
    }

    public final long component6() {
        return this.restEndTime;
    }

    public final TextElement component7() {
        return this.activityDesc;
    }

    public final long component8() {
        return this.countdownInterval;
    }

    public final String component9() {
        return this.countDownTextBgColor;
    }

    public final ActivityTime copy(long r20, long r22, long r24, long r26, long r28, long r30, TextElement r32, long r33, String r35, FontStyle r36) {
        return new ActivityTime(r20, r22, r24, r26, r28, r30, r32, r33, r35, r36);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ActivityTime) == false) goto L26;
        ActivityTime r7 = (ActivityTime) r6;
        if (this.serverTime == r7.serverTime) goto L8;
        return false;
    L8:
        if (this.startTime == r7.startTime) goto L10;
        return false;
    L10:
        if (this.endTime == r7.endTime) goto L12;
        return false;
    L12:
        if (this.preStartTime == r7.preStartTime) goto L14;
        return false;
    L14:
        if (this.restBeginTime == r7.restBeginTime) goto L16;
        return false;
    L16:
        if (this.restEndTime == r7.restEndTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.activityDesc, r7.activityDesc) == true) goto L20;
        return false;
    L20:
        if (this.countdownInterval == r7.countdownInterval) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.countDownTextBgColor, r7.countDownTextBgColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.countDownTextStyle, r7.countDownTextStyle) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        long r0 = this.serverTime;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.startTime;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.endTime;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.preStartTime;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.restBeginTime;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.restEndTime;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        TextElement r12 = this.activityDesc;
        int r13 = 0;
        if (r12 == null) goto L5;
        int r14 = r12.hashCode();
    L6:
        long r15 = this.countdownInterval;
        int r16 = (((r11 + r14) * 31) + ((int) (r15 ^ (r15 >>> 32)))) * 31;
        String r17 = this.countDownTextBgColor;
        if (r17 == null) goto L9;
        int r18 = r17.hashCode();
    L10:
        int r19 = (r16 + r18) * 31;
        FontStyle r20 = this.countDownTextStyle;
        if (r20 == null) goto L14;
        r13 = r20.hashCode();
    L14:
        return r19 + r13;
    L9:
        r18 = 0;
        goto L10
    L5:
        r14 = 0;
        goto L6
    }

    public String toString() {
        return "ActivityTime(serverTime=" + this.serverTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", preStartTime=" + this.preStartTime + ", restBeginTime=" + this.restBeginTime + ", restEndTime=" + this.restEndTime + ", activityDesc=" + this.activityDesc + ", countdownInterval=" + this.countdownInterval + ", countDownTextBgColor=" + this.countDownTextBgColor + ", countDownTextStyle=" + this.countDownTextStyle + ")";
    }

    public final TextElement getActivityDesc() {
        return this.activityDesc;
    }

    public final String getCountDownTextBgColor() {
        return this.countDownTextBgColor;
    }

    public final FontStyle getCountDownTextStyle() {
        return this.countDownTextStyle;
    }

    public final long getCountdownInterval() {
        return this.countdownInterval;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getPreStartTime() {
        return this.preStartTime;
    }

    public final long getRestBeginTime() {
        return this.restBeginTime;
    }

    public final long getRestEndTime() {
        return this.restEndTime;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public ActivityTime(long r4, long r6, long r8, long r10, long r12, long r14, TextElement r16, long r17, String r19, FontStyle r20) {
        this.serverTime = r4;
        this.startTime = r6;
        this.endTime = r8;
        this.preStartTime = r10;
        this.restBeginTime = r12;
        this.restEndTime = r14;
        this.activityDesc = r16;
        this.countdownInterval = r17;
        this.countDownTextBgColor = r19;
        this.countDownTextStyle = r20;
    }

    public /* synthetic */ ActivityTime(long r18, long r20, long r22, long r24, long r26, long r28, TextElement r30, long r31, String r33, FontStyle r34, int r35, DefaultConstructorMarker r36) {
        long r2 = 0;
        if ((r35 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r35 & 2) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r35 & 4) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r35 & 8) == 0) goto L17;
        long r10 = 0;
    L19:
        if ((r35 & 16) == 0) goto L21;
        long r12 = 0;
    L23:
        if ((r35 & 32) != 0) goto L27;
        r2 = r28;
    L27:
        if ((r35 & 64) == 0) goto L29;
        TextElement r1 = null;
    L31:
        if ((r35 & 128) == 0) goto L33;
        long r15 = 1000;
    L35:
        if ((r35 & 256) == 0) goto L37;
        String r14 = null;
    L39:
        if ((r35 & 512) == 0) goto L41;
        FontStyle r0 = null;
    L42:
        this(r4, r6, r8, r10, r12, r2, r1, r15, r14, r0);
        return;
    L41:
        r0 = r34;
        goto L42
    L37:
        r14 = r33;
        goto L39
    L33:
        r15 = r31;
        goto L35
    L29:
        r1 = r30;
        goto L31
    L21:
        r12 = r26;
        goto L23
    L17:
        r10 = r24;
        goto L19
    L13:
        r8 = r22;
        goto L15
    L9:
        r6 = r20;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }
}
