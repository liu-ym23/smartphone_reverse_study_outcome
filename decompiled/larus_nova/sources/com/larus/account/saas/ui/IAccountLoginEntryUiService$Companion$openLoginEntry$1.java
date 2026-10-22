package com.larus.account.saas.ui;

import b48.e;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import x38.d;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "service", "Lcom/larus/account/saas/ui/IAccountLoginEntryUiService;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/larus/account/saas/ui/IAccountLoginEntryUiService;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class IAccountLoginEntryUiService$Companion$openLoginEntry$1 extends Lambda implements Function1<IAccountLoginEntryUiService, Boolean> {
    final /* synthetic */ d $callback;
    final /* synthetic */ e $context;

    public IAccountLoginEntryUiService$Companion$openLoginEntry$1(e r100, d r101) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(IAccountLoginEntryUiService r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        return Boolean.valueOf(r100.a());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(IAccountLoginEntryUiService r100) {
        return invoke2(r100);
    }
}
