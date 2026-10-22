package com.larus.bmhome.chat.layout.item;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
public final class c1 implements Function0<va8.p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AttachReceiver f304273a;

    public c1(AttachReceiver r100) {
        this.f304273a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.p] */
    @Override // kotlin.jvm.functions.Function0
    public final va8.p invoke() {
        AttachReceiver r100 = this.f304273a;
        if ((r100 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.p.class));
    }
}
