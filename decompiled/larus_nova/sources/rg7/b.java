package rg7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lrg7/b;", "", "", "unitDisable", "I", "b", "()I", "backgroundDuration", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "clipboard-suite_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, c> f537717a;

    @SerializedName("enter_background_duration_threshold")
    private final int backgroundDuration;

    @SerializedName("unit_disable")
    private final int unitDisable;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.unitDisable == r101.unitDisable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f537717a, r101.f537717a) == true) goto L10;
        return false;
    L10:
        if (this.backgroundDuration == r101.backgroundDuration) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.unitDisable * 31;
        Map<String, c> r101 = this.f537717a;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.backgroundDuration;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ClipboardCertConfig(unitDisable=" + this.unitDisable + ", tokenConfig=" + this.f537717a + ", backgroundDuration=" + this.backgroundDuration + ")";
    }

    public final int a() {
        return this.backgroundDuration;
    }

    public final int b() {
        return this.unitDisable;
    }

    public /* synthetic */ b(int r100) {
        this(0, MapsKt.emptyMap(), 30000);
    }

    public b(int r100, Map<String, c> r101, int r102) {
        this.unitDisable = r100;
        this.f537717a = r101;
        this.backgroundDuration = r102;
    }
}
