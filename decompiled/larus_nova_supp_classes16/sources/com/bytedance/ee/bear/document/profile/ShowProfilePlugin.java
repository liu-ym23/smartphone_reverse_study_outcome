package com.bytedance.ee.bear.document.profile;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.lark.dependency.c0;
import com.bytedance.ee.util.info.AppInfoUtils;
import java.util.Map;
import ku5.c;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ShowProfilePlugin extends DocumentPluginV2 {
    private static final String CANCEL = "cancel";
    private static final String CONFIRM = "confirm";
    private static final int RATE_LIMIT_INTERVAL_MILLIS = 1000;
    private static final int REQUEST_CODE = 11011;
    private static final String TAG = "ShowProfilePlugin";
    private long lastTimeShowProfile;

    public class a implements i<ProfileModel> {
        public final /* synthetic */ ShowProfilePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(ShowProfilePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r11, m r12) {
            ProfileModel r13 = (ProfileModel) r11;
            tt5.a.b(ShowProfilePlugin.TAG, "ShowHalfProfileHandler handle()... data = " + r13);
            if (ShowProfilePlugin.access$400(this.a) == false) goto L6;
            tt5.a.k(ShowProfilePlugin.TAG, "ShowHalfProfileHandler, isUIContainerDetached == true");
            return;
        L6:
            if (AppInfoUtils.e().booleanValue() == false) goto L9;
            tt5.a.h(ShowProfilePlugin.TAG, "ShowHalfProfileHandler, isMempopeApp is true, return");
            return;
        L9:
            if (ShowProfilePlugin.access$200(this.a) == false) goto L11;
            tt5.a.h(ShowProfilePlugin.TAG, "ShowHalfProfileHandler, shouldLimit is true");
            return;
        L11:
            BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) ShowProfilePlugin.access$500(this.a, BaseUnspecifiedOrientationPlugin.class);
            if (r0 != null) goto L14;
        L22:
            if (r13 != null) goto L24;
            return;
        L24:
            if (TextUtils.isEmpty(r13.getUserId()) == true) goto L34;
            com.bytedance.ee.bear.document.profile.b r9 = new com.bytedance.ee.bear.document.profile.b(this, r12);
            if (ForsetiHelper.s(this.a.getHost().getHostFragment()) == false) goto L28;
            ((c0) org.koin.java.a.a(c0.class)).D1(this.a.getHost().getHostFragment(), this.a.getHost().getUserComponent().b(), r13.getUserId(), (String) this.a.getEditorAbility().getDocumentMetadata().getDocName().getValue(), r13.getContent(), r13.getConfirmText(), r9);
            return;
        L28:
            ((c0) org.koin.java.a.a(c0.class)).Wb(ShowProfilePlugin.access$1100(this.a), ShowProfilePlugin.access$1200(this.a), this.a.getHost().getUserComponent().b(), r13.getUserId(), (String) this.a.getEditorAbility().getDocumentMetadata().getDocName().getValue(), r13.getContent(), r13.getConfirmText(), r9);
            return;
        L34:
            return;
        L14:
            if (ForsetiHelper.s(this.a.getHost().getHostFragment()) == true) goto L22;
            if (c.k(ShowProfilePlugin.access$600(this.a)) == true) goto L18;
        L21:
            r0.forcePortrait();
            goto L22
        L18:
            if (cu5.c.e(ShowProfilePlugin.access$700(this.a)) == false) goto L21;
            if (c.l() == true) goto L22;
            goto L21
        }
    }

    public class b implements i<ProfileModel> {
        public final /* synthetic */ ShowProfilePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(ShowProfilePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            ProfileModel r4 = (ProfileModel) r2;
            tt5.a.b(ShowProfilePlugin.TAG, "handle()... data = " + r4);
            if (ShowProfilePlugin.access$200(this.a) == false) goto L5;
            tt5.a.h(ShowProfilePlugin.TAG, "ShowProfileHandler, shouldLimit is true");
            return;
        L5:
            if (r4 != null) goto L7;
            return;
        L7:
            if (TextUtils.isEmpty(r4.getUserId()) == true) goto L12;
            ShowProfilePlugin.access$300(this.a, r4.getUserId());
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ShowProfilePlugin() {
        this.lastTimeShowProfile = -1;
    }

    private boolean shouldLimit() {
        if ((System.currentTimeMillis() - this.lastTimeShowProfile) <= 1000) goto L6;
        this.lastTimeShowProfile = System.currentTimeMillis();
        return false;
    L6:
        return true;
    }

    public static /* synthetic */ boolean access$1000(ShowProfilePlugin r0) {
        return r0.isUIContainerAttached();
    }

    public static /* synthetic */ FragmentActivity access$1100(ShowProfilePlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ FragmentManager access$1200(ShowProfilePlugin r0) {
        return r0.getFragmentManager();
    }

    public static /* synthetic */ boolean access$200(ShowProfilePlugin r0) {
        return r0.shouldLimit();
    }

    public static /* synthetic */ boolean access$400(ShowProfilePlugin r0) {
        return r0.isUIContainerDetached();
    }

    public static /* synthetic */ Context access$600(ShowProfilePlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ Context access$700(ShowProfilePlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ boolean access$800(ShowProfilePlugin r0) {
        return r0.isUIContainerAttached();
    }

    private void showProfile(String r3) {
        ((k) org.koin.java.a.a(k.class)).e(r3, (CharSequence) getEditorAbility().getDocumentMetadata().getDocName().getValue());
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.util.showProfile", new b(this));
        r3.put("biz.util.inviteNoPermUserProfile", new a(this));
    }

    public static /* synthetic */ void access$300(ShowProfilePlugin r0, String r1) {
        r0.showProfile(r1);
    }

    public static /* synthetic */ f access$500(ShowProfilePlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }
}
