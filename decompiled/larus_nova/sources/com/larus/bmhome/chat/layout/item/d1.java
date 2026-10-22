package com.larus.bmhome.chat.layout.item;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
public final class d1 implements Function0<va8.x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AttachReceiver f304291a;

    public d1(AttachReceiver r100) {
        this.f304291a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.x] */
    @Override // kotlin.jvm.functions.Function0
    public final va8.x invoke() {
        AttachReceiver r100 = this.f304291a;
        if ((r100 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.x.class));
    }
}
