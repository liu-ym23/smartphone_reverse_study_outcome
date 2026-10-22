package com.ss.android.lark.larkconfig.userconfig;

import android.text.TextUtils;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.GetAppConfigRequest;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.settings.v1.GetUniversalUserSettingRequest;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.larkconfig.universal.UniversalUserSettingService$getAllUniversalUserSetting$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.storage.LarkKVStorage;
import com.suite.lark.component.protocol.Biz;
import java.lang.ref.Reference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f431141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f431142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile tpb.a f431143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<tpb.b, Object> f431144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f431145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f431146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f431147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f431148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f431149i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f431150a = null;

        static {
            f431150a = new e();
        }
    }

    public final tpb.a a() {
        if (TextUtils.equals(((upb.a) ClaymoreServiceLoader.loadFirst(upb.a.class)).getUserId(), this.f431145e) == true) goto L5;
        return null;
    L5:
        return this.f431143c;
    }

    public final void b() {
        Log.i("AppUserConfigService", "init called");
        com.ss.android.lark.larkconfig.userconfig.a r100 = com.ss.android.lark.larkconfig.userconfig.a.C5120a.f431132a;
        com.ss.android.lark.larkconfig.userconfig.a.C5120a.f431132a = new com.ss.android.lark.larkconfig.userconfig.a();
    L4:
        if (r100.f431152b.isEmpty() == true) goto L10;
        if (((f.b) ((LinkedBlockingQueue) r100.f431152b).poll()) == null) goto L4;
        ((ConcurrentHashMap) r100.f431151a).get(null);
        throw null;
    L10:
        Object r101 = this.f431142b;
        monitor-enter(r101);
    L20:
        th = move-exception;
        throw th;
    L13:
        if (this.f431148h == true) goto L18;
        opb.e.a.f524824a.e();     // Catch: Throwable -> L20
        com.ss.android.lark.larkconfig.universal.e r102 = com.ss.android.lark.larkconfig.universal.e.f431131a;     // Catch: Throwable -> L20
        GetUniversalUserSettingRequest.Builder r103 = new GetUniversalUserSettingRequest.Builder().need_all_keys(Boolean.TRUE).strategy(SyncDataStrategy.FORCE_SERVER);     // Catch: Throwable -> L20
        SdkSender.asynSendRequestNonWrap(Command.GET_UNIVERSAL_USER_SETTING, r103, new UniversalUserSettingService$getAllUniversalUserSetting$1(), com.ss.android.lark.larkconfig.universal.b.f431128a);     // Catch: Throwable -> L20
        c();     // Catch: Throwable -> L20
        if (this.f431149i == true) goto L17;
        ((upb.a) ClaymoreServiceLoader.loadFirst(upb.a.class)).registerAccountChangeListener(this.f431146f);     // Catch: Throwable -> L20
        this.f431149i = true;     // Catch: Throwable -> L20
    L17:
        this.f431148h = true;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L20
    }

    public final void c() {
        if (this.f431147g.get() == true) goto L15;
        Object r100 = this.f431141a;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (a() != null) goto L14;
        String r101 = ((upb.a) ClaymoreServiceLoader.loadFirst(upb.a.class)).getUserId();     // Catch: Throwable -> L12
        this.f431143c = (tpb.a) LarkKVStorage.j(Biz.Core, true).getJSONObject(String.format("%s_%s", new Object[]{r101, "key_app_config_v1"}), tpb.a.class);     // Catch: Throwable -> L12
        if (this.f431143c == null) goto L14;
        this.f431145e = r101;     // Catch: Throwable -> L12
        Log.i("AppUserConfigService", "loaded app config from local");     // Catch: Throwable -> L12
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L12
    L15:
        final String r102 = ((upb.a) ClaymoreServiceLoader.loadFirst(upb.a.class)).getUserId();
        GetAppConfigRequest.Builder r103 = new GetAppConfigRequest.Builder();
        r103.force_remote(Boolean.TRUE);
        SdkSender.asynSendRequestNonWrap(Command.GET_APP_CONFIG, r103, new AppUserConfigService$1(this), new b(this, r102));
    }

    public final void d() {
        Object r100 = this.f431142b;
        monitor-enter(r100);
        opb.e.a.f524824a.getClass();     // Catch: Throwable -> L16
        com.ss.android.lark.appsetting.api.service.d.a.f408956a.getClass();     // Catch: Throwable -> L16
        com.ss.android.lark.appsetting.api.e r101 = com.ss.android.lark.appsetting.api.e.a.f408951a;     // Catch: Throwable -> L16
        if (r101.f408948b == null) goto L7;
        r101.f408948b.clear();     // Catch: Throwable -> L16
    L7:
        Map<String, Reference<Map<String, Object>>> r102 = r101.f408949c;     // Catch: Throwable -> L16
        if (r102 == null) goto L10;
        ((HashMap) r102).clear();     // Catch: Throwable -> L16
    L10:
        Reference<Map<String, AppConfig>> r103 = r101.f408947a;     // Catch: Throwable -> L16
        if (r103 == null) goto L13;
        r103.clear();     // Catch: Throwable -> L16
    L13:
        this.f431148h = false;     // Catch: Throwable -> L16
        this.f431143c = null;     // Catch: Throwable -> L16
        this.f431145e = null;     // Catch: Throwable -> L16
        this.f431147g.set(false);     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public e() {
        this.f431141a = new Object();
        this.f431142b = new Object();
        this.f431144d = new ConcurrentHashMap();
        this.f431147g = new AtomicBoolean(false);
        this.f431148h = false;
        this.f431149i = false;
        this.f431146f = new c(this);
    }
}
