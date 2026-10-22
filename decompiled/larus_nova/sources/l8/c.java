package l8;

import android.os.Bundle;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.monitor.common.timing.PerformanceTiming;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f507906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c7.a f507907b;

    @Override // b7.a, b7.b
    public final void onBeforeGlobalPropsInitialize() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_component_global_props_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeInitialPropsInitialize() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_component_initial_props_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeJsbRegister() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_component_jsb_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeOpenContainer() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "open_time");
    }

    @Override // b7.a, b7.b
    public final void onCardLoadStart() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_card_load_start");
    }

    @Override // b7.a, b7.b
    public final void onContainerInitEnd() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "container_init_end");
    }

    @Override // b7.a, b7.b
    public final void onContainerInitStart() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "container_init_start");
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadEnd() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_engine_load_end");
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadStart() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_engine_load_start");
    }

    @Override // b7.a, b7.b
    public final void onGlobalPropsInitialized() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_component_global_props_end");
    }

    @Override // b7.a, b7.b
    public final void onInitialPropsInitialized() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_component_initial_props_end");
    }

    @Override // b7.a, b7.b
    public final void onJsbRegistered() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_component_jsb_end");
    }

    @Override // b7.a, b7.b
    public final void onLynxEnvInitialized() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_component_lynx_env_end");
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentEnd() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_component_end");
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentStart() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_component_start");
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataEnd() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_init_data_end");
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateStart() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        b.b(this.f507906a, "prepare_template_start");
    }

    @Override // b7.a, b7.b
    public final void onRelease() {
        ConcurrentHashMap<String, PerformanceTiming> r100 = b.f507905a;
        String r101 = this.f507906a;
        Intrinsics.checkNotNullParameter(r101, ST.UUID_DEVICE);
        b.f507905a.remove(r101);
    }

    public c() {
        this.f507906a = UUID.randomUUID().toString();
    }

    @Override // b7.a, b7.b
    public final void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        ConcurrentHashMap<String, PerformanceTiming> r101 = b.f507905a;
        b.b(this.f507906a, "prepare_render_data_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeLynxEnvInitialize(boolean r100) {
        ConcurrentHashMap<String, PerformanceTiming> r101 = b.f507905a;
        b.b(this.f507906a, "prepare_component_lynx_env_start");
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r100) {
        Intrinsics.checkNotNullParameter(r100, "annieContext");
        this.f507907b = r100;
        Bundle r101 = r100.getBundle();
        if (r101 == null) goto L9;
        String r102 = r101.getString("annie_uuid_key");
        if (r102 == null) goto L7;
        this.f507906a = r102;
    L7:
        ConcurrentHashMap<String, PerformanceTiming> r103 = b.f507905a;
        String r104 = this.f507906a;
        Intrinsics.checkNotNullParameter(r104, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        b.a(r104).setInitBundle(r101);
        return;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        ConcurrentHashMap<String, PerformanceTiming> r101 = b.f507905a;
        b.b(this.f507906a, "prepare_engine_js_load_end");
        String r102 = this.f507906a;
        c7.a r103 = this.f507907b;
        if (r103 == null) goto L6;
        String r104 = r103.getBizKey();
        if (r104 == null) goto L6;
    L7:
        b.c(r102, r104);
        return;
    L6:
        r104 = "host";
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateEnd(boolean r100) {
        ConcurrentHashMap<String, PerformanceTiming> r101 = b.f507905a;
        String r102 = this.f507906a;
        Intrinsics.checkNotNullParameter(r102, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter("prepare_template_end", "stageName");
        PerformanceTiming r103 = b.a(r102);
        if (r100 == false) goto L5;
        String r104 = "gecko";
    L6:
        r103.setTemplateResType(r104);
        r103.put("prepare_template_end", Long.valueOf(System.currentTimeMillis()));
        return;
    L5:
        r104 = "cdn";
        goto L6
    }

    @Override // b7.a, b7.b
    public final void onCreateRenderData(View r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        Intrinsics.checkNotNullParameter(r101, "stateKeys");
        ConcurrentHashMap<String, PerformanceTiming> r102 = b.f507905a;
        b.b(this.f507906a, "prepare_render_data_end");
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        a(r100, r101, "fallback");
        return false;
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        a(r100, r101, "fallback");
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r100, boolean r101) {
        ConcurrentHashMap<String, PerformanceTiming> r102 = b.f507905a;
        b.b(this.f507906a, "prepare_engine_js_load_start");
    }

    public final void a(int r100, String r101, String r102) {
        ConcurrentHashMap<String, PerformanceTiming> r103 = b.f507905a;
        String r104 = this.f507906a;
        Intrinsics.checkNotNullParameter(r104, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "reason");
        PerformanceTiming r105 = b.a(r104);
        r105.setErrorMsg(r101);
        r105.setErrorCode(Integer.valueOf(r100));
        r105.setErrorReason(r102);
        String r106 = this.f507906a;
        c7.a r107 = this.f507907b;
        if (r107 == null) goto L6;
        String r108 = r107.getBizKey();
        if (r108 == null) goto L6;
    L7:
        b.c(r106, r108);
        return;
    L6:
        r108 = "host";
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onAttachView(View r100, IHybridComponent.HybridType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        ConcurrentHashMap<String, PerformanceTiming> r103 = b.f507905a;
        String r104 = this.f507906a;
        Intrinsics.checkNotNullParameter(r104, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        PerformanceTiming r105 = b.a(r104);
        r105.setEngineType(r101.getHybridName());
        if (r100 == null) goto L5;
        r105.setViewRef(new WeakReference(r100));
    L5:
        if (r102 == null) goto L8;
        r105.setPageType(r102);
        return;
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        a(r101, r102, "error");
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataStart(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
        ConcurrentHashMap<String, PerformanceTiming> r103 = b.f507905a;
        b.b(this.f507906a, "prepare_init_data_start");
    }
}
