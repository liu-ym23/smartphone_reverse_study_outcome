package oe2;

import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Loe2/e;", "", "", BaseCoreViewModel.CORE_TAG_STATE, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "stateTs", "J", "c", "()J", "statePos", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e {
    public static final /* synthetic */ int a = 0;

    @SerializedName(BaseCoreViewModel.CORE_TAG_STATE)
    private final String state;

    @SerializedName("statePos")
    private final long statePos;

    @SerializedName("stateTs")
    private final long stateTs;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L12;
        e r7 = (e) r6;
        if (Intrinsics.areEqual(this.state, r7.state) == true) goto L8;
        return false;
    L8:
        if (this.stateTs == r7.stateTs) goto L10;
        return false;
    L10:
        if (this.statePos == r7.statePos) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.state;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.stateTs;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        long r4 = this.statePos;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r1 = 0;
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

    public /* synthetic */ e(String r7, long r8) {
        this(r7, r8, 0);
    }

    public e(String r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
        this.state = r2;
        this.stateTs = r3;
        this.statePos = r5;
    }
}
