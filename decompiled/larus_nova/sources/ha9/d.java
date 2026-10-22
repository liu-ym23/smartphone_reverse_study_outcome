package ha9;

import androidx.collection.SieveCacheKt;
import com.larus.flowsdk.common.experiment.FlowABValueType;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f484417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f484418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f484419c;

    public d(a r100) {
        f r101 = new f();
        g r102 = g.f484424a;
        Intrinsics.checkNotNullParameter(r100, "registry");
        Intrinsics.checkNotNullParameter(r101, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r102, "reporter");
        this.f484417a = r100;
        this.f484418b = r101;
        this.f484419c = r102;
    }

    public final Object a(String r100, final String r101, FlowABValueType r110, Object r111, final Function2<? super String, ? super ga9.f<?>, ? extends Object> r112) {
        a r102 = this.f484417a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "key");
        final ga9.f<?> r103 = r102.f484413c.get(r101);
        if (r103 != null) goto L9;
        this.f484419c.b(r101);
        e.f484420a.getClass();
        Object r104 = e.a(r111);
        if (r104 != null) goto L8;
        return r111;
    L8:
        return r104;
    L9:
        FlowABValueType r105 = r103.f480603c;
        if (r105 == r110) goto L16;
        this.f484419c.c(r101, r105);
        e.f484420a.getClass();
        Object r106 = e.a(r111);
        if (r106 != null) goto L15;
        return r111;
    L15:
        return r106;
    L16:
        f r113 = this.f484418b;
        Function0 r107 = new c(r112, r101, r103);
        r113.getClass();
        Intrinsics.checkNotNullParameter(r100, "namespace");
        Intrinsics.checkNotNullParameter(r103, "info");
        Intrinsics.checkNotNullParameter(r107, "loadValue");
        String r108 = r100 + '/' + r103.f480601a;
        if (r103.f480605e == true) goto L19;
    L21:
        Object r109 = r107.invoke();
        if (r109 != null) goto L24;
        Object r114 = r103.f480604d;
    L25:
        e r115 = e.f484420a;
        FlowABValueType r116 = r103.f480603c;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "type");
        int r117 = e.a.f484421a[r116.ordinal()];
        Object r118 = null;
        switch(r117) {
            case 1: goto L96;
            case 2: goto L79;
            case 3: goto L73;
            case 4: goto L61;
            case 5: goto L58;
            case 6: goto L44;
            case 7: goto L30;
            default: goto L28;
        };
    L28:
        throw new NoWhenBranchMatchedException();
    L30:
        if ((r114 instanceof JSONArray) == false) goto L33;
        r118 = new JSONArray(((JSONArray) r114).toString());
    L98:
        if (r118 != null) goto L103;
        if (r109 == null) goto L101;
        r113.f484422a.c(r103.f480601a, r103.f480603c);
    L101:
        e r119 = e.f484420a;
        T r120 = r103.f480604d;
        r119.getClass();
        r118 = e.a(r120);
    L103:
        if (r103.f480605e == false) goto L105;
        ConcurrentHashMap<String, Object> r121 = r113.f484423b;
        e.f484420a.getClass();
        r121.put(r108, e.a(r118));
    L105:
        e.f484420a.getClass();
        Object r122 = e.a(r118);
    L106:
        if (r122 != null) goto L109;
        return r111;
    L109:
        return r122;
    L33:
        if ((r114 instanceof String) == false) goto L98;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L36
        Object r124 = Result.m9449constructorimpl(new JSONArray((String) r114));     // Catch: Throwable -> L36
    L39:
        if (Result.m9455isFailureimpl(r124) == true) goto L42;
        r118 = r124;
    L42:
        r118 = (JSONArray) r118;
    L36:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L44:
        if ((r114 instanceof JSONObject) == false) goto L47;
        r118 = new JSONObject(((JSONObject) r114).toString());
        goto L98
    L47:
        if ((r114 instanceof String) == false) goto L98;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L50
        Object r127 = Result.m9449constructorimpl(new JSONObject((String) r114));     // Catch: Throwable -> L50
    L53:
        if (Result.m9455isFailureimpl(r127) == true) goto L56;
        r118 = r127;
    L56:
        r118 = (JSONObject) r118;
    L50:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L53
    L58:
        if ((r114 instanceof String) == false) goto L98;
        r118 = (String) r114;
        goto L98
    L61:
        if ((r114 instanceof Double) == false) goto L64;
        r118 = (Double) r114;
        goto L98
    L64:
        if ((r114 instanceof Float) == false) goto L67;
        r118 = Double.valueOf(((Number) r114).floatValue());
        goto L98
    L67:
        if ((r114 instanceof Integer) == false) goto L70;
        r118 = Double.valueOf(((Number) r114).intValue());
        goto L98
    L70:
        if ((r114 instanceof Long) == false) goto L98;
        r118 = Double.valueOf(((Number) r114).longValue());
        goto L98
    L73:
        if ((r114 instanceof Long) == false) goto L76;
        r118 = (Long) r114;
        goto L98
    L76:
        if ((r114 instanceof Integer) == false) goto L98;
        r118 = Long.valueOf(((Number) r114).intValue());
        goto L98
    L79:
        if ((r114 instanceof Integer) == false) goto L82;
        r118 = (Integer) r114;
        goto L98
    L82:
        if ((r114 instanceof Long) == false) goto L98;
        long r129 = ((Number) r114).longValue();
        if (r129 >= SieveCacheKt.NodeMetaAndPreviousMask) goto L86;
    L88:
        boolean r130 = false;
    L89:
        if (r130 == true) goto L92;
        r114 = null;
    L92:
        Long r131 = (Long) r114;
        if (r131 == null) goto L98;
        r118 = Integer.valueOf((int) r131.longValue());
        goto L98
    L86:
        if (r129 > SieveCacheKt.NodeLinkMask) goto L88;
        r130 = true;
        goto L89
    L96:
        if ((r114 instanceof Boolean) == false) goto L98;
        r118 = (Boolean) r114;
        goto L98
    L24:
        r114 = r109;
        goto L25
    L19:
        if (r113.f484423b.containsKey(r108) == false) goto L21;
        e r132 = e.f484420a;
        Object r133 = r113.f484423b.get(r108);
        r132.getClass();
        r122 = e.a(r133);
        goto L106
    }
}
