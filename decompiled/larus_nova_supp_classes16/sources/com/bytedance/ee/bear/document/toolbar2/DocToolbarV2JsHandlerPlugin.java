package com.bytedance.ee.bear.document.toolbar2;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2JsHandlerPlugin;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolBarV2Type;
import com.bytedance.ee.bear.edit.component.toolbar2.c0;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.common.ReflectUtils;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rcb.c;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocToolbarV2JsHandlerPlugin extends DocumentPluginV2 implements BaseDocToolbarV2JsHandlerPlugin<PluginHost> {
    private static final String TAG = "DocToolbarV2JsHandlerPlugin";
    private EditPanelsManager editPanelsManager;
    private final List<c0<? extends ToolbarV2>> jsHandlers;
    private boolean mSyncedBlockEnable;

    public class a implements i<JSONObject> {
        public final /* synthetic */ DocToolbarV2JsHandlerPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(DocToolbarV2JsHandlerPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r12, m r13) {
            JSONObject r14 = (JSONObject) r12;
            if (r14 == null) goto L5;
            tt5.a.h(DocToolbarV2JsHandlerPlugin.TAG, "[ToolbarV2]=" + du5.b.k(r14.toString()));
        L6:
            DocViewModel r1 = DocToolbarV2JsHandlerPlugin.access$100(this.a);
            if (DocToolbarV2JsHandlerPlugin.access$200(this.a) == false) goto L17;
            if (r1 == null) goto L17;
            if (DocToolbarV2JsHandlerPlugin.access$300(this.a, r14) == false) goto L12;
            tt5.a.h(DocToolbarV2JsHandlerPlugin.TAG, "setCurrentRefBlockInfo null");
            r1.setCurrentRefBlockInfo(null);
            goto L17
        L12:
            String r2 = r14.getString("srcObjToken");
            int r4 = r14.getIntValue("srcObjType");
            if (TextUtils.isEmpty(r2) == true) goto L17;
            if (r4 <= 0) goto L17;
            tt5.a.h(DocToolbarV2JsHandlerPlugin.TAG, "setCurrentRefBlockInfo start");
            r1.setCurrentRefBlockInfo(new BlockInfo(r2, Integer.valueOf(r4)));
        L17:
            if (DocToolbarV2JsHandlerPlugin.access$400(this.a) != null) goto L19;
            return;
        L19:
            if (DocToolbarV2JsHandlerPlugin.access$400(this.a).size() == 0) goto L70;
            Iterator r3 = DocToolbarV2JsHandlerPlugin.access$400(this.a).iterator();
        L22:
            if (r3.hasNext() == false) goto L71;
            c0 r5 = (c0) r3.next();
            if (r14 == null) goto L45;
            if (r14.isEmpty() == true) goto L45;
            Class r6 = ReflectUtils.a(r5);
            if (r6 != null) goto L50;
            r6 = ReflectUtils.b(r5);
        L50:
            Object r7 = JSON.parseObject(r14.toString(), r6);     // Catch: Throwable -> L43
            if ((r7 instanceof ToolbarV2) == false) goto L22;
            if (((ToolbarV2) r7).getType() != r5.getType()) goto L22;
            Iterator r8 = DocToolbarV2JsHandlerPlugin.access$400(this.a).iterator();     // Catch: Throwable -> L43
        L37:
            if (r8.hasNext() == false) goto L41;
            c0 r9 = (c0) r8.next();     // Catch: Throwable -> L43
            if (r9 == r5) goto L37;
            tt5.a.h(DocToolbarV2JsHandlerPlugin.TAG, "hide " + ToolBarV2Type.getName(r9.getType()) + " toolbar ");     // Catch: Throwable -> L43
            r9.handle(null, r13);     // Catch: Throwable -> L43
            goto L37
        L41:
            r5.handle(r7, r13);     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            tt5.a.d(DocToolbarV2JsHandlerPlugin.TAG, "ToolbarJsHandler PARSE_DATA_ERR  data： " + r14 + "    clazz： " + r6 + "  e: " + th);
        L45:
            tt5.a.h(DocToolbarV2JsHandlerPlugin.TAG, "all hide " + ToolBarV2Type.getName(r5.getType()) + " toolbar ");
            if (DocToolbarV2JsHandlerPlugin.access$500(this.a).getActiveEditPanel().getValue() != r5.getEditPanel()) goto L48;
            c.c(DocToolbarV2JsHandlerPlugin.access$600(this.a));
        L48:
            r5.handle(null, r13);
            goto L22
        L71:
            return;
        L70:
            return;
        L5:
            tt5.a.h(DocToolbarV2JsHandlerPlugin.TAG, "[ToolbarV2]= null");
            goto L6
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocToolbarV2JsHandlerPlugin() {
        this.jsHandlers = new ArrayList();
        this.mSyncedBlockEnable = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.docs.all.synced_block_enable");
    }

    public static /* synthetic */ DocViewModel access$100(DocToolbarV2JsHandlerPlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ boolean access$200(DocToolbarV2JsHandlerPlugin r0) {
        return r0.mSyncedBlockEnable;
    }

    public static /* synthetic */ List access$400(DocToolbarV2JsHandlerPlugin r0) {
        return r0.jsHandlers;
    }

    public static /* synthetic */ EditPanelsManager access$500(DocToolbarV2JsHandlerPlugin r0) {
        return r0.editPanelsManager;
    }

    public static /* synthetic */ Context access$600(DocToolbarV2JsHandlerPlugin r0) {
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

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        this.editPanelsManager = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
        getBridge().c("biz.navigation.setDocToolbarV2", new a(this));
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

    public static /* synthetic */ boolean access$300(DocToolbarV2JsHandlerPlugin r0, JSONObject r1) {
        return r0.isEmptyData(r1);
    }
}
