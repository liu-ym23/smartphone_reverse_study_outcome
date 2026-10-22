package com.bytedance.ee.bear.document.tips;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocTipsLayout;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.facade.common.widget.ErrorTipsView;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeTipsPlugin extends DocumentPluginV3 implements com.bytedance.ee.bear.middleground_permission_export.model.g, BaseTipsPlugin<ChameleonPluginHost> {
    private static final int PERM_TYPE_CONTAINER = 1;
    private static final String TAG = "TipsPlugin";
    private DocViewModel docViewModel;
    private uv4.c mBottomDialog;
    private final CompositeDisposable mCompositeDisposable;
    private tb5.m mErrorTipCallback;
    private final MutableLiveData<Boolean> mIsShowingAtTips;
    private tb5.m mLinkCallback;
    private final ErrorTipsView.b mTipsClickCallback;
    private final Observer<String> memberFetchTokenObserver;
    private int shareMemberNumber;
    private a0 tipsController;

    public class a implements ErrorTipsView.b {
        public final /* synthetic */ OfficeTipsPlugin a;

        public a(OfficeTipsPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.facade.common.widget.ErrorTipsView.b
        public final void onClick(String r5, String r6) {
            JSONObject r0 = new JSONObject();
            if ("linkUrl".equals(r5) == false) goto L13;
            if (OfficeTipsPlugin.access$000(this.a) != null) goto L7;
        L10:
            tt5.a.d(OfficeTipsPlugin.TAG, "link callback or linkurl is empty");
            return;
        L7:
            if (TextUtils.isEmpty(r6) == true) goto L10;
            r0.put("linkUrl", r6);
            OfficeTipsPlugin.access$000(this.a).b(r0);
        L21:
            if (OfficeTipsPlugin.access$200(this.a) != null) goto L23;
            return;
        L23:
            if ("close".equals(r5) == false) goto L27;
            OfficeTipsPlugin.access$200(this.a).l();
            return;
        L27:
            return;
        L13:
            if (OfficeTipsPlugin.access$100(this.a) != null) goto L16;
            tt5.a.d(OfficeTipsPlugin.TAG, "error tip callback is null");
            return;
        L16:
            r0.put(JSEventListener.ACTION, r5);
            if (TextUtils.isEmpty(r6) == true) goto L19;
            r0.put("urlPath", r6);
        L19:
            OfficeTipsPlugin.access$100(this.a).b(r0);
            goto L21
        }
    }

    public class b implements com.bytedance.ee.bear.document.tips.a {
        public final /* synthetic */ OfficeTipsPlugin a;

        @Override // com.bytedance.ee.bear.document.tips.a
        public final int a() {
            return OfficeTipsPlugin.access$1000(this.a);
        }

        public b(OfficeTipsPlugin r1) {
            this.a = r1;
        }
    }

    public class c implements tb5.i<String> {
        public final /* synthetic */ OfficeTipsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(OfficeTipsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            String r3 = (String) r1;
            if (OfficeTipsPlugin.access$200(this.a) == null) goto L5;
            OfficeTipsPlugin.access$200(this.a).k();
        L5:
            OfficeTipsPlugin.access$1100(this.a).setValue(Boolean.FALSE);
        }
    }

    public class d implements tb5.i<String> {
        public final /* synthetic */ OfficeTipsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(OfficeTipsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            String r4 = (String) r2;
            if (OfficeTipsPlugin.access$200(this.a) == null) goto L5;
            OfficeTipsPlugin.access$200(this.a).o(r4, r3);
        L5:
            OfficeTipsPlugin.access$1100(this.a).setValue(Boolean.TRUE);
        }
    }

    public class e implements tb5.i<String> {
        public final /* synthetic */ OfficeTipsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(OfficeTipsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            String r4 = (String) r2;
            tt5.a.h(OfficeTipsPlugin.TAG, "err link handler triggered");
            OfficeTipsPlugin.access$002(this.a, r3);
        }
    }

    public class f implements tb5.i<String> {
        public final /* synthetic */ OfficeTipsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(OfficeTipsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            String r3 = (String) r1;
            tt5.a.h(OfficeTipsPlugin.TAG, "hide error tips view.");
            if (OfficeTipsPlugin.access$200(this.a) == null) goto L6;
            OfficeTipsPlugin.access$200(this.a).l();
            return;
        }
    }

    public class g implements tb5.i<String> {
        public final /* synthetic */ OfficeTipsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(OfficeTipsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r12, tb5.m r13) {
            String r14 = (String) r12;
            OfficeTipsPlugin.access$102(this.a, r13);
        L15:
            e = move-exception;
            tt5.a.e(OfficeTipsPlugin.TAG, "ErrorTipViewShowHandler handle(): ", e, false);
            return;
        L4:
            if (TextUtils.isEmpty(r14) == false) goto L6;
            tt5.a.d(OfficeTipsPlugin.TAG, "show err tips with empty data");     // Catch: JSONException -> L15
            return;
        L6:
            org.json.JSONObject r2 = new org.json.JSONObject(r14);     // Catch: JSONException -> L15
            String r16 = r2.optString("text");     // Catch: JSONException -> L15
            String r3 = r2.optString("linkText");     // Catch: JSONException -> L15
            String r4 = r2.optString("linkUrl");     // Catch: JSONException -> L15
            String r5 = r2.optString("extraText");     // Catch: JSONException -> L15
            String r6 = r2.optString("extraAction");     // Catch: JSONException -> L15
            boolean r7 = r2.optBoolean("canClose", false);     // Catch: JSONException -> L15
            ErrorTipsView.TipsType r8 = ErrorTipsView.TipsType.valueOf(r2.optString("type", "normal"));     // Catch: JSONException -> L15
            org.json.JSONObject r9 = r2.optJSONObject("textBtn");     // Catch: JSONException -> L15
            if (r9 == null) goto L10;
            String r10 = r9.optString(JSEventListener.ACTION);     // Catch: JSONException -> L15
            String r0 = r9.optString("text");     // Catch: JSONException -> L15
        L11:
            ErrorTipsView.c r11 = new ErrorTipsView.c(r7, r10, r0);     // Catch: JSONException -> L15
            r11.f = ((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class)).c();     // Catch: JSONException -> L15
            r11.e = r5;     // Catch: JSONException -> L15
            r11.d = r6;     // Catch: JSONException -> L15
            r11.g = r2.optString("actionName");     // Catch: JSONException -> L15
            if (OfficeTipsPlugin.access$200(this.a) == null) goto L20;
            OfficeTipsPlugin.access$200(this.a).p(new ErrorTipsView.d(r16, r3, r4, r8), r11, OfficeTipsPlugin.access$1200(this.a));     // Catch: JSONException -> L15
            return;
        L20:
            return;
        L10:
            r10 = "";
            r0 = "";
            goto L11
        }
    }

    public class h implements tb5.i<String> {
        public final /* synthetic */ OfficeTipsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h(OfficeTipsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            String r3 = (String) r1;
            if (OfficeTipsPlugin.access$1900(this.a) != null) goto L5;
            return;
        L5:
            if (OfficeTipsPlugin.access$1900(this.a).c() == false) goto L9;
            OfficeTipsPlugin.access$1900(this.a).a();
            return;
        }
    }

    public class i implements tb5.i<BottomPopupData> {
        public final /* synthetic */ OfficeTipsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public i(OfficeTipsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            BottomPopupData r4 = (BottomPopupData) r2;
            if (r4 == null) goto L6;
            if (r3 == null) goto L6;
            this.a.showBottomPopup(r4, r3);
            return;
        L6:
            tt5.a.h(OfficeTipsPlugin.TAG, "handle(): BottomPopupData is Null");
        }
    }

    public static /* synthetic */ void a(OfficeTipsPlugin r0, String r1) {
        r0.lambda$new$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void reportAtAuthorizeCloseClick() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();
        jg5.k.a.a.a();
    }

    private void reportAtAuthorizeView() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();
        jg5.k.a.a.c();
    }

    @Override // com.bytedance.ee.bear.document.tips.BaseTipsPlugin
    public void hideQuotaBanner() {
        a0 r0 = this.tipsController;
        if (r0 == null) goto L6;
        DocTipsLayout r1 = r0.e;
        r1.i = false;
        r1.a();
        r1.b();
        return;
    }

    public OfficeTipsPlugin() {
        this.mIsShowingAtTips = new MutableLiveData();
        this.mCompositeDisposable = new CompositeDisposable();
        this.memberFetchTokenObserver = new com.bytedance.ee.bear.document.tips.b(this);
        this.shareMemberNumber = -1;
        this.mTipsClickCallback = new a(this);
    }

    public LiveData<Boolean> getIsShowingAtTips() {
        return this.mIsShowingAtTips;
    }

    public static /* synthetic */ tb5.m access$000(OfficeTipsPlugin r0) {
        return r0.mLinkCallback;
    }

    public static /* synthetic */ tb5.m access$100(OfficeTipsPlugin r0) {
        return r0.mErrorTipCallback;
    }

    public static /* synthetic */ int access$1000(OfficeTipsPlugin r0) {
        return r0.shareMemberNumber;
    }

    public static /* synthetic */ MutableLiveData access$1100(OfficeTipsPlugin r0) {
        return r0.mIsShowingAtTips;
    }

    public static /* synthetic */ ErrorTipsView.b access$1200(OfficeTipsPlugin r0) {
        return r0.mTipsClickCallback;
    }

    public static /* synthetic */ void access$1300(OfficeTipsPlugin r0) {
        r0.reportAtAuthorizeCloseClick();
    }

    public static /* synthetic */ CompositeDisposable access$1400(OfficeTipsPlugin r0) {
        return r0.mCompositeDisposable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$1500(OfficeTipsPlugin r0) {
        return r0.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$1600(OfficeTipsPlugin r0) {
        return r0.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$1700(OfficeTipsPlugin r0) {
        return r0.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$1800(OfficeTipsPlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ uv4.c access$1900(OfficeTipsPlugin r0) {
        return r0.mBottomDialog;
    }

    public static /* synthetic */ a0 access$200(OfficeTipsPlugin r0) {
        return r0.tipsController;
    }

    private /* synthetic */ void lambda$new$0(String r2) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().n(r2, this);
    }

    private void reportAtAuthorizeSendClick(boolean r2) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();
        jg5.k.a.a.b(r2);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.util.showTips", new d(this));
        r3.put("biz.util.hideTips", new c(this));
        r3.put("biz.util.showMessage", new g(this));
        r3.put("biz.util.hideMessage", new f(this));
        r3.put("biz.util.showBottomPopup", new i(this));
        r3.put("biz.util.hideBottomPopup", new h(this));
        r3.put("biz.appeal.show", new e(this));
    }

    public void notifyMemberNumber(int r2) {
        if (this.shareMemberNumber != r2) goto L5;
        return;
    L5:
        this.shareMemberNumber = r2;
        a0 r0 = this.tipsController;
        if (r0 == null) goto L9;
        r0.n(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.tips.BaseTipsPlugin
    public void showQuotaBanner(String r4) {
        a0 r0 = this.tipsController;
        if (r0 == null) goto L9;
        DocTipsLayout r1 = r0.e;
        if (r1.j == false) goto L7;
        r1.i = false;
        return;
    L7:
        r1.setVisibility(0);
        r1.i = true;
        r1.t.setTip(r4);
        r1.a();
        return;
    }

    public static /* synthetic */ tb5.m access$002(OfficeTipsPlugin r0, tb5.m r1) {
        r0.mLinkCallback = r1;
        return r1;
    }

    public static /* synthetic */ tb5.m access$102(OfficeTipsPlugin r0, tb5.m r1) {
        r0.mErrorTipCallback = r1;
        return r1;
    }

    public static /* synthetic */ void access$2000(OfficeTipsPlugin r0, boolean r1) {
        r0.reportAtAuthorizeSendClick(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        this.docViewModel = (DocViewModel) viewModel(DocViewModel.class);
        a0 r0 = new a0(r3, r4, this.docViewModel);
        this.tipsController = r0;
        b r5 = new b(this);
        r0.p = false;
        r0.k = r5;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().n(this.docViewModel.getToken(), this);
        this.docViewModel.liveDocObjToken().observe(r3.getLifecycleOwner(), this.memberFetchTokenObserver);
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        a0 r3 = this.tipsController;
        if (r3 == null) goto L5;
        r3.k();
        this.tipsController.l();
    L5:
        DocViewModel r4 = this.docViewModel;
        if (r4 == null) goto L8;
        r4.liveDocObjToken().removeObserver(this.memberFetchTokenObserver);
    L8:
        this.mCompositeDisposable.clear();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().getClass();
        ((ConcurrentHashMap) jg5.j.c.a).remove(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.tips.BaseTipsPlugin
    public void showBottomPopup(final BottomPopupData r4, final tb5.m r5) {
        if (this.mBottomDialog != null) goto L5;
        this.mBottomDialog = new uv4.c(getActivity());
        zo5.b r0 = (zo5.b) org.koin.java.a.a(zo5.b.class);
        View r1 = this.mBottomDialog.f;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.FrameLayout");
        r0.p((FrameLayout) r1);
    L5:
        this.mBottomDialog.d(r4);
        uv4.c r2 = this.mBottomDialog;
        uv4.c.a r3 = new AnonymousClass3(this, r4, r5);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "clickCallback");
        r2.k = r3;
        reportAtAuthorizeView();
    }

    @Override // com.bytedance.ee.bear.document.tips.BaseTipsPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.tips.BaseTipsPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
