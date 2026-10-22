package com.larus.account.base.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.autofill.HintConstants;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b48.b;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.model.PhoneLoginAccountDiscoverySource;
import com.larus.home.impl.sdk.o0;
import com.larus.login.impl.PhoneLoginFragment;
import com.larus.login.impl.VerificationCodeFragment;
import com.larus.login.impl.a0;
import com.larus.login.impl.activity.PhoneLoginActivity;
import com.larus.login.impl.b4;
import com.larus.login.impl.f2;
import com.larus.login.impl.h0;
import com.larus.login.impl.lark_discover.PhoneLoginAccountDiscoveryFragment;
import com.larus.login.impl.r3;
import com.larus.login.impl.s3;
import com.larus.login.impl.switchbind.SwitchBindViewModel;
import com.larus.login.impl.t3;
import com.larus.login.impl.u3;
import com.larus.login.impl.v3;
import com.larus.login.impl.w;
import com.larus.login.impl.w3;
import com.larus.login.impl.y3;
import com.larus.setting.impl.f3;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n38.e;
import n38.g;
import n38.h;
import n38.j;
import n38.m;
import n38.p;
import n38.t;
import n38.v;
import n38.x;
import n38.y;
import n38.z;
import org.json.JSONObject;
import q38.l;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u009a\u00012\u00020\u0001:\u0002\u009a\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J`\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH&J,\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0017H&JF\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u0003H&J<\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001c\u001a\u00020\u0003H&JP\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH&J^\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH&JL\u0010'\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&JL\u0010*\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\"\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020,2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&JH\u0010-\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH&JP\u00100\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00101\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH&J\u001a\u00102\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u00103\u001a\u000204H&J$\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J!\u00107\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002082\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010\b\u001a\u000208H&J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>H&J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>H&J6\u0010@\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\f2\b\b\u0002\u0010C\u001a\u00020\u00032\b\b\u0002\u0010D\u001a\u00020EH&J\b\u0010F\u001a\u00020GH&J\b\u0010H\u001a\u00020\fH&J\b\u0010I\u001a\u00020\u0003H&JX\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\f2!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u00070M2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010R¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00070MH&J\u0012\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010\u0004\u001a\u00020\u0005H&J:\u0010V\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\f2\b\u0010Z\u001a\u0004\u0018\u00010\f2\u0006\u0010[\u001a\u00020X2\u0006\u0010\b\u001a\u00020\\H&J(\u0010]\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010[\u001a\u00020X2\u0006\u0010\b\u001a\u00020\\H&J\u0018\u0010^\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\\H&J(\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010a\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\\H&J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\\H&J\u0010\u0010c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\\H&J\u0018\u0010d\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\\H&J\u0018\u0010f\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020gH&J\u0010\u0010h\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020iH&J(\u0010j\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\f2\u0006\u0010`\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\\H&J2\u0010k\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010Y\u001a\u00020\f2\b\u0010Z\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\\H&J \u0010l\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\f2\u0006\u0010W\u001a\u00020X2\u0006\u0010\b\u001a\u00020\\H&J\u0018\u0010m\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020nH&J\u0018\u0010o\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010p\u001a\u00020qH&J(\u0010r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020u2\u0006\u0010\b\u001a\u00020vH&J\u0012\u0010w\u001a\u0004\u0018\u00010x2\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010y\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010z\u001a\u0004\u0018\u00010\f2\b\u0010{\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010|H&J\u0010\u0010}\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0013\u0010~\u001a\u00020\u00072\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H&J\u001d\u0010\u0081\u0001\u001a\u00020\u00072\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010\b\u001a\u00030\u0082\u0001H&J0\u0010\u0083\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020X2\u0007\u0010\u0085\u0001\u001a\u00020X2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0007\u0010\b\u001a\u00030\u0082\u0001H&J\u0012\u0010\u0088\u0001\u001a\u00020\u00032\u0007\u0010\u0089\u0001\u001a\u00020\fH&J\u0012\u0010\u008a\u0001\u001a\u00020\u00032\u0007\u0010\u0089\u0001\u001a\u00020\fH&J\u001d\u0010\u008b\u0001\u001a\u00020\u00072\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010\b\u001a\u00030\u008c\u0001H&J\u0012\u0010\u008d\u0001\u001a\u00020\u00072\u0007\u0010\u007f\u001a\u00030\u0080\u0001H&J!\u0010\u008e\u0001\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH&J*\u0010\u008f\u0001\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\f2\u0006\u0010`\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0007\u0010\b\u001a\u00030\u0090\u0001H&J*\u0010\u0091\u0001\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\f2\u0006\u0010`\u001a\u00020\f2\u0007\u0010\u0092\u0001\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\\H&J)\u0010\u0093\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010a\u001a\u00020\f2\u0006\u0010\b\u001a\u00020vH&J\u0012\u0010\u0094\u0001\u001a\u00020\u00072\u0007\u0010=\u001a\u00030\u0095\u0001H&J\u0012\u0010\u0096\u0001\u001a\u00020\u00072\u0007\u0010=\u001a\u00030\u0095\u0001H&J\t\u0010\u0097\u0001\u001a\u00020\u0007H&J\u001b\u0010\u0098\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0011\u0010\u0099\u0001\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0003H&¨\u0006\u009b\u0001"}, d2 = {"Lcom/larus/account/base/api/ILoginService;", "", "isSupportedPlatform", "", "platform", "Lcom/larus/account/base/model/LoginPlatform;", "loginByOneTap", "", "callback", "Lcom/larus/account/base/api/IAccountCallback;", "enableAgeGate", "businessScene", "", "activity", "Landroid/app/Activity;", "trackerJson", "Lorg/json/JSONObject;", "useGoogleOntap", "forceBindMobile", "triggerAppId", "loginByLark", "Landroidx/fragment/app/FragmentActivity;", "secUid", "Lcom/larus/account/base/api/ILarkLoginCallback;", "sendVerificationCode", "account", "Lcom/larus/account/base/api/IVerificationCodeCallback;", "enableAutoRead", "is6Digit", "sendVoiceVerificationCode", "loginByVerificationCode", "mobile", "code", "loginByPhoneAccountDiscovery", "source", "Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;", "smsCodeKey", "mobileTicket", "registerNewUser", "authBindLoginWithProfileKey", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "profileKey", "bindLogin", "getPhoneInfo", "Lcom/larus/account/base/api/IPhoneOneKeyCallback;", "phoneOneKeyLogin", "ageGateManager", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "phoneValidateOneKeyLogin", "secretMobile", "onSaaSLogout", "info", "Lcom/larus/account/saas/model/AccountBaseInfo;", "logout", "forceLogout", "registerAccountStatusChangeListener", "Lcom/larus/account/base/api/IAccountStatusListener;", "isSticky", "(Lcom/larus/account/base/api/IAccountStatusListener;Ljava/lang/Boolean;)V", "unregisterAccountStatusChangeListener", "registerAccountBindStatusListener", "listener", "Lcom/larus/account/base/api/IAccountBindStatusListener;", "unregisterAccountBindStatusListener", "updateAccountToken", "Lcom/larus/account/base/api/IAccountTokenUpdateCallback;", "token", "isFromDelete", "extraInfo", "Landroid/os/Bundle;", "getAccountInfo", "Lcom/larus/account/base/model/AccountInfo;", "getXTToken", "isNewUser", "uploadAvatar", "path", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "onFail", "", "errorCode", "getPlatformUserInfo", "Lcom/larus/account/base/model/PlatformUserInfo;", "getBindingAccountInfo", "type", "", "ticket", "unusableMobileTicket", "isBindExit", "Lcom/larus/account/base/api/IBindCallback;", "checkVerificationCode", "unbindPlatform", "bindPlatform", "platformAppId", "authCode", "loginPlatform", "checkSafeEnvBeforeInputOldMobile", "checkSafeEnvBeforeSendCodeToOldMobile", "oldMobile", "checkOldPhoneUnusable", "Lcom/larus/account/base/api/ICheckMobileUnusableCallback;", "getAvailableVerifyWays", "Lcom/larus/account/base/api/IGetOauthPlatformsCallback;", "doAuthVerify", "changeMobileBind", "checkOldVerificationCode", "googleRequestAuth", "Lcom/larus/account/base/api/IGoogleAuthCallback;", "googleSignOut", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getDouYinAccessToken", "forceRequestServer", "triggerScene", "Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "Lcom/larus/account/base/api/IDouYinTokenUpdateCallback;", "getCacheDouYinAccessToken", "Lcom/larus/account/base/api/DouYinTokenResult;", "onNewAccountChange", "password", "captcha", "Lcom/larus/account/base/callback/FlowSaitamaLoginDelegateCallback;", "forceClearDouYinCacheToken", "getPhoneNumberByGoogle", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "getPhoneNumberBySim", "Lcom/larus/account/base/api/IGooglePhoneNumber;", "getPhoneNumberByActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "looseCheckPhoneNumber", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "strictCheckPhoneNumber", "autoGetSms", "Lcom/larus/account/base/api/IAutoSmsCode;", "endSmsListener", "ssoWithProfileKeyLogin", "getBindConflictUserInfo", "Lcom/larus/account/base/api/IBindConflictUserInfoCallback;", "solveConflictAndSwitchBind", "verifyTicket", "updateAuthorizeInfo", "addBindListener", "Lcom/larus/account/base/api/INewBindNotify;", "removeBindListener", "notifyNewBind", "loginStatusChangedToLogin", "setIsNewUser", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILoginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286097a = null;

    @Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016JX\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u001fH\u0016JB\u0010 \u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0016J:\u0010%\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\fH\u0016JN\u0010&\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\\\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016JL\u0010/\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016JL\u00102\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u00103\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u0002042\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016JF\u00105\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u0001072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016JN\u00108\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u0001072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010<\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010=\u001a\u00020>H\u0016J\u001f\u0010?\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010BJ\u0010\u0010C\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020@H\u0016J\u0010\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010E\u001a\u00020FH\u0016J0\u0010H\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020\u0005H\u0016J\b\u0010Q\u001a\u00020\fH\u0016JX\u0010R\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00052!\u0010T\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\u00100U2#\u0010Y\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010Z¢\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b([\u0012\u0004\u0012\u00020\u00100UH\u0016J\u0012\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010\r\u001a\u00020\u000eH\u0016J:\u0010^\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00052\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00052\b\u0010b\u001a\u0004\u0018\u00010\u00052\u0006\u0010c\u001a\u00020`2\u0006\u0010\u0011\u001a\u00020dH\u0016J(\u0010e\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010c\u001a\u00020`2\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0018\u0010f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J(\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0018\u0010g\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0010\u0010k\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0018\u0010l\u001a\u00020\u00102\u0006\u0010m\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0018\u0010n\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020oH\u0016J\u0010\u0010p\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020qH\u0016J(\u0010r\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J2\u0010s\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u00052\b\u0010b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J \u0010t\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00052\u0006\u0010_\u001a\u00020`2\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0018\u0010u\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020vH\u0016J\u0018\u0010w\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010x\u001a\u00020yH\u0016J(\u0010z\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010{\u001a\u00020\f2\u0006\u0010|\u001a\u00020}2\u0006\u0010\u0011\u001a\u00020~H\u0016J\u0010\u0010\u007f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0015\u0010\u0080\u0001\u001a\u00020\u00102\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0016J\u001e\u0010\u0083\u0001\u001a\u00020\u00102\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0007\u0010\u0011\u001a\u00030\u0084\u0001H\u0016J0\u0010\u0085\u0001\u001a\u00020\u00102\u0007\u0010\u0086\u0001\u001a\u00020`2\u0007\u0010\u0087\u0001\u001a\u00020`2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u0011\u001a\u00030\u0084\u0001H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020\f2\u0007\u0010\u008b\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010\u008c\u0001\u001a\u00020\f2\u0007\u0010\u008b\u0001\u001a\u00020\u0005H\u0016J\u001e\u0010\u008d\u0001\u001a\u00020\u00102\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0007\u0010\u0011\u001a\u00030\u008e\u0001H\u0016J\u0013\u0010\u008f\u0001\u001a\u00020\u00102\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J!\u0010\u0090\u0001\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0016J4\u0010\u0093\u0001\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\u00052\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0011\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J*\u0010\u0097\u0001\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0007\u0010\u0011\u001a\u00030\u0098\u0001H\u0016J*\u0010\u0099\u0001\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u00052\u0007\u0010\u009a\u0001\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0012\u0010\u009b\u0001\u001a\u00020\u00102\u0007\u0010E\u001a\u00030\u009c\u0001H\u0016J\u0012\u0010\u009d\u0001\u001a\u00020\u00102\u0007\u0010E\u001a\u00030\u009c\u0001H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0010H\u0016J)\u0010\u009f\u0001\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020~H\u0016J\u001b\u0010 \u0001\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0011\u0010¡\u0001\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006¢\u0001"}, d2 = {"Lcom/larus/account/base/api/ILoginService$Companion;", "Lcom/larus/account/base/api/ILoginService;", "<init>", "()V", "TAG", "", "impl", "getImpl", "()Lcom/larus/account/base/api/ILoginService;", "impl$delegate", "Lkotlin/Lazy;", "isSupportedPlatform", "", "platform", "Lcom/larus/account/base/model/LoginPlatform;", "loginByOneTap", "", "callback", "Lcom/larus/account/base/api/IAccountCallback;", "enableAgeGate", "businessScene", "activity", "Landroid/app/Activity;", "trackerJson", "Lorg/json/JSONObject;", "useGoogleOntap", "forceBindMobile", "triggerAppId", "loginByLark", "Landroidx/fragment/app/FragmentActivity;", "secUid", "Lcom/larus/account/base/api/ILarkLoginCallback;", "sendVerificationCode", "account", "Lcom/larus/account/base/api/IVerificationCodeCallback;", "enableAutoRead", "is6Digit", "sendVoiceVerificationCode", "loginByVerificationCode", "code", "loginByPhoneAccountDiscovery", "source", "Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;", "smsCodeKey", "mobile", "mobileTicket", "registerNewUser", "authBindLoginWithProfileKey", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "profileKey", "bindLogin", "getPhoneInfo", "Lcom/larus/account/base/api/IPhoneOneKeyCallback;", "phoneOneKeyLogin", "ageGateManager", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "phoneValidateOneKeyLogin", "secretMobile", "logout", "forceLogout", "onSaaSLogout", "info", "Lcom/larus/account/saas/model/AccountBaseInfo;", "registerAccountStatusChangeListener", "Lcom/larus/account/base/api/IAccountStatusListener;", "isSticky", "(Lcom/larus/account/base/api/IAccountStatusListener;Ljava/lang/Boolean;)V", "unregisterAccountStatusChangeListener", "registerAccountBindStatusListener", "listener", "Lcom/larus/account/base/api/IAccountBindStatusListener;", "unregisterAccountBindStatusListener", "updateAccountToken", "Lcom/larus/account/base/api/IAccountTokenUpdateCallback;", "token", "isFromDelete", "extraInfo", "Landroid/os/Bundle;", "getAccountInfo", "Lcom/larus/account/base/model/AccountInfo;", "getXTToken", "isNewUser", "uploadAvatar", "path", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "onFail", "", "errorCode", "getPlatformUserInfo", "Lcom/larus/account/base/model/PlatformUserInfo;", "getBindingAccountInfo", "type", "", "ticket", "unusableMobileTicket", "isBindExit", "Lcom/larus/account/base/api/IBindCallback;", "checkVerificationCode", "unbindPlatform", "bindPlatform", "platformAppId", "authCode", "loginPlatform", "checkSafeEnvBeforeInputOldMobile", "checkSafeEnvBeforeSendCodeToOldMobile", "oldMobile", "checkOldPhoneUnusable", "Lcom/larus/account/base/api/ICheckMobileUnusableCallback;", "getAvailableVerifyWays", "Lcom/larus/account/base/api/IGetOauthPlatformsCallback;", "doAuthVerify", "changeMobileBind", "checkOldVerificationCode", "googleRequestAuth", "Lcom/larus/account/base/api/IGoogleAuthCallback;", "googleSignOut", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getDouYinAccessToken", "forceRequestServer", "triggerScene", "Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "Lcom/larus/account/base/api/IDouYinTokenUpdateCallback;", "forceClearDouYinCacheToken", "getPhoneNumberByGoogle", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "getPhoneNumberBySim", "Lcom/larus/account/base/api/IGooglePhoneNumber;", "getPhoneNumberByActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "looseCheckPhoneNumber", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "strictCheckPhoneNumber", "autoGetSms", "Lcom/larus/account/base/api/IAutoSmsCode;", "endSmsListener", "ssoWithProfileKeyLogin", "getCacheDouYinAccessToken", "Lcom/larus/account/base/api/DouYinTokenResult;", "onNewAccountChange", "password", "captcha", "Lcom/larus/account/base/callback/FlowSaitamaLoginDelegateCallback;", "getBindConflictUserInfo", "Lcom/larus/account/base/api/IBindConflictUserInfoCallback;", "solveConflictAndSwitchBind", "verifyTicket", "addBindListener", "Lcom/larus/account/base/api/INewBindNotify;", "removeBindListener", "notifyNewBind", "updateAuthorizeInfo", "loginStatusChangedToLogin", "setIsNewUser", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ILoginService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f286098b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<ILoginService> f286099c = null;

        private Companion() {
        }

        static {
            f286098b = new Companion();
            f286099c = LazyKt.lazy(new v());
        }

        public static ILoginService Z() {
            return f286099c.getValue();
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void N() {
            Intrinsics.checkNotNullParameter("oneLogin", "businessScene");
            ILoginService r100 = Z();
            if (r100 == null) goto L6;
            r100.N();
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final String K() {
            ILoginService r100 = Z();
            if (r100 == null) goto L5;
            String r101 = r100.K();
        L6:
            if (r101 != null) goto L9;
            return "";
        L9:
            return r101;
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.larus.account.base.api.ILoginService
        public final q38.a getAccountInfo() {
            ILoginService r100 = Z();
            if (r100 == null) goto L7;
            q38.a r101 = r100.getAccountInfo();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return new q38.a(false, "", "", "", 0, "", false);
        }

        @Override // com.larus.account.base.api.ILoginService
        public final boolean isNewUser() {
            ILoginService r100 = Z();
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.isNewUser() != true) goto L7;
            return true;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void z() {
            ILoginService r100 = Z();
            if (r100 == null) goto L6;
            r100.z();
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final boolean C(LoginPlatform r100) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            ILoginService r101 = Z();
            if (r101 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.C(r100) != true) goto L7;
            return true;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void G(w r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.G(r100);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void H(x r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.H(r100);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void L(g r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.L(r100);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void Q(j r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.Q(r100);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void U(Fragment r100) {
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.U(r100);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void V(x r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.V(r100);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final e Y(LoginPlatform r100) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            ILoginService r101 = Z();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.Y(r100);
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void a(Fragment r100) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void k(LoginPlatform r100) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.k(r100);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void m(boolean r100) {
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.m(r100);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final l p(LoginPlatform r100) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            ILoginService r101 = Z();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.p(r100);
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void y(s3 r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.y(r100);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void B(String r100, y3 r101) {
            Intrinsics.checkNotNullParameter(r100, "mobile");
            Intrinsics.checkNotNullParameter(r101, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.B(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void E(LoginPlatform r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.E(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void I(Fragment r100, VerificationCodeFragment.b r101) {
            Intrinsics.checkNotNullParameter(r101, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.I(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void M(String r100, b r101) {
            Intrinsics.checkNotNullParameter(r101, "info");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.M(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void T(LoginPlatform r100, f3 r101) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r101, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.T(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void b(String r100, o0 r101) {
            Intrinsics.checkNotNullParameter("8943", "platformAppId");
            Intrinsics.checkNotNullParameter("aweme_v2", "platform");
            Intrinsics.checkNotNullParameter(r100, "authCode");
            Intrinsics.checkNotNullParameter(r101, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.b(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void e(String r100, m r101) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r101, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.e(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void f(j r100, Boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.f(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void i(y r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.i(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void n(String r100, PhoneLoginFragment.b r101) {
            Intrinsics.checkNotNullParameter(r100, "oldMobile");
            Intrinsics.checkNotNullParameter(r101, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.n(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void o(String r100, t3 r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            Intrinsics.checkNotNullParameter(r101, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.o(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void v(LoginPlatform r100, m r101) {
            Intrinsics.checkNotNullParameter(r100, "loginPlatform");
            Intrinsics.checkNotNullParameter(r101, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.v(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void l(String r100, String r101, w3 r102) {
            Intrinsics.checkNotNullParameter(r100, "mobile");
            Intrinsics.checkNotNullParameter(r101, "code");
            Intrinsics.checkNotNullParameter(r102, "callback");
            ILoginService r103 = Z();
            if (r103 == null) goto L6;
            r103.l(r100, r101, r102);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void s(String r100, Function1<? super String, Unit> r101, Function1<? super Long, Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, "path");
            Intrinsics.checkNotNullParameter(r101, "onSuccess");
            Intrinsics.checkNotNullParameter(r102, "onFail");
            ILoginService r103 = Z();
            if (r103 == null) goto L6;
            r103.s(r100, r101, r102);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void t(LoginPlatform r100, h0.c r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter("PhoneOneKeyLoginFragment", "account");
            Intrinsics.checkNotNullParameter(r101, "callback");
            ILoginService r103 = Z();
            if (r103 == null) goto L6;
            r103.t(r100, r101, r102);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void u(LoginPlatform r100, String r101, f2 r102) {
            Intrinsics.checkNotNullParameter(r100, "loginPlatform");
            Intrinsics.checkNotNullParameter(r101, "profileKey");
            Intrinsics.checkNotNullParameter(r102, "callback");
            ILoginService r103 = Z();
            if (r103 == null) goto L6;
            r103.u(r100, r101, r102);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void x(boolean r100, h r101, String r102) {
            ILoginService r103 = Z();
            if (r103 == null) goto L6;
            r103.x(r100, r101, r102);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void A(String r100, String r101, String r102, SwitchBindViewModel.C114781.AnonymousClass2 r103) {
            Intrinsics.checkNotNullParameter(r100, "profileKey");
            Intrinsics.checkNotNullParameter(r101, "platformAppId");
            Intrinsics.checkNotNullParameter(r102, "platform");
            Intrinsics.checkNotNullParameter(r103, "callback");
            ILoginService r104 = Z();
            if (r104 == null) goto L6;
            r104.A(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void O(FragmentActivity r100, String r101, String r102, t r103) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "businessScene");
            Intrinsics.checkNotNullParameter(r103, "callback");
            ILoginService r104 = Z();
            if (r104 == null) goto L6;
            r104.O(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void R(int r100, int r101, Intent r102, PhoneLoginActivity.a r103) {
            Intrinsics.checkNotNullParameter(r103, "callback");
            ILoginService r104 = Z();
            if (r104 == null) goto L6;
            r104.R(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void S(String r100, String r101, String r102, a0.a r103) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "platformAppId");
            Intrinsics.checkNotNullParameter(r102, "platform");
            Intrinsics.checkNotNullParameter(r103, "callback");
            ILoginService r104 = Z();
            if (r104 == null) goto L6;
            r104.S(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void c(String r100, String r101, String r102, SwitchBindViewModel.AnonymousClass1.a r103) {
            Intrinsics.checkNotNullParameter(r100, "profileKey");
            Intrinsics.checkNotNullParameter(r101, "platformAppId");
            Intrinsics.checkNotNullParameter(r102, "verifyTicket");
            Intrinsics.checkNotNullParameter(r103, "callback");
            ILoginService r104 = Z();
            if (r104 == null) goto L6;
            r104.c(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void q(String r100, String r101, String r102, m r103) {
            Intrinsics.checkNotNullParameter(r100, "platformAppId");
            Intrinsics.checkNotNullParameter(r101, "platform");
            Intrinsics.checkNotNullParameter(r102, "authCode");
            Intrinsics.checkNotNullParameter(r103, "callback");
            ILoginService r104 = Z();
            if (r104 == null) goto L6;
            r104.q(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void w(LoginPlatform r100, boolean r101, GetOauthTokenTriggerScene r102, p r103) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r102, "triggerScene");
            Intrinsics.checkNotNullParameter(r103, "callback");
            ILoginService r104 = Z();
            if (r104 == null) goto L6;
            r104.w(r100, r101, r102, r103);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void D(LoginPlatform r100, String r101, b4 r110, boolean r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r101, "account");
            Intrinsics.checkNotNullParameter(r110, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.D(r100, r101, r110, r111, r112);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void F(LoginPlatform r100, n38.l r101, String r110, boolean r111, Bundle r112) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r101, "callback");
            Intrinsics.checkNotNullParameter(r110, "token");
            Intrinsics.checkNotNullParameter(r112, "extraInfo");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.F(r100, r101, r110, r111, r112);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void W(String r100, int r101, String r110, String r111, m r112) {
            Intrinsics.checkNotNullParameter(r100, "mobile");
            Intrinsics.checkNotNullParameter(r110, "ticket");
            Intrinsics.checkNotNullParameter(r112, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.W(r100, r101, r110, r111, r112);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void h(LoginPlatform r100, String r101, String r110, h0.d r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r101, "secretMobile");
            Intrinsics.checkNotNullParameter(r110, "account");
            Intrinsics.checkNotNullParameter(r111, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.h(r100, r101, r110, r111, r112);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void r(String r100, String r101, String r110, String r111, r3 r112) {
            Intrinsics.checkNotNullParameter(r100, "mobile");
            Intrinsics.checkNotNullParameter(r101, "code");
            Intrinsics.checkNotNullParameter(r110, "ticket");
            Intrinsics.checkNotNullParameter(r112, "callback");
            ILoginService r102 = Z();
            if (r102 == null) goto L6;
            r102.r(r100, r101, r110, r111, r112);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void d(LoginPlatform r100, String r110, String r111, String r112, v3 r113, JSONObject r114) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter("15210", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
            Intrinsics.checkNotNullParameter(r110, "account");
            Intrinsics.checkNotNullParameter(r111, "code");
            Intrinsics.checkNotNullParameter(r112, "profileKey");
            Intrinsics.checkNotNullParameter(r113, "callback");
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.d(r100, r110, r111, r112, r113, r114);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void g(LoginPlatform r100, String r110, String r111, String r112, u3 r113, JSONObject r114) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter("15210", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
            Intrinsics.checkNotNullParameter(r110, "account");
            Intrinsics.checkNotNullParameter(r111, "code");
            Intrinsics.checkNotNullParameter(r112, "profileKey");
            Intrinsics.checkNotNullParameter(r113, "callback");
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.g(r100, r110, r111, r112, r113, r114);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void j(LoginPlatform r100, String r110, z r111, boolean r112, String r113, boolean r114, boolean r115) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r110, "account");
            Intrinsics.checkNotNullParameter(r111, "callback");
            ILoginService r101 = Z();
            if (r101 == null) goto L6;
            r101.j(r100, r110, r111, r112, r113, r115, true);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void J(LoginPlatform r110, String r111, String r112, h r113, boolean r114, String r115, JSONObject r116, String r117) {
            Intrinsics.checkNotNullParameter(r110, "platform");
            Intrinsics.checkNotNullParameter(r111, "account");
            Intrinsics.checkNotNullParameter(r112, "code");
            Intrinsics.checkNotNullParameter(r113, "callback");
            ILoginService r100 = Z();
            if (r100 == null) goto L6;
            a.b(r100, r110, r111, r112, r113, r114, r115, r116);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void X(PhoneLoginAccountDiscoverySource r110, String r111, String r112, String r113, String r114, boolean r115, PhoneLoginAccountDiscoveryFragment.b r116, String r117) {
            Intrinsics.checkNotNullParameter(r110, "source");
            Intrinsics.checkNotNullParameter(r116, "callback");
            ILoginService r100 = Z();
            if (r100 == null) goto L6;
            r100.X(r110, r111, r112, r113, r114, r115, r116, r117);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void P(LoginPlatform r110, h r111, boolean r112, String r113, FragmentActivity r114, JSONObject r115, boolean r116, boolean r210, String r211) {
            Intrinsics.checkNotNullParameter(r110, "platform");
            Intrinsics.checkNotNullParameter(r111, "callback");
            ILoginService r100 = Z();
            if (r100 == null) goto L6;
            a.a(r100, r110, r111, r112, r113, r114, r115, r116, r210, null, 256);
            return;
        }
    }

    public static final class a {
        public static /* synthetic */ void c(ILoginService r100, j r101) {
            r100.f(r101, Boolean.FALSE);
        }

        public static /* synthetic */ void d(ILoginService r100, LoginPlatform r101, n38.l r102, String r103, boolean r110, Bundle r111, int r112) {
            if ((r112 & 4) == 0) goto L5;
            r103 = "";
        L5:
            String r104 = r103;
            if ((r112 & 8) == 0) goto L8;
            boolean r105 = false;
        L10:
            if ((r112 & 16) == 0) goto L12;
            r111 = new Bundle();
        L12:
            r100.F(r101, r102, r104, r105, r111);
            return;
        L8:
            r105 = r110;
            goto L10
        }

        public static /* synthetic */ void b(ILoginService r100, LoginPlatform r110, String r111, String r112, h r113, boolean r114, String r115, JSONObject r116) {
            r100.J(r110, r111, r112, r113, r114, r115, r116, null);
        }

        public static /* synthetic */ void a(ILoginService r110, LoginPlatform r111, h r112, boolean r113, String r114, FragmentActivity r115, JSONObject r116, boolean r210, boolean r211, String r212, int r213) {
            if ((r213 & 32) == 0) goto L5;
            JSONObject r100 = null;
        L7:
            if ((r213 & 64) == 0) goto L9;
            boolean r117 = false;
        L11:
            if ((r213 & 128) == 0) goto L13;
            boolean r118 = false;
        L15:
            if ((r213 & 256) == 0) goto L17;
            String r119 = null;
        L18:
            r110.P(r111, r112, r113, r114, r115, r100, r117, r118, r119);
            return;
        L17:
            r119 = r212;
            goto L18
        L13:
            r118 = r211;
            goto L15
        L9:
            r117 = r210;
            goto L11
        L5:
            r100 = r116;
            goto L7
        }
    }

    static {
        f286097a = Companion.f286098b;
    }

    void A(String r100, String r101, String r102, SwitchBindViewModel.C114781.AnonymousClass2 r103);

    void B(String r100, y3 r101);

    boolean C(LoginPlatform r100);

    void D(LoginPlatform r100, String r101, b4 r102, boolean r103, boolean r104);

    void E(LoginPlatform r100, Context r101);

    void F(LoginPlatform r100, n38.l r101, String r102, boolean r103, Bundle r104);

    void G(w r100);

    void H(x r100);

    void I(Fragment r100, VerificationCodeFragment.b r101);

    void J(LoginPlatform r100, String r101, String r102, h r103, boolean r104, String r105, JSONObject r106, String r107);

    String K();

    void L(g r100);

    void M(String r100, b r101);

    void N();

    void O(FragmentActivity r100, String r101, String r102, t r103);

    void P(LoginPlatform r100, h r101, boolean r102, String r103, FragmentActivity r104, JSONObject r105, boolean r106, boolean r107, String r108);

    void Q(j r100);

    void R(int r100, int r101, Intent r102, PhoneLoginActivity.a r103);

    void S(String r100, String r101, String r102, a0.a r103);

    void T(LoginPlatform r100, f3 r101);

    void U(Fragment r100);

    void V(x r100);

    void W(String r100, int r101, String r102, String r103, m r104);

    void X(PhoneLoginAccountDiscoverySource r100, String r101, String r102, String r103, String r104, boolean r105, PhoneLoginAccountDiscoveryFragment.b r106, String r107);

    e Y(LoginPlatform r100);

    void a(Fragment r100);

    void b(String r100, o0 r101);

    void c(String r100, String r101, String r102, SwitchBindViewModel.AnonymousClass1.a r103);

    void d(LoginPlatform r100, String r101, String r102, String r103, v3 r104, JSONObject r105);

    void e(String r100, m r101);

    void f(j r100, Boolean r101);

    void g(LoginPlatform r100, String r101, String r102, String r103, u3 r104, JSONObject r105);

    q38.a getAccountInfo();

    void h(LoginPlatform r100, String r101, String r102, h0.d r103, String r104);

    void i(y r100, String r101);

    boolean isNewUser();

    void j(LoginPlatform r100, String r101, z r102, boolean r103, String r104, boolean r105, boolean r106);

    void k(LoginPlatform r100);

    void l(String r100, String r101, w3 r102);

    void m(boolean r100);

    void n(String r100, PhoneLoginFragment.b r101);

    void o(String r100, t3 r101);

    l p(LoginPlatform r100);

    void q(String r100, String r101, String r102, m r103);

    void r(String r100, String r101, String r102, String r103, r3 r104);

    void s(String r100, Function1<? super String, Unit> r101, Function1<? super Long, Unit> r102);

    void t(LoginPlatform r100, h0.c r101, String r102);

    void u(LoginPlatform r100, String r101, f2 r102);

    void v(LoginPlatform r100, m r101);

    void w(LoginPlatform r100, boolean r101, GetOauthTokenTriggerScene r102, p r103);

    void x(boolean r100, h r101, String r102);

    void y(s3 r100);

    void z();
}
