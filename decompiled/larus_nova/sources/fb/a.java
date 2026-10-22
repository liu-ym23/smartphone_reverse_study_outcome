package fb;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import gb.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: fb.a$a, reason: collision with other inner class name */
    public static final class C5877a {
    }

    static {
    }

    public a() {
    }

    public static Object a(gb.d r110) {
        Intrinsics.checkNotNullParameter(r110, "option");
        if (Intrinsics.areEqual(r110.getType(), "op") == false) goto L197;
        List<Object> r100 = r110.c();
        if (r100 == null) goto L7;
        boolean r101 = true;
        boolean r102 = false;
        if (Intrinsics.areEqual(r110.b(), "!") == false) goto L19;
        if (r100.isEmpty() == true) goto L17;
        if (e.a(ListProtector.get(r100, 0)) == false) goto L17;
        r101 = false;
    L17:
        return Boolean.valueOf(r101);
    L19:
        if (Intrinsics.areEqual(r110.b(), "&&") == false) goto L38;
        if (r100.isEmpty() == true) goto L23;
        List<Object> r103 = r100;
        if ((r103 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r111 = r103.iterator();
    L31:
        if (r111.hasNext() == false) goto L36;
        if (e.a(r111.next()) == true) goto L31;
        r101 = false;
    L36:
        return Boolean.valueOf(r101);
    L27:
        if (r103.isEmpty() == false) goto L29;
    L23:
        return Boolean.FALSE;
    L38:
        if (Intrinsics.areEqual(r110.b(), "||") == false) goto L58;
        if (r100.isEmpty() == true) goto L42;
        List<Object> r104 = r100;
        if ((r104 instanceof Collection) == true) goto L46;
    L48:
        Iterator<T> r112 = r104.iterator();
    L50:
        if (r112.hasNext() == false) goto L54;
        if (e.a(r112.next()) == false) goto L50;
    L56:
        return Boolean.valueOf(r101);
    L54:
        r101 = false;
        goto L56
    L46:
        if (r104.isEmpty() == false) goto L48;
    L42:
        return Boolean.FALSE;
    L58:
        if (r100.size() >= 2) goto L62;
        HybridLogger r113 = HybridLogger.f246343a;
        HybridLogger.i("AirSolution_CalcExecutor", "error: size less then 2, " + r100, null, 12);
        return new Object();
    L62:
        if (Intrinsics.areEqual(r110.b(), "t") == false) goto L73;
        if (r100.size() >= 3) goto L67;
        HybridLogger r114 = HybridLogger.f246343a;
        HybridLogger.i("AirSolution_CalcExecutor", "error: size less then 3, " + r100, null, 12);
        return new Object();
    L67:
        boolean r115 = e.a(ListProtector.get(r100, 0));
        Object r105 = ListProtector.get(r100, 1);
        Object r106 = ListProtector.get(r100, 2);
        if (r115 == false) goto L71;
        return r105;
    L71:
        return r106;
    L73:
        if ((ListProtector.get(r100, 0) instanceof Number) == true) goto L75;
    L165:
        Object r107 = ListProtector.get(r100, 0);
        Object r108 = ListProtector.get(r100, 1);
        String r116 = r110.b();
        if (r116 == null) goto L195;
        int r109 = r116.hashCode();
        if (r109 == 43) goto L183;
        if (r109 == 61) goto L179;
        if (r109 != 1084) goto L195;
        if (r116.equals("!=") == false) goto L195;
        return Boolean.valueOf(!Intrinsics.areEqual(r107, r108));
    L179:
        if (r116.equals(ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L195;
        return Boolean.valueOf(Intrinsics.areEqual(r107, r108));
    L183:
        if (r116.equals(Marker.ANY_NON_NULL_MARKER) == false) goto L195;
        if ((r107 instanceof String) == false) goto L188;
    L192:
        StringBuilder r117 = new StringBuilder();
        r117.append(r107);
        r117.append(r108);
        return r117.toString();
    L188:
        if ((r108 instanceof String) == true) goto L192;
        return new Object();
    L195:
        return Boolean.FALSE;
    L75:
        if ((ListProtector.get(r100, 1) instanceof Number) == false) goto L165;
        Object r118 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type kotlin.Number");
        double r119 = ((Number) r118).doubleValue();
        Object r120 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type kotlin.Number");
        double r121 = ((Number) r120).doubleValue();
        String r122 = r110.b();
        if (r122 == null) goto L197;
        int r123 = r122.hashCode();
        if (r123 == 42) goto L161;
        if (r123 == 43) goto L156;
        if (r123 == 45) goto L151;
        if (r123 == 47) goto L146;
        if (r123 == 1084) goto L138;
        if (r123 == 1921) goto L129;
        if (r123 == 1983) goto L120;
        switch(r123) {
            case 60: goto L111;
            case 61: goto L102;
            case 62: goto L93;
            default: goto L197;
        };
    L93:
        if (r122.equals(">") == false) goto L197;
        if (r119 > r121) goto L100;
        r101 = false;
    L100:
        return Boolean.valueOf(r101);
    L102:
        if (r122.equals(ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L197;
        if (r119 == r121) goto L109;
        r101 = false;
    L109:
        return Boolean.valueOf(r101);
    L111:
        if (r122.equals("<") == false) goto L197;
        if (r119 < r121) goto L118;
        r101 = false;
    L118:
        return Boolean.valueOf(r101);
    L120:
        if (r122.equals(">=") == false) goto L197;
        if (r119 >= r121) goto L127;
        r101 = false;
    L127:
        return Boolean.valueOf(r101);
    L129:
        if (r122.equals("<=") == false) goto L197;
        if (r119 <= r121) goto L136;
        r101 = false;
    L136:
        return Boolean.valueOf(r101);
    L138:
        if (r122.equals("!=") == false) goto L197;
        if (r119 != r121) goto L144;
        r102 = true;
    L144:
        return Boolean.valueOf(!r102);
    L146:
        if (r122.equals(HTTP.URL_DEFAULT) == false) goto L197;
        return Double.valueOf(r119 / r121);
    L151:
        if (r122.equals("-") == false) goto L197;
        return Double.valueOf(r119 - r121);
    L156:
        if (r122.equals(Marker.ANY_NON_NULL_MARKER) == false) goto L197;
        return Double.valueOf(r119 + r121);
    L161:
        if (r122.equals("*") == false) goto L197;
        return Double.valueOf(r119 * r121);
    L7:
        return new Object();
    L197:
        return new Object();
    }
}
