package com.larus.platform.audit;

import com.larus.platform.service.AccountService;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes31.dex */
public final class BehaviorAuditApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f365317a = null;

    static {
        f365317a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @JvmStatic
    public static final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (AccountService.f365697a.isEnterpriseAccount() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(f365317a, null, null, new BehaviorAuditApi$report$1(r100, null), 3, null);
    }

    @JvmStatic
    public static final void b(b r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "extras");
        a(new a(BehaviorAuditOperation.COPY, r100, null, r101, 12));
    }

    @JvmStatic
    public static final void c(b r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "fileInfo");
        Intrinsics.checkNotNullParameter(r101, "extras");
        a(new a(BehaviorAuditOperation.DOWNLOAD, r100, null, r101, 12));
    }
}
