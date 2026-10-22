package pe6;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003JH\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/lark/policy/model/network/NetPolicyDecision;", "", "effect", "", SlcCommonAction.KEY_ACTIONS, "", "errorCode", "", "appliedPolicySetResults", "Lcom/bytedance/lark/policy/model/network/AppliedPolicySetResult;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;)V", "getEffect", "()Ljava/lang/String;", "getActions", "()Ljava/util/List;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAppliedPolicySetResults", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/lark/policy/model/network/NetPolicyDecision;", "equals", "", "other", "hashCode", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<String> actions;

    @SerializedName("appliedPolicySetResults")
    private final List<a> appliedPolicySetResults;

    @SerializedName("effect")
    private final String effect;

    @SerializedName("errorCode")
    private final Integer errorCode;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.effect, r101.effect) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorCode, r101.errorCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appliedPolicySetResults, r101.appliedPolicySetResults) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.effect.hashCode() * 31;
        List<String> r101 = this.actions;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.errorCode;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<a> r108 = this.appliedPolicySetResults;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "NetPolicyDecision(effect=" + this.effect + ", actions=" + this.actions + ", errorCode=" + this.errorCode + ", appliedPolicySetResults=" + this.appliedPolicySetResults + ')';
    }

    public final List<String> a() {
        return this.actions;
    }

    public final List<a> b() {
        return this.appliedPolicySetResults;
    }

    public final String c() {
        return this.effect;
    }

    public final Integer d() {
        return this.errorCode;
    }
}
