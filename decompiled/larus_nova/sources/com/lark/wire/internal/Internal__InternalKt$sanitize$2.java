package com.lark.wire.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class Internal__InternalKt$sanitize$2 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final Internal__InternalKt$sanitize$2 INSTANCE = null;

    static {
        INSTANCE = new Internal__InternalKt$sanitize$2();
    }

    public Internal__InternalKt$sanitize$2() {
        super(1, b.class, "sanitize", "sanitize(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r100, "value");
        StringBuilder r101 = new StringBuilder(r100.length());
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L10;
        char r103 = r100.charAt(r102);
        if (StringsKt.contains$default(",[]{}\\", r103, false, 2, null) == false) goto L8;
        r101.append('\\');
    L8:
        r101.append(r103);
        r102 = r102 + 1;
        goto L4
    L10:
        return r101.toString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
