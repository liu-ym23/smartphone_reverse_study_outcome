package com.larus.uaigc.service;

import androidx.fragment.app.DialogFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 %2\u00020\u0001:\u0001%J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H&J\u0010\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H&J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH&J\b\u0010\u001e\u001a\u00020\rH&J\n\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0010\u0010!\u001a\u0004\u0018\u00010\u001bH¦@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&¨\u0006&"}, d2 = {"Lcom/larus/uaigc/service/ICreationAvatarService;", "", "clearAvatarWhiteTUrl", "", "getDigitalAvatarOnboardingCacheManager", "Lcom/larus/platform/model/creation/IDigitalAvatarOnboardingCacheManager;", "createDigitalAvatarTemplateListDialogFragment", "Landroidx/fragment/app/DialogFragment;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/uaigc/avatar/DigitalAvatarTemplateModel;", "createDigitalAvatarRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "hasCreatedAvatar", "", "isAvatarInCreating", "isAvatarCreated", "initFetch", "getDigitalAvatarPreGenImagesOfScan", "", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "getDigitalAvatarPreGenImagesOfUpload", "getDigitalAvatarPreGenImages", "getDigitalAvatarMasterPreGenImage", "getDigitalAvatarRefVideo", "Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "updateDigitalAvatarIpaMainTempUrl", "tempUrl", "", "updateDigitalAvatarIpaMainTempUri", "tempUri", "needCompleteVideoAvatar", "getAiReplicaInfo", "Lcom/larus/uaigc/api/AiReplicaInfoData;", "fetchAiReplicaIpaMainUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "avatarCleared", "avatarCreated", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationAvatarService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373907a = null;

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096A¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0001J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018H\u0096\u0001J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018H\u0096\u0001J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018H\u0096\u0001J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u0096\u0001J\t\u0010 \u001a\u00020\u001eH\u0096\u0001J\t\u0010!\u001a\u00020\u001eH\u0096\u0001J\t\u0010\"\u001a\u00020\u001eH\u0096\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u000fH\u0096\u0001¨\u0006'"}, d2 = {"Lcom/larus/uaigc/service/ICreationAvatarService$Companion;", "Lcom/larus/uaigc/service/ICreationAvatarService;", "<init>", "()V", "avatarCleared", "", "avatarCreated", "clearAvatarWhiteTUrl", "createDigitalAvatarRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createDigitalAvatarTemplateListDialogFragment", "Landroidx/fragment/app/DialogFragment;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/uaigc/avatar/DigitalAvatarTemplateModel;", "fetchAiReplicaIpaMainUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAiReplicaInfo", "Lcom/larus/uaigc/api/AiReplicaInfoData;", "getDigitalAvatarMasterPreGenImage", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "getDigitalAvatarOnboardingCacheManager", "Lcom/larus/platform/model/creation/IDigitalAvatarOnboardingCacheManager;", "getDigitalAvatarPreGenImages", "", "getDigitalAvatarPreGenImagesOfScan", "getDigitalAvatarPreGenImagesOfUpload", "getDigitalAvatarRefVideo", "Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "hasCreatedAvatar", "", "initFetch", "isAvatarCreated", "isAvatarInCreating", "needCompleteVideoAvatar", "updateDigitalAvatarIpaMainTempUri", "tempUri", "updateDigitalAvatarIpaMainTempUrl", "tempUrl", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICreationAvatarService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373908c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICreationAvatarService f373909b;

        static {
            f373908c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final Object C(Continuation<? super String> r100) {
            return this.f373909b.C(r100);
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final void F() {
            this.f373909b.F();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final com.larus.uaigc.api.a G() {
            return this.f373909b.G();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final List<ey9.k> K() {
            return this.f373909b.K();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final void O() {
            this.f373909b.O();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final void P() {
            this.f373909b.P();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final List<ey9.k> Q() {
            return this.f373909b.Q();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final DialogFragment R(dy9.a r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            return this.f373909b.R(r100);
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final boolean S() {
            return this.f373909b.S();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final void T(String r100) {
            this.f373909b.T(r100);
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final boolean U() {
            return this.f373909b.U();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final q97.a a() {
            return this.f373909b.a();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final void c(String r100) {
            this.f373909b.c(r100);
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final sq9.u d() {
            return this.f373909b.d();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final boolean h() {
            return this.f373909b.h();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final void i() {
            this.f373909b.i();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final ey9.k p() {
            return this.f373909b.p();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final ey9.a q() {
            return this.f373909b.q();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final List<ey9.k> u() {
            return this.f373909b.u();
        }

        @Override // com.larus.uaigc.service.ICreationAvatarService
        public final boolean v() {
            return this.f373909b.v();
        }

        private Companion() {
            ICreationAvatarService r100 = (ICreationAvatarService) ServiceManager.get().getService(ICreationAvatarService.class);
            if (r100 != null) goto L5;
            r100 = new ICreationAvatarServiceNoop();
        L5:
            this.f373909b = r100;
        }
    }

    static {
        f373907a = Companion.f373908c;
    }

    Object C(Continuation<? super String> r100);

    void F();

    com.larus.uaigc.api.a G();

    List<ey9.k> K();

    void O();

    void P();

    List<ey9.k> Q();

    DialogFragment R(dy9.a r100);

    boolean S();

    void T(String r100);

    boolean U();

    q97.a a();

    void c(String r100);

    sq9.u d();

    boolean h();

    void i();

    ey9.k p();

    ey9.a q();

    List<ey9.k> u();

    boolean v();
}
