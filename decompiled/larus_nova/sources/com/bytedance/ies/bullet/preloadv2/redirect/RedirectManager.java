package com.bytedance.ies.bullet.preloadv2.redirect;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.ResourceFrom2;
import com.bytedance.forest.utils.h;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.util.UriUtil;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m26.f;
import org.json.JSONObject;
import s26.d;

/* JADX INFO: loaded from: classes19.dex */
public final class RedirectManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f247717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f247718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f247719c = null;

    static {
        f247717a = true;
        f247719c = LazyKt.lazy(RedirectManager$mMap$2.INSTANCE);
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (f247717a == true) goto L6;
        f.c("RedirectManager disable");
        return null;
    L6:
        Lazy r101 = f247719c;
        String r102 = (String) ((LruCache) r101.getValue()).get(r100);
        int r103 = f.f511670a;
        f.c("RedirectManager getRedirectPath URL:" + r100 + ",redirectUrl:" + r102);
        boolean r104 = false;
        if (r102 != null) goto L10;
    L18:
        if (r104 == false) goto L20;
        f.c("RedirectManager file exit,url:" + r100);
        return r102;
    L20:
        f.c("RedirectManager file not exit,url:" + r100);
        ((LruCache) r101.getValue()).remove(r100);
        return null;
    L10:
        if (StringsKt.startsWith$default(r102, "http", false, 2, null) == false) goto L13;
    L16:
        r104 = true;
        goto L18
    L13:
        if (StringsKt.startsWith$default(r102, "file", false, 2, null) == true) goto L15;
    L17:
        StringsKt.startsWith$default(r102, UriUtil.LOCAL_ASSET_SCHEME, false, 2, null);
        goto L18
    L15:
        if (new PolarisFileWrapper(UriProtector.parse(r102).getPath()).exists() == false) goto L17;
        goto L16
    }

    public static String d(String r100) {
        return new Uri.Builder().scheme(UriUtil.LOCAL_ASSET_SCHEME).authority("").path(r100).build().toString();
    }

    public static String e(String r100) {
        if (StringsKt.contains$default(r100, "@", false, 2, null) == true) goto L7;
        return Uri.fromFile(new PolarisFileWrapper(r100)).toString();
    L7:
        return "file:///" + r100;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (f247717a == true) goto L6;
        f.c("RedirectManager disable");
        return;
    L6:
        if (r101 == null) goto L9;
        int r102 = f.f511670a;
        f.c("RedirectManager putRedirectPath URL:" + r100 + ",redirectUrl:" + r101);
        String r103 = (String) ((LruCache) f247719c.getValue()).put(r100, r101);
        return;
    }

    public static String f(String r100, ResourceFrom2 r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        int r103 = h.f244547a;     // Catch: Throwable -> L8
        if (h.a(UriProtector.parse(r100).getScheme()) == false) goto L6;
        return r100;
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (r101 != ResourceFrom2.BUILTIN) goto L14;
        return d(r100);
    L14:
        return e(r100);
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Deprecated(message = "use wrapRedirectPath(String, ResourceFrom2?)")
    public static String g(String r100, ResourceFrom r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        int r103 = h.f244547a;     // Catch: Throwable -> L8
        if (h.a(UriProtector.parse(r100).getScheme()) == false) goto L6;
        return r100;
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (r101 != ResourceFrom.BUILTIN) goto L14;
        return d(r100);
    L14:
        return e(r100);
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static String h(String r100, ResourceType r101) {
        Intrinsics.checkNotNullParameter(r100, "rawFilePath");
        if (r101 != ResourceType.ASSET) goto L6;
        return d(r100);
    L6:
        if (r101 == ResourceType.DISK) goto L11;
        return null;
    L11:
        return e(r100);
    }

    public static void c(String r100, String r101, String r110, boolean r111, long r112) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "resUrl");
        int r102 = f.f511670a;
        StringBuilder r103 = new StringBuilder();
        if (r111 == false) goto L5;
        String r104 = "命中";
    L6:
        r103.append(r104);
        r103.append("命中重定向缓存 ");
        r103.append(r101);
        r103.append(", ");
        r103.append(r110);
        f.c(r103.toString());
        d r105 = d.f540305c;
        r r106 = (r) d.f540305c.d(r100, r.class);
        if (r106 == null) goto L13;
        c1 r107 = new c1("bdx_redirect_fetch", null, null, null, null, 254);
        r107.f247792b = r101;
        JSONObject r108 = new JSONObject();
        r108.put("res_url", r101);
        if (r110 != null) goto L11;
        r110 = "null";
    L11:
        r108.put(ITiktokService.ResponseConstants.REDIRECT_URL, r110);
        r108.put(BaseHttpRequestInfo.KEY_HIT, r111 ? 1 : 0);
        r107.f247794d = r108;
        JSONObject r109 = new JSONObject();
        r109.put("duration", r112);
        r107.f247795e = r109;
        r106.S(r107);
        return;
    L13:
        return;
    L5:
        r104 = "错过";
        goto L6
    }
}
