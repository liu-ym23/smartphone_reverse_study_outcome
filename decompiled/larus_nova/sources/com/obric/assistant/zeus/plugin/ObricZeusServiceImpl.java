package com.obric.assistant.zeus.plugin;

import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.obric.aiagent.sharedstate.StateKey;
import com.obric.assistant.spi.zeus.IObricZeusService;
import com.obric.assistant.state.ObricSharedStateDelegate;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/zeus/plugin/ObricZeusServiceImpl;", "Lcom/obric/assistant/spi/zeus/IObricZeusService;", "<init>", "()V", "getZeusPluginDebugInfo", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricZeusServiceImpl implements IObricZeusService {
    public ObricZeusServiceImpl() {
    }

    @Override // com.obric.assistant.spi.zeus.IObricZeusService
    public final String getZeusPluginDebugInfo() {
        AppHost.Companion r100 = AppHost.f326268a;
        Bundle r101 = r100.getApplication().getPackageManager().getApplicationInfo(r100.getApplication().getPackageName(), 128).metaData;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getInt("ZEUS_HOST_PROTOCOL_VERSION"));
    L6:
        ObricSharedStateDelegate r103 = ObricSharedStateDelegate.f392933c;
        return StringsKt.trimIndent("\n            plugin-protocol: " + r102 + "\n            memory-plugin: " + r103.b(StateKey.KEY_ZEUS_MEMORY_VERSION) + "\n            aiagent-plugin: " + r103.b(StateKey.KEY_ZEUS_AIAGENT_VERSION) + "\n        ");
    L5:
        r102 = null;
        goto L6
    }
}
