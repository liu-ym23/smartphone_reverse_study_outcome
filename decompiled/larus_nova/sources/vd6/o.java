package vd6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f554199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f554200c;

    public static final class a {
    }

    static {
    }

    public abstract Object a(List<? extends Object> r100);

    public final String b(List<? extends Object> r110) {
        List<? extends Object> r100 = r110;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L25;
        int r103 = this.f554200c;
        int r104 = 0;
        boolean r105 = true;
        boolean r106 = true;
        boolean r107 = false;
    L11:
        if (r104 >= r103) goto L24;
        Object r108 = ListProtector.get(r110, r104);
        if ((r108 instanceof Number) == true) goto L16;
        r105 = false;
    L16:
        if ((r108 instanceof Boolean) == true) goto L19;
        r106 = false;
    L19:
        if ((r108 instanceof Float) == false) goto L21;
    L22:
        r107 = true;
    L23:
        r104 = r104 + 1;
        goto L11
    L21:
        if ((r108 instanceof Double) == false) goto L23;
    L24:
        r101 = r105;
    L26:
        if (r101 == false) goto L30;
        if (r107 == false) goto L29;
        return "param_type_double";
    L29:
        return "param_type_number";
    L30:
        if (r106 == false) goto L32;
        return "param_type_boolean";
    L32:
        return "param_type_other";
    L25:
        r106 = false;
        r107 = false;
        goto L26
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void c(List<? extends Object> r100, boolean r101) {
        List<? extends Object> r102 = r100;
        int r103 = 0;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L29;
        int r105 = r100.size();
        int r106 = this.f554200c;
        if (r105 < r106) goto L27;
    L13:
        if (r103 >= r106) goto L25;
        if (ListProtector.get(r100, r103) == null) goto L24;
        if ((ListProtector.get(r100, r103) instanceof sd6.f) == false) goto L22;
        if (r101 == false) goto L22;
        throw new ExprException(101, "params error: param is null");
    L22:
        r103 = r103 + 1;
        goto L13
    L24:
        throw new ExprException(101, "params error: param is null");
    L25:
        return;
    L27:
        throw new ExprException(101, "params error: params.size() < operator.argsLength");
    L29:
        throw new ExprException(101, "params error: params isNullOrEmpty");
    L5:
        if (r102.isEmpty() == true) goto L8;
        r104 = false;
        goto L10
    }

    public o(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        this.f554198a = r100;
        this.f554199b = r101;
        this.f554200c = r102;
    }
}
