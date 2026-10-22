package kotlinx.datetime.internal.format;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: classes42.dex */
public final class t<Object, Field> implements b<Object, Field> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KMutableProperty1<Object, Field> f505356a;

    @Override // kotlinx.datetime.internal.format.parser.a
    public final String getName() {
        return this.f505356a.getName();
    }

    public t(MutablePropertyReference1Impl r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f505356a = r100;
    }

    @Override // kotlinx.datetime.internal.format.b
    public final Field a(Object r100) {
        Field r101 = b(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("Field " + getName() + " is not set");
    }

    @Override // kotlinx.datetime.internal.format.b
    public final Field b(Object r100) {
        return this.f505356a.get(r100);
    }

    @Override // kotlinx.datetime.internal.format.parser.a
    public final Field c(Object r100, Field r101) {
        Field r102 = this.f505356a.get(r100);
        if (r102 != null) goto L7;
        this.f505356a.set(r100, r101);
    L9:
        return null;
    L7:
        if (Intrinsics.areEqual(r102, r101) == true) goto L9;
        return r102;
    }
}
