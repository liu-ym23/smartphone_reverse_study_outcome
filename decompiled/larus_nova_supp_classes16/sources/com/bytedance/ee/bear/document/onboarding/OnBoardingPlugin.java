package com.bytedance.ee.bear.document.onboarding;

import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OnBoardingPlugin extends DocumentPlugin implements ocb.a {
    private static final String BIZ_ONBOARDING_GET_STATUS = "biz.onboarding.getStatuses";
    private static final String BIZ_ONBOARDING_SET_FINISHED = "biz.onboarding.setFinished";
    private static final String BIZ_UTIL_SHOW_GUIDE = "biz.util.showUserGuide";
    private static final String JS_BIZ_UTIL_FINISH_GUIDE = "javascript:window.lark.biz.util.finishUserGuide";
    private static final String TAG = "OnBoardingPlugin";
    private static final String UNDEFINED_ACTION = "mobile_illegal_onboarding_item";
    private com.bytedance.ee.bear.document.onboarding.b currentMission;
    private List<com.bytedance.ee.bear.document.onboarding.b> missionList;
    private com.bytedance.ee.bear.document.onboarding.d missionProvder;
    private tk5.b statusListener;

    public class a implements tk5.b {
        public final /* synthetic */ OnBoardingPlugin a;

        public a(OnBoardingPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements i<OnBoardingIdListData> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r9, m r10) {
            OnBoardingIdListData r11 = (OnBoardingIdListData) r9;
            if (r10 != null) goto L5;
            tt5.a.d(OnBoardingPlugin.TAG, "CallbackFunction is null");
            return;
        L5:
            JSONObject r1 = new JSONObject();
            if (r11 != null) goto L8;
        L18:
            Iterator r12 = ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().h().entrySet().iterator();
        L20:
            if (r12.hasNext() == false) goto L22;
            Map.Entry r3 = (Map.Entry) r12.next();
            String r4 = (String) r3.getKey();
            boolean r5 = ((Boolean) r3.getValue()).booleanValue();
            JSONObject r6 = new JSONObject();
            r6.put("is_done", Boolean.valueOf(r5));
            r1.put(r4, r6);
        L22:
            tt5.a.h(OnBoardingPlugin.TAG, "getOnBoardingStatus: " + r1);
            r10.b(r1);
            return;
        L8:
            if (r11.getIds() == null) goto L18;
            if (r11.getIds().length == 0) goto L18;
            String[] r13 = r11.getIds();
            int r7 = r13.length;
            int r8 = 0;
        L13:
            if (r8 >= r7) goto L22;
            String r14 = r13[r8];
            if (TextUtils.isEmpty(r14) == true) goto L17;
            boolean r16 = ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().f(r14);
            JSONObject r17 = new JSONObject();
            r17.put("is_done", Boolean.valueOf(r16));
            r1.put(r14, r17);
        L17:
            r8 = r8 + 1;
            goto L13
        }
    }

    public class c implements i<OnBoardingIdListData> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            OnBoardingIdListData r7 = (OnBoardingIdListData) r5;
            tt5.a.h(OnBoardingPlugin.TAG, "setOnBoardingFinished:" + r7);
            if (r7 != null) goto L5;
            return;
        L5:
            if (r7.getIds() == null) goto L19;
            String[] r8 = r7.getIds();
            ArrayList r9 = new ArrayList();
            int r0 = r8.length;
            int r1 = 0;
        L8:
            if (r1 >= r0) goto L13;
            String r2 = r8[r1];
            if (TextUtils.isEmpty(r2) == true) goto L12;
            r9.add(r2);
        L12:
            r1 = r1 + 1;
            goto L8
        L13:
            ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().i(r9);
            return;
        }
    }

    public class d implements i<OnBoardingData> {
        public final /* synthetic */ OnBoardingPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(OnBoardingPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            OnBoardingData r5 = (OnBoardingData) r3;
            tt5.a.h(OnBoardingPlugin.TAG, "show OnBoarding:" + r5);
            if (r5 == null) goto L6;
            r5.transformPositionsIfNeed();
            this.a.dispatchMission(r5, r4);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void dismissShowingMission() {
        if (this.currentMission == null) goto L6;
        ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().d(this.currentMission);
        this.currentMission = null;
        return;
    }

    public tk5.b getStatusListener() {
        if (this.statusListener != null) goto L6;
        this.statusListener = new a(this);
    L6:
        return this.statusListener;
    }

    private String getBiz() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
        return "doc";
    L5:
        String r1 = r0.getOriginBearUrl().getType();
        if (TextUtils.equals(r1, "docx") == false) goto L8;
        return "doc";
    L8:
        return r1;
    }

    public OnBoardingPlugin(com.bytedance.ee.bear.document.onboarding.d r1) {
        this.missionProvder = r1;
    }

    private com.bytedance.ee.bear.document.onboarding.b getMission(String r5) {
        if (this.missionList != null) goto L5;
    L15:
        return null;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L15;
        Iterator<com.bytedance.ee.bear.document.onboarding.b> r0 = this.missionList.iterator();
    L9:
        if (r0.hasNext() == false) goto L15;
        com.bytedance.ee.bear.document.onboarding.b r2 = r0.next();
        if (r5 == null) goto L9;
        if (r5.equals(r2.getId()) == false) goto L9;
        return r2;
    }

    private void onDismissMission(String r3, String r4) {
        tt5.a.b(TAG, "dismiss guide: " + r3 + "; status: " + r4);
        if (getWeb() == null) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put(JSEventListener.ACTION, r3);
        r0.put("status", r4);
        getWeb().j(JS_BIZ_UTIL_FINISH_GUIDE, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatchMission(OnBoardingData r6, m r7) {
        String r0 = r6.action;
        if (TextUtils.isEmpty(r0) == false) goto L6;
        onDismissMission(UNDEFINED_ACTION, "fail");
        return;
    L6:
        com.bytedance.ee.bear.document.onboarding.b r1 = getMission(r0);
        this.currentMission = r1;
        if (r6.customData == null) goto L10;
        if (r1 != null) goto L10;
        this.currentMission = new c35.a(r6, getBiz(), r7);
    L14:
        if (r6.position == null) goto L18;
        WebView r8 = getWeb().getWebView();
        if (r8 == null) goto L18;
        int[] r2 = new int[2];
        r8.getLocationInWindow(r2);
        OnBoardingData.Position r9 = r6.position;
        r9.x += r2[0];
        r9.y += r2[1];
    L18:
        com.bytedance.ee.bear.document.onboarding.b r10 = this.currentMission;
        r10.a = r6;
        r10.b = (DocumentPluginHost) getHost();
        ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().a(this.currentMission, new com.bytedance.ee.bear.document.onboarding.c(this.statusListener, getActivity(), getTitleBar(), ((DocumentPluginHost) getHost()).c().getView()));
        return;
    L10:
        if (r1 != null) goto L14;
        onDismissMission(r0, "fail");
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        this.missionList = this.missionProvder.get();
        pcb.a.a.b(r1.getActivity()).c(this);
        bindBridgeHandlerAutoUnbind(BIZ_UTIL_SHOW_GUIDE, new d(this));
        bindBridgeHandlerAutoUnbind(BIZ_ONBOARDING_GET_STATUS, new b());
        bindBridgeHandlerAutoUnbind(BIZ_ONBOARDING_SET_FINISHED, new c());
        getStatusListener();
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        pcb.a.a.b(r1.getActivity()).a(this);
        dismissShowingMission();
        com.bytedance.ee.bear.document.onboarding.a.C0088a.a.a.clear();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static /* synthetic */ void access$300(OnBoardingPlugin r0, String r1, String r2) {
        r0.onDismissMission(r1, r2);
    }

    public void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        if (r2 <= 0) goto L4;
        boolean r4 = true;
    L5:
        if (r4 == true) goto L8;
        dismissShowingMission();
        return;
    L8:
        return;
    L4:
        r4 = false;
        goto L5
    }
}
