package r14;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lr14/d0;", "", "", "xMin", "D", "b", "()D", "setXMin", "(D)V", "yMin", "d", "setYMin", "xMax", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setXMax", "yMax", "c", "setYMax", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class d0 {

    @SerializedName("x_max")
    private double xMax;

    @SerializedName("x_min")
    private double xMin;

    @SerializedName("y_max")
    private double yMax;

    @SerializedName("y_min")
    private double yMin;

    public d0() {
    }

    public final double a() {
        return this.xMax;
    }

    public final double b() {
        return this.xMin;
    }

    public final double c() {
        return this.yMax;
    }

    public final double d() {
        return this.yMin;
    }
}
