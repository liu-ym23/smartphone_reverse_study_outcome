package o47;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.ManifestUtils;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.j;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Keva f521975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Keva f521976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Gson f521977c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f521978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f521979e = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f521980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f521981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JsonObject f521982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o47.a f521983d;

        public a(String r100, Uri r101, JsonObject r102, o47.a r103) {
            this.f521980a = r100;
            this.f521981b = r101;
            this.f521982c = r102;
            this.f521983d = r103;
        }

        public final void a() {
            String r100 = this.f521980a;
            Uri r101 = this.f521981b;
            JsonObject r102 = this.f521982c;
            o47.a r103 = this.f521983d;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L41
            boolean r105 = true;
            if (r100 != null) goto L6;
        L9:
            boolean r110 = true;
        L10:
            if (r110 == false) goto L12;
            return;
        L12:
            String r111 = j.g(r101, null);     // Catch: Throwable -> L41
            if (r111 != null) goto L15;
            return;
        L15:
            if (r102 != null) goto L19;
            r102 = ManifestUtils.c(r100);     // Catch: Throwable -> L41
            if (r102 != null) goto L19;
            return;
        L19:
            String r112 = r102.get("version").getAsString();     // Catch: Throwable -> L41
            if (r112 != null) goto L22;
            return;
        L22:
            Keva r113 = f.d(r111);     // Catch: Throwable -> L41
            if (r113 == null) goto L36;
            o47.a r114 = f.m(r111, r113, null);     // Catch: Throwable -> L41
            if (r114 != null) goto L27;
            r114 = r103;
        L27:
            if (r114 == null) goto L36;
            o47.a.C7013a r115 = r114.a();     // Catch: Throwable -> L41
            if (r115 == null) goto L36;
            String r116 = r115.e();     // Catch: Throwable -> L41
            if (r116 == null) goto L36;
            if (Intrinsics.areEqual(r116, r112) == false) goto L35;
            Intrinsics.checkNotNullParameter(r101, "uri");     // Catch: Throwable -> L41
            f.g(r101, r103, false);     // Catch: Throwable -> L41
            r105 = false;
            goto L36
        L35:
            f.n(r111);     // Catch: Throwable -> L41
        L36:
            if (r105 == false) goto L38;
            com.bytedance.pia.core.utils.d.l("[Cache] Validate Cache Finish. (URL: " + r101 + " , isUpdate: " + f.p(r101, r100, r102, null) + ')', null, 14);     // Catch: Throwable -> L41
        L39:
            Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
        L43:
            Uri r107 = this.f521981b;
            Throwable r108 = Result.m9452exceptionOrNullimpl(r106);
            if (r108 == null) goto L49;
            com.bytedance.pia.core.utils.d.f("[Cache] Validate Cache Exception. (URL: " + r107 + " , Error: " + r108 + ')', null, null, 14);
            return;
        L49:
            return;
        L38:
            com.bytedance.pia.core.utils.d.l("[Cache] No Need to validate Cache Finish. (URL: " + r101 + ')', null, 14);     // Catch: Throwable -> L41
            goto L39
        L6:
            if (r100.length() == 0) goto L9;
            r110 = false;
        L41:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L43
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f521977c = GsonUtils.b();
        f521979e = new AtomicBoolean(false);
    }

    @JvmStatic
    public static final void e() {
        Lazy<Settings> r100 = Settings.f266286f;
        if (Settings.a.a().l() == true) goto L6;
        return;
    L6:
        if (f521979e.compareAndSet(false, true) == false) goto L9;
        f521975a = Keva.getRepo("pia_cache_index_repo");
        f521976b = Keva.getRepo("pia_cache_content_repo");
        com.bytedance.pia.core.utils.d.l("[Cache]: Finish Init PIA Cache Pool.", null, 14);
        return;
    }

    @JvmStatic
    public static final Keva c(Uri r100) {
        Lazy<Settings> r101 = Settings.f266286f;
        if (Settings.a.a().l() == true) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        String r102 = j.g(r100, null);
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L17;
        return null;
    L17:
        return d(r102);
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
        goto L14
    }

    @JvmStatic
    public static final Keva d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Lazy<Settings> r101 = Settings.f266286f;
        if (Settings.a.a().l() == true) goto L6;
        return null;
    L6:
        if (f521979e.get() == true) goto L8;
        return null;
    L8:
        Keva r102 = f521975a;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r102 = null;
    L12:
        if (r102.contains(r100) == false) goto L23;
        Keva r103 = f521975a;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r103 = null;
    L16:
        String r104 = r103.getString(r100, "");
        if (r104.length() <= 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L23;
        return Keva.getRepo(r104);
    L19:
        r105 = false;
    L23:
        return null;
    }

    @JvmStatic
    public static final o47.a.C7013a i(JsonObject r100) {
        if (r100 != null) goto L19;
        return null;
    L19:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl((o47.a.C7013a) GsonUtils.b().fromJson(r100.getAsJsonObject("cache").toString(), o47.a.C7013a.class));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        o47.a.C7013a r103 = (o47.a.C7013a) r102;
        if (r103 != null) goto L16;
        return null;
    L16:
        if (TextUtils.isEmpty(r103.e()) == false) goto L18;
        return null;
    L18:
        return r103;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @JvmStatic
    public static final d j(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        Lazy<Settings> r100 = Settings.f266286f;
        if (Settings.a.a().l() == true) goto L6;
        return null;
    L6:
        if (f521979e.get() == true) goto L9;
        return null;
    L9:
        if (f521978d != 0) goto L11;
    L12:
        ThreadUtil.a().postDelayed(c.f521969a, 5000);
    L13:
        String r101 = j.g(r110, null);
        if (r101 != null) goto L16;
        return null;
    L16:
        Keva r102 = d(r101);
        if (r102 == null) goto L58;
        Keva r103 = f521975a;
        if (r103 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r103 = null;
    L21:
        String[] r104 = r103.getStringArray(r101.concat("_extraVary"), null);
        if (r104 == null) goto L24;
        List r105 = ArraysKt.toList(r104);
    L25:
        List r106 = r105;
        boolean r107 = true;
        if (r106 != null) goto L28;
    L31:
        boolean r108 = true;
    L32:
        if (r108 == true) goto L43;
        String r109 = j.g(r110, r105);
        if (r109 != null) goto L36;
    L39:
        if (r107 == true) goto L43;
        if (h(r109, r102) == false) goto L43;
        String r111 = GsonProtectorUtils.toJson(GsonUtils.b(), r105);
    L44:
        d r112 = m(r109, r102, r111);
        if (r112 == null) goto L51;
        if (b.a(r112) == false) goto L51;
        com.bytedance.pia.core.utils.d.l("[Cache][Query] Using cacheKey with extra, key = ".concat(r109), null, 14);
    L53:
        if (r112 == null) goto L58;
        if (b.a(r112) == false) goto L58;
        com.bytedance.pia.core.utils.d.l("[Cache][Query] Find Matched PIA Cache. (URL = " + r110 + ", CacheConfig = " + r112.f521972c + ')', null, 14);
        return r112;
    L51:
        if (Intrinsics.areEqual(r109, r101) == true) goto L53;
        r112 = m(r101, r102, null);
        com.bytedance.pia.core.utils.d.l("[Cache][Query] Using cacheKey without extra, key = ".concat(r101), null, 14);
        goto L53
    L36:
        if (r109.length() == 0) goto L39;
        r107 = false;
    L43:
        r109 = r101;
        r111 = null;
        goto L44
    L28:
        if (r106.isEmpty() == true) goto L31;
        r108 = false;
        goto L32
    L24:
        r105 = null;
    L58:
        com.bytedance.pia.core.utils.d.l("[Cache][Query] Find No Matched PIA Cache. (URL = " + r110 + ')', null, 14);
        return null;
    L11:
        if ((System.currentTimeMillis() - f521978d) <= 60000) goto L13;
        goto L12
    }

    @JvmStatic
    public static final String k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "normalizeUrl");
        Lazy<Settings> r101 = Settings.f266286f;
        if (Settings.a.a().l() == true) goto L6;
        return null;
    L6:
        if (f521979e.get() == true) goto L8;
        return null;
    L8:
        Keva r102 = f521976b;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r102 = null;
    L12:
        if (r102.contains(r100) == true) goto L14;
        return null;
    L14:
        Keva r103 = f521976b;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r103 = null;
    L17:
        String r104 = r103.getString(r100, "");
        if (r104 != null) goto L20;
    L23:
        boolean r105 = true;
    L24:
        if (r105 == false) goto L26;
        return null;
    L26:
        return r104;
    L20:
        if (r104.length() == 0) goto L23;
        r105 = false;
        goto L24
    }

    public static void n(String r100) {
        com.bytedance.pia.core.utils.d.l("[Cache] Remove ALL Cache. (URL: " + r100 + ')', null, 14);
        Keva r101 = d(r100);
        if (r101 == null) goto L9;
        Map<String, ?> r102 = r101.getAll();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
        Iterator<Map.Entry<String, ?>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        b(r103.next().getKey(), r101);
        goto L6
    L8:
        r101.clear();
    L9:
        o(r100);
    }

    public static void o(String r100) {
        Keva r101 = f521975a;
        Keva r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r101 = null;
    L5:
        r101.erase(r100);
        Keva r103 = f521975a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
    L9:
        r102.erase(r100.concat("_extraVary"));
        return;
    L8:
        r102 = r103;
        goto L9
    }

    @JvmStatic
    public static final void a(Uri r100, String r101) {
        Lazy<Settings> r102 = Settings.f266286f;
        if (Settings.a.a().l() == true) goto L6;
        return;
    L6:
        if (f521979e.get() == true) goto L8;
        return;
    L8:
        if (r100 != null) goto L10;
        return;
    L10:
        if (r101 != null) goto L12;
        return;
    L12:
        Keva r103 = c(r100);
        if (r103 == null) goto L16;
        b(r101, r103);
        return;
    }

    @JvmStatic
    public static final boolean b(String r100, Keva r101) {
        Intrinsics.checkNotNullParameter(r100, "normalizeUrl");
        Intrinsics.checkNotNullParameter(r101, "configRepo");
        Lazy<Settings> r102 = Settings.f266286f;
        if (Settings.a.a().l() == true) goto L6;
        return false;
    L6:
        if (f521979e.get() == true) goto L9;
        return false;
    L9:
        if (h(r100, r101) == false) goto L18;
        r101.erase(r100);
        Keva r103 = f521976b;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r103 = null;
    L13:
        r103.erase(r100);
        Keva r104 = f521976b;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r104 = null;
    L16:
        r104.erase(r100 + "_headers");
        StringBuilder r105 = new StringBuilder("[Cache] Delete Cache Success. URL = ");
        r105.append(r100);
        com.bytedance.pia.core.utils.d.l(r105.toString(), null, 14);
        return true;
    L18:
        return false;
    }

    public static void f(String r100, List r101) {
        Keva r102 = f521975a;
        Keva r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r102 = null;
    L5:
        r102.storeString(r100, UUID.randomUUID().toString());
        if (r101 == null) goto L16;
        Keva r104 = f521975a;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
    L11:
        String r105 = r100.concat("_extraVary");
        Object[] r106 = r101.toArray(new String[0]);
        if (r106 == null) goto L15;
        r103.storeStringArray(r105, (String[]) r106);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L10:
        r103 = r104;
        goto L11
    }

    public static boolean h(String r100, Keva r101) {
        if (r101.contains(r100) == false) goto L11;
        Keva r102 = f521976b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r102 = null;
    L8:
        if (r102.contains(r100) == false) goto L13;
        return true;
    L13:
        return false;
    L11:
        return false;
    }

    @JvmStatic
    public static final o47.a.C7013a l(String r100, Keva r101) {
        Intrinsics.checkNotNullParameter(r100, "normalizeUrl");
        Lazy<Settings> r102 = Settings.f266286f;
        Object r103 = null;
        if (Settings.a.a().l() == true) goto L6;
        return null;
    L6:
        if (f521979e.get() == true) goto L8;
        return null;
    L8:
        Keva r104 = f521976b;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r104 = null;
    L12:
        if (r104.contains(r100) == true) goto L15;
        return null;
    L15:
        if (r101 != null) goto L17;
        Keva r105 = f521976b;
        if (r105 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r105 = null;
    L39:
        String r106 = r105.getString(r100 + "_headers", "");
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L52
        JsonElement r108 = GsonUtils.f266372c.parse(r106);     // Catch: Throwable -> L52
        if ((r108 instanceof JsonObject) == false) goto L43;
        JsonObject r109 = (JsonObject) r108;     // Catch: Throwable -> L52
    L44:
        if (r109 == null) goto L47;
        r103 = f521977c.fromJson(r109, o47.a.C7013a.class);     // Catch: Throwable -> L52
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L52
        Object r110 = r103;
    L57:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L50
    L35:
        r103 = r110;
    L56:
        return (o47.a.C7013a) r103;
    L50:
        Throwable th10 = th;
        r103 = r110;
    L54:
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th10));
        goto L56
    L47:
        r110 = null;
        goto L57
    L43:
        r109 = null;
    L52:
        th = move-exception;
        th10 = th;
        goto L54
    L17:
        if (r101.contains(r100) == true) goto L19;
        return null;
    L19:
        String r112 = r101.getString(r100, "");
        if (r112 != null) goto L22;
    L25:
        boolean r113 = true;
    L26:
        if (r113 == false) goto L61;
        return null;
    L61:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L30
        r110 = Result.m9449constructorimpl((o47.a.C7013a) f521977c.fromJson(r112, o47.a.C7013a.class));     // Catch: Throwable -> L30
    L33:
        if (Result.m9455isFailureimpl(r110) == false) goto L35;
    L30:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L22:
        if (r112.length() == 0) goto L25;
        r113 = false;
        goto L26
    }

    public static void g(Uri r100, o47.a r101, boolean r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        Keva r103 = c(r100);
        if (r103 != null) goto L7;
        return;
    L7:
        if (h(r101.b(), r103) == false) goto L11;
        r101.a().g(Boolean.valueOf(r102));
        q(r101.b(), r101.a().h(), r101.c(), r103);
        com.bytedance.pia.core.utils.d.l("[Cache] Finish Cache Mark. (URL: " + r101.b() + ", CacheConfig: " + r101.a() + ')', null, 14);
        return;
    }

    @JvmStatic
    public static final d m(String r100, Keva r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "normalizeUrl");
        Intrinsics.checkNotNullParameter(r101, "configRepo");
        Lazy<Settings> r103 = Settings.f266286f;
        if (Settings.a.a().l() == true) goto L6;
        return null;
    L6:
        if (f521979e.get() == true) goto L9;
        return null;
    L9:
        if (h(r100, r101) == true) goto L11;
        return null;
    L11:
        o47.a.C7013a r104 = l(r100, r101);
        if (r104 != null) goto L14;
        return null;
    L14:
        String r105 = k(r100);
        if (r105 != null) goto L18;
        return null;
    L18:
        return new d(r100, r105, r104, r102);
    }

    @JvmStatic
    public static final boolean p(Uri r100, String r101, JsonObject r110, List<String> r111) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "content");
        Lazy<Settings> r102 = Settings.f266286f;
        boolean r103 = false;
        if (Settings.a.a().l() == true) goto L6;
        return false;
    L6:
        if (f521979e.get() == true) goto L8;
        return false;
    L8:
        o47.a.C7013a r112 = i(r110);
        Keva r104 = null;
        if (r112 != null) goto L16;
        JsonObject r113 = ManifestUtils.c(r101);
        if (r113 != null) goto L13;
        r112 = null;
    L14:
        if (r112 != null) goto L16;
        return false;
    L13:
        r112 = i(r113);
    L16:
        Number r105 = r112.c();
        if (r105 == null) goto L19;
        long r106 = r105.longValue();
    L20:
        r112.f(Long.valueOf((r106 * ((long) 1000)) + System.currentTimeMillis()));
        r112.g(Boolean.FALSE);
        String r107 = j.g(r100, null);
        if (r107 == null) goto L69;
        String r108 = j.g(r100, r111);
        if (r108 == null) goto L69;
        Keva r109 = f521975a;
        if (r109 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r109 = null;
    L30:
        if (r109.contains(r107) == true) goto L32;
        f(r107, r111);
    L63:
        Keva r114 = d(r107);
        if (r114 == null) goto L69;
        if (h(r108, r114) == false) goto L68;
        b(r108, r114);
        r103 = true;
    L68:
        q(r108, r112.h(), r101, r114);
        goto L69
    L32:
        if (r111 == null) goto L63;
        Keva r115 = f521975a;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r115 = null;
    L37:
        if (r115.contains(r107.concat("_extraVary")) == false) goto L54;
        Keva r116 = f521975a;
        if (r116 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r116 = null;
    L41:
        String[] r117 = r116.getStringArray(r107.concat("_extraVary"), null);
        if (r117 == null) goto L53;
        List r118 = ArraysKt.toList(r117);
        int r119 = com.bytedance.pia.core.utils.b.f266389a;
        Intrinsics.checkNotNullParameter(r111, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r118, "second");
        if (r111.isEmpty() == false) goto L49;
        if (r118.isEmpty() == false) goto L49;
        boolean r120 = true;
    L52:
        if (r120 == true) goto L63;
    L49:
        if (r111.size() == r118.size()) goto L51;
        r120 = false;
        goto L52
    L51:
        r120 = Intrinsics.areEqual(CollectionsKt.sorted(r111), CollectionsKt.sorted(r118));
    L53:
        n(r107);
        f(r107, r111);
        goto L63
    L54:
        Keva r121 = f521975a;
        if (r121 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
    L58:
        String r122 = r107.concat("_extraVary");
        Object[] r123 = r111.toArray(new String[0]);
        if (r123 == null) goto L62;
        r104.storeStringArray(r122, (String[]) r123);
        goto L63
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L57:
        r104 = r121;
    L69:
        return r103;
    L19:
        r106 = 600;
        goto L20
    }

    public static void q(String r100, JsonObject r101, String r102, Keva r103) {
        Keva r104 = f521976b;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        r104 = null;
    L5:
        monitor-enter(r104);
        r103.storeString(r100, r101.toString());     // Catch: Throwable -> L15
        Keva r105 = f521976b;     // Catch: Throwable -> L15
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");     // Catch: Throwable -> L15
        r105 = null;
    L9:
        r105.storeString(r100 + "_headers", r101.toString());     // Catch: Throwable -> L15
        Keva r106 = f521976b;     // Catch: Throwable -> L15
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentRepo");     // Catch: Throwable -> L15
        r106 = null;
    L12:
        r106.storeString(r100, r102);     // Catch: Throwable -> L15
        com.bytedance.pia.core.utils.d.l("[Cache] Save Cache Success. (URL = " + r100 + ", CacheConfig: " + r101 + ')', null, 14);     // Catch: Throwable -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r104);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void update(Uri r100, String r101, JsonObject r102, o47.a r103) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Lazy<Settings> r104 = Settings.f266286f;
        if (Settings.a.a().l() == true) goto L6;
        return;
    L6:
        if (f521979e.get() == true) goto L8;
        return;
    L8:
        com.bytedance.pia.core.utils.d.l("[Cache] Begin to Validate Cache. (URL: " + r100 + ')', null, 14);
        ThreadUtil.c(new a(r101, r100, r102, r103));
    }
}
