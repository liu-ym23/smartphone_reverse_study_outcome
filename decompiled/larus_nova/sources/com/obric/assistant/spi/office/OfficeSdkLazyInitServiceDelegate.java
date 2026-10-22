package com.obric.assistant.spi.office;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import sga.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/obric/assistant/spi/office/OfficeSdkLazyInitServiceDelegate;", "Lcom/obric/assistant/spi/office/IOfficeSdkLazyInitService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/obric/assistant/spi/office/IOfficeSdkLazyInitService;", "delegate$delegate", "Lkotlin/Lazy;", "tryInitOnUiEntry", "", "tryInitOnFirstFeedShown", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSdkLazyInitServiceDelegate implements IOfficeSdkLazyInitService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfficeSdkLazyInitServiceDelegate f392901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f392902b = null;

    private OfficeSdkLazyInitServiceDelegate() {
    }

    static {
        f392901a = new OfficeSdkLazyInitServiceDelegate();
        f392902b = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.spi.office.IOfficeSdkLazyInitService
    public final void a() {
        IOfficeSdkLazyInitService r100 = (IOfficeSdkLazyInitService) f392902b.getValue();
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.obric.assistant.spi.office.IOfficeSdkLazyInitService
    public final boolean b() {
        IOfficeSdkLazyInitService r100 = (IOfficeSdkLazyInitService) f392902b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.b();
    }
}
