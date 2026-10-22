package i57;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes21.dex */
public final class f<T, V> implements ReadOnlyProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f488325a = null;

    static {
        f488325a = new f();
    }

    public f() {
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return new a.C6231a(r101.getName());
    }
}
