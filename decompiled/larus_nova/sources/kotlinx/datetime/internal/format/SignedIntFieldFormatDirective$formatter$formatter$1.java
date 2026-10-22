package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Target] */
/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class SignedIntFieldFormatDirective$formatter$formatter$1<Target> extends FunctionReferenceImpl implements Function1<Target, Integer> {
    public SignedIntFieldFormatDirective$formatter$formatter$1(Object r100) {
        super(1, r100, b.class, "getterNotNull", "getterNotNull(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(Target r100) {
        return (Integer) ((b) this.receiver).a(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object r100) {
        return invoke(r100);
    }
}
