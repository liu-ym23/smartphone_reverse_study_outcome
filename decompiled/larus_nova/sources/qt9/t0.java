package qt9;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.vivo.push.PushClientConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\u001f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fHÆ\u0003Jg\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fHÆ\u0001J\u0013\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R(\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/larus/settings/provider/DynamicTraceConfig;", "", "action", "", PushClientConstants.TAG_CLASS_NAME, "", "isConstructor", "", "methodName", "methodSign", "traceThreadMode", ControlRule.KEY_EXTRA_DATA, "", "<init>", "(ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "getAction", "()I", "getClassName", "()Ljava/lang/String;", "()Z", "getMethodName", "getMethodSign", "getTraceThreadMode", "getExtraData", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t0 {

    @SerializedName("action")
    private final int action;

    @SerializedName(PushClientConstants.TAG_CLASS_NAME)
    private final String className;

    @SerializedName(ControlRule.KEY_EXTRA_DATA)
    private final Map<String, Object> extraData;

    @SerializedName("isConstructor")
    private final boolean isConstructor;

    @SerializedName("methodName")
    private final String methodName;

    @SerializedName("methodSign")
    private final String methodSign;

    @SerializedName("traceThreadMode")
    private final int traceThreadMode;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (this.action == r101.action) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.className, r101.className) == true) goto L15;
        return false;
    L15:
        if (this.isConstructor == r101.isConstructor) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.methodName, r101.methodName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.methodSign, r101.methodSign) == true) goto L24;
        return false;
    L24:
        if (this.traceThreadMode == r101.traceThreadMode) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extraData, r101.extraData) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.action * 31;
        String r101 = this.className;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.isConstructor == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        String r107 = this.methodName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.methodSign;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.traceThreadMode) * 31;
        Map<String, Object> r113 = this.extraData;
        if (r113 == null) goto L23;
        r102 = r113.hashCode();
    L23:
        return r112 + r102;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DynamicTraceConfig(action=" + this.action + ", className=" + this.className + ", isConstructor=" + this.isConstructor + ", methodName=" + this.methodName + ", methodSign=" + this.methodSign + ", traceThreadMode=" + this.traceThreadMode + ", extraData=" + this.extraData + ')';
    }

    public t0() {
        Map<String, Object> r100 = MapsKt.emptyMap();
        this.action = 0;
        this.className = "";
        this.isConstructor = false;
        this.methodName = "";
        this.methodSign = "";
        this.traceThreadMode = 4;
        this.extraData = r100;
    }

    public final int a() {
        return this.action;
    }

    public final String b() {
        return this.className;
    }

    public final Map<String, Object> c() {
        return this.extraData;
    }

    public final String d() {
        return this.methodName;
    }

    public final String e() {
        return this.methodSign;
    }

    public final int f() {
        return this.traceThreadMode;
    }

    public final boolean g() {
        return this.isConstructor;
    }
}
