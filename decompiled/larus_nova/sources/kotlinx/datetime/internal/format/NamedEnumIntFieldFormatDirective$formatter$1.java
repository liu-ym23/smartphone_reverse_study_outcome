package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Target] */
/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class NamedEnumIntFieldFormatDirective$formatter$1<Target> extends FunctionReferenceImpl implements Function1<Target, String> {
    public NamedEnumIntFieldFormatDirective$formatter$1(Object r100) {
        super(1, r100, NamedEnumIntFieldFormatDirective.class, "getStringValue", "getStringValue(Ljava/lang/Object;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Target r100) {
        ((NamedEnumIntFieldFormatDirective) this.receiver).getClass();
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Object r100) {
        return invoke2(r100);
    }
}
