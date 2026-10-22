package hh7;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lhh7/c;", "", "", "", "input", "Ljava/util/Map;", "getInput", "()Ljava/util/Map;", "used_state_params", "getUsed_state_params", "Lhh7/d;", BdpAppEventConstant.PARAMS_OUTPUT, "Lhh7/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lhh7/d;", "b", "(Lhh7/d;)V", "timon-monitor-impl_release"}, k = 1, mv = {1, 4, 0})
public final class c {

    @SerializedName("input")
    private final Map<String, Object> input;

    @SerializedName(BdpAppEventConstant.PARAMS_OUTPUT)
    private d output;

    @SerializedName("used_state_params")
    private final Map<String, Object> used_state_params;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.input, r101.input) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.used_state_params, r101.used_state_params) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.output, r101.output) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.input;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.used_state_params;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        d r107 = this.output;
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
        return "EngineData(input=" + this.input + ", used_state_params=" + this.used_state_params + ", output=" + this.output + ")";
    }

    public final d a() {
        return this.output;
    }

    public final void b(d r100) {
        this.output = r100;
    }

    public c(Map r100, Map r101) {
        this.input = r100;
        this.used_state_params = r101;
        this.output = null;
    }
}
