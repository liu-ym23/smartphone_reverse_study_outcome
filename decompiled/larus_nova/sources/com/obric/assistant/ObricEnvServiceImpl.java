package com.obric.assistant;

import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.obric.aiagent.sharedstate.StateKey;
import com.obric.assistant.common.spi.IObricEnvService;
import com.obric.assistant.state.ObricSharedStateDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\u0014\u0010\t\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/ObricEnvServiceImpl;", "Lcom/obric/assistant/common/spi/IObricEnvService;", "<init>", "()V", "modifyAppInfoLayoutAction", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "appendZeusInfo", "modifyCommonDialogStyleAction", "action", "Lkotlin/Function0;", "modifyTTVideoEngineLogAction", "isBuildDateShowInRelease", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnvServiceImpl implements IObricEnvService {
    public ObricEnvServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.IObricEnvService
    public final boolean d() {
        return true;
    }

    @Override // com.obric.assistant.common.spi.IObricEnvService
    public final void a(n2a.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        r100.invoke();
    }

    @Override // com.obric.assistant.common.spi.IObricEnvService
    public final void b(com.larus.common_ui.dialog.a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        r100.invoke();
    }

    @Override // com.obric.assistant.common.spi.IObricEnvService
    public final void c(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        AppHost.Companion r101 = AppHost.f326268a;
        Bundle r102 = r101.getApplication().getPackageManager().getApplicationInfo(r101.getApplication().getPackageName(), 128).metaData;
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.getInt("ZEUS_HOST_PROTOCOL_VERSION"));
    L6:
        ObricSharedStateDelegate r104 = ObricSharedStateDelegate.f392933c;
        String r105 = StringsKt.trimIndent("\n                plugin-protocol: " + r103 + "\n                memory-plugin: " + r104.b(StateKey.KEY_ZEUS_MEMORY_VERSION) + "\n                aiagent-plugin: " + r104.b(StateKey.KEY_ZEUS_AIAGENT_VERSION) + "\n            ");
        r100.append("\n");
        r100.append(r105);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
