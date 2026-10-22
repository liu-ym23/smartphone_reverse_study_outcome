package db;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f467789d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f467790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f467791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f467792c;

    /* JADX INFO: renamed from: db.a$a, reason: collision with other inner class name */
    public static final class C5648a {
        public static Object a(String r110, Object r111) {
            Intrinsics.checkNotNullParameter(r110, "input");
            boolean r100 = false;
            if (StringsKt.startsWith$default(r110, "$", false, 2, null) == false) goto L5;
            r110 = r110.substring(2);
        L5:
            int r101 = StringsKt.indexOf$default(r110, ".", 0, false, 6, null);
            if (r101 != (-1)) goto L8;
            String r102 = "";
        L10:
            int r103 = r101 + 1;
            if (r110 == null) goto L55;
            String r104 = r110.substring(r103);
            if ((r111 instanceof Map) == false) goto L27;
            if (r102.length() != 0) goto L17;
            r100 = true;
        L17:
            if (r100 == true) goto L19;
            Map r105 = (Map) r111;
            if (r105.containsKey(r102) == false) goto L27;
            Object r112 = r105.get(r102);
            if (r112 == null) goto L58;
            int r113 = a.f467789d;
            return a(r104, r112);
        L58:
            return null;
        L19:
            return ((Map) r111).get(r110);
        L27:
            if ((r111 instanceof String) == false) goto L38;
            if (Intrinsics.areEqual(r110, "length") == true) goto L31;
            int r114 = CastIntegerProtector.parseInt(r110);
            String r115 = (String) r111;
            if (r114 < r115.length()) goto L35;
            return null;
        L35:
            return String.valueOf(r115.charAt(r114));
        L31:
            return Integer.valueOf(((String) r111).length());
        L38:
            if ((r111 instanceof List) == true) goto L40;
            return null;
        L40:
            if (Intrinsics.areEqual(r110, "length") == true) goto L42;
            if (r101 >= 0) goto L47;
            List r116 = (List) r111;
            int r117 = CastIntegerProtector.parseInt(r110);
            if (r117 < r116.size()) goto L61;
            return null;
        L61:
            return ListProtector.get(r116, r117);
        L47:
            List r118 = (List) r111;
            int r106 = CastIntegerProtector.parseInt(r102);
            if (r106 >= r118.size()) goto L50;
            Object r119 = ListProtector.get(r118, r106);
        L51:
            if (r119 == null) goto L62;
            int r107 = a.f467789d;
            return a(r110.substring(r103), r119);
        L62:
            return null;
        L50:
            r119 = null;
            goto L51
        L42:
            return Integer.valueOf(((List) r111).size());
        L55:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L8:
            if (r110 == null) goto L57;
            r102 = r110.substring(0, r101);
            goto L10
        L57:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    static {
    }

    public a() {
        this.f467790a = new LinkedHashMap();
        this.f467791b = new LinkedHashMap();
        this.f467792c = new ConcurrentHashMap();
    }
}
