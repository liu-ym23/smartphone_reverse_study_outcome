package tf0;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ltf0/s;", "", "", "x", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "y", "b", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class s {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private final float f545696x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private final float f545697y;

    public final String toString() {
        return "Point(x=" + this.f545696x + ", y=" + this.f545697y + ')';
    }

    public final float a() {
        return this.f545696x;
    }

    public final float b() {
        return this.f545697y;
    }

    public s(float r100, float r101) {
        this.f545696x = r100;
        this.f545697y = r101;
    }
}
