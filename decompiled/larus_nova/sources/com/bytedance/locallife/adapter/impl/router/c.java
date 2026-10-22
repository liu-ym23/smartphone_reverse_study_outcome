package com.bytedance.locallife.adapter.impl.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.locallife.adapter.impl.page.poi.LifePoiActivity;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.common.utils.j;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes20.dex */
public final class c extends fo6.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f256497c;

    public static final class a {
    }

    static {
    }

    public c(xu6.e r100) {
        super(r100);
        this.f256497c = LazyKt.lazy(PoiH5Router$interceptNativePoiJump$2.INSTANCE);
    }

    @Override // fo6.d
    public final boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (((Number) this.f256497c.getValue()).intValue() == 1) goto L15;
        String r101 = UriProtector.getQueryParameter(r100, "url");
        if (r101 != null) goto L7;
        r101 = UriProtector.getQueryParameter(r100, "surl");
    L7:
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L16;
        return true;
    L16:
        return false;
    L9:
        if (StringsKt.contains$default(r101, "life.scsjsd.com/life-service/common-h5/poi", false, 2, null) != true) goto L11;
        r102 = true;
        goto L12
    L15:
        return false;
    }

    @Override // fo6.a, fo6.d
    public final void b(Context r110, Uri r111, Intent r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r112, "intent");
        super.b(r110, r111, r112);
        r112.setClass(r110, LifePoiActivity.class);
        Uri.Builder r100 = r111.buildUpon();
        Iterator r101 = ((ArrayList) dn6.a.a(r111)).iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        Pair r102 = (Pair) r101.next();
        if (Intrinsics.areEqual(r102.getFirst(), "url") == true) goto L4;
        if (Intrinsics.areEqual(r102.getFirst(), "surl") == true) goto L4;
        if (TextUtils.isEmpty((CharSequence) r102.getFirst()) == true) goto L4;
        if (TextUtils.isEmpty((CharSequence) r102.getSecond()) == true) goto L4;
        r112.putExtra((String) r102.getFirst(), (String) r102.getSecond());
        goto L4
    L15:
        int r103 = j.f257151a;
        if (j.b(UriProtector.getQueryParameter(r111, "id")) == false) goto L20;
        String r104 = UriProtector.getQueryParameter(r111, "poi_id");
        if (r104 == null) goto L20;
        r112.putExtra("id", r104);
        r100.appendQueryParameter("id", r104);
    L20:
        String r105 = UriProtector.getQueryParameter(r111, "author_id");
        if (r105 != null) goto L23;
    L32:
        String r106 = UriProtector.getQueryParameter(r111, "forward_params");
        String r107 = UriProtector.getQueryParameter(r111, "request_params");
        if (j.b(r106) == true) goto L35;
    L117:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L70
        String r109 = UriProtector.getQueryParameter(r111, "extra_session_params");     // Catch: Throwable -> L70
        if (r109 == null) goto L67;
        Iterator r113 = ((HashMap) com.bytedance.locallife.common.utils.f.e(com.bytedance.locallife.common.utils.f.c(r109))).entrySet().iterator();     // Catch: Throwable -> L70
    L41:
        if (r113.hasNext() == false) goto L66;
        Map.Entry r114 = (Map.Entry) r113.next();     // Catch: Throwable -> L70
        Object r115 = r114.getValue();     // Catch: Throwable -> L70
        if ((r115 instanceof Integer) == true) goto L44;
        if ((r115 instanceof Short) == true) goto L47;
        if ((r115 instanceof Long) == true) goto L50;
        if ((r115 instanceof Byte) == true) goto L53;
        if ((r115 instanceof Float) == true) goto L56;
        if ((r115 instanceof Double) == true) goto L59;
        if ((r115 instanceof Character) == true) goto L62;
        if ((r115 instanceof String) == false) goto L41;
        r112.putExtra((String) r114.getKey(), (String) r115);     // Catch: Throwable -> L70
        goto L41
    L62:
        r112.putExtra((String) r114.getKey(), ((Character) r115).charValue());     // Catch: Throwable -> L70
        goto L41
    L59:
        r112.putExtra((String) r114.getKey(), ((Number) r115).doubleValue());     // Catch: Throwable -> L70
        goto L41
    L56:
        r112.putExtra((String) r114.getKey(), ((Number) r115).floatValue());     // Catch: Throwable -> L70
        goto L41
    L53:
        r112.putExtra((String) r114.getKey(), ((Number) r115).byteValue());     // Catch: Throwable -> L70
        goto L41
    L50:
        r112.putExtra((String) r114.getKey(), ((Number) r115).longValue());     // Catch: Throwable -> L70
        goto L41
    L47:
        r112.putExtra((String) r114.getKey(), ((Number) r115).shortValue());     // Catch: Throwable -> L70
        goto L41
    L44:
        r112.putExtra((String) r114.getKey(), ((Number) r115).intValue());     // Catch: Throwable -> L70
        goto L41
    L66:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L70
    L68:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L70
    L72:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L121;
        HostServiceUtilsKt.w0().ensureNotReachHere(r118, "extraSessionParams");
    L121:
    L83:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Object r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L85:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L123;
        HostServiceUtilsKt.w0().ensureNotReachHere(r121, "ad_logextra->log_extra");
    L123:
    L96:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        Object r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L98:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L119;
        HostServiceUtilsKt.w0().ensureNotReachHere(r124, "ad_creativeid->cid");
    L119:
    L109:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        Object r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L111:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 == null) goto L115;
        HostServiceUtilsKt.w0().ensureNotReachHere(r127, "ad_creativeid->cid");
    L115:
        r112.setData(r100.build());
        r110.startActivity(r112);
        return;
    L103:
        if (j.b(UriProtector.getQueryParameter(r111, "creative_id")) == false) goto L107;
        String r128 = UriProtector.getQueryParameter(r111, "ad_creativeid");     // Catch: Throwable -> L109
        if (r128 == null) goto L107;
        r112.putExtra("creative_id", r128);     // Catch: Throwable -> L109
    L107:
        r126 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L109
        goto L111
    L90:
        if (j.b(UriProtector.getQueryParameter(r111, "cid")) == false) goto L94;
        String r129 = UriProtector.getQueryParameter(r111, "ad_creativeid");     // Catch: Throwable -> L96
        if (r129 == null) goto L94;
        r112.putExtra("cid", r129);     // Catch: Throwable -> L96
    L94:
        r123 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L96
        goto L98
    L77:
        if (j.b(UriProtector.getQueryParameter(r111, "log_extra")) == false) goto L81;
        String r130 = UriProtector.getQueryParameter(r111, "ad_logextra");     // Catch: Throwable -> L83
        if (r130 == null) goto L81;
        r112.putExtra("log_extra", r130);     // Catch: Throwable -> L83
    L81:
        r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L83
        goto L85
    L67:
        r116 = null;
    L70:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L72
    L35:
        if (j.a(r107) == false) goto L117;
        r112.putExtra("forward_params", r107);
        goto L117
    L23:
        if (j.a(r105) == true) goto L32;
        String r132 = UriProtector.getQueryParameter(r111, "extra_session_params");
        if (r132 == null) goto L32;
        String r133 = com.bytedance.locallife.common.utils.f.c(r132).optString("author_id", "");
        if (r133 == null) goto L32;
        if (j.a(r133) == false) goto L32;
        r112.putExtra("author_id", r133);
        r100.appendQueryParameter("author_id", r133);
        goto L32
    }
}
