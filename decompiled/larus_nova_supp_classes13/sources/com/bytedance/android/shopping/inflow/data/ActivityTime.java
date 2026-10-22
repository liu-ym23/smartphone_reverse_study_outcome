package com.bytedance.android.shopping.inflow.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JQ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/inflow/data/ActivityTime;", "Ljava/io/Serializable;", "serverTime", "", "startTime", "endTime", "preStartTime", "restBeginTime", "restEndTime", "countDownTextBgColor", "", "(JJJJJJLjava/lang/String;)V", "getCountDownTextBgColor", "()Ljava/lang/String;", "getEndTime", "()J", "getPreStartTime", "getRestBeginTime", "getRestEndTime", "getServerTime", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityTime implements Serializable {

    @SerializedName("count_down_text_bg_color")
    private final String countDownTextBgColor;

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
        this(0, 0, 0, 0, 0, 0, null, 127, null);
    }

    public static /* synthetic */ ActivityTime copy$default(ActivityTime r14, long r15, long r17, long r19, long r21, long r23, long r25, String r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        long r1 = r14.serverTime;
    L7:
        if ((r28 & 2) == 0) goto L9;
        long r3 = r14.startTime;
    L11:
        if ((r28 & 4) == 0) goto L13;
        long r5 = r14.endTime;
    L15:
        if ((r28 & 8) == 0) goto L17;
        long r7 = r14.preStartTime;
    L19:
        if ((r28 & 16) == 0) goto L21;
        long r9 = r14.restBeginTime;
    L23:
        if ((r28 & 32) == 0) goto L25;
        long r11 = r14.restEndTime;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r13 = r14.countDownTextBgColor;
    L31:
        return r14.copy(r1, r3, r5, r7, r9, r11, r13);
    L29:
        r13 = r27;
        goto L31
    L25:
        r11 = r25;
        goto L27
    L21:
        r9 = r23;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }

    public final long component1() {
        return this.serverTime;
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

    public final String component7() {
        return this.countDownTextBgColor;
    }

    public final ActivityTime copy(long r16, long r18, long r20, long r22, long r24, long r26, String r28) {
        return new ActivityTime(r16, r18, r20, r22, r24, r26, r28);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ActivityTime) == false) goto L20;
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
        if (Intrinsics.areEqual(this.countDownTextBgColor, r7.countDownTextBgColor) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
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
        String r12 = this.countDownTextBgColor;
        if (r12 == null) goto L5;
        int r13 = r12.hashCode();
    L7:
        return r11 + r13;
    L5:
        r13 = 0;
        goto L7
    }

    public String toString() {
        return "ActivityTime(serverTime=" + this.serverTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", preStartTime=" + this.preStartTime + ", restBeginTime=" + this.restBeginTime + ", restEndTime=" + this.restEndTime + ", countDownTextBgColor=" + this.countDownTextBgColor + ")";
    }

    public final String getCountDownTextBgColor() {
        return this.countDownTextBgColor;
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

    public ActivityTime(long r1, long r3, long r5, long r7, long r9, long r11, String r13) {
        this.serverTime = r1;
        this.startTime = r3;
        this.endTime = r5;
        this.preStartTime = r7;
        this.restBeginTime = r9;
        this.restEndTime = r11;
        this.countDownTextBgColor = r13;
    }

    public /* synthetic */ ActivityTime(long r14, long r16, long r18, long r20, long r22, long r24, String r26, int r27, DefaultConstructorMarker r28) {
        long r1 = 0;
        if ((r27 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r27 & 2) == 0) goto L9;
        long r5 = 0;
    L11:
        if ((r27 & 4) == 0) goto L13;
        long r7 = 0;
    L15:
        if ((r27 & 8) == 0) goto L17;
        long r9 = 0;
    L19:
        if ((r27 & 16) == 0) goto L21;
        long r11 = 0;
    L23:
        if ((r27 & 32) != 0) goto L27;
        r1 = r24;
    L27:
        if ((r27 & 64) == 0) goto L29;
        String r0 = null;
    L30:
        this(r3, r5, r7, r9, r11, r1, r0);
        return;
    L29:
        r0 = r26;
        goto L30
    L21:
        r11 = r22;
        goto L23
    L17:
        r9 = r20;
        goto L19
    L13:
        r7 = r18;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r3 = r14;
        goto L7
    }
}
