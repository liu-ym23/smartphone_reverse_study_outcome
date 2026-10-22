package com.obric.assistant.common.spi.settings;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h37.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/common/spi/settings/ObricSettingRequestDelegate;", "Lcom/obric/assistant/common/spi/settings/IObricSettingRequestService;", "<init>", "()V", "overrideByObricSettings", "Lorg/json/JSONObject;", "appSettings", "overrideSettingResponse", "", "response", "", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSettingRequestDelegate implements IObricSettingRequestService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricSettingRequestDelegate f387849b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricSettingRequestService f387850a;

    static {
        f387849b = new ObricSettingRequestDelegate();
    }

    @Override // com.obric.assistant.common.spi.settings.IObricSettingRequestService
    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        this.f387850a.a(r100);
    }

    @Override // com.obric.assistant.common.spi.settings.IObricSettingRequestService
    public final JSONObject b(JSONObject r100) {
        return this.f387850a.b(r100);
    }

    private ObricSettingRequestDelegate() {
        IObricSettingRequestService r100 = (IObricSettingRequestService) ServiceManager.get().getService(IObricSettingRequestService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricSettingRequestServiceImpl();
    L5:
        this.f387850a = r100;
    }
}
