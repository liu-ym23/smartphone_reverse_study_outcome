package com.bytedance.i18n.claymore;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.log.MiraMonitor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0007J%\u0010\b\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0007¢\u0006\u0002\u0010\tJ'\u0010\n\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0007¢\u0006\u0002\u0010\tJ.\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/i18n/claymore/PluginServiceLoader;", "", "()V", "loadAll", "", ExifInterface.GPS_DIRECTION_TRUE, "c", "Ljava/lang/Class;", MiraMonitor.LOAD_FIRST_KEY, "(Ljava/lang/Class;)Ljava/lang/Object;", "loadFirstOrNull", "registerLoader", "", "loader", "Lcom/bytedance/i18n/claymore/ClaymoreServiceLoader$Loader;", "core"}, k = 1, mv = {1, 4, 0})
public final class PluginServiceLoader {
    public static final PluginServiceLoader INSTANCE = null;

    private PluginServiceLoader() {
    }

    static {
        INSTANCE = new PluginServiceLoader();
    }

    @JvmStatic
    public static final <T> Iterator<T> loadAll(Class<T> r100) {
        return ClaymoreServiceLoader.loadAll(r100);
    }

    @JvmStatic
    public static final <T> T loadFirst(Class<T> r100) {
        return (T) ClaymoreServiceLoader.loadFirst(r100);
    }

    @JvmStatic
    public static final <T> T loadFirstOrNull(Class<T> r100) {
        return (T) ClaymoreServiceLoader.loadFirstOrNull(r100);
    }

    @JvmStatic
    public static final <T> void registerLoader(Class<T> r100, ClaymoreServiceLoader.Loader<T> r101) {
        ClaymoreServiceLoader.registerLoader(r100, r101);
    }
}
