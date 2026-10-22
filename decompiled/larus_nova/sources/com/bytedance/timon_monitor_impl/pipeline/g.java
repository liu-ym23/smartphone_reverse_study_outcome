package com.bytedance.timon_monitor_impl.pipeline;

import android.content.ClipData;
import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache;
import com.bytedance.timonbase.sensitive.detect.cacher.TMSensitiveContentCacheManager;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {kz5.a.class})
public final class g implements TimonSystem {

    public static final class a {
    }

    static {
    }

    public g() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "SensitiveContentCacheSystem";
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(dh7.c r100) {
        return true;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(dh7.c r100) {
        ReentrantReadWriteLock.ReadLock r101 = r100.f468622b.readLock();
        r101.lock();
        Object r102 = ((LinkedHashMap) r100.f468621a).get(Reflection.getOrCreateKotlinClass(kz5.a.class));     // Catch: Throwable -> L45
        Object r103 = null;
        if ((r102 instanceof kz5.a) == true) goto L6;
        r102 = null;
    L6:
        kz5.a r104 = (kz5.a) r102;     // Catch: Throwable -> L45
        r101.unlock();
        if (r104 != null) goto L10;
    L11:
        if (r104 != null) goto L13;
        return true;
    L13:
        if (r104.f506748a != 101804) goto L56;
    L14:
        ReentrantReadWriteLock.ReadLock r105 = r100.f468622b.readLock();
        r105.lock();
        Object r106 = ((LinkedHashMap) r100.f468621a).get(Reflection.getOrCreateKotlinClass(kz5.b.class));     // Catch: Throwable -> L40
        if ((r106 instanceof kz5.b) == false) goto L19;
        r103 = r106;
    L19:
        kz5.b r107 = (kz5.b) r103;     // Catch: Throwable -> L40
        r105.unlock();
        if (r107 == null) goto L57;
        Object r108 = r107.f506756b;
        if ((r108 instanceof CharSequence) == false) goto L28;
        ISensitiveContentCache.Type r109 = ISensitiveContentCache.Type.CLIPBOARD;
        String.valueOf(r108);
        ISensitiveContentCache r110 = (ISensitiveContentCache) ((ConcurrentHashMap) TMSensitiveContentCacheManager.f270900a.getValue()).get(r109);
        if (r110 == null) goto L58;
        MapsKt.emptyMap();
        r110.a();
        return true;
    L58:
        return true;
    L28:
        if ((r108 instanceof ClipData) == false) goto L60;
        if (r108 == null) goto L39;
        ClipData r111 = (ClipData) r108;
        int r112 = r111.getItemCount();
        int r113 = 0;
    L31:
        if (r113 >= r112) goto L61;
        CharSequence r114 = r111.getItemAt(r113).getText();
        if (r114 == null) goto L37;
        ISensitiveContentCache.Type r115 = ISensitiveContentCache.Type.CLIPBOARD;
        r114.toString();
        ISensitiveContentCache r116 = (ISensitiveContentCache) ((ConcurrentHashMap) TMSensitiveContentCacheManager.f270900a.getValue()).get(r115);
        if (r116 == null) goto L37;
        MapsKt.emptyMap();
        r116.a();
    L37:
        r113 = r113 + 1;
        goto L31
    L61:
        return true;
    L39:
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipData");
    L60:
        return true;
    L57:
        return true;
    L40:
        th = move-exception;
        r105.unlock();
        throw th;
    L56:
        return true;
    L10:
        if (r104.f506748a == 101803) goto L14;
    L45:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
