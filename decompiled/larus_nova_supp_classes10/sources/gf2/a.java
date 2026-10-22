package gf2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lgf2/a;", "", "", "itemId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "d", "(Ljava/lang/Long;)V", "itemType", "getItemType", "", "coverUrl", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "likeCount", "c", "title", "getTitle", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {
    public boolean a;

    @SerializedName("url")
    private final String coverUrl;

    @SerializedName("item_id")
    private Long itemId;

    @SerializedName("item_type")
    private final Long itemType;

    @SerializedName("count")
    private final Long likeCount;

    @SerializedName("title")
    private final String title;

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.itemId, r4.itemId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.itemType, r4.itemType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.coverUrl, r4.coverUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.likeCount, r4.likeCount) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L16;
        return false;
    L16:
        if (this.a == r4.a) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Long r0 = this.itemId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.itemType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.coverUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.likeCount;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.title;
        if (r13 == null) goto L21;
        r1 = r13.hashCode();
    L21:
        int r14 = (r12 + r1) * 31;
        boolean r15 = this.a;
        ?? r16 = r15;
        if (r15 == false) goto L25;
        r16 = 1;
    L25:
        return r14 + r16;
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
        return "LinkVideo(itemId=" + this.itemId + ", itemType=" + this.itemType + ", coverUrl=" + this.coverUrl + ", likeCount=" + this.likeCount + ", title=" + this.title + ", isGray=" + this.a + ")";
    }

    public final String a() {
        return this.coverUrl;
    }

    public final Long b() {
        return this.itemId;
    }

    public final Long c() {
        return this.likeCount;
    }

    public a(int r1) {
        this.itemId = null;
        this.itemType = null;
        this.coverUrl = null;
        this.likeCount = null;
        this.title = null;
        this.a = false;
    }

    public final void d(Long r1) {
        this.itemId = r1;
    }
}
