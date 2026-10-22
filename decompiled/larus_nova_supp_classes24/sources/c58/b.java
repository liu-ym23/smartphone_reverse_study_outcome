package c58;

import com.larus.asr.direct.AsrDirectFillComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ AsrDirectFillComponent a;

    public /* synthetic */ b(AsrDirectFillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        AsrDirectFillComponent r0 = this.a;
        ((Boolean) r2).booleanValue();
        r0.s = false;
        return Unit.INSTANCE;
    }
}
