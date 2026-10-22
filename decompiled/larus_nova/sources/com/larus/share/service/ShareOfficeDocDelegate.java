package com.larus.share.service;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001JD\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0010H\u0096\u0001J#\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/larus/share/service/ShareOfficeDocDelegate;", "Lcom/larus/share/service/IShareOfficeDocService;", "<init>", "()V", "isAvailable", "", "isDocPublic", "docType", "Lcom/larus/share/service/ShareDocType;", "token", "", "observeDocPermission", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isPublic", "openPermissionSetting", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "Lcom/larus/share/service/ShareDocPermissionParams;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareOfficeDocDelegate implements IShareOfficeDocService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ShareOfficeDocDelegate f368886b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IShareOfficeDocService f368887a;

    static {
        f368886b = new ShareOfficeDocDelegate();
    }

    @Override // com.larus.share.service.IShareOfficeDocService
    public final boolean a(ShareDocType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "docType");
        Intrinsics.checkNotNullParameter(r101, "token");
        return this.f368887a.a(r100, r101);
    }

    @Override // com.larus.share.service.IShareOfficeDocService
    public final void b(ShareDocType r100, String r101, LifecycleOwner r102, Function1<? super Boolean, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "docType");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "owner");
        Intrinsics.checkNotNullParameter(r103, "onChanged");
        this.f368887a.b(r100, r101, r102, r103);
    }

    @Override // com.larus.share.service.IShareOfficeDocService
    public final void c(Context r100, ShareDocType r101, i r102) {
        Intrinsics.checkNotNullParameter(r101, "docType");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f368887a.c(r100, r101, r102);
    }

    private ShareOfficeDocDelegate() {
        IShareOfficeDocService r100 = (IShareOfficeDocService) ServiceManager.get().getService(IShareOfficeDocService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultShareOfficeDocService();
    L5:
        this.f368887a = r100;
    }
}
