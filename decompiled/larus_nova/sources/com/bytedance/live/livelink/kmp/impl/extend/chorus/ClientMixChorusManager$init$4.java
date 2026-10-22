package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lgi6/b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lgi6/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class ClientMixChorusManager$init$4 extends FunctionReferenceImpl implements Function1<gi6.b, Unit> {
    public ClientMixChorusManager$init$4(ClientMixChorusManager r100) {
        super(1, r100, ClientMixChorusManager.class, "onUpdateMixStream", "onUpdateMixStream(Lcom/bytedance/live/livelink/kmp/api/base/event/Event;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(gi6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ClientMixChorusManager r101 = (ClientMixChorusManager) this.receiver;
        if (r101.f255565a == true) goto L8;
        if (r101.a() == false) goto L8;
        r101.b();
        r101.f255565a = true;
    L8:
        if (r101.f255565a == true) goto L10;
        return;
    L10:
        if (r101.a() == true) goto L14;
        r101.f255565a = false;
        r101.d();
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(gi6.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
