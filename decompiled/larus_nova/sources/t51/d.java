package t51;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lt51/d;", "", "", "hOffset", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "c", "(F)V", "vOffset", "b", "d", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d {

    @SerializedName("h_offset")
    private float hOffset;

    @SerializedName("v_offset")
    private float vOffset;

    public d() {
    }

    public final void c() {
        this.hOffset = 0.0f;
    }

    public final void d() {
        this.vOffset = 0.19f;
    }

    public final float a() {
        return this.hOffset;
    }

    public final float b() {
        return this.vOffset;
    }
}
