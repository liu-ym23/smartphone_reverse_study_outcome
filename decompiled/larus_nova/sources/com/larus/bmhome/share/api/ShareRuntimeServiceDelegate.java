package com.larus.bmhome.share.api;

import android.content.Context;
import android.content.Intent;
import com.larus.bmhome.share.panel.b;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u001d\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0013\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\\\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019H\u0096\u0001¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/share/api/ShareRuntimeServiceDelegate;", "Lcom/larus/bmhome/share/api/IShareRuntimeService;", "<init>", "()V", "handleActivityResult", "", "requestCode", "", "resultCode", "intent", "Landroid/content/Intent;", "initShareRuntime", "isChannelSupported", "", "shareChannel", "", "shareType", "isInstalledChannel", "share", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", DyPayConstant.KEY_SHOW_LOADING, "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareRuntimeServiceDelegate implements IShareRuntimeService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ShareRuntimeServiceDelegate f313829b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IShareRuntimeService f313830a;

    static {
        f313829b = new ShareRuntimeServiceDelegate();
    }

    @Override // com.larus.bmhome.share.api.IShareRuntimeService
    public final boolean a(String r100) {
        return this.f313830a.a(r100);
    }

    @Override // com.larus.bmhome.share.api.IShareRuntimeService
    public final void b(int r100, int r101, Intent r102) {
        this.f313830a.b(r100, r101, r102);
    }

    @Override // com.larus.bmhome.share.api.IShareRuntimeService
    public final void c() {
        this.f313830a.c();
    }

    @Override // com.larus.bmhome.share.api.IShareRuntimeService
    public final void d(Context r100, String r110, String r111, b r112, boolean r113, com.larus.share.impl.sdk.b r114) {
        Intrinsics.checkNotNullParameter(r112, "shareContent");
        this.f313830a.d(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.larus.bmhome.share.api.IShareRuntimeService
    public final boolean e(String r100, String r101) {
        return this.f313830a.e(r100, r101);
    }

    private ShareRuntimeServiceDelegate() {
        IShareRuntimeService r100 = (IShareRuntimeService) ServiceManager.get().getService(IShareRuntimeService.class);
        if (r100 != null) goto L5;
        r100 = new ShareRuntimeServiceNoop();
    L5:
        this.f313830a = r100;
    }
}
