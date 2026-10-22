package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lhe3/y;", "", "Lhe3/a0;", "coverInfo", "Lhe3/a0;", "a", "()Lhe3/a0;", "Lhe3/p1;", "priceInfo", "Lhe3/p1;", "c", "()Lhe3/p1;", "Lhe3/u1;", "salesInfo", "Lhe3/u1;", "e", "()Lhe3/u1;", "Lhe3/r1;", "recReasonInfo", "Lhe3/r1;", "d", "()Lhe3/r1;", "Lhe3/d2;", "titleTagInfo", "Lhe3/d2;", "f", "()Lhe3/d2;", "Lhe3/r;", "liveInfo", "Lhe3/r;", "b", "()Lhe3/r;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("cover_info")
    private final a0 coverInfo;

    @SerializedName("live_info")
    private final r liveInfo;

    @SerializedName("price_info")
    private final p1 priceInfo;

    @SerializedName("rec_reason_info")
    private final r1 recReasonInfo;

    @SerializedName("sales_info")
    private final u1 salesInfo;

    @SerializedName("title_tag_info")
    private final d2 titleTagInfo;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof y) == false) goto L18;
        y r4 = (y) r3;
        if (Intrinsics.areEqual(this.coverInfo, r4.coverInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.priceInfo, r4.priceInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.salesInfo, r4.salesInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recReasonInfo, r4.recReasonInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.titleTagInfo, r4.titleTagInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.liveInfo, r4.liveInfo) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        a0 r0 = this.coverInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        p1 r4 = this.priceInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        u1 r7 = this.salesInfo;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        r1 r10 = this.recReasonInfo;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        d2 r13 = this.titleTagInfo;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        r r16 = this.liveInfo;
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
        return "DeepFeedSlcCommonData(coverInfo=" + this.coverInfo + ", priceInfo=" + this.priceInfo + ", salesInfo=" + this.salesInfo + ", recReasonInfo=" + this.recReasonInfo + ", titleTagInfo=" + this.titleTagInfo + ", liveInfo=" + this.liveInfo + ")";
    }

    public y() {
        this.coverInfo = null;
        this.priceInfo = null;
        this.salesInfo = null;
        this.recReasonInfo = null;
        this.titleTagInfo = null;
        this.liveInfo = null;
    }

    public final a0 a() {
        return this.coverInfo;
    }

    public final r b() {
        return this.liveInfo;
    }

    public final p1 c() {
        return this.priceInfo;
    }

    public final r1 d() {
        return this.recReasonInfo;
    }

    public final u1 e() {
        return this.salesInfo;
    }

    public final d2 f() {
        return this.titleTagInfo;
    }
}
