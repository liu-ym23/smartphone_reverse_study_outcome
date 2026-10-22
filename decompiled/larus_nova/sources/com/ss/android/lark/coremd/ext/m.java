package com.ss.android.lark.coremd.ext;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class m<T> implements ReadWriteProperty<j, T> {
    public m() {
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object r100, KProperty r101) {
        j r102 = (j) r100;
        Intrinsics.checkNotNullParameter(r102, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Object r103 = r102.getValues().get(e.a(r101));
        if (r103 != null) goto L6;
        return null;
    L6:
        return r103;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(j r100, KProperty r101, Object r102) {
        j r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        r103.getValues().put(e.a(r101), r102);
    }
}
