package com.bytedance.bdp.appbase.auth.contextservice;

import com.bytedance.bdp.appbase.auth.contextservice.manager.AuthorizeEventManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/bdp/appbase/auth/contextservice/manager/AuthorizeEventManager;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
final class AuthorizationService$mDefaultAuthEventManager$2 extends Lambda implements Function0<AuthorizeEventManager> {
    final /* synthetic */ AuthorizationService this$0;

    public AuthorizationService$mDefaultAuthEventManager$2(AuthorizationService r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AuthorizeEventManager invoke() {
        this.this$0.getClass();
        return new AuthorizeEventManager();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AuthorizeEventManager invoke() {
        return invoke();
    }
}
