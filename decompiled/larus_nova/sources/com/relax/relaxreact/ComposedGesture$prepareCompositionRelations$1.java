package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "gesture", "Lcom/relax/relaxreact/BaseGesture;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ComposedGesture$prepareCompositionRelations$1 extends Lambda implements Function1<BaseGesture, Unit> {
    final /* synthetic */ Map<Integer, Map<String, ArrayList<BaseGesture>>> $collectedRelations;

    public ComposedGesture$prepareCompositionRelations$1(Map<Integer, Map<String, ArrayList<BaseGesture>>> r100) {
        this.$collectedRelations = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BaseGesture r100) {
        Intrinsics.checkNotNullParameter(r100, "gesture");
        Map r101 = (Map) com.bytedance.rts.kmp.foundation.j.c(this.$collectedRelations, Integer.valueOf(r100.f405383a));
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        ArrayList<BaseGesture> r102 = (ArrayList) r101.get("simultaneous");
        if (r102 == null) goto L6;
    L8:
        if (r101 == null) goto L11;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        ArrayList<BaseGesture> r103 = (ArrayList) r101.get("waitFor");
        if (r103 == null) goto L11;
    L12:
        ArrayList<BaseGesture> r104 = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        Intrinsics.checkNotNullParameter(r102, "simultaneousWith");
        Intrinsics.checkNotNullParameter(r103, "waitFor");
        Intrinsics.checkNotNullParameter(r104, "continueWith");
        r100.c("simultaneous", r102);
        r100.c("waitFor", r103);
        r100.c("continueWith", r104);
        return;
    L11:
        r103 = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
    L6:
        r102 = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        goto L8
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BaseGesture r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
