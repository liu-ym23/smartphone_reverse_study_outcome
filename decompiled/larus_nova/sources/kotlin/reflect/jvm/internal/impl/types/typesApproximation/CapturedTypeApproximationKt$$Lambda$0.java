package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;

/* JADX INFO: loaded from: classes42.dex */
class CapturedTypeApproximationKt$$Lambda$0 implements Function1 {
    public static final CapturedTypeApproximationKt$$Lambda$0 INSTANCE = null;

    static {
        INSTANCE = new CapturedTypeApproximationKt$$Lambda$0();
    }

    public CapturedTypeApproximationKt$$Lambda$0() {
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        return CapturedTypeApproximationKt.accessor$CapturedTypeApproximationKt$lambda0((DescriptorRendererOptions) r100);
    }
}
