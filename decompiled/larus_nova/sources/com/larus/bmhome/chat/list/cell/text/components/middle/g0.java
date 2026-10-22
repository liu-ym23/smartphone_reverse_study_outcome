package com.larus.bmhome.chat.list.cell.text.components.middle;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
public final class g0 implements Function0<u29.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AttachReceiver f306263a;

    public g0(AttachReceiver r100) {
        this.f306263a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, u29.b] */
    @Override // kotlin.jvm.functions.Function0
    public final u29.b invoke() {
        AttachReceiver r100 = this.f306263a;
        if ((r100 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(u29.b.class));
    }
}
