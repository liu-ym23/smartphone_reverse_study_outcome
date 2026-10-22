package mc3;

import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.commentv2.model.CommentTabTypeEnum;
import com.bytedance.android.shopping.commentv3.data.StatIdEnum;
import com.bytedance.android.shopping.commentv3.data.TabTypeEnum;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final C0218a b = null;
    public final Map<String, Object> a;

    /* JADX INFO: renamed from: mc3.a$a, reason: collision with other inner class name */
    public static final class C0218a {
        public C0218a() {
        }

        public static String a() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            JSONObject r1 = new JSONObject();     // Catch: Throwable -> L4
            r1.put("filter_type", TabTypeEnum.TAB.getType());     // Catch: Throwable -> L4
            r1.put("filter_id", StatIdEnum.ALL.getId());     // Catch: Throwable -> L4
            Object r2 = Result.constructor-impl(r1.toString());     // Catch: Throwable -> L4
        L7:
            if (Result.isFailure-impl(r2) == false) goto L10;
            r2 = "";
        L10:
            return (String) r2;
        L4:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r2 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }

        public static Map b() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("id", "1");
            r0.put("name", "全部");
            r0.put("sentiment", 1);
            r0.put("tag_type", Integer.valueOf(TabTypeEnum.TAB.getType()));
            Unit r1 = Unit.INSTANCE;
            return MapsKt.mapOf(TuplesKt.to("selected_tab", r0));
        }

        public static String c(CommentParams r3, String r4) {
            if (r3 == null) goto L6;
            Map r5 = r3.getExtraParams();
            if (r5 == null) goto L6;
            Object r6 = r5.get(r4);
        L8:
            if ((r6 instanceof String) == true) goto L30;
            Object r0 = "";
            if ((r6 instanceof Map) == false) goto L26;
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L18
            Set r8 = ((Map) r6).entrySet();     // Catch: Throwable -> L18
            LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));     // Catch: Throwable -> L18
            Iterator r9 = r8.iterator();     // Catch: Throwable -> L18
        L14:
            if (r9.hasNext() == false) goto L16;
            Map.Entry r10 = (Map.Entry) r9.next();     // Catch: Throwable -> L18
            Pair r11 = TuplesKt.to(String.valueOf(r10.getKey()), r10.getValue());     // Catch: Throwable -> L18
            r1.put(r11.getFirst(), r11.getSecond());     // Catch: Throwable -> L18
            goto L14
        L16:
            Object r12 = Result.constructor-impl(new JSONObject(r1).toString());     // Catch: Throwable -> L18
        L21:
            if (Result.isFailure-impl(r12) == true) goto L31;
            r0 = r12;
        L31:
            return (String) r0;
        L18:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L21
        L26:
            return "";
        L30:
            return (String) r6;
        L6:
            r6 = null;
            goto L8
        }
    }

    static {
        b = new C0218a();
    }

    public final String a() {
        Object r0 = this.a.get("first_filter");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (r1.length() != 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        b.getClass();
        return C0218a.a();
    L15:
        return r1;
    L11:
        r2 = false;
        goto L12
    }

    public final boolean b() {
        Object r0 = this.a.get("selected_first");
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map r1 = (Map) r0;
        if (r1 == null) goto L12;
        if (nc3.a.c(r1, "id", 0) != StatIdEnum.PIC_VIDEO.getId()) goto L17;
        return true;
    L17:
        return false;
    L12:
        if (c() == true) goto L14;
        return false;
    L14:
        if (f() != StatIdEnum.PIC_VIDEO.getId()) goto L19;
        return true;
    L19:
        return false;
    }

    public final String d() {
        Object r0 = this.a.get("second_filter");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    }

    public final Map<? extends Object, Object> e() {
        Object r0 = this.a.get("selected_second");
        Object r2 = null;
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map<? extends Object, Object> r1 = (Map) r0;
        if (r1 != null) goto L11;
        Object r3 = this.a.get("selected_first");
        if ((r3 instanceof Map) == true) goto L10;
        r3 = null;
    L10:
        r1 = (Map) r3;
    L11:
        if (r1 != null) goto L17;
        Object r4 = this.a.get("selected_tab");
        if ((r4 instanceof Map) == false) goto L16;
        r2 = r4;
    L16:
        r1 = (Map) r2;
    L17:
        if (r1 == null) goto L19;
        return r1;
    L19:
        return new LinkedHashMap();
    }

    public final boolean c() {
        if (g() != CommentTabTypeEnum.STAT.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final long f() {
        return nc3.a.c(e(), "id", StatIdEnum.ALL.getId());
    }

    public final long g() {
        return nc3.a.c(e(), "tag_type", CommentTabTypeEnum.STAT.getType());
    }

    public a(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2;
    }
}
