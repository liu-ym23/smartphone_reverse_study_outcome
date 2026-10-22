package io.github.alexzhirkevich.compottie;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class LottiePainter$progress$2 extends FunctionReferenceImpl implements Function0<Float> {
    public LottiePainter$progress$2(Object r100) {
        super(0, r100, Function0.class, AbsMethodDelegate.TAG_INVOKE, "invoke()Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Float invoke() {
        return (Float) ((Function0) this.receiver).invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Float invoke() {
        return invoke();
    }
}
