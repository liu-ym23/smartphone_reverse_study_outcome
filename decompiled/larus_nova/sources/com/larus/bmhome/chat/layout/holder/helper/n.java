package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes25.dex */
public final class n implements Function0<u7> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AttachReceiver f303667a;

    public n(AttachReceiver r100) {
        this.f303667a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.list.u7, t1a.a] */
    @Override // kotlin.jvm.functions.Function0
    public final u7 invoke() {
        AttachReceiver r100 = this.f303667a;
        if ((r100 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(u7.class));
    }
}
