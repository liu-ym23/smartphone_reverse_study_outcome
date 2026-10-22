package yw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lyw6/s;", "", "Lyw6/r;", "start_state", "Lyw6/r;", "d", "()Lyw6/r;", "end_state", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "headerIconSwitchColorDistance", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "headerBackgroundShowDistance", "b", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("end_state")
    private final r end_state;

    @SerializedName("elevator_state")
    private final Integer headerBackgroundShowDistance;

    @SerializedName("start_show_elevator_offset")
    private final Integer headerIconSwitchColorDistance;

    @SerializedName("start_state")
    private final r start_state;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.start_state, r101.start_state) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.end_state, r101.end_state) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.headerIconSwitchColorDistance, r101.headerIconSwitchColorDistance) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.headerBackgroundShowDistance, r101.headerBackgroundShowDistance) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        r r100 = this.start_state;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        r r104 = this.end_state;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.headerIconSwitchColorDistance;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.headerBackgroundShowDistance;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "GoodsHeaderViewInfoEntity(start_state=" + this.start_state + ", end_state=" + this.end_state + ", headerIconSwitchColorDistance=" + this.headerIconSwitchColorDistance + ", headerBackgroundShowDistance=" + this.headerBackgroundShowDistance + ')';
    }

    public s() {
        this.start_state = null;
        this.end_state = null;
        this.headerIconSwitchColorDistance = null;
        this.headerBackgroundShowDistance = null;
    }

    public final r a() {
        return this.end_state;
    }

    public final Integer b() {
        return this.headerBackgroundShowDistance;
    }

    public final Integer c() {
        return this.headerIconSwitchColorDistance;
    }

    public final r d() {
        return this.start_state;
    }
}
