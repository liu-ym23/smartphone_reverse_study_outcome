package com.bytedance.locallife.pdp;

import android.net.Uri;
import com.bytedance.locallife.pdp.settings.l0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.trade.goods.entity.PoiTradeSettingEntity;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f261012a = 0;

    static {
    }

    public static String a(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "originUri");
        Intrinsics.checkNotNullParameter(r101, "h5Url");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L20
        Uri r103 = UriProtector.parse(r101);     // Catch: Throwable -> L20
        PoiTradeSettingEntity r104 = l0.f261737a;     // Catch: Throwable -> L20
        if (r104 == null) goto L7;
        List<String> r105 = r104.O();     // Catch: Throwable -> L20
        if (r105 == null) goto L7;
    L8:
        Uri.Builder r106 = UriProtector.parse("aweme://webview/").buildUpon();     // Catch: Throwable -> L20
        Uri.Builder r107 = r103.buildUpon();     // Catch: Throwable -> L20
        Set<String> r108 = UriProtector.getQueryParameterNames(r100);     // Catch: Throwable -> L20
        if (r108 == null) goto L18;
        Iterator<T> r109 = r108.iterator();     // Catch: Throwable -> L20
    L12:
        if (r109.hasNext() == false) goto L18;
        String r110 = (String) r109.next();     // Catch: Throwable -> L20
        if (UriProtector.getQueryParameterNames(r103).contains(r110) == true) goto L12;
        if (r105.contains(r110) == false) goto L12;
        r107.appendQueryParameter(r110, UriProtector.getQueryParameter(r100, r110));     // Catch: Throwable -> L20
    L18:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L20
        Object r112 = Result.m9449constructorimpl(r106.appendQueryParameter("url", r107.build().toString()).toString());     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r112) == false) goto L26;
        r112 = "";
    L26:
        return (String) r112;
    L7:
        r105 = l0.f261739c;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }
}
