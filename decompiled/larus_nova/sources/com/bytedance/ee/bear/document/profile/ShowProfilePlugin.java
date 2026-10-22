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

/* JADX INFO: loaded from: classes16.dex */
public class ShowProfilePlugin extends DocumentPluginV2 {
    private static final String CANCEL = "cancel";
    private static final String CONFIRM = "confirm";
    private static final int RATE_LIMIT_INTERVAL_MILLIS = 1000;
    private static final int REQUEST_CODE = 11011;
    private static final String TAG = "ShowProfilePlugin";
    private long lastTimeShowProfile;

    public class a implements i<ProfileModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShowProfilePlugin f221226a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(ShowProfilePlugin r100) {
            this.f221226a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            ProfileModel r112 = (ProfileModel) r110;
            tt5.a.b("ShowProfilePlugin", "ShowHalfProfileHandler handle()... data = " + r112);
            if (ShowProfilePlugin.access$400(this.f221226a) == false) goto L6;
            tt5.a.k("ShowProfilePlugin", "ShowHalfProfileHandler, isUIContainerDetached == true");
            return;
        L6:
            if (AppInfoUtils.e().booleanValue() == false) goto L9;
            tt5.a.h("ShowProfilePlugin", "ShowHalfProfileHandler, isMempopeApp is true, return");
            return;
        L9:
            if (ShowProfilePlugin.access$200(this.f221226a) == false) goto L11;
            tt5.a.h("ShowProfilePlugin", "ShowHalfProfileHandler, shouldLimit is true");
            return;
        L11:
            BaseUnspecifiedOrientationPlugin r100 = (BaseUnspecifiedOrientationPlugin) ShowProfilePlugin.access$500(this.f221226a, BaseUnspecifiedOrientationPlugin.class);
            if (r100 != null) goto L14;
        L22:
            if (r112 != null) goto L24;
            return;
        L24:
            if (TextUtils.isEmpty(r112.getUserId()) == true) goto L34;
            com.bytedance.ee.bear.document.profile.b r101 = new com.bytedance.ee.bear.document.profile.b(this, r111);
            if (ForsetiHelper.s(this.f221226a.getHost().getHostFragment()) == false) goto L28;
            ((c0) org.koin.java.a.a(c0.class)).D1(this.f221226a.getHost().getHostFragment(), this.f221226a.getHost().getUserComponent().b(), r112.getUserId(), this.f221226a.getEditorAbility().getDocumentMetadata().getDocName().getValue(), r112.getContent(), r112.getConfirmText(), r101);
            return;
        L28:
            ((c0) org.koin.java.a.a(c0.class)).Wb(ShowProfilePlugin.access$1100(this.f221226a), ShowProfilePlugin.access$1200(this.f221226a), this.f221226a.getHost().getUserComponent().b(), r112.getUserId(), this.f221226a.getEditorAbility().getDocumentMetadata().getDocName().getValue(), r112.getContent(), r112.getConfirmText(), r101);
            return;
        L34:
            return;
        L14:
            if (ForsetiHelper.s(this.f221226a.getHost().getHostFragment()) == true) goto L22;
            if (c.k(ShowProfilePlugin.access$600(this.f221226a)) == true) goto L18;
        L21:
            r100.forcePortrait();
            goto L22
        L18:
            if (cu5.c.e(ShowProfilePlugin.access$700(this.f221226a)) == false) goto L21;
            if (c.l() == true) goto L22;
            goto L21
        }
    }

    public class b implements i<ProfileModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShowProfilePlugin f221227a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(ShowProfilePlugin r100) {
            this.f221227a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            ProfileModel r102 = (ProfileModel) r100;
            tt5.a.b("ShowProfilePlugin", "handle()... data = " + r102);
            if (ShowProfilePlugin.access$200(this.f221227a) == false) goto L5;
            tt5.a.h("ShowProfilePlugin", "ShowProfileHandler, shouldLimit is true");
            return;
        L5:
            if (r102 != null) goto L7;
            return;
        L7:
            if (TextUtils.isEmpty(r102.getUserId()) == true) goto L12;
            ShowProfilePlugin.access$300(this.f221227a, r102.getUserId());
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
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

    public static /* synthetic */ boolean access$1000(ShowProfilePlugin r100) {
        return r100.isUIContainerAttached();
    }

    public static /* synthetic */ FragmentActivity access$1100(ShowProfilePlugin r100) {
        return r100.getActivity();
    }

    public static /* synthetic */ FragmentManager access$1200(ShowProfilePlugin r100) {
        return r100.getFragmentManager();
    }

    public static /* synthetic */ boolean access$200(ShowProfilePlugin r100) {
        return r100.shouldLimit();
    }

    public static /* synthetic */ boolean access$400(ShowProfilePlugin r100) {
        return r100.isUIContainerDetached();
    }

    public static /* synthetic */ Context access$600(ShowProfilePlugin r100) {
        return r100.getContext();
    }

    public static /* synthetic */ Context access$700(ShowProfilePlugin r100) {
        return r100.getContext();
    }

    public static /* synthetic */ boolean access$800(ShowProfilePlugin r100) {
        return r100.isUIContainerAttached();
    }

    private void showProfile(String r100) {
        ((k) org.koin.java.a.a(k.class)).e(r100, getEditorAbility().getDocumentMetadata().getDocName().getValue());
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        r100.put("biz.util.showProfile", new b(this));
        r100.put("biz.util.inviteNoPermUserProfile", new a(this));
    }

    public static /* synthetic */ void access$300(ShowProfilePlugin r100, String r101) {
        r100.showProfile(r101);
    }

    public static /* synthetic */ f access$500(ShowProfilePlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }
}
