package sj3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lsj3/i;", "", "", "Lsj3/l;", "pos", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "content", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Lsj3/o;", "wordRecord", "Lsj3/o;", "d", "()Lsj3/o;", "Lsj3/k;", "extraInfo", "Lsj3/k;", "b", "()Lsj3/k;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("content")
    private final String content;

    @SerializedName("extra_info")
    private final k extraInfo;

    @SerializedName("pos")
    private final List<l> pos;

    @SerializedName("word_record")
    private final o wordRecord;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L14;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.pos, r4.pos) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.wordRecord, r4.wordRecord) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraInfo, r4.extraInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<l> r0 = this.pos;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        o r7 = this.wordRecord;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        k r10 = this.extraInfo;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "StoreSearchSugItemDTO(pos=" + this.pos + ", content=" + this.content + ", wordRecord=" + this.wordRecord + ", extraInfo=" + this.extraInfo + ")";
    }

    public i() {
        this.pos = null;
        this.content = null;
        this.wordRecord = null;
        this.extraInfo = null;
    }

    public final String a() {
        return this.content;
    }

    public final k b() {
        return this.extraInfo;
    }

    public final List<l> c() {
        return this.pos;
    }

    public final o d() {
        return this.wordRecord;
    }
}
