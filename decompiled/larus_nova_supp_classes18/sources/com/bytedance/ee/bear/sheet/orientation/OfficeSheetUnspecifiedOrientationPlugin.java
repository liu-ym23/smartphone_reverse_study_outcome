package com.bytedance.ee.bear.sheet.orientation;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.orientation.OfficeDocsUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.OrientationViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import ku5.c;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeSheetUnspecifiedOrientationPlugin extends OfficeDocsUnspecifiedOrientationPlugin {
    private static final int MAX_SHOW_COUNT = 3;
    private static final String SP_KEY = "show_count";
    private static final String SP_NAME = "sheet_enter_landscape_tip";
    private static final String TOGGLE_DEVICE_ORIENTATION = "biz.bitable.toggleDeviceOrientation";
    private on5.a mAnalytic;

    public class a implements OfficeDocsUnspecifiedOrientationPlugin.d {
        public final /* synthetic */ OfficeSheetUnspecifiedOrientationPlugin a;

        public a(OfficeSheetUnspecifiedOrientationPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements i<Void> {
        public final /* synthetic */ OfficeSheetUnspecifiedOrientationPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(OfficeSheetUnspecifiedOrientationPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            Context r4 = OfficeSheetUnspecifiedOrientationPlugin.access$400(this.a);
            if (r4 == null) goto L17;
            Resources r5 = r4.getResources();
            if (r5 == null) goto L18;
            Configuration r6 = r5.getConfiguration();
            if (r6 != null) goto L12;
            return;
        L12:
            if (r6.orientation != 1) goto L14;
            this.a.forceLandscape();
            return;
        L14:
            this.a.forcePortrait();
            return;
        L18:
            return;
        }
    }

    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    public boolean canShowTips() {
        return super.canShowTips();
    }

    public OfficeSheetUnspecifiedOrientationPlugin() {
    }

    public static /* synthetic */ on5.a access$000(OfficeSheetUnspecifiedOrientationPlugin r0) {
        return r0.mAnalytic;
    }

    public static /* synthetic */ OrientationViewModel access$100(OfficeSheetUnspecifiedOrientationPlugin r0) {
        return ((OfficeUnspecifiedOrientationPlugin) r0).mOrientationViewModel;
    }

    public static /* synthetic */ OrientationViewModel access$200(OfficeSheetUnspecifiedOrientationPlugin r0) {
        return ((OfficeUnspecifiedOrientationPlugin) r0).mOrientationViewModel;
    }

    public static /* synthetic */ OrientationViewModel access$300(OfficeSheetUnspecifiedOrientationPlugin r0) {
        return ((OfficeUnspecifiedOrientationPlugin) r0).mOrientationViewModel;
    }

    public static /* synthetic */ Context access$400(OfficeSheetUnspecifiedOrientationPlugin r0) {
        return r0.getContext();
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(TOGGLE_DEVICE_ORIENTATION, new b(this));
    }

    public void onAttachToHost(ChameleonPluginHost r2) {
        super.onAttachToHost(r2);
        on5.a r3 = new on5.a();
        this.mAnalytic = r3;
        r3.a = getDocViewModel().getBearUrl();
        setIOrientationEvent(new a(this));
    }

    public void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        if (r4.orientation == 2) goto L5;
        return;
    L5:
        if (c.k(getContext()) == true) goto L11;
        ml5.b r5 = new ml5.b(SP_NAME);
        int r0 = r5.a.getInt(SP_KEY, 0);
        if (r0 >= 3) goto L12;
        r5.b(SP_KEY, Integer.valueOf(r0 + 1));
        Toast.showText(getContext(), getResources().getString(2131888267));
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
