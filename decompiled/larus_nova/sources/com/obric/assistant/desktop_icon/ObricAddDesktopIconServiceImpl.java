package com.obric.assistant.desktop_icon;

import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/desktop_icon/ObricAddDesktopIconServiceImpl;", "Lcom/obric/assistant/desktop_icon/IObricAddDesktopIconService;", "<init>", "()V", "init", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAddDesktopIconServiceImpl implements IObricAddDesktopIconService {
    public ObricAddDesktopIconServiceImpl() {
    }

    @Override // com.obric.assistant.desktop_icon.IObricAddDesktopIconService
    public final void init() {
        FLogger.f375446a.i("ObricDesktopIcon", "checking desktop icon ");
        HomeService.f344094a.y();
    }
}
