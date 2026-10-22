package com.larus.bmhome.larkinput.api.host;

import com.bytedance.creativex.mediaimport.preview.internal.main.g;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oq8.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/larkinput/api/host/LarkInputHostService;", "Lcom/larus/bmhome/larkinput/api/host/ILarkInputHostService;", "<init>", "()V", "createSpans", "", "", "token", "Lcom/larus/bmhome/larkinput/api/model/InlineToken;", "openPicker", "", "request", "Lcom/larus/bmhome/larkinput/api/model/InlineTokenRequest;", "callback", "Lcom/larus/bmhome/larkinput/api/host/ILarkInputTokenCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkInputHostService implements ILarkInputHostService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LarkInputHostService f312462b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILarkInputHostService f312463a;

    static {
        f312462b = new LarkInputHostService();
    }

    @Override // com.larus.bmhome.larkinput.api.host.ILarkInputHostService
    public final void a(a r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f312463a.a(r100, r101);
    }

    private LarkInputHostService() {
        ILarkInputHostService r100 = (ILarkInputHostService) ServiceManager.get().getService(ILarkInputHostService.class);
        if (r100 != null) goto L5;
        r100 = new LarkInputHostServiceNoop();
    L5:
        this.f312463a = r100;
    }
}
