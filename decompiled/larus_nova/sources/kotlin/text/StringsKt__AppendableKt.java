package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u0002H\u00012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\b\u001a\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a\u001f\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a7\u0010\u0010\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"append", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendLine", "", "appendRange", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__AppendableKt {
    public StringsKt__AppendableKt() {
    }

    private static final Appendable appendLine(Appendable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.append('\n');
    }

    public static final <T extends Appendable> T append(T r100, CharSequence... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.append(r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    private static final Appendable appendLine(Appendable r100, char r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.append(r101).append('\n');
    }

    private static final Appendable appendLine(Appendable r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.append(r101).append('\n');
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void appendElement(Appendable r100, T r101, Function1<? super T, ? extends CharSequence> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 == null) goto L5;
        r100.append(r102.invoke(r101));
        return;
    L5:
        if (r101 != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L11;
        r100.append((CharSequence) r101);
        return;
    L11:
        if ((r101 instanceof Character) == false) goto L13;
        r100.append(((Character) r101).charValue());
        return;
    L13:
        r100.append(String.valueOf(r101));
        return;
    L7:
        r103 = r101 instanceof CharSequence;
        goto L8
    }

    public static final <T extends Appendable> T appendRange(T r100, CharSequence r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        T r104 = (T) r100.append(r101, r102, r103);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return r104;
    }
}
