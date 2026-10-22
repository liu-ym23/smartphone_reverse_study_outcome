package com.larus.share.host;

import com.obric.assistant.spi.share.IShareKeyConfigService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/share/host/MainlandShareKeyConfigService;", "Lcom/obric/assistant/spi/share/IShareKeyConfigService;", "<init>", "()V", "isAvailable", "", "getKey", "", "channel", "share-host_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainlandShareKeyConfigService implements IShareKeyConfigService {
    public MainlandShareKeyConfigService() {
    }

    @Override // com.obric.assistant.spi.share.IShareKeyConfigService
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        int r101 = r100.hashCode();
        if (r101 == (-1325936172)) goto L17;
        if (r101 == (-791770330)) goto L14;
        if (r101 == 3616) goto L10;
    L18:
        return null;
    L10:
        if (r100.equals("qq") == false) goto L18;
        return "1112323716";
    L14:
        if (r100.equals("wechat") == false) goto L18;
        return "wx75f04c8595ccb9f6";
    L17:
        if (r100.equals("douyin") == false) goto L18;
        return "aw730v27vx2bu2qw";
    }
}
