package kotlin;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"UByteArray", "Lkotlin/UByteArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/UByte;", "(ILkotlin/jvm/functions/Function1;)[B", "ubyteArrayOf", SlcElement.KEY_ELEMENTS, "ubyteArrayOf-GBYM_sE", "([B)[B", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UByteArrayKt {
    /* JADX INFO: renamed from: ubyteArrayOf-GBYM_sE, reason: not valid java name */
    private static final byte[] m9536ubyteArrayOfGBYM_sE(byte... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return r100;
    }

    private static final byte[] UByteArray(int r100, Function1<? super Integer, UByte> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        byte[] r102 = new byte[r100];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L6;
        r102[r103] = r101.invoke(Integer.valueOf(r103)).m9517unboximpl();
        r103 = r103 + 1;
        goto L3
    L6:
        return UByteArray.m9520constructorimpl(r102);
    }
}
