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
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnBoardingPlugin f220699a;

        public a(OnBoardingPlugin r100) {
            this.f220699a = r100;
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
        public final void handle(Object r100, m r110) {
            OnBoardingIdListData r101 = (OnBoardingIdListData) r100;
            if (r110 != null) goto L5;
            tt5.a.d(OnBoardingPlugin.TAG, "CallbackFunction is null");
            return;
        L5:
            JSONObject r102 = new JSONObject();
            if (r101 != null) goto L8;
        L18:
            Iterator<Map.Entry<String, Boolean>> r103 = ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().h().entrySet().iterator();
        L20:
            if (r103.hasNext() == false) goto L22;
            Map.Entry<String, Boolean> r104 = r103.next();
            String r105 = r104.getKey();
            boolean r106 = r104.getValue().booleanValue();
            JSONObject r107 = new JSONObject();
            r107.put2("is_done", Boolean.valueOf(r106));
            r102.put2(r105, r107);
        L22:
            tt5.a.h(OnBoardingPlugin.TAG, "getOnBoardingStatus: " + r102);
            r110.b(r102);
            return;
        L8:
            if (r101.getIds() == null) goto L18;
            if (r101.getIds().length == 0) goto L18;
            String[] r108 = r101.getIds();
            int r109 = r108.length;
            int r111 = 0;
        L13:
            if (r111 >= r109) goto L22;
            String r112 = r108[r111];
            if (TextUtils.isEmpty(r112) == true) goto L17;
            boolean r113 = ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().f(r112);
            JSONObject r114 = new JSONObject();
            r114.put2("is_done", Boolean.valueOf(r113));
            r102.put2(r112, r114);
        L17:
            r111 = r111 + 1;
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
        public final void handle(Object r100, m r101) {
            OnBoardingIdListData r102 = (OnBoardingIdListData) r100;
            tt5.a.h(OnBoardingPlugin.TAG, "setOnBoardingFinished:" + r102);
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.getIds() == null) goto L19;
            String[] r103 = r102.getIds();
            ArrayList r104 = new ArrayList();
            int r105 = r103.length;
            int r106 = 0;
        L8:
            if (r106 >= r105) goto L13;
            String r107 = r103[r106];
            if (TextUtils.isEmpty(r107) == true) goto L12;
            r104.add(r107);
        L12:
            r106 = r106 + 1;
            goto L8
        L13:
            ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().i(r104);
            return;
        }
    }

    public class d implements i<OnBoardingData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnBoardingPlugin f220700a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(OnBoardingPlugin r100) {
            this.f220700a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            OnBoardingData r102 = (OnBoardingData) r100;
            tt5.a.h(OnBoardingPlugin.TAG, "show OnBoarding:" + r102);
            if (r102 == null) goto L6;
            r102.transformPositionsIfNeed();
            this.f220700a.dispatchMission(r102, r101);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
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
        DocViewModel r100 = getDocViewModel();
        if (r100 != null) goto L5;
        return "doc";
    L5:
        String r101 = r100.getOriginBearUrl().getType();
        if (TextUtils.equals(r101, DocumentType.DOCX_NAME) == false) goto L8;
        return "doc";
    L8:
        return r101;
    }

    public OnBoardingPlugin(com.bytedance.ee.bear.document.onboarding.d r100) {
        this.missionProvder = r100;
    }

    private com.bytedance.ee.bear.document.onboarding.b getMission(String r100) {
        if (this.missionList != null) goto L5;
    L15:
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L15;
        Iterator<com.bytedance.ee.bear.document.onboarding.b> r101 = this.missionList.iterator();
    L9:
        if (r101.hasNext() == false) goto L15;
        com.bytedance.ee.bear.document.onboarding.b r102 = r101.next();
        if (r100 == null) goto L9;
        if (r100.equals(r102.getId()) == false) goto L9;
        return r102;
    }

    private void onDismissMission(String r100, String r101) {
        tt5.a.b(TAG, "dismiss guide: " + r100 + "; status: " + r101);
        if (getWeb() == null) goto L6;
        JSONObject r102 = new JSONObject();
        r102.put2("action", r100);
        r102.put2("status", r101);
        getWeb().j(JS_BIZ_UTIL_FINISH_GUIDE, r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatchMission(OnBoardingData r100, m r101) {
        String r102 = r100.action;
        if (TextUtils.isEmpty(r102) == false) goto L6;
        onDismissMission(UNDEFINED_ACTION, "fail");
        return;
    L6:
        com.bytedance.ee.bear.document.onboarding.b r103 = getMission(r102);
        this.currentMission = r103;
        if (r100.customData == null) goto L10;
        if (r103 != null) goto L10;
        this.currentMission = new c35.a(r100, getBiz(), r101);
    L14:
        if (r100.position == null) goto L18;
        WebView r104 = getWeb().getWebView();
        if (r104 == null) goto L18;
        int[] r105 = new int[2];
        r104.getLocationInWindow(r105);
        OnBoardingData.Position r106 = r100.position;
        r106.f220697x += r105[0];
        r106.f220698y += r105[1];
    L18:
        com.bytedance.ee.bear.document.onboarding.b r107 = this.currentMission;
        r107.f220703a = r100;
        r107.f220704b = (DocumentPluginHost) getHost();
        ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().a(this.currentMission, new com.bytedance.ee.bear.document.onboarding.c(this.statusListener, getActivity(), getTitleBar(), ((DocumentPluginHost) getHost()).c().getView()));
        return;
    L10:
        if (r103 != null) goto L14;
        onDismissMission(r102, "fail");
    }

    public void onAttachToUIContainer(DocumentPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        this.missionList = this.missionProvder.get();
        pcb.a.AbstractC7181a.b(r100.getActivity()).c(this);
        bindBridgeHandlerAutoUnbind(BIZ_UTIL_SHOW_GUIDE, new d(this));
        bindBridgeHandlerAutoUnbind(BIZ_ONBOARDING_GET_STATUS, new b());
        bindBridgeHandlerAutoUnbind(BIZ_ONBOARDING_SET_FINISHED, new c());
        getStatusListener();
    }

    public void onDetachFromUIContainer(DocumentPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        pcb.a.AbstractC7181a.b(r100.getActivity()).a(this);
        dismissShowingMission();
        com.bytedance.ee.bear.document.onboarding.a.C3144a.f220702a.f220701a.clear();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    public static /* synthetic */ void access$300(OnBoardingPlugin r100, String r101, String r102) {
        r100.onDismissMission(r101, r102);
    }

    @Override // ocb.a
    public void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        if (r101 <= 0) goto L4;
        boolean r103 = true;
    L5:
        if (r103 == true) goto L8;
        dismissShowingMission();
        return;
    L8:
        return;
    L4:
        r103 = false;
        goto L5
    }
}
