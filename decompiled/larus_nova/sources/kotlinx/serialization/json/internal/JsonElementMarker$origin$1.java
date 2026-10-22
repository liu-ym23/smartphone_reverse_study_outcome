package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements Function2<luc.f, Integer, Boolean> {
    public JsonElementMarker$origin$1(Object r100) {
        super(2, r100, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public final Boolean invoke(luc.f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        JsonElementMarker r102 = (JsonElementMarker) this.receiver;
        r102.getClass();
        if (r100.i(r101) == false) goto L5;
    L7:
        boolean r103 = false;
    L8:
        r102.f505373b = r103;
        return Boolean.valueOf(r103);
    L5:
        if (r100.h(r101).a() == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(luc.f r100, Integer r101) {
        return invoke(r100, r101.intValue());
    }
}
