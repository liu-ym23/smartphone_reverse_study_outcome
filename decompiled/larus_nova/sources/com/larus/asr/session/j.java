package com.larus.asr.session;

import com.larus.im.bean.message.Message;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class j implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentAsrSession f287894a;

    public /* synthetic */ j(ComponentAsrSession r100) {
        this.f287894a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        ComponentAsrSession r101 = this.f287894a;
        Message r102 = (Message) r100;
        Intrinsics.checkNotNullParameter(r102, "message");
        Iterator<T> r103 = r101.d().iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        ((com.larus.asr.session.component.o0) r103.next()).j(r102);
        goto L4
    L7:
        return Unit.INSTANCE;
    }
}
