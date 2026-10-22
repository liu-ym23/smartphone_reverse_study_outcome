package com.bytedance.locallife.adapter.impl.host.gecko;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.i;
import com.bytedance.forest.model.j;
import com.bytedance.forest.utils.r;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.hybrid.gecko.LifeGeckoRegister;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import fp6.d;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ss6.c;

/* JADX INFO: loaded from: classes20.dex */
public class LifeGeckoxService implements gt6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f256456a;

    @Override // gt6.b
    public final void b() {
    }

    @Override // gt6.b
    public final String a() {
        File r100 = HostServiceUtilsKt.E().getApplicationContext().getFilesDir();
        if (r100 == null) goto L5;
        String r101 = r100.getAbsolutePath();
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        return new PolarisFileWrapper(r101, "offlineX").getAbsolutePath();
    L5:
        r101 = null;
        goto L6
    }

    @Override // gt6.b
    public final String d() {
        LifeGeckoRegister.Companion.getClass();
        com.bytedance.geckox.b r100 = com.bytedance.geckox.b.a.f245076a;
        GeckoGlobalConfig r101 = com.bytedance.geckox.b.a();
        if (r101 == null) goto L5;
        GeckoGlobalConfig.ENVType r102 = r101.getEnv();
    L6:
        if (r102 != null) goto L8;
        int r103 = -1;
    L10:
        if (r103 != 1) goto L12;
        return LifeGeckoRegister.AK_BOE;
    L12:
        if (r103 == 2) goto L14;
        return LifeGeckoRegister.AK_TEST;
    L14:
        return LifeGeckoRegister.AK_PROD;
    L8:
        r103 = LifeGeckoRegister.a.C3665a.f259076a[r102.ordinal()];
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // gt6.b
    public final boolean h() {
        return ((Boolean) this.f256456a.getValue()).booleanValue();
    }

    @Override // gt6.b
    public final d i() {
        b r100 = b.f256458a;
        if (b.f256459b != null) goto L24;
        monitor-enter(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        c r102 = HostServiceUtilsKt.E();     // Catch: Throwable -> L12
        gt6.b r103 = HostServiceUtilsKt.B();     // Catch: Throwable -> L12
        String r104 = r103.d();     // Catch: Throwable -> L12
        String r105 = r103.a();     // Catch: Throwable -> L12
        long r106 = r102.getAppId();     // Catch: Throwable -> L12
        String r107 = r102.getBussinessVersionName();     // Catch: Throwable -> L12
        String r110 = r102.getDeviceId();     // Catch: Throwable -> L12
        r103.b();     // Catch: Throwable -> L12
        i r108 = new i("gecko.zijieapi.com", new GeckoConfig(r104, r105, r106, r107, r110, "CN", false), 4);     // Catch: Throwable -> L12
        Context r109 = r102.getApplicationContext();     // Catch: Throwable -> L12
        if ((r109 instanceof Application) == false) goto L9;
        Forest r111 = new Forest((Application) r109, r108);     // Catch: Throwable -> L12
        b.f256459b = r111;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);
    L26:
        return new d(r111);
    L9:
        r111 = null;
    L12:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L21
        Throwable r113 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));     // Catch: Throwable -> L21
        if (r113 == null) goto L24;
        int r114 = com.bytedance.locallife.biz.mob.a.f256703c;     // Catch: Throwable -> L21
        Pair[] r115 = new Pair[2];     // Catch: Throwable -> L21
        r115[0] = TuplesKt.to("code", "0");     // Catch: Throwable -> L21
        String r116 = r113.getMessage();     // Catch: Throwable -> L21
        if (r116 != null) goto L18;
        r116 = "";
    L18:
        r115[1] = TuplesKt.to("msg", r116);     // Catch: Throwable -> L21
        com.bytedance.locallife.biz.mob.a.C3646a.c("poi_local_res_load_error", MapsKt.hashMapOf(r115));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L24:
        r111 = b.f256459b;
        goto L26
    }

    public LifeGeckoxService() {
        this.f256456a = LazyKt.lazy(LifeGeckoxService$lifeSaasRegisterLifeCenterGecko$2.INSTANCE);
    }

    @Override // gt6.b
    public final long c(String r100) {
        b r101 = b.f256458a;
        String r102 = a();
        String r103 = d();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Long r104 = b.a(r102, r103, r100);
        if (r104 != null) goto L10;
        return -1;
    L10:
        return r104.longValue();
    }

    @Override // gt6.b
    public final long e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "accessKey");
        Intrinsics.checkNotNullParameter("live_local_life_shelf_components", "channel");
        b r101 = b.f256458a;
        Long r102 = b.a(a(), r100, "live_local_life_shelf_components");
        if (r102 != null) goto L7;
        return -1;
    L7:
        return r102.longValue();
    }

    @Override // gt6.b
    public final boolean f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        b r101 = b.f256458a;
        String r102 = a();
        String r103 = d();
        if (TextUtils.isEmpty(r103) == false) goto L5;
    L10:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNull(r103);
        Intrinsics.checkNotNull(r100);
        if (b.a(r102, r103, r100) == null) goto L10;
        return true;
    }

    @Override // gt6.b
    public final j g(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = UriProtector.getQueryParameter(r100, "surl");
        if (r101 == null) goto L7;
        String r102 = UriProtector.parse(r101).getPath();
        if (r102 == null) goto L7;
        return r.a(r101, GeckoXAdapter.Companion.getPrefixAsGeckoCDN(r102));
    L7:
        return null;
    }

    @Override // gt6.b
    public final String getChannelPath(String r100) {
        String r101 = "live_local_life_shelf_components";
        Intrinsics.checkNotNullParameter(r100, "accessKey");
        Intrinsics.checkNotNullParameter("live_local_life_shelf_components", "channel");
        b r102 = b.f256458a;
        String r103 = a();
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L17:
        return null;
    L5:
        if (TextUtils.isEmpty("live_local_life_shelf_components") == true) goto L17;
        if (TextUtils.isEmpty(r103) == true) goto L17;
        Intrinsics.checkNotNull("live_local_life_shelf_components");
        if (StringsKt.indexOf$default("live_local_life_shelf_components", HTTP.URL_DEFAULT, 0, false, 6, null) != 0) goto L14;
        r101 = "ive_local_life_shelf_components";
    L14:
        if (StringsKt.lastIndexOf$default(r101, HTTP.URL_DEFAULT, 0, false, 6, null) != (r101.length() - 1)) goto L19;
        r101 = r101.substring(0, StringsKt.lastIndexOf$default(r101, HTTP.URL_DEFAULT, 0, false, 6, null));
    L19:
        return ResLoadUtils.getChannelPath(new PolarisFileWrapper(r103), r100, r101);
    }

    @Override // gt6.b
    public final String j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ak");
        com.bytedance.geckox.b r101 = com.bytedance.geckox.b.a.f245076a;
        GlobalConfigSettings r102 = com.bytedance.geckox.b.b();
        if (r102 == null) goto L11;
        GlobalConfigSettings.ResourceMeta r103 = r102.getResourceMeta();
        if (r103 == null) goto L11;
        GlobalConfigSettings.CurrentLevelConfig r104 = r103.getConfig();
        if (r104 == null) goto L11;
        Map<String, String> r105 = r104.getPrefix2AccessKey();
        if (r105 == null) goto L11;
        return r105.get(r100);
    L11:
        return null;
    }
}
