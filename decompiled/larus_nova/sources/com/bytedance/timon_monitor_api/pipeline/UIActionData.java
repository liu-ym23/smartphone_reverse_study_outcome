package com.bytedance.timon_monitor_api.pipeline;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001%B/\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u0017\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006HÆ\u0003J5\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/bytedance/timon_monitor_api/pipeline/UIActionData;", "Ljava/io/Serializable;", "", "component1", "", "component2", "", "component3", "action_type", "ts", "extra_info", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getAction_type", "()Ljava/lang/String;", "setAction_type", "(Ljava/lang/String;)V", "J", "getTs", "()J", "setTs", "(J)V", "Ljava/util/Map;", "getExtra_info", "()Ljava/util/Map;", "setExtra_info", "(Ljava/util/Map;)V", "<init>", "(Ljava/lang/String;JLjava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "timon-monitor-api_release"}, k = 1, mv = {1, 4, 0})
public final class UIActionData implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 0;

    @SerializedName("action_type")
    private String action_type;

    @SerializedName("extra_info")
    private Map<String, String> extra_info;

    /* JADX INFO: renamed from: ts, reason: collision with root package name */
    @SerializedName("ts")
    private long f270717ts;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UIActionData copy$default(UIActionData r100, String r101, long r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.action_type;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f270717ts;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.extra_info;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.action_type;
    }

    public final long component2() {
        return this.f270717ts;
    }

    public final Map<String, String> component3() {
        return this.extra_info;
    }

    public final UIActionData copy(String r100, long r101, Map<String, String> r102) {
        return new UIActionData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof UIActionData) == false) goto L12;
        UIActionData r101 = (UIActionData) r100;
        if (Intrinsics.areEqual(this.action_type, r101.action_type) == true) goto L8;
        return false;
    L8:
        if (this.f270717ts == r101.f270717ts) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra_info, r101.extra_info) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.action_type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f270717ts;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        Map<String, String> r105 = this.extra_info;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "UIActionData(action_type=" + this.action_type + ", ts=" + this.f270717ts + ", extra_info=" + this.extra_info + ")";
    }

    public final String getAction_type() {
        return this.action_type;
    }

    public final Map<String, String> getExtra_info() {
        return this.extra_info;
    }

    public final long getTs() {
        return this.f270717ts;
    }

    public final void setAction_type(String r100) {
        this.action_type = r100;
    }

    public final void setExtra_info(Map<String, String> r100) {
        this.extra_info = r100;
    }

    public final void setTs(long r100) {
        this.f270717ts = r100;
    }

    public UIActionData(String r100, long r101, Map<String, String> r102) {
        this.action_type = r100;
        this.f270717ts = r101;
        this.extra_info = r102;
    }

    public /* synthetic */ UIActionData(String r100, long r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = 0;
    L5:
        this(r100, r101, r102);
    }
}
