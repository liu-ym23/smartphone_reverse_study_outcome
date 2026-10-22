package com.larus.account.base.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.EventsUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b48.b;
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
import org.xmlpull.v1.XmlPullParser;
import q38.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u009a\u00012\u00020\u0001:\u0002\u009a\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J`\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH&J,\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0017H&JF\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u0003H&J<\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001c\u001a\u00020\u0003H&JP\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH&J^\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH&JL\u0010'\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&JL\u0010*\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\"\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020,2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&JH\u0010-\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH&JP\u00100\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00101\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH&J\u001a\u00102\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u00103\u001a\u000204H&J$\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J!\u00107\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002082\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010\b\u001a\u000208H&J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>H&J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>H&J6\u0010@\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\f2\b\b\u0002\u0010C\u001a\u00020\u00032\b\b\u0002\u0010D\u001a\u00020EH&J\b\u0010F\u001a\u00020GH&J\b\u0010H\u001a\u00020\fH&J\b\u0010I\u001a\u00020\u0003H&JX\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\f2!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u00070M2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010R¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00070MH&J\u0012\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010\u0004\u001a\u00020\u0005H&J:\u0010V\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\f2\b\u0010Z\u001a\u0004\u0018\u00010\f2\u0006\u0010[\u001a\u00020X2\u0006\u0010\b\u001a\u00020\\H&J(\u0010]\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010[\u001a\u00020X2\u0006\u0010\b\u001a\u00020\\H&J\u0018\u0010^\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\\H&J(\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010a\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\\H&J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\\H&J\u0010\u0010c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\\H&J\u0018\u0010d\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\\H&J\u0018\u0010f\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020gH&J\u0010\u0010h\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020iH&J(\u0010j\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\f2\u0006\u0010`\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\\H&J2\u0010k\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010Y\u001a\u00020\f2\b\u0010Z\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\\H&J \u0010l\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\f2\u0006\u0010W\u001a\u00020X2\u0006\u0010\b\u001a\u00020\\H&J\u0018\u0010m\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020nH&J\u0018\u0010o\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010p\u001a\u00020qH&J(\u0010r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020u2\u0006\u0010\b\u001a\u00020vH&J\u0012\u0010w\u001a\u0004\u0018\u00010x2\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010y\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010z\u001a\u0004\u0018\u00010\f2\b\u0010{\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010|H&J\u0010\u0010}\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0013\u0010~\u001a\u00020\u00072\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H&J\u001d\u0010\u0081\u0001\u001a\u00020\u00072\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010\b\u001a\u00030\u0082\u0001H&J0\u0010\u0083\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020X2\u0007\u0010\u0085\u0001\u001a\u00020X2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0007\u0010\b\u001a\u00030\u0082\u0001H&J\u0012\u0010\u0088\u0001\u001a\u00020\u00032\u0007\u0010\u0089\u0001\u001a\u00020\fH&J\u0012\u0010\u008a\u0001\u001a\u00020\u00032\u0007\u0010\u0089\u0001\u001a\u00020\fH&J\u001d\u0010\u008b\u0001\u001a\u00020\u00072\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010\b\u001a\u00030\u008c\u0001H&J\u0012\u0010\u008d\u0001\u001a\u00020\u00072\u0007\u0010\u007f\u001a\u00030\u0080\u0001H&J!\u0010\u008e\u0001\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH&J*\u0010\u008f\u0001\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\f2\u0006\u0010`\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0007\u0010\b\u001a\u00030\u0090\u0001H&J*\u0010\u0091\u0001\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\f2\u0006\u0010`\u001a\u00020\f2\u0007\u0010\u0092\u0001\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\\H&J)\u0010\u0093\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010a\u001a\u00020\f2\u0006\u0010\b\u001a\u00020vH&J\u0012\u0010\u0094\u0001\u001a\u00020\u00072\u0007\u0010=\u001a\u00030\u0095\u0001H&J\u0012\u0010\u0096\u0001\u001a\u00020\u00072\u0007\u0010=\u001a\u00030\u0095\u0001H&J\t\u0010\u0097\u0001\u001a\u00020\u0007H&J\u001b\u0010\u0098\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0011\u0010\u0099\u0001\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0003H&¨\u0006\u009b\u0001"}, d2 = {"Lcom/larus/account/base/api/ILoginService;", XmlPullParser.NO_NAMESPACE, "isSupportedPlatform", XmlPullParser.NO_NAMESPACE, "platform", "Lcom/larus/account/base/model/LoginPlatform;", "loginByOneTap", XmlPullParser.NO_NAMESPACE, "callback", "Lcom/larus/account/base/api/IAccountCallback;", "enableAgeGate", "businessScene", XmlPullParser.NO_NAMESPACE, "activity", "Landroid/app/Activity;", "trackerJson", "Lorg/json/JSONObject;", "useGoogleOntap", "forceBindMobile", "triggerAppId", "loginByLark", "Landroidx/fragment/app/FragmentActivity;", "secUid", "Lcom/larus/account/base/api/ILarkLoginCallback;", "sendVerificationCode", "account", "Lcom/larus/account/base/api/IVerificationCodeCallback;", "enableAutoRead", "is6Digit", "sendVoiceVerificationCode", "loginByVerificationCode", "mobile", "code", "loginByPhoneAccountDiscovery", "source", "Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;", "smsCodeKey", "mobileTicket", "registerNewUser", "authBindLoginWithProfileKey", "platformId", "profileKey", "bindLogin", "getPhoneInfo", "Lcom/larus/account/base/api/IPhoneOneKeyCallback;", "phoneOneKeyLogin", "ageGateManager", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "phoneValidateOneKeyLogin", "secretMobile", "onSaaSLogout", "info", "Lcom/larus/account/saas/model/AccountBaseInfo;", "logout", "forceLogout", "registerAccountStatusChangeListener", "Lcom/larus/account/base/api/IAccountStatusListener;", "isSticky", "(Lcom/larus/account/base/api/IAccountStatusListener;Ljava/lang/Boolean;)V", "unregisterAccountStatusChangeListener", "registerAccountBindStatusListener", "listener", "Lcom/larus/account/base/api/IAccountBindStatusListener;", "unregisterAccountBindStatusListener", "updateAccountToken", "Lcom/larus/account/base/api/IAccountTokenUpdateCallback;", "token", "isFromDelete", "extraInfo", "Landroid/os/Bundle;", "getAccountInfo", "Lcom/larus/account/base/model/AccountInfo;", "getXTToken", "isNewUser", "uploadAvatar", "path", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "onFail", XmlPullParser.NO_NAMESPACE, "errorCode", "getPlatformUserInfo", "Lcom/larus/account/base/model/PlatformUserInfo;", "getBindingAccountInfo", "type", XmlPullParser.NO_NAMESPACE, "ticket", "unusableMobileTicket", "isBindExit", "Lcom/larus/account/base/api/IBindCallback;", "checkVerificationCode", "unbindPlatform", "bindPlatform", "platformAppId", "authCode", "loginPlatform", "checkSafeEnvBeforeInputOldMobile", "checkSafeEnvBeforeSendCodeToOldMobile", "oldMobile", "checkOldPhoneUnusable", "Lcom/larus/account/base/api/ICheckMobileUnusableCallback;", "getAvailableVerifyWays", "Lcom/larus/account/base/api/IGetOauthPlatformsCallback;", "doAuthVerify", "changeMobileBind", "checkOldVerificationCode", "googleRequestAuth", "Lcom/larus/account/base/api/IGoogleAuthCallback;", "googleSignOut", "context", "Landroid/content/Context;", "getDouYinAccessToken", "forceRequestServer", "triggerScene", "Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "Lcom/larus/account/base/api/IDouYinTokenUpdateCallback;", "getCacheDouYinAccessToken", "Lcom/larus/account/base/api/DouYinTokenResult;", "onNewAccountChange", "password", "captcha", "Lcom/larus/account/base/callback/FlowSaitamaLoginDelegateCallback;", "forceClearDouYinCacheToken", "getPhoneNumberByGoogle", "fragment", "Landroidx/fragment/app/Fragment;", "getPhoneNumberBySim", "Lcom/larus/account/base/api/IGooglePhoneNumber;", "getPhoneNumberByActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "looseCheckPhoneNumber", "phoneNumber", "strictCheckPhoneNumber", "autoGetSms", "Lcom/larus/account/base/api/IAutoSmsCode;", "endSmsListener", "ssoWithProfileKeyLogin", "getBindConflictUserInfo", "Lcom/larus/account/base/api/IBindConflictUserInfoCallback;", "solveConflictAndSwitchBind", "verifyTicket", "updateAuthorizeInfo", "addBindListener", "Lcom/larus/account/base/api/INewBindNotify;", "removeBindListener", "notifyNewBind", "loginStatusChangedToLogin", "setIsNewUser", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface ILoginService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016JX\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u001fH\u0016JB\u0010 \u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0016J:\u0010%\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\fH\u0016JN\u0010&\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\\\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016JL\u0010/\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016JL\u00102\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u00103\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u0002042\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016JF\u00105\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u0001072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016JN\u00108\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u0001072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010<\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010=\u001a\u00020>H\u0016J\u001f\u0010?\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010BJ\u0010\u0010C\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020@H\u0016J\u0010\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010E\u001a\u00020FH\u0016J0\u0010H\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020\u0005H\u0016J\b\u0010Q\u001a\u00020\fH\u0016JX\u0010R\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00052!\u0010T\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\u00100U2#\u0010Y\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010Z¢\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b([\u0012\u0004\u0012\u00020\u00100UH\u0016J\u0012\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010\r\u001a\u00020\u000eH\u0016J:\u0010^\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00052\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00052\b\u0010b\u001a\u0004\u0018\u00010\u00052\u0006\u0010c\u001a\u00020`2\u0006\u0010\u0011\u001a\u00020dH\u0016J(\u0010e\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010c\u001a\u00020`2\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0018\u0010f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J(\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0018\u0010g\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0010\u0010k\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0018\u0010l\u001a\u00020\u00102\u0006\u0010m\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0018\u0010n\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020oH\u0016J\u0010\u0010p\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020qH\u0016J(\u0010r\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J2\u0010s\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u00052\b\u0010b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J \u0010t\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00052\u0006\u0010_\u001a\u00020`2\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0018\u0010u\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020vH\u0016J\u0018\u0010w\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010x\u001a\u00020yH\u0016J(\u0010z\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010{\u001a\u00020\f2\u0006\u0010|\u001a\u00020}2\u0006\u0010\u0011\u001a\u00020~H\u0016J\u0010\u0010\u007f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0015\u0010\u0080\u0001\u001a\u00020\u00102\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0016J\u001e\u0010\u0083\u0001\u001a\u00020\u00102\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0007\u0010\u0011\u001a\u00030\u0084\u0001H\u0016J0\u0010\u0085\u0001\u001a\u00020\u00102\u0007\u0010\u0086\u0001\u001a\u00020`2\u0007\u0010\u0087\u0001\u001a\u00020`2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u0011\u001a\u00030\u0084\u0001H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020\f2\u0007\u0010\u008b\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010\u008c\u0001\u001a\u00020\f2\u0007\u0010\u008b\u0001\u001a\u00020\u0005H\u0016J\u001e\u0010\u008d\u0001\u001a\u00020\u00102\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0007\u0010\u0011\u001a\u00030\u008e\u0001H\u0016J\u0013\u0010\u008f\u0001\u001a\u00020\u00102\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J!\u0010\u0090\u0001\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0016J4\u0010\u0093\u0001\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\u00052\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0011\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J*\u0010\u0097\u0001\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0007\u0010\u0011\u001a\u00030\u0098\u0001H\u0016J*\u0010\u0099\u0001\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u00052\u0007\u0010\u009a\u0001\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020dH\u0016J\u0012\u0010\u009b\u0001\u001a\u00020\u00102\u0007\u0010E\u001a\u00030\u009c\u0001H\u0016J\u0012\u0010\u009d\u0001\u001a\u00020\u00102\u0007\u0010E\u001a\u00030\u009c\u0001H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0010H\u0016J)\u0010\u009f\u0001\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020~H\u0016J\u001b\u0010 \u0001\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0011\u0010¡\u0001\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006¢\u0001"}, d2 = {"Lcom/larus/account/base/api/ILoginService$Companion;", "Lcom/larus/account/base/api/ILoginService;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "impl", "getImpl", "()Lcom/larus/account/base/api/ILoginService;", "impl$delegate", "Lkotlin/Lazy;", "isSupportedPlatform", XmlPullParser.NO_NAMESPACE, "platform", "Lcom/larus/account/base/model/LoginPlatform;", "loginByOneTap", XmlPullParser.NO_NAMESPACE, "callback", "Lcom/larus/account/base/api/IAccountCallback;", "enableAgeGate", "businessScene", "activity", "Landroid/app/Activity;", "trackerJson", "Lorg/json/JSONObject;", "useGoogleOntap", "forceBindMobile", "triggerAppId", "loginByLark", "Landroidx/fragment/app/FragmentActivity;", "secUid", "Lcom/larus/account/base/api/ILarkLoginCallback;", "sendVerificationCode", "account", "Lcom/larus/account/base/api/IVerificationCodeCallback;", "enableAutoRead", "is6Digit", "sendVoiceVerificationCode", "loginByVerificationCode", "code", "loginByPhoneAccountDiscovery", "source", "Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;", "smsCodeKey", "mobile", "mobileTicket", "registerNewUser", "authBindLoginWithProfileKey", "platformId", "profileKey", "bindLogin", "getPhoneInfo", "Lcom/larus/account/base/api/IPhoneOneKeyCallback;", "phoneOneKeyLogin", "ageGateManager", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "phoneValidateOneKeyLogin", "secretMobile", "logout", "forceLogout", "onSaaSLogout", "info", "Lcom/larus/account/saas/model/AccountBaseInfo;", "registerAccountStatusChangeListener", "Lcom/larus/account/base/api/IAccountStatusListener;", "isSticky", "(Lcom/larus/account/base/api/IAccountStatusListener;Ljava/lang/Boolean;)V", "unregisterAccountStatusChangeListener", "registerAccountBindStatusListener", "listener", "Lcom/larus/account/base/api/IAccountBindStatusListener;", "unregisterAccountBindStatusListener", "updateAccountToken", "Lcom/larus/account/base/api/IAccountTokenUpdateCallback;", "token", "isFromDelete", "extraInfo", "Landroid/os/Bundle;", "getAccountInfo", "Lcom/larus/account/base/model/AccountInfo;", "getXTToken", "isNewUser", "uploadAvatar", "path", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "onFail", XmlPullParser.NO_NAMESPACE, "errorCode", "getPlatformUserInfo", "Lcom/larus/account/base/model/PlatformUserInfo;", "getBindingAccountInfo", "type", XmlPullParser.NO_NAMESPACE, "ticket", "unusableMobileTicket", "isBindExit", "Lcom/larus/account/base/api/IBindCallback;", "checkVerificationCode", "unbindPlatform", "bindPlatform", "platformAppId", "authCode", "loginPlatform", "checkSafeEnvBeforeInputOldMobile", "checkSafeEnvBeforeSendCodeToOldMobile", "oldMobile", "checkOldPhoneUnusable", "Lcom/larus/account/base/api/ICheckMobileUnusableCallback;", "getAvailableVerifyWays", "Lcom/larus/account/base/api/IGetOauthPlatformsCallback;", "doAuthVerify", "changeMobileBind", "checkOldVerificationCode", "googleRequestAuth", "Lcom/larus/account/base/api/IGoogleAuthCallback;", "googleSignOut", "context", "Landroid/content/Context;", "getDouYinAccessToken", "forceRequestServer", "triggerScene", "Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "Lcom/larus/account/base/api/IDouYinTokenUpdateCallback;", "forceClearDouYinCacheToken", "getPhoneNumberByGoogle", "fragment", "Landroidx/fragment/app/Fragment;", "getPhoneNumberBySim", "Lcom/larus/account/base/api/IGooglePhoneNumber;", "getPhoneNumberByActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "looseCheckPhoneNumber", "phoneNumber", "strictCheckPhoneNumber", "autoGetSms", "Lcom/larus/account/base/api/IAutoSmsCode;", "endSmsListener", "ssoWithProfileKeyLogin", "getCacheDouYinAccessToken", "Lcom/larus/account/base/api/DouYinTokenResult;", "onNewAccountChange", "password", "captcha", "Lcom/larus/account/base/callback/FlowSaitamaLoginDelegateCallback;", "getBindConflictUserInfo", "Lcom/larus/account/base/api/IBindConflictUserInfoCallback;", "solveConflictAndSwitchBind", "verifyTicket", "addBindListener", "Lcom/larus/account/base/api/INewBindNotify;", "removeBindListener", "notifyNewBind", "updateAuthorizeInfo", "loginStatusChangedToLogin", "setIsNewUser", "api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion implements ILoginService {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<ILoginService> c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(new v());
        }

        public static ILoginService Z() {
            return c.getValue();
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void N() {
            Intrinsics.checkNotNullParameter("oneLogin", "businessScene");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.N();
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final String K() {
            ILoginService r0 = Z();
            if (r0 == null) goto L5;
            String r1 = r0.K();
        L6:
            if (r1 != null) goto L9;
            return XmlPullParser.NO_NAMESPACE;
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.larus.account.base.api.ILoginService
        public final q38.a getAccountInfo() {
            ILoginService r0 = Z();
            if (r0 == null) goto L7;
            q38.a r1 = r0.getAccountInfo();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return new q38.a(false, XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, 0, XmlPullParser.NO_NAMESPACE, false);
        }

        @Override // com.larus.account.base.api.ILoginService
        public final boolean isNewUser() {
            ILoginService r0 = Z();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isNewUser() != true) goto L7;
            return true;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void z() {
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.z();
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final boolean C(LoginPlatform r2) {
            Intrinsics.checkNotNullParameter(r2, "platform");
            ILoginService r0 = Z();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.C(r2) != true) goto L7;
            return true;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void G(w r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.G(r2);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void H(x r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.H(r2);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void L(g r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.L(r2);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void Q(j r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.Q(r2);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void U(Fragment r2) {
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.U(r2);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void V(x r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.V(r2);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final e Y(LoginPlatform r2) {
            Intrinsics.checkNotNullParameter(r2, "platform");
            ILoginService r0 = Z();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.Y(r2);
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void a(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void k(LoginPlatform r2) {
            Intrinsics.checkNotNullParameter(r2, "platform");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.k(r2);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void m(boolean r2) {
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.m(r2);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final l p(LoginPlatform r2) {
            Intrinsics.checkNotNullParameter(r2, "platform");
            ILoginService r0 = Z();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.p(r2);
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void y(s3 r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.y(r2);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void B(String r2, y3 r3) {
            Intrinsics.checkNotNullParameter(r2, "mobile");
            Intrinsics.checkNotNullParameter(r3, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.B(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void E(LoginPlatform r2, Context r3) {
            Intrinsics.checkNotNullParameter(r2, "platform");
            Intrinsics.checkNotNullParameter(r3, "context");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.E(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void I(Fragment r2, VerificationCodeFragment.b r3) {
            Intrinsics.checkNotNullParameter(r3, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.I(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void M(String r2, b r3) {
            Intrinsics.checkNotNullParameter(r3, "info");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.M(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void T(LoginPlatform r2, f3 r3) {
            Intrinsics.checkNotNullParameter(r2, "platform");
            Intrinsics.checkNotNullParameter(r3, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.T(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void b(String r3, o0 r4) {
            Intrinsics.checkNotNullParameter("8943", "platformAppId");
            Intrinsics.checkNotNullParameter("aweme_v2", "platform");
            Intrinsics.checkNotNullParameter(r3, "authCode");
            Intrinsics.checkNotNullParameter(r4, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.b(r3, r4);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void e(String r2, m r3) {
            Intrinsics.checkNotNullParameter(r2, "platform");
            Intrinsics.checkNotNullParameter(r3, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.e(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void f(j r2, Boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.f(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void i(y r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.i(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void n(String r2, PhoneLoginFragment.b r3) {
            Intrinsics.checkNotNullParameter(r2, "oldMobile");
            Intrinsics.checkNotNullParameter(r3, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.n(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void o(String r2, t3 r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            Intrinsics.checkNotNullParameter(r3, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.o(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void v(LoginPlatform r2, m r3) {
            Intrinsics.checkNotNullParameter(r2, "loginPlatform");
            Intrinsics.checkNotNullParameter(r3, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.v(r2, r3);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void l(String r2, String r3, w3 r4) {
            Intrinsics.checkNotNullParameter(r2, "mobile");
            Intrinsics.checkNotNullParameter(r3, "code");
            Intrinsics.checkNotNullParameter(r4, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.l(r2, r3, r4);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void s(String r2, Function1<? super String, Unit> r3, Function1<? super Long, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "path");
            Intrinsics.checkNotNullParameter(r3, "onSuccess");
            Intrinsics.checkNotNullParameter(r4, "onFail");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.s(r2, r3, r4);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void t(LoginPlatform r3, h0.c r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "platform");
            Intrinsics.checkNotNullParameter("PhoneOneKeyLoginFragment", "account");
            Intrinsics.checkNotNullParameter(r4, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.t(r3, r4, r5);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void u(LoginPlatform r2, String r3, f2 r4) {
            Intrinsics.checkNotNullParameter(r2, "loginPlatform");
            Intrinsics.checkNotNullParameter(r3, "profileKey");
            Intrinsics.checkNotNullParameter(r4, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.u(r2, r3, r4);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void x(boolean r2, h r3, String r4) {
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.x(r2, r3, r4);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void A(String r2, String r3, String r4, SwitchBindViewModel.fetchAccountInfo.1.2 r5) {
            Intrinsics.checkNotNullParameter(r2, "profileKey");
            Intrinsics.checkNotNullParameter(r3, "platformAppId");
            Intrinsics.checkNotNullParameter(r4, "platform");
            Intrinsics.checkNotNullParameter(r5, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.A(r2, r3, r4, r5);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void O(FragmentActivity r2, String r3, String r4, t r5) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "businessScene");
            Intrinsics.checkNotNullParameter(r5, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.O(r2, r3, r4, r5);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void R(int r2, int r3, Intent r4, PhoneLoginActivity.a r5) {
            Intrinsics.checkNotNullParameter(r5, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.R(r2, r3, r4, r5);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void S(String r2, String r3, String r4, a0.a r5) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "platformAppId");
            Intrinsics.checkNotNullParameter(r4, "platform");
            Intrinsics.checkNotNullParameter(r5, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.S(r2, r3, r4, r5);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void c(String r2, String r3, String r4, SwitchBindViewModel.executeSwitch.1.a r5) {
            Intrinsics.checkNotNullParameter(r2, "profileKey");
            Intrinsics.checkNotNullParameter(r3, "platformAppId");
            Intrinsics.checkNotNullParameter(r4, "verifyTicket");
            Intrinsics.checkNotNullParameter(r5, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.c(r2, r3, r4, r5);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void q(String r2, String r3, String r4, m r5) {
            Intrinsics.checkNotNullParameter(r2, "platformAppId");
            Intrinsics.checkNotNullParameter(r3, "platform");
            Intrinsics.checkNotNullParameter(r4, "authCode");
            Intrinsics.checkNotNullParameter(r5, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.q(r2, r3, r4, r5);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void w(LoginPlatform r2, boolean r3, GetOauthTokenTriggerScene r4, p r5) {
            Intrinsics.checkNotNullParameter(r2, "platform");
            Intrinsics.checkNotNullParameter(r4, "triggerScene");
            Intrinsics.checkNotNullParameter(r5, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.w(r2, r3, r4, r5);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void D(LoginPlatform r8, String r9, b4 r10, boolean r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r8, "platform");
            Intrinsics.checkNotNullParameter(r9, "account");
            Intrinsics.checkNotNullParameter(r10, "callback");
            ILoginService r1 = Z();
            if (r1 == null) goto L6;
            r1.D(r8, r9, r10, r11, r12);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void F(LoginPlatform r8, n38.l r9, String r10, boolean r11, Bundle r12) {
            Intrinsics.checkNotNullParameter(r8, "platform");
            Intrinsics.checkNotNullParameter(r9, "callback");
            Intrinsics.checkNotNullParameter(r10, "token");
            Intrinsics.checkNotNullParameter(r12, "extraInfo");
            ILoginService r1 = Z();
            if (r1 == null) goto L6;
            r1.F(r8, r9, r10, r11, r12);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void W(String r8, int r9, String r10, String r11, m r12) {
            Intrinsics.checkNotNullParameter(r8, "mobile");
            Intrinsics.checkNotNullParameter(r10, "ticket");
            Intrinsics.checkNotNullParameter(r12, "callback");
            ILoginService r1 = Z();
            if (r1 == null) goto L6;
            r1.W(r8, r9, r10, r11, r12);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void h(LoginPlatform r8, String r9, String r10, h0.d r11, String r12) {
            Intrinsics.checkNotNullParameter(r8, "platform");
            Intrinsics.checkNotNullParameter(r9, "secretMobile");
            Intrinsics.checkNotNullParameter(r10, "account");
            Intrinsics.checkNotNullParameter(r11, "callback");
            ILoginService r1 = Z();
            if (r1 == null) goto L6;
            r1.h(r8, r9, r10, r11, r12);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void r(String r8, String r9, String r10, String r11, r3 r12) {
            Intrinsics.checkNotNullParameter(r8, "mobile");
            Intrinsics.checkNotNullParameter(r9, "code");
            Intrinsics.checkNotNullParameter(r10, "ticket");
            Intrinsics.checkNotNullParameter(r12, "callback");
            ILoginService r1 = Z();
            if (r1 == null) goto L6;
            r1.r(r8, r9, r10, r11, r12);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void d(LoginPlatform r9, String r10, String r11, String r12, v3 r13, JSONObject r14) {
            Intrinsics.checkNotNullParameter(r9, "platform");
            Intrinsics.checkNotNullParameter("15210", "platformId");
            Intrinsics.checkNotNullParameter(r10, "account");
            Intrinsics.checkNotNullParameter(r11, "code");
            Intrinsics.checkNotNullParameter(r12, "profileKey");
            Intrinsics.checkNotNullParameter(r13, "callback");
            ILoginService r1 = Z();
            if (r1 == null) goto L6;
            r1.d(r9, r10, r11, r12, r13, r14);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void g(LoginPlatform r9, String r10, String r11, String r12, u3 r13, JSONObject r14) {
            Intrinsics.checkNotNullParameter(r9, "platform");
            Intrinsics.checkNotNullParameter("15210", "platformId");
            Intrinsics.checkNotNullParameter(r10, "account");
            Intrinsics.checkNotNullParameter(r11, "code");
            Intrinsics.checkNotNullParameter(r12, "profileKey");
            Intrinsics.checkNotNullParameter(r13, "callback");
            ILoginService r1 = Z();
            if (r1 == null) goto L6;
            r1.g(r9, r10, r11, r12, r13, r14);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void j(LoginPlatform r9, String r10, z r11, boolean r12, String r13, boolean r14, boolean r15) {
            Intrinsics.checkNotNullParameter(r9, "platform");
            Intrinsics.checkNotNullParameter(r10, "account");
            Intrinsics.checkNotNullParameter(r11, "callback");
            ILoginService r0 = Z();
            if (r0 == null) goto L6;
            r0.j(r9, r10, r11, r12, r13, r15, true);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void J(LoginPlatform r10, String r11, String r12, h r13, boolean r14, String r15, JSONObject r16, String r17) {
            Intrinsics.checkNotNullParameter(r10, "platform");
            Intrinsics.checkNotNullParameter(r11, "account");
            Intrinsics.checkNotNullParameter(r12, "code");
            Intrinsics.checkNotNullParameter(r13, "callback");
            ILoginService r1 = Z();
            if (r1 == null) goto L6;
            a.b(r1, r10, r11, r12, r13, r14, r15, r16);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void X(PhoneLoginAccountDiscoverySource r11, String r12, String r13, String r14, String r15, boolean r16, PhoneLoginAccountDiscoveryFragment.b r17, String r18) {
            Intrinsics.checkNotNullParameter(r11, "source");
            Intrinsics.checkNotNullParameter(r17, "callback");
            ILoginService r1 = Z();
            if (r1 == null) goto L6;
            r1.X(r11, r12, r13, r14, r15, r16, r17, r18);
            return;
        }

        @Override // com.larus.account.base.api.ILoginService
        public final void P(LoginPlatform r13, h r14, boolean r15, String r16, FragmentActivity r17, JSONObject r18, boolean r19, boolean r20, String r21) {
            Intrinsics.checkNotNullParameter(r13, "platform");
            Intrinsics.checkNotNullParameter(r14, "callback");
            ILoginService r1 = Z();
            if (r1 == null) goto L6;
            a.a(r1, r13, r14, r15, r16, r17, r18, r19, r20, null, 256);
            return;
        }
    }

    public static final class a {
        public static /* synthetic */ void c(ILoginService r1, j r2) {
            r1.f(r2, Boolean.FALSE);
        }

        public static /* synthetic */ void d(ILoginService r6, LoginPlatform r7, n38.l r8, String r9, boolean r10, Bundle r11, int r12) {
            if ((r12 & 4) == 0) goto L5;
            r9 = XmlPullParser.NO_NAMESPACE;
        L5:
            String r3 = r9;
            if ((r12 & 8) == 0) goto L8;
            boolean r4 = false;
        L10:
            if ((r12 & 16) == 0) goto L12;
            r11 = new Bundle();
        L12:
            r6.F(r7, r8, r3, r4, r11);
            return;
        L8:
            r4 = r10;
            goto L10
        }

        public static /* synthetic */ void b(ILoginService r9, LoginPlatform r10, String r11, String r12, h r13, boolean r14, String r15, JSONObject r16) {
            r9.J(r10, r11, r12, r13, r14, r15, r16, null);
        }

        public static /* synthetic */ void a(ILoginService r13, LoginPlatform r14, h r15, boolean r16, String r17, FragmentActivity r18, JSONObject r19, boolean r20, boolean r21, String r22, int r23) {
            if ((r23 & 32) == 0) goto L5;
            JSONObject r9 = null;
        L7:
            if ((r23 & 64) == 0) goto L9;
            boolean r10 = false;
        L11:
            if ((r23 & 128) == 0) goto L13;
            boolean r11 = false;
        L15:
            if ((r23 & 256) == 0) goto L17;
            String r12 = null;
        L18:
            r13.P(r14, r15, r16, r17, r18, r9, r10, r11, r12);
            return;
        L17:
            r12 = r22;
            goto L18
        L13:
            r11 = r21;
            goto L15
        L9:
            r10 = r20;
            goto L11
        L5:
            r9 = r19;
            goto L7
        }
    }

    static {
        a = Companion.b;
    }

    void A(String r1, String r2, String r3, SwitchBindViewModel.fetchAccountInfo.1.2 r4);

    void B(String r1, y3 r2);

    boolean C(LoginPlatform r1);

    void D(LoginPlatform r1, String r2, b4 r3, boolean r4, boolean r5);

    void E(LoginPlatform r1, Context r2);

    void F(LoginPlatform r1, n38.l r2, String r3, boolean r4, Bundle r5);

    void G(w r1);

    void H(x r1);

    void I(Fragment r1, VerificationCodeFragment.b r2);

    void J(LoginPlatform r1, String r2, String r3, h r4, boolean r5, String r6, JSONObject r7, String r8);

    String K();

    void L(g r1);

    void M(String r1, b r2);

    void N();

    void O(FragmentActivity r1, String r2, String r3, t r4);

    void P(LoginPlatform r1, h r2, boolean r3, String r4, FragmentActivity r5, JSONObject r6, boolean r7, boolean r8, String r9);

    void Q(j r1);

    void R(int r1, int r2, Intent r3, PhoneLoginActivity.a r4);

    void S(String r1, String r2, String r3, a0.a r4);

    void T(LoginPlatform r1, f3 r2);

    void U(Fragment r1);

    void V(x r1);

    void W(String r1, int r2, String r3, String r4, m r5);

    void X(PhoneLoginAccountDiscoverySource r1, String r2, String r3, String r4, String r5, boolean r6, PhoneLoginAccountDiscoveryFragment.b r7, String r8);

    e Y(LoginPlatform r1);

    void a(Fragment r1);

    void b(String r1, o0 r2);

    void c(String r1, String r2, String r3, SwitchBindViewModel.executeSwitch.1.a r4);

    void d(LoginPlatform r1, String r2, String r3, String r4, v3 r5, JSONObject r6);

    void e(String r1, m r2);

    void f(j r1, Boolean r2);

    void g(LoginPlatform r1, String r2, String r3, String r4, u3 r5, JSONObject r6);

    q38.a getAccountInfo();

    void h(LoginPlatform r1, String r2, String r3, h0.d r4, String r5);

    void i(y r1, String r2);

    boolean isNewUser();

    void j(LoginPlatform r1, String r2, z r3, boolean r4, String r5, boolean r6, boolean r7);

    void k(LoginPlatform r1);

    void l(String r1, String r2, w3 r3);

    void m(boolean r1);

    void n(String r1, PhoneLoginFragment.b r2);

    void o(String r1, t3 r2);

    l p(LoginPlatform r1);

    void q(String r1, String r2, String r3, m r4);

    void r(String r1, String r2, String r3, String r4, r3 r5);

    void s(String r1, Function1<? super String, Unit> r2, Function1<? super Long, Unit> r3);

    void t(LoginPlatform r1, h0.c r2, String r3);

    void u(LoginPlatform r1, String r2, f2 r3);

    void v(LoginPlatform r1, m r2);

    void w(LoginPlatform r1, boolean r2, GetOauthTokenTriggerScene r3, p r4);

    void x(boolean r1, h r2, String r3);

    void y(s3 r1);

    void z();
}
