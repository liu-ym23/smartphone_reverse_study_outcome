package com.larus.platform.api;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/IAccountRemovedCacheService;", "", "onAccountRemoved", "", "secUserId", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAccountRemovedCacheService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f364774a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/api/IAccountRemovedCacheService$Companion;", "Lcom/larus/platform/api/IAccountRemovedCacheService;", "<init>", "()V", PromotionProductPrivilegesStruct.SERVICES, "", "getServices", "()Ljava/util/Set;", "services$delegate", "Lkotlin/Lazy;", "onAccountRemoved", "", "secUserId", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAccountRemovedCacheService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f364775b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<Set<IAccountRemovedCacheService>> f364776c = null;

        private Companion() {
        }

        static {
            f364775b = new Companion();
            f364776c = LazyKt.lazy(new w());
        }

        @Override // com.larus.platform.api.IAccountRemovedCacheService
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "secUserId");
            Iterator<T> r101 = f364776c.getValue().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((IAccountRemovedCacheService) r101.next()).a(r100);
            goto L4
        }
    }

    static {
        f364774a = Companion.f364775b;
    }

    void a(String r100);
}
