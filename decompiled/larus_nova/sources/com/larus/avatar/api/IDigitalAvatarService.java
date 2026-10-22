package com.larus.avatar.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import q97.a;
import sq9.u;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J$\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J$\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J*\u0010\u0010\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/larus/avatar/api/IDigitalAvatarService;", "", "getDigitalAvatarOnboardingCacheManager", "Lcom/larus/platform/model/creation/IDigitalAvatarOnboardingCacheManager;", "createDigitalAvatarRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "tryPreloadDigitalOnboardingDialogResource", "", "startAvatarManagerActivityForResult", "activity", "Landroid/app/Activity;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "startAvatarUploadActivityForResult", "showDigitalReplaceConfirmDialog", "doOnConfirmClicked", "Lkotlin/Function0;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDigitalAvatarService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f290722a = null;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J+\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0096\u0001J%\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J%\u0010\u0013\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J\t\u0010\u0014\u001a\u00020\tH\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/larus/avatar/api/IDigitalAvatarService$Companion;", "Lcom/larus/avatar/api/IDigitalAvatarService;", "<init>", "()V", "createDigitalAvatarRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "getDigitalAvatarOnboardingCacheManager", "Lcom/larus/platform/model/creation/IDigitalAvatarOnboardingCacheManager;", "showDigitalReplaceConfirmDialog", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "doOnConfirmClicked", "Lkotlin/Function0;", "startAvatarManagerActivityForResult", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "startAvatarUploadActivityForResult", "tryPreloadDigitalOnboardingDialogResource", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IDigitalAvatarService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f290723c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IDigitalAvatarService f290724b;

        static {
            f290723c = new Companion();
        }

        @Override // com.larus.avatar.api.IDigitalAvatarService
        public final a a() {
            return this.f290724b.a();
        }

        @Override // com.larus.avatar.api.IDigitalAvatarService
        public final void b() {
            this.f290724b.b();
        }

        @Override // com.larus.avatar.api.IDigitalAvatarService
        public final u d() {
            return this.f290724b.d();
        }

        @Override // com.larus.avatar.api.IDigitalAvatarService
        public final void e(Activity r100, Function0 r101) {
            Intrinsics.checkNotNullParameter(r101, "doOnConfirmClicked");
            this.f290724b.e(r100, r101);
        }

        @Override // com.larus.avatar.api.IDigitalAvatarService
        public final void f(FragmentActivity r100, Context r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f290724b.f(r100, r101, r102);
        }

        private Companion() {
            this.f290724b = (IDigitalAvatarService) ServiceManager.get().getService(IDigitalAvatarService.class);
        }
    }

    static {
        f290722a = Companion.f290723c;
    }

    a a();

    void b();

    u d();

    void e(Activity r100, Function0 r101);

    void f(FragmentActivity r100, Context r101, Bundle r102);
}
