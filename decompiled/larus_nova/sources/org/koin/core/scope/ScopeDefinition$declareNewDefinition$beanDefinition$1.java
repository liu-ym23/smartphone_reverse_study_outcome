package org.koin.core.scope;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/koin/core/scope/Scope;", "Llwc/a;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ScopeDefinition$declareNewDefinition$beanDefinition$1 extends Lambda implements Function2<Scope, lwc.a, Object> {
    final /* synthetic */ Object $instance;

    public ScopeDefinition$declareNewDefinition$beanDefinition$1(Object r100) {
        this.$instance = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Scope r100, lwc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$createSingle");
        Intrinsics.checkNotNullParameter(r101, "it");
        return this.$instance;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Scope r100, lwc.a r101) {
        return invoke2(r100, r101);
    }
}
