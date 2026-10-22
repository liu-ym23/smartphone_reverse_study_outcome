package com.ss.android.lark.coremd.ext;

import com.facebook.keyframes.model.KFAnimation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> implements ReadWriteProperty<j, T> {
    public c() {
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        j r102 = (j) r100;
        Intrinsics.checkNotNullParameter(r102, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Map<Object, Object> r103 = r102.getValues();
        String r104 = e.a(r101);
        Object r105 = r103.get(r104);
        if (r105 != null) goto L10;
        ConcurrentHashMap<Object, Function1<j, Object>> r106 = d.f419619a;
        Intrinsics.checkNotNullParameter(r102, "host");
        Intrinsics.checkNotNullParameter(r101, "kProperty");
        Function1<j, Object> r107 = d.f419619a.get(e.a(r101));
        if (r107 == null) goto L7;
        Object r108 = r107.invoke(r102);
    L8:
        Object r109 = r108;
        r103.put(r104, r109);
        return r109;
    L7:
        r108 = null;
        goto L8
    L10:
        return r105;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(j r100, KProperty r101, Object r102) {
        j r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        r103.getValues().put(e.a(r101), r102);
    }
}
