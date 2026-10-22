package org.koin.core.scope;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class KoinScopeComponentKt$inject$1 extends Lambda implements Function0 {
    final /* synthetic */ Function0<lwc.a> $parameters;
    final /* synthetic */ mwc.a $qualifier;
    final /* synthetic */ a $this_inject;

    /* JADX WARN: Multi-variable type inference failed */
    public KoinScopeComponentKt$inject$1(a r100, mwc.a r101, Function0<? extends lwc.a> r102) {
        this.$this_inject = r100;
        this.$qualifier = r101;
        this.$parameters = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        a r100 = this.$this_inject;
        mwc.a r101 = this.$qualifier;
        Function0<lwc.a> r102 = this.$parameters;
        Scope r103 = r100.getScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return r103.c(Reflection.getOrCreateKotlinClass(Object.class), r101, r102);
    }
}
