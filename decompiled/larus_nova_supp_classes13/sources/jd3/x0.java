package jd3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Ljd3/x0;", "", "", "viewMicroTime", "J", "getViewMicroTime", "()J", "Ljd3/a1;", "viewBaseInfo", "Ljd3/a1;", "getViewBaseInfo", "()Ljd3/a1;", "a", "(Ljd3/a1;)V", "Ljd3/b1;", "viewExtraInfo", "Ljd3/b1;", "getViewExtraInfo", "()Ljd3/b1;", "b", "(Ljd3/b1;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x0 {

    @SerializedName("base_Info")
    private a1 viewBaseInfo;

    @SerializedName("extra_info")
    private b1 viewExtraInfo;

    @SerializedName("view_micro_time")
    private final long viewMicroTime;

    public static final class a {
    }

    static {
    }

    public x0() {
        this.viewMicroTime = System.currentTimeMillis() * ((long) 1000);
    }

    public final void a(a1 r1) {
        this.viewBaseInfo = r1;
    }

    public final void b(b1 r1) {
        this.viewExtraInfo = r1;
    }
}
