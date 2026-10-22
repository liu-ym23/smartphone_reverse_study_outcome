package kotlinx.serialization.json.internal;

import com.facebook.keyframes.model.KFAnimation;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p.a<Map<String, Integer>> f505459a = null;

    static {
        f505459a = new p.a();
    }

    public static final Map<String, Integer> b(final ouc.a r100, final luc.f r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "descriptor");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        p r102 = r100.f526801c;
        p.a<Map<String, Integer>> r103 = f505459a;
        Function0 r104 = new t(r101, r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "descriptor");
        Intrinsics.checkNotNullParameter(r103, "key");
        Intrinsics.checkNotNullParameter(r104, "defaultValue");
        Object r105 = r102.a(r101, r103);
        if (r105 != null) goto L10;
        r105 = r104.invoke();
        Intrinsics.checkNotNullParameter(r101, "descriptor");
        Intrinsics.checkNotNullParameter(r103, "key");
        Intrinsics.checkNotNullParameter(r105, "value");
        ConcurrentHashMap r106 = (ConcurrentHashMap) r102.f505453a;
        Object r107 = r106.get(r101);
        if (r107 != null) goto L8;
        r107 = new ConcurrentHashMap(2);
        r106.put(r101, r107);
    L8:
        ((Map) r107).put(r103, r105);
    L10:
        return (Map) r105;
    }

    public static final void e(luc.f r100, ouc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "json");
        if (Intrinsics.areEqual(r100.getKind(), luc.p.a.f510877a) == false) goto L6;
        r101.f526799a.getClass();
        return;
    }

    public static final int c(luc.f r100, ouc.a r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "json");
        Intrinsics.checkNotNullParameter(r102, "name");
        if (r101.f526799a.f526844m == true) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L14;
        String r104 = r102.toLowerCase(Locale.ROOT);
        Integer r105 = b(r101, r100).get(r104);
        if (r105 != null) goto L13;
        return -3;
    L13:
        return r105.intValue();
    L14:
        e(r100, r101);
        int r106 = r100.g(r102);
        if (r106 == (-3)) goto L18;
        return r106;
    L18:
        if (r101.f526799a.f526843l == true) goto L20;
        return r106;
    L20:
        Integer r107 = b(r101, r100).get(r102);
        if (r107 != null) goto L23;
        return -3;
    L23:
        return r107.intValue();
    L5:
        if (Intrinsics.areEqual(r100.getKind(), luc.o.b.f510876a) == false) goto L7;
        r103 = true;
        goto L9
    }

    public static final void a(Map<String, Integer> r100, luc.f r101, String r102, int r103) {
        if (Intrinsics.areEqual(r101.getKind(), luc.o.b.f510876a) == false) goto L5;
        String r104 = "enum value";
    L7:
        if (r100.containsKey(r102) == true) goto L11;
        r100.put(r102, Integer.valueOf(r103));
        return;
    L11:
        throw new JsonException("The suggested name '" + r102 + "' for " + r104 + ' ' + r101.b(r103) + " is already one of the names for " + r104 + ' ' + r101.b(((Number) MapsKt.getValue(r100, r102)).intValue()) + " in " + r101);
    L5:
        r104 = KFAnimation.PROPERTY_TYPE_JSON_FIELD;
        goto L7
    }

    public static final int d(luc.f r100, ouc.a r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "json");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "suffix");
        int r104 = c(r100, r101, r102);
        if (r104 == (-3)) goto L6;
        return r104;
    L6:
        throw new SerializationException(r100.f() + " does not contain element with name '" + r102 + '\'' + r103);
    }
}
