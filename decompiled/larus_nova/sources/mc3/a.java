package mc3;

import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.commentv2.model.CommentTabTypeEnum;
import com.bytedance.android.shopping.commentv3.data.StatIdEnum;
import com.bytedance.android.shopping.commentv3.data.TabTypeEnum;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
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

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C6799a f512870b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f512871a;

    /* JADX INFO: renamed from: mc3.a$a, reason: collision with other inner class name */
    public static final class C6799a {
        public C6799a() {
        }

        public static String a() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
            JSONObject r101 = new JSONObject();     // Catch: Throwable -> L4
            r101.put(EffectConfiguration.KEY_FILTER_TYPE, TabTypeEnum.TAB.getType());     // Catch: Throwable -> L4
            r101.put("filter_id", StatIdEnum.ALL.getId());     // Catch: Throwable -> L4
            Object r102 = Result.m9449constructorimpl(r101.toString());     // Catch: Throwable -> L4
        L7:
            if (Result.m9455isFailureimpl(r102) == false) goto L10;
            r102 = "";
        L10:
            return (String) r102;
        L4:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public static Map b() {
            LinkedHashMap r100 = new LinkedHashMap();
            r100.put("id", "1");
            r100.put("name", "全部");
            r100.put("sentiment", 1);
            r100.put(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, Integer.valueOf(TabTypeEnum.TAB.getType()));
            Unit r101 = Unit.INSTANCE;
            return MapsKt.mapOf(TuplesKt.to("selected_tab", r100));
        }

        public static String c(CommentParams r100, String r101) {
            if (r100 == null) goto L6;
            Map<String, Object> r102 = r100.getExtraParams();
            if (r102 == null) goto L6;
            Object r103 = r102.get(r101);
        L8:
            if ((r103 instanceof String) == true) goto L30;
            Object r104 = "";
            if ((r103 instanceof Map) == false) goto L26;
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
            Set r106 = ((Map) r103).entrySet();     // Catch: Throwable -> L18
            LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r106, 10)), 16));     // Catch: Throwable -> L18
            Iterator r108 = r106.iterator();     // Catch: Throwable -> L18
        L14:
            if (r108.hasNext() == false) goto L16;
            Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Throwable -> L18
            Pair r110 = TuplesKt.to(String.valueOf(r109.getKey()), r109.getValue());     // Catch: Throwable -> L18
            r107.put(r110.getFirst(), r110.getSecond());     // Catch: Throwable -> L18
            goto L14
        L16:
            Object r111 = Result.m9449constructorimpl(new JSONObject(r107).toString());     // Catch: Throwable -> L18
        L21:
            if (Result.m9455isFailureimpl(r111) == true) goto L31;
            r104 = r111;
        L31:
            return (String) r104;
        L18:
            th = move-exception;
            Result.Companion r112 = Result.Companion;
            r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L21
        L26:
            return "";
        L30:
            return (String) r103;
        L6:
            r103 = null;
            goto L8
        }
    }

    static {
        f512870b = new C6799a();
    }

    public final String a() {
        Object r100 = this.f512871a.get("first_filter");
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r101 = (String) r100;
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if (r101.length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        f512870b.getClass();
        return C6799a.a();
    L15:
        return r101;
    L11:
        r102 = false;
        goto L12
    }

    public final boolean b() {
        Object r100 = this.f512871a.get("selected_first");
        if ((r100 instanceof Map) == true) goto L5;
        r100 = null;
    L5:
        Map r101 = (Map) r100;
        if (r101 == null) goto L12;
        if (nc3.a.c(r101, "id", 0) != StatIdEnum.PIC_VIDEO.getId()) goto L17;
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
        Object r100 = this.f512871a.get("second_filter");
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r101 = (String) r100;
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    }

    public final Map<? extends Object, Object> e() {
        Object r100 = this.f512871a.get("selected_second");
        Object r101 = null;
        if ((r100 instanceof Map) == true) goto L5;
        r100 = null;
    L5:
        Map<? extends Object, Object> r102 = (Map) r100;
        if (r102 != null) goto L11;
        Object r103 = this.f512871a.get("selected_first");
        if ((r103 instanceof Map) == true) goto L10;
        r103 = null;
    L10:
        r102 = (Map) r103;
    L11:
        if (r102 != null) goto L17;
        Object r104 = this.f512871a.get("selected_tab");
        if ((r104 instanceof Map) == false) goto L16;
        r101 = r104;
    L16:
        r102 = (Map) r101;
    L17:
        if (r102 == null) goto L19;
        return r102;
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
        return nc3.a.c(e(), com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, CommentTabTypeEnum.STAT.getType());
    }

    public a(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f512871a = r100;
    }
}
