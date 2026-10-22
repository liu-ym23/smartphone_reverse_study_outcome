package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "node", "Lcom/relax/relaxreact/SnapshotInstance;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class SnapshotInstance$detachBindingsRecursively$1 extends Lambda implements Function1<SnapshotInstance, Unit> {
    final /* synthetic */ z0 $renderer;

    public SnapshotInstance$detachBindingsRecursively$1(z0 r100) {
        this.$renderer = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SnapshotInstance r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        final z0 r101 = this.$renderer;
        com.bytedance.rts.kmp.foundation.j.b(r100.f405447k, new SnapshotInstance$__unmountEventListeners$1(r101));
        Map<String, r> r102 = r100.f405447k;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        ((LinkedHashMap) r102).clear();
        final z0 r103 = this.$renderer;
        ArrayList<p> r104 = r100.f405441e;
        if (r104 == null) goto L6;
        Intrinsics.checkNotNull(r104);
        com.bytedance.rts.kmp.foundation.i.c(r104, new SnapshotInstance$__unmountGestures$1(r103));
    L6:
        com.bytedance.rts.kmp.foundation.j.b(r100.f405448l, SnapshotInstance$__unmountRefs$1.INSTANCE);
        r100.f405448l = new LinkedHashMap();
        new LinkedHashMap();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SnapshotInstance r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
