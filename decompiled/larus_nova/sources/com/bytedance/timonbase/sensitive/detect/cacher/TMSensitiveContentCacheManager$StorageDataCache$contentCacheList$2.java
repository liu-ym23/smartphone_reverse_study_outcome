package com.bytedance.timonbase.sensitive.detect.cacher;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/concurrent/CopyOnWriteArrayList;", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/util/concurrent/CopyOnWriteArrayList;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class TMSensitiveContentCacheManager$StorageDataCache$contentCacheList$2 extends Lambda implements Function0<CopyOnWriteArrayList<Object>> {
    public static final TMSensitiveContentCacheManager$StorageDataCache$contentCacheList$2 INSTANCE = null;

    static {
        INSTANCE = new TMSensitiveContentCacheManager$StorageDataCache$contentCacheList$2();
    }

    public TMSensitiveContentCacheManager$StorageDataCache$contentCacheList$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CopyOnWriteArrayList<Object> invoke2() {
        return new CopyOnWriteArrayList();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CopyOnWriteArrayList<Object> invoke() {
        return invoke2();
    }
}
