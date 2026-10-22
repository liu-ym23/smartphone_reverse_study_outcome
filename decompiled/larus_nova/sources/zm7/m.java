package zm7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001a"}, d2 = {"Lzm7/m;", "", "", "timerTaskKey", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "expire", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "f", "(Z)V", "Lzm7/q;", "timerConfig", "Lzm7/q;", "d", "()Lzm7/q;", "Lzm7/n;", "pendantConfig", "Lzm7/n;", "c", "()Lzm7/n;", "extra", "b", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final class m {

    @SerializedName("expire_state")
    private boolean expire;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("pendant_config")
    private final n pendantConfig;

    @SerializedName("timer_config")
    private final q timerConfig;

    @SerializedName("timer_task_key")
    private final String timerTaskKey;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L21:
        return true;
    L5:
        if ((r100 instanceof m) == false) goto L20;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.timerTaskKey, r101.timerTaskKey) == false) goto L20;
        if (this.expire != r101.expire) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L20;
        if (Intrinsics.areEqual(this.timerConfig, r101.timerConfig) == false) goto L20;
        if (Intrinsics.areEqual(this.pendantConfig, r101.pendantConfig) == false) goto L20;
        if (Intrinsics.areEqual(this.extra, r101.extra) == false) goto L20;
    L11:
        r102 = false;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    public final int hashCode() {
        String r100 = this.timerTaskKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.expire;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        q r107 = this.timerConfig;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        n r110 = this.pendantConfig;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.extra;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LuckyTimerData(timerTaskKey=" + this.timerTaskKey + ", expire=" + this.expire + ", timerConfig=" + this.timerConfig + ", pendantConfig=" + this.pendantConfig + ", extra=" + this.extra + ")";
    }

    public final boolean a() {
        return this.expire;
    }

    public final String b() {
        return this.extra;
    }

    public final n c() {
        return this.pendantConfig;
    }

    public final q d() {
        return this.timerConfig;
    }

    public final String e() {
        return this.timerTaskKey;
    }

    public final void f(boolean r100) {
        this.expire = r100;
    }
}
