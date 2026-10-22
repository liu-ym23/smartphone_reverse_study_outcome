package com.larus.share.service;

import androidx.fragment.app.DialogFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0015\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0015\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/larus/share/service/ShareServiceDelegate;", "Lcom/larus/share/service/IShareService;", "<init>", "()V", "showDriveShareFragment", "Landroidx/fragment/app/DialogFragment;", "shareContext", "Lcom/larus/share/bean/DriveShareContext;", "showSheetShareFragment", "Lcom/larus/share/bean/SheetShareContext;", "showSlidesShareFragment", "Lcom/larus/share/bean/SlideShareContext;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareServiceDelegate implements IShareService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ShareServiceDelegate f368888b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IShareService f368889a;

    static {
        f368888b = new ShareServiceDelegate();
    }

    @Override // com.larus.share.service.IShareService
    public final DialogFragment a(kw9.b r100) {
        return this.f368889a.a(r100);
    }

    @Override // com.larus.share.service.IShareService
    public final DialogFragment b(kw9.f r100) {
        return this.f368889a.b(r100);
    }

    @Override // com.larus.share.service.IShareService
    public final DialogFragment c(kw9.i r100) {
        return this.f368889a.c(r100);
    }

    private ShareServiceDelegate() {
        IShareService r100 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r100 != null) goto L5;
        r100 = new ShareServiceNoop();
    L5:
        this.f368889a = r100;
    }
}
