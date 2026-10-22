package com.obric.assistant.spi.office;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import sga.b;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/spi/office/OfficeSdkLazyInitSettingsServiceDelegate;", "Lcom/obric/assistant/spi/office/IOfficeSdkLazyInitSettingsService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/obric/assistant/spi/office/IOfficeSdkLazyInitSettingsService;", "delegate$delegate", "Lkotlin/Lazy;", "isOfficeSdkLazyInitEnabled", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSdkLazyInitSettingsServiceDelegate implements IOfficeSdkLazyInitSettingsService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfficeSdkLazyInitSettingsServiceDelegate f392903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f392904b = null;

    private OfficeSdkLazyInitSettingsServiceDelegate() {
    }

    static {
        f392903a = new OfficeSdkLazyInitSettingsServiceDelegate();
        f392904b = LazyKt.lazy(new b());
    }

    @Override // com.obric.assistant.spi.office.IOfficeSdkLazyInitSettingsService
    public final boolean isOfficeSdkLazyInitEnabled() {
        IOfficeSdkLazyInitSettingsService r100 = (IOfficeSdkLazyInitSettingsService) f392904b.getValue();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isOfficeSdkLazyInitEnabled() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
