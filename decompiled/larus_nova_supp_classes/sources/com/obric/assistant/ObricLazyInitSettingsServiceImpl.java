package com.obric.assistant;

import android.util.EventsUtils;
import com.obric.assistant.spi.launch.IObricLazyInitSettingsService;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/ObricLazyInitSettingsServiceImpl;", "Lcom/obric/assistant/spi/launch/IObricLazyInitSettingsService;", "<init>", "()V", "isIvyKitLazyInitEnabled", XmlPullParser.NO_NAMESPACE, "isAppletLazyInitEnabled", "isTTVideoEngineLazyInitEnabled", "isLocalLifeLazyInitEnabled", "isECommerceLazyInitEnabled", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricLazyInitSettingsServiceImpl implements IObricLazyInitSettingsService {
    public ObricLazyInitSettingsServiceImpl() {
    }

    @Override // com.obric.assistant.spi.launch.IObricLazyInitSettingsService
    public final boolean a() {
        return t1.a.getObricLazyInitConfig().getEnableAppletLazyInit();
    }

    @Override // com.obric.assistant.spi.launch.IObricLazyInitSettingsService
    public final boolean b() {
        return t1.a.getObricLazyInitConfig().getEnableTTVideoEngineLazyInit();
    }

    @Override // com.obric.assistant.spi.launch.IObricLazyInitSettingsService
    public final boolean c() {
        return t1.a.getObricLazyInitConfig().getEnableECommerceLazyInit();
    }

    @Override // com.obric.assistant.spi.launch.IObricLazyInitSettingsService
    public final boolean d() {
        return t1.a.getObricLazyInitConfig().getEnableLocalLifeLazyInit();
    }

    @Override // com.obric.assistant.spi.launch.IObricLazyInitSettingsService
    public final boolean e() {
        return t1.a.getObricLazyInitConfig().getEnableIvyKitLazyInit();
    }
}
