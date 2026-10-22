package com.bytedance.ee.bear.middleground.drive.rustsdk.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.q;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.middleground.drive.rustsdk.DriveRustPBWrapper;
import com.bytedance.ee.bear.middleground.drive.rustsdk.DriveStateMonitorImpl;
import com.bytedance.ee.util.ui.m;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.NoticeClientEventRequest;
import com.bytedance.lark.pb.basic.v1.SetReqIdSuffixRequest;
import com.bytedance.lark.pb.space.drive.v1.InitDriveRequest;
import com.bytedance.lark.pb.tool.v1.SetDomainAliasRequest;
import com.bytedance.lark.pb.tool.v1.SetNetworkProxyRequest;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l {
    public static volatile l d;
    public NoticeClientEventRequest.Event a;
    public volatile int b;
    public ml5.b c;

    public static l b() {
        if (d != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new l();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public final void a() {
        qf5.a r0 = qf5.a.c.a(getContext());
        if (r0.a.get() != 2) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        d(true);
        return;
    L12:
        return;
    L5:
        if (r0.a.get() == 1) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean c() {
        qf5.a r0 = qf5.a.c.a(getContext());
        StringBuilder r1 = new StringBuilder("inited() = ");
        if (r0.a.get() != 2) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        tt5.a.h("Middleground_Drive_DriveSDK", r1.toString());
        if (r0.a.get() != 2) goto L10;
        return true;
    L10:
        return false;
    L5:
        r2 = false;
        goto L6
    }

    public final void e() {
        ml5.b r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = (String) r0.a("ip_proxy_rust", "");
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return;
    L8:
        if (r1.contains(":") == false) goto L12;
        Uri r2 = UriProtector.parse(r1);
        String r3 = r2.getHost();
        String r4 = r2.getPort() + "";
        SetNetworkProxyRequest.Builder r5 = new SetNetworkProxyRequest.Builder();
        r5.proxy_url("http://" + r3 + ":" + r4);
        SdkSender.asynSendRequestNonWrap(Command.SET_NETWORK_PROXY, r5, null, new a());
        return;
    }

    public final void f() {
        if (((NetService) org.koin.java.a.a(NetService.class)).getEnv() != 2) goto L7;
        ml5.b r0 = this.c;
        if (r0 == null) goto L7;
        SdkSender.asynSendRequestNonWrap(Command.SET_REQ_ID_SUFFIX, new SetReqIdSuffixRequest.Builder().suffix("#" + ((String) r0.a("http_request_id", ""))), null, new a());
        return;
    L7:
        SdkSender.asynSendRequestNonWrap(Command.SET_REQ_ID_SUFFIX, new SetReqIdSuffixRequest.Builder().suffix(""), null, new a());
    }

    public l() {
        this.b = 0;
        SharedPreferences.OnSharedPreferenceChangeListener r1 = new e(this);
        getContext();
        boolean r3 = true;
        if (eu5.g.c().endsWith(":p0") == false) goto L6;
        this.b = 1;
    L9:
        if (this.b == 1) goto L12;
        r3 = false;
    L12:
        if (r3 == false) goto L18;
        ApkUtil.getAppVersionName(getContext());
        ml5.b r2 = new ml5.b("debug_config");
        this.c = r2;
        r2.registerOnSharedPreferenceChangeListener(r1);
        getContext();
        com.bytedance.ee.bear.contract.f r4 = (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class);
        if (eu5.g.j() == false) goto L16;
        final MutableLiveData r5 = r4.c();
    L17:
        final MutableLiveData r6 = r4.b();
        final MediatorLiveData r7 = new MediatorLiveData();
        r7.addSource(r5, new q(r7));
        r7.addSource(r6, new q(r7));
        m.a(new f(this, r7, r5, r6));
        f();
        e();
        ((h0) org.koin.java.a.a(h0.class)).Pe(new k(this));
        goto L18
    L16:
        r5 = r4.h();
    L18:
        SetDomainAliasRequest.Builder r8 = new SetDomainAliasRequest.Builder();
        b0 r9 = (b0) org.koin.java.a.a(b0.class);
        if (TextUtils.isEmpty(r9.p()) == true) goto L21;
        r8.domain2alias.put(r9.p(), DomainSettings.Alias.DOCS_API);
    L22:
        SdkSender.asynSendRequestNonWrap(Command.SET_DOMAIN_ALIAS, r8, new RustSdkServiceImp$2(this), new g());
        tt5.a.h("BaseRustServiceImp", "setDomainAlias()");
        tt5.a.h("BaseRustServiceImp", "drive initDrive");
        d(false);
        return;
    L21:
        tt5.a.d("BaseRustServiceImp", "setDomainAlias: getDocsInterfaceDomain maybe return empty");
        goto L22
    L6:
        if (eu5.g.j() == false) goto L9;
        this.b = 2;
        goto L9
    }

    private Context getContext() {
        return eu5.b.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.ee.bear.middleground.drive.rustsdk.init.d, java.lang.Runnable] */
    public final void d(boolean r11) {
        if (eu5.g.j() == false) goto L5;
    L6:
        tt5.a.h("BaseRustServiceImp", "drive lazyInit start");
        String r0 = ay4.c.b.a(getContext(), Biz.RUSTSDK, "suiteDrive");
        VFSPath r1 = ay4.d.a().z(r0);
        if (eu5.g.j() == false) goto L9;
        String r2 = r1.subPath("main").getRealPath();
    L10:
        String r3 = r2;
        if (r11 == false) goto L43;
        qf5.a r12 = qf5.a.c.a(getContext());
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive start");
        boolean r7 = true;
        r12.a.set(1);
        AccountService.Account r4 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();     // Catch: Exception -> L42
        if (r4 != null) goto L16;
    L41:
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive error account");
        r12.a.set(0);
        return;
    L16:
        if (r4.hasLogin() == false) goto L41;
        String r6 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getDeviceId();
        if (TextUtils.isEmpty(r6) == false) goto L21;
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive error deviceId");
        r12.a.set(0);
        return;
    L21:
        DriveRustSdkWrapper.a r9 = new DriveRustSdkWrapper.a(r3, r4.token, r4.uid, r4.tenantId, r6);
        DriveRustSdkWrapper r5 = DriveRustSdkWrapper.b();
        monitor-enter(r5);
        tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "DriveRustPBWrapper sync initSdk: ");     // Catch: Throwable -> L38
        if (r9.equals(DriveRustSdkWrapper.a) == false) goto L27;
        monitor-exit(r5);
    L34:
        if (r7 == false) goto L36;
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive end initResult true");
        r12.a.set(2);
        DriveStateMonitorImpl.a().b();
    L37:
        tt5.a.h("BaseRustServiceImp", "drive syncinit end");
        return;
    L36:
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive end initResult false");
        r12.a.set(0);
        goto L37
    L27:
        DriveRustSdkWrapper.a = r9;     // Catch: Throwable -> L38
        tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "DriveRustPBWrapper sync initSdk: real ");     // Catch: Throwable -> L38
        DriveRustSdkWrapper.c(r9);     // Catch: Exception -> L30 Throwable -> L38
        DriveRustPBWrapper.g().e = false;     // Catch: Exception -> L30 Throwable -> L38
        InitDriveRequest.Builder r8 = DriveRustSdkWrapper.a(r9);     // Catch: Exception -> L30 Throwable -> L38
        b r10 = new b();     // Catch: Exception -> L30 Throwable -> L38
        r7 = ((Boolean) SdkSender.syncSend(Command.SUITE_DRIVE_INIT_DRIVE, r8, r10)).booleanValue();     // Catch: Exception -> L30 Throwable -> L38
    L33:
        monitor-exit(r5);
        goto L34
    L30:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustSdkWrapper", "DriveRustPBWrapper sync initSdk: ", e, false);     // Catch: Throwable -> L38
        r7 = false;
    L38:
        th = move-exception;
        throw th;
    L42:
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive error account service");
        r12.a.set(0);
        return;
    L43:
        qf5.a r13 = qf5.a.c.a(getContext());
        ?? r14 = new d();
        h0 r15 = (h0) org.koin.java.a.c(h0.class, null, null, 6);
        AccountService.Account r16 = r15.G2();
        tt5.a.h("Middleground_Drive_DriveSDK", "drive start init from cache account");
        if (r16 != null) goto L46;
    L48:
        qf5.b r17 = r13.b;
        if (r17 == null) goto L51;
        r15.qc(r17);
    L51:
        qf5.b r18 = new qf5.b(r13, r14, r3);
        r13.b = r18;
        r15.Pe(r18);
        return;
    L46:
        if (r16.hasLogin() == false) goto L48;
        r13.a(r14, r3, r16);
        goto L48
    L9:
        r2 = r1.subPath("space").getRealPath();
        goto L10
    L5:
        if (eu5.g.i() == true) goto L6;
    }
}
