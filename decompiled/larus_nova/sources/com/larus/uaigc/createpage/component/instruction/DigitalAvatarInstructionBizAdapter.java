package com.larus.uaigc.createpage.component.instruction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.z2;
import com.larus.trace.DigitalAvatarProcessType;
import com.larus.uaigc.api.AIReplicaApi;
import com.larus.uaigc.createpage.CreationHostUiPolicy;
import com.larus.uaigc.service.ICreationAvatarService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes31.dex */
public final class DigitalAvatarInstructionBizAdapter extends vp8.g {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f371766s = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BaseContentWidget f371767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final vp8.j f371768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f371769j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f371770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f371771l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f371772m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Balloon f371773n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f371774o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f371775p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f371776q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Triple<Integer, Integer, Integer> f371777r;

    public static final class a {
    }

    static {
    }

    private final Context getContext() {
        return this.f371767h.getContext();
    }

    @Override // vp8.g
    public final void p() {
        ActivityResultLauncher<Intent> r100 = this.f371770k;
        if (r100 == null) goto L6;
        r100.unregister();
        return;
    }

    public final void I() {
        this.f371772m = fy9.a.a();
        String r100 = null;
        if ((getContext() instanceof ny9.h) == false) goto L5;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f371767h), null, null, new DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1(this, null), 3, null);
        return;
    L5:
        com.bytedance.router.i r101 = SmartRouter.buildRoute(getContext(), "//flow/create_digital_avatar");
        int r102 = CreationHostUiPolicy.f371382f;
        boolean r103 = CreationHostUiPolicy.a.a(this.f556664g.getArguments()).f371383a;
        r101.f267554c.putExtra("from_ai_creation_applet", r103);
        int r104 = DigitalAvatarProcessType.BOTH_IMAGE_AND_VIDEO.getId();
        r101.f267554c.putExtra("digital_avatar_process_type", r104);
        r101.f267554c.putExtra("skip_digital_avatar_onboarding", true);
        com.larus.bmhome.chat.component.cvs.y r105 = (com.larus.bmhome.chat.component.cvs.y) this.f556661d.getValue();
        if (r105 == null) goto L10;
        wc9.e r106 = r105.h();
        if (r106 == null) goto L10;
        r100 = r106.f559198a;
    L10:
        r101.f267554c.putExtra("argConversationId", r100);
        Bundle r107 = new Bundle();
        r107.putString("previous_page", "chat");
        r107.putString("replica_create_id", this.f371772m);
        r101.f267554c.putExtras(r107);
        r101.f267555d = R.anim.larus_router_slide_in_bottom;
        r101.f267556e = R.anim.larus_router_no_anim;
        r101.d();
    }

    @Override // vp8.g
    public final void d() {
        if ((getContext() instanceof ny9.h) == false) goto L5;
        this.f371770k = this.f556664g.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b2(this));
        return;
    L5:
        this.f371770k = this.f556664g.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c2(this));
    }

    public static void A(final DigitalAvatarInstructionBizAdapter r100) {
        if (ICreationAvatarService.f373907a.S() == false) goto L7;
        t19.s.j(t19.s.f544207a, r100.getContext(), r100.getContext().getString(R.string.larus_portrait_bottomsheet_err_toast_replace), null, false, 28);
        Balloon r101 = r100.f371773n;
        if (r101 == null) goto L25;
        r101.h();
        return;
    L25:
        return;
    L7:
        tx9.r0.f("chat", "reset_replica");
        if (z2.f365865a.hasAvatarModelUpdate() == false) goto L10;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.f371767h), null, null, new DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$1$1(r100, null), 3, null);
    L21:
        Balloon r102 = r100.f371773n;
        if (r102 == null) goto L27;
        r102.h();
        return;
    L27:
        return;
    L10:
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L17;
        r103.H();
        VideoPortraitConfig r104 = com.larus.home.impl.sdk.l1.f346198a.a();
        if (r104 == null) goto L17;
        boolean r105 = true;
        if (r104.getEnableVideoAvatar() != true) goto L17;
    L18:
        if (r105 == false) goto L20;
        r100.I();
        goto L21
    L20:
        Function0 r106 = new j2(r100);
        r100.getClass();
        com.larus.platform.service.k2 r107 = com.larus.platform.service.k2.f365755a;
        g3.a.a(r100.f556664g, null, true, null, false, new i2(r106), 26);
    L17:
        r105 = false;
        goto L18
    }

    public static final /* synthetic */ Context C(DigitalAvatarInstructionBizAdapter r100) {
        return r100.getContext();
    }

    @Override // vp8.g
    public final boolean q(final com.larus.bmhome.actionbar.model.r r100) {
        Integer r101 = r100.f295408a;
        if (r101 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L21;
        ViewGroup r103 = this.f371775p;
        ConstraintLayout r104 = null;
        if (r103 == null) goto L13;
        ImageView r105 = (ImageView) r103.findViewById(R.id.ic_arrow);
    L14:
        if (r105 == null) goto L16;
        com.larus.utils.e1.x(r105);
    L16:
        ViewGroup r106 = this.f371775p;
        if (r106 == null) goto L19;
        r104 = (ConstraintLayout) r106.findViewById(R.id.title_content_container);
    L19:
        if (r104 == null) goto L21;
        com.larus.utils.e1.d(r104, new d2(this, r100));
        goto L21
    L13:
        r105 = null;
    L21:
        return false;
    L6:
        if (r101.intValue() != 11) goto L8;
        r102 = true;
        goto L9
    }

    @Override // vp8.g
    public final void u(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        this.f371775p = r100;
    }

    public static void B(CommonDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, null, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, null);
    }

    public static final void E(DigitalAvatarInstructionBizAdapter r100, String r101) {
        r100.getClass();
        tx9.r0.f("chat", "confirm_delete_replica");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.f371767h), null, null, new DigitalAvatarInstructionBizAdapter$realDeleteDigitalAvatar$1(r100, r101, null), 3, null);
    }

    public static final void G(DigitalAvatarInstructionBizAdapter r110, Triple r111) {
        r110.getClass();
        if (r111 == null) goto L5;
        int r100 = ((Number) r111.getFirst()).intValue();
    L6:
        if (r111 == null) goto L8;
        int r112 = ((Number) r111.getSecond()).intValue();
    L9:
        CommonDialog.a r101 = new CommonDialog.a();
        AppHost.Companion r102 = AppHost.f326268a;
        r101.i(r102.getApplication().getString(R.string.larus_replica_popUp_createNew));
        r101.g(r102.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupDesc_generationFail) + r102.getApplication().getResources().getQuantityString(R.plurals.larus_replica_gen_msg_prompt2, r100, new Object[]{Integer.valueOf(r100)}) + r102.getApplication().getResources().getQuantityString(R.plurals.larus_replica_gen_msg_prompt3, r112, new Object[]{Integer.valueOf(r112)}));
        com.larus.common_ui.dialog.f0 r103 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r110.getContext(), R.color.larus_conditional_danger_50)), null, 5);
        Intrinsics.checkNotNullParameter(r103, "commonDialogTextStyleConfig");
        r101.D = r103;
        com.larus.common_ui.dialog.f0 r104 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r110.getContext(), v19.c.b(R.attr.larus_neutral_70, r110.getContext(), R.color.larus_neutral_70))), null, 5);
        Intrinsics.checkNotNullParameter(r104, "commonDialogTextStyleConfig");
        r101.E = r104;
        r101.h(ContextCompat.getColor(r110.getContext(), v19.c.b(R.attr.larus_neutral_70, r110.getContext(), R.color.larus_neutral_70)));
        CommonDialog.a.f(r101, new p2(r112, r110), r102.getApplication().getString(R.string.larus_replica_popUp_btn_createNew), false, 12);
        CommonDialog.a.e(r101, new q2(), r102.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupBtn_cancel), 4);
        B(r101.a(), r110.f556664g.getChildFragmentManager());
        return;
    L8:
        r112 = 0;
        goto L9
    L5:
        r100 = 0;
        goto L6
    }

    public static final Object H(DigitalAvatarInstructionBizAdapter r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1) == false) goto L7;
        DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1 r102 = (DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        int r107 = 1;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        dm9.a r108 = (dm9.a) r104;
        int r109 = 0;
        if ((r108 instanceof dm9.a.b) == false) goto L31;
        FLogger.f375446a.i("DigitalAvatarInstructionBizAdapter", "fetch train quota success");
        dm9.a.b r110 = (dm9.a.b) r108;
        com.larus.uaigc.api.b r111 = (com.larus.uaigc.api.b) r110.f469231a.getData();
        if (r111 == null) goto L22;
        int r112 = r111.c();
    L23:
        Integer r113 = Boxing.boxInt(r112);
        com.larus.uaigc.api.b r114 = (com.larus.uaigc.api.b) r110.f469231a.getData();
        if (r114 == null) goto L26;
        r109 = r114.a();
    L26:
        Integer r115 = Boxing.boxInt(r109);
        com.larus.uaigc.api.b r116 = (com.larus.uaigc.api.b) r110.f469231a.getData();
        if (r116 == null) goto L29;
        r107 = r116.b();
    L29:
        Triple<Integer, Integer, Integer> r117 = new Triple(r113, r115, Boxing.boxInt(r107));
    L33:
        r100.f371777r = r117;
        return Unit.INSTANCE;
    L22:
        r112 = 0;
        goto L23
    L31:
        if ((r108 instanceof dm9.a.C5690a) == false) goto L36;
        FLogger.f375446a.i("DigitalAvatarInstructionBizAdapter", "fetch train quota fail: " + ((dm9.a.C5690a) r108).f469230c);
        r117 = new Triple(Boxing.boxInt(0), Boxing.boxInt(0), Boxing.boxInt(0));
        goto L33
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        AIReplicaApi.Companion r118 = AIReplicaApi.f370258a;
        DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$result$1 r119 = new DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$result$1(null);
        r102.label = 1;
        r118.getClass();
        r104 = AIReplicaApi.Companion.b(r119, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1(r100, r101);
        goto L8
    }

    public static void v(DigitalAvatarInstructionBizAdapter r100, ActivityResult r101) {
        tx9.d2 r102 = tx9.d2.f547848a;
        int r103 = r101.getResultCode();
        r102.getClass();
        tx9.d2.c(r103, "digital_avatar_instruction");
        if (r101.getResultCode() != (-1)) goto L39;
        Intent r104 = r101.getData();
        if (r104 == null) goto L7;
        ArrayList r105 = r104.getParcelableArrayListExtra("result.uri.list");
    L8:
        if (r105 == null) goto L15;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L11:
        if (r107.hasNext() == false) goto L16;
        Uri r108 = ((AlbumSelectItem) r107.next()).f365506a;
        if (r108 == null) goto L11;
        r106.add(r108);
    L16:
        if (r106 != null) goto L18;
    L21:
        boolean r109 = true;
    L22:
        if (r109 == true) goto L41;
        va8.o r110 = (va8.o) r100.f371771l.getValue();
        if (r110 == null) goto L27;
        r110.ra();
    L27:
        Object r111 = r100.getContext();
        if ((r111 instanceof ny9.h) == false) goto L30;
        ny9.h r112 = (ny9.h) r111;
    L31:
        if (r112 == null) goto L40;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.f371767h), null, null, new DigitalAvatarInstructionBizAdapter$onAttach$1$1$1(r100, r106, null), 3, null);
        return;
    L40:
        return;
    L30:
        r112 = null;
        goto L31
    L41:
        return;
    L18:
        if (r106.isEmpty() == true) goto L21;
        r109 = false;
        goto L22
    L15:
        r106 = null;
        goto L16
    L7:
        r105 = null;
        goto L8
    }

    public static void y(DigitalAvatarInstructionBizAdapter r110, String r111) {
        if (ICreationAvatarService.f373907a.S() == false) goto L7;
        t19.s.j(t19.s.f544207a, r110.getContext(), r110.getContext().getString(R.string.larus_portrait_bottomsheet_err_toast_delete), null, false, 28);
        Balloon r112 = r110.f371773n;
        if (r112 == null) goto L21;
        r112.h();
        return;
    L21:
        return;
    L7:
        tx9.r0.f("chat", "delete_replica");
        ICoreInputAbility r100 = r110.c();
        if (r100 == null) goto L11;
        r100.qp(false);
    L11:
        if (z2.f365865a.hasAvatarModelUpdate() == false) goto L13;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110.f371767h), null, null, new DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$2$1(r110, r111, null), 3, null);
    L14:
        com.larus.bmhome.instruction.g r113 = (com.larus.bmhome.instruction.g) r110.f556659b.getValue();
        if (r113 == null) goto L17;
        r113.A1();
    L17:
        Balloon r114 = r110.f371773n;
        if (r114 == null) goto L23;
        r114.h();
        return;
    L23:
        return;
    L13:
        CommonDialog.a r101 = new CommonDialog.a();
        AppHost.Companion r102 = AppHost.f326268a;
        r101.i(r102.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupTitle_deleteReplica));
        r101.g(r102.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupDesc_generationFail));
        com.larus.common_ui.dialog.f0 r103 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r110.getContext(), v19.c.b(R.attr.larus_neutral_100, r110.getContext(), R.color.larus_neutral_100))), null, 5);
        Intrinsics.checkNotNullParameter(r103, "commonDialogTextStyleConfig");
        r101.D = r103;
        com.larus.common_ui.dialog.f0 r104 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r110.getContext(), v19.c.b(R.attr.larus_neutral_70, r110.getContext(), R.color.larus_neutral_70))), null, 5);
        Intrinsics.checkNotNullParameter(r104, "commonDialogTextStyleConfig");
        r101.E = r104;
        r101.h(ContextCompat.getColor(r110.getContext(), v19.c.b(R.attr.larus_neutral_70, r110.getContext(), R.color.larus_neutral_70)));
        CommonDialog.a.f(r101, new k2(r110, r111), r102.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupBtn_delete), false, 12);
        CommonDialog.a.e(r101, new l2(), r102.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupBtn_cancel), 4);
        B(r101.a(), r110.f556664g.getChildFragmentManager());
        goto L14
    }

    public DigitalAvatarInstructionBizAdapter(BaseContentWidget r100, vp8.j r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "component");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        super(r100);
        this.f371767h = r100;
        this.f371768i = r101;
        this.f371769j = r102;
        this.f371771l = LazyKt.lazy(new e2(this));
        LaunchInfo r103 = AuthModelDelegate.f297134b.x().getValue();
        if (r103 != null) goto L5;
    L8:
        int r104 = 10;
    L9:
        this.f371776q = r104;
        return;
    L5:
        if (r103.K() <= 0) goto L8;
        r104 = r103.K();
        goto L9
    }

    public static final Object D(DigitalAvatarInstructionBizAdapter r100, Function2 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$1) == false) goto L7;
        DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$1 r103 = (DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (Function2) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        wc9.e r108 = (wc9.e) r105;
    L25:
        r103.L$0 = null;
        r103.label = 2;
        if (r101.invoke(r108, r103) != r106) goto L29;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        ILaunchCacheService r109 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r109 == null) goto L21;
        r108 = r109.b();
        if (r108 != null) goto L25;
    L21:
        Flow r110 = FlowLiveDataConversions.asFlow(AuthModelDelegate.f297134b.y());
        DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$cvs$2 r111 = new DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$cvs$2(null);
        r103.L$0 = r101;
        r103.label = 1;
        r105 = kotlinx.coroutines.flow.e.t(r110, r111, r103);
        if (r105 != r106) goto L24;
        return r106;
    L7:
        r103 = new DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$1(r100, r102);
        goto L8
    }

    public static final void F(DigitalAvatarInstructionBizAdapter r110, String r111, Triple r112) {
        r110.getClass();
        if (r112 == null) goto L5;
        int r100 = ((Number) r112.getFirst()).intValue();
    L6:
        if (r112 == null) goto L8;
        int r113 = ((Number) r112.getSecond()).intValue();
    L9:
        CommonDialog.a r101 = new CommonDialog.a();
        AppHost.Companion r102 = AppHost.f326268a;
        r101.i(r102.getApplication().getString(R.string.larus_replica_popUp_delete));
        r101.g(r102.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupDesc_generationFail) + r102.getApplication().getResources().getQuantityString(R.plurals.larus_replica_gen_msg_prompt2, r100, new Object[]{Integer.valueOf(r100)}) + r102.getApplication().getResources().getQuantityString(R.plurals.larus_replica_gen_msg_prompt3, r113, new Object[]{Integer.valueOf(r113)}));
        com.larus.common_ui.dialog.f0 r114 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r110.getContext(), R.color.larus_conditional_danger_50)), null, 5);
        Intrinsics.checkNotNullParameter(r114, "commonDialogTextStyleConfig");
        r101.D = r114;
        com.larus.common_ui.dialog.f0 r115 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r110.getContext(), v19.c.b(R.attr.larus_neutral_70, r110.getContext(), R.color.larus_neutral_70))), null, 5);
        Intrinsics.checkNotNullParameter(r115, "commonDialogTextStyleConfig");
        r101.E = r115;
        r101.h(ContextCompat.getColor(r110.getContext(), v19.c.b(R.attr.larus_neutral_70, r110.getContext(), R.color.larus_neutral_70)));
        CommonDialog.a.f(r101, new m2(r110, r111), r102.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupBtn_delete), false, 12);
        CommonDialog.a.e(r101, new n2(), r102.getApplication().getString(R.string.larus_mob_ccBot_AIReplica_popupBtn_cancel), 4);
        B(r101.a(), r110.f556664g.getChildFragmentManager());
        return;
    L8:
        r113 = 0;
        goto L9
    L5:
        r100 = 0;
        goto L6
    }
}
