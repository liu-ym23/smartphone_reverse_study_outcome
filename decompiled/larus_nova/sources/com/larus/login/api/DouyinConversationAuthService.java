package com.larus.login.api;

import androidx.fragment.app.FragmentActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/login/api/DouyinConversationAuthService;", "Lcom/larus/login/api/IDouyinConversationAuthService;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/login/api/IDouyinConversationAuthService;", "impl$delegate", "Lkotlin/Lazy;", "markTrigger", "", "scene", "Lcom/larus/login/api/DouyinConversationAuthTriggerScene;", "tryShow", "host", "Landroidx/fragment/app/FragmentActivity;", "currentPage", "", "clearTrigger", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouyinConversationAuthService implements IDouyinConversationAuthService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DouyinConversationAuthService f356984a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f356985b = null;

    private DouyinConversationAuthService() {
    }

    static {
        f356984a = new DouyinConversationAuthService();
        f356985b = LazyKt.lazy(new d0());
    }

    @Override // com.larus.login.api.IDouyinConversationAuthService
    public final void b(DouyinConversationAuthTriggerScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IDouyinConversationAuthService r101 = (IDouyinConversationAuthService) f356985b.getValue();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.larus.login.api.IDouyinConversationAuthService
    public final void a(FragmentActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        IDouyinConversationAuthService r102 = (IDouyinConversationAuthService) f356985b.getValue();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
