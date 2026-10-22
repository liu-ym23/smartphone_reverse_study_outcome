package com.bytedance.ee.bear.office.list.adapter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OfficeDocumentAdapter$visibleThumbnailLoader$2 extends FunctionReferenceImpl implements Function4<String, Integer, Integer, String, Unit> {
    public OfficeDocumentAdapter$visibleThumbnailLoader$2(Object r8) {
        super(4, r8, OfficeDocumentAdapter.class, "notifyVisibleThumbnailReady", "notifyVisibleThumbnailReady(Ljava/lang/String;IILjava/lang/String;)V", 0);
    }

    public final void invoke(String r9, int r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        Intrinsics.checkNotNullParameter(r12, "p3");
        OfficeDocumentAdapter r2 = (OfficeDocumentAdapter) ((CallableReference) this).receiver;
        r2.n.post(new g(r2, r9, r10, r11, r12));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((String) r1, ((Number) r2).intValue(), ((Number) r3).intValue(), (String) r4);
        return Unit.INSTANCE;
    }
}
