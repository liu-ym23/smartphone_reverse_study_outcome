package com.ss.android.lark.lynxkit.container;

import android.view.View;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolHandle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J2\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J>\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J>\u0010\r\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tH&J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J2\u0010\r\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&JJ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tH&J2\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J2\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J>\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J*\u0010\u0019\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J*\u0010\u001a\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J6\u0010\u0019\u001a\u00020\u00072\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J*\u0010\u001b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 H&J\u0016\u0010!\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 H&J\b\u0010\"\u001a\u00020\u0007H&J\b\u0010#\u001a\u00020\u0007H&J\b\u0010$\u001a\u00020\u0007H&J\u001c\u0010%\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\fH&J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\tH&J\b\u0010(\u001a\u00020)H&J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H&J\u001c\u0010.\u001a\u00020\u00072\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000100H&¨\u00061"}, d2 = {"Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "", "getLynxView", "Landroid/view/View;", "getBridgeProtocolHandle", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolHandle;", ChameleonOpenTracker.Stage.RENDER, "", "templateUrl", "", "initDataJson", "lynxViewShareData", "", "renderWithTemplateData", "initData", "Lcom/lynx/tasm/TemplateData;", "templateData", "", "baseUrl", "bundle", "Lcom/lynx/tasm/TemplateBundle;", "initDataMap", "renderByTemplateLoader", "templatePath", "renderByTemplateLoaderWithTemplateData", "updateData", "updateTemplateData", "reloadTemplate", "resetData", "sendGlobalEventToJS", "event", "data", "", "sendDataToJSByModule", MapMonitorConst.EVENT_DESTROY, "show", "hide", "updateGlobalData", "dataMap", "dataJson", "hasRendered", "", "updateSize", "widthMeasureSpec", "", "heightMeasureSpec", "updateShareData", "shareData", "Ljava/util/HashMap;", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILarkLynxContainer {
    void destroy();

    ILarkLynxBridgeProtocolHandle getBridgeProtocolHandle();

    View getLynxView();

    boolean hasRendered();

    void hide();

    void reloadTemplate(String r100, Map<String, ? extends Object> r101);

    void render();

    void render(TemplateBundle r100, String r101, Map<String, ? extends Object> r102);

    void render(String r100, String r101, Map<String, ? extends Object> r102);

    void render(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102);

    void render(byte[] r100, String r101, Map<String, ? extends Object> r102);

    void render(byte[] r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, String r103);

    void renderByTemplateLoader(String r100, String r101, Map<String, ? extends Object> r102);

    void renderByTemplateLoader(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102);

    void renderByTemplateLoaderWithTemplateData(String r100, TemplateData r101, Map<String, ? extends Object> r102);

    void renderWithTemplateData(TemplateBundle r100, TemplateData r101, Map<String, ? extends Object> r102);

    void renderWithTemplateData(String r100, TemplateData r101, Map<String, ? extends Object> r102);

    void renderWithTemplateData(byte[] r100, TemplateData r101, Map<String, ? extends Object> r102, String r103);

    void resetData(String r100);

    void sendDataToJSByModule(List<? extends Object> r100);

    void sendGlobalEventToJS(String r100, List<? extends Object> r101);

    void show();

    void updateData(String r100, Map<String, ? extends Object> r101);

    void updateData(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101);

    void updateGlobalData(String r100);

    void updateGlobalData(Map<String, ? extends Object> r100);

    void updateShareData(HashMap<String, Object> r100);

    void updateSize(int r100, int r101);

    void updateTemplateData(TemplateData r100, Map<String, ? extends Object> r101);
}
