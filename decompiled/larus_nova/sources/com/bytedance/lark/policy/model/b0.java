package com.bytedance.lark.policy.model;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J_\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006'"}, d2 = {"Lcom/bytedance/lark/policy/model/ValidateResponse;", "", "effect", "", ST.UUID_DEVICE, SlcCommonAction.KEY_ACTIONS, "", "Lcom/bytedance/lark/policy/model/Action;", "isAllow", "", "type", "Lcom/bytedance/lark/policy/model/ResponseType;", "errorMsg", "policySetKeys", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLcom/bytedance/lark/policy/model/ResponseType;Ljava/lang/String;Ljava/util/List;)V", "getEffect", "()Ljava/lang/String;", "getUuid", "getActions", "()Ljava/util/List;", "()Z", "getType", "()Lcom/bytedance/lark/policy/model/ResponseType;", "getErrorMsg", "getPolicySetKeys", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b0 {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<a> actions;

    @SerializedName("effect")
    private final String effect;

    @SerializedName("errorMsg")
    private final String errorMsg;

    @SerializedName("isAllow")
    private final boolean isAllow;

    @SerializedName("policySetKeys")
    private final List<String> policySetKeys;

    @SerializedName("type")
    private final ResponseType type;

    @SerializedName(ST.UUID_DEVICE)
    private final String uuid;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.effect, r101.effect) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uuid, r101.uuid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L18;
        return false;
    L18:
        if (this.isAllow == r101.isAllow) goto L21;
        return false;
    L21:
        if (this.type == r101.type) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.policySetKeys, r101.policySetKeys) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.effect.hashCode() * 31) + this.uuid.hashCode()) * 31;
        List<a> r101 = this.actions;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.isAllow == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((r104 + r105) * 31) + this.type.hashCode()) * 31;
        String r107 = this.errorMsg;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return ((r106 + r102) * 31) + this.policySetKeys.hashCode();
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ValidateResponse(effect=" + this.effect + ", uuid=" + this.uuid + ", actions=" + this.actions + ", isAllow=" + this.isAllow + ", type=" + this.type + ", errorMsg=" + this.errorMsg + ", policySetKeys=" + this.policySetKeys + ')';
    }

    public final List<a> a() {
        return this.actions;
    }

    public final String b() {
        return this.effect;
    }

    public final String c() {
        return this.errorMsg;
    }

    public final List<String> d() {
        return this.policySetKeys;
    }

    public final String e() {
        return this.uuid;
    }

    public final boolean f() {
        return this.isAllow;
    }

    public final ResponseType getType() {
        return this.type;
    }

    public b0(String r100, String r101, List<a> r102, boolean r103, ResponseType r104, String r105, List<String> r106) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        Intrinsics.checkNotNullParameter(r101, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r104, "type");
        Intrinsics.checkNotNullParameter(r106, "policySetKeys");
        this.effect = r100;
        this.uuid = r101;
        this.actions = r102;
        this.isAllow = r103;
        this.type = r104;
        this.errorMsg = r105;
        this.policySetKeys = r106;
    }

    public /* synthetic */ b0(String r110, String r111, List r112, boolean r113, ResponseType r114, String r115, List r116, int r117) {
        if ((r117 & 4) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r117 & 8) == 0) goto L9;
        boolean r101 = Intrinsics.areEqual(r110, "PERMIT");
    L11:
        if ((r117 & 16) == 0) goto L13;
        ResponseType r102 = ResponseType.REMOTE;
    L15:
        if ((r117 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r117 & 64) == 0) goto L21;
        List r104 = CollectionsKt.emptyList();
    L22:
        this(r110, r111, r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
