package kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, d2 = {"lazy", "Lkotlin/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/LazyKt")
class LazyKt__LazyJVMKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[LazyThreadSafetyMode.values().length];
            r100[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LazyThreadSafetyMode.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public LazyKt__LazyJVMKt() {
    }

    public static <T> Lazy<T> lazy(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        DefaultConstructorMarker r101 = null;
        return new SynchronizedLazyImpl(r100, r101, 2, r101);
    }

    public static <T> Lazy<T> lazy(LazyThreadSafetyMode r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, "initializer");
        int r102 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        int r103 = 2;
        if (r102 == 1) goto L11;
        if (r102 == 2) goto L14;
        if (r102 != 3) goto L9;
        return new UnsafeLazyImpl(r101);
    L9:
        throw new NoWhenBranchMatchedException();
    L14:
        return new SafePublicationLazyImpl(r101);
    L11:
        DefaultConstructorMarker r104 = null;
        return new SynchronizedLazyImpl(r101, r104, r103, r104);
    }

    public static <T> Lazy<T> lazy(Object r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "initializer");
        return new SynchronizedLazyImpl(r101, r100);
    }
}
