package hi3;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lhi3/a;", "", "", "url", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "btmId", "a", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "callback", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "b", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {
    public static final /* synthetic */ int a = 0;

    @SerializedName("btm_id")
    private final String btmId;

    @SerializedName("callback")
    private final IAction callback;

    @SerializedName("url")
    private final String url;

    /* JADX INFO: renamed from: hi3.a$a, reason: collision with other inner class name */
    public static final class C0205a {
    }

    static {
    }

    public a() {
        this(null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.btmId, r4.btmId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.callback, r4.callback) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.btmId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        IAction r7 = this.callback;
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
        return "OpenPayParams(url=" + this.url + ", btmId=" + this.btmId + ", callback=" + this.callback + ")";
    }

    public final String a() {
        return this.btmId;
    }

    public final IAction b() {
        return this.callback;
    }

    public final String c() {
        return this.url;
    }

    public a(String r1, String r2, IAction r3) {
        this.url = r1;
        this.btmId = r2;
        this.callback = r3;
    }
}
