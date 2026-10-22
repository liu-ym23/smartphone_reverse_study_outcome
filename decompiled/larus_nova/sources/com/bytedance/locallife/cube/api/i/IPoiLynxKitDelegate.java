package com.bytedance.locallife.cube.api.i;

import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.config.LoadType;
import com.bytedance.locallife.cube.api.config.LynxLoadConfig;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.cube.api.model.DelegateStatus;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import m16.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0012\u001a\u00020\u0004H'J/\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u001b\b\u0002\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015¢\u0006\u0002\b\u0017H&J7\u0010\u001b\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u00192\u001b\b\u0002\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015¢\u0006\u0002\b\u0017H&J\b\u0010\u001d\u001a\u00020\u001cH&J\b\u0010\u001e\u001a\u00020\u0004H'J\u001a\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H&J2\u0010'\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001fH&JF\u0010)\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001f2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010$H&J(\u0010,\u001a\u00020\u00042\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0013H&J\u001c\u0010-\u001a\u00020\u00042\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010*H'J\u001c\u0010.\u001a\u00020\u00042\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010*H&J\b\u0010/\u001a\u00020\u0004H&J\b\u00100\u001a\u00020\u0004H&J\b\u00101\u001a\u00020\u0004H&J\n\u00103\u001a\u0004\u0018\u000102H'J\n\u00104\u001a\u0004\u0018\u00010\u001fH'J\b\u00105\u001a\u00020\u0004H&J\b\u00106\u001a\u00020\u001cH'J\b\u00107\u001a\u00020\fH'J\b\u00109\u001a\u000208H'J\b\u0010:\u001a\u00020\u0004H&J\u0012\u0010<\u001a\u0004\u0018\u00010\u00102\u0006\u0010;\u001a\u00020\u001fH&J\u0018\u0010?\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020=H&J\u0018\u0010@\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020=H&J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u001fH&J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u001fH&J\b\u0010C\u001a\u00020\u001cH&J\b\u0010E\u001a\u00020DH&J\u0012\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010;\u001a\u00020\u001fH&J\n\u0010I\u001a\u0004\u0018\u00010HH&R\u0014\u0010M\u001a\u00020J8&X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0016\u0010Q\u001a\u0004\u0018\u00010N8&X¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006R"}, d2 = {"Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;", "", "Lcom/bytedance/locallife/cube/api/i/ICubeListener;", "listener", "", "addCubeListener", "removeCubeListener", "Lkotlin/Function0;", "setOnSizeChangedListener", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "width", "height", "updateScreenMetrics", "Landroid/view/View;", "realView", "load", "Lcom/bytedance/locallife/cube/api/model/CubeInternalSchemaModel;", "schemaModel", "Lkotlin/Function1;", "Lcom/bytedance/locallife/cube/api/config/LynxLoadConfig;", "Lkotlin/ExtensionFunctionType;", "dynamicInitConfig", "Lcom/bytedance/locallife/cube/api/config/LoadType;", "loadType", "preload", "", "isPreloadSuccess", "reload", "", "eventName", "Lorg/json/JSONObject;", "params", "sendEvent", "", "data", "updateTimingFlag", "updateData", "globalProps", "updateDataWithGlobalProps", "", "newSchemaModel", "updateGlobalProps", "reloadTemplate", "resetData", SendEventContainerMethodParamModel.EventKinds.onShow, "onHide", MapMonitorConst.EVENT_DESTROY, "Lcom/bytedance/ies/bullet/service/base/d1;", "getResourceInfo", "getContainerID", "syncFlush", "isSyncFlushEnabled", "getAsyncLayoutThreadStrategy", "Lcom/bytedance/locallife/cube/api/model/DelegateStatus;", "getDelegateStatus", "addTagView", "id", "findViewByIdSelector", "Landroid/view/MotionEvent;", "ev", "hitTest", "hitTestV2", "measureLynxUI", "layoutLynxUI", "isJsRuntimeReady", "Lm16/b;", "contextProviderFactory", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "findLynxUIById", "Lcom/bytedance/locallife/cube/api/config/CubeConfig;", "getCubeConfig", "Lcom/bytedance/locallife/cube/api/config/CubeContext;", "getCubeContext", "()Lcom/bytedance/locallife/cube/api/config/CubeContext;", "cubeContext", "Lgp6/b;", "getCubeTiming", "()Lgp6/b;", "cubeTiming", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public interface IPoiLynxKitDelegate {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void load$default(IPoiLynxKitDelegate r100, CubeInternalSchemaModel r101, Function1 r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.load(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
        }

        public static /* synthetic */ void updateGlobalProps$default(IPoiLynxKitDelegate r100, Map r101, CubeInternalSchemaModel r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.updateGlobalProps(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateGlobalProps");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void preload$default(IPoiLynxKitDelegate r100, CubeInternalSchemaModel r101, LoadType r102, Function1 r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.preload(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preload");
        }

        public static /* synthetic */ void updateData$default(IPoiLynxKitDelegate r100, CubeInternalSchemaModel r101, Map r102, String r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.updateData(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateData");
        }

        public static /* synthetic */ void updateDataWithGlobalProps$default(IPoiLynxKitDelegate r100, CubeInternalSchemaModel r101, Map r102, String r103, Map r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.updateDataWithGlobalProps(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateDataWithGlobalProps");
        }
    }

    void addCubeListener(ICubeListener r100);

    void addTagView();

    b contextProviderFactory();

    void destroy();

    LynxBaseUI findLynxUIById(String r100);

    View findViewByIdSelector(String r100);

    @Deprecated(message = "temp function for GoodsDetail, to be deleted")
    int getAsyncLayoutThreadStrategy();

    @Deprecated(message = "please get ContainerID from CubeContext")
    String getContainerID();

    CubeConfig getCubeConfig();

    CubeContext getCubeContext();

    gp6.b getCubeTiming();

    @Deprecated(message = "please get DelegateStatus from CubeContext")
    DelegateStatus getDelegateStatus();

    @Deprecated(message = "please get ResourceInfo from CubeContext")
    d1 getResourceInfo();

    void hitTest(String r100, MotionEvent r101);

    void hitTestV2(String r100, MotionEvent r101);

    boolean isJsRuntimeReady();

    boolean isPreloadSuccess();

    @Deprecated(message = "no longer needed, to be deleted")
    boolean isSyncFlushEnabled();

    void layoutLynxUI(String r100);

    @Deprecated(message = "replace with load(url: String, initData: Map<String, Any>?, dynamicInitConfig: LynxDynamicInitConfig?)")
    void load();

    void load(CubeInternalSchemaModel r100, Function1<? super LynxLoadConfig, Unit> r101);

    void measureLynxUI(String r100);

    void onConfigurationChanged(Configuration r100);

    void onHide();

    void onShow();

    void preload(CubeInternalSchemaModel r100, LoadType r101, Function1<? super LynxLoadConfig, Unit> r102);

    View realView();

    @Deprecated(message = "no longer need")
    void reload();

    @Deprecated(message = "to be deleted")
    void reloadTemplate(Map<String, ? extends Object> r100);

    void removeCubeListener(ICubeListener r100);

    void resetData(Map<String, ? extends Object> r100);

    void sendEvent(String r100, JSONObject r101);

    void setOnSizeChangedListener(Function0<Unit> r100);

    void syncFlush();

    void updateData(CubeInternalSchemaModel r100, Map<String, Object> r101, String r102);

    void updateDataWithGlobalProps(CubeInternalSchemaModel r100, Map<String, Object> r101, String r102, Map<String, Object> r103);

    void updateGlobalProps(Map<String, ? extends Object> r100, CubeInternalSchemaModel r101);

    void updateScreenMetrics(int r100, int r101);
}
