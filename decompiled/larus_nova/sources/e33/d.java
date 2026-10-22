package e33;

import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f470905a = null;

    public d() {
    }

    static {
        f470905a = new d();
    }

    public static Class b(Type r100) {
        if ((r100 instanceof Class) == false) goto L6;
        return (Class) r100;
    L6:
        if ((r100 instanceof ParameterizedType) == false) goto L10;
        return b(((ParameterizedType) r100).getRawType());
    L10:
        throw new IllegalArgumentException("Unsupported type");
    }

    @Override // e33.n
    public final o a(l r110, com.bytedance.android.scope.e r111) {
        Intrinsics.checkNotNullParameter(r110, "serviceDesc");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        KClass r100 = (KClass) CollectionsKt.firstOrNull(r110.f470910b);
        if (r100 == null) goto L28;
        Constructor r112 = (Constructor) ArraysKt.firstOrNull(JvmClassMappingKt.getJavaClass(r100).getConstructors());
        if (r112 == null) goto L26;
        Type[] r101 = r112.getGenericParameterTypes();
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L19;
        Type r105 = r101[r104];
        if ((r105 instanceof Class) == false) goto L12;
        Object r106 = r111.b(JvmClassMappingKt.getKotlinClass((Class) r105));
    L16:
        r102.add(r106);
        r104 = r104 + 1;
        goto L7
    L12:
        if ((r105 instanceof ParameterizedType) == false) goto L18;
        ParameterizedType r107 = (ParameterizedType) r105;
        if (Intrinsics.areEqual(r107.getRawType(), com.bytedance.android.scope.a.class) == false) goto L18;
        r106 = b.a(r111, JvmClassMappingKt.getKotlinClass(b(r107.getActualTypeArguments()[0])));
    L18:
        throw new IllegalArgumentException("Unsupported parameter type " + r105);
    L19:
        Object[] r113 = r102.toArray(new Object[0]);
        Object r114 = r112.newInstance(Arrays.copyOf(r113, r113.length));
        if (r114 == null) goto L24;
        return (o) r114;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.scope.ScopeService");
    L26:
        throw new IllegalStateException(("Type does not have a constructor: " + r100).toString());
    L28:
        throw new IllegalStateException(("Service does not have a primary type: " + r110).toString());
    }
}
