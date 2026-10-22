package com.bytedance.ee.bear.document.edit_toolbar;

import android.content.Context;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolBarV2Type;
import com.bytedance.ee.bear.edit.component.toolbar2.c0;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.common.ReflectUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeDocToolbarV2JsHandlerPlugin extends DocumentPluginV3 implements BaseDocToolbarV2JsHandlerPlugin<ChameleonPluginHost> {
    private static final String TAG = "DocToolbarV2JsHandlerPlugin";
    private EditPanelsManager editPanelsManager;
    private final List<c0<? extends ToolbarV2>> jsHandlers;
    private boolean mSyncedBlockEnable;

    public class a implements i<JSONObject> {
        public final /* synthetic */ OfficeDocToolbarV2JsHandlerPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficeDocToolbarV2JsHandlerPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r12, m r13) {
            JSONObject r14 = (JSONObject) r12;
            if (r14 == null) goto L5;
            tt5.a.h(OfficeDocToolbarV2JsHandlerPlugin.TAG, "[ToolbarV2]=" + du5.b.k(r14.toString()));
        L7:
            if (OfficeDocToolbarV2JsHandlerPlugin.access$100(this.a) != null) goto L9;
            return;
        L9:
            if (OfficeDocToolbarV2JsHandlerPlugin.access$100(this.a).size() == 0) goto L60;
            Iterator r1 = OfficeDocToolbarV2JsHandlerPlugin.access$100(this.a).iterator();
        L12:
            if (r1.hasNext() == false) goto L61;
            c0 r2 = (c0) r1.next();
            if (r14 == null) goto L35;
            if (r14.isEmpty() == true) goto L35;
            Class r5 = ReflectUtils.a(r2);
            if (r5 != null) goto L40;
            r5 = ReflectUtils.b(r2);
        L40:
            Object r6 = JSON.parseObject(r14.toString(), r5);     // Catch: Throwable -> L33
            if ((r6 instanceof ToolbarV2) == false) goto L12;
            if (((ToolbarV2) r6).getType() != r2.getType()) goto L12;
            Iterator r7 = OfficeDocToolbarV2JsHandlerPlugin.access$100(this.a).iterator();     // Catch: Throwable -> L33
        L27:
            if (r7.hasNext() == false) goto L31;
            c0 r8 = (c0) r7.next();     // Catch: Throwable -> L33
            if (r8 == r2) goto L27;
            tt5.a.h(OfficeDocToolbarV2JsHandlerPlugin.TAG, "hide " + ToolBarV2Type.getName(r8.getType()) + " toolbar ");     // Catch: Throwable -> L33
            r8.handle(null, r13);     // Catch: Throwable -> L33
            goto L27
        L31:
            r2.handle(r6, r13);     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            tt5.a.d(OfficeDocToolbarV2JsHandlerPlugin.TAG, "ToolbarJsHandler PARSE_DATA_ERR  data： " + r14 + "    clazz： " + r5 + "  e: " + th);
        L35:
            tt5.a.h(OfficeDocToolbarV2JsHandlerPlugin.TAG, "all hide " + ToolBarV2Type.getName(r2.getType()) + " toolbar ");
            if (OfficeDocToolbarV2JsHandlerPlugin.access$200(this.a).getActiveEditPanel().getValue() != r2.getEditPanel()) goto L38;
            rcb.c.c(OfficeDocToolbarV2JsHandlerPlugin.access$300(this.a));
        L38:
            r2.handle(null, r13);
            goto L12
        L61:
            return;
        L60:
            return;
        L5:
            tt5.a.h(OfficeDocToolbarV2JsHandlerPlugin.TAG, "[ToolbarV2]= null");
            goto L7
        }
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeDocToolbarV2JsHandlerPlugin() {
        this.jsHandlers = new ArrayList();
        this.mSyncedBlockEnable = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.docs.all.synced_block_enable");
    }

    public static /* synthetic */ List access$100(OfficeDocToolbarV2JsHandlerPlugin r0) {
        return r0.jsHandlers;
    }

    public static /* synthetic */ EditPanelsManager access$200(OfficeDocToolbarV2JsHandlerPlugin r0) {
        return r0.editPanelsManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$300(OfficeDocToolbarV2JsHandlerPlugin r0) {
        return r0.getContext();
    }

    private boolean isEmptyData(JSONObject r4) {
        if (CollectionUtils.isEmpty(r4) == false) goto L6;
        return true;
    L6:
        if (r4.size() == 2) goto L8;
        return false;
    L8:
        if (r4.containsKey("srcObjToken") == true) goto L10;
        return false;
    L10:
        if (r4.containsKey("srcObjType") == false) goto L16;
        tt5.a.h(TAG, "empty synced block data");
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        this.editPanelsManager = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
        getWeb().getBridge().c("biz.navigation.setDocToolbarV2", new a(this));
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2JsHandlerPlugin
    public void registerHandler(c0<? extends ToolbarV2> r2) {
        if (this.jsHandlers.contains(r2) == false) goto L5;
        this.jsHandlers.remove(r2);
    L5:
        this.jsHandlers.add(r2);
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2JsHandlerPlugin
    public void unRegisterHandler(c0<? extends ToolbarV2> r2) {
        if (this.jsHandlers.contains(r2) == false) goto L6;
        this.jsHandlers.remove(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2JsHandlerPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
