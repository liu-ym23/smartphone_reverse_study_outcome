package fj3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: fj3.a$a, reason: collision with other inner class name */
    public static final class C0123a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0123a) == false) goto L16;
            C0123a r4 = (C0123a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 == null) goto L22;
            r1 = r13.hashCode();
        L22:
            return r12 + r1;
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(schema=" + this.a + ", btm=" + this.b + ", bcm=" + this.c + ", sourcePackage=" + this.d + ", traceId=" + this.e + ")";
        }

        public C0123a(String r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "schema");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b {
        public final int a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "Result(code=" + this.a + ", msg=" + this.b + ")";
        }

        public b(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public static String a(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof String) == true) goto L8;
        String r3 = r2.toString();
        if ((!StringsKt.isBlank(r3)) == true) goto L15;
        return null;
    L15:
        return r3;
    L8:
        if ((!StringsKt.isBlank((String) r2)) == true) goto L16;
        r2 = null;
    L16:
        return (String) r2;
    }

    public static b c(Map r9, Context r10, PageFinder r11) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Object r0 = r9.get("data");
        if ((r0 instanceof Map) == false) goto L19;
        Set r12 = ((Map) r0).entrySet();
        ArrayList r1 = new ArrayList();
        Iterator r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        Object r2 = r13.next();
        if ((((Map.Entry) r2).getKey() instanceof String) == false) goto L6;
        r1.add(r2);
        goto L6
    L10:
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r14 = r1.iterator();
    L12:
        if (r14.hasNext() == false) goto L24;
        Map.Entry r4 = (Map.Entry) r14.next();
        Object r5 = r4.getKey();
        if (r5 == null) goto L17;
        Pair r6 = TuplesKt.to((String) r5, r4.getValue());
        r3.put(r6.getFirst(), r6.getSecond());
        goto L12
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L24:
        r9 = r3;
    L25:
        String r7 = a(r9.get("schema"));
        C0123a r8 = null;
        if (r7 != null) goto L28;
    L34:
        if (r8 != null) goto L38;
        return new b(0, "schema parse error");
    L38:
        return e(r10, r11, r8);
    L28:
        if ((!StringsKt.isBlank(r7)) == false) goto L30;
        String r15 = r7;
    L31:
        if (r15 == null) goto L34;
        r8 = new C0123a(r15, a(r9.get("btm")), a(r9.get("bcm")), a(r9.get("sourcePackage")), a(r9.get("traceId")));
        goto L34
    L30:
        r15 = null;
        goto L31
    L19:
        if ((r0 instanceof JSONObject) == false) goto L25;
        JSONObject r16 = (JSONObject) r0;
        Sequence r17 = SequencesKt.asSequence(r16.keys());
        r3 = new LinkedHashMap();
        Iterator r18 = r17.iterator();
    L22:
        if (r18.hasNext() == false) goto L24;
        Object r19 = r18.next();
        r3.put(r19, r16.opt((String) r19));
        goto L22
    }

    public static b d(JSONObject r9, Context r10, PageFinder r11) {
        Intrinsics.checkNotNullParameter(r9, "params");
        JSONObject r0 = r9.optJSONObject("data");
        if (r0 == null) goto L6;
        r9 = r0;
    L6:
        String r1 = r9.optString("schema");
        C0123a r2 = null;
        if ((!StringsKt.isBlank(r1)) == false) goto L9;
        String r4 = r1;
    L10:
        if (r4 == null) goto L29;
        String r3 = r9.optString("btm");
        if ((!StringsKt.isBlank(r3)) == false) goto L15;
        String r5 = r3;
    L16:
        String r6 = r9.optString("bcm");
        if ((!StringsKt.isBlank(r6)) == false) goto L19;
        String r7 = r6;
    L20:
        String r8 = r9.optString("sourcePackage");
        if ((!StringsKt.isBlank(r8)) == false) goto L23;
        String r12 = r8;
    L24:
        String r13 = r9.optString("traceId");
        if ((!StringsKt.isBlank(r13)) == false) goto L27;
        String r14 = r13;
    L28:
        r2 = new C0123a(r4, r5, r7, r12, r14);
        goto L29
    L27:
        r14 = null;
        goto L28
    L23:
        r12 = null;
        goto L24
    L19:
        r7 = null;
        goto L20
    L15:
        r5 = null;
    L29:
        if (r2 != null) goto L33;
        return new b(0, "schema parse error");
    L33:
        return e(r10, r11, r2);
    L9:
        r4 = null;
        goto L10
    }

    public static b e(Context r5, PageFinder r6, C0123a r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(UriProtector.parse(r7.a));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        Uri r2 = (Uri) r1;
        if (r2 == null) goto L76;
        String r4 = r2.getScheme();
        if (r4 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == true) goto L76;
        String r3 = r2.getHost();
        if (r3 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == true) goto L76;
        String r10 = r7.a;
        String r11 = r7.b;
        if (r11 != null) goto L32;
    L35:
        boolean r12 = true;
    L36:
        if (r12 == true) goto L38;
        r10 = BtmUtilsKt.b(r10, BtmUtilsKt.e(r7.b, r6));
    L38:
        UrlBuilderV2 r13 = new UrlBuilderV2(r10);
        String r14 = r7.c;
        if (r14 != null) goto L41;
    L44:
        boolean r15 = true;
    L45:
        if (r15 == true) goto L103;
        r13.addOrReplaceParam("bcm", r7.c);
    L103:
        Object r16 = Result.constructor-impl(UriProtector.parse(r13.build()));     // Catch: Throwable -> L49
    L52:
        if (Result.isFailure-impl(r16) == false) goto L54;
        r16 = null;
    L54:
        Uri r17 = (Uri) r16;
        if (r17 == null) goto L76;
        String r18 = r17.getScheme();
        if (r18 != null) goto L59;
    L62:
        boolean r19 = true;
    L63:
        if (r19 == true) goto L73;
        String r20 = r17.getHost();
        if (r20 != null) goto L67;
    L70:
        boolean r21 = true;
    L71:
        if (r21 == true) goto L73;
        boolean r22 = true;
    L74:
        if (r22 == false) goto L76;
    L77:
        if (r17 == null) goto L79;
        boolean r23 = ECServiceManager.a;
        IAdapterService r24 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r24 == null) goto L83;
        if (r5 == null) goto L86;
        Bundle r25 = new Bundle();     // Catch: Throwable -> L89
        r25.putString("sourcePackage", r7.d);     // Catch: Throwable -> L89
        r25.putString("traceId", r7.e);     // Catch: Throwable -> L89
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L89
        Object r27 = Result.constructor-impl(Boolean.valueOf(r24.handleSchemaWithLive(r5, r17, true, r25)));     // Catch: Throwable -> L89
    L91:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 != null) goto L98;
        boolean r29 = ((Boolean) r27).booleanValue();
        dm.a.a("ECShopOpenJsbHelper").i("open shop schema, host=" + r17.getHost() + ", result=" + r29 + ",  sourcePackage=" + r7.d + ", traceId=" + r7.e);
        if (r29 == false) goto L97;
        return new b(1, "ok");
    L97:
        return new b(-1, "page not found");
    L98:
        String r30 = r28.getMessage();
        if (r30 != null) goto L102;
        r30 = "handleSchemaWithLive exception";
    L102:
        return b(r30, r7, r17, r28);
    L86:
        return b("context is null", r7, r17, null);
    L89:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L91
    L83:
        return b("adapter service unavailable", r7, r17, null);
    L79:
        return new b(0, "schema parse error");
    L67:
        if (StringsKt.isBlank(r20) == true) goto L70;
        r21 = false;
    L73:
        r22 = false;
        goto L74
    L59:
        if (StringsKt.isBlank(r18) == true) goto L62;
        r19 = false;
    L49:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L41:
        if (StringsKt.isBlank(r14) == true) goto L44;
        r15 = false;
        goto L45
    L32:
        if (StringsKt.isBlank(r11) == true) goto L35;
        r12 = false;
        goto L36
    L23:
        if (StringsKt.isBlank(r3) == true) goto L26;
        r9 = false;
        goto L27
    L15:
        if (StringsKt.isBlank(r4) == true) goto L18;
        r8 = false;
    L76:
        r17 = null;
    L4:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static b b(String r3, C0123a r4, Uri r5, Throwable r6) {
        dm.a.a("ECShopOpenJsbHelper").b("open shop schema disabled, host=" + r5.getHost() + ",sourcePackage=" + r4.d + ", traceId=" + r4.e + ", reason=" + r3, r6);
        return new b(-2, "page disabled");
    }
}
