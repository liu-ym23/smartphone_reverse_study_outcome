package com.bytedance.live.richcontent.resource.cache;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "K", "V", "it", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)I"}, k = 3, mv = {1, 4, 2})
final class ResourceCacheFactory$createMaxEntitySoftCache$1 extends Lambda implements Function1<Object, Integer> {
    public static final ResourceCacheFactory$createMaxEntitySoftCache$1 INSTANCE = null;

    static {
        INSTANCE = new ResourceCacheFactory$createMaxEntitySoftCache$1();
    }

    public ResourceCacheFactory$createMaxEntitySoftCache$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(Object r100) {
        return 1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object r100) {
        return Integer.valueOf(invoke2(r100));
    }
}
