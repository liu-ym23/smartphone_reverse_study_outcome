package com.larus.uaigc.createpage.component.digitalavatar;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.uaigc.api.AIReplicaApi;
import com.larus.uaigc.impl.databinding.LarusLayoutDigitalAvatarCreateBtnBinding;
import com.larus.uaigc.service.ICreationAvatarService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import tx9.r0;
import v19.c7;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 b2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020<H\u0016J\u0010\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@H\u0016J \u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u000eH\u0016J\u0012\u0010F\u001a\u00020<2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J4\u0010G\u001a\u00020<2$\u0010H\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010J\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0K\u0012\u0006\u0012\u0004\u0018\u00010L0IH\u0082@¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020<H\u0002J\u0016\u0010O\u001a\u00020<2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020<0QH\u0002J\u0018\u0010R\u001a\u00020<2\u0006\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020\u000eH\u0002J\u000e\u0010U\u001a\u00020<H\u0082@¢\u0006\u0002\u0010VJ$\u0010W\u001a\u00020<2\u001a\u0010X\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010:H\u0002J,\u0010Y\u001a\u00020<2\u0006\u0010T\u001a\u00020\u000e2\u001a\u0010X\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010:H\u0002J\u0010\u0010Z\u001a\u00020<2\u0006\u0010T\u001a\u00020\u000eH\u0002J\u0010\u0010[\u001a\u00020<2\u0006\u0010T\u001a\u00020\u000eH\u0002J\b\u0010\\\u001a\u00020<H\u0002J\b\u0010]\u001a\u00020<H\u0002J\b\u0010^\u001a\u00020<H\u0002J\b\u0010_\u001a\u00020<H\u0002J\b\u0010`\u001a\u00020<H\u0002J\b\u0010a\u001a\u00020\bH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0016\u001a\u0004\b%\u0010&R(\u0010(\u001a\u000f\u0012\t\u0012\u00070*¢\u0006\u0002\b+\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/larus/uaigc/createpage/component/digitalavatar/DigitalAvatarComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/uaigc/bean/createpage/component/digitalavatar/IDigitalAvatarAbility;", "<init>", "()V", "_hasAvatar", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "hasAvatar", "Lkotlinx/coroutines/flow/StateFlow;", "getHasAvatar", "()Lkotlinx/coroutines/flow/StateFlow;", "avatarUrl", "", "delayShowGeneratingJob", "Lkotlinx/coroutines/Job;", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "createAvatarBtn", "Lcom/larus/uaigc/impl/databinding/LarusLayoutDigitalAvatarCreateBtnBinding;", "getCreateAvatarBtn", "()Lcom/larus/uaigc/impl/databinding/LarusLayoutDigitalAvatarCreateBtnBinding;", "createAvatarBtn$delegate", "createAvatarMaxUploadImgCnt", "", "instructionEditAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getInstructionEditAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "instructionEditAbility$delegate", "templateFeedAbility", "Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "getTemplateFeedAbility", "()Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "templateFeedAbility$delegate", "generatingToastViewStub", "Lcom/larus/common_ui/view/ViewStubManager;", "Lcom/larus/uaigc/impl/databinding/LarusLayoutAvatarGeneratingToastBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getGeneratingToastViewStub", "()Lcom/larus/common_ui/view/ViewStubManager;", "generatingToastViewStub$delegate", "morePopupLastDismissTime", "", "morePopup", "Lcom/skydoves/balloon/Balloon;", "replicaCreateId", "pickImagesLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "titleView", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "trainQuotaInfo", "Lkotlin/Triple;", "onAttach", "", WidgetCostModule.TYPE_ON_CREATE, "onViewCreated", "view", "Landroid/view/View;", "onDigitalAvatarTemplateChoose", "templateInfo", "Lcom/larus/bmhome/avatar/api/DigitalAvatarTemplate;", "position", "enterFrom", "createDigitalAvatar", "getMainBotConversationInfo", "callback", "Lkotlin/Function2;", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLauncher", "checkGalleryPermission", "doNext", "Lkotlin/Function0;", "openDigitalAvatarMenu", "hostView", "digitalAvatarId", "tryFetchTrainQuotaInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showQuotaRemindReGenDialog", "replicaTrainQuotaInfo", "showQuotaRemindDeleteDialog", "delDigitalAvatar", "realDeleteDigitalAvatar", "initWhiteTUrl", "initTitle", "initInputWidget", "initCreateAvatarBtn", "regenerateVideoAvatar", "shouldPropagateAICreationHostSource", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigitalAvatarComponent extends BaseContentWidget implements oy9.a {
    public static final /* synthetic */ int C = 0;
    public NovaTitleBarEx A;
    public Triple<Integer, Integer, Integer> B;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final StateFlowImpl f371526m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b1 f371527n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final StateFlowImpl f371528o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Job f371529p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f371530q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f371531r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f371532s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f371533t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f371534u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f371535v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f371536w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Balloon f371537x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f371538y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f371539z;

    public static final class a {
    }

    static {
    }

    public final ny9.s B3() {
        return (ny9.s) this.f371530q.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, oy9.a.class);
    }

    public DigitalAvatarComponent() {
        StateFlowImpl r100 = j1.a(Boolean.FALSE);
        this.f371526m = r100;
        this.f371527n = kotlinx.coroutines.flow.e.b(r100);
        DigitalAvatarInfoManager.f371542a.getClass();
        this.f371528o = DigitalAvatarInfoManager.f371543b;
        this.f371530q = LazyKt.lazy(new com.larus.uaigc.createpage.component.digitalavatar.a(this));
        this.f371531r = LazyKt.lazy(new e(this));
        LaunchInfo r101 = AuthModelDelegate.f297134b.x().getValue();
        if (r101 != null) goto L5;
    L8:
        int r102 = 10;
    L9:
        this.f371532s = r102;
        this.f371533t = LazyKt.lazy(new f(this));
        this.f371534u = LazyKt.lazy(new g(this));
        this.f371535v = LazyKt.lazy(new h(this));
        return;
    L5:
        if (r101.K() <= 0) goto L8;
        r102 = r101.K();
        goto L9
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        super.onCreate();
        ny9.s r100 = B3();
        if (r100 == null) goto L5;
        z0 r101 = r100.f();
    L6:
        StateFlowImpl r102 = this.f371526m;
        boolean r103 = false;
        if (r101 == null) goto L14;
        Integer r104 = r101.f295611g;
        int r105 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r104 == null) goto L14;
        if (r104.intValue() != r105) goto L14;
        boolean r106 = true;
    L15:
        r102.setValue(Boolean.valueOf(!r106));
        if (((Boolean) this.f371526m.getValue()).booleanValue() == true) goto L27;
        ny9.s r107 = B3();
        if (r107 != null) goto L20;
    L22:
        if (r103 == false) goto L28;
        z3(null);
        com.larus.uaigc.createpage.v r108 = (com.larus.uaigc.createpage.v) s1a.d.a(this).getAbility(com.larus.uaigc.createpage.v.class);
        if (r108 == null) goto L29;
        r108.kB(true);
        return;
    L29:
        return;
    L28:
        return;
    L20:
        if (r107.D() != true) goto L22;
        r103 = true;
        goto L22
    L27:
        return;
    L14:
        r106 = false;
        goto L15
    L5:
        r101 = null;
        goto L6
    }

    @Override // oy9.a
    public final b1 Hc() {
        return this.f371527n;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.f371539z = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(this));
        final NovaTitleBarEx r111 = (NovaTitleBarEx) F2().findViewById(R.id.title);
        this.A = r111;
        ny9.s r100 = B3();
        if (r100 == null) goto L5;
        String r101 = r100.w();
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        NovaTitleBarEx.Y5(r111, r101, null, null, 6);
        e1.d(r111.getBinding().f326840f, new j(this, r111));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DigitalAvatarComponent$initWhiteTUrl$1(this, null), 3, null);
        View r112 = F2();
        if ((r112 instanceof ConstraintLayout) == false) goto L11;
        ConstraintLayout r113 = (ConstraintLayout) r112;
    L13:
        if (r113 == null) goto L19;
        r113.addView(((LarusLayoutDigitalAvatarCreateBtnBinding) this.f371531r.getValue()).f373217a);
        ConstraintSet r102 = new ConstraintSet();
        r102.clone(r113);
        r102.connect(R.id.avatar_create_btn_root, 4, R.id.root, 4);
        r102.connect(R.id.avatar_create_btn_root, 6, R.id.root, 6);
        r102.connect(R.id.avatar_create_btn_root, 7, R.id.root, 7);
        r102.applyTo(r113);
        RoundConstraintLayout r114 = ((LarusLayoutDigitalAvatarCreateBtnBinding) this.f371531r.getValue()).f373217a;
        ViewGroup.LayoutParams r103 = r114.getLayoutParams();
        if (r103 == null) goto L18;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        r104.bottomMargin = c7.b(12);
        r114.setLayoutParams(r104);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DigitalAvatarComponent$initCreateAvatarBtn$2(this, null), 3, null);
        e1.d(((LarusLayoutDigitalAvatarCreateBtnBinding) this.f371531r.getValue()).f373217a, new i(this));
        if (((Boolean) this.f371527n.getValue()).booleanValue() == true) goto L43;
        sq9.u r115 = ICreationAvatarService.f373907a.d();
        if (r115 != null) goto L24;
    L26:
        boolean r116 = false;
    L27:
        if (r116 == false) goto L43;
        ny9.s r117 = B3();
        if (r117 == null) goto L37;
        z0 r118 = r117.f();
        if (r118 == null) goto L37;
        com.larus.bmhome.actionbar.model.r r119 = r118.f295621q;
        if (r119 == null) goto L37;
        com.larus.bmhome.actionbar.model.j1 r120 = r119.f295412e;
        if (r120 == null) goto L37;
        String r121 = r120.f295236h;
    L39:
        if (Intrinsics.areEqual(r121, "1") == false) goto L43;
        if (z2.f365865a.l1() == true) goto L43;
        z3(null);
    L37:
        r121 = null;
        goto L39
    L24:
        if (r115.a() == true) goto L26;
        r116 = true;
    L43:
        View r122 = F2().findViewById(R.id.chat_input);
        if (r122 == null) goto L47;
        r122.setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_base_1, getContext(), R.color.larus_base_1)), ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_base_1, getContext(), R.color.larus_base_1)), ContextCompat.getColor(getContext(), R.color.static_white_transparent_0), ContextCompat.getColor(getContext(), R.color.static_white_transparent_0)}));
        return;
    L47:
        return;
    L11:
        r113 = null;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final void z3(ab8.a r100) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DigitalAvatarComponent$createDigitalAvatar$1(this, r100, null), 3, null);
    }

    public static void Y2(CommonDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, null, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, null);
    }

    public static final void m3(DigitalAvatarComponent r100, String r101) {
        r100.getClass();
        r0.f("replica", "confirm_delete_replica");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new DigitalAvatarComponent$realDeleteDigitalAvatar$1(r100, r101, null), 3, null);
    }

    public static final Object p3(DigitalAvatarComponent r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof DigitalAvatarComponent$tryFetchTrainQuotaInfo$1) == false) goto L7;
        DigitalAvatarComponent$tryFetchTrainQuotaInfo$1 r102 = (DigitalAvatarComponent$tryFetchTrainQuotaInfo$1) r101;
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
        FLogger.f375446a.i("DigitalAvatarComponent", "fetch train quota success");
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
        r100.B = r117;
        return Unit.INSTANCE;
    L22:
        r112 = 0;
        goto L23
    L31:
        if ((r108 instanceof dm9.a.C5690a) == false) goto L36;
        FLogger.f375446a.i("DigitalAvatarComponent", "fetch train quota fail: " + ((dm9.a.C5690a) r108).f469230c);
        r117 = new Triple(Boxing.boxInt(0), Boxing.boxInt(0), Boxing.boxInt(0));
        goto L33
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        AIReplicaApi.Companion r118 = AIReplicaApi.f370258a;
        DigitalAvatarComponent$tryFetchTrainQuotaInfo$result$1 r119 = new DigitalAvatarComponent$tryFetchTrainQuotaInfo$result$1(null);
        r102.label = 1;
        r118.getClass();
        r104 = AIReplicaApi.Companion.b(r119, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new DigitalAvatarComponent$tryFetchTrainQuotaInfo$1(r100, r101);
        goto L8
    }

    public static final Object h3(DigitalAvatarComponent r100, Function2 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof DigitalAvatarComponent$getMainBotConversationInfo$1) == false) goto L7;
        DigitalAvatarComponent$getMainBotConversationInfo$1 r103 = (DigitalAvatarComponent$getMainBotConversationInfo$1) r102;
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
        DigitalAvatarComponent$getMainBotConversationInfo$cvs$2 r111 = new DigitalAvatarComponent$getMainBotConversationInfo$cvs$2(null);
        r103.L$0 = r101;
        r103.label = 1;
        r105 = kotlinx.coroutines.flow.e.t(r110, r111, r103);
        if (r105 != r106) goto L24;
        return r106;
    L7:
        r103 = new DigitalAvatarComponent$getMainBotConversationInfo$1(r100, r102);
        goto L8
    }

    @Override // oy9.a
    public final void onDigitalAvatarTemplateChoose(ab8.a r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "templateInfo");
        Intrinsics.checkNotNullParameter(MusicAppletPage.SOURCE_TEMPLATE_LIST, "enterFrom");
        if (((Boolean) this.f371527n.getValue()).booleanValue() == false) goto L7;
        ys8.a r103 = (ys8.a) this.f371533t.getValue();
        if (r103 == null) goto L9;
        r103.onDigitalAvatarTemplateChoose(r100, r101, MusicAppletPage.SOURCE_TEMPLATE_LIST);
        return;
    L9:
        return;
    L7:
        z3(r100);
    }
}
