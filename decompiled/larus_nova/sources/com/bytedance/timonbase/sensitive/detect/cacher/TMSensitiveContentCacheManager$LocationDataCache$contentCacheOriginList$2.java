package com.bytedance.timonbase.sensitive.detect.cacher;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TMSensitiveContentCacheManager$LocationDataCache$contentCacheOriginList$2 extends Lambda implements Function0<CopyOnWriteArrayList<String[]>> {
    public static final TMSensitiveContentCacheManager$LocationDataCache$contentCacheOriginList$2 INSTANCE = null;

    static {
        INSTANCE = new TMSensitiveContentCacheManager$LocationDataCache$contentCacheOriginList$2();
    }

    public TMSensitiveContentCacheManager$LocationDataCache$contentCacheOriginList$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CopyOnWriteArrayList<String[]> invoke2() {
        return new CopyOnWriteArrayList();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CopyOnWriteArrayList<String[]> invoke() {
        return invoke2();
    }
}
