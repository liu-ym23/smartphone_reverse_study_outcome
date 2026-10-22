package yo6;

import android.net.Uri;
import com.bytedance.locallife.common.utils.f;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Pair<String, String>> f568668a = null;

    /* JADX INFO: renamed from: yo6.a$a, reason: collision with other inner class name */
    public static final class C8366a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f568669a;

        public C8366a(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "innerMap");
            this.f568669a = r100;
        }

        @Override // yo6.a.b
        public final String get(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f568669a.get(r100);
        }
    }

    public interface b {
        String get(String r100);
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f568670a;

        public c(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            this.f568670a = r100;
        }

        @Override // yo6.a.b
        public final String get(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return UriProtector.getQueryParameter(this.f568670a, r100);
        }
    }

    static {
        f568668a = CollectionsKt.listOf(TuplesKt.to(UniContext.KEY_OF_BIZ_CODE, "Life-Biz-Code"));
    }

    public static Map a(b r100, Map r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<T> r103 = f568668a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Pair r104 = (Pair) r103.next();
        Object r105 = r104.getSecond();
        String r106 = r100.get((String) r104.getFirst());
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        r102.put(r105, r106);
        goto L4
    L9:
        r102.putAll(r101);
        String r107 = r100.get("header_params");
        HashMap r108 = null;
        Object r109 = null;
        if (r107 != null) goto L22;
    L20:
        b(r102, r108);
        return r102;
    L22:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L13
        Object r111 = Result.m9449constructorimpl(f.g(new JSONObject(r107)));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r111) == true) goto L19;
        r109 = r111;
    L19:
        r108 = (HashMap) r109;
    L13:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public static void b(Map r100, Map r101) {
        if (r101 == null) goto L13;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.entrySet().iterator();
    L5:
        if (r103.hasNext() == false) goto L9;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (StringsKt.startsWith$default((String) r104.getKey(), "RPC-PERSIST-LANE-C", false, 2, null) == false) goto L5;
        r102.put(r104.getKey(), r104.getValue());
        goto L5
    L9:
        Iterator r105 = r102.entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L20;
        Map.Entry r106 = (Map.Entry) r105.next();
        r100.put(r106.getKey(), r106.getValue());
        goto L11
    L20:
        return;
    }
}
