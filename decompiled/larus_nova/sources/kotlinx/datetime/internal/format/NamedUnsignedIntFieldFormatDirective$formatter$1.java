package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Target] */
/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class NamedUnsignedIntFieldFormatDirective$formatter$1<Target> extends FunctionReferenceImpl implements Function1<Target, String> {
    public NamedUnsignedIntFieldFormatDirective$formatter$1(Object r100) {
        super(1, r100, NamedUnsignedIntFieldFormatDirective.class, "getStringValue", "getStringValue(Ljava/lang/Object;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Target r100) {
        NamedUnsignedIntFieldFormatDirective r101 = (NamedUnsignedIntFieldFormatDirective) this.receiver;
        int r102 = r101.f505260a.f505359a.a(r100).intValue();
        String r103 = (String) CollectionsKt.getOrNull(r101.f505261b, r102 - r101.f505260a.f505360b);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return "The value " + r102 + " of " + r101.f505260a.f505362d + " does not have a corresponding string representation";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Object r100) {
        return invoke2(r100);
    }
}
