package com.larus.common.account.douyin;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.bytedance.keva.Keva;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.gson.annotations.SerializedName;
import com.larus.account.base.api.ConversationAuthUpdateScene;
import com.larus.account.base.api.IDouyinHeartBeatService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.provider.IThirdPartyPlatformLoginProvider;
import com.larus.login.impl.douyinconversationauth.DouyinConversationAuthServiceImpl$tryShow$1;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0003+,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J*\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J4\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J2\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0082@¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0002J*\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010*\u001a\u00020\bH\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/common/account/douyin/DouyinHeartBeatServiceImpl;", "Lcom/larus/account/base/api/IDouyinHeartBeatService;", "<init>", "()V", "mKeva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "hasActUpdateSuccess", "", "mLatestCallTime", "", "doTryHeartBeatRequest", "", "immediate", "triggerScene", "Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "callback", "Lcom/larus/account/base/api/HeartBeatResultCallback;", "clearTokenCache", "doHeartBeat", "douYinTokenResult", "Lcom/larus/account/base/api/DouYinTokenResult;", "isAuto", "doHeartBeatRequest", "accessToken", "", "openId", ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "actUpdate", "requestActUpdate", "Lcom/larus/network/http/Async;", "Lcom/larus/common/account/douyin/DouyinHeartBeatServiceImpl$AuthActUpdateResult;", "updateScene", "Lcom/larus/account/base/api/ConversationAuthUpdateScene;", "(Lcom/larus/account/base/api/DouYinTokenResult;ZLcom/larus/account/base/api/ConversationAuthUpdateScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestConversationAuthPopupEligibility", "Lcom/larus/account/base/api/ConversationAuthPopupEligibilityCallback;", "getDouyinLoginInstance", "Lcom/larus/account/base/provider/IThirdPartyPlatformLoginProvider;", "tryHeartBeatRequest", "delay", "isImplemented", "Companion", "AuthHeartBeatResult", "AuthActUpdateResult", "douyinlogin_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouyinHeartBeatServiceImpl implements IDouyinHeartBeatService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f326010d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f326011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f326012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f326013c;

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/common/account/douyin/DouyinHeartBeatServiceImpl$AuthActUpdateResult;", "", "askAuthToDouyin", "", "<init>", "(Z)V", "getAskAuthToDouyin", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "douyinlogin_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("ask_auth_to_douyin")
        private final boolean askAuthToDouyin;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.askAuthToDouyin == ((a) r100).askAuthToDouyin) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.askAuthToDouyin == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "AuthActUpdateResult(askAuthToDouyin=" + this.askAuthToDouyin + ')';
        }

        public a() {
            this.askAuthToDouyin = false;
        }

        public final boolean a() {
            return this.askAuthToDouyin;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/larus/common/account/douyin/DouyinHeartBeatServiceImpl$AuthHeartBeatResult;", "", "accessToken", "", "<init>", "(Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "douyinlogin_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("access_token")
        private String accessToken;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.accessToken, ((b) r100).accessToken) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.accessToken;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "AuthHeartBeatResult(accessToken=" + this.accessToken + ')';
        }

        public b() {
            this.accessToken = null;
        }

        public final String a() {
            return this.accessToken;
        }
    }

    public static final class c {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class d extends BDNetworkTagContextProviderAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f326014a;

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return !this.f326014a ? 1 : 0;
        }

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final boolean markAsNewUser() {
            return super.markAsNewUser();
        }

        public d(boolean r100) {
            this.f326014a = r100;
        }
    }

    static {
    }

    @Override // com.larus.account.base.api.IDouyinHeartBeatService
    public final void d() {
    }

    public static IThirdPartyPlatformLoginProvider g() {
        Iterator r100 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        IThirdPartyPlatformLoginProvider r101 = (IThirdPartyPlatformLoginProvider) r100.next();
        if (r101.c() != LoginPlatform.DOUYIN) goto L4;
        return r101;
    L8:
        return null;
    }

    @Override // com.larus.account.base.api.IDouyinHeartBeatService
    public final void a() {
        this.f326011a.erase("cache_access_token");
    }

    public DouyinHeartBeatServiceImpl() {
        this.f326011a = Keva.getRepo("auth_heart_beat_info");
    }

    @Override // com.larus.account.base.api.IDouyinHeartBeatService
    public final boolean c() {
        return this.f326012b;
    }

    @Override // com.larus.account.base.api.IDouyinHeartBeatService
    public final void b(ConversationAuthUpdateScene r110, DouyinConversationAuthServiceImpl$tryShow$1 r111) {
        Intrinsics.checkNotNullParameter(r110, "updateScene");
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L6;
        r111.onResult(false, false);
        return;
    L6:
        IThirdPartyPlatformLoginProvider r100 = g();
        if (r100 != null) goto L10;
        r111.onResult(false, false);
        return;
    L10:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1(r100, r111, this, r110, null), 2, null);
    }

    @Override // com.larus.account.base.api.IDouyinHeartBeatService
    public final synchronized void e(long r100, final boolean r110, final GetOauthTokenTriggerScene r111, final n38.f r112) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r111, "triggerScene");     // Catch: Throwable -> L13
        long r101 = System.currentTimeMillis() + r100;     // Catch: Throwable -> L13
        if ((r101 - this.f326013c) > 5000) goto L10;
        if (r110 == true) goto L10;
        if (r112 == null) goto L8;
        r112.onResult(null, null, null);     // Catch: Throwable -> L13
    L8:
        monitor-exit(this);
        return;
    L10:
        this.f326013c = r101;     // Catch: Throwable -> L13
        new Handler(Looper.getMainLooper()).postDelayed(new g(this, r110, r111, r112), r100);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object h(n38.e r210, boolean r211, ConversationAuthUpdateScene r212, Continuation<? super com.larus.network.http.a<a>> r213) {
        if ((r213 instanceof DouyinHeartBeatServiceImpl$requestActUpdate$1) == false) goto L7;
        DouyinHeartBeatServiceImpl$requestActUpdate$1 r100 = (DouyinHeartBeatServiceImpl$requestActUpdate$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DouyinHeartBeatServiceImpl$requestActUpdate$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L17;
        if (r104 != 1) goto L16;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L13
        Object r105 = r102;
        String r106 = "DouyinHeartBeatServiceImpl";
        boolean r107 = true;
    L45:
        com.larus.network.http.a r108 = (com.larus.network.http.a) r105;     // Catch: Exception -> L57
        if ((r108 instanceof y) == false) goto L64;
        this.f326012b = r107;     // Catch: Exception -> L57
        a r109 = (a) ((y) r108).f360135b;     // Catch: Exception -> L57
        FLogger r111 = FLogger.f375446a;     // Catch: Exception -> L57
        StringBuilder r112 = new StringBuilder("requestActUpdate result, dataPresent=");     // Catch: Exception -> L57
        if (r109 != null) goto L51;
        r107 = false;
    L51:
        r112.append(r107);     // Catch: Exception -> L57
        r112.append(", askAuthToDouyin=");     // Catch: Exception -> L57
        if (r109 == null) goto L54;
        Boolean r113 = Boxing.boxBoolean(r109.a());     // Catch: Exception -> L57
    L55:
        r112.append(r113);     // Catch: Exception -> L57
        r111.i(r106, r112.toString());     // Catch: Exception -> L57
    L57:
        e = e;
    L58:
        FLogger.f375446a.e(r106, "requestActUpdate failed", e);
        return null;
    L54:
        r113 = null;
    L64:
        return r108;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r102);
        String r114 = r210.f516997a;
        String r115 = r210.f516998b;
        if (r114 != null) goto L20;
    L23:
        boolean r116 = true;
    L24:
        if (r116 == true) goto L63;
        if (r115 != null) goto L27;
    L30:
        boolean r117 = true;
    L31:
        if (r117 == true) goto L65;
        BDNetworkTagManager r118 = BDNetworkTagManager.getInstance();     // Catch: Exception -> L13
        if (r211 == false) goto L36;
        boolean r119 = true;
    L37:
        Pair<String, String> r120 = r118.buildBDNetworkTag(new d(r119));     // Catch: Exception -> L13
        JSONObject r121 = new JSONObject();     // Catch: Exception -> L13
        r121.put("access_token", r114);     // Catch: Exception -> L13
        r121.put(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, r210.f516999c);     // Catch: Exception -> L13
        r121.put("expire_time_in_second", r210.f517000d);     // Catch: Exception -> L13
        r121.put(Constants.JumpUrlConstants.URL_KEY_OPENID, r115);     // Catch: Exception -> L13
        if (r212 == null) goto L40;
        r121.put("update_scene", r212.getValue());     // Catch: Exception -> L13
    L40:
        Unit r122 = Unit.INSTANCE;     // Catch: Exception -> L13
        HashMap r123 = new HashMap();     // Catch: Exception -> L13
        r123.put("X-Flow-Aweme-Open-Id", r115);     // Catch: Exception -> L13
        r123.put(r120.first, r120.second);     // Catch: Exception -> L13
        r110.label = 1;     // Catch: Exception -> L13
        r106 = "DouyinHeartBeatServiceImpl";
        r107 = true;
        r105 = HttpExtKt.k(ServiceType.BASIC_SERVICE, a.class, "/alice/user/act_update", r121, null, r123, false, null, null, null, r110, TTVideoEngineInterface.PLAYER_OPTION_DUMMYSURFACE_FORBID);     // Catch: Exception -> L57
        if (r105 != r103) goto L45;
        return r103;
    L36:
        r119 = false;
        goto L37
    L65:
        return null;
    L27:
        if (StringsKt.isBlank(r115) == true) goto L30;
        r117 = false;
        goto L31
    L63:
        return null;
    L20:
        if (StringsKt.isBlank(r114) == true) goto L23;
        r116 = false;
    L13:
        e = e;
        r106 = "DouyinHeartBeatServiceImpl";
    L7:
        r100 = new DouyinHeartBeatServiceImpl$requestActUpdate$1(this, r213);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object f(DouyinHeartBeatServiceImpl r110, String r111, String r112, String r210, boolean r211, Continuation r212) {
        r110.getClass();
        if ((r212 instanceof DouyinHeartBeatServiceImpl$doHeartBeatRequest$1) == false) goto L7;
        DouyinHeartBeatServiceImpl$doHeartBeatRequest$1 r100 = (DouyinHeartBeatServiceImpl$doHeartBeatRequest$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DouyinHeartBeatServiceImpl$doHeartBeatRequest$1 r113 = r100;
        Object r102 = r113.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r113.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L22:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof y) == false) goto L30;
        b r106 = (b) ((y) r105).f360135b;
        if (r106 == null) goto L30;
        String r107 = r106.a();
        if (r107 == null) goto L30;
        FLogger.f375446a.i("DouyinHeartBeatServiceImpl", "responseHeartBeatRequest, accessToken:".concat(r107));
        r110.f326011a.storeString("cache_access_token", r107);
    L30:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (r111 == null) goto L31;
        if (r112 == null) goto L32;
        Pair<String, String> r108 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new h(r211));
        JSONObject r109 = new JSONObject();
        r109.put(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, r210);
        Unit r114 = Unit.INSTANCE;
        HashMap r115 = new HashMap();
        r115.put("X-Flow-Access-Token", r111);
        r115.put("X-Flow-Aweme-Open-Id", r112);
        r115.put(r108.first, r108.second);
        r113.label = 1;
        r102 = HttpExtKt.k(ServiceType.BASIC_SERVICE, b.class, "/alice/user/act_heartbeat", r109, null, r115, false, null, null, null, r113, TTVideoEngineInterface.PLAYER_OPTION_DUMMYSURFACE_FORBID);
        if (r102 != r103) goto L22;
        return r103;
    L32:
        return Unit.INSTANCE;
    L31:
        return Unit.INSTANCE;
    L7:
        r100 = new DouyinHeartBeatServiceImpl$doHeartBeatRequest$1(r110, r212);
        goto L8
    }
}
