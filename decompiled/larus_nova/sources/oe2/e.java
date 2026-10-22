package oe2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Loe2/e;", "", "", "state", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "stateTs", "J", "c", "()J", "statePos", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522952a = 0;

    @SerializedName("state")
    private final String state;

    @SerializedName("statePos")
    private final long statePos;

    @SerializedName("stateTs")
    private final long stateTs;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.state, r101.state) == true) goto L8;
        return false;
    L8:
        if (this.stateTs == r101.stateTs) goto L10;
        return false;
    L10:
        if (this.statePos == r101.statePos) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.state;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.stateTs;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.statePos;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvRoomState(state=" + this.state + ", stateTs=" + this.stateTs + ", statePos=" + this.statePos + ")";
    }

    public final String a() {
        return this.state;
    }

    public final long b() {
        return this.statePos;
    }

    public final long c() {
        return this.stateTs;
    }

    public /* synthetic */ e(String r100, long r101) {
        this(r100, r101, 0);
    }

    public e(String r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.state = r100;
        this.stateTs = r101;
        this.statePos = r102;
    }
}
