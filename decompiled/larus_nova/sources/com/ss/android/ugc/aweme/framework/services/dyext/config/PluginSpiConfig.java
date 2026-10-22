package com.ss.android.ugc.aweme.framework.services.dyext.config;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0002J\u001e\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/config/PluginSpiConfig;", "", "()V", "getDouyinImplPlugin", "", ExifInterface.GPS_DIRECTION_TRUE, "service", "Ljava/lang/Class;", "getDyliteImplPlugin", "getPlugin", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class PluginSpiConfig {
    public static final PluginSpiConfig INSTANCE = null;

    private PluginSpiConfig() {
    }

    private final <T> String getDouyinImplPlugin(Class<T> r100) {
        return null;
    }

    private final <T> String getDyliteImplPlugin(Class<T> r100) {
        return null;
    }

    static {
        INSTANCE = new PluginSpiConfig();
    }

    public final <T> String getPlugin(Class<T> r100) {
        int r101 = FlavorConfig.INSTANCE.getFlavor();
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L11;
        return null;
    L11:
        return getDyliteImplPlugin(r100);
    L9:
        return getDouyinImplPlugin(r100);
    }
}
