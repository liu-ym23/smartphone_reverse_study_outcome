package com.bytedance.ee.bear.document.profile;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.lark.dependency.c0;
import com.bytedance.ee.util.info.AppInfoUtils;
import java.util.Map;
import ku5.c;
import org.json.JSONException;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public class OfficeShowProfilePlugin extends DocumentPluginV3 {
    private static final String CANCEL = "cancel";
    private static final String CONFIRM = "confirm";
    private static final int RATE_LIMIT_INTERVAL_MILLIS = 1000;
    private static final String TAG = "OfficeShowProfilePlugin";
    private long lastTimeShowProfile;

    public class a implements i<ProfileModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeShowProfilePlugin f221224a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficeShowProfilePlugin r100) {
            this.f221224a = r100;
        }

        public static String a(a r100, String r101) {
            r100.getClass();
            JSONObject r102 = new JSONObject();     // Catch: JSONException -> L5
            r102.put("id", r101);     // Catch: JSONException -> L5
            return r102.toString();
        L5:
            e = move-exception;
            tt5.a.e(OfficeShowProfilePlugin.TAG, "getResult failed", e, false);
            return SliceInitService.DEFAULT_SWITCH;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            ProfileModel r112 = (ProfileModel) r110;
            tt5.a.b(OfficeShowProfilePlugin.TAG, "ShowHalfProfileHandler handle()... data = " + r112);
            if (OfficeShowProfilePlugin.access$400(this.f221224a) == false) goto L6;
            tt5.a.k(OfficeShowProfilePlugin.TAG, "ShowHalfProfileHandler, isUIContainerDetached == true");
            return;
        L6:
            if (AppInfoUtils.e().booleanValue() == false) goto L9;
            tt5.a.h(OfficeShowProfilePlugin.TAG, "ShowHalfProfileHandler, isMempopeApp is true, return");
            return;
        L9:
            if (OfficeShowProfilePlugin.access$200(this.f221224a) == false) goto L11;
            tt5.a.h(OfficeShowProfilePlugin.TAG, "ShowHalfProfileHandler, shouldLimit is true");
            return;
        L11:
            BaseUnspecifiedOrientationPlugin r100 = (BaseUnspecifiedOrientationPlugin) OfficeShowProfilePlugin.access$500(this.f221224a, BaseUnspecifiedOrientationPlugin.class);
            if (r100 != null) goto L14;
        L22:
            if (r112 != null) goto L24;
            return;
        L24:
            if (TextUtils.isEmpty(r112.getUserId()) == true) goto L34;
            com.bytedance.ee.bear.document.profile.a r101 = new com.bytedance.ee.bear.document.profile.a(this, r111);
            if (ForsetiHelper.s(this.f221224a.getHost().getHostFragment()) == false) goto L28;
            ((c0) org.koin.java.a.a(c0.class)).D1(this.f221224a.getHost().getHostFragment(), this.f221224a.getHost().getUserComponent().b(), r112.getUserId(), this.f221224a.getDocumentMetadata().getDocName().getValue(), r112.getContent(), r112.getConfirmText(), r101);
            return;
        L28:
            ((c0) org.koin.java.a.a(c0.class)).Wb(OfficeShowProfilePlugin.access$1100(this.f221224a), OfficeShowProfilePlugin.access$1200(this.f221224a), this.f221224a.getHost().getUserComponent().b(), r112.getUserId(), this.f221224a.getDocumentMetadata().getDocName().getValue(), r112.getContent(), r112.getConfirmText(), r101);
            return;
        L34:
            return;
        L14:
            if (ForsetiHelper.s(this.f221224a.getHost().getHostFragment()) == true) goto L22;
            if (c.k(OfficeShowProfilePlugin.access$600(this.f221224a)) == true) goto L18;
        L21:
            r100.forcePortrait();
            goto L22
        L18:
            if (cu5.c.e(OfficeShowProfilePlugin.access$700(this.f221224a)) == false) goto L21;
            if (c.l() == true) goto L22;
            goto L21
        }
    }

    public class b implements i<ProfileModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeShowProfilePlugin f221225a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeShowProfilePlugin r100) {
            this.f221225a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            ProfileModel r102 = (ProfileModel) r100;
            tt5.a.b(OfficeShowProfilePlugin.TAG, "handle()... data = " + r102);
            if (OfficeShowProfilePlugin.access$200(this.f221225a) == false) goto L5;
            tt5.a.h(OfficeShowProfilePlugin.TAG, "ShowProfileHandler, shouldLimit is true");
            return;
        L5:
            if (r102 != null) goto L7;
            return;
        L7:
            if (TextUtils.isEmpty(r102.getUserId()) == true) goto L12;
            OfficeShowProfilePlugin.access$300(this.f221225a, r102.getUserId());
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public OfficeShowProfilePlugin() {
        this.lastTimeShowProfile = -1;
    }

    private boolean shouldLimit() {
        if ((System.currentTimeMillis() - this.lastTimeShowProfile) <= 1000) goto L6;
        this.lastTimeShowProfile = System.currentTimeMillis();
        return false;
    L6:
        return true;
    }

    public static /* synthetic */ boolean access$1000(OfficeShowProfilePlugin r100) {
        return r100.isUIContainerAttached();
    }

    public static /* synthetic */ FragmentActivity access$1100(OfficeShowProfilePlugin r100) {
        return r100.getActivity();
    }

    public static /* synthetic */ FragmentManager access$1200(OfficeShowProfilePlugin r100) {
        return r100.getFragmentManager();
    }

    public static /* synthetic */ boolean access$200(OfficeShowProfilePlugin r100) {
        return r100.shouldLimit();
    }

    public static /* synthetic */ boolean access$400(OfficeShowProfilePlugin r100) {
        return r100.isUIContainerDetached();
    }

    public static /* synthetic */ Context access$600(OfficeShowProfilePlugin r100) {
        return r100.getContext();
    }

    public static /* synthetic */ Context access$700(OfficeShowProfilePlugin r100) {
        return r100.getContext();
    }

    public static /* synthetic */ boolean access$800(OfficeShowProfilePlugin r100) {
        return r100.isUIContainerAttached();
    }

    private void showProfile(String r100) {
        ((k) org.koin.java.a.a(k.class)).e(r100, getDocumentMetadata().getDocName().getValue());
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        r100.put("biz.util.showProfile", new b(this));
        r100.put("biz.util.inviteNoPermUserProfile", new a(this));
    }

    public static /* synthetic */ void access$300(OfficeShowProfilePlugin r100, String r101) {
        r100.showProfile(r101);
    }

    public static /* synthetic */ f access$500(OfficeShowProfilePlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }
}
