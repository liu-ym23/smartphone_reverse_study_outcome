package ks4;

import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolHandle;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements j, ILarkLynxContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILarkLynxContainer f505908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f505909b;

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void destroy() {
        this.f505908a.destroy();
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final ILarkLynxBridgeProtocolHandle getBridgeProtocolHandle() {
        return this.f505908a.getBridgeProtocolHandle();
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final View getLynxView() {
        return this.f505908a.getLynxView();
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final boolean hasRendered() {
        return this.f505908a.hasRendered();
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void hide() {
        this.f505908a.hide();
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void reloadTemplate(String r100, Map<String, ? extends Object> r101) {
        this.f505908a.reloadTemplate(r100, r101);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void render() {
        this.f505908a.render();
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void render(TemplateBundle r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        this.f505908a.render(r100, r101, r102);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void render(String r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "templateUrl");
        this.f505908a.render(r100, r101, r102);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void render(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "templateUrl");
        this.f505908a.render(r100, r101, r102);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void render(byte[] r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "templateData");
        this.f505908a.render(r100, r101, r102);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void render(byte[] r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "templateData");
        this.f505908a.render(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void renderByTemplateLoader(String r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "templatePath");
        this.f505908a.renderByTemplateLoader(r100, r101, r102);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void renderByTemplateLoader(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "templatePath");
        this.f505908a.renderByTemplateLoader(r100, r101, r102);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void renderByTemplateLoaderWithTemplateData(String r100, TemplateData r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "templatePath");
        this.f505908a.renderByTemplateLoaderWithTemplateData(r100, r101, r102);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void renderWithTemplateData(TemplateBundle r100, TemplateData r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        this.f505908a.renderWithTemplateData(r100, r101, r102);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void renderWithTemplateData(String r100, TemplateData r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "templateUrl");
        this.f505908a.renderWithTemplateData(r100, r101, r102);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void renderWithTemplateData(byte[] r100, TemplateData r101, Map<String, ? extends Object> r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "templateData");
        this.f505908a.renderWithTemplateData(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void resetData(String r100) {
        this.f505908a.resetData(r100);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void sendDataToJSByModule(List<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f505908a.sendDataToJSByModule(r100);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void sendGlobalEventToJS(String r100, List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f505908a.sendGlobalEventToJS(r100, r101);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void show() {
        this.f505908a.show();
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void updateData(String r100, Map<String, ? extends Object> r101) {
        this.f505908a.updateData(r100, r101);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void updateData(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101) {
        this.f505908a.updateData(r100, r101);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void updateGlobalData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dataJson");
        this.f505908a.updateGlobalData(r100);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void updateGlobalData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataMap");
        this.f505908a.updateGlobalData(r100);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void updateShareData(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "shareData");
        this.f505908a.updateShareData(r100);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void updateSize(int r100, int r101) {
        this.f505908a.updateSize(r100, r101);
    }

    @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
    public final void updateTemplateData(TemplateData r100, Map<String, ? extends Object> r101) {
        this.f505908a.updateTemplateData(r100, r101);
    }

    public b(ILarkLynxContainer r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "containerContext");
        this.f505908a = r100;
        this.f505909b = r101;
    }

    @Override // ks4.j
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, RuleConditionBean.BIZ_DATA_KEY);
        c r102 = this.f505909b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, RuleConditionBean.BIZ_DATA_KEY);
        r102.f505910a.put(r100, r101);
    }
}
