package com.larus.login.impl.tourist;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.provider.agegate.AgeGateManagerService;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.auth.ILaunchMetricService;
import com.larus.bmhome.auth.LaunchMetricDelegate;
import com.larus.bmhome.auth.h1;
import com.larus.bmhome.auth.i1;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.im.bean.IMMsgExt;
import com.larus.login.api.ITouristApi;
import com.larus.login.impl.AccountUtils;
import com.larus.network.http.w;
import com.larus.network.http.y;
import com.larus.network.http.z;
import com.larus.nova.R;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.AccountService;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import t19.s;
import uj9.d;
import wc9.e;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\bH\u0002J\u001a\u0010'\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020\bH\u0002J\u0010\u0010)\u001a\u00020 2\u0006\u0010&\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\bH\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010&\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020 H\u0016J\u0010\u0010.\u001a\u00020 2\u0006\u0010&\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\bH\u0016J\u0018\u00100\u001a\u00020 2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\bH\u0016J\u001a\u00104\u001a\u00020 2\u0006\u00101\u001a\u0002022\b\u00105\u001a\u0004\u0018\u00010%H\u0016J\b\u00106\u001a\u00020 H\u0002J\u001a\u00107\u001a\u00020 2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\u000eH\u0017J\u001a\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010%H\u0017J\b\u0010A\u001a\u00020 H\u0016J\b\u0010B\u001a\u00020 H\u0016J\b\u0010C\u001a\u00020 H\u0016J\u0018\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020%H\u0016J\u0017\u0010H\u001a\u00020 2\b\u0010=\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010IJ\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00132\u0006\u0010G\u001a\u00020%H\u0082@¢\u0006\u0002\u0010LJ$\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u00132\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%H\u0082@¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020 H\u0016J\u0010\u0010S\u001a\u00020 2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010[\u001a\u00020 2\u0006\u0010\\\u001a\u00020XH\u0016J\u0010\u0010]\u001a\u00020 2\u0006\u0010\\\u001a\u00020XH\u0016J\u0010\u0010^\u001a\u00020 2\u0006\u0010\\\u001a\u00020ZH\u0016J\u0010\u0010_\u001a\u00020 2\u0006\u0010\\\u001a\u00020ZH\u0016J\b\u0010`\u001a\u00020 H\u0016J\b\u0010a\u001a\u00020 H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\b0\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\b0\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020X0WX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0WX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/larus/login/impl/tourist/TouristServiceImpl;", "Lcom/larus/account/base/provider/agegate/IAgeGateResultCallback;", "Lcom/larus/login/api/ITouristApi;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "riskDialogShowed", "", "_launchResult", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "_riskResult", "_ageGateErrorStatus", "", "needSyncFailedMsgWhenLogin", "_launchAndRiskResult", "Landroidx/lifecycle/MediatorLiveData;", "_cvsResult", "Lcom/larus/network/http/Async;", "", "launchAndRiskResult", "Landroidx/lifecycle/LiveData;", "getLaunchAndRiskResult", "()Landroidx/lifecycle/LiveData;", "cvsResult", "getCvsResult", "baseConstrains", "isMessageLimited", "isCreateBotLimited", "isHitTouristMode", "checkAgeGate", "", "trackerJson", "Lorg/json/JSONObject;", "put", "key", "", "value", "getBoolean", "defaultValue", "markMessageLimited", "getMessageLimited", "markCreateBotLimited", "getCreateBotLimited", "revertLimit", "markRisk", "getRisk", "openLogin", "scene", "Lcom/larus/platform/model/TriggerLoginScene;", "forceFullScreenLogin", "openHalfLogin", "deepLinkSchema", "compensateDidIfNeeded", "checkIfShowRiskDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "fm", "Landroidx/fragment/app/FragmentManager;", "handleLimitedState", "code", "handleRiskState", "shark", "msg", "onLoginIn", "onLoginOut", "onLoginFail", "requestLaunch", "scope", "Lkotlinx/coroutines/CoroutineScope;", "source", "markAgeGateError", "(Ljava/lang/Long;)V", "fetchLaunchInfoByTourist", "Lcom/larus/bmhome/auth/LaunchInfo;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchConversationInfoByTourist", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "botId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPassAgeGateSuccess", "onPassAgeGateFailed", "errorCode", "", "callBackList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/login/api/callback/LoginCallBack;", "panelCallBackList", "Lcom/larus/login/api/callback/LoginPanelCallBack;", "addCallBack", "callBack", "removeCallBack", "addPanelCallBack", "removePanelCallBack", "onPanelOpen", "onPanelClose", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouristServiceImpl implements s38.b, ITouristApi {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f358275k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f358276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f358277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f358278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Boolean> f358279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f358280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<com.larus.network.http.a<Object>> f358281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MediatorLiveData f358282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData f358283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList<tj9.a> f358284i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList<tj9.b> f358285j;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class b implements p0 {
        public b() {
        }

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f358286a;

        public c(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f358286a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f358286a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f358286a.invoke(r100);
        }
    }

    static {
    }

    public static void B() {
        IApplog.Companion r100 = IApplog.f287053a;
        String r101 = r100.getDeviceId();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
    L9:
        r100.u(3000, null);
        return;
    L8:
        if (Intrinsics.areEqual(r101, "0") == true) goto L9;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.larus.login.api.ITouristApi
    public final void b() {
        Iterator<T> r100 = this.f358285j.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((tj9.b) r100.next()).onClose();
        goto L4
    }

    @Override // com.larus.login.api.ITouristApi
    public final void g() {
        this.f358276a.storeBoolean("key_tourist_message_limited", false);
        this.f358276a.storeBoolean("key_tourist_create_bot_limited", false);
    }

    @Override // com.larus.login.api.ITouristApi
    public final void h() {
        Iterator<T> r100 = this.f358285j.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((tj9.b) r100.next()).onOpen();
        goto L4
    }

    @Override // com.larus.login.api.ITouristApi
    public final void j() {
        this.f358276a.storeBoolean("key_tourist_risk", false);
        this.f358279d.setValue(Boolean.FALSE);
        this.f358277b = false;
        this.f358281f.setValue(z.f360206d);
        this.f358280e = true;
        Iterator<tj9.a> r100 = this.f358284i.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().a();
        goto L4
    L6:
        this.f358284i.clear();
    }

    @Override // s38.b
    public final void l() {
        FLogger r100 = FLogger.f375446a;
        r100.i("TouristManager", "onPassAgeGateSuccess");
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        String r102 = null;
        if ((r101 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r103 = (FragmentActivity) r101;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.getSupportFragmentManager().getFragments().size() != 0) goto L10;
        return;
    L10:
        Lazy r104 = d.f550448a;
        if (d.d() == true) goto L13;
        IAccountService.f286094a.m();
    L13:
        Fragment r105 = (Fragment) ListProtector.get(r103.getSupportFragmentManager().getFragments(), 0);
        Bundle r106 = r105.getArguments();
        if (r106 == null) goto L16;
        r102 = r106.getString("pending_deeplink_schema");
    L16:
        String r107 = r102;
        if (o0.d(r107) == false) goto L19;
        r100.i("TouristManager", "pass uri from push when route to main page");
    L19:
        AccountUtils r108 = AccountUtils.f357130a;
        Intrinsics.checkNotNull(r105);
        AccountUtils.l(r108, r105, true, false, r107, 4);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.login.api.ITouristApi
    public final void n() {
        this.f358281f.setValue(z.f360206d);
        this.f358280e = false;
        this.f358276a.erase("last_send_msg_of_tourist_mode");
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean t() {
        return !ILoginService.f286097a.getAccountInfo().f531528a;
    }

    public TouristServiceImpl() {
        Keva r100 = xg9.b.a();
        this.f358276a = r100;
        MutableLiveData<Boolean> r101 = new MutableLiveData(Boolean.FALSE);
        this.f358278c = r101;
        MutableLiveData<Boolean> r102 = new MutableLiveData(Boolean.valueOf(r100.getBoolean("key_tourist_risk", false)));
        this.f358279d = r102;
        new MutableLiveData(null);
        final MediatorLiveData r103 = new MediatorLiveData();
        r103.addSource(r101, new c(new com.larus.login.impl.tourist.a(r103, this)));
        r103.addSource(r102, new c(new com.larus.login.impl.tourist.b(r103, this)));
        MutableLiveData<com.larus.network.http.a<Object>> r104 = new MutableLiveData(z.f360206d);
        this.f358281f = r104;
        this.f358282g = r103;
        this.f358283h = r104;
        this.f358284i = new CopyOnWriteArrayList();
        this.f358285j = new CopyOnWriteArrayList();
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean a() {
        if (t() == true) goto L5;
        return false;
    L5:
        if (this.f358276a.getBoolean("key_tourist_message_limited", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean f() {
        if (t() == false) goto L13;
        i1 r100 = h1.a();
        if (r100 == null) goto L7;
        String r101 = r100.f295807a;
    L9:
        if (o0.d(r101) == false) goto L13;
        String r102 = com.larus.network.http.d.f360140a;
        if (com.larus.network.http.d.f360144e == true) goto L13;
        return true;
    L7:
        r101 = null;
    L13:
        return false;
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean u() {
        if (t() == true) goto L5;
        return false;
    L5:
        if (this.f358276a.getBoolean("key_tourist_create_bot_limited", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean c() {
        return this.f358280e;
    }

    @Override // com.larus.login.api.ITouristApi
    public final LiveData<Boolean> w() {
        return this.f358282g;
    }

    @Override // com.larus.login.api.ITouristApi
    public final LiveData<com.larus.network.http.a<Object>> y() {
        return this.f358283h;
    }

    @Override // s38.b
    public final void A(int r100) {
        FLogger.f375446a.i("TouristManager", "onPassAgeGateFailed");
    }

    @Override // com.larus.login.api.ITouristApi
    public final void k(long r100) {
        if (t() == true) goto L5;
        return;
    L5:
        if (r100 != IMMsgExt.ERROR_TOURIST_REACH_MESSAGE_LIMIT) goto L8;
        this.f358276a.storeBoolean("key_tourist_message_limited", true);
        ITouristApi.a.a(this, TriggerLoginScene.TRIGGER_LOGIN_MESSAGE_LIMITED, false, 2);
        return;
    L8:
        if (r100 != IMMsgExt.ERROR_TOURIST_REACH_CREATE_BOT_LIMIT) goto L13;
        this.f358276a.storeBoolean("key_tourist_create_bot_limited", true);
        ITouristApi.a.a(this, TriggerLoginScene.TRIGGER_LOGIN_CREATE_BOT, false, 2);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void o(Long r100) {
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L6;
        FLogger.f375446a.i("TouristManager", "checkTouristLaunchPage ageGateErrorStatus " + r100 + ' ');
        ITouristApi.a.a(this, null, false, 3);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void p(tj9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f358284i.remove(r100);
    }

    @Override // com.larus.login.api.ITouristApi
    public final void q(JSONObject r100) {
        FLogger.f375446a.i("AccountLoginController", "checkAgeGate");
        if (AppHost.f326268a.isOversea() == true) goto L6;
        l();
        return;
    L6:
        AgeGateManagerService.f286218a.a(this, "visitor", r100);
    }

    @Override // com.larus.login.api.ITouristApi
    public final void s(tj9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f358285j.add(r100);
    }

    @Override // com.larus.login.api.ITouristApi
    public final void v(tj9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f358284i.add(r100);
    }

    @Override // com.larus.login.api.ITouristApi
    public final void z(tj9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f358285j.remove(r100);
    }

    @Override // com.larus.login.api.ITouristApi
    public final void d(TriggerLoginScene r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        FLogger.f375446a.i("TouristManager", "openHalfLogin scene: " + r100);
        boolean r102 = false;
        Bundle r103 = f.c(new Pair[]{TuplesKt.to("key_from_restricted_func", Boolean.TRUE), TuplesKt.to("trigger_login_scene_tag", Integer.valueOf(r100.getValue()))});
        String r104 = null;
        if (o0.d(r101) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L16;
        r103.putString("pending_deeplink_schema", r101);
        String r105 = UriProtector.getQueryParameter(UriProtector.parse(r101), "enter_method");
        if (r105 == null) goto L16;
        if (r105.length() <= 0) goto L12;
        r102 = true;
    L12:
        if (r102 == false) goto L14;
        r104 = r105;
    L14:
        if (r104 == null) goto L16;
        r103.putString("account_enter_method", r104);
    L16:
        B();
        i r106 = SmartRouter.buildRoute(AppHost.f326268a.getApplication().getApplicationContext(), "//flow/half_account_login");
        r106.f267554c.putExtras(r103);
        r106.d();
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean i(boolean r100, String r110) {
        boolean r101 = false;
        if (t() == true) goto L5;
        return false;
    L5:
        if (r100 == false) goto L7;
        this.f358276a.storeBoolean("key_tourist_risk", true);
        this.f358279d.setValue(Boolean.TRUE);
    L13:
        ITouristApi.a.a(this, null, true, 1);
        return true;
    L7:
        if (r110 != null) goto L9;
    L10:
        r101 = true;
    L11:
        if (r101 == true) goto L13;
        s.j(s.f544207a, AppHost.f326268a.getApplication(), r110, null, false, 28);
        goto L13
    L9:
        if (r110.length() != 0) goto L11;
        goto L10
    }

    @Override // com.larus.login.api.ITouristApi
    public final void m(Context r100, FragmentManager r101) {
        Intrinsics.checkNotNullParameter(r101, "fm");
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f358277b == false) goto L7;
        return;
    L7:
        if (this.f358276a.getBoolean("key_tourist_risk", false) == true) goto L10;
        return;
    L10:
        if (r101.isStateSaved() == false) goto L12;
        return;
    L12:
        if (r101.isDestroyed() == true) goto L34;
        CommonDialog.a r102 = new CommonDialog.a();
        r102.i(r100.getString(R.string.larus_guest_limited_usage_title));
        r102.g(r100.getString(R.string.larus_guest_limited_usage_message));
        CommonDialog.a.f(r102, new b(), r100.getString(R.string.larus_guest_limited_usage_confirm), false, 12);
        r102.f327194w = true;
        CommonDialog r103 = r102.a();
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L22
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, "tourist_risk_dialog", r104);     // Catch: Exception -> L22
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L28;
    L20:
        this.f358277b = true;     // Catch: Exception -> L22
        return;
    L28:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L19:
        r103.show(r101, "tourist_risk_dialog");     // Catch: Exception -> L22
    L22:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "tourist limit dialog show Error");
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void r(LifecycleCoroutineScope r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "scope");
        Intrinsics.checkNotNullParameter(r111, "source");
        if ((this.f358281f.getValue() instanceof y) == false) goto L5;
        return;
    L5:
        this.f358278c.setValue(Boolean.FALSE);
        this.f358281f.setValue(new w(null));
        BuildersKt.launch$default(r110, Dispatchers.getIO(), null, new TouristServiceImpl$requestLaunch$1(this, r111, null), 2, null);
    }

    @Override // com.larus.login.api.ITouristApi
    public final void x(TriggerLoginScene r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        FLogger.f375446a.i("TouristManager", "openLogin scene: " + r100 + "  forceFullScreenLogin: " + r101);
        if (r101 == true) goto L5;
        B();
        i r102 = SmartRouter.buildRoute(AppHost.f326268a.getApplication().getApplicationContext(), "//flow/half_account_login");
        r102.f267554c.putExtras(f.c(new Pair[]{TuplesKt.to("key_from_restricted_func", Boolean.TRUE), TuplesKt.to("trigger_login_scene_tag", Integer.valueOf(r100.getValue()))}));
        r102.d();
        return;
    L5:
        i r103 = SmartRouter.buildRoute(AppHost.f326268a.getApplication().getApplicationContext(), "//flow/account_login");
        r103.f267554c.putExtras(f.c(new Pair[]{TuplesKt.to("key_from_restricted_func", Boolean.TRUE), TuplesKt.to("trigger_login_scene_tag", Integer.valueOf(r100.getValue()))}));
        r103.f267554c.addFlags(67108864);
        r103.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object e(TouristServiceImpl r100, String r101, String r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof TouristServiceImpl$fetchConversationInfoByTourist$1) == false) goto L7;
        TouristServiceImpl$fetchConversationInfoByTourist$1 r104 = (TouristServiceImpl$fetchConversationInfoByTourist$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r102 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L17:
        r107 = (com.larus.network.http.a) r106;
        e r109 = null;
        if ((r107 instanceof y) == false) goto L20;
        y r110 = (y) r107;
    L21:
        if (r110 == null) goto L24;
        r109 = (e) r110.f360135b;
    L24:
        if (r109 != null) goto L26;
        LaunchMetricDelegate.f295730b.a("conversation_fetch_end", false, "Invalid conversation info: " + r109 + " for " + r102);
    L27:
        return r107;
    L26:
        ILaunchMetricService.a.a(LaunchMetricDelegate.f295730b, "conversation_fetch_end", true, 8);
        goto L27
    L20:
        r110 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        ILaunchMetricService.a.a(LaunchMetricDelegate.f295730b, "conversation_fetch_start", false, 12);
        IConversationRepoService r111 = RepoDispatcherDelegate.f307737b.f();
        r104.L$0 = r102;
        r104.label = 1;
        r106 = IConversationRepoService.a.e(r111, r101, r102, r104, 4);
        if (r106 != r107) goto L17;
    L7:
        r104 = new TouristServiceImpl$fetchConversationInfoByTourist$1(r100, r103);
        goto L8
    }
}
