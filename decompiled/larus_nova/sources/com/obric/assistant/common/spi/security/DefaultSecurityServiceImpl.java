package com.obric.assistant.common.spi.security;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/common/spi/security/DefaultSecurityServiceImpl;", "Lcom/obric/assistant/common/spi/security/IObricSecurityService;", "<init>", "()V", "shouldEraseLog", "", "eraseLogWithTail", "", PlayerResolution.SDKKEY.ORIGIN, "disableReceiveText", "getAdditionalEraseSensitiveKeys", "", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultSecurityServiceImpl implements IObricSecurityService {
    public DefaultSecurityServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.security.IObricSecurityService
    public final String a(String r100) {
        return r100;
    }

    @Override // com.obric.assistant.common.spi.security.IObricSecurityService
    public final boolean c() {
        return false;
    }

    @Override // com.obric.assistant.common.spi.security.IObricSecurityService
    public final List<String> b() {
        return CollectionsKt.emptyList();
    }
}
