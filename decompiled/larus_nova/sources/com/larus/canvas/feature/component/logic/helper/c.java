package com.larus.canvas.feature.component.logic.helper;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f323369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f323370b = null;

    public c() {
    }

    static {
        f323369a = new c();
        f323370b = new Gson();
    }

    public static String a(String r100) {
        Uri r101 = b(r100);
        if (r101 != null) goto L6;
        return r100;
    L6:
        return c(r101, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method", "in_app_push"), TuplesKt.to("current_page", "image_generate_canvas")})).toString();
    }

    public static Uri b(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        return (Uri) r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static String d(Uri r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r100, "target_url"));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static Uri c(Uri r100, Map r101) {
        Uri.Builder r102 = r100.buildUpon().clearQuery();
        Iterator<T> r103 = UriProtector.getQueryParameterNames(r100).iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        String r104 = (String) r103.next();
        if (r101.containsKey(r104) == true) goto L4;
        Iterator<T> r105 = UriProtector.getQueryParameters(r100, r104).iterator();
    L10:
        if (r105.hasNext() == false) goto L4;
        r102.appendQueryParameter(r104, (String) r105.next());
        goto L10
    L12:
        Iterator r106 = r101.entrySet().iterator();
    L14:
        if (r106.hasNext() == false) goto L17;
        Map.Entry r107 = (Map.Entry) r106.next();
        r102.appendQueryParameter((String) r107.getKey(), (String) r107.getValue());
        goto L14
    L17:
        return r102.build();
    }
}
