package com.ss.android.lark.conditional.access.auth.v2.service;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J/\u0010\f\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/service/DeviceConfig;", "", "deviceConfigInfo", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getDeviceConfigInfo", "()Ljava/util/HashMap;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceConfig {
    private final HashMap<String, Integer> deviceConfigInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceConfig copy$default(DeviceConfig r100, HashMap r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.deviceConfigInfo;
    L6:
        return r100.copy(r101);
    }

    public final HashMap<String, Integer> component1() {
        return this.deviceConfigInfo;
    }

    public final DeviceConfig copy(HashMap<String, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceConfigInfo");
        return new DeviceConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeviceConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.deviceConfigInfo, ((DeviceConfig) r100).deviceConfigInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.deviceConfigInfo.hashCode();
    }

    public String toString() {
        return "DeviceConfig(deviceConfigInfo=" + this.deviceConfigInfo + ')';
    }

    public final HashMap<String, Integer> getDeviceConfigInfo() {
        return this.deviceConfigInfo;
    }

    public DeviceConfig(HashMap<String, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceConfigInfo");
        this.deviceConfigInfo = r100;
    }

    public /* synthetic */ DeviceConfig(HashMap r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new HashMap();
    L5:
        this(r100);
    }
}
