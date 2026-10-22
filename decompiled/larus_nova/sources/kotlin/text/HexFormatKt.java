package kotlin.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"HexFormat", "Lkotlin/text/HexFormat;", "builderAction", "Lkotlin/Function1;", "Lkotlin/text/HexFormat$Builder;", "", "Lkotlin/ExtensionFunctionType;", "isCaseSensitive", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class HexFormatKt {
    private static final HexFormat HexFormat(Function1<? super HexFormat.Builder, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        HexFormat.Builder r101 = new HexFormat.Builder();
        r100.invoke(r101);
        return r101.build();
    }

    public static final /* synthetic */ boolean access$isCaseSensitive(String r100) {
        return isCaseSensitive(r100);
    }

    private static final boolean isCaseSensitive(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length()) goto L18;
        char r102 = r100.charAt(r101);
        if (Intrinsics.compare(r102, 128) < 0) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L13;
        r101 = r101 + 1;
        goto L4
    L13:
        return true;
    L8:
        if (Character.isLetter(r102) == true) goto L11;
        r103 = false;
        goto L12
    L18:
        return false;
    }
}
