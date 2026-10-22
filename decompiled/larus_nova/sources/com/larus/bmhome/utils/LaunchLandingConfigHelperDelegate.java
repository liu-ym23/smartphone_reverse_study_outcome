package com.larus.bmhome.utils;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.auth.LandingConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0096A¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0013\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0001¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/utils/LaunchLandingConfigHelperDelegate;", "Lcom/larus/bmhome/utils/ILaunchLandingConfigHelper;", "<init>", "()V", "checkIsFromUgArguments", "", "arguments", "Landroid/os/Bundle;", "findOrCreateConversationByBot", "Lcom/larus/bmhome/utils/SimpleConvInfo;", "botId", "", "conversationInfo", "Lcom/larus/network/http/Async;", "Lcom/larus/im/bean/conversation/Conversation;", "(Ljava/lang/String;Lcom/larus/network/http/Async;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLandingConfig", "Lcom/larus/bmhome/auth/LandingConfig;", "setLandingConfig", "", "config", "tryHandleLaunchLandingScheme", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchLandingConfigHelperDelegate implements ILaunchLandingConfigHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LaunchLandingConfigHelperDelegate f314922b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILaunchLandingConfigHelper f314923a;

    static {
        f314922b = new LaunchLandingConfigHelperDelegate();
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final void a(Context r100) {
        this.f314923a.a(r100);
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final LandingConfig b() {
        return this.f314923a.b();
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final boolean c(Bundle r100) {
        return this.f314923a.c(r100);
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final Object d(String r100, Continuation r101) {
        return this.f314923a.d(r100, r101);
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final void e(LandingConfig r100) {
        this.f314923a.e(r100);
    }

    private LaunchLandingConfigHelperDelegate() {
        ILaunchLandingConfigHelper r100 = (ILaunchLandingConfigHelper) ServiceManager.get().getService(ILaunchLandingConfigHelper.class);
        if (r100 != null) goto L5;
        r100 = new LaunchLandingConfigHelperNoop();
    L5:
        this.f314923a = r100;
    }
}
