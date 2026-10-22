package ia;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: classes43.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c r100, boolean r101) {
            r100.onVisibleChange(r101, Boolean.FALSE);
        }
    }

    @Deprecated(message = "迫不得已加的下沉接口，内部重构使用，外部千万不要使用，出了问题不负责修复")
    void bindContainerId(String r100);

    boolean canBackPress();

    boolean canGoBack();

    void close();

    void enterBackground();

    void enterForeground();

    void finish();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    t36.d generateSchemaData(String r100);

    LaunchMode getBDXLaunchMode();

    String getBDXTag();

    String getBid();

    String getContainerId();

    m16.b getContextProviderFactory();

    t36.d getCurrentSchema();

    @Deprecated(message = "实现不稳定，仅容器内部使用，外部千万不要使用，出了问题不负责修复")
    String getCurrentUrl();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    KitType getKitType();

    View getKitView();

    Map<String, Long> getPerfMap();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    t36.d getSchemaData();

    Context getSystemContext();

    String getViewType();

    WeakReference<Context> getWeakContext();

    void goBack();

    void hideError();

    void hideLoading();

    void interceptBackPress(boolean r100);

    void loadSchema(String r100, Map<String, ? extends Object> r101);

    void onAttachToWindow();

    void onCreate(Bundle r100);

    void onEngineReady(m16.b r100);

    void onVisibleChange(boolean r100, Boolean r101);

    <T> void registerWeakHolder(Class<T> r100, T r101);

    void release();

    void reload(Map<String, ? extends Object> r100);

    void reloadTemplate(Map<String, ? extends Object> r100);

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.h r100);

    void showError();

    void showLoading(String r100);

    void updateData(Map<String, ? extends Object> r100);

    void updateGlobalProps(Map<String, ? extends Object> r100);

    void updateScreenMetrics(int r100, int r101);
}
