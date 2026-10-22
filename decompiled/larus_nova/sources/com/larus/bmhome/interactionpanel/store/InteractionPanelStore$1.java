package com.larus.bmhome.interactionpanel.store;

import com.larus.platform.service.AccountService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class InteractionPanelStore$1 extends FunctionReferenceImpl implements Function0<String> {
    public InteractionPanelStore$1(Object r100) {
        super(0, r100, AccountService.class, "getUserId", "getUserId()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return ((AccountService) this.receiver).getUserId();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
