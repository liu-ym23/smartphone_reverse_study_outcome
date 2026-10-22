package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007\u0012 \b\u0002\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ!\u0010\u0019\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007HÆ\u0003J!\u0010\u001a\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016Jv\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032 \b\u0002\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u00072 \b\u0002\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR.\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R.\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/obric/assistant/ObricNetworkInterceptConfig;", "", "enabled", "", "obricNetworkHostWhiteList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "obricNetworkPathWhiteList", "obricEnableTTNetMonitorHookEvent", "obricTtnetMonitorHookEventRate", "", "<init>", "(Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/Float;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getObricNetworkHostWhiteList", "()Ljava/util/ArrayList;", "getObricNetworkPathWhiteList", "getObricEnableTTNetMonitorHookEvent", "getObricTtnetMonitorHookEventRate", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/Float;)Lcom/obric/assistant/ObricNetworkInterceptConfig;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricNetworkInterceptConfig {

    @SerializedName("enable")
    private final Boolean enabled;

    @SerializedName("obric_enable_ttnet_monitor_hook_event")
    private final Boolean obricEnableTTNetMonitorHookEvent;

    @SerializedName("obric_network_host_white_list")
    private final ArrayList<String> obricNetworkHostWhiteList;

    @SerializedName("obric_network_path_white_list")
    private final ArrayList<String> obricNetworkPathWhiteList;

    @SerializedName("obric_ttnet_monitor_hook_event_rate")
    private final Float obricTtnetMonitorHookEventRate;

    public ObricNetworkInterceptConfig() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricNetworkInterceptConfig copy$default(ObricNetworkInterceptConfig r100, Boolean r101, ArrayList r102, ArrayList r103, Boolean r104, Float r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enabled;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.obricNetworkHostWhiteList;
    L8:
        ArrayList r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.obricNetworkPathWhiteList;
    L11:
        ArrayList r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.obricEnableTTNetMonitorHookEvent;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.obricTtnetMonitorHookEventRate;
    L17:
        Boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Boolean component1() {
        return this.enabled;
    }

    public final ArrayList<String> component2() {
        return this.obricNetworkHostWhiteList;
    }

    public final ArrayList<String> component3() {
        return this.obricNetworkPathWhiteList;
    }

    public final Boolean component4() {
        return this.obricEnableTTNetMonitorHookEvent;
    }

    public final Float component5() {
        return this.obricTtnetMonitorHookEventRate;
    }

    public final ObricNetworkInterceptConfig copy(Boolean r100, ArrayList<String> r101, ArrayList<String> r110, Boolean r111, Float r112) {
        return new ObricNetworkInterceptConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricNetworkInterceptConfig) == true) goto L8;
        return false;
    L8:
        ObricNetworkInterceptConfig r101 = (ObricNetworkInterceptConfig) r100;
        if (Intrinsics.areEqual(this.enabled, r101.enabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.obricNetworkHostWhiteList, r101.obricNetworkHostWhiteList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.obricNetworkPathWhiteList, r101.obricNetworkPathWhiteList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.obricEnableTTNetMonitorHookEvent, r101.obricEnableTTNetMonitorHookEvent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.obricTtnetMonitorHookEventRate, r101.obricTtnetMonitorHookEventRate) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.enabled;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ArrayList<String> r104 = this.obricNetworkHostWhiteList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<String> r107 = this.obricNetworkPathWhiteList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.obricEnableTTNetMonitorHookEvent;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.obricTtnetMonitorHookEventRate;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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

    public String toString() {
        return "ObricNetworkInterceptConfig(enabled=" + this.enabled + ", obricNetworkHostWhiteList=" + this.obricNetworkHostWhiteList + ", obricNetworkPathWhiteList=" + this.obricNetworkPathWhiteList + ", obricEnableTTNetMonitorHookEvent=" + this.obricEnableTTNetMonitorHookEvent + ", obricTtnetMonitorHookEventRate=" + this.obricTtnetMonitorHookEventRate + ')';
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final Boolean getObricEnableTTNetMonitorHookEvent() {
        return this.obricEnableTTNetMonitorHookEvent;
    }

    public final ArrayList<String> getObricNetworkHostWhiteList() {
        return this.obricNetworkHostWhiteList;
    }

    public final ArrayList<String> getObricNetworkPathWhiteList() {
        return this.obricNetworkPathWhiteList;
    }

    public final Float getObricTtnetMonitorHookEventRate() {
        return this.obricTtnetMonitorHookEventRate;
    }

    public ObricNetworkInterceptConfig(Boolean r100, ArrayList<String> r101, ArrayList<String> r102, Boolean r103, Float r104) {
        this.enabled = r100;
        this.obricNetworkHostWhiteList = r101;
        this.obricNetworkPathWhiteList = r102;
        this.obricEnableTTNetMonitorHookEvent = r103;
        this.obricTtnetMonitorHookEventRate = r104;
    }

    public /* synthetic */ ObricNetworkInterceptConfig(Boolean r100, ArrayList r101, ArrayList r102, Boolean r103, Float r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = Boolean.TRUE;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        ArrayList r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        r102 = new ArrayList();
    L11:
        ArrayList r106 = r102;
        if ((r105 & 8) == 0) goto L14;
        r103 = Boolean.FALSE;
    L14:
        Boolean r107 = r103;
        if ((r105 & 16) == 0) goto L17;
        r104 = Float.valueOf(0.0f);
    L17:
        Boolean r108 = r100;
        this(r108, r111, r106, r107, r104);
    }
}
