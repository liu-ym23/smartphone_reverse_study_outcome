package rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lrc/k;", "", "", "click", "Ljava/lang/String;", "getClick", "()Ljava/lang/String;", "setClick", "(Ljava/lang/String;)V", "exposure", "getExposure", "setExposure", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class k {

    @SerializedName("click")
    private String click;

    @SerializedName("exposure")
    private String exposure;

    public k() {
        this.click = com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT;
        this.exposure = com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT;
    }
}
