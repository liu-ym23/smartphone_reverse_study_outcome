package com.larus.bmhome.utils;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/utils/LandingRedBadgeHelperDelegate;", "Lcom/larus/bmhome/utils/ILandingRedBadgeHelper;", "<init>", "()V", "isChatPageResumed", "", "isMainTabPageResumed", "setChatPageResumed", "", "setMainTabPageResumed", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandingRedBadgeHelperDelegate implements ILandingRedBadgeHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LandingRedBadgeHelperDelegate f314918b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILandingRedBadgeHelper f314919a;

    static {
        f314918b = new LandingRedBadgeHelperDelegate();
    }

    @Override // com.larus.bmhome.utils.ILandingRedBadgeHelper
    public final void a() {
        this.f314919a.a();
    }

    @Override // com.larus.bmhome.utils.ILandingRedBadgeHelper
    public final boolean b() {
        return this.f314919a.b();
    }

    @Override // com.larus.bmhome.utils.ILandingRedBadgeHelper
    public final void c() {
        this.f314919a.c();
    }

    private LandingRedBadgeHelperDelegate() {
        ILandingRedBadgeHelper r100 = (ILandingRedBadgeHelper) ServiceManager.get().getService(ILandingRedBadgeHelper.class);
        if (r100 != null) goto L5;
        r100 = new LandingRedBadgeHelperNoop();
    L5:
        this.f314919a = r100;
    }
}
