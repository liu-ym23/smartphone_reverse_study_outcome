package nb1;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lnb1/m;", "", "", "rgb", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setRgb", "(Ljava/lang/String;)V", "", "alpha", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "setAlpha", "(F)V", "<init>", "()V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m {

    @SerializedName("alpha")
    private float alpha;

    /* JADX INFO: renamed from: rgb, reason: collision with root package name */
    @SerializedName("rgb")
    private String f518498rgb;

    public m() {
        this.f518498rgb = CustomHeaderConfig.COLOR_LIGHT;
        this.alpha = 1.0f;
    }

    public final float a() {
        return this.alpha;
    }

    public final String b() {
        return this.f518498rgb;
    }
}
