package ia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class b implements c {
    private ia.a _anniexContainerProxy;

    public static final class a extends ia.a {
        public a() {
        }
    }

    @Override // ia.c
    public void bindContainerId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
    }

    @Override // ia.c
    public boolean canBackPress() {
        return false;
    }

    @Override // ia.c
    public boolean canGoBack() {
        return false;
    }

    @Override // ia.c
    public void close() {
    }

    @Override // ia.c
    public void enterBackground() {
    }

    @Override // ia.c
    public void enterForeground() {
    }

    @Override // ia.c
    public void finish() {
    }

    @Override // ia.c
    public String getBDXTag() {
        return "";
    }

    @Override // ia.c
    public String getBid() {
        return "";
    }

    @Override // ia.c
    public String getContainerId() {
        return "";
    }

    @Override // ia.c
    public m16.b getContextProviderFactory() {
        return null;
    }

    @Override // ia.c
    public t36.d getCurrentSchema() {
        return null;
    }

    @Override // ia.c
    public String getCurrentUrl() {
        return "";
    }

    @Override // ia.c
    public View getKitView() {
        return null;
    }

    @Override // ia.c
    public t36.d getSchemaData() {
        return null;
    }

    @Override // ia.c
    public Context getSystemContext() {
        return null;
    }

    @Override // ia.c
    public String getViewType() {
        return "";
    }

    @Override // ia.c
    public void goBack() {
    }

    @Override // ia.c
    public void hideError() {
    }

    @Override // ia.c
    public void hideLoading() {
    }

    @Override // ia.c
    public void interceptBackPress(boolean r100) {
    }

    public boolean isVisibility() {
        return false;
    }

    @Override // ia.c
    public void loadSchema(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
    }

    public void observerKeyboardStatusChange() {
    }

    @Override // ia.c
    public void onAttachToWindow() {
    }

    @Override // ia.c
    public void onCreate(Bundle r100) {
    }

    @Override // ia.c
    public void onVisibleChange(boolean r100, Boolean r101) {
    }

    public void preloadSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
    }

    @Override // ia.c
    public <T> void registerWeakHolder(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
    }

    @Override // ia.c
    public void reload(Map<String, ? extends Object> r100) {
    }

    @Override // ia.c
    public void reloadTemplate(Map<String, ? extends Object> r100) {
    }

    public void removeKitView() {
    }

    @Override // ia.c
    public void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.h r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // ia.c
    public void showError() {
    }

    @Override // ia.c
    public void showLoading(String r100) {
    }

    public void updateData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // ia.c
    public void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // ia.c
    public void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "globalProps");
    }

    @Override // ia.c
    public void updateScreenMetrics(int r100, int r101) {
    }

    @Override // ia.c
    public Map<String, Long> getPerfMap() {
        return new LinkedHashMap();
    }

    @Override // ia.c
    public WeakReference<Context> getWeakContext() {
        return new WeakReference(null);
    }

    public final void onKitViewCreate() {
        ia.a r100 = this._anniexContainerProxy;
        if (r100 == null) goto L10;
        AnnieXContainerManager r101 = AnnieXContainerManager.INSTANCE;
        View r102 = getKitView();
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        r101.saveContainerProxyFromEngineHashCode(r103, r100);
        return;
    L7:
        r103 = -1;
        goto L8
    }

    @Override // ia.c
    public void release() {
        AnnieXContainerManager r100 = AnnieXContainerManager.INSTANCE;
        View r101 = getKitView();
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        r100.removeContainerProxyFromEngineHashCode(r102);
        this._anniexContainerProxy = null;
        return;
    L5:
        r102 = -1;
        goto L6
    }

    public b() {
        this._anniexContainerProxy = new a();
    }

    @Override // ia.c
    public LaunchMode getBDXLaunchMode() {
        return LaunchMode.MODE_UNSPECIFIED;
    }

    @Override // ia.c
    public KitType getKitType() {
        return KitType.UNKNOWN;
    }

    @Override // ia.c
    public t36.d generateSchemaData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Lazy<SchemaService> r101 = SchemaService.f248116f;
        return SchemaService.a.a().b("default_bid", Uri.EMPTY);
    }

    @Override // ia.c
    public void onEngineReady(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
    }

    public void recreateKitView(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    public void loadSchema(String r100, Map<String, ? extends Object> r101, m16.b r102, com.bytedance.android.anniex.base.lifecycle.a r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
    }
}
