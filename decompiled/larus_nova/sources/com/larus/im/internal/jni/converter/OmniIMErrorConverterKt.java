package com.larus.im.internal.jni.converter;

import com.larus.im.callback.IMError;
import com.larus.im.internal.jni.bean.OmniIMError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toIMError", "Lcom/larus/im/callback/IMError;", "Lcom/larus/im/internal/jni/bean/OmniIMError;", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OmniIMErrorConverterKt {
    public static final IMError toIMError(OmniIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new IMError(r100.code, r100.tips, null, r100.ext);
    }
}
