package kotlinx.datetime.internal.format;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class SignedFormatStructure$formatter$1<T> extends FunctionReferenceImpl implements Function1<T, Boolean> {
    final /* synthetic */ SignedFormatStructure<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public SignedFormatStructure$formatter$1(SignedFormatStructure<? super T> r100) {
        this.this$0 = r100;
        super(1, Intrinsics.Kotlin.class, "checkIfAllNegative", "formatter$checkIfAllNegative(Lkotlinx/datetime/internal/format/SignedFormatStructure;Ljava/lang/Object;)Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(T r100) {
        Iterator<l<T>> r101 = this.this$0.f505272c.iterator();
        boolean r102 = false;
        boolean r103 = false;
    L4:
        if (r101.hasNext() == false) goto L11;
        l<T> r104 = r101.next();
        if (Intrinsics.areEqual(r104.a().b(r100), Boolean.TRUE) == true) goto L7;
        if (r104.b(r100) == true) goto L4;
    L13:
        return Boolean.valueOf(r102);
    L7:
        r103 = true;
        goto L4
    L11:
        r102 = r103;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100) {
        return invoke(r100);
    }
}
