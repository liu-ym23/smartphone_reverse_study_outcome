package gz2;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.monitorV2.util.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f483363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f483364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<String> f483365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f483366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C6084a f483367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<C6084a> f483368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f483369g;

    /* JADX INFO: renamed from: gz2.a$a, reason: collision with other inner class name */
    public static final class C6084a implements Comparable<C6084a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f483370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f483371b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6084a) == true) goto L8;
            return false;
        L8:
            C6084a r101 = (C6084a) r100;
            if (this.f483370a == r101.f483370a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f483371b, r101.f483371b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f483370a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f483371b.hashCode();
        }

        public final String toString() {
            return "SubPerf(cost=" + this.f483370a + ", data=" + this.f483371b + ')';
        }

        @Override // java.lang.Comparable
        public final int compareTo(C6084a r100) {
            C6084a r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "other");
            return ((int) r101.f483370a) - ((int) this.f483370a);
        }

        public C6084a(long r100, k r101) {
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f483370a = r100;
            this.f483371b = r101;
        }
    }

    public abstract boolean a(k r100);

    public abstract void d(k r100);

    public abstract void e(long r100, JSONObject r101);

    public a() {
        this.f483363a = 10;
        this.f483364b = 3;
        this.f483365c = SetsKt.hashSetOf(new String[]{GXTemplateKey.GAIAX_JS, GXTemplateKey.GAIAX_CSS});
        this.f483366d = CollectionsKt.listOf(new String[]{"fetch", "x.request", "__prefetch"});
        this.f483368f = Collections.synchronizedList(new ArrayList());
        this.f483369g = new Object();
    }

    public final void c(C6084a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f483367e != null) goto L6;
        this.f483367e = r100;
        Unit r101 = Unit.INSTANCE;
    L6:
        if (this.f483368f.size() >= this.f483363a) goto L9;
        this.f483368f.add(r100);
        return;
    }

    public static JSONObject b(JSONObject r210, String r211) {
        Object r100 = "";
        Intrinsics.checkNotNullParameter(r211, "resType");
        if (r210 == null) goto L5;
        JSONObject r101 = r210.optJSONObject("res_info");
    L6:
        if (r101 != null) goto L9;
        r101 = new JSONObject();
    L9:
        if (r210 == null) goto L11;
        JSONObject r102 = r210.optJSONObject("res_load_perf");
    L12:
        if (r102 != null) goto L15;
        r102 = new JSONObject();
    L15:
        if (r210 == null) goto L17;
        JSONObject r103 = r210.optJSONObject("res_loader_info");
    L18:
        if (r103 != null) goto L20;
        r103 = new JSONObject();
    L20:
        JSONObject r110 = r103;
        JSONObject r111 = new JSONObject();
        r111.put("is_memory", r101.optBoolean("is_memory") ? 1 : 0);
        r111.put("is_preload", r101.optBoolean("is_preload") ? 1 : 0);
        r111.put("is_preloaded", r101.optBoolean("is_preloaded") ? 1 : 0);
        r111.put("res_from", r101.optString("res_from"));
        r111.put("res_size", r101.optLong("res_size"));
        if (Intrinsics.areEqual(r211, "res_template_dur") == false) goto L24;
        r111.put("res_src", r101.optString("res_src"));
    L51:
        r111.put(ChameleonOpenTracker.ParamKey.RES_VERSION, String.valueOf(r101.optLong(ChameleonOpenTracker.ParamKey.RES_VERSION)));
        JSONObject r104 = new JSONObject();
        r104.put("res_load_start", r102.optLong("res_load_start"));
        r104.put("res_load_finish", r102.optLong("res_load_finish"));
        JSONObject r105 = new JSONObject();
        r105.put("res_loader_name", r110.optString("res_loader_name"));
        JSONObject r106 = new JSONObject();
        r106.put("res_info", r111);
        r106.put("res_load_perf", r104);
        r106.put("res_loader_info", r105);
        return r106;
    L24:
        if (Intrinsics.areEqual(r211, "sub_res_dur") == false) goto L51;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L44
        String r108 = UriProtector.parse(r101.optString("res_src")).getPath();     // Catch: Throwable -> L44
        if (r108 != null) goto L28;
    L31:
        boolean r112 = true;
    L32:
        if (r112 == false) goto L34;
    L41:
        String r109 = "";
    L42:
        Object r113 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L44
    L47:
        if (Result.m9455isFailureimpl(r113) == true) goto L50;
        r100 = r113;
    L50:
        r111.put("res_src", (String) r100);
        goto L51
    L34:
        if (StringsKt.startsWith$default(r108, HTTP.URL_DEFAULT, false, 2, null) == false) goto L36;
        r108 = r108.subSequence(1, r108.length()).toString();     // Catch: Throwable -> L44
    L36:
        List r114 = StringsKt.split$default(r108, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);     // Catch: Throwable -> L44
        int r115 = r114.size();     // Catch: Throwable -> L44
        if (r115 != 1) goto L39;
        r109 = String.valueOf(ListProtector.get(r114, 0));     // Catch: Throwable -> L44
        goto L42
    L39:
        if (r115 <= 1) goto L41;
        r109 = ((String) ListProtector.get(r114, r115 - 2)) + '/' + ((String) ListProtector.get(r114, r115 - 1));     // Catch: Throwable -> L44
        goto L42
    L28:
        if (r108.length() == 0) goto L31;
        r112 = false;
    L44:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L17:
        r103 = null;
        goto L18
    L11:
        r102 = null;
        goto L12
    L5:
        r101 = null;
        goto L6
    }
}
