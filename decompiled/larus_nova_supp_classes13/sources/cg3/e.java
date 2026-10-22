package cg3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcg3/e;", "", "", "shareTitle", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "shareContent", "b", "", "rankType", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("rank_type")
    private final Integer rankType;

    @SerializedName("share_content")
    private final String shareContent;

    @SerializedName("share_title")
    private final String shareTitle;

    public e() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L12;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.shareTitle, r4.shareTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shareContent, r4.shareContent) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rankType, r4.rankType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.shareTitle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.shareContent;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.rankType;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentShareInfoStruct(shareTitle=" + this.shareTitle + ", shareContent=" + this.shareContent + ", rankType=" + this.rankType + ")";
    }

    public final Integer a() {
        return this.rankType;
    }

    public final String b() {
        return this.shareContent;
    }

    public final String c() {
        return this.shareTitle;
    }

    public e(int r1) {
        this.shareTitle = null;
        this.shareContent = null;
        this.rankType = null;
    }
}
