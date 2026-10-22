package com.bytedance.locallife.cube.api.config;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Jy\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010*\u001a\u00020+H\u0016J\t\u0010,\u001a\u00020\u0007HÖ\u0001R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015¨\u0006-"}, d2 = {"Lcom/bytedance/locallife/cube/api/config/LynxLoadConfig;", "", "readResOnMainThread", "", "renderTemplateOnMainThread", "initData", "", "", "customGlobalProps", "monitorContext", "", "enablePreFetchImage", "enableAsyncRequestImage", "(ZZLjava/util/Map;Ljava/util/Map;Ljava/util/Map;ZZ)V", "getCustomGlobalProps", "()Ljava/util/Map;", "setCustomGlobalProps", "(Ljava/util/Map;)V", "getEnableAsyncRequestImage", "()Z", "setEnableAsyncRequestImage", "(Z)V", "getEnablePreFetchImage", "setEnablePreFetchImage", "getInitData", "setInitData", "getMonitorContext", "setMonitorContext", "getReadResOnMainThread", "setReadResOnMainThread", "getRenderTemplateOnMainThread", "setRenderTemplateOnMainThread", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LynxLoadConfig {
    private Map<String, Object> customGlobalProps;
    private boolean enableAsyncRequestImage;
    private boolean enablePreFetchImage;
    private Map<String, Object> initData;
    private Map<String, String> monitorContext;
    private boolean readResOnMainThread;
    private boolean renderTemplateOnMainThread;

    public LynxLoadConfig() {
        this(false, false, null, null, null, false, false, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxLoadConfig copy$default(LynxLoadConfig r100, boolean r101, boolean r102, Map r103, Map r104, Map r110, boolean r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.readResOnMainThread;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.renderTemplateOnMainThread;
    L8:
        boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.initData;
    L11:
        Map r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.customGlobalProps;
    L14:
        Map r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.monitorContext;
    L17:
        Map r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.enablePreFetchImage;
    L20:
        boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.enableAsyncRequestImage;
    L23:
        boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final boolean component1() {
        return this.readResOnMainThread;
    }

    public final boolean component2() {
        return this.renderTemplateOnMainThread;
    }

    public final Map<String, Object> component3() {
        return this.initData;
    }

    public final Map<String, Object> component4() {
        return this.customGlobalProps;
    }

    public final Map<String, String> component5() {
        return this.monitorContext;
    }

    public final boolean component6() {
        return this.enablePreFetchImage;
    }

    public final boolean component7() {
        return this.enableAsyncRequestImage;
    }

    public final LynxLoadConfig copy(boolean r110, boolean r111, Map<String, Object> r112, Map<String, Object> r113, Map<String, String> r114, boolean r115, boolean r116) {
        return new LynxLoadConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public String toString() {
        return "LynxLoadConfig(readResOnMainThread=" + this.readResOnMainThread + ", renderTemplateOnMainThread=" + this.renderTemplateOnMainThread + ", initData=" + this.initData + ", customGlobalProps=" + this.customGlobalProps + ", monitorContext=" + this.monitorContext + ", enablePreFetchImage=" + this.enablePreFetchImage + ", enableAsyncRequestImage=" + this.enableAsyncRequestImage + ')';
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.readResOnMainThread == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.renderTemplateOnMainThread == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        Map<String, Object> r104 = this.initData;
        int r105 = 0;
        if (r104 == null) goto L13;
        int r106 = r104.hashCode();
    L14:
        int r107 = (r103 + r106) * 31;
        Map<String, Object> r108 = this.customGlobalProps;
        if (r108 == null) goto L18;
        r105 = r108.hashCode();
    L18:
        return r107 + r105;
    L13:
        r106 = 0;
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final Map<String, Object> getCustomGlobalProps() {
        return this.customGlobalProps;
    }

    public final boolean getEnableAsyncRequestImage() {
        return this.enableAsyncRequestImage;
    }

    public final boolean getEnablePreFetchImage() {
        return this.enablePreFetchImage;
    }

    public final Map<String, Object> getInitData() {
        return this.initData;
    }

    public final Map<String, String> getMonitorContext() {
        return this.monitorContext;
    }

    public final boolean getReadResOnMainThread() {
        return this.readResOnMainThread;
    }

    public final boolean getRenderTemplateOnMainThread() {
        return this.renderTemplateOnMainThread;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(LynxLoadConfig.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.cube.api.config.LynxLoadConfig");
        LynxLoadConfig r102 = (LynxLoadConfig) r100;
        if (this.readResOnMainThread == r102.readResOnMainThread) goto L16;
        return false;
    L16:
        if (this.renderTemplateOnMainThread == r102.renderTemplateOnMainThread) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.initData, r102.initData) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.customGlobalProps, r102.customGlobalProps) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setCustomGlobalProps(Map<String, Object> r100) {
        this.customGlobalProps = r100;
    }

    public final void setEnableAsyncRequestImage(boolean r100) {
        this.enableAsyncRequestImage = r100;
    }

    public final void setEnablePreFetchImage(boolean r100) {
        this.enablePreFetchImage = r100;
    }

    public final void setInitData(Map<String, Object> r100) {
        this.initData = r100;
    }

    public final void setMonitorContext(Map<String, String> r100) {
        this.monitorContext = r100;
    }

    public final void setReadResOnMainThread(boolean r100) {
        this.readResOnMainThread = r100;
    }

    public final void setRenderTemplateOnMainThread(boolean r100) {
        this.renderTemplateOnMainThread = r100;
    }

    public LynxLoadConfig(boolean r100, boolean r101, Map<String, Object> r102, Map<String, Object> r103, Map<String, String> r104, boolean r105, boolean r106) {
        this.readResOnMainThread = r100;
        this.renderTemplateOnMainThread = r101;
        this.initData = r102;
        this.customGlobalProps = r103;
        this.monitorContext = r104;
        this.enablePreFetchImage = r105;
        this.enableAsyncRequestImage = r106;
    }

    public /* synthetic */ LynxLoadConfig(boolean r100, boolean r101, Map r102, Map r110, Map r111, boolean r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        boolean r116 = false;
    L7:
        if ((r114 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Map r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Map r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Map r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r114 & 64) == 0) goto L29;
        boolean r117 = false;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
