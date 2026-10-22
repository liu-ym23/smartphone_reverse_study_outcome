package hi3;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lhi3/a;", "", "", "url", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "btmId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "callback", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "b", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f485267a = 0;

    @SerializedName("btm_id")
    private final String btmId;

    @SerializedName("callback")
    private final IAction callback;

    @SerializedName("url")
    private final String url;

    /* JADX INFO: renamed from: hi3.a$a, reason: collision with other inner class name */
    public static final class C6148a {
    }

    static {
    }

    public a() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.btmId, r101.btmId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.btmId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        IAction r107 = this.callback;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
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

    public a(String r100, String r101, IAction r102) {
        this.url = r100;
        this.btmId = r101;
        this.callback = r102;
    }
}
