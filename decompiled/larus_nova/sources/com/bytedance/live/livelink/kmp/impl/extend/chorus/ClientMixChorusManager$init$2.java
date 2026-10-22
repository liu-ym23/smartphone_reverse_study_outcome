package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lgi6/b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lgi6/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class ClientMixChorusManager$init$2 extends FunctionReferenceImpl implements Function1<gi6.b, Unit> {
    public ClientMixChorusManager$init$2(ClientMixChorusManager r100) {
        super(1, r100, ClientMixChorusManager.class, "onClientMixedDataFrame", "onClientMixedDataFrame(Lcom/bytedance/live/livelink/kmp/api/base/event/Event;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(gi6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        final ClientMixChorusManager r101 = (ClientMixChorusManager) this.receiver;
        if (Intrinsics.areEqual(r101.f255572h.k(), zi6.a.d.f572255a) == true) goto L25;
        HashMap<String, Object> r102 = r100.f481421c;
        if (r102 == null) goto L26;
        Object r103 = r102.get("dataFrame");
        if ((r103 instanceof byte[]) == true) goto L11;
        r103 = null;
    L11:
        final byte[] r104 = (byte[]) r103;
        if (r104 != null) goto L15;
        return;
    L15:
        if (r104.length != 0) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == true) goto L28;
        oi6.b r106 = r101.f255568d;
        if (r106 == null) goto L24;
        oi6.a.a(r106, new ClientMixChorusManager$onClientMixedDataFrame$1(r101, r104), "ClientMixChorusManager onClientMixedDataFrame");
        return;
    L24:
        return;
    L28:
        return;
    L17:
        r105 = false;
        goto L18
    L26:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(gi6.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
