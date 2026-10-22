package yv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lyv6/e;", "", "Lyv6/c;", "deliver", "Lyv6/c;", "b", "()Lyv6/c;", "trip", "e", "general", "d", "food", "c", "default", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    /* JADX INFO: renamed from: default, reason: not valid java name */
    @SerializedName("default")
    private final c f1171default;

    @SerializedName("deliver")
    private final c deliver;

    @SerializedName("food")
    private final c food;

    @SerializedName("general")
    private final c general;

    @SerializedName("trip")
    private final c trip;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.deliver, r101.deliver) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.trip, r101.trip) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.general, r101.general) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.food, r101.food) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f1171default, r101.f1171default) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        c r100 = this.deliver;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c r104 = this.trip;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        c r107 = this.general;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.food;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        c r113 = this.f1171default;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "WholeProcessOptStrategy(deliver=" + this.deliver + ", trip=" + this.trip + ", general=" + this.general + ", food=" + this.food + ", default=" + this.f1171default + ')';
    }

    public e() {
        this.deliver = null;
        this.trip = null;
        this.general = null;
        this.food = null;
        this.f1171default = null;
    }

    public final c a() {
        return this.f1171default;
    }

    public final c b() {
        return this.deliver;
    }

    public final c c() {
        return this.food;
    }

    public final c d() {
        return this.general;
    }

    public final c e() {
        return this.trip;
    }
}
