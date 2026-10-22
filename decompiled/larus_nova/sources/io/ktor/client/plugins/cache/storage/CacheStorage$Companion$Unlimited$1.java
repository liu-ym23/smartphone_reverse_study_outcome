package io.ktor.client.plugins.cache.storage;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/client/plugins/cache/storage/UnlimitedStorage;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class CacheStorage$Companion$Unlimited$1 extends Lambda implements Function0<UnlimitedStorage> {
    public static final CacheStorage$Companion$Unlimited$1 INSTANCE = null;

    static {
        INSTANCE = new CacheStorage$Companion$Unlimited$1();
    }

    public CacheStorage$Companion$Unlimited$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final UnlimitedStorage invoke() {
        return new UnlimitedStorage();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ UnlimitedStorage invoke() {
        return invoke();
    }
}
