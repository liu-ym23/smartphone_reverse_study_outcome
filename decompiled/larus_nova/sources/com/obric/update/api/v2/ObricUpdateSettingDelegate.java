package com.obric.update.api.v2;

import coa.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/obric/update/api/v2/ObricUpdateSettingDelegate;", "Lcom/obric/update/api/v2/IObricUpdateSettingService;", "<init>", "()V", "service", "getService", "()Lcom/obric/update/api/v2/IObricUpdateSettingService;", "service$delegate", "Lkotlin/Lazy;", "isWiFiUpdateEnable", "", "setWifiUpdateEnable", "", "enable", "getLastCheckDate", "", "setLastCheckDate", "date", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateSettingDelegate implements IObricUpdateSettingService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricUpdateSettingDelegate f404037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f404038b = null;

    private ObricUpdateSettingDelegate() {
    }

    static {
        f404037a = new ObricUpdateSettingDelegate();
        f404038b = LazyKt.lazy(new b());
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final boolean a() {
        IObricUpdateSettingService r100 = (IObricUpdateSettingService) f404038b.getValue();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        return !r101;
    L5:
        if (r100.a() == true) goto L7;
        r101 = true;
        goto L9
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final String c() {
        IObricUpdateSettingService r100 = (IObricUpdateSettingService) f404038b.getValue();
        if (r100 == null) goto L6;
        String r101 = r100.c();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "date");
        IObricUpdateSettingService r101 = (IObricUpdateSettingService) f404038b.getValue();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final void d(boolean r100) {
        IObricUpdateSettingService r101 = (IObricUpdateSettingService) f404038b.getValue();
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }
}
