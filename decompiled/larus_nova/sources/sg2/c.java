package sg2;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006\""}, d2 = {"Lsg2/c;", "", "", "type", "I", "getType", "()I", ce.f26396k, "(I)V", "clickType", "b", ce.f26391f, "", "productId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "(Ljava/lang/String;)V", "", "clickTimes", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "f", "(J)V", "showTimes", "e", ce.f26395j, "lastClickTimestamps", "c", "h", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("click_times")
    private long clickTimes;

    @SerializedName("click_type")
    private int clickType;

    @SerializedName("last_click_timestamp")
    private long lastClickTimestamps;

    @SerializedName("productId")
    private String productId;

    @SerializedName("show_times")
    private long showTimes;

    @SerializedName("type")
    private int type;

    public static final class a {
    }

    static {
    }

    public final void g() {
        this.clickType = 0;
    }

    public c() {
        this.type = -1;
        this.clickType = -1;
        this.productId = "";
    }

    public final long a() {
        return this.clickTimes;
    }

    public final int b() {
        return this.clickType;
    }

    public final long c() {
        return this.lastClickTimestamps;
    }

    public final String d() {
        return this.productId;
    }

    public final long e() {
        return this.showTimes;
    }

    public final int getType() {
        return this.type;
    }

    public final void f(long r100) {
        this.clickTimes = r100;
    }

    public final void h(long r100) {
        this.lastClickTimestamps = r100;
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.productId = r100;
    }

    public final void j(long r100) {
        this.showTimes = r100;
    }

    public final void k(int r100) {
        this.type = r100;
    }
}
