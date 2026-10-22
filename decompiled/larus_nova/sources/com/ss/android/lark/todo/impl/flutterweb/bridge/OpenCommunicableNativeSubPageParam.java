package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0003H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenCommunicableNativeSubPageParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "pagePath", "", "openType", "callbackMethod", "params", "", "callbackId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getPagePath", "()Ljava/lang/String;", "getOpenType", "getCallbackMethod", "getParams", "()Ljava/util/Map;", "getCallbackId", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenCommunicableNativeSubPageParam implements NonProguard {
    private final String callbackId;
    private final String callbackMethod;
    private final String openType;
    private final String pagePath;
    private final Map<String, String> params;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenCommunicableNativeSubPageParam copy$default(OpenCommunicableNativeSubPageParam r100, String r101, String r102, String r103, Map r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.pagePath;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.openType;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.callbackMethod;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.params;
    L14:
        Map r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.callbackId;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.pagePath;
    }

    public final String component2() {
        return this.openType;
    }

    public final String component3() {
        return this.callbackMethod;
    }

    public final Map<String, String> component4() {
        return this.params;
    }

    public final String component5() {
        return this.callbackId;
    }

    public final OpenCommunicableNativeSubPageParam copy(String r100, String r101, String r110, Map<String, String> r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "pagePath");
        Intrinsics.checkNotNullParameter(r101, "openType");
        Intrinsics.checkNotNullParameter(r110, "callbackMethod");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callbackId");
        return new OpenCommunicableNativeSubPageParam(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenCommunicableNativeSubPageParam) == true) goto L8;
        return false;
    L8:
        OpenCommunicableNativeSubPageParam r101 = (OpenCommunicableNativeSubPageParam) r100;
        if (Intrinsics.areEqual(this.pagePath, r101.pagePath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.openType, r101.openType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callbackMethod, r101.callbackMethod) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.callbackId, r101.callbackId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.pagePath.hashCode() * 31) + this.openType.hashCode()) * 31) + this.callbackMethod.hashCode()) * 31) + this.params.hashCode()) * 31) + this.callbackId.hashCode();
    }

    public String toString() {
        return "OpenCommunicableNativeSubPageParam(pagePath='" + this.pagePath + "', openType='" + this.openType + "', callbackMethod='" + this.callbackMethod + "', params='" + this.params + "', callbackId='" + this.callbackId + "')";
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final String getCallbackMethod() {
        return this.callbackMethod;
    }

    public final String getOpenType() {
        return this.openType;
    }

    public final String getPagePath() {
        return this.pagePath;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public OpenCommunicableNativeSubPageParam(String r100, String r101, String r102, Map<String, String> r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "pagePath");
        Intrinsics.checkNotNullParameter(r101, "openType");
        Intrinsics.checkNotNullParameter(r102, "callbackMethod");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "callbackId");
        this.pagePath = r100;
        this.openType = r101;
        this.callbackMethod = r102;
        this.params = r103;
        this.callbackId = r104;
    }
}
