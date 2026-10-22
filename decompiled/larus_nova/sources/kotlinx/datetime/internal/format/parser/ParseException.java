package kotlinx.datetime.internal.format.parser;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0002j\u0002`\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/datetime/internal/format/parser/ParseException;", "Lkotlin/Exception;", "Ljava/lang/Exception;", "errors", "", "Lkotlinx/datetime/internal/format/parser/ParseError;", "<init>", "(Ljava/util/List;)V", "kotlinx-datetime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParseException extends Exception {
    public ParseException(List<k> r110) {
        Intrinsics.checkNotNullParameter(r110, "errors");
        if (r110.size() != 1) goto L5;
        String r111 = "Position " + ((k) ListProtector.get(r110, 0)).f505332a + ": " + ((k) ListProtector.get(r110, 0)).f505333b.invoke();
    L6:
        super(r111);
        return;
    L5:
        r111 = ((StringBuilder) CollectionsKt.joinTo$default(r110, new StringBuilder(r110.size() * 33), ", ", "Errors: ", null, 0, null, new p(), 56, null)).toString();
        goto L6
    }
}
