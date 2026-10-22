package com.larus.profile.impl;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.collection.profile.api.CollectServiceDelegate;
import com.larus.account.base.api.IAccountService;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.AccountService;
import com.larus.profile.api.IProfileApi;
import com.larus.profile.impl.mine.MineTabFragment;
import com.larus.profile.impl.mine.PageMineTabFragment;
import com.larus.profile.impl.view.ProfileAvatarViewerDialog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J(\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\fH\u0016J\u0016\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020$H\u0096@¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.H\u0096@¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\fH\u0016J\b\u00101\u001a\u00020\fH\u0016J\b\u00102\u001a\u00020\fH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u00064"}, d2 = {"Lcom/larus/profile/impl/ProfileServiceImpl;", "Lcom/larus/profile/api/IProfileApi;", "<init>", "()V", "collectListStyle", "", "getCollectListStyle", "()I", "collectListStyle$delegate", "Lkotlin/Lazy;", "creationUpdateLive", "Landroidx/lifecycle/MutableLiveData;", "", "getCreationUpdateLive", "()Landroidx/lifecycle/MutableLiveData;", "collectionUpdateLive", "getCollectionUpdateLive", "userInfoFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/account/base/model/profile/UserInfo;", "getUserInfoFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "createPageMineTabFragment", "Lcom/larus/profile/api/model/IPageMineTabFragment;", "showCreationCallback", "Lkotlin/Function0;", "", "dismissCreationCallback", "createMineTabFragment", "Lcom/larus/common_ui/tab/TabChildFragment;", "createOtherProfileFragment", "Landroidx/fragment/app/Fragment;", "showProfileAvatarViewDialog", "activity", "Landroidx/fragment/app/FragmentActivity;", "avatarUrl", "", "enterFrom", "canEditProfile", "queryUserInfoWhenCacheEmpty", "source", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUserCreationList", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/UserCreationListResponse;", "request", "Lcom/larus/profile/api/bean/RequestCreationGroupData;", "(Lcom/larus/profile/api/bean/RequestCreationGroupData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasRevisitList", "hasLikeRevisitList", "baseProfileEnable", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileServiceImpl implements IProfileApi {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f366056f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f366057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f366058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Boolean> f366059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableSharedFlow<r38.b> f366060e;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.profile.api.IProfileApi
    public final s19.a d() {
        return new MineTabFragment();
    }

    @Override // com.larus.profile.api.IProfileApi
    public final boolean g() {
        int r100 = ((Number) this.f366057b.getValue()).intValue();
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L8;
        return CollectServiceDelegate.f273530b.a();
    L8:
        return CollectServiceDelegate.f273530b.k();
    }

    @Override // com.larus.profile.api.IProfileApi
    public final boolean i() {
        int r100 = ((Number) this.f366057b.getValue()).intValue();
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L8;
        return false;
    L8:
        return CollectServiceDelegate.f273530b.k();
    }

    public ProfileServiceImpl() {
        this.f366057b = LazyKt.lazy(new f2());
        this.f366058c = new MutableLiveData();
        this.f366059d = new MutableLiveData();
        this.f366060e = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
    }

    @Override // com.larus.profile.api.IProfileApi
    public final MutableSharedFlow<r38.b> b() {
        return this.f366060e;
    }

    @Override // com.larus.profile.api.IProfileApi
    public final MutableLiveData<Boolean> h() {
        return this.f366058c;
    }

    @Override // com.larus.profile.api.IProfileApi
    public final MutableLiveData<Boolean> j() {
        return this.f366059d;
    }

    @Override // com.larus.profile.api.IProfileApi
    public final Object a(fs9.x r100, Continuation<? super com.larus.network.http.a<fs9.b0>> r101) {
        Lazy<ProfileRepo> r102 = ProfileRepo.f366052b;
        ProfileRepo.a.a().getClass();
        return ProfileRepo.d(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.profile.api.IProfileApi
    public final Object e(String r210, Continuation<? super Boolean> r211) {
        String r100 = r210;
        if ((r211 instanceof ProfileServiceImpl$queryUserInfoWhenCacheEmpty$1) == false) goto L7;
        ProfileServiceImpl$queryUserInfoWhenCacheEmpty$1 r101 = (ProfileServiceImpl$queryUserInfoWhenCacheEmpty$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r111 = false;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        ResultKt.throwOnFailure(r103);
    L49:
        r111 = ((Boolean) r103).booleanValue();
    L52:
        return Boxing.boxBoolean(r111);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        String r105 = "ProfileServiceImpl";
    L45:
        if ((((com.larus.network.http.a) r103) instanceof com.larus.network.http.y) == false) goto L50;
        FLogger.f375446a.i(r105, "updateDefaultProfile success");
        String r106 = ProfileRequestSource.LAZY_LOAD.getValue();
        r101.label = 3;
        r103 = e(r106, r101);
        if (r103 != r110) goto L49;
        return r110;
    L50:
        FLogger.f375446a.i(r105, "updateDefaultProfile fail");
        goto L52
    L17:
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r107 = r103;
        int r108 = 2;
        boolean r112 = true;
    L25:
        com.larus.network.http.a r109 = (com.larus.network.http.a) r107;
        if ((r109 instanceof com.larus.network.http.y) == false) goto L36;
        fs9.s r113 = (fs9.s) ((com.larus.network.http.y) r109).f360135b;
        if (r113 == null) goto L34;
        r38.b r114 = r113.b();
        if (r114 == null) goto L34;
        IAccountService.Companion r115 = IAccountService.f286094a;
        r115.l(r114);
        r115.o(AccountService.f365697a.getUserId(), r114.c(), r100);
        return Boxing.boxBoolean(r112);
    L34:
        return Boxing.boxBoolean(false);
    L36:
        if ((r109 instanceof com.larus.network.http.f) == false) goto L54;
        if (((com.larus.network.http.f) r109).f360157d.getCode() != 710012014) goto L54;
        if (Intrinsics.areEqual(r100, "settings_page") == false) goto L54;
        r105 = "ProfileServiceImpl";
        FLogger.f375446a.i(r105, "queryUserInfoWhenCacheEmpty fail with USER_NOT_EXISTS, try to update default profile");
        Lazy<ProfileRepo> r116 = ProfileRepo.f366052b;
        ProfileRepo r117 = ProfileRepo.a.a();
        r101.L$0 = null;
        r101.label = r108;
        r117.getClass();
        r103 = ProfileRepo.g(r101);
        if (r103 != r110) goto L45;
        return r110;
    L54:
        return Boxing.boxBoolean(false);
    L18:
        ResultKt.throwOnFailure(r103);
        if (IAccountService.f286094a.getUserInfo() != null) goto L21;
        FlowDowngradeServiceDelegate r118 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r119 = new JSONObject();
        Map r120 = MapsKt.mapOf(TuplesKt.to("source", r100));
        r101.L$0 = r100;
        r101.label = 1;
        r108 = 2;
        r112 = true;
        r107 = IFlowDowngradeService.a.b(r118, ServiceType.UGC, fs9.s.class, "/alice/profile/self_brief", r119, null, false, null, r120, r101, 1008);
        if (r107 != r110) goto L25;
        return r110;
    L21:
        return Boxing.boxBoolean(true);
    L7:
        r101 = new ProfileServiceImpl$queryUserInfoWhenCacheEmpty$1(this, r211);
        goto L8
    }

    @Override // com.larus.profile.api.IProfileApi
    public final gs9.h f(Function0<Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "showCreationCallback");
        Intrinsics.checkNotNullParameter(r101, "dismissCreationCallback");
        PageMineTabFragment r102 = new PageMineTabFragment();
        r102.E = r100;
        r102.F = r101;
        return r102;
    }

    @Override // com.larus.profile.api.IProfileApi
    public final void c(FragmentActivity r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        ProfileAvatarViewerDialog r104 = new ProfileAvatarViewerDialog(r100, r101, r102, r103);
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r104);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
    }
}
