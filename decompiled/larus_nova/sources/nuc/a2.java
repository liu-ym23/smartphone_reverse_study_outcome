package nuc;

import com.vivo.push.PushClientConstants;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes5.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final luc.f[] f520642a = null;

    static {
        f520642a = new luc.f[0];
    }

    public static final Set<String> a(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof n) == true) goto L5;
        HashSet r101 = new HashSet(r100.d());
        int r102 = r100.d();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L9;
        r101.add(r100.b(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r101;
    L5:
        return ((n) r100).c();
    }

    public static final luc.f[] b(List<? extends luc.f> r100) {
        List<? extends luc.f> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r100 = null;
    L12:
        if (r100 == null) goto L16;
        luc.f[] r103 = (luc.f[]) r100.toArray(new luc.f[0]);
        if (r103 == null) goto L16;
        return r103;
    L16:
        return f520642a;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final KClass<Object> c(KType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        KClassifier r101 = r100.getClassifier();
        if ((r101 instanceof KClass) == false) goto L7;
        return (KClass) r101;
    L7:
        if ((r101 instanceof KTypeParameter) == false) goto L11;
        throw new IllegalArgumentException("Captured type parameter " + r101 + " from generic non-reified function. Such functionality cannot be supported because " + r101 + " is erased, either specify serializer explicitly or make calling function inline with reified " + r101 + '.');
    L11:
        throw new IllegalArgumentException("Only KClass supported as classifier, got " + r101);
    }

    public static final void d(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getSimpleName();
        if (r101 != null) goto L5;
        r101 = "<local class name not available>";
    L5:
        Intrinsics.checkNotNullParameter(r101, PushClientConstants.TAG_CLASS_NAME);
        throw new SerializationException("Serializer for class '" + r101 + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n");
    }
}
