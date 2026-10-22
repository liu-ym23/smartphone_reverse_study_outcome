package com.bytedance.locallife.cube.api.i;

import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.config.LynxLoadConfig;
import com.bytedance.locallife.cube.api.model.CubeLynxError;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001>J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0006H&J\u001c\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\rH&J\b\u0010\u0010\u001a\u00020\u0006H&J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u0017\u001a\u00020\u0006H&J \u0010\u001c\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001e\u001a\u00020\u0006H&J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002H&J \u0010#\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0014H&J\u001a\u0010$\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u0002H&J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002H&J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002H&J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002H&J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002H&J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002H&J\u001a\u0010+\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010*H&J\u001a\u0010.\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010,H&J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002H&J\b\u00100\u001a\u00020\u0006H&J\b\u00101\u001a\u00020\u0006H&J\b\u00102\u001a\u00020\u0006H&J&\u00104\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00022\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH&JF\u00108\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00022\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000205\u0018\u00010\r2\b\u00107\u001a\u0004\u0018\u00010\tH&J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u000209H&J\u001c\u0010=\u001a\u00020\u00062\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\rH&¨\u0006?"}, d2 = {"Lcom/bytedance/locallife/cube/api/i/ICubeListener;", "", "Lcom/bytedance/locallife/cube/api/config/CubeContext;", "cubeContext", "Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;", "delegate", "", "beforeCreateLynxView", "onLynxKitDelegateCreated", "", "url", "onLoadStart", "onInitDataEnd", "", "globalProps", "beforeUpdateProps", "beforeLoadTemplate", "Lcom/bytedance/ies/bullet/service/base/d1;", "resourceInfo", "loadTemplateReady", "", "error", "loadTemplateError", "beforeReadTemplate", "", "lynxFile", "Lcom/bytedance/ies/bullet/core/q;", "listener", "afterReadTemplate", "beforeRender", "afterRender", "uri", PerfLog.PARAM_KEY_CONTEXT_ID, "onLoadUriSucceed", "cause", "onLoadUriFailed", "onPageStart", "onPageUpdate", "onUpdateDataWithoutChange", "onDataUpdated", "onLoadSuccess", "onFirstScreen", "Lcom/bytedance/locallife/cube/api/model/CubeLynxError;", "onReceivedError", "Lorg/json/JSONObject;", "metric", "onFirstLoadPerfReady", "onRuntimeReady", "onLynxViewClientDestroy", "beforeDestroy", "onLynxViewAndJSRuntimeDestroy", "timingInfo", "onTimingSetup", "", "updateTiming", ForwardDependency$ForwardLocation.FLAG, "onTimingUpdate", "Lcom/bytedance/locallife/cube/api/config/LynxLoadConfig;", "lynxLoadConfig", "onBeforeLoadTransformLynxKitParams", "data", "onBeforeUpdateData", "Base", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public interface ICubeListener {

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J \u0010\u001d\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0002H\u0016J \u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0015H\u0016J\u001a\u0010%\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0016J\u001a\u0010,\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010/\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00100\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0016J\b\u00101\u001a\u00020\u0006H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J&\u00105\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00022\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016JF\u00109\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00022\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000206\u0018\u00010\r2\b\u00108\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020:H\u0016J\u001c\u0010>\u001a\u00020\u00062\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006A"}, d2 = {"Lcom/bytedance/locallife/cube/api/i/ICubeListener$Base;", "Lcom/bytedance/locallife/cube/api/i/ICubeListener;", "Lcom/bytedance/locallife/cube/api/config/CubeContext;", "cubeContext", "Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;", "delegate", "", "beforeCreateLynxView", "onLynxKitDelegateCreated", "", "url", "onLoadStart", "onInitDataEnd", "", "", "globalProps", "beforeUpdateProps", "beforeLoadTemplate", "Lcom/bytedance/ies/bullet/service/base/d1;", "resourceInfo", "loadTemplateReady", "", "error", "loadTemplateError", "beforeReadTemplate", "", "lynxFile", "Lcom/bytedance/ies/bullet/core/q;", "listener", "afterReadTemplate", "beforeRender", "afterRender", "uri", PerfLog.PARAM_KEY_CONTEXT_ID, "onLoadUriSucceed", "cause", "onLoadUriFailed", "onPageStart", "onPageUpdate", "onUpdateDataWithoutChange", "onDataUpdated", "onLoadSuccess", "onFirstScreen", "Lcom/bytedance/locallife/cube/api/model/CubeLynxError;", "onReceivedError", "Lorg/json/JSONObject;", "metric", "onFirstLoadPerfReady", "onRuntimeReady", "onLynxViewClientDestroy", "beforeDestroy", "onLynxViewAndJSRuntimeDestroy", "timingInfo", "onTimingSetup", "", "updateTiming", ForwardDependency$ForwardLocation.FLAG, "onTimingUpdate", "Lcom/bytedance/locallife/cube/api/config/LynxLoadConfig;", "lynxLoadConfig", "onBeforeLoadTransformLynxKitParams", "data", "onBeforeUpdateData", "<init>", "()V", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
    public static class Base implements ICubeListener {
        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void afterReadTemplate(String r100, byte[] r101, q r102) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "lynxFile");
            Intrinsics.checkNotNullParameter(r102, "listener");
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void afterRender() {
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void beforeCreateLynxView(CubeContext r100, IPoiLynxKitDelegate r101) {
            Intrinsics.checkNotNullParameter(r100, "cubeContext");
            Intrinsics.checkNotNullParameter(r101, "delegate");
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void beforeDestroy() {
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void beforeLoadTemplate() {
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void beforeReadTemplate() {
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void beforeRender() {
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void beforeUpdateProps(Map<String, Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "globalProps");
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void loadTemplateError(Throwable r100) {
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void loadTemplateReady(d1 r100) {
            Intrinsics.checkNotNullParameter(r100, "resourceInfo");
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onBeforeLoadTransformLynxKitParams(LynxLoadConfig r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxLoadConfig");
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onBeforeUpdateData(Map<String, Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onDataUpdated(CubeContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onFirstLoadPerfReady(CubeContext r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onFirstScreen(CubeContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onInitDataEnd() {
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onLoadStart(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onLoadSuccess(CubeContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onLoadUriFailed(String r100, CubeContext r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "cause");
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onLoadUriSucceed(String r100, CubeContext r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onLynxKitDelegateCreated(CubeContext r100, IPoiLynxKitDelegate r101) {
            Intrinsics.checkNotNullParameter(r100, "cubeContext");
            Intrinsics.checkNotNullParameter(r101, "delegate");
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onLynxViewAndJSRuntimeDestroy() {
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onLynxViewClientDestroy() {
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onPageStart(String r100, CubeContext r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onPageUpdate(CubeContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onReceivedError(CubeContext r100, CubeLynxError r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onRuntimeReady(CubeContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onTimingSetup(CubeContext r100, Map<String, Object> r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onTimingUpdate(CubeContext r100, Map<String, Object> r101, Map<String, Long> r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener
        public void onUpdateDataWithoutChange(CubeContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        public Base() {
        }
    }

    void afterReadTemplate(String r100, byte[] r101, q r102);

    void afterRender();

    void beforeCreateLynxView(CubeContext r100, IPoiLynxKitDelegate r101);

    void beforeDestroy();

    void beforeLoadTemplate();

    void beforeReadTemplate();

    void beforeRender();

    void beforeUpdateProps(Map<String, Object> r100);

    void loadTemplateError(Throwable r100);

    void loadTemplateReady(d1 r100);

    void onBeforeLoadTransformLynxKitParams(LynxLoadConfig r100);

    void onBeforeUpdateData(Map<String, Object> r100);

    void onDataUpdated(CubeContext r100);

    void onFirstLoadPerfReady(CubeContext r100, JSONObject r101);

    void onFirstScreen(CubeContext r100);

    void onInitDataEnd();

    void onLoadStart(String r100);

    void onLoadSuccess(CubeContext r100);

    void onLoadUriFailed(String r100, CubeContext r101, Throwable r102);

    void onLoadUriSucceed(String r100, CubeContext r101);

    void onLynxKitDelegateCreated(CubeContext r100, IPoiLynxKitDelegate r101);

    void onLynxViewAndJSRuntimeDestroy();

    void onLynxViewClientDestroy();

    void onPageStart(String r100, CubeContext r101);

    void onPageUpdate(CubeContext r100);

    void onReceivedError(CubeContext r100, CubeLynxError r101);

    void onRuntimeReady(CubeContext r100);

    void onTimingSetup(CubeContext r100, Map<String, Object> r101);

    void onTimingUpdate(CubeContext r100, Map<String, Object> r101, Map<String, Long> r102, String r103);

    void onUpdateDataWithoutChange(CubeContext r100);
}
