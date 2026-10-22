package com.bytedance.locallife.poi.media;

import com.bytedance.locallife.poi.media.entity.PoiMediaStyle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import iy6.g;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f262661a = null;

    static {
        f262661a = new a();
    }

    public a() {
    }

    public static boolean b(g r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.e() != PoiMediaStyle.POI_MEDIA_STYLE_PHOTOS.getStyle()) goto L6;
        return true;
    }

    public static void d(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        int r101 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("poi_player_err", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("error", r100.getMessage()), TuplesKt.to("error_type", "data")}));
    }

    public static void a(JsonObject r100, Map r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r100 != null) goto L18;
        return;
    L18:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Iterator<T> r104 = r100.keySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r104.hasNext() == false) goto L9;
        String r105 = (String) r104.next();     // Catch: Throwable -> L11
        JsonElement r106 = r100.get(r105);     // Catch: Throwable -> L11
        c(f262661a, r105, r106, r101);     // Catch: Throwable -> L11
        goto L7
    L9:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L21;
        if (r102 == null) goto L22;
        r102.invoke(r108);
        return;
    L22:
        return;
    L21:
        return;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(a r100, String r101, JsonElement r102, Map r103) {
        r100.getClass();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        if ((r102 instanceof JsonObject) == false) goto L7;
        a((JsonObject) r102, r103, null);     // Catch: Throwable -> L17
    L15:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Result.m9452exceptionOrNullimpl(r105);
        return;
    L7:
        if ((r102 instanceof JsonArray) == false) goto L13;
        Iterator r106 = ((Iterable) r102).iterator();     // Catch: Throwable -> L17
    L10:
        if (r106.hasNext() == false) goto L15;
        c(r100, r101, (JsonElement) r106.next(), r103);     // Catch: Throwable -> L17
        goto L10
    L13:
        if ((r102 instanceof JsonPrimitive) == false) goto L15;
        r103.put(r101, ((JsonPrimitive) r102).getAsString());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
