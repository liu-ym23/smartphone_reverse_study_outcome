package yh;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lyh/a;", "", "", "enableEcomTabSort", "I", "e", "()I", "", "a1", FaceService.girlLabel, "getA1", "()F", "a2", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "clickScore", "c", "consecutiveClickScore", "d", "addToCartScore", "b", "seqLength", "f", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    @SerializedName("a1")
    private final float f567527a1;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    @SerializedName("a2")
    private final float f567528a2;

    @SerializedName("add_to_cart_score")
    private final float addToCartScore;

    @SerializedName("click_score")
    private final float clickScore;

    @SerializedName("consecutive_click_score")
    private final float consecutiveClickScore;

    @SerializedName("enable_ecom_tab_sort3")
    private final int enableEcomTabSort;

    @SerializedName("seq_length")
    private final int seqLength;

    public a() {
        this.f567527a1 = 0.5f;
        this.f567528a2 = 1.0f;
        this.clickScore = 0.25f;
        this.consecutiveClickScore = 0.375f;
        this.addToCartScore = 1.0f;
        this.seqLength = 10;
    }

    public final float a() {
        return this.f567528a2;
    }

    public final float b() {
        return this.addToCartScore;
    }

    public final float c() {
        return this.clickScore;
    }

    public final float d() {
        return this.consecutiveClickScore;
    }

    public final int e() {
        return this.enableEcomTabSort;
    }

    public final int f() {
        return this.seqLength;
    }
}
