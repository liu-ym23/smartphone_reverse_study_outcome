package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import androidx.collection.SparseArrayCompat;
import com.ss.android.lark.profile.v2.entity.BaseField;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class BaseFieldHandlers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f414375a = null;

    static {
        f414375a = LazyKt.lazy(BaseFieldHandlers$fieldHandlers$2.INSTANCE);
    }

    public static String a(BaseField r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Function1 r101 = (Function1) ((SparseArrayCompat) f414375a.getValue()).get(r100.getFieldType());
        if (r101 != null) goto L7;
        return null;
    L7:
        return (String) r101.invoke(r100);
    }
}
