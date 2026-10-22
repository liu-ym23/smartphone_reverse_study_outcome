package com.bytedance.pia.core.setting;

import android.net.Uri;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.PiaAppInfo;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.utils.DefaultResourceLoader;
import com.bytedance.pia.core.utils.j;
import com.facebook.keyframes.model.KFImage;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f266303a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Keva f266304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PiaAppInfo f266305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f266306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Uri f266307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f266308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f266309g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicBoolean f266310h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f266311i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<String> f266312j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f266313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ArrayList<String> f266314l = null;

    public g() {
    }

    static {
        f266303a = new g();
        f266309g = new AtomicBoolean(false);
        f266310h = new AtomicBoolean(false);
        f266311i = true;
        f266312j = new LinkedHashSet();
        f266314l = new ArrayList();
    }

    @JvmStatic
    public static final String b() {
        if (f266305c != null) goto L5;
        return "37913fa91838dc5ccb399f24439d11c0";
    L5:
        f266303a.getClass();
        PiaAppInfo r100 = f266305c;
        if (r100 != null) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        String r101 = r100.f266141f;
        if (r101 == null) goto L11;
    L13:
        if (Intrinsics.areEqual("local_test", r101) == false) goto L15;
    L16:
        return "aac7f74029c1c77d9beff78823e97382";
    L15:
        if (Intrinsics.areEqual(EffectConstants.CHANNEL_TEST, r101) == true) goto L16;
        return "37913fa91838dc5ccb399f24439d11c0";
    L11:
        r101 = "";
        goto L13
    }

    public static void e() {
        if (f266305c != null) goto L6;
        return;
    L6:
        if (f266309g.compareAndSet(false, true) == false) goto L75;
        PiaAppInfo r100 = f266305c;
        if (r100 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r100 = null;
    L12:
        if (r100.f266145j == false) goto L14;
    L23:
        PiaAppInfo r101 = f266305c;
        if (r101 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r101 = null;
    L26:
        boolean r102 = r101.f266145j;
        Uri r103 = f266307e;
        if (r103 == null) goto L30;
    L63:
        if (r103 == null) goto L77;
        l47.b<i47.c> r104 = c47.c.a.f22408d;
        if (r104 == null) goto L68;
        i47.c r105 = r104.create();
    L69:
        if (r105 != null) goto L71;
        r105 = new DefaultResourceLoader(null);
    L71:
        com.bytedance.pia.core.utils.d.l("[PIASettings] start fetching settings, URL: " + r103, null, 14);
        r105.b(LoadFrom.Online, new d(r103), new e(), new f());
        return;
    L68:
        r105 = null;
        goto L69
    L77:
        return;
    L30:
        if (f266305c != null) goto L32;
    L62:
        r103 = null;
        goto L63
    L32:
        if (f266306d == null) goto L62;
        Uri.Builder r106 = new Uri.Builder();
        r106.scheme("https");
        String r107 = f266306d;
        if (r107 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("apiHost");
        r107 = null;
    L37:
        r106.authority(r107);
        r106.appendPath("common");
        r106.appendQueryParameter("app_id", "349653");
        PiaAppInfo r108 = f266305c;
        if (r108 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r108 = null;
    L40:
        r106.appendQueryParameter("device_id", r108.f266139d);
        PiaAppInfo r109 = f266305c;
        if (r109 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r109 = null;
    L43:
        r106.appendQueryParameter("user_id", r109.f266138c);
        PiaAppInfo r110 = f266305c;
        if (r110 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r110 = null;
    L46:
        r106.appendQueryParameter("channel", r110.f266141f);
        PiaAppInfo r111 = f266305c;
        if (r111 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r111 = null;
    L49:
        r106.appendQueryParameter("device_type", r111.f266142g);
        r106.appendQueryParameter("device_platform", "Android");
        PiaAppInfo r112 = f266305c;
        if (r112 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r112 = null;
    L52:
        r106.appendQueryParameter("os_version", r112.f266143h);
        PiaAppInfo r113 = f266305c;
        if (r113 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r113 = null;
    L55:
        r106.appendQueryParameter("host_app_id", String.valueOf(r113.f266136a));
        PiaAppInfo r114 = f266305c;
        if (r114 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r114 = null;
    L58:
        r106.appendQueryParameter("host_app_name", r114.f266140e);
        PiaAppInfo r115 = f266305c;
        if (r115 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r115 = null;
    L61:
        r106.appendQueryParameter("host_version", r115.f266144i);
        r106.appendQueryParameter("sdk_version", "2.0.0");
        r103 = r106.build();
        com.bytedance.pia.core.utils.d.l("PIA Settings Url: " + r103, null, 14);
        f266307e = r103;
        goto L63
    L14:
        if (f266310h.get() == false) goto L23;
        PiaAppInfo r116 = f266305c;
        if (r116 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r116 = null;
    L18:
        long r117 = r116.f266137b;
        if (r117 > 0) goto L21;
        return;
    L21:
        if ((System.currentTimeMillis() - f266308f) >= ((r117 * ((long) 60)) * ((long) 1000))) goto L23;
        return;
    }

    public static void c(JsonReader r100) {
        if (r100.peek() != JsonToken.BEGIN_OBJECT) goto L15;
        r100.beginObject();
        LinkedHashSet r101 = new LinkedHashSet();
    L6:
        if (r100.hasNext() == false) goto L14;
        String r102 = r100.nextName();
        if (StringsKt.startsWith$default(r102, "page/", false, 2, null) == false) goto L13;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        f266303a.getClass();     // Catch: Throwable -> L11
        d(r102, r100, r101);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    L13:
        r100.skipValue();
        goto L6
    L14:
        r100.endObject();
        Set<String> r105 = f266312j;
        r105.clear();
        r105.addAll(r101);
        return;
    L15:
        r100.skipValue();
    }

    public static final void a(g r100, InputStream r101) {
        r100.getClass();
        JsonReader r102 = new JsonReader(new InputStreamReader(r101));
        r102.beginObject();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(r102.nextName(), "data") == true) goto L8;
        r102.skipValue();     // Catch: Throwable -> L9
        goto L5
    L8:
        f266313k = "" + r102.hashCode() + f266303a.hashCode();     // Catch: Throwable -> L9
        c(r102);     // Catch: Throwable -> L9
        goto L5
    L12:
        r102.endObject();     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r102, null);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    public static void d(String r110, JsonReader r111, Set r112) {
        if (r111.peek() == JsonToken.BEGIN_OBJECT) goto L5;
        r111.skipValue();
        return;
    L5:
        r111.beginObject();
    L7:
        if (r111.hasNext() == false) goto L88;
        if (Intrinsics.areEqual(r111.nextName(), "val") == true) goto L10;
        r111.skipValue();
        goto L7
    L10:
        boolean r100 = false;
        Keva r101 = null;
        if (StringsKt.startsWith$default(r110, "page/", false, 2, null) == true) goto L13;
        r111.skipValue();
        goto L7
    L13:
        if (r111.peek() == JsonToken.BEGIN_OBJECT) goto L14;
        r111.skipValue();
        goto L7
    L14:
        r111.beginObject();
        JsonArray r102 = new JsonArray();
        String r103 = null;
        String r104 = null;
    L16:
        if (r111.hasNext() == false) goto L54;
        String r105 = r111.nextName();
        if (r105 == null) goto L53;
        int r106 = r105.hashCode();
        if (r106 != (-290659267)) goto L22;
        if (r105.equals(KFImage.FEATURES_JSON_FIELD) == false) goto L53;
        if (r111.peek() == JsonToken.BEGIN_ARRAY) goto L44;
        r111.skipValue();
        goto L16
    L44:
        r111.beginArray();
    L46:
        if (r111.hasNext() == false) goto L51;
        if (r111.peek() == JsonToken.STRING) goto L49;
        r111.skipValue();
        goto L46
    L49:
        r102.add(r111.nextString());
        goto L46
    L51:
        r111.endArray();
        goto L16
    L22:
        if (r106 != 116079) goto L24;
        if (r105.equals("url") == false) goto L53;
        if (r111.peek() == JsonToken.STRING) goto L37;
        r111.skipValue();
        goto L16
    L37:
        r103 = r111.nextString();
        goto L16
    L24:
        if (r106 != 351608024) goto L53;
        if (r105.equals("version") == false) goto L53;
        if (r111.peek() == JsonToken.STRING) goto L31;
        r111.skipValue();
        goto L16
    L31:
        r104 = r111.nextString();
    L53:
        r111.skipValue();
        goto L16
    L54:
        r111.endObject();
        if (r103 != null) goto L57;
    L60:
        boolean r107 = true;
    L61:
        if (r107 == true) goto L7;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L65
        Object r109 = Result.m9449constructorimpl(j.g(UriProtector.parse(r103), null));     // Catch: Throwable -> L65
    L68:
        if (Result.m9455isFailureimpl(r109) == false) goto L70;
        r109 = null;
    L70:
        String r113 = (String) r109;
        if (r113 != null) goto L73;
    L74:
        r100 = true;
    L75:
        if (r100 == true) goto L7;
        JsonObject r114 = new JsonObject();
        String r115 = f266313k;
        if (r115 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("version");
        r115 = null;
    L80:
        r114.addProperty("version", r115);
        r114.addProperty("url", r103);
        r114.addProperty("manifestVersion", r104);
        r114.add(KFImage.FEATURES_JSON_FIELD, r102);
        Keva r116 = f266304b;
        if (r116 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("settings");
    L84:
        r101.storeString(r113, r114.toString());
        r112.add(r113);
        goto L7
    L83:
        r101 = r116;
        goto L84
    L73:
        if (r113.length() != 0) goto L75;
    L65:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L68
    L57:
        if (r103.length() == 0) goto L60;
        r107 = false;
        goto L61
    L88:
        r111.endObject();
    }
}
