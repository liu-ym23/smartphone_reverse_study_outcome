package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.js.string;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class JsStringContext$interpret$2 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final JsStringContext$interpret$2 INSTANCE = null;

    static {
        INSTANCE = new JsStringContext$interpret$2();
    }

    public JsStringContext$interpret$2() {
        super(1, StringsKt.class, "uppercase", "uppercase(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return r100.toUpperCase(Locale.ROOT);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
