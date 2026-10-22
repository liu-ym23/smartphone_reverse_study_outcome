package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.relax.runtime.gen.GlobalEventCallback;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RelaxPage$on$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ long $id;
    final /* synthetic */ RelaxPage this$0;

    public RelaxPage$on$2(RelaxPage r100, String r101, long r102) {
        this.this$0 = r100;
        this.$eventName = r101;
        this.$id = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        RelaxInstance r100 = this.this$0.f404903c;
        if (r100 == null) goto L10;
        com.relax.relaxframework.utils.a r101 = r100.getGlobalEventEmitter();
        if (r101 == null) goto L11;
        String r102 = this.$eventName;
        long r103 = this.$id;
        Intrinsics.checkNotNullParameter(r102, "eventName");
        Map r104 = (Map) ((LinkedHashMap) r101.f405299a).get(r102);
        if (r104 == null) goto L12;
        GlobalEventCallback r105 = (GlobalEventCallback) r104.remove(Long.valueOf(r103));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
