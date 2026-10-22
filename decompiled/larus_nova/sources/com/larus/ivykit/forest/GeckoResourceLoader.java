package com.larus.ivykit.forest;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.o;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public class GeckoResourceLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f351633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Forest f351634c;

    public static final class a {
    }

    static {
    }

    public GeckoResourceLoader(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "accessKey");
        Intrinsics.checkNotNullParameter(r111, "offlineDir");
        this.f351632a = r110;
        FLogger.f375446a.d("GeckoResourceLoader", "init loader: accessKey = " + r110 + ", offlineDir = " + r111);
        AppHost.Companion r100 = AppHost.f326268a;
        long r101 = (long) r100.getAppId();
        String r102 = r100.getVersionName();
        String r103 = o.f365780a.getDeviceId();
        if (r100.isOversea() == false) goto L5;
        String r104 = EnvConst$GEO.SG;
    L6:
        GeckoConfig r105 = new GeckoConfig(r110, r111, r101, r102, r103, r104);
        pg9.b.f529212a.getClass();
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put(r110, r105);
        Unit r113 = Unit.INSTANCE;
        this.f351633b = new i("gecko.doubao.com", r105, r112);
        this.f351634c = new Forest(r100.getApplication(), this.f351633b);
        return;
    L5:
        r104 = "cn";
        goto L6
    }

    public static String b(String r110, String r111) {
        if (StringsKt.startsWith$default(r110, "http://", false, 2, null) == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L11;
        return r110;
    L11:
        int r101 = l0.f375430a;
        List r112 = StringsKt.split$default((CharSequence) l0.a("", new GeckoResourceLoader$handleBundle$data$1(new URL(r110))), new String[]{r111}, false, 0, 6, null);
        if (r112.size() == 2) goto L14;
        return "";
    L14:
        return StringsKt.removePrefix((String) ListProtector.get(r112, 1), HTTP.URL_DEFAULT);
    L5:
        if (StringsKt.startsWith$default(r110, "https://", false, 2, null) == true) goto L8;
        r100 = false;
        goto L9
    }

    public final RequestParams a(String r100, String r101, boolean r102, boolean r103) {
        RequestParams r104 = new RequestParams(0);
        r104.f244272b = this.f351632a;
        r104.f244273c = r101;
        r104.f244274d = r100;
        r104.f244285o = r102;
        r104.f244276f = r103;
        FLogger.f375446a.d("GeckoResourceLoader", "createParam: accessKey = " + r104.f244272b + ", channel = " + r101 + ", bundle = " + r100 + ", onlyLocal=" + r102 + ", waitGeckoUpdate=" + r103);
        return r104;
    }

    public final String c(String r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "bundleOrUrl");
        Intrinsics.checkNotNullParameter(r101, "channel");
        Forest r104 = this.f351634c;
        boolean r105 = false;
        if (StringsKt.startsWith$default(r100, "http://", false, 2, null) == false) goto L5;
    L6:
        r105 = true;
    L8:
        if (r105 == false) goto L10;
        String r106 = r100;
    L11:
        com.bytedance.forest.model.o r107 = r104.createSyncRequest(r106, a(b(r100, r101), r101, r102, r103));
        if (r107 == null) goto L22;
        Response r108 = r107.b();
        if (r108 == null) goto L23;
        FLogger.f375446a.d("GeckoResourceLoader", "loadSync-bundleOrUrl: " + r100 + ", success:" + r108.f244316r + ", errorInfo:" + r108.f244317s + ", from:" + r108.f244319u + ", cache:" + r108.f244323y + ", version:" + r108.B + ", filePath:" + r108.f244318t);
        if (r108.f244316r == false) goto L24;
        String r109 = r108.f244318t;
        if (r109 != null) goto L21;
        return "";
    L21:
        return r109;
    L24:
        return "";
    L23:
        return "";
    L22:
        return "";
    L10:
        r106 = "";
        goto L11
    L5:
        if (StringsKt.startsWith$default(r100, "https://", false, 2, null) == false) goto L8;
        goto L6
    }
}
