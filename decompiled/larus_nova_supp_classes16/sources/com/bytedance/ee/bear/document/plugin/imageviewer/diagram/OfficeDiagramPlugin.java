package com.bytedance.ee.bear.document.plugin.imageviewer.diagram;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.imageviewer.plugin.BaseDiagramPlugin;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$Base64Data;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$SVGData;
import com.bytedance.ee.bear.imageviewer.i3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/imageviewer/diagram/OfficeDiagramPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/contract/imageviewer/plugin/BaseDiagramPlugin;", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "<init>", "()V", "mDiagramViewModel", "Lcom/bytedance/ee/bear/document/plugin/imageviewer/diagram/OfficeDiagramViewModel;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "registerDiagramBase64DataRequestListener", "listener", "Lcom/bytedance/ee/bear/contract/imageviewer/delegate/DiagramDataDelegate$DiagramBase64DataRequestListener;", "requestDiagramSVGData", "uuid", "index", "", "Lcom/bytedance/ee/bear/contract/imageviewer/delegate/DiagramDataDelegate$DiagramSVGDataRequestListener;", "unregisterDiagramBase64DataRequestListener", "Companion", "DiagramBase64DataHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDiagramPlugin extends DocumentPluginV3 implements BaseDiagramPlugin<ChameleonPluginHost> {
    public static final a Companion = null;
    private static final String REQUEST_DIAGRAM_SVG_DATA = "window.lark.biz.util.requestDiagramSVGData";
    private static final String SEND_DIAGRAM_BASE64_DATA = "biz.util.sendDiagramBase64Data";
    private static final String TAG = "DiagramPlugin";
    private OfficeDiagramViewModel mDiagramViewModel;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<DiagramData$Base64Data> {
        public final /* synthetic */ OfficeDiagramPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeDiagramPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            DiagramData$Base64Data r5 = (DiagramData$Base64Data) r3;
            StringBuilder r6 = new StringBuilder("JS send diagram base64 data, uuid = ");
            String r0 = null;
            if (r5 == null) goto L5;
            String r1 = r5.getUuid();
        L6:
            r6.append(du5.b.k(r1));
            r6.append(" , result = ");
            if (r5 == null) goto L9;
            String r2 = r5.getResult();
        L10:
            r6.append(r2);
            tt5.a.h(OfficeDiagramPlugin.TAG, r6.toString());
            OfficeDiagramViewModel r7 = OfficeDiagramPlugin.access$getMDiagramViewModel$p(this.a);
            if (r7 == null) goto L19;
            if (r5 == null) goto L14;
            String r8 = r5.getUuid();
        L15:
            if (r5 == null) goto L17;
            r0 = r5.getBase64String();
        L17:
            r7.notifyDiagramBase64DataResult(r8, r0);
            return;
        L14:
            r8 = null;
            goto L15
        L19:
            return;
        L9:
            r2 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class c implements OfficeDiagramViewModel.a {
        public final /* synthetic */ OfficeDiagramPlugin a;

        public static final class a implements m {
            public final /* synthetic */ tw4.a.b a;

            @Override // tb5.m
            public final void a(NonProguard r1) {
            }

            @Override // tb5.m
            public final void b(JSONObject r1) {
            }

            @Override // tb5.m
            public final void onCallBack(String r3) {
                DiagramData$SVGData r4 = (DiagramData$SVGData) JSON.parseObject(r3, DiagramData$SVGData.class);     // Catch: Exception -> L10
                if (TextUtils.equals(r4.getResult(), DiagramData$RESULT.SUCCESS) == true) goto L5;
                return;
            L5:
                if (TextUtils.isEmpty(r4.getSvgString()) == true) goto L16;
                tw4.a.b r0 = this.a;     // Catch: Exception -> L10
                if (r0 == null) goto L17;
                ((i3) r0).a(r4.getSvgString());     // Catch: Exception -> L10
                return;
            L17:
                return;
            L16:
                return;
            L10:
                e = move-exception;
                tt5.a.d(OfficeDiagramPlugin.TAG, "parse SVGData failed: " + e.getMessage());
            }

            public a(tw4.a.b r1, String r2) {
                this.a = r1;
            }
        }

        public c(OfficeDiagramPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.plugin.imageviewer.diagram.OfficeDiagramViewModel.a
        public final void a(String r3, int r4, tw4.a.b r5) {
            tt5.a.h(OfficeDiagramPlugin.TAG, "request diagram svg data, uuid = " + du5.b.k(r3));
            JSONObject r0 = new JSONObject();
            r0.put("uuid", r3);
            r0.put("index", Integer.valueOf(r4));
            ((e4) this.a.getHostAbility(e4.class)).getBridge().a(OfficeDiagramPlugin.REQUEST_DIAGRAM_SVG_DATA, r0, new a(r5, r3));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.plugin.BaseDiagramPlugin
    public void unregisterDiagramBase64DataRequestListener() {
        OfficeDiagramViewModel r0 = this.mDiagramViewModel;
        if (r0 == null) goto L6;
        r0.unregisterDiagramBase64DataRequestListener();
        return;
    }

    public OfficeDiagramPlugin() {
    }

    public static final /* synthetic */ OfficeDiagramViewModel access$getMDiagramViewModel$p(OfficeDiagramPlugin r0) {
        return r0.mDiagramViewModel;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(SEND_DIAGRAM_BASE64_DATA, new b(this));
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.plugin.BaseDiagramPlugin
    public void registerDiagramBase64DataRequestListener(tw4.a.InterfaceC0300a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        OfficeDiagramViewModel r0 = this.mDiagramViewModel;
        if (r0 == null) goto L6;
        r0.registerDiagramBase64DataRequestListener(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        OfficeDiagramViewModel r3 = (OfficeDiagramViewModel) viewModel(OfficeDiagramViewModel.class);
        this.mDiagramViewModel = r3;
        if (r3 == null) goto L6;
        r3.setDelegate(new c(this));
        return;
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        OfficeDiagramViewModel r3 = this.mDiagramViewModel;
        if (r3 == null) goto L6;
        r3.setDelegate(null);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.plugin.BaseDiagramPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.plugin.BaseDiagramPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.plugin.BaseDiagramPlugin
    public void requestDiagramSVGData(String r2, int r3, tw4.a.b r4) {
        OfficeDiagramViewModel r0 = this.mDiagramViewModel;
        if (r0 == null) goto L6;
        r0.requestDiagramSVGData(r2, r3, r4);
        return;
    }
}
