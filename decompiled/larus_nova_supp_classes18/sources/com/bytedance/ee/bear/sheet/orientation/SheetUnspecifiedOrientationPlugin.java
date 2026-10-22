package com.bytedance.ee.bear.sheet.orientation;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.ee.bear.bitable.plugin.BitableSubFragmentPlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.DocsUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.OrientationViewModel;
import com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import ku5.c;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetUnspecifiedOrientationPlugin extends DocsUnspecifiedOrientationPlugin {
    private static final int MAX_SHOW_COUNT = 3;
    private static final String SP_KEY = "show_count";
    private static final String SP_NAME = "sheet_enter_landscape_tip";
    private static final String TOGGLE_DEVICE_ORIENTATION = "biz.bitable.toggleDeviceOrientation";
    private qm5.a mAnalytic;

    public class a implements DocsUnspecifiedOrientationPlugin.e {
        public final /* synthetic */ SheetUnspecifiedOrientationPlugin a;

        public final void a() {
            SheetUnspecifiedOrientationPlugin.access$000(this.a).b("show_landscape_btn");
        }

        public final void b() {
            SheetUnspecifiedOrientationPlugin.access$200(this.a).setSource("sheet_m_landscape_button");
        }

        public final void c() {
            SheetUnspecifiedOrientationPlugin.access$100(this.a).setSource("sheet_m_portrait_button");
        }

        public final void d() {
            SheetUnspecifiedOrientationPlugin.access$300(this.a).setSource("mobile_rotation");
        }

        public final void e() {
            SheetUnspecifiedOrientationPlugin.access$000(this.a).b("show_portrait_btn");
        }

        public a(SheetUnspecifiedOrientationPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements i<Void> {
        public final /* synthetic */ SheetUnspecifiedOrientationPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SheetUnspecifiedOrientationPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            this.a.toggleDeviceOrientation();
        }
    }

    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    public boolean canShowTips() {
        BitableSubFragmentPlugin r0 = findPlugin(BitableSubFragmentPlugin.class);
        if (r0 != null) goto L5;
        return true;
    L5:
        return !r0.isInDocXMode();
    }

    public void toggleDeviceOrientation() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        Resources r1 = r0.getResources();
        if (r1 != null) goto L8;
        return;
    L8:
        Configuration r2 = r1.getConfiguration();
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.orientation != 1) goto L14;
        forceLandscape();
        return;
    L14:
        forcePortrait();
    }

    public SheetUnspecifiedOrientationPlugin() {
    }

    public static /* synthetic */ qm5.a access$000(SheetUnspecifiedOrientationPlugin r0) {
        return r0.mAnalytic;
    }

    public static /* synthetic */ OrientationViewModel access$100(SheetUnspecifiedOrientationPlugin r0) {
        return ((UnspecifiedOrientationPlugin) r0).mOrientationViewModel;
    }

    public static /* synthetic */ OrientationViewModel access$200(SheetUnspecifiedOrientationPlugin r0) {
        return ((UnspecifiedOrientationPlugin) r0).mOrientationViewModel;
    }

    public static /* synthetic */ OrientationViewModel access$300(SheetUnspecifiedOrientationPlugin r0) {
        return ((UnspecifiedOrientationPlugin) r0).mOrientationViewModel;
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super.onAttachToHost(r2);
        qm5.a r3 = new qm5.a();
        this.mAnalytic = r3;
        r3.a = getDocViewModel().getBearUrl();
        setIOrientationEvent(new a(this));
        bindBridgeHandler(TOGGLE_DEVICE_ORIENTATION, new b(this));
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
        onAttachToHost((DocumentPluginHost) r1);
    }
}
