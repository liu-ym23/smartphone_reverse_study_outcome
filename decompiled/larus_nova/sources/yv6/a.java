package yv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lyv6/a;", "", "", "enableJato", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "enableBlockGC", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "enableCloseClassVerify", "b", "duration", "getDuration", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("duration")
    private final Boolean duration;

    @SerializedName("enableBlockGC")
    private final Boolean enableBlockGC;

    @SerializedName("enableCloseClassVerify")
    private final Boolean enableCloseClassVerify;

    @SerializedName("enableJato")
    private final Boolean enableJato;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.enableJato, r101.enableJato) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableBlockGC, r101.enableBlockGC) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableCloseClassVerify, r101.enableCloseClassVerify) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enableJato;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.enableBlockGC;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.enableCloseClassVerify;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.duration;
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
        return "JatoConfig(enableJato=" + this.enableJato + ", enableBlockGC=" + this.enableBlockGC + ", enableCloseClassVerify=" + this.enableCloseClassVerify + ", duration=" + this.duration + ')';
    }

    public a() {
        this.enableJato = null;
        this.enableBlockGC = null;
        this.enableCloseClassVerify = null;
        this.duration = null;
    }

    public final Boolean a() {
        return this.enableBlockGC;
    }

    public final Boolean b() {
        return this.enableCloseClassVerify;
    }

    public final Boolean c() {
        return this.enableJato;
    }
}
