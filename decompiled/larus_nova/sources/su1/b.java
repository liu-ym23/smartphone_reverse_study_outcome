package su1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f543585b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543586a;

    public static final class a {
        public a() {
        }

        private final int getType(Number r100) {
            if ((r100 instanceof Double) == false) goto L6;
            return 4;
        L6:
            if ((r100 instanceof Float) == false) goto L9;
            return 3;
        L9:
            if ((r100 instanceof Long) == false) goto L11;
            return 2;
        L11:
            return 1;
        }

        public static final int a(a r100, Object r101, Object r102) {
            r100.getClass();
            if ((r101 instanceof String) == false) goto L8;
            if ((r102 instanceof String) == false) goto L8;
            return ((String) r101).compareTo((String) r102);
        L8:
            if ((r101 instanceof Boolean) == false) goto L16;
            if ((r102 instanceof Boolean) == false) goto L16;
            if (Intrinsics.areEqual(r101, r102) == false) goto L14;
            return 0;
        L14:
            return -1;
        L16:
            if ((r101 instanceof Number) == false) goto L31;
            if ((r102 instanceof Number) == false) goto L31;
            Number r103 = (Number) r101;
            Number r104 = (Number) r102;
            int r105 = Math.max(r100.getType(r103), r100.getType(r104));
            if (r105 == 2) goto L29;
            if (r105 == 3) goto L37;
            if (r105 == 4) goto L36;
            return Intrinsics.compare(r103.intValue(), r104.intValue());
        L36:
            return Double.compare(r103.doubleValue(), r104.doubleValue());
        L37:
            return Float.compare(r103.floatValue(), r104.floatValue());
        L29:
            return (r103.longValue() > r104.longValue() ? 1 : (r103.longValue() == r104.longValue() ? 0 : -1));
        L31:
            throw new SimpleExpressException("express execute failed, compare error, o1 is " + r101 + ", o2 is " + r102, null, 2, null);
        }
    }

    static {
        f543585b = new a();
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, OnekeyLoginConstants.CU_KEY_OPERATOR);
        this.f543586a = r100;
    }

    public final Object b(qu1.a r100) {
        if (r100.f534837a.isEmpty() == true) goto L10;
        Object r101 = ((LinkedList) r100.f534837a).pop();
        if (r101 == null) goto L8;
        return r101;
    L8:
        throw new SimpleExpressException("express execute failed, " + this.f543586a + " operation value is " + r101, null, 2, null);
    L10:
        throw new SimpleExpressException("express execute failed, " + this.f543586a + " operation value is null", null, 2, null);
    }

    @Override // su1.e
    public final void a(qu1.a r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "environment");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r102 = b(r100);
        int r103 = a.a(f543585b, b(r100), r102);
        String r104 = this.f543586a;
        int r105 = r104.hashCode();
        if (r105 == 60) goto L37;
        if (r105 == 62) goto L33;
        if (r105 == 1084) goto L29;
        if (r105 == 1921) goto L24;
        if (r105 == 1952) goto L20;
        if (r105 != 1983) goto L44;
        if (r104.equals(">=") == false) goto L44;
        if (r103 == 0) goto L39;
        if (r103 > 0) goto L39;
    L40:
        boolean r106 = false;
    L41:
        ((LinkedList) r100.f534837a).push(Boolean.valueOf(r106));
        return;
    L39:
        r106 = true;
    L44:
        throw new SimpleExpressException("express execute failed, unknown operator[" + this.f543586a + ']', null, 2, null);
    L20:
        if (r104.equals("==") == false) goto L44;
        if (r103 != 0) goto L40;
    L24:
        if (r104.equals("<=") == false) goto L44;
        if (r103 == 0) goto L39;
        if (r103 >= 0) goto L40;
    L29:
        if (r104.equals("!=") == false) goto L44;
        if (r103 == 0) goto L40;
    L33:
        if (r104.equals(">") == false) goto L44;
        if (r103 <= 0) goto L40;
    L37:
        if (r104.equals("<") == false) goto L44;
        if (r103 >= 0) goto L40;
        goto L39
    }
}
