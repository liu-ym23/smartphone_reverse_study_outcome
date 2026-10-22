package com.larus.common.account.phone;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.impl.d;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginServiceIniter;
import com.larus.account.base.impl.LoginServiceImpl;
import com.larus.account.base.impl.m;
import com.larus.account.base.impl.o;
import com.larus.account.base.impl.p;
import com.larus.account.base.impl.q;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.model.PhoneLoginAccountDiscoverySource;
import com.larus.account.base.provider.IVerificationCodeLoginProvider;
import com.larus.account.base.provider.agegate.AgeGateManagerService;
import com.larus.common.apphost.AppHost;
import com.larus.login.impl.b4;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import n38.h;
import n38.z;
import org.json.JSONObject;
import ta7.g;
import ua7.e;
import wb7.i;
import yz8.c;
import yz8.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004JB\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J:\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J*\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J<\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016JD\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016JN\u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016JR\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010-\u001a\u00020\rH\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J$\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J2\u00101\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002JN\u00102\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u00103\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J,\u00104\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00106\u001a\u00020\rH\u0016J\u0010\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/common/account/phone/PhoneLogin;", "Lcom/larus/account/base/provider/IVerificationCodeLoginProvider;", "Lcom/larus/account/base/provider/agegate/IAgeGateResultCallback;", "<init>", "()V", "TAG", "", "authOppoSite", "", "CODE_UNREGISTER", "loginData", "Lcom/larus/common/account/phone/PhoneLogin$PhoneLoginData;", "sendCode", "", "platform", "Lcom/larus/account/base/model/LoginPlatform;", "account", "callback", "Lcom/larus/account/base/api/IVerificationCodeCallback;", "enableAgeGate", "", "businessScene", "enableAutoRead", "is6Digit", "sendVoiceCode", "getPhoneInfo", "Lcom/larus/account/base/api/IPhoneOneKeyCallback;", "phoneOneKeyLogin", "Lcom/larus/account/base/api/IAccountCallback;", "ageGateManager", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "phoneValidateOneKeyLogin", "secretMobile", "login", "code", "trackerJson", "Lorg/json/JSONObject;", "loginByAccountDiscovery", "source", "Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;", "smsCodeKey", "mobile", "mobileTicket", "secUid", "registerNewUser", "init", "providePlatform", "logout", "forceLogout", "doPhoneLogin", "doLoginOnlyWithAgeGate", "ageGateCallback", "startLoginForContinue", "smsKey", "onPassAgeGateSuccess", "onPassAgeGateFailed", "errorCode", "PhoneLoginData", "phonelogin_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhoneLogin implements IVerificationCodeLoginProvider, s38.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f326088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f326089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f326090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f326091d;

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f326092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LoginPlatform f326093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f326094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h f326095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f326096e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f326097f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final e<i> f326098g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f326092a, r101.f326092a) == true) goto L12;
            return false;
        L12:
            if (this.f326093b == r101.f326093b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f326094c, r101.f326094c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f326095d, r101.f326095d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f326096e, r101.f326096e) == true) goto L24;
            return false;
        L24:
            if (this.f326097f == r101.f326097f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f326098g, r101.f326098g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f326092a.hashCode() * 31) + this.f326093b.hashCode()) * 31) + this.f326094c.hashCode()) * 31) + this.f326095d.hashCode()) * 31;
            String r101 = this.f326096e;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f326097f) * 31;
            e<i> r105 = this.f326098g;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "PhoneLoginData(account=" + this.f326092a + ", platform=" + this.f326093b + ", code=" + this.f326094c + ", callback=" + this.f326095d + ", businessScene=" + this.f326096e + ", errorCode=" + this.f326097f + ", response=" + this.f326098g + ')';
        }

        public a(String r100, LoginPlatform r101, String r102, h r103, String r104, int r105, e<i> r106) {
            Intrinsics.checkNotNullParameter(r100, "account");
            Intrinsics.checkNotNullParameter(r101, "platform");
            Intrinsics.checkNotNullParameter(r102, "code");
            Intrinsics.checkNotNullParameter(r103, "callback");
            this.f326092a = r100;
            this.f326093b = r101;
            this.f326094c = r102;
            this.f326095d = r103;
            this.f326096e = r104;
            this.f326097f = r105;
            this.f326098g = r106;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f326099a = null;

        static {
            int[] r100 = new int[PhoneLoginAccountDiscoverySource.values().length];
            r100[PhoneLoginAccountDiscoverySource.VERIFICATION_CODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PhoneLoginAccountDiscoverySource.CARRIER_ONE_KEY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f326099a = r100;
        }
    }

    @Override // com.larus.account.base.provider.ILoginProvider
    public final void init() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.isOversea() == true) goto L6;
        int r101 = u38.b.f548611a;
        OnekeyLoginServiceIniter r102 = new OnekeyLoginServiceIniter(new OnekeyLoginConfig(new u38.a()).getDefault(false));
        r102.init(r100.getApplication());
        AuthorizeFramework.init(r100.getApplication(), new OnekeyLoginServiceIniter[]{r102});
        return;
    }

    @Override // s38.b
    public final void l() {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f326088a, "PhoneLogin onPassAgeGateSuccess");
        a r101 = this.f326091d;
        if (r101 == null) goto L11;
        String r102 = r101.f326092a;
        e<i> r103 = r101.f326098g;
        if (r103 == null) goto L9;
        i r104 = (i) r103.f549264p;
        if (r104 == null) goto L9;
        String r105 = r104.f559023e;
    L10:
        h r106 = r101.f326095d;
        String r107 = r101.f326096e;
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("app_name", AppHost.f326268a.getAppName());
        g r109 = d.l();
        d r110 = (d) r109;
        r110.n(r102, r105, r108, new yz8.i(r106, this, r107));
        return;
    L9:
        r105 = null;
        goto L10
    L11:
        r100.i(this.f326088a, "PhoneLogin onPassAgeGateSuccess but loginData is null !!!");
    }

    public PhoneLogin() {
        this.f326088a = "PhoneLogin";
        this.f326089b = 1;
        this.f326090c = 1011;
    }

    @Override // com.larus.account.base.provider.ILoginProvider
    public final LoginPlatform c() {
        return LoginPlatform.PHONE;
    }

    @Override // s38.b
    public final void A(int r110) {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f326088a, "PhoneLogin onPassAgeGateFailed");
        a r101 = this.f326091d;
        if (r101 == null) goto L14;
        h r102 = r101.f326095d;
        if (r102 == null) goto L12;
        LoginPlatform r103 = r101.f326093b;
        e<i> r104 = r101.f326098g;
        if (r104 == null) goto L10;
        String r105 = r104.f549255i;
        if (r105 == null) goto L10;
    L11:
        h.a.a(r102, r103, r110, r105, r101.f326096e, null, null, null, null, 480);
        Unit r111 = Unit.INSTANCE;
    L13:
        if (r111 == null) goto L14;
        return;
    L10:
        r105 = "";
        goto L11
    L12:
        r111 = null;
    L14:
        r100.i(this.f326088a, "PhoneLogin onPassAgeGateFailed and loginData is null !!!");
    }

    @Override // com.larus.account.base.provider.IVerificationCodeLoginProvider
    public final void e(LoginPlatform r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter(r101, "callback");
        IOnekeyLoginService r102 = (IOnekeyLoginService) AuthorizeFramework.getService(IOnekeyLoginService.class);
        if (r102 == null) goto L6;
        r102.getPhoneInfo(new yz8.b(r102, r101));
        return;
    }

    @Override // com.larus.account.base.provider.IVerificationCodeLoginProvider
    public final void g(LoginPlatform r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter("PhoneOneKeyLoginFragment", "account");
        Intrinsics.checkNotNullParameter(r101, "callback");
        IOnekeyLoginService r102 = (IOnekeyLoginService) AuthorizeFramework.getService(IOnekeyLoginService.class);
        yz8.e r103 = new yz8.e(r101, AppHost.f326268a.getApplication());
        if (r102 == null) goto L6;
        r102.getAuthToken(r103);
        return;
    }

    @Override // com.larus.account.base.provider.ILoginProvider
    public final void o(h r100, String r101) {
        FLogger.f375446a.i(this.f326088a, "logout");
        if (r100 == null) goto L6;
        h.a.b(r100, LoginPlatform.PHONE, r101);
        return;
    }

    @Override // com.larus.account.base.provider.IVerificationCodeLoginProvider
    public final void d(LoginPlatform r100, String r101, String r102, q r110) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter(r101, "secretMobile");
        Intrinsics.checkNotNullParameter(r102, "account");
        Intrinsics.checkNotNullParameter(r110, "callback");
        f r103 = new f(r101, r102, this, r110, AppHost.f326268a.getApplication());
        ((IOnekeyLoginService) AuthorizeFramework.getService(IOnekeyLoginService.class)).getValidateToken(r103);
    }

    @Override // com.larus.account.base.provider.IVerificationCodeLoginProvider
    public final void y(LoginPlatform r100, String r101, b4 r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter(r101, "account");
        Intrinsics.checkNotNullParameter(r102, "callback");
        LinkedHashMap r104 = new LinkedHashMap();
        if (r103 == false) goto L5;
        String r105 = "1";
    L6:
        r104.put("is6Digits", r105);
        r104.put("app_name", AppHost.f326268a.getAppName());
        FLogger.f375446a.i(this.f326088a, "sendCode");
        g r106 = d.l();
        d r107 = (d) r106;
        r107.t(r101, r104, new yz8.h(r102));
        return;
    L5:
        r105 = "0";
        goto L6
    }

    @Override // com.larus.account.base.provider.IVerificationCodeLoginProvider
    public final void s(LoginPlatform r100, String r101, z r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter(r101, "account");
        Intrinsics.checkNotNullParameter(r102, "callback");
        LinkedHashMap r105 = new LinkedHashMap();
        if (r104 == false) goto L5;
        String r106 = "1";
    L6:
        r105.put("is6Digits", r106);
        r105.put("app_name", AppHost.f326268a.getAppName());
        if (r103 == false) goto L9;
        r105.put("auto_read", "1");
    L9:
        FLogger.f375446a.i(this.f326088a, "sendCode");
        g r107 = d.l();
        d r108 = (d) r107;
        r108.s(r101, 24, r105, new yz8.g(r102));
        return;
    L5:
        r106 = "0";
        goto L6
    }

    @Override // com.larus.account.base.provider.IVerificationCodeLoginProvider
    public final void u(PhoneLoginAccountDiscoverySource r100, String r101, String r102, String r103, String r104, boolean r105, o r106) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r106, "callback");
        LinkedHashMap r107 = new LinkedHashMap();
        if (r105 == false) goto L6;
        r107.put("register_new_user", "true");
    L6:
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r107.put("sec_uid", r104);
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        r107.put("mobile_ticket", r103);
        int r108 = b.f326099a[r100.ordinal()];
        if (r108 != 1) goto L14;
        r107.put("sms_code_key", StringUtils.encryptWithXor(r101));
        r107.put("mobile", StringUtils.encryptWithXor(r102));
        g r109 = d.l();
        d r110 = (d) r109;
        r110.m("", "", Integer.valueOf(this.f326089b), null, r107, new c(r106, this));
        return;
    L14:
        if (r108 != 2) goto L19;
        if (r101 != null) goto L17;
        r101 = "";
    L17:
        r107.put("sms_code_key", r101);
        g r111 = d.l();
        d r112 = (d) r111;
        r112.e("", "", "", r107, new yz8.d(r106, this));
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.account.base.provider.IVerificationCodeLoginProvider
    public final void f(LoginPlatform r110, String r111, String r112, LoginServiceImpl.d r210, boolean r211, String r212, AgeGateManagerService r213, JSONObject r214) {
        Intrinsics.checkNotNullParameter(r110, "platform");
        Intrinsics.checkNotNullParameter(r111, "account");
        Intrinsics.checkNotNullParameter(r112, "code");
        Intrinsics.checkNotNullParameter(r210, "callback");
        if (r211 == false) goto L5;
        FLogger.f375446a.i(this.f326088a, "doLoginOnlyWithAgeGate");
        LinkedHashMap r113 = new LinkedHashMap();
        r113.put("app_name", AppHost.f326268a.getAppName());
        g r114 = d.l();
        d r115 = (d) r114;
        r115.o(r111, r112, r113, new com.larus.common.account.phone.a(r210, r110, r212, this, r111, r112, r213, this, r214));
        return;
    L5:
        FLogger.f375446a.i(this.f326088a, "doPhoneLogin");
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("app_name", AppHost.f326268a.getAppName());
        g r101 = d.l();
        d r102 = (d) r101;
        r102.m(r111, r112, Integer.valueOf(this.f326089b), null, r100, new yz8.a(r210, this, r212, r110));
    }
}
