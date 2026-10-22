package com.bytedance.ee.bear.orientation;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.DocsUnspecifiedOrientationPlugin;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocUnspecifiedOrientationPlugin extends DocsUnspecifiedOrientationPlugin {
    private d mAnalyticService;
    private DocOrientationAnalytic mDocOrientationAnalytic;
    private boolean mIsManualSwitchToLandscape;
    private boolean mIsManualSwitchToPotrait;

    public class a extends DocsUnspecifiedOrientationPlugin.d {
        public final /* synthetic */ DocUnspecifiedOrientationPlugin a;

        public final void b() {
            DocUnspecifiedOrientationPlugin.access$002(this.a, true);
        }

        public final void c() {
            DocUnspecifiedOrientationPlugin.access$102(this.a, true);
        }

        public a(DocUnspecifiedOrientationPlugin r1) {
            this.a = r1;
        }
    }

    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    public DocUnspecifiedOrientationPlugin() {
    }

    public void onAttachToHost(DocumentPluginHost r1) {
        super.onAttachToHost(r1);
        this.mDocOrientationAnalytic = new DocOrientationAnalytic();
        this.mAnalyticService = (d) org.koin.java.a.a(d.class);
        setIOrientationEvent(new a(this));
    }

    public void onConfigurationChanged(Configuration r6) {
        super.onConfigurationChanged(r6);
        d r0 = this.mAnalyticService;
        if (r0 == null) goto L5;
        HashMap r1 = r0.m("docCommonParams");
    L6:
        boolean r2 = getHost().a().isAnnounceDoc();
        int r7 = r6.orientation;
        if (r7 != 2) goto L13;
        if (this.mIsManualSwitchToLandscape == false) goto L11;
        DocOrientationAnalytic r8 = this.mDocOrientationAnalytic;
        String r4 = DocOrientationAnalytic.ActionType.HORIZONTAL_SCREEN.getActionType();
        r8.getClass();
        DocOrientationAnalytic.a("ccm_doc_mobile_switch_horizontal_click", r4, r1, r2);
        this.mIsManualSwitchToLandscape = false;
        return;
    L11:
        DocOrientationAnalytic r9 = this.mDocOrientationAnalytic;
        String r3 = DocOrientationAnalytic.ActionType.SYSTEM_AUTO_MATIC.getActionType();
        r9.getClass();
        DocOrientationAnalytic.a("ccm_doc_mobile_switch_horizontal_click", r3, r1, r2);
        return;
    L13:
        if (r7 == 1) goto L15;
        return;
    L15:
        if (this.mIsManualSwitchToPotrait == false) goto L18;
        DocOrientationAnalytic r10 = this.mDocOrientationAnalytic;
        String r5 = DocOrientationAnalytic.ActionType.VERTICAL_SCREEN.getActionType();
        String r11 = DocOrientationAnalytic.ButtonLocation.FLOAT.getLocation();
        r10.getClass();
        DocOrientationAnalytic.b(r5, r11, r1, r2);
        this.mIsManualSwitchToPotrait = false;
    L23:
        setSwitchToPortraitByWeb(false);
        return;
    L18:
        if (getSwitchToPortraitByWeb() == true) goto L21;
        DocOrientationAnalytic r12 = this.mDocOrientationAnalytic;
        String r13 = DocOrientationAnalytic.ActionType.SYSTEM_AUTO_MATIC.getActionType();
        r12.getClass();
        DocOrientationAnalytic.a("ccm_doc_mobile_switch_vertical_click", r13, r1, r2);
        goto L23
    L21:
        if (getSwitchToPortraitByWeb() == false) goto L23;
        DocOrientationAnalytic r14 = this.mDocOrientationAnalytic;
        String r15 = DocOrientationAnalytic.ActionType.VERTICAL_SCREEN.getActionType();
        String r16 = DocOrientationAnalytic.ButtonLocation.TOP_BAR.getLocation();
        r14.getClass();
        DocOrientationAnalytic.b(r15, r16, r1, r2);
        goto L23
    L5:
        r1 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ boolean access$002(DocUnspecifiedOrientationPlugin r0, boolean r1) {
        r0.mIsManualSwitchToLandscape = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$102(DocUnspecifiedOrientationPlugin r0, boolean r1) {
        r0.mIsManualSwitchToPotrait = r1;
        return r1;
    }
}
