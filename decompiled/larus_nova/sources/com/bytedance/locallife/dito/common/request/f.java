package com.bytedance.locallife.dito.common.request;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends Converter.Factory {
    public f() {
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<TypedInput, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "annotations");
        Intrinsics.checkNotNullParameter(r102, "retrofit");
        if ((r100 instanceof Class) == false) goto L5;
        Class r103 = (Class) r100;
    L6:
        if (r103 != null) goto L9;
        return null;
    L9:
        if (k.class.isAssignableFrom(r103) == true) goto L12;
        return null;
    L12:
        return new g();
    L5:
        r103 = null;
        goto L6
    }
}
