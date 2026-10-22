package f33;

import com.bytedance.android.scope.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    public static final KClass<? extends j> a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "scopeInstance");
        Class<?>[] r101 = r100.getClass().getInterfaces();
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        boolean r104 = false;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L8;
        Class<?> r106 = r101[r105];
        if (j.class.isAssignableFrom(r106) == false) goto L7;
        r102.add(r106);
    L7:
        r105 = r105 + 1;
        goto L3
    L8:
        LinkedHashSet r107 = new LinkedHashSet();
        Iterator r108 = r102.iterator();
    L10:
        if (r108.hasNext() == false) goto L23;
        Class r109 = (Class) r108.next();
        Iterator r110 = r107.iterator();
        boolean r111 = false;
    L13:
        if (r110.hasNext() == false) goto L20;
        Class<?> r112 = (Class) r110.next();
        if (r112.isAssignableFrom(r109) == true) goto L16;
        if (r109.isAssignableFrom(r112) == false) goto L13;
        r111 = true;
        goto L13
    L16:
        r110.remove();
        goto L13
    L20:
        if (r111 == true) goto L10;
        r107.add(r109);
        goto L10
    L23:
        if (r107.size() != 1) goto L25;
        r104 = true;
    L25:
        if (r104 == false) goto L32;
        KClass<? extends j> r113 = JvmClassMappingKt.getKotlinClass((Class) CollectionsKt.first(r107));
        if (r113 == null) goto L30;
        return r113;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.KClass<out com.bytedance.android.scope.Scope>");
    L32:
        throw new IllegalStateException(("Scope instance must implement exactly one Scope interface: " + r100 + ", " + r107).toString());
    }
}
