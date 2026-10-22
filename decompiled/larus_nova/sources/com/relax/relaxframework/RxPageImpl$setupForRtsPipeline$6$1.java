package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RxPageImpl$setupForRtsPipeline$6$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ int $gestureId;
    final /* synthetic */ Object $params;
    final /* synthetic */ Ref.ObjectRef<RxElementImpl> $target;

    public RxPageImpl$setupForRtsPipeline$6$1(Ref.ObjectRef<RxElementImpl> r100, int r101, String r102, Object r103) {
        this.$target = r100;
        this.$gestureId = r101;
        this.$eventName = r102;
        this.$params = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        RxElementImpl r100 = this.$target.element;
        Intrinsics.checkNotNull(r100);
        RxElementImpl r101 = r100;
        int r102 = this.$gestureId;
        String r103 = this.$eventName;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        Object r104 = this.$params;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, "eventName");
        Intrinsics.checkNotNullParameter(r104, "params");
        Map<Integer, BaseGesture> r105 = r101.f404933v;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        BaseGesture r107 = (BaseGesture) r106.get(Integer.valueOf(r102));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
