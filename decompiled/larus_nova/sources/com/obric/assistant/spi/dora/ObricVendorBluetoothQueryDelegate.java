package com.obric.assistant.spi.dora;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import lga.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/spi/dora/ObricVendorBluetoothQueryDelegate;", "Lcom/obric/assistant/spi/dora/IObricVendorBluetoothQueryService;", "<init>", "()V", "queryVendorBluetoothSppStatus", "Lcom/obric/assistant/spi/dora/VendorBluetoothSppStatus;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVendorBluetoothQueryDelegate implements IObricVendorBluetoothQueryService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricVendorBluetoothQueryDelegate f392874b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricVendorBluetoothQueryService f392875a;

    static {
        f392874b = new ObricVendorBluetoothQueryDelegate();
    }

    @Override // com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService
    public final a a() {
        return this.f392875a.a();
    }

    private ObricVendorBluetoothQueryDelegate() {
        IObricVendorBluetoothQueryService r100 = (IObricVendorBluetoothQueryService) ServiceManager.get().getService(IObricVendorBluetoothQueryService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricVendorBluetoothQueryServiceImpl();
    L5:
        this.f392875a = r100;
    }
}
