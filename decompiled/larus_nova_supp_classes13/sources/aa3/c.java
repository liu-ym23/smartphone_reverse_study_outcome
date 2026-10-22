package aa3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Laa3/c;", "", "", "preBindPage", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "preBindTiming", "f", "preBindCountResume", "b", "preBindInstantEnd", "d", "preBindCountLoadMore", "a", "preBindCountUserBehavior", "c", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("pre_bind_count_load_more")
    private final Integer preBindCountLoadMore;

    @SerializedName("pre_bind_count_resume")
    private final Integer preBindCountResume;

    @SerializedName("pre_bind_count_user_behavior")
    private final Integer preBindCountUserBehavior;

    @SerializedName("pre_bind_instant_end")
    private final Integer preBindInstantEnd;

    @SerializedName("pre_bind_page")
    private final Integer preBindPage;

    @SerializedName("pre_bind_timing")
    private final Integer preBindTiming;

    public c() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L18;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.preBindPage, r4.preBindPage) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.preBindTiming, r4.preBindTiming) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.preBindCountResume, r4.preBindCountResume) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preBindInstantEnd, r4.preBindInstantEnd) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.preBindCountLoadMore, r4.preBindCountLoadMore) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.preBindCountUserBehavior, r4.preBindCountUserBehavior) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.preBindPage;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.preBindTiming;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.preBindCountResume;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.preBindInstantEnd;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.preBindCountLoadMore;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.preBindCountUserBehavior;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
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
        return "MallPreBindSetting(preBindPage=" + this.preBindPage + ", preBindTiming=" + this.preBindTiming + ", preBindCountResume=" + this.preBindCountResume + ", preBindInstantEnd=" + this.preBindInstantEnd + ", preBindCountLoadMore=" + this.preBindCountLoadMore + ", preBindCountUserBehavior=" + this.preBindCountUserBehavior + ")";
    }

    public final Integer a() {
        return this.preBindCountLoadMore;
    }

    public final Integer b() {
        return this.preBindCountResume;
    }

    public final Integer c() {
        return this.preBindCountUserBehavior;
    }

    public final Integer d() {
        return this.preBindInstantEnd;
    }

    public final Integer e() {
        return this.preBindPage;
    }

    public final Integer f() {
        return this.preBindTiming;
    }

    public c(int r1) {
        this.preBindPage = null;
        this.preBindTiming = null;
        this.preBindCountResume = null;
        this.preBindInstantEnd = null;
        this.preBindCountLoadMore = null;
        this.preBindCountUserBehavior = null;
    }
}
