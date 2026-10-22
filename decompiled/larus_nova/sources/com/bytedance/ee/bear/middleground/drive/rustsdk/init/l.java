package com.bytedance.ee.bear.middleground.drive.rustsdk.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.ee.bear.contract.AccountService$Account;
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

/* JADX INFO: loaded from: classes18.dex */
public final class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile l f232590d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NoticeClientEventRequest.Event f232591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f232592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ml5.b f232593c;

    public static l b() {
        if (f232590d != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f232590d != null) goto L9;
        f232590d = new l();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f232590d;
    }

    public final void a() {
        qf5.a r100 = qf5.a.f532733c.a(getContext());
        if (r100.f532735a.get() != 2) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L12;
        d(true);
        return;
    L12:
        return;
    L5:
        if (r100.f532735a.get() == 1) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean c() {
        qf5.a r100 = qf5.a.f532733c.a(getContext());
        StringBuilder r101 = new StringBuilder("inited() = ");
        if (r100.f532735a.get() != 2) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        tt5.a.h("Middleground_Drive_DriveSDK", r101.toString());
        if (r100.f532735a.get() != 2) goto L10;
        return true;
    L10:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public final void e() {
        ml5.b r100 = this.f232593c;
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = (String) r100.a("ip_proxy_rust", "");
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (r101.contains(":") == false) goto L12;
        Uri r102 = UriProtector.parse(r101);
        String r103 = r102.getHost();
        String r104 = r102.getPort() + "";
        SetNetworkProxyRequest.Builder r105 = new SetNetworkProxyRequest.Builder();
        r105.proxy_url("http://" + r103 + ":" + r104);
        SdkSender.asynSendRequestNonWrap(Command.SET_NETWORK_PROXY, r105, null, new a());
        return;
    }

    public final void f() {
        if (((NetService) org.koin.java.a.a(NetService.class)).getEnv() != 2) goto L7;
        ml5.b r100 = this.f232593c;
        if (r100 == null) goto L7;
        SdkSender.asynSendRequestNonWrap(Command.SET_REQ_ID_SUFFIX, new SetReqIdSuffixRequest.Builder().suffix("#" + ((String) r100.a("http_request_id", ""))), null, new a());
        return;
    L7:
        SdkSender.asynSendRequestNonWrap(Command.SET_REQ_ID_SUFFIX, new SetReqIdSuffixRequest.Builder().suffix(""), null, new a());
    }

    public l() {
        this.f232592b = 0;
        SharedPreferences.OnSharedPreferenceChangeListener r100 = new e(this);
        getContext();
        boolean r101 = true;
        if (eu5.g.c().endsWith(":p0") == false) goto L6;
        this.f232592b = 1;
    L9:
        if (this.f232592b == 1) goto L12;
        r101 = false;
    L12:
        if (r101 == false) goto L18;
        ApkUtil.getAppVersionName(getContext());
        ml5.b r102 = new ml5.b("debug_config");
        this.f232593c = r102;
        r102.registerOnSharedPreferenceChangeListener(r100);
        getContext();
        com.bytedance.ee.bear.contract.f r103 = (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class);
        if (eu5.g.j() == false) goto L16;
        final MutableLiveData r104 = r103.c();
    L17:
        final MutableLiveData r105 = r103.b();
        final MediatorLiveData r106 = new MediatorLiveData();
        r106.addSource(r104, new q(r106));
        r106.addSource(r105, new q(r106));
        m.a(new f(this, r106, r104, r105));
        f();
        e();
        ((h0) org.koin.java.a.a(h0.class)).Pe(new k(this));
        goto L18
    L16:
        r104 = r103.h();
    L18:
        SetDomainAliasRequest.Builder r107 = new SetDomainAliasRequest.Builder();
        b0 r108 = (b0) org.koin.java.a.a(b0.class);
        if (TextUtils.isEmpty(r108.p()) == true) goto L21;
        r107.domain2alias.put(r108.p(), DomainSettings.Alias.DOCS_API);
    L22:
        SdkSender.asynSendRequestNonWrap(Command.SET_DOMAIN_ALIAS, r107, new RustSdkServiceImp$2(this), new g());
        tt5.a.h("BaseRustServiceImp", "setDomainAlias()");
        tt5.a.h("BaseRustServiceImp", "drive initDrive");
        d(false);
        return;
    L21:
        tt5.a.d("BaseRustServiceImp", "setDomainAlias: getDocsInterfaceDomain maybe return empty");
        goto L22
    L6:
        if (eu5.g.j() == false) goto L9;
        this.f232592b = 2;
        goto L9
    }

    private Context getContext() {
        return eu5.b.f474075a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.ee.bear.middleground.drive.rustsdk.init.d, java.lang.Runnable] */
    public final void d(boolean r110) {
        if (eu5.g.j() == false) goto L5;
    L6:
        tt5.a.h("BaseRustServiceImp", "drive lazyInit start");
        String r100 = ay4.c.b.a(getContext(), Biz.RUSTSDK, "suiteDrive");
        VFSPath r101 = ay4.d.a().z(r100);
        if (eu5.g.j() == false) goto L9;
        String r102 = r101.subPath(PullConfiguration.PROCESS_NAME_MAIN).getRealPath();
    L10:
        String r103 = r102;
        if (r110 == false) goto L43;
        qf5.a r111 = qf5.a.f532733c.a(getContext());
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive start");
        boolean r104 = true;
        r111.f532735a.set(1);
        AccountService$Account r105 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();     // Catch: Exception -> L42
        if (r105 != null) goto L16;
    L41:
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive error account");
        r111.f532735a.set(0);
        return;
    L16:
        if (r105.hasLogin() == false) goto L41;
        String r106 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getDeviceId();
        if (TextUtils.isEmpty(r106) == false) goto L21;
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive error deviceId");
        r111.f532735a.set(0);
        return;
    L21:
        DriveRustSdkWrapper.a r107 = new DriveRustSdkWrapper.a(r103, r105.token, r105.uid, r105.tenantId, r106);
        DriveRustSdkWrapper r108 = DriveRustSdkWrapper.b();
        monitor-enter(r108);
        tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "DriveRustPBWrapper sync initSdk: ");     // Catch: Throwable -> L38
        if (r107.equals(DriveRustSdkWrapper.f232570a) == false) goto L27;
        monitor-exit(r108);
    L34:
        if (r104 == false) goto L36;
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive end initResult true");
        r111.f532735a.set(2);
        DriveStateMonitorImpl.a().b();
    L37:
        tt5.a.h("BaseRustServiceImp", "drive syncinit end");
        return;
    L36:
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive end initResult false");
        r111.f532735a.set(0);
        goto L37
    L27:
        DriveRustSdkWrapper.f232570a = r107;     // Catch: Throwable -> L38
        tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "DriveRustPBWrapper sync initSdk: real ");     // Catch: Throwable -> L38
        DriveRustSdkWrapper.c(r107);     // Catch: Exception -> L30 Throwable -> L38
        DriveRustPBWrapper.g().f232533e = false;     // Catch: Exception -> L30 Throwable -> L38
        InitDriveRequest.Builder r109 = DriveRustSdkWrapper.a(r107);     // Catch: Exception -> L30 Throwable -> L38
        b r112 = new b();     // Catch: Exception -> L30 Throwable -> L38
        r104 = ((Boolean) SdkSender.syncSend(Command.SUITE_DRIVE_INIT_DRIVE, r109, r112)).booleanValue();     // Catch: Exception -> L30 Throwable -> L38
    L33:
        monitor-exit(r108);
        goto L34
    L30:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustSdkWrapper", "DriveRustPBWrapper sync initSdk: ", e, false);     // Catch: Throwable -> L38
        r104 = false;
    L38:
        th = move-exception;
        throw th;
    L42:
        tt5.a.h("Middleground_Drive_DriveSDK", "sync init drive error account service");
        r111.f532735a.set(0);
        return;
    L43:
        qf5.a r113 = qf5.a.f532733c.a(getContext());
        ?? r114 = new d();
        h0 r115 = (h0) org.koin.java.a.c(h0.class, null, null, 6);
        AccountService$Account r116 = r115.G2();
        tt5.a.h("Middleground_Drive_DriveSDK", "drive start init from cache account");
        if (r116 != null) goto L46;
    L48:
        qf5.b r117 = r113.f532736b;
        if (r117 == null) goto L51;
        r115.qc(r117);
    L51:
        qf5.b r118 = new qf5.b(r113, r114, r103);
        r113.f532736b = r118;
        r115.Pe(r118);
        return;
    L46:
        if (r116.hasLogin() == false) goto L48;
        r113.a(r114, r103, r116);
        goto L48
    L9:
        r102 = r101.subPath("space").getRealPath();
        goto L10
    L5:
        if (eu5.g.i() == true) goto L6;
    }
}
