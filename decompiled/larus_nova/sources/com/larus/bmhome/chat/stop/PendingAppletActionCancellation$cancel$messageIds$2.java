package com.larus.bmhome.chat.stop;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PendingAppletActionCancellation$cancel$messageIds$2 extends FunctionReferenceImpl implements Function1<String, String> {
    public PendingAppletActionCancellation$cancel$messageIds$2(Object r100) {
        super(1, r100, PendingAppletActionCancellation.class, "normalizeIdentifier", "normalizeIdentifier(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        PendingAppletActionCancellation r101 = (PendingAppletActionCancellation) this.receiver;
        PendingAppletActionCancellation r102 = PendingAppletActionCancellation.f309941a;
        r101.getClass();
        return PendingAppletActionCancellation.e(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
