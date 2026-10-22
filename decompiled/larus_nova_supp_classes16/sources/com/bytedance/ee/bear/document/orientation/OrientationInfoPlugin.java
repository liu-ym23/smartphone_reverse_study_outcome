package com.bytedance.ee.bear.document.orientation;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OrientationInfoPlugin extends DocumentPlugin {
    private static final String GET_ORIENTATION_STATE = "biz.orientation.getStatus";
    private static final String NOTIFY_ORIENTATION_CHANGE = "window.lark.biz.orientation.onSwitch";
    private static final String SET_ORIENTATION = "biz.orientation.setOrientation";
    private static final String TAG = "OrientationInfoPlugin";
    private a mJSBinder;
    private h mOrientationController;
    private b mSetOrientationBinder;

    public static class SetOrientationData implements NonProguard {
        private String orientation;

        public SetOrientationData() {
        }

        public String toString() {
            return "SetOrientationData{orientation='" + this.orientation + "'}";
        }

        public String getOrientation() {
            return this.orientation;
        }

        public void setOrientation(String r1) {
            this.orientation = r1;
        }
    }

    public class a implements tb5.h {
        public final /* synthetic */ OrientationInfoPlugin a;

        @Override // tb5.h, tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
        }

        public a(OrientationInfoPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.h, tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            if (OrientationInfoPlugin.access$100(this.a).getConfiguration().orientation != 2) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == false) goto L8;
            OrientationEnum r5 = OrientationEnum.LANDSCAPE;
        L9:
            r3.b(r5.toJsonObject());
            return;
        L8:
            r5 = OrientationEnum.PORTRAIT;
            goto L9
        L5:
            r4 = false;
            goto L6
        }
    }

    public class b implements tb5.i<SetOrientationData> {
        public final /* synthetic */ OrientationInfoPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OrientationInfoPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r7, tb5.m r8) {
            SetOrientationData r9 = (SetOrientationData) r7;
            tt5.a.h(OrientationInfoPlugin.TAG, "SetOrientationHandler handle: " + r9);
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.slides.presentation_enable") == true) goto L5;
            tt5.a.h(OrientationInfoPlugin.TAG, "SetOrientationHandler handle: ccm.slides.presentation_enable fg is false");
            return;
        L5:
            if (r9 != null) goto L8;
            tt5.a.d(OrientationInfoPlugin.TAG, "data is null");
            return;
        L8:
            if (r9.getOrientation() != null) goto L10;
            tt5.a.d(OrientationInfoPlugin.TAG, "orientation is null");
            return;
        L10:
            String r10 = r9.getOrientation();
            r10.getClass();
            int r11 = r10.hashCode();
            int r2 = -1;
            if (r11 == 3005871) goto L26;
            if (r11 == 729267099) goto L22;
            if (r11 == 1430647483) goto L18;
        L27:
            byte r12 = -1;
        L29:
            if (r12 == 0) goto L35;
            if (r12 == 1) goto L34;
            if (r12 == 2) goto L33;
            tt5.a.d(OrientationInfoPlugin.TAG, "invalid orientation: ".concat(r10));
            return;
        L33:
            OrientationInfoPlugin.access$300(this.a).b(0);
            r2 = 0;
        L36:
            BaseUnspecifiedOrientationPlugin r13 = (BaseUnspecifiedOrientationPlugin) OrientationInfoPlugin.access$400(this.a, BaseUnspecifiedOrientationPlugin.class);
            if (r13 == null) goto L46;
            OrientationViewModel r14 = r13.getOrientationViewModel();
            if (r14 == null) goto L47;
            r14.setRequestOrientation(r2);
            tt5.a.h(OrientationInfoPlugin.TAG, "Updated OrientationViewModel requestOrientation to: " + r2);
            return;
        L47:
            return;
        L46:
            return;
        L34:
            OrientationInfoPlugin.access$300(this.a).b(1);
            r2 = 1;
            goto L36
        L35:
            OrientationInfoPlugin.access$300(this.a).b(-1);
            goto L36
        L18:
            if (r10.equals("landscape") == false) goto L27;
            r12 = 2;
            goto L29
        L22:
            if (r10.equals("portrait") == false) goto L27;
            r12 = 1;
            goto L29
        L26:
            if (r10.equals("auto") == false) goto L27;
            r12 = 0;
            goto L29
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OrientationInfoPlugin() {
    }

    public static /* synthetic */ Resources access$100(OrientationInfoPlugin r0) {
        return r0.getResources();
    }

    public static /* synthetic */ vv4.k access$200(OrientationInfoPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ h access$300(OrientationInfoPlugin r0) {
        return r0.mOrientationController;
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super.onAttachToHost(r2);
        this.mOrientationController = new h(r2);
        this.mJSBinder = new a(this);
        this.mSetOrientationBinder = new b(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r7) {
        super.onConfigurationChanged(r7);
        vv4.k r0 = access$200(this.mJSBinder.a);
        boolean r1 = true;
        if (r0 != null) goto L5;
    L12:
        DocViewModel r2 = getDocViewModel();
        if (r2 != null) goto L15;
    L17:
        r1 = false;
    L18:
        pcb.a.a.b(getActivity()).onConfigurationChanged(r7, r1);
        return;
    L15:
        if (r2.getOpenSource() != DocsOpenSource.vc) goto L17;
    L5:
        if (r7.orientation != 2) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        OrientationEnum r4 = OrientationEnum.LANDSCAPE;
    L11:
        JSONObject r5 = r4.toJsonObject();
        tt5.a.h(TAG, "notifyOrientationChange: " + r5.toJSONString());
        r0.j(NOTIFY_ORIENTATION_CHANGE, r5);
        goto L12
    L10:
        r4 = OrientationEnum.PORTRAIT;
        goto L11
    L7:
        r3 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$400(OrientationInfoPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        bindBridgeHandler(GET_ORIENTATION_STATE, this.mJSBinder);
        bindBridgeHandler(SET_ORIENTATION, this.mSetOrientationBinder);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
