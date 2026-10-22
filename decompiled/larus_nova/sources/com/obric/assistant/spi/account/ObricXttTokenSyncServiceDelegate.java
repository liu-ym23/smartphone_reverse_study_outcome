package com.obric.assistant.spi.account;

import gga.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/spi/account/ObricXttTokenSyncServiceDelegate;", "Lcom/obric/assistant/spi/account/IObricXttTokenSyncService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/obric/assistant/spi/account/IObricXttTokenSyncService;", "delegate$delegate", "Lkotlin/Lazy;", "updateXttTokenSnapshot", "", "token", "", "userId", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricXttTokenSyncServiceDelegate implements IObricXttTokenSyncService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricXttTokenSyncServiceDelegate f392814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f392815b = null;

    private ObricXttTokenSyncServiceDelegate() {
    }

    static {
        f392814a = new ObricXttTokenSyncServiceDelegate();
        f392815b = LazyKt.lazy(new b());
    }

    @Override // com.obric.assistant.spi.account.IObricXttTokenSyncService
    public final void a(String r100, String r101) {
        ((IObricXttTokenSyncService) f392815b.getValue()).a(r100, r101);
    }
}
