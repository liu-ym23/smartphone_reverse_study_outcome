package com.obric.assistant.push;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.sharedstate.StateKey;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.push.IObricPushConfigService;
import com.obric.assistant.state.ISharedStateService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/push/ObricPushConfigServiceImpl;", "Lcom/obric/assistant/spi/push/IObricPushConfigService;", "<init>", "()V", "savePushToken", "", "token", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPushConfigServiceImpl implements IObricPushConfigService {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    public ObricPushConfigServiceImpl() {
    }

    @Override // com.obric.assistant.spi.push.IObricPushConfigService
    public final void a(String r100) {
        if (ObricFeatureServiceDelegate.f387839b.b() == true) goto L6;
        FLogger.f375446a.i("ObricPushConfigServiceImpl", "savePushToken skipped: not ObricOs");
        return;
    L6:
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L15;
        FLogger.f375446a.w("ObricPushConfigServiceImpl", "savePushToken skipped: token is null or empty");
        return;
    L15:
        ISharedStateService.f392930a.getClass();
        ISharedStateService r102 = ISharedStateService.a.a();
        if (r102 == null) goto L18;
        r102.a(StateKey.KEY_DOUBAO_PUSH_TOKEN, r100);
        FLogger.f375446a.i("ObricPushConfigServiceImpl", "savePushToken success");
        return;
    L18:
        FLogger.f375446a.w("ObricPushConfigServiceImpl", "savePushToken skipped: ISharedStateService instance is null");
        return;
    L8:
        if (r100.length() == 0) goto L11;
        r101 = false;
        goto L12
    }
}
