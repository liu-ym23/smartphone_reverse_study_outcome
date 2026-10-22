package com.obric.assistant.spi.launch;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import pga.a;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/spi/launch/ObricLazyInitSettingsServiceDelegate;", "Lcom/obric/assistant/spi/launch/IObricLazyInitSettingsService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/obric/assistant/spi/launch/IObricLazyInitSettingsService;", "delegate$delegate", "Lkotlin/Lazy;", "isIvyKitLazyInitEnabled", "", "isAppletLazyInitEnabled", "isTTVideoEngineLazyInitEnabled", "isLocalLifeLazyInitEnabled", "isECommerceLazyInitEnabled", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLazyInitSettingsServiceDelegate implements IObricLazyInitSettingsService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricLazyInitSettingsServiceDelegate f392888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f392889b = null;

    private ObricLazyInitSettingsServiceDelegate() {
    }

    static {
        f392888a = new ObricLazyInitSettingsServiceDelegate();
        f392889b = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.spi.launch.IObricLazyInitSettingsService
    public final boolean a() {
        IObricLazyInitSettingsService r100 = (IObricLazyInitSettingsService) f392889b.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.a() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.spi.launch.IObricLazyInitSettingsService
    public final boolean b() {
        IObricLazyInitSettingsService r100 = (IObricLazyInitSettingsService) f392889b.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.b() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.spi.launch.IObricLazyInitSettingsService
    public final boolean c() {
        IObricLazyInitSettingsService r100 = (IObricLazyInitSettingsService) f392889b.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.c() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.spi.launch.IObricLazyInitSettingsService
    public final boolean d() {
        IObricLazyInitSettingsService r100 = (IObricLazyInitSettingsService) f392889b.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.d() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.spi.launch.IObricLazyInitSettingsService
    public final boolean e() {
        IObricLazyInitSettingsService r100 = (IObricLazyInitSettingsService) f392889b.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.e() != true) goto L7;
        return true;
    }
}
