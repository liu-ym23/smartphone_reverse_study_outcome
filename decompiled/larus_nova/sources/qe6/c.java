package qe6;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/lark/policy/model/trace/TracePolicyResultData;", "", "pointKey", "", "effect", SlcCommonAction.KEY_ACTIONS, "resultType", "enableLocalValidate", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getPointKey", "()Ljava/lang/String;", "getEffect", "getActions", "getResultType", "getEnableLocalValidate", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final String actions;

    @SerializedName("effect")
    private final String effect;

    @SerializedName("enableLocalValidate")
    private final boolean enableLocalValidate;

    @SerializedName("pointKey")
    private final String pointKey;

    @SerializedName("result_type")
    private final String resultType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.pointKey, r101.pointKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.effect, r101.effect) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resultType, r101.resultType) == true) goto L21;
        return false;
    L21:
        if (this.enableLocalValidate == r101.enableLocalValidate) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.pointKey.hashCode() * 31) + this.effect.hashCode()) * 31) + this.actions.hashCode()) * 31) + this.resultType.hashCode()) * 31;
        if (this.enableLocalValidate == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "TracePolicyResultData(pointKey=" + this.pointKey + ", effect=" + this.effect + ", actions=" + this.actions + ", resultType=" + this.resultType + ", enableLocalValidate=" + this.enableLocalValidate + ')';
    }

    public c(String r100, String r101, String r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "pointKey");
        Intrinsics.checkNotNullParameter(r101, "effect");
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r103, "resultType");
        this.pointKey = r100;
        this.effect = r101;
        this.actions = r102;
        this.resultType = r103;
        this.enableLocalValidate = r104;
    }
}
