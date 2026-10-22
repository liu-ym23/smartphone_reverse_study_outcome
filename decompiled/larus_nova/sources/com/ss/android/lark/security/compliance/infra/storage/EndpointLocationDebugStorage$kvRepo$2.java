package com.ss.android.lark.security.compliance.infra.storage;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.storage.LarkKVStorage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/security/compliance/infra/storage/ScsDebugKVRepo;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class EndpointLocationDebugStorage$kvRepo$2 extends Lambda implements Function0<a> {
    public static final EndpointLocationDebugStorage$kvRepo$2 INSTANCE = null;

    static {
        INSTANCE = new EndpointLocationDebugStorage$kvRepo$2();
    }

    public EndpointLocationDebugStorage$kvRepo$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        com.ss.android.lark.storage.a r100 = d.f440474a;
        Intrinsics.checkNotNullParameter("endpoint_location_debug", "repoName");
        return new a(LarkKVStorage.g(d.f440474a, "endpoint_location_debug", false));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
