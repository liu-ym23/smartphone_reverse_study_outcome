package yz5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<f> f569542a = null;

    static {
        f569542a = CollectionsKt.listOf(new f[]{new i(), new t(), new p(), new a(), new c(), new m(), new e(), new d(), new j(), new h(), new s(), new u(), new l(), new b(), new k(), new g(), new q(), new n()});
    }

    public static boolean a(List r100) {
        if (r100.isEmpty() == false) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return false;
    L9:
        if (((ArrayList) r100).size() != 1) goto L28;
        Object r102 = ListProtector.get(r100, 0);
        if (r102 == null) goto L13;
        boolean r103 = r102 instanceof String;
    L14:
        if (r103 == false) goto L28;
        String r104 = (String) r102;
        if (r104 == null) goto L18;
        String r105 = r104.toLowerCase(Locale.getDefault());
    L20:
        if (Intrinsics.areEqual(r105, "true") == false) goto L22;
        return true;
    L22:
        if (r104 == null) goto L24;
        String r106 = r104.toLowerCase(Locale.getDefault());
    L26:
        if (Intrinsics.areEqual(r106, "false") == false) goto L28;
        return false;
    L24:
        r106 = null;
        goto L26
    L18:
        r105 = null;
        goto L20
    L13:
        r103 = true;
    L28:
        Stack r107 = new Stack();
        Iterator r108 = r100.iterator();
    L30:
        if (r108.hasNext() == false) goto L40;
        Object r109 = r108.next();
        if ((r109 instanceof f) == true) goto L34;
        r107.push(r109);
        goto L30
    L34:
        if ((r109 instanceof n) == false) goto L36;
        Object r110 = ((f) r109).a(null, r107.pop());
    L37:
        r107.push(r110);
        goto L30
    L36:
        f r111 = (f) r109;
        r110 = r111.a(r107.pop(), r107.pop());
        goto L37
    L40:
        return d(r107.pop());
    L5:
        r101 = false;
        goto L6
    }

    public static boolean d(Object r100) throws RuntimeException {
        String r101 = String.valueOf(r100).toLowerCase(Locale.getDefault());
        if (Intrinsics.areEqual(r101, "true") == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r101, "false") == false) goto L10;
        return false;
    L10:
        throw new RuntimeException("not valid boolean, value = " + r101);
    }

    public static boolean b(String r100, Map r101) throws Exception {
        if (r100 == null) goto L7;
        String r102 = StringsKt.trim(r100).toString();
        if (r102 == null) goto L7;
        String r103 = r102.toLowerCase(Locale.getDefault());
    L8:
        boolean r104 = true;
        if (Intrinsics.areEqual(r103, "true") == false) goto L12;
        return true;
    L12:
        if (r100 != null) goto L14;
    L17:
        if (r104 == true) goto L38;
        if (r100 == null) goto L37;
        String r105 = StringsKt.trim(r100).toString();
        Locale r106 = Locale.getDefault();
        if (r105 == null) goto L35;
        if (Intrinsics.areEqual(r105.toLowerCase(r106), "false") == true) goto L38;
        if (r101.isEmpty() == true) goto L38;
        boolean r107 = a(c(r100, r101));     // Catch: Exception -> L28
        hz5.k.d("Helios-Control-Api", "getParseExecuteResult expression=" + r100 + " result=" + r107);     // Catch: Exception -> L28
        return r107;
    L28:
        e = move-exception;
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("expression", r100);
        Iterator r109 = r101.entrySet().iterator();
    L31:
        if (r109.hasNext() == false) goto L33;
        Map.Entry r110 = (Map.Entry) r109.next();
        r108.put(r110.getKey(), String.valueOf(((Function0) r110.getValue()).invoke()));
        goto L31
    L33:
        hz5.l.b(new iz5.b(null, e, "label_parser_executor_result", r108, 17));
        goto L38
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L38:
        return false;
    L14:
        if (StringsKt.isBlank(r100) == true) goto L17;
        r104 = false;
    L7:
        r103 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.Map] */
    public static List c(String r100, Map r101) {
        List r102 = StringsKt.split$default(r100, new String[]{" "}, false, 0, 6, null);
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if ((!StringsKt.isBlank((String) r105)) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r107 = r103.iterator();
    L10:
        if (r107.hasNext() == false) goto L31;
        String r108 = (String) r107.next();
        if (r108 == null) goto L30;
        ?? r109 = StringsKt.replace$default(StringsKt.trim(r108).toString(), "$@", " ", false, 4, null);
        Iterator r110 = f569542a.iterator();
    L14:
        Object r111 = null;
        if (r110.hasNext() == false) goto L19;
        Object r112 = r110.next();
        if (Intrinsics.areEqual(((f) r112).c(), r109) == false) goto L14;
    L20:
        f r113 = (f) r112;
        Function0 r114 = (Function0) r101.get(r109);
        if (r113 == null) goto L24;
        r109 = r113;
    L28:
        r106.add(r109);
        goto L10
    L24:
        if (r101.containsKey(r109) == false) goto L28;
        if (r114 == null) goto L27;
        r111 = r114.invoke();
    L27:
        hz5.k.d("Helios-Control-Api", "parseExpression " + r109 + com.alipay.sdk.m.n.a.f25612h + r111);
        r109 = r111;
        goto L28
    L19:
        r112 = null;
        goto L20
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L31:
        ArrayList r115 = new ArrayList();
        Stack r116 = new Stack();
        Iterator r117 = r106.iterator();
    L33:
        if (r117.hasNext() == false) goto L53;
        Object r118 = r117.next();
        if ((r118 instanceof f) == false) goto L36;
        if ((r118 instanceof i) == true) goto L39;
        if ((r118 instanceof t) == true) goto L43;
    L47:
        if ((!r116.isEmpty()) == false) goto L51;
        if (((f) r118).b() > ((f) r116.peek()).b()) goto L51;
        r115.add(r116.pop());
    L51:
        r116.push(r118);
    L43:
        if ((r116.peek() instanceof i) == true) goto L45;
        r115.add(r116.pop());
        goto L43
    L45:
        r116.pop();
        goto L33
    L39:
        r116.add(r118);
        goto L33
    L36:
        r115.add(r118);
    L53:
        if ((!r116.isEmpty()) == false) goto L55;
        r115.add(r116.pop());
        goto L53
    L55:
        return r115;
    }
}
