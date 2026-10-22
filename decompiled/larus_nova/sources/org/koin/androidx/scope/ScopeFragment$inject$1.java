package org.koin.androidx.scope;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import mwc.a;
import org.koin.core.scope.Scope;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Object;"}, k = 3, mv = {1, 1, 18})
public final class ScopeFragment$inject$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Function0 $parameters;
    final /* synthetic */ a $qualifier;
    final /* synthetic */ org.koin.core.scope.a $this_inject;
    final /* synthetic */ ScopeFragment this$0;

    public ScopeFragment$inject$1(ScopeFragment r100, org.koin.core.scope.a r101, a r102, Function0 r103) {
        this.this$0 = r100;
        this.$this_inject = r101;
        this.$qualifier = r102;
        this.$parameters = r103;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        org.koin.core.scope.a r100 = this.$this_inject;
        a r101 = this.$qualifier;
        Function0<? extends lwc.a> r102 = this.$parameters;
        Scope r103 = r100.getScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return r103.c(Reflection.getOrCreateKotlinClass(Object.class), r101, r102);
    }
}
