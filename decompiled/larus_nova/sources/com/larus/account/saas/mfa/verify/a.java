package com.larus.account.saas.mfa.verify;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.home.impl.sdk.b;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f286456a = null;

    static {
        f286456a = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static void a(b r100) {
        Intrinsics.checkNotNullParameter("flow_mfa_remote_connect_pc", "scene");
        Intrinsics.checkNotNullParameter("flow_mfa_template_common", ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r100, "callback");
        BuildersKt.launch$default(f286456a, null, null, new MfaVerifyManager$startVerify$1("flow_mfa_remote_connect_pc", "flow_mfa_template_common", r100, null), 3, null);
    }
}
