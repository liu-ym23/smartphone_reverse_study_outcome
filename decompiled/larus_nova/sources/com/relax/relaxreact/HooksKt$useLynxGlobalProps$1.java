package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<no name provided>", "Lkotlin/Function0;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class HooksKt$useLynxGlobalProps$1 extends Lambda implements Function0<Function0<? extends Unit>> {
    final /* synthetic */ k0 $lynx;
    final /* synthetic */ l1<Map<String, Object>> $setGlobalProps;

    public HooksKt$useLynxGlobalProps$1(k0 r100, l1<Map<String, Object>> r101) {
        this.$lynx = r100;
        this.$setGlobalProps = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Function0<? extends Unit> invoke2() {
        m0 r100 = this.$lynx.f405537b;
        final EventEmitter r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("GlobalEventEmitter");
        r100 = null;
    L6:
        EventEmitter r102 = r100.f405549a;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
    L10:
        final l1<Map<String, Object>> r103 = this.$setGlobalProps;
        final Function1<Map<String, Object>, Unit> r104 = new HooksKt$useLynxGlobalProps$1$listener$1(r103);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r104, "listener");
        r101.c("__UpdateGlobalProps", ContextType.kEngine.getValue());
        r101.a("__UpdateGlobalProps", r104);
        return new AnonymousClass1(r101, r104);
    L9:
        r101 = r102;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Function0<? extends Unit> invoke() {
        return invoke2();
    }
}
