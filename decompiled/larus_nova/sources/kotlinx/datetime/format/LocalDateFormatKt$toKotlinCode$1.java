package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class LocalDateFormatKt$toKotlinCode$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final LocalDateFormatKt$toKotlinCode$1 INSTANCE = null;

    static {
        INSTANCE = new LocalDateFormatKt$toKotlinCode$1();
    }

    public LocalDateFormatKt$toKotlinCode$1() {
        super(1, guc.c.class, "toKotlinCode", "toKotlinCode(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return guc.c.a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
