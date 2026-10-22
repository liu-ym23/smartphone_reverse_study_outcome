package sl;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lsl/g;", "", "", ReportConstant.COMMON_ACTION_TYPE, "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "Lsl/k;", "dialog", "Lsl/k;", "c", "()Lsl/k;", "Lsl/a;", "bizAction", "Lsl/a;", "b", "()Lsl/a;", "Lsl/m;", "jumpAction", "Lsl/m;", "d", "()Lsl/m;", "Lsl/r;", "skuAction", "Lsl/r;", "f", "()Lsl/r;", "Lsl/o;", "orderAction", "Lsl/o;", "e", "()Lsl/o;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("action_type")
    private final int actionType;

    @SerializedName("biz_action")
    private final a bizAction;

    @SerializedName("dialog")
    private final k dialog;

    @SerializedName("jump_action")
    private final m jumpAction;

    @SerializedName("order_action")
    private final o orderAction;

    @SerializedName("sku_action")
    private final r skuAction;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L18;
        g r101 = (g) r100;
        if (this.actionType == r101.actionType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dialog, r101.dialog) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bizAction, r101.bizAction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpAction, r101.jumpAction) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.skuAction, r101.skuAction) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.orderAction, r101.orderAction) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r100 = this.actionType * 31;
        k r101 = this.dialog;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        a r105 = this.bizAction;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        m r108 = this.jumpAction;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        r r111 = this.skuAction;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        o r114 = this.orderAction;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ECCheckAction(actionType=" + this.actionType + ", dialog=" + this.dialog + ", bizAction=" + this.bizAction + ", jumpAction=" + this.jumpAction + ", skuAction=" + this.skuAction + ", orderAction=" + this.orderAction + ")";
    }

    public g() {
        this.actionType = 0;
        this.dialog = null;
        this.bizAction = null;
        this.jumpAction = null;
        this.skuAction = null;
        this.orderAction = null;
    }

    public final int a() {
        return this.actionType;
    }

    public final a b() {
        return this.bizAction;
    }

    public final k c() {
        return this.dialog;
    }

    public final m d() {
        return this.jumpAction;
    }

    public final o e() {
        return this.orderAction;
    }

    public final r f() {
        return this.skuAction;
    }
}
