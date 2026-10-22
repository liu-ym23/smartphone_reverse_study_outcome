package com.obric.assistant.common.spi;

import com.larus.common_ui.dialog.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n2a.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/common/spi/DefaultObricEnvService;", "Lcom/obric/assistant/common/spi/IObricEnvService;", "<init>", "()V", "modifyAppInfoLayoutAction", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "modifyCommonDialogStyleAction", "action", "Lkotlin/Function0;", "modifyTTVideoEngineLogAction", "isBuildDateShowInRelease", "", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricEnvService implements IObricEnvService {
    public DefaultObricEnvService() {
    }

    @Override // com.obric.assistant.common.spi.IObricEnvService
    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    @Override // com.obric.assistant.common.spi.IObricEnvService
    public final void b(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    @Override // com.obric.assistant.common.spi.IObricEnvService
    public final void c(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
    }

    @Override // com.obric.assistant.common.spi.IObricEnvService
    public final boolean d() {
        return false;
    }
}
