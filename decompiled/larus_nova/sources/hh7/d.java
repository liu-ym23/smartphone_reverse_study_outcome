package hh7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lhh7/d;", "", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "", "code", "I", "getCode", "()I", "", "strategies", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lhh7/e;", "hit_rules", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setHit_rules", "(Ljava/util/List;)V", "timon-monitor-impl_release"}, k = 1, mv = {1, 4, 0})
public final class d {

    @SerializedName("code")
    private final int code;

    @SerializedName("hit_rules")
    private List<e> hit_rules;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("strategies")
    private final List<String> strategies;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L8;
        return false;
    L8:
        if (this.code == r101.code) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strategies, r101.strategies) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hit_rules, r101.hit_rules) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.scene;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.code) * 31;
        List<String> r104 = this.strategies;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<e> r107 = this.hit_rules;
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
        return "EngineOutputData(scene=" + this.scene + ", code=" + this.code + ", strategies=" + this.strategies + ", hit_rules=" + this.hit_rules + ")";
    }

    public final List<e> a() {
        return this.hit_rules;
    }

    public final List<String> b() {
        return this.strategies;
    }

    public d(String r100, List r101, List r102) {
        this.scene = r100;
        this.code = 0;
        this.strategies = r101;
        this.hit_rules = r102;
    }
}
