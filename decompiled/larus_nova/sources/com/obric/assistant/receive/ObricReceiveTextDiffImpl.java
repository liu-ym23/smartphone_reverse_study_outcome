package com.obric.assistant.receive;

import com.larus.receive.contract.IReceiveTextDiff;
import com.larus.receive.contract.ReceiveTextDelivery;
import com.larus.receive.contract.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/receive/ObricReceiveTextDiffImpl;", "Lcom/larus/receive/contract/IReceiveTextDiff;", "<init>", "()V", "resolveTextShare", "Lcom/larus/receive/contract/ReceiveTextDecision;", "request", "Lcom/larus/receive/contract/ReceiveTextRequest;", "o_receive_extension_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricReceiveTextDiffImpl implements IReceiveTextDiff {
    public ObricReceiveTextDiffImpl() {
    }

    @Override // com.larus.receive.contract.IReceiveTextDiff
    public final a a(ps9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (Intrinsics.areEqual(r100.f530469a, "android.intent.action.SEND") == false) goto L19;
        String r101 = r100.f530470b;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L19;
        if (r100.f530471c == false) goto L19;
        if (r100.f530472d == false) goto L17;
        return a.b.f367371a;
    L17:
        return new a.C4480a(ReceiveTextDelivery.FILL_INPUT);
    L7:
        if (StringsKt.startsWith$default(r101, "text/", false, 2, null) != true) goto L9;
        r102 = true;
    L19:
        return a.b.f367371a;
    }
}
