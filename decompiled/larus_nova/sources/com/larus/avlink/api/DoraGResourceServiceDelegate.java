package com.larus.avlink.api;

import a49.d;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0013\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\rH\u0096\u0001J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0096\u0001J\t\u0010\u0016\u001a\u00020\bH\u0096\u0001J\t\u0010\u0017\u001a\u00020\bH\u0096\u0001J\t\u0010\u0018\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096\u0001¨\u0006\u001c"}, d2 = {"Lcom/larus/avlink/api/DoraGResourceServiceDelegate;", "Lcom/larus/avlink/api/IDoraGResourceService;", "<init>", "()V", "getEmptyAlbumIconResId", "", "getRecordMinutesOnboardingIconResId", "loadDiaryListLottie", "", "view", "Landroid/view/View;", "notifyDoraGDeviceNameUpdate", "newName", "", "onDiaryBetaWidgetCardUpdate", "widgetCard", "", "onDiaryContentUpdate", "diaryCard", "onDiaryDelete", "diaryId", "prepareNaturalWakeupBgmFile", "refreshDiaryWidget", "registerDoraGWidgetListener", "unregisterDoraGWidgetListener", "updateWidgetEntry", "enable", "", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGResourceServiceDelegate implements IDoraGResourceService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DoraGResourceServiceDelegate f291642b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDoraGResourceService f291643a;

    static {
        f291642b = new DoraGResourceServiceDelegate();
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final void a(d r100) {
        this.f291643a.a(r100);
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final void b() {
        this.f291643a.b();
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final void c() {
        this.f291643a.c();
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "newName");
        this.f291643a.d(r100);
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final void e(LottieAdapterView r100) {
        this.f291643a.e(r100);
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "diaryId");
        this.f291643a.f(r100);
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final void g(boolean r100) {
        this.f291643a.g(r100);
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final int h() {
        return this.f291643a.h();
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final int i() {
        return this.f291643a.i();
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final void j() {
        this.f291643a.j();
    }

    @Override // com.larus.avlink.api.IDoraGResourceService
    public final void k(Object r100) {
        this.f291643a.k(r100);
    }

    private DoraGResourceServiceDelegate() {
        this.f291643a = (IDoraGResourceService) ServiceManager.get().getService(IDoraGResourceService.class);
    }
}
