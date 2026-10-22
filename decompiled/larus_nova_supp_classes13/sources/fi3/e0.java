package fi3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lfi3/e0;", "", "", "msg", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "isLong", "Z", "c", "()Z", "extractPath", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("extract_path")
    private final String extractPath;

    @SerializedName("is_long")
    private final boolean isLong;

    @SerializedName("message")
    private final String msg;

    public static final class a {
    }

    static {
    }

    public e0() {
        this(null, false, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e0) == false) goto L12;
        e0 r4 = (e0) r3;
        if (Intrinsics.areEqual(this.msg, r4.msg) == true) goto L8;
        return false;
    L8:
        if (this.isLong == r4.isLong) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extractPath, r4.extractPath) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        String r0 = this.msg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.isLong;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r3 + r5) * 31;
        String r7 = this.extractPath;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        return r6 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPToastParams(msg=" + this.msg + ", isLong=" + this.isLong + ", extractPath=" + this.extractPath + ")";
    }

    public final String a() {
        return this.extractPath;
    }

    public final String b() {
        return this.msg;
    }

    public final boolean c() {
        return this.isLong;
    }

    public e0(String r1, boolean r2, String r3) {
        this.msg = r1;
        this.isLong = r2;
        this.extractPath = r3;
    }
}
