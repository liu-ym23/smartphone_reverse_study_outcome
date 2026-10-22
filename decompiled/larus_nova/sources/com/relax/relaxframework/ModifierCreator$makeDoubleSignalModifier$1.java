package com.relax.relaxframework;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/relax/relaxframework/p6;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/relax/relaxframework/y3;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/relax/relaxframework/y3;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class ModifierCreator$makeDoubleSignalModifier$1 extends Lambda implements Function0<y3> {
    final /* synthetic */ Function0<Double> $value;

    public ModifierCreator$makeDoubleSignalModifier$1(Function0<Double> r100) {
        this.$value = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final y3 invoke() {
        int r100 = y3.f405359e;
        double r101 = this.$value.invoke().doubleValue();
        y3 r102 = new y3(PropertyValueType.DOUBLE);
        r102.f405318c = r101;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ y3 invoke() {
        return invoke();
    }
}
