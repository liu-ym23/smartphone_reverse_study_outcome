package kotlinx.datetime.internal.format;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class OptionalFormatStructure$formatter$2 extends FunctionReferenceImpl implements Function1<Object, Boolean> {
    public OptionalFormatStructure$formatter$2(Object r100) {
        super(1, r100, v.class, EffectConstants.CHANNEL_TEST, "test(Ljava/lang/Object;)Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object r100) {
        ((v) this.receiver).getClass();
        return Boolean.TRUE;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100) {
        return invoke(r100);
    }
}
