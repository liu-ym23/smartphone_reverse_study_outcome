package com.bytedance.sdk.account.devicetransfer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.bd_sec_tee.core.TeeProvider;
import com.bytedance.bd_sec_tee.core.model.TeeResult;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.sdk.account.impl.j;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.settings.AccountHostSettingsManager;
import com.bytedance.sdk.account.utils.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.account.k;
import com.ss.android.token.AuthTokenMultiProcessSharedProvider;
import com.ss.android.token.h0;
import com.ss.android.token.r;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import qb7.b;
import qb7.c;

/* JADX INFO: loaded from: classes3.dex */
public final class AccountDeviceTransferManager extends b<Bundle> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f268880e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f268881f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f268882g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AccountDeviceTransferManager f268883h = null;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f268884a = null;

        static {
            f268884a = new a();
        }

        public a() {
        }

        public static void a() {
            AccountDeviceTransferManager r100 = AccountDeviceTransferManager.f268883h;
            r100.getClass();
            c r101 = new c();
            r101.f532409a = -2;
            IOnekeyLoginService r102 = (IOnekeyLoginService) AuthorizeFramework.getService(IOnekeyLoginService.class);
            if (r102 != null) goto L5;
            r101.f532410b = "oneKeyLoginService is null";
            r100.c(r101);
            return;
        L5:
            r102.getAuthToken("device_transfer", false, true, new com.bytedance.sdk.account.devicetransfer.a(r101, r102));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f268880e = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AccountDeviceTransferManager.class), "mEnableDeviceTransferLogoutForInit", "getMEnableDeviceTransferLogoutForInit()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AccountDeviceTransferManager.class), "teeProvider", "getTeeProvider()Lcom/bytedance/bd_sec_tee/core/TeeProvider;"))};
        f268883h = new AccountDeviceTransferManager();
        f268881f = LazyKt.lazy(AccountDeviceTransferManager$mEnableDeviceTransferLogoutForInit$2.INSTANCE);
        f268882g = LazyKt.lazy(AccountDeviceTransferManager$teeProvider$2.INSTANCE);
    }

    @Override // qb7.b
    public final String b() {
        return "AccountDeviceTransferManager";
    }

    @JvmStatic
    public static final boolean g() {
        f268883h.getClass();
        Lazy r100 = f268881f;
        KProperty r101 = f268880e[0];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    @Override // qb7.b
    public final void d() {
        c r100 = new c();
        r100.f532409a = -1;
        Context r101 = k.c();
        if (r101 != null) goto L6;
        r100.f532410b = "context is null";
    L32:
        c(r100);
        return;
    L6:
        if (h0.d(r101) == true) goto L9;
        r100.f532410b = "not main process";
        goto L32
    L9:
        if (j.m(r101).isLogin() == true) goto L12;
        r100.f532410b = "not login";
        goto L32
    L12:
        if (g() == true) goto L14;
        r100.f532410b = "isEnableDeviceTransferLogout=false";
        goto L32
    L14:
        AuthTokenMultiProcessSharedProvider.b r102 = r.f449787a;
        String r103 = r.f449794h;
        boolean r104 = true;
        if (n.a(r103) == false) goto L23;
        Lazy r105 = f268882g;
        KProperty r106 = f268880e[1];
        TeeProvider r107 = (TeeProvider) r105.getValue();
        r107.getClass();
        if (TextUtils.isEmpty(r103) == true) goto L23;
        X509EncodedKeySpec r108 = new X509EncodedKeySpec(Base64.decode(r103, 0));     // Catch: Exception -> L21
        r107.f199570a.getClass();     // Catch: Exception -> L21
        PublicKey r109 = KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(r108);     // Catch: Exception -> L21
    L24:
        Lazy r110 = f268882g;
        KProperty r111 = f268880e[1];
        TeeResult<String> r112 = ((TeeProvider) r110.getValue()).a("device_transfer", r109);
        if (r112.f199579c == 0) goto L27;
    L29:
        r104 = false;
    L30:
        if (r104 == true) goto L34;
        r100.f532410b = "isDeviceTransfer=false";
        goto L32
    L34:
        AuthorizeFramework.addInitListener(IOnekeyLoginService.class, a.f268884a);
        return;
    L27:
        if (r112.f199583g != TeeResult.ResultType.PUB_COMPARE_NOT_EQUAL) goto L29;
    L21:
        e = move-exception;
        r107.e("Failed to decode public key", e);
    L23:
        r109 = null;
        goto L24
    }

    @JvmStatic
    public static final boolean f() {
        com.bytedance.sdk.account.settings.common.a.a();
        int r100 = com.bytedance.sdk.account.settings.common.a.K;
        if (r100 != 0) goto L5;
    L10:
        return false;
    L5:
        if (r100 != 1) goto L7;
        return true;
    L7:
        if (r100 != 2) goto L10;
        AccountHostSettingsManager.f269319d.getClass();
        AccountHostSettingsManager.f269317b.getClass();
        goto L10
    }

    public AccountDeviceTransferManager() {
    }
}
