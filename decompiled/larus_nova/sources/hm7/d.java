package hm7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lhm7/d;", "", "", "token", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lhm7/a;", "component", "Lhm7/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lhm7/a;", "luckydog-task_release"}, k = 1, mv = {1, 4, 0})
public final class d {

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    @SerializedName("timer_component")
    private final a f485949component;

    @SerializedName("token")
    private final String token;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f485949component, r101.f485949component) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.token;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.f485949component;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TimerPendantModel(token=" + this.token + ", component=" + this.f485949component + ")";
    }

    public final a a() {
        return this.f485949component;
    }

    public final String b() {
        return this.token;
    }
}
