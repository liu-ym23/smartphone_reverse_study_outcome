package fi3;

import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s0 {
    public final Map<String, Object> a;
    public final ArrayList<Map<String, Object>> b;
    public final String c;
    public final Uri d;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u0001¨\u0006\u0006"}, d2 = {"fi3/s0$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends Map<String, Object>>> {
        public a() {
        }
    }

    public final String a() {
        Object r0 = this.a.get("biz_context");
        Object r2 = null;
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map r1 = (Map) r0;
        if (r1 == null) goto L8;
        Object r3 = r1.get("scene_type");
    L10:
        if ((r3 instanceof String) == false) goto L13;
        r2 = r3;
    L13:
        String r4 = (String) r2;
        if (r4 != null) goto L17;
        return "";
    L17:
        return r4;
    L8:
        r3 = null;
        goto L10
    }

    public s0(Uri r9) {
        Intrinsics.checkNotNullParameter(r9, "uri");
        this.d = r9;
        this.c = "pass_through";
        String r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L27
        HashMap r3 = new HashMap();     // Catch: Throwable -> L27
        Iterator r4 = UriProtector.getQueryParameterNames(r9).iterator();     // Catch: Throwable -> L27
    L5:
        if (r4.hasNext() == false) goto L25;
        String r5 = (String) r4.next();     // Catch: Throwable -> L27
        boolean r6 = false;
        if (r5 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == true) goto L5;
        String r8 = UriProtector.getQueryParameter(r9, r5);     // Catch: Throwable -> L27
        if (r8 != null) goto L17;
    L18:
        r6 = true;
    L20:
        if ((!r6) == true) goto L23;
        r8 = null;
    L23:
        if (r8 == null) goto L5;
        r3.put(r5, r8);     // Catch: Throwable -> L27
        goto L5
    L17:
        if (StringsKt.isBlank(r8) == false) goto L20;
    L9:
        if (StringsKt.isBlank(r5) == true) goto L12;
        r7 = false;
        goto L13
    L25:
        Object r10 = Result.constructor-impl(r3);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r10) == false) goto L32;
        r10 = null;
    L32:
        HashMap r11 = (HashMap) r10;
        if (r11 != null) goto L36;
        r11 = new HashMap();
    L36:
        this.a = r11;
        Object r12 = r11.get(this.c);
        if (r12 == null) goto L39;
        String r13 = r12.toString();
    L40:
        if (r13 == null) goto L51;
        Object r14 = r11.get(this.c);
        if (r14 == null) goto L45;
        r0 = r14.toString();
    L45:
        if ((!Intrinsics.areEqual(r0, "null")) == false) goto L51;
        int r1 = com.bytedance.android.ec.core.utils.t0.a;     // Catch: Exception -> L48
        List r15 = (List) com.bytedance.android.ec.core.utils.t0.a.a.fromJson(String.valueOf(r11.get(this.c)), new a().getType());     // Catch: Exception -> L48
    L50:
        ArrayList<Map<String, Object>> r16 = new ArrayList(r15);
    L52:
        this.b = r16;
        return;
    L48:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r15 = CollectionsKt.emptyList();
    L51:
        r16 = new ArrayList();
        goto L52
    L39:
        r13 = null;
    L27:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public static Map b(Object r1) {
        if (TypeIntrinsics.isMutableMap(r1) == false) goto L11;
        if (TypeIntrinsics.isMutableMap(r1) == true) goto L7;
        r1 = null;
    L7:
        Map r2 = (Map) r1;
        if (r2 == null) goto L20;
        return r2;
    L20:
        return new LinkedHashMap();
    L11:
        if ((r1 instanceof String) == false) goto L18;
        JSONObject r3 = z1.g((String) r1);
        if (r3 == null) goto L22;
        Map r4 = MapsKt.toMutableMap(z1.k(r3));
        if (r4 == null) goto L22;
        return r4;
    L22:
        return new LinkedHashMap();
    L18:
        return new LinkedHashMap();
    }
}
