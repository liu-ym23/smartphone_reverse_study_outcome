package org.koin.core.scope;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "org/koin/core/scope/Scope$inject$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Scope$inject$$inlined$inject$default$1 extends Lambda implements Function0 {
    final /* synthetic */ Function0 $parameters;
    final /* synthetic */ mwc.a $qualifier;
    final /* synthetic */ Scope this$0;

    public Scope$inject$$inlined$inject$default$1(Scope r100, mwc.a r101, Function0 r102) {
        this.this$0 = r100;
        this.$qualifier = r101;
        this.$parameters = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Scope r100 = this.this$0;
        mwc.a r101 = this.$qualifier;
        Function0<? extends lwc.a> r102 = this.$parameters;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return r100.c(Reflection.getOrCreateKotlinClass(Object.class), r101, r102);
    }
}
