package com.bytedance.android.shopping.store.hybrid;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabConfig;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabDTO;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 62\u00020\u0001:\u00017BW\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b4\u00105J\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0017\u0010!\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017R\u0017\u0010#\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b$\u0010\fR\u0019\u0010%\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010*\u001a\u0004\u0018\u00010)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R0\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;", "Ljava/io/Serializable;", "", "isDynamicTabConfig", "", "", "dictionary", "getApiExtraParamsWith", "getEventExtraParamsWith", "durationReported", "Z", "getDurationReported", "()Z", "setDurationReported", "(Z)V", "enterStoreReported", "getEnterStoreReported", "setEnterStoreReported", "isFetchDynamicTabInitialData", "setFetchDynamicTabInitialData", "monitorId", "Ljava/lang/String;", "getMonitorId", "()Ljava/lang/String;", "setMonitorId", "(Ljava/lang/String;)V", "", "tabId", "I", "getTabId", "()I", "tabType", "getTabType", "tabName", "getTabName", "defaultSelected", "getDefaultSelected", "containerType", "Ljava/lang/Integer;", "getContainerType", "()Ljava/lang/Integer;", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabDTO;", "dynamicTabVO", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabDTO;", "getDynamicTabVO", "()Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabDTO;", "externalMetaInfo", "Ljava/util/Map;", "getExternalMetaInfo", "()Ljava/util/Map;", "setExternalMetaInfo", "(Ljava/util/Map;)V", "<init>", "(IILjava/lang/String;ZLjava/lang/Integer;Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabDTO;Ljava/util/Map;)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreTabConfig implements Serializable {
    public static final int CONTAINER_TYPE_LYNX = 2;
    public static final int CONTAINER_TYPE_WEB = 3;
    public static final a Companion = null;
    private final Integer containerType;
    private final boolean defaultSelected;
    private boolean durationReported;
    private final ECStoreDynamicTabDTO dynamicTabVO;
    private boolean enterStoreReported;
    private Map<String, String> externalMetaInfo;
    private boolean isFetchDynamicTabInitialData;
    private String monitorId;
    private final int tabId;
    private final String tabName;
    private final int tabType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isDynamicTabConfig() {
        uj3.j.a r0 = uj3.j.L;
        Integer r1 = this.containerType;
        ECStoreDynamicTabDTO r2 = this.dynamicTabVO;
        r0.getClass();
        return uj3.j.a.a(r1, r2);
    }

    public final Integer getContainerType() {
        return this.containerType;
    }

    public final boolean getDefaultSelected() {
        return this.defaultSelected;
    }

    public final boolean getDurationReported() {
        return this.durationReported;
    }

    public final ECStoreDynamicTabDTO getDynamicTabVO() {
        return this.dynamicTabVO;
    }

    public final boolean getEnterStoreReported() {
        return this.enterStoreReported;
    }

    public final Map<String, String> getExternalMetaInfo() {
        return this.externalMetaInfo;
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final int getTabType() {
        return this.tabType;
    }

    public final boolean isFetchDynamicTabInitialData() {
        return this.isFetchDynamicTabInitialData;
    }

    public final Map<String, String> getApiExtraParamsWith(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "dictionary");
        ECStoreDynamicTabDTO r0 = this.dynamicTabVO;
        if (r0 == null) goto L7;
        ECStoreDynamicTabConfig r1 = r0.getConfig();
        if (r1 == null) goto L7;
        String r3 = r1.getApiExtraParams();
    L9:
        return a(r3, r2);
    L7:
        r3 = null;
        goto L9
    }

    public final Map<String, String> getEventExtraParamsWith(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "dictionary");
        ECStoreDynamicTabDTO r0 = this.dynamicTabVO;
        if (r0 == null) goto L7;
        ECStoreDynamicTabConfig r1 = r0.getConfig();
        if (r1 == null) goto L7;
        String r3 = r1.getEventExtraParams();
    L9:
        return a(r3, r2);
    L7:
        r3 = null;
        goto L9
    }

    public final void setDurationReported(boolean r1) {
        this.durationReported = r1;
    }

    public final void setEnterStoreReported(boolean r1) {
        this.enterStoreReported = r1;
    }

    public final void setExternalMetaInfo(Map<String, String> r1) {
        this.externalMetaInfo = r1;
    }

    public final void setFetchDynamicTabInitialData(boolean r1) {
        this.isFetchDynamicTabInitialData = r1;
    }

    public final void setMonitorId(String r1) {
        this.monitorId = r1;
    }

    public static Map a(String r4, Map r5) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        Object r2 = null;
        if (r1 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r4, "{}") == true) goto L34;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L23
        int r6 = w0.a;     // Catch: Throwable -> L23
        JsonObject r7 = (JsonObject) w0.b(r4, JsonObject.class);     // Catch: Throwable -> L23
        if (r7 != null) goto L17;
        return null;
    L17:
        b(r7, r5);     // Catch: Throwable -> L23
        String r8 = u0.d(r7);     // Catch: Throwable -> L23
        if ((!Intrinsics.areEqual(r8, "{}")) == true) goto L21;
        r8 = null;
    L21:
        Object r9 = Result.constructor-impl(w0.a(r8));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r9) == true) goto L30;
        r2 = r9;
    L30:
        return (Map) r2;
    L23:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L34:
        return null;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static void b(JsonObject r6, Map r7) {
        Regex r0 = new Regex("^\\$(\\S)+\\$$");
        Iterator r1 = new HashSet(r6.keySet()).iterator();
    L4:
        if (r1.hasNext() == false) goto L29;
        String r2 = (String) r1.next();
        JsonPrimitive r3 = r6.get(r2);
        if ((r3 instanceof JsonPrimitive) == false) goto L27;
        JsonPrimitive r4 = r3;
        if (r4.isString() == false) goto L27;
        if (r0.matches(r4.getAsString()) == false) goto L27;
        String r5 = r4.getAsString();
        Object r8 = r7.get(r5.subSequence(1, r5.length() - 1));
        String r9 = (String) r8;
        if (r9 != null) goto L14;
    L17:
        boolean r10 = true;
    L19:
        if ((!r10) == true) goto L22;
        r8 = null;
    L22:
        String r11 = (String) r8;
        if (r11 != null) goto L25;
        r11 = "";
    L25:
        r6.addProperty(r2, r11);
        goto L4
    L14:
        if (StringsKt.isBlank(r9) == true) goto L17;
        r10 = false;
    L27:
        if ((r3 instanceof JsonObject) == false) goto L4;
        b((JsonObject) r3, r7);
        goto L4
    }

    public StoreTabConfig(int r2, int r3, String r4, boolean r5, Integer r6, ECStoreDynamicTabDTO r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r4, "tabName");
        this.tabId = r2;
        this.tabType = r3;
        this.tabName = r4;
        this.defaultSelected = r5;
        this.containerType = r6;
        this.dynamicTabVO = r7;
        this.externalMetaInfo = r8;
    }

    public /* synthetic */ StoreTabConfig(int r11, int r12, String r13, boolean r14, Integer r15, ECStoreDynamicTabDTO r16, Map r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 16) == 0) goto L5;
        Integer r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        ECStoreDynamicTabDTO r8 = null;
    L11:
        if ((r18 & 64) == 0) goto L13;
        Map r9 = null;
    L14:
        this(r11, r12, r13, r14, r7, r8, r9);
        return;
    L13:
        r9 = r17;
        goto L14
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }
}
