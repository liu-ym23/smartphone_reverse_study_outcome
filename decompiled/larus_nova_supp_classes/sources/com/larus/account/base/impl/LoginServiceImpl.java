package com.larus.account.base.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.EventsUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.sdk.account.impl.d0;
import com.bytedance.sdk.account.impl.h;
import com.bytedance.sdk.account.impl.j;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.UserAction;
import com.larus.account.base.model.AccountStatus;
import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.model.PhoneLoginAccountDiscoverySource;
import com.larus.account.base.provider.IGooglePhoneLoginProvider;
import com.larus.account.base.provider.ILarkLoginProvider;
import com.larus.account.base.provider.IThirdPartyPlatformLoginProvider;
import com.larus.account.base.provider.IVerificationCodeLoginProvider;
import com.larus.account.base.provider.agegate.AgeGateManagerService;
import com.larus.common.apphost.AppHost;
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
import com.larus.platform.service.o;
import com.larus.setting.impl.f3;
import com.larus.settings.value.e10;
import com.larus.settings.value.fr;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.token.p;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m38.a;
import m38.c;
import n38.g;
import n38.m;
import n38.t;
import n38.x;
import n38.y;
import n38.z;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import p38.b;
import p38.f;
import q38.l;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016JX\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u001dH\u0016J*\u0010%\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0019\u001a\u00020(H\u0016JB\u0010)\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0016J:\u0010.\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010-\u001a\u00020\nH\u0016JN\u0010/\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010\u001dH\u0016J\\\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u001d2\b\u00105\u001a\u0004\u0018\u00010\u001d2\b\u00106\u001a\u0004\u0018\u00010\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u001d2\u0006\u00107\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u001dH\u0016JL\u00108\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016JL\u0010;\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\"\u0010<\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016JF\u0010>\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010$\u001a\u0004\u0018\u00010\u001dH\u0016JN\u0010A\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010$\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010C\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010D\u001a\u00020EH\u0016J$\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001f\u0010H\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020IH\u0016J\u0010\u0010M\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\bH\u0016J\u0010\u0010O\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\bH\u0016J0\u0010P\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020WH\u0016J0\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u001dH\u0002J\b\u0010_\u001a\u00020\u001dH\u0016J\b\u0010`\u001a\u00020\nH\u0016JX\u0010a\u001a\u00020\u00182\u0006\u0010b\u001a\u00020\u001d2!\u0010c\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u00180d2#\u0010h\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010i¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020\u00180dH\u0016J\u0012\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J:\u0010m\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u001d2\u0006\u0010n\u001a\u00020]2\u0006\u0010o\u001a\u00020\u001d2\b\u0010p\u001a\u0004\u0018\u00010\u001d2\u0006\u0010q\u001a\u00020]2\u0006\u0010\u0019\u001a\u00020rH\u0016J(\u0010s\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001d2\u0006\u0010q\u001a\u00020]2\u0006\u0010\u0019\u001a\u00020rH\u0016J2\u0010t\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001d2\u0006\u0010o\u001a\u00020\u001d2\b\u0010p\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0019\u001a\u00020rH\u0016J\u0018\u0010u\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020rH\u0016J \u0010v\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u001d2\u0006\u0010n\u001a\u00020]2\u0006\u0010\u0019\u001a\u00020rH\u0016J(\u0010w\u001a\u00020\u00182\u0006\u0010x\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u001d2\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020rH\u0016J\u0018\u0010w\u001a\u00020\u00182\u0006\u0010z\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020rH\u0016J\u0010\u0010{\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020rH\u0016J\u0018\u0010|\u001a\u00020\u00182\u0006\u0010}\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020rH\u0016J\u0018\u0010~\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u007fH\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\u00182\u0007\u0010\u0019\u001a\u00030\u0081\u0001H\u0016J)\u0010\u0082\u0001\u001a\u00020\u00182\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020rH\u0016J\u001a\u0010\u0083\u0001\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0007\u0010\u0019\u001a\u00030\u0084\u0001H\u0016J\u001b\u0010\u0085\u0001\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0016J-\u0010\u0088\u0001\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0007\u0010\u0089\u0001\u001a\u00020\n2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0019\u001a\u00030\u008c\u0001H\u0016J\u0014\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00012\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J4\u0010\u008f\u0001\u001a\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010\u001d2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001d2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001d2\t\u0010\u0019\u001a\u0005\u0018\u00010\u0092\u0001H\u0016J\u0011\u0010\u0093\u0001\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0015\u0010\u0094\u0001\u001a\u00020\u00182\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J\u001e\u0010\u0097\u0001\u001a\u00020\u00182\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0007\u0010\u0019\u001a\u00030\u0098\u0001H\u0016J0\u0010\u0099\u0001\u001a\u00020\u00182\u0007\u0010\u009a\u0001\u001a\u00020]2\u0007\u0010\u009b\u0001\u001a\u00020]2\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00012\u0007\u0010\u0019\u001a\u00030\u0098\u0001H\u0016J\u0012\u0010\u009e\u0001\u001a\u00020\n2\u0007\u0010\u009f\u0001\u001a\u00020\u001dH\u0016J\u0012\u0010 \u0001\u001a\u00020\n2\u0007\u0010\u009f\u0001\u001a\u00020\u001dH\u0016J\u001e\u0010¡\u0001\u001a\u00020\u00182\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0007\u0010\u0019\u001a\u00030¢\u0001H\u0016J\u0013\u0010£\u0001\u001a\u00020\u00182\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J!\u0010¤\u0001\u001a\u00020\u00182\u0006\u0010z\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J*\u0010¥\u0001\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u001d2\u0007\u0010\u0019\u001a\u00030¦\u0001H\u0016J\u0011\u0010§\u0001\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\u0006H\u0016J\u0011\u0010¨\u0001\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\u0006H\u0016J\t\u0010©\u0001\u001a\u00020\u0018H\u0016J*\u0010ª\u0001\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020\u001d2\u0007\u0010«\u0001\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020rH\u0016J*\u0010¬\u0001\u001a\u00020\u00182\u0006\u0010x\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u001d2\u0006\u0010y\u001a\u00020\u001d2\u0007\u0010\u0019\u001a\u00030\u008c\u0001H\u0016J\u001b\u0010\u00ad\u0001\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0011\u0010®\u0001\u001a\u00020\u00182\u0006\u0010`\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006¯\u0001"}, d2 = {"Lcom/larus/account/base/impl/LoginServiceImpl;", "Lcom/larus/account/base/api/ILoginService;", "<init>", "()V", "newBindListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/account/base/api/INewBindNotify;", "accountBindStatusListeners", "Lcom/larus/account/base/api/IAccountBindStatusListener;", "enableAccountFrequentCallOpt", XmlPullParser.NO_NAMESPACE, "getEnableAccountFrequentCallOpt", "()Z", "enableAccountFrequentCallOpt$delegate", "Lkotlin/Lazy;", "larkLoginProvider", "Lcom/larus/account/base/provider/ILarkLoginProvider;", "getLarkLoginProvider", "()Lcom/larus/account/base/provider/ILarkLoginProvider;", "larkLoginProvider$delegate", "isSupportedPlatform", "platform", "Lcom/larus/account/base/model/LoginPlatform;", "loginByOneTap", XmlPullParser.NO_NAMESPACE, "callback", "Lcom/larus/account/base/api/IAccountCallback;", "enableAgeGate", "businessScene", XmlPullParser.NO_NAMESPACE, "activity", "Landroid/app/Activity;", "trackerJson", "Lorg/json/JSONObject;", "useGoogleOntap", "forceBindMobile", "triggerAppId", "loginByLark", "Landroidx/fragment/app/FragmentActivity;", "secUid", "Lcom/larus/account/base/api/ILarkLoginCallback;", "sendVerificationCode", "account", "Lcom/larus/account/base/api/IVerificationCodeCallback;", "enableAutoRead", "is6Digit", "sendVoiceVerificationCode", "loginByVerificationCode", "code", "loginByPhoneAccountDiscovery", "source", "Lcom/larus/account/base/model/PhoneLoginAccountDiscoverySource;", "smsCodeKey", "mobile", "mobileTicket", "registerNewUser", "authBindLoginWithProfileKey", "platformId", "profileKey", "bindLogin", "getPhoneInfo", "Lcom/larus/account/base/api/IPhoneOneKeyCallback;", "phoneOneKeyLogin", "ageGateManager", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "phoneValidateOneKeyLogin", "secretMobile", "onSaaSLogout", "info", "Lcom/larus/account/saas/model/AccountBaseInfo;", "logout", "forceLogout", "registerAccountStatusChangeListener", "Lcom/larus/account/base/api/IAccountStatusListener;", "isSticky", "(Lcom/larus/account/base/api/IAccountStatusListener;Ljava/lang/Boolean;)V", "unregisterAccountStatusChangeListener", "registerAccountBindStatusListener", "listener", "unregisterAccountBindStatusListener", "updateAccountToken", "Lcom/larus/account/base/api/IAccountTokenUpdateCallback;", "token", "isFromDelete", "extraInfo", "Landroid/os/Bundle;", "getAccountInfo", "Lcom/larus/account/base/model/AccountInfo;", "getAccountInfoWithFrequentMethodCallOpt", "isLogin", "userId", "secUserId", "odinUserType", XmlPullParser.NO_NAMESPACE, "userMobile", "getXTToken", "isNewUser", "uploadAvatar", "path", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "onFail", XmlPullParser.NO_NAMESPACE, "errorCode", "getPlatformUserInfo", "Lcom/larus/account/base/model/PlatformUserInfo;", "getBindingAccountInfo", "type", "ticket", "unusableMobileTicket", "isBindExit", "Lcom/larus/account/base/api/IBindCallback;", "checkVerificationCode", "changeMobileBind", "unbindPlatform", "checkOldVerificationCode", "bindPlatform", "platformAppId", "authCode", "loginPlatform", "checkSafeEnvBeforeInputOldMobile", "checkSafeEnvBeforeSendCodeToOldMobile", "oldMobile", "checkOldPhoneUnusable", "Lcom/larus/account/base/api/ICheckMobileUnusableCallback;", "getAvailableVerifyWays", "Lcom/larus/account/base/api/IGetOauthPlatformsCallback;", "doAuthVerify", "googleRequestAuth", "Lcom/larus/account/base/api/IGoogleAuthCallback;", "googleSignOut", "context", "Landroid/content/Context;", "getDouYinAccessToken", "forceRequestServer", "triggerScene", "Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "Lcom/larus/account/base/api/IDouYinTokenUpdateCallback;", "getCacheDouYinAccessToken", "Lcom/larus/account/base/api/DouYinTokenResult;", "onNewAccountChange", "password", "captcha", "Lcom/larus/account/base/callback/FlowSaitamaLoginDelegateCallback;", "forceClearDouYinCacheToken", "getPhoneNumberByGoogle", "fragment", "Landroidx/fragment/app/Fragment;", "getPhoneNumberBySim", "Lcom/larus/account/base/api/IGooglePhoneNumber;", "getPhoneNumberByActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "looseCheckPhoneNumber", "phoneNumber", "strictCheckPhoneNumber", "autoGetSms", "Lcom/larus/account/base/api/IAutoSmsCode;", "endSmsListener", "ssoWithProfileKeyLogin", "getBindConflictUserInfo", "Lcom/larus/account/base/api/IBindConflictUserInfoCallback;", "addBindListener", "removeBindListener", "notifyNewBind", "solveConflictAndSwitchBind", "verifyTicket", "updateAuthorizeInfo", "loginStatusChangedToLogin", "setIsNewUser", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class LoginServiceImpl implements ILoginService {
    public final CopyOnWriteArrayList<x> b;
    public final CopyOnWriteArrayList<g> c;
    public final Lazy d;
    public final Lazy e;

    @Override // com.larus.account.base.api.ILoginService
    public final void N() {
        Intrinsics.checkNotNullParameter("oneLogin", "businessScene");
        a.c(a.a, "oneLogin", null);
    }

    @Override // com.larus.account.base.api.ILoginService
    public final q38.a getAccountInfo() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L29
        j r1 = j.m(AppHost.a.getApplication());     // Catch: Throwable -> L29
        String r4 = null;
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L16;
        boolean r6 = r1.isLogin();     // Catch: Throwable -> L29
        String r8 = String.valueOf(r1.getUserId());     // Catch: Throwable -> L29
        String r9 = r1.getSecUserId();     // Catch: Throwable -> L29
        int r10 = r1.i();     // Catch: Throwable -> L29
        String r11 = r1.q.a();     // Catch: Throwable -> L29
        a.a.getClass();     // Catch: Throwable -> L29
        LoginPlatform r2 = a.a(r8);     // Catch: Throwable -> L29
        if (r2 == null) goto L8;
        r4 = r2.name();     // Catch: Throwable -> L29
    L8:
        if (r4 != null) goto L10;
        String r7 = XmlPullParser.NO_NAMESPACE;
    L11:
        ILarkLoginProvider r3 = (ILarkLoginProvider) this.e.getValue();     // Catch: Throwable -> L29
        if (r3 == null) goto L14;
        boolean r12 = r3.a(r9);     // Catch: Throwable -> L29
    L36:
        return new q38.a(r6, r7, r8, r9, r10, r11, r12);
    L14:
        r12 = false;
        goto L36
    L10:
        r7 = r4;
        goto L11
    L16:
        a r5 = a.a;     // Catch: Throwable -> L29
        String r13 = String.valueOf(r1.getUserId());     // Catch: Throwable -> L29
        r5.getClass();     // Catch: Throwable -> L29
        LoginPlatform r14 = a.a(r13);     // Catch: Throwable -> L29
        if (r14 == null) goto L19;
        r4 = r14.name();     // Catch: Throwable -> L29
    L19:
        if (r4 != null) goto L21;
        String r15 = XmlPullParser.NO_NAMESPACE;
    L22:
        ILarkLoginProvider r16 = (ILarkLoginProvider) ServiceManager.get().getService(ILarkLoginProvider.class);     // Catch: Throwable -> L29
        if (r16 == null) goto L25;
        boolean r17 = r16.a(r1.getSecUserId());     // Catch: Throwable -> L29
    L28:
        return new q38.a(r1.isLogin(), r15, String.valueOf(r1.getUserId()), r1.getSecUserId(), r1.i(), r1.q.a(), r17);
    L25:
        r17 = false;
        goto L28
    L21:
        r15 = r4;
    L29:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Throwable r19 = Result.m52exceptionOrNullimpl(Result.m49constructorimpl(ResultKt.createFailure(th)));
        if (r19 == null) goto L34;
        FLogger.a.e("LoginServiceImpl", "error:" + r19.getMessage());
    L34:
        return new q38.a(false, XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, 0, XmlPullParser.NO_NAMESPACE, false);
    }

    @Override // com.larus.account.base.api.ILoginService
    public final boolean isNewUser() {
        a.a.getClass();
        return a.c;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void z() {
        CopyOnWriteArrayList<x> r0 = this.b;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((x) r1.next()).DQ();
        goto L6
    L10:
        return;
    }

    public LoginServiceImpl() {
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = LazyKt.lazy(new d());
        this.e = LazyKt.lazy(new e());
    }

    @Override // com.larus.account.base.api.ILoginService
    public final String K() {
        return p.d();
    }

    @Override // com.larus.account.base.api.ILoginService
    public final boolean C(LoginPlatform r4) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((IThirdPartyPlatformLoginProvider) r0.next()).c() != r4) goto L4;
        return true;
    L8:
        Iterator r1 = ServiceManager.get().getServices(IVerificationCodeLoginProvider.class).iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        if (((IVerificationCodeLoginProvider) r1.next()).c() != r4) goto L10;
        return true;
    L14:
        return false;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void G(w r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        int r1 = f.a;
        Intrinsics.checkNotNullParameter(r4, "callback");
        b r0 = new b(r4);
        com.bytedance.sdk.account.impl.d.l().r("change_mobile_without_old_mobile", "change_mobile_without_old_mobile", null, r0);
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void H(x r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.b.contains(r2) == false) goto L6;
        this.b.remove(r2);
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void L(g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.addIfAbsent(r2);
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void Q(n38.j r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        List<n38.j> r1 = c.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        List<n38.j> r0 = c.a;
        if (r0 == null) goto L6;
        ((CopyOnWriteArrayList) r0).remove(r3);
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void U(Fragment r2) {
        Iterator r3 = ServiceManager.get().getServices(IGooglePhoneLoginProvider.class).iterator();
        if (r3.hasNext() == false) goto L6;
        ((IGooglePhoneLoginProvider) r3.next()).q();
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void V(x r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.b.contains(r2) == false) goto L5;
        return;
    L5:
        this.b.add(r2);
    }

    @Override // com.larus.account.base.api.ILoginService
    public final n38.e Y(LoginPlatform r4) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        IThirdPartyPlatformLoginProvider r1 = (IThirdPartyPlatformLoginProvider) r0.next();
        if (r1.c() != r4) goto L4;
        return r1.h();
    L9:
        return null;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void a(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Iterator r0 = ServiceManager.get().getServices(IGooglePhoneLoginProvider.class).iterator();
        if (r0.hasNext() == false) goto L6;
        ((IGooglePhoneLoginProvider) r0.next()).a(r3);
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void k(LoginPlatform r4) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        IThirdPartyPlatformLoginProvider r1 = (IThirdPartyPlatformLoginProvider) r0.next();
        if (r1.c() != r4) goto L4;
        r1.v();
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void m(boolean r2) {
        a.a.getClass();
        a.c = r2;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final l p(LoginPlatform r4) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        IThirdPartyPlatformLoginProvider r1 = (IThirdPartyPlatformLoginProvider) r0.next();
        if (r1.c() != r4) goto L4;
        return r1.x();
    L9:
        return null;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void y(s3 r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        int r1 = f.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        p38.e r0 = new p38.e(r3);
        com.bytedance.sdk.account.impl.d.l().k(r0);
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void B(String r4, y3 r5) {
        Intrinsics.checkNotNullParameter(r4, "mobile");
        Intrinsics.checkNotNullParameter(r5, "callback");
        int r2 = f.a;
        Intrinsics.checkNotNullParameter(r4, "mobile");
        Intrinsics.checkNotNullParameter(r5, "callback");
        p38.a r0 = new p38.a(r5);
        com.bytedance.sdk.account.impl.d.l().j(r4, r0);
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void E(LoginPlatform r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        Intrinsics.checkNotNullParameter(r5, "context");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IThirdPartyPlatformLoginProvider r1 = (IThirdPartyPlatformLoginProvider) r0.next();
        if (r4 != LoginPlatform.GOOGLE) goto L4;
        r1.p(r5);
        goto L4
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void I(Fragment r2, VerificationCodeFragment.b r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Iterator r4 = ServiceManager.get().getServices(IGooglePhoneLoginProvider.class).iterator();
        if (r4.hasNext() == false) goto L6;
        ((IGooglePhoneLoginProvider) r4.next()).w(r3);
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void M(String r6, b48.b r7) {
        Intrinsics.checkNotNullParameter(r7, "info");
        a r0 = a.a;
        String r1 = r7.b;
        r0.getClass();
        LoginPlatform r2 = a.a(r1);
        xg9.b.a().storeString("phone_number", "-1");
        Iterator r3 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        IThirdPartyPlatformLoginProvider r4 = (IThirdPartyPlatformLoginProvider) r3.next();
        if (r4.c() != r2) goto L4;
        r4.o(null, r6);
        goto L4
    L8:
        Iterator r5 = ServiceManager.get().getServices(IVerificationCodeLoginProvider.class).iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        IVerificationCodeLoginProvider r8 = (IVerificationCodeLoginProvider) r5.next();
        if (r8.c() != r2) goto L10;
        r8.o(null, r6);
        goto L10
    L14:
        a r9 = a.a;
        if (r6 != null) goto L17;
        r6 = XmlPullParser.NO_NAMESPACE;
    L17:
        UserAction r10 = UserAction.USER_LOGOUT;
        n38.c r11 = new n38.c(r7.b, r7.c);
        r9.getClass();
        a.d(r6, r10, r11);
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void T(LoginPlatform r4, f3 r5) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IThirdPartyPlatformLoginProvider r1 = (IThirdPartyPlatformLoginProvider) r0.next();
        if (r4 != LoginPlatform.GOOGLE) goto L4;
        r1.j(r5);
        goto L4
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void b(String r5, o0 r6) {
        Intrinsics.checkNotNullParameter("8943", "platformAppId");
        Intrinsics.checkNotNullParameter("aweme_v2", "platform");
        Intrinsics.checkNotNullParameter(r5, "authCode");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        IThirdPartyPlatformLoginProvider r1 = (IThirdPartyPlatformLoginProvider) r0.next();
        if (r1.c() != LoginPlatform.DOUYIN) goto L4;
        r1.b(r5, r6);
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void e(String r3, m r4) {
        Intrinsics.checkNotNullParameter(r3, "platform");
        Intrinsics.checkNotNullParameter(r4, "callback");
        com.bytedance.sdk.account.impl.p r0 = com.bytedance.sdk.account.impl.p.t();
        com.bytedance.sdk.account.impl.p r1 = r0;
        r1.w(r3, new f(r3, this, r4));
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void f(n38.j r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "callback");
        List<n38.j> r1 = c.a;
        boolean r9 = Intrinsics.areEqual(r8, Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r7, "callback");
        List<n38.j> r0 = c.a;
        if (r0 == null) goto L5;
        ((CopyOnWriteArrayList) r0).add(r7);
    L5:
        if (r9 == false) goto L36;
        n38.a r10 = c.b;
        AccountStatus r2 = null;
        if (r10 == null) goto L34;
    L21:
        if (r10 == null) goto L23;
        r2 = r10.a;
    L23:
        if (r2 != null) goto L25;
        int r3 = -1;
    L27:
        if (r3 != 1) goto L29;
        r7.b(r10);
        return;
    L29:
        if (r3 != 2) goto L38;
        r7.a(r10);
        return;
    L38:
        return;
    L25:
        r3 = c.a.a[r2.ordinal()];
        goto L27
    L34:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L15
        q38.a r12 = ILoginService.a.getAccountInfo();     // Catch: Throwable -> L15
        if (h.a().isLogin() == false) goto L12;
        n38.a r4 = new n38.a(AccountStatus.LOGGED_IN, new n38.c(r12.c, r12.d), UserAction.USER_LOGIN, "get_account_status_siticky");     // Catch: Throwable -> L15
    L13:
        Object r13 = Result.m49constructorimpl(r4);     // Catch: Throwable -> L15
    L18:
        if (Result.m55isFailureimpl(r13) == false) goto L20;
        r13 = null;
    L20:
        r10 = (n38.a) r13;
        goto L21
    L12:
        r4 = new n38.a(AccountStatus.LOGGED_OUT, new n38.c(r12.c, r12.d), UserAction.USER_LOGOUT, "get_account_status_siticky");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r13 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void i(y r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        o.a.reportEvent("get_carrier", new JSONObject());
        long r0 = System.currentTimeMillis();
        Iterator r8 = ServiceManager.get().getServices(IVerificationCodeLoginProvider.class).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ((IVerificationCodeLoginProvider) r8.next()).e(LoginPlatform.PHONE, new m(r6, r0));
        goto L4
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void n(String r4, PhoneLoginFragment.b r5) {
        Intrinsics.checkNotNullParameter(r4, "oldMobile");
        Intrinsics.checkNotNullParameter(r5, "callback");
        int r2 = f.a;
        Intrinsics.checkNotNullParameter(r4, "oldMobile");
        Intrinsics.checkNotNullParameter(r5, "callback");
        p38.c r0 = new p38.c(r5);
        com.bytedance.sdk.account.impl.d.l().r("change_mobile", "change_mobile", r4, r0);
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void o(String r3, t3 r4) {
        Intrinsics.checkNotNullParameter(r3, "code");
        Intrinsics.checkNotNullParameter(r4, "callback");
        com.bytedance.sdk.account.impl.d r0 = com.bytedance.sdk.account.impl.d.l();
        com.bytedance.sdk.account.impl.d r1 = r0;
        r1.p(r3, new i(r4));
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void v(LoginPlatform r4, m r5) {
        Intrinsics.checkNotNullParameter(r4, "loginPlatform");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        IThirdPartyPlatformLoginProvider r1 = (IThirdPartyPlatformLoginProvider) r0.next();
        if (r1.c() != r4) goto L4;
        r1.t(r5);
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void l(String r3, String r4, w3 r5) {
        Intrinsics.checkNotNullParameter(r3, "mobile");
        Intrinsics.checkNotNullParameter(r4, "code");
        Intrinsics.checkNotNullParameter(r5, "callback");
        com.bytedance.sdk.account.impl.d r0 = com.bytedance.sdk.account.impl.d.l();
        com.bytedance.sdk.account.impl.d r1 = r0;
        r1.h(r3, r4, new j(r5));
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void s(String r12, Function1<? super String, Unit> r13, Function1<? super Long, Unit> r14) {
        Intrinsics.checkNotNullParameter(r12, "path");
        Intrinsics.checkNotNullParameter(r13, "onSuccess");
        Intrinsics.checkNotNullParameter(r14, "onFail");
        AppHost.a.getApplication();
        if (mb7.a.b == null) goto L5;
    L14:
        mb7.a r0 = mb7.a.b;
        g r1 = new g(r13, r14);
        Context r15 = r0.a;
        int r16 = pb7.b.l;
        String r3 = ta7.d.a("/user/update/upload_avatar/");
        if (r12 == null) goto L17;
        String r8 = r12;
        String r7 = "avatar";
    L18:
        String r17 = "post_file";
        if (TextUtils.isEmpty("post_file") == false) goto L21;
        r17 = "get";
    L21:
        new pb7.b(r15, new lb7.a(r3, r17, null, null, r7, r8, false, 0), r1).m();
        return;
    L17:
        r7 = null;
        r8 = null;
        goto L18
    L5:
        monitor-enter(mb7.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mb7.a.b != null) goto L9;
        mb7.a.b = new mb7.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(mb7.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void t(LoginPlatform r4, h0.c r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        Intrinsics.checkNotNullParameter("PhoneOneKeyLoginFragment", "account");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Iterator r0 = ServiceManager.get().getServices(IVerificationCodeLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IVerificationCodeLoginProvider r1 = (IVerificationCodeLoginProvider) r0.next();
        if (r1.c() != r4) goto L4;
        r1.g(r4, new p(r6, r5));
        goto L4
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void u(LoginPlatform r4, String r5, f2 r6) {
        Intrinsics.checkNotNullParameter(r4, "loginPlatform");
        Intrinsics.checkNotNullParameter(r5, "profileKey");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        IThirdPartyPlatformLoginProvider r1 = (IThirdPartyPlatformLoginProvider) r0.next();
        if (r1.c() != r4) goto L4;
        r1.B(r5, new s(r6));
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void x(boolean r8, n38.h r9, String r10) {
        q38.a r5 = getAccountInfo();
        a r0 = a.a;
        String r1 = r5.c;
        r0.getClass();
        LoginPlatform r3 = a.a(r1);
        e r2 = new e(r3, r8, r9);
        Intrinsics.checkNotNullParameter(r5, "accountInfo");
        com.bytedance.sdk.account.impl.g.a().d(new m38.b(r8, r2, r3, r10, r5));
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void A(String r5, String r6, String r7, SwitchBindViewModel.fetchAccountInfo.1.2 r8) {
        Intrinsics.checkNotNullParameter(r5, "profileKey");
        Intrinsics.checkNotNullParameter(r6, "platformAppId");
        Intrinsics.checkNotNullParameter(r7, "platform");
        Intrinsics.checkNotNullParameter(r8, "callback");
        d0 r1 = d0.c();
        d0 r2 = r1;
        r2.a("/passport/conflict/connect/get_user_info", null, MapsKt.mapOf(new Pair[]{TuplesKt.to("profile_key", r5), TuplesKt.to("platform_app_id", r6), TuplesKt.to("platform", r7)}), new k(r8));
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void O(FragmentActivity r3, String r4, String r5, t r6) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "businessScene");
        Intrinsics.checkNotNullParameter(r6, "callback");
        ILarkLoginProvider r0 = (ILarkLoginProvider) ServiceManager.get().getService(ILarkLoginProvider.class);
        if (r0 == null) goto L6;
        r0.c(r3, r5, new c(r4, r6));
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void R(int r1, int r2, Intent r3, PhoneLoginActivity.a r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Iterator r5 = ServiceManager.get().getServices(IGooglePhoneLoginProvider.class).iterator();
        if (r5.hasNext() == false) goto L6;
        ((IGooglePhoneLoginProvider) r5.next()).i(r4);
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void S(String r6, String r7, String r8, a0.a r9) {
        Intrinsics.checkNotNullParameter(r6, "token");
        Intrinsics.checkNotNullParameter(r7, "platformAppId");
        Intrinsics.checkNotNullParameter(r8, "platform");
        Intrinsics.checkNotNullParameter(r9, "callback");
        int r4 = f.a;
        Intrinsics.checkNotNullParameter(r6, "token");
        Intrinsics.checkNotNullParameter(r7, "platformAppId");
        Intrinsics.checkNotNullParameter(r8, "platform");
        Intrinsics.checkNotNullParameter(r9, "callback");
        d0 r0 = d0.c();
        d0 r1 = r0;
        r1.b("/passport/auth/verify", null, MapsKt.mapOf(new Pair[]{TuplesKt.to("code", r6), TuplesKt.to("platform_app_id", r7), TuplesKt.to("platform", r8)}), new p38.d(r9));
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void c(String r4, String r5, String r6, SwitchBindViewModel.executeSwitch.1.a r7) {
        Intrinsics.checkNotNullParameter(r4, "profileKey");
        Intrinsics.checkNotNullParameter(r5, "platformAppId");
        Intrinsics.checkNotNullParameter(r6, "verifyTicket");
        Intrinsics.checkNotNullParameter(r7, "callback");
        d0 r0 = d0.c();
        d0 r1 = r0;
        r1.b("/passport/conflict/connect/resolve", null, MapsKt.mapOf(new Pair[]{TuplesKt.to("profile_key", r4), TuplesKt.to("platform_app_id", r5), TuplesKt.to("verify_ticket", r6)}), new r(r7));
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void q(String r11, String r12, String r13, m r14) {
        Intrinsics.checkNotNullParameter(r11, "platformAppId");
        Intrinsics.checkNotNullParameter(r12, "platform");
        Intrinsics.checkNotNullParameter(r13, "authCode");
        Intrinsics.checkNotNullParameter(r14, "callback");
        if (Intrinsics.areEqual(r12, "aweme_v2") == false) goto L5;
        com.bytedance.sdk.account.impl.p r0 = com.bytedance.sdk.account.impl.p.t();
        com.bytedance.sdk.account.impl.p r1 = r0;
        r1.b(r11, r12, r13, null, new a(r14, this));
        return;
    L5:
        com.bytedance.sdk.account.impl.p r2 = com.bytedance.sdk.account.impl.p.t();
        com.bytedance.sdk.account.impl.p r3 = r2;
        r3.i(r11, r12, null, r13, 0, null, new b(r14));
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void w(LoginPlatform r4, boolean r5, GetOauthTokenTriggerScene r6, n38.p r7) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        Intrinsics.checkNotNullParameter(r6, "triggerScene");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IThirdPartyPlatformLoginProvider r1 = (IThirdPartyPlatformLoginProvider) r0.next();
        if (r1.c() != r4) goto L4;
        r1.k(r5, r6, r7);
        goto L4
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void D(LoginPlatform r3, String r4, b4 r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "platform");
        Intrinsics.checkNotNullParameter(r4, "account");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Iterator r8 = ServiceManager.get().getServices(IVerificationCodeLoginProvider.class).iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        IVerificationCodeLoginProvider r0 = (IVerificationCodeLoginProvider) r8.next();
        if (r0.c() == r3) goto L7;
        s r1 = s.a;
        Context r2 = AppHost.a.getApplication().getApplicationContext();
        r1.getClass();
        s.t(r2, "not supported on this platform!");
        goto L4
    L7:
        r0.y(r3, r4, r5, r7);
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void F(LoginPlatform r4, n38.l r5, String r6, boolean r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "token");
        Intrinsics.checkNotNullParameter(r8, "extraInfo");
        Iterator r9 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        IThirdPartyPlatformLoginProvider r0 = (IThirdPartyPlatformLoginProvider) r9.next();
        if (r0.c() != r4) goto L4;
        e10 r1 = e10.a;
        int r2 = l0.a;
        ((Boolean) l0.a(Boolean.FALSE, new fr())).booleanValue();
        r0.z(r5, r6, r8);
        goto L4
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void W(String r6, int r7, String r8, String r9, m r10) {
        Intrinsics.checkNotNullParameter(r6, "mobile");
        Intrinsics.checkNotNullParameter(r8, "ticket");
        Intrinsics.checkNotNullParameter(r10, "callback");
        LinkedHashMap r1 = new LinkedHashMap();
        e10 r2 = e10.a;
        if (e10.L0() == false) goto L5;
        String r3 = MiraMonitor.VALUE_DEFAULT;
    L6:
        r1.put("is6Digits", r3);
        r1.put("app_name", AppHost.a.getAppName());
        boolean r4 = false;
        r1.put("unbindExist", String.valueOf(0));
        r1.put("ticket", r8);
        if (r9.length() != 0) goto L9;
        r4 = true;
    L9:
        if (r4 == true) goto L11;
        r1.put("unusable_mobile_ticket", r9);
    L11:
        com.bytedance.sdk.account.impl.d r11 = com.bytedance.sdk.account.impl.d.l();
        com.bytedance.sdk.account.impl.d r12 = r11;
        r12.s(r6, r7, r1, new l(r10));
        return;
    L5:
        r3 = "1";
        goto L6
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void h(LoginPlatform r4, String r5, String r6, h0.d r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "platform");
        Intrinsics.checkNotNullParameter(r5, "secretMobile");
        Intrinsics.checkNotNullParameter(r6, "account");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Iterator r0 = ServiceManager.get().getServices(IVerificationCodeLoginProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IVerificationCodeLoginProvider r1 = (IVerificationCodeLoginProvider) r0.next();
        if (r1.c() != r4) goto L4;
        r1.d(r4, r5, r6, new q(r8, r7));
        goto L4
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void r(String r8, String r9, String r10, String r11, r3 r12) {
        Intrinsics.checkNotNullParameter(r8, "mobile");
        Intrinsics.checkNotNullParameter(r9, "code");
        Intrinsics.checkNotNullParameter(r10, "ticket");
        Intrinsics.checkNotNullParameter(r12, "callback");
        HashMap r5 = new HashMap();
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        r5.put("unusable_mobile_ticket", r11);
    L8:
        com.bytedance.sdk.account.impl.d r13 = com.bytedance.sdk.account.impl.d.l();
        com.bytedance.sdk.account.impl.d r1 = r13;
        r1.i(r8, r9, r10, r5, new h(r12));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void d(LoginPlatform r2, String r3, String r4, String r5, v3 r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r2, "platform");
        Intrinsics.checkNotNullParameter("15210", "platformId");
        Intrinsics.checkNotNullParameter(r3, "account");
        Intrinsics.checkNotNullParameter(r4, "code");
        Intrinsics.checkNotNullParameter(r5, "profileKey");
        Intrinsics.checkNotNullParameter(r6, "callback");
        com.bytedance.sdk.account.impl.d r8 = com.bytedance.sdk.account.impl.d.l();
        com.bytedance.sdk.account.impl.d r9 = r8;
        r9.b(r3, r4, r5, new g(r2, r6));
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void g(LoginPlatform r2, String r3, String r4, String r5, u3 r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r2, "platform");
        Intrinsics.checkNotNullParameter("15210", "platformId");
        Intrinsics.checkNotNullParameter(r3, "account");
        Intrinsics.checkNotNullParameter(r4, "code");
        Intrinsics.checkNotNullParameter(r5, "profileKey");
        Intrinsics.checkNotNullParameter(r6, "callback");
        com.bytedance.sdk.account.impl.p r8 = com.bytedance.sdk.account.impl.p.t();
        com.bytedance.sdk.account.impl.p r9 = r8;
        r9.r(r3, r4, r5, new f(r6, r2));
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void j(LoginPlatform r7, String r8, z r9, boolean r10, String r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r7, "platform");
        Intrinsics.checkNotNullParameter(r8, "account");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Iterator r14 = ServiceManager.get().getServices(IVerificationCodeLoginProvider.class).iterator();
    L4:
        if (r14.hasNext() == false) goto L10;
        IVerificationCodeLoginProvider r0 = (IVerificationCodeLoginProvider) r14.next();
        if (r0.c() == r7) goto L7;
        s r15 = s.a;
        Context r1 = AppHost.a.getApplication().getApplicationContext();
        r15.getClass();
        s.t(r1, "not supported on this platform!");
        goto L4
    L7:
        r0.s(r7, r8, r9, r12, r13);
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void J(LoginPlatform r10, String r11, String r12, n38.h r13, boolean r14, String r15, JSONObject r16, String r17) {
        Intrinsics.checkNotNullParameter(r10, "platform");
        Intrinsics.checkNotNullParameter(r11, "account");
        Intrinsics.checkNotNullParameter(r12, "code");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Iterator r2 = ServiceManager.get().getServices(IVerificationCodeLoginProvider.class).iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        IVerificationCodeLoginProvider r5 = (IVerificationCodeLoginProvider) r2.next();
        if (r5.c() == r10) goto L7;
        s r6 = s.a;
        Context r7 = AppHost.a.getApplication().getApplicationContext();
        r6.getClass();
        s.t(r7, "not supported on this platform!");
        goto L4
    L7:
        r5.f(r10, r11, r12, new d(r17, r13), r14, r15, AgeGateManagerService.a, r16);
        return;
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void X(PhoneLoginAccountDiscoverySource r11, String r12, String r13, String r14, String r15, boolean r16, PhoneLoginAccountDiscoveryFragment.b r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r17, "callback");
        Iterator r1 = ServiceManager.get().getServices(IVerificationCodeLoginProvider.class).iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (((IVerificationCodeLoginProvider) r2).c() != LoginPlatform.PHONE) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
    L12:
        IVerificationCodeLoginProvider r3 = (IVerificationCodeLoginProvider) r2;
        if (r3 != null) goto L16;
        s r0 = s.a;
        Context r5 = AppHost.a.getApplication().getApplicationContext();
        r0.getClass();
        s.t(r5, "not supported on this platform!");
        return;
    L16:
        r3.u(r11, r12, r13, r14, r15, r16, new o(r18, r17));
        return;
    L8:
        r4 = false;
        goto L9
    L11:
        r2 = null;
        goto L12
    }

    @Override // com.larus.account.base.api.ILoginService
    public final void P(LoginPlatform r7, n38.h r8, boolean r9, String r10, FragmentActivity r11, JSONObject r12, boolean r13, boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r7, "platform");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Iterator r16 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r16.hasNext() == false) goto L12;
        IThirdPartyPlatformLoginProvider r0 = (IThirdPartyPlatformLoginProvider) r16.next();
        if (r0.c() != r7) goto L4;
        n r2 = new n(r15, r8);
        if (r13 == false) goto L10;
        AgeGateManagerService r17 = AgeGateManagerService.a;
        r0.n(r7, r2);
        return;
    L10:
        AgeGateManagerService r18 = AgeGateManagerService.a;
        r0.m(r7, r2, r10, r11, r14);
        return;
    L12:
        s r19 = s.a;
        Context r20 = AppHost.a.getApplication().getApplicationContext();
        r19.getClass();
        s.t(r20, "not supported on this platform!");
    }
}
