package com.bytedance.android.shopping.mall.opt;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/mall/opt/f;", "", "", "", "optPage", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "optVideoPlay", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "optBg", "a", "preBindOnRequestEnd", "getPreBindOnRequestEnd", "eventReport", "getEventReport", "reserveEventBlack", "e", "Lcom/bytedance/android/shopping/mall/opt/a;", "preBindOnLoadMoreSuccessConfig", "Lcom/bytedance/android/shopping/mall/opt/a;", "d", "()Lcom/bytedance/android/shopping/mall/opt/a;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("opt_event_report")
    private final List<String> eventReport;

    @SerializedName("opt_bg")
    private final Integer optBg;

    @SerializedName("opt_page")
    private final List<String> optPage;

    @SerializedName("opt_video_play")
    private final Integer optVideoPlay;

    @SerializedName("pre_bind_on_load_more_success_config")
    private final a preBindOnLoadMoreSuccessConfig;

    @SerializedName("pre_bind_on_request_end")
    private final Integer preBindOnRequestEnd;

    @SerializedName("reserve_event_black")
    private final List<String> reserveEventBlack;

    public f() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L20;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.optPage, r4.optPage) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.optVideoPlay, r4.optVideoPlay) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.optBg, r4.optBg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preBindOnRequestEnd, r4.preBindOnRequestEnd) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.eventReport, r4.eventReport) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.reserveEventBlack, r4.reserveEventBlack) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preBindOnLoadMoreSuccessConfig, r4.preBindOnLoadMoreSuccessConfig) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        List<String> r0 = this.optPage;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.optVideoPlay;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.optBg;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.preBindOnRequestEnd;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.eventReport;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.reserveEventBlack;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        a r19 = this.preBindOnLoadMoreSuccessConfig;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MallFrameOpt(optPage=" + this.optPage + ", optVideoPlay=" + this.optVideoPlay + ", optBg=" + this.optBg + ", preBindOnRequestEnd=" + this.preBindOnRequestEnd + ", eventReport=" + this.eventReport + ", reserveEventBlack=" + this.reserveEventBlack + ", preBindOnLoadMoreSuccessConfig=" + this.preBindOnLoadMoreSuccessConfig + ")";
    }

    public final Integer a() {
        return this.optBg;
    }

    public final List<String> b() {
        return this.optPage;
    }

    public final Integer c() {
        return this.optVideoPlay;
    }

    public final a d() {
        return this.preBindOnLoadMoreSuccessConfig;
    }

    public final List<String> e() {
        return this.reserveEventBlack;
    }

    public f(Object r1) {
        this.optPage = null;
        this.optVideoPlay = null;
        this.optBg = null;
        this.preBindOnRequestEnd = null;
        this.eventReport = null;
        this.reserveEventBlack = null;
        this.preBindOnLoadMoreSuccessConfig = null;
    }
}
