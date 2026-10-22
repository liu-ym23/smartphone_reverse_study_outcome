package com.larus.avatar.impl.scan.component;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.avatar.impl.manager.QuotaValidationManager;
import com.larus.avatar.impl.scan.ScanCameraViewModel;
import com.larus.avatar.impl.scan.utils.EmptyPermissionFragment;
import com.larus.avatar.impl.scan.view.ScanCameraBeautyButton;
import com.larus.avatar.impl.scan.view.ScanCameraBeautyLevel;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.trace.DigitalAvatarProcessType;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00060\u0001j\u0002`\u00022\u00020\u0003:\u00011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\u0016\u0010\u001e\u001a\u00020\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150 H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0015H\u0002J\b\u0010&\u001a\u00020\u0015H\u0016J\b\u0010.\u001a\u00020\u0015H\u0002J\b\u0010/\u001a\u00020\u0015H\u0002J\b\u00100\u001a\u00020\u0015H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/larus/avatar/impl/scan/component/ScanCameraBtnComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/avatar/impl/scan/component/IScanCameraBtnComponentAbility;", "<init>", "()V", "viewModel", "Lcom/larus/avatar/impl/scan/ScanCameraViewModel;", "getViewModel", "()Lcom/larus/avatar/impl/scan/ScanCameraViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "btnContainerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "btnLoading", "Landroid/view/View;", "btnTextView", "Landroid/widget/TextView;", "btnMaskView", "btnGoUpload", "onAttach", "", "onViewCreated", "view", "setupLayoutParams", LiveCommonConstants.REASON_ON_DEDTROY, "showStartRecord", "handleExperimentalGroupStartRecording", "showAuthorizationDialog", "startRecordingAfterPermission", "requestVideoRecordPermission", "passBlk", "Lkotlin/Function0;", "startRecordingDirectly", "hide", "showReScan", "showStartCreate", "trackStartCreate", DyPayConstant.KEY_SHOW_LOADING, "beautyButton", "Lcom/larus/avatar/impl/scan/view/ScanCameraBeautyButton;", "beautyManager", "Lcom/larus/avatar/impl/scan/view/ScanCameraBeautyManager;", "getBeautyManager", "()Lcom/larus/avatar/impl/scan/view/ScanCameraBeautyManager;", "beautyManager$delegate", "setupBeautyButton", "showBeautyButton", "hideBeautyButton", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanCameraBtnComponent extends BaseContentWidget implements b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f290893u = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f290894m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ConstraintLayout f290895n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f290896o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f290897p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f290898q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f290899r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ScanCameraBeautyButton f290900s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f290901t;

    public static final class a {
    }

    static {
    }

    public final ScanCameraViewModel Y2() {
        return (ScanCameraViewModel) this.f290894m.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.avatar.impl.scan.component.c0] */
    public final void h3() {
        final ?? r100 = new c0(this);
        Fragment r101 = com.larus.avatar.impl.scan.utils.c.b(this);
        if (r101 == null) goto L20;
        FragmentManager r102 = r101.getChildFragmentManager();
        if (r102.findFragmentByTag("EmptyPermissionFragment") != null) goto L21;
        int r103 = EmptyPermissionFragment.f291128f;
        Function1<? super Boolean, Unit> r104 = new u(r100);
        Intrinsics.checkNotNullParameter(r104, "callback");
        EmptyPermissionFragment r105 = new EmptyPermissionFragment();
        r105.f291129d = r104;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L15
        FragmentTransaction r107 = r102.beginTransaction();     // Catch: Throwable -> L15
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r107, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "EmptyPermissionFragment", 0) == true) goto L13;
        r107 = r107.add(r105, "EmptyPermissionFragment");     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(Integer.valueOf(r107.commitAllowingStateLoss()));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L21:
        return;
    }

    @Override // com.larus.avatar.impl.scan.component.b
    public final void hide() {
        ConstraintLayout r100 = this.f290895n;
        if (r100 == null) goto L5;
        j19.c.d(r100);
    L5:
        View r101 = this.f290898q;
        if (r101 == null) goto L8;
        j19.c.d(r101);
    L8:
        View r102 = this.f290899r;
        if (r102 == null) goto L11;
        j19.c.d(r102);
    L11:
        ScanCameraBeautyButton r103 = this.f290900s;
        if (r103 == null) goto L14;
        j19.c.d(r103);
    L14:
        ConstraintLayout r104 = this.f290895n;
        if (r104 == null) goto L18;
        r104.setOnClickListener(null);
        return;
    }

    public final void m3() {
        int r100 = com.larus.avatar.impl.scan.utils.d.f291135a;
        Fragment r101 = com.larus.avatar.impl.scan.utils.c.b(this);
        Integer r102 = null;
        if ((r101 instanceof TraceFragment) == false) goto L5;
        TraceFragment r110 = (TraceFragment) r101;
    L6:
        ScanCameraViewModel r103 = Y2();
        if (r103 == null) goto L12;
        com.larus.avatar.impl.scan.l r104 = r103.getScanCameraInputParams();
        if (r104 == null) goto L12;
        String r105 = r104.f291009g;
        if (r105 == null) goto L12;
    L13:
        String r106 = r105;
        ScanCameraViewModel r107 = Y2();
        if (r107 == null) goto L18;
        com.larus.avatar.impl.scan.l r108 = r107.getScanCameraInputParams();
        if (r108 == null) goto L18;
        String r109 = r108.f291008f;
    L19:
        ScanCameraViewModel r111 = Y2();
        if (r111 == null) goto L24;
        com.larus.avatar.impl.scan.l r112 = r111.getScanCameraInputParams();
        if (r112 == null) goto L24;
        String r113 = r112.f291013k;
    L25:
        ScanCameraViewModel r114 = Y2();
        if (r114 == null) goto L30;
        com.larus.avatar.impl.scan.l r115 = r114.getScanCameraInputParams();
        if (r115 == null) goto L30;
        String r116 = r115.f291014l;
    L31:
        ScanCameraViewModel r117 = Y2();
        if (r117 == null) goto L36;
        com.larus.avatar.impl.scan.l r118 = r117.getScanCameraInputParams();
        if (r118 == null) goto L36;
        String r119 = r118.f291015m;
    L37:
        ScanCameraViewModel r120 = Y2();
        if (r120 == null) goto L42;
        com.larus.avatar.impl.scan.l r121 = r120.getScanCameraInputParams();
        if (r121 == null) goto L42;
        String r122 = r121.f291016n;
    L43:
        ScanCameraViewModel r123 = Y2();
        if (r123 == null) goto L48;
        ScanCameraBeautyLevel r124 = r123.getBeautyLevel();
        if (r124 == null) goto L48;
        r102 = Integer.valueOf(r124.getMobLevelInt());
    L48:
        Intrinsics.checkNotNullParameter(r106, "scene");
        tx9.r0.a(r106, 0, 1, r109, r116, r119, r122, r102, r113, r110, 256);
        return;
    L42:
        r122 = null;
    L36:
        r119 = null;
    L30:
        r116 = null;
    L24:
        r113 = null;
    L18:
        r109 = null;
    L12:
        r105 = BasicTestActionHandler.TEST_ACTION_RESET;
        goto L13
    L5:
        r110 = null;
        goto L6
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        ConstraintLayout r100 = this.f290895n;
        if (r100 == null) goto L5;
        r100.setOnClickListener(null);
    L5:
        this.f290895n = null;
        this.f290896o = null;
        this.f290897p = null;
        this.f290898q = null;
        this.f290899r = null;
    }

    @Override // com.larus.avatar.impl.scan.component.b
    public final void showLoading() {
        ConstraintLayout r100 = this.f290895n;
        if (r100 == null) goto L5;
        e1.x(r100);
    L5:
        TextView r101 = this.f290897p;
        if (r101 == null) goto L8;
        j19.c.d(r101);
    L8:
        View r102 = this.f290896o;
        if (r102 == null) goto L11;
        e1.x(r102);
    L11:
        View r103 = this.f290898q;
        if (r103 == null) goto L14;
        e1.x(r103);
    L14:
        ScanCameraBeautyButton r104 = this.f290900s;
        if (r104 == null) goto L17;
        j19.c.d(r104);
    L17:
        ConstraintLayout r105 = this.f290895n;
        if (r105 == null) goto L21;
        r105.setOnClickListener(null);
        return;
    }

    @Override // com.larus.avatar.impl.scan.component.b
    public final void sq() {
        ConstraintLayout r100 = this.f290895n;
        if (r100 == null) goto L5;
        e1.x(r100);
    L5:
        TextView r101 = this.f290897p;
        if (r101 == null) goto L8;
        e1.x(r101);
    L8:
        View r102 = this.f290896o;
        if (r102 == null) goto L11;
        j19.c.d(r102);
    L11:
        View r103 = this.f290898q;
        if (r103 == null) goto L14;
        e1.x(r103);
    L14:
        ScanCameraBeautyButton r104 = this.f290900s;
        if (r104 == null) goto L17;
        j19.c.d(r104);
    L17:
        TextView r105 = this.f290897p;
        if (r105 == null) goto L20;
        r105.setText(AppHost.f326268a.getApplication().getString(R.string.larus_creation_replica_video_btn_create));
    L20:
        ConstraintLayout r106 = this.f290895n;
        if (r106 == null) goto L23;
        r106.setOnClickListener(new s(this));
    L23:
        boolean r107 = true;
        if (DigitalAvatarProcessType.Companion == null) goto L38;
        ScanCameraViewModel r108 = Y2();
        if (r108 == null) goto L32;
        com.larus.avatar.impl.scan.l r109 = r108.getScanCameraInputParams();
        if (r109 == null) goto L32;
        Integer r110 = r109.f291021s;
        if (r110 == null) goto L32;
        int r111 = r110.intValue();
    L33:
        DigitalAvatarProcessType r112 = DigitalAvatarProcessType.a.a(r111);
        if (r112 == null) goto L38;
        if (r112.isNewCreate() != true) goto L38;
        boolean r113 = true;
    L39:
        List<ey9.k> r114 = IUgcAIGCService.f373945a.Q();
        if (r114 == null) goto L42;
        int r115 = r114.size();
    L43:
        if (r115 <= 0) goto L45;
        boolean r116 = true;
    L46:
        if (r113 == true) goto L62;
        if (r113 == true) goto L49;
        if (r116 == false) goto L62;
    L49:
        if (r113 == true) goto L59;
        if (r116 == false) goto L59;
        ScanCameraViewModel r117 = Y2();
        if (r117 != null) goto L54;
    L56:
        r107 = false;
    L57:
        if (r107 == false) goto L59;
    L54:
        if (r117.getFrontImageIsSamePerson() == true) goto L56;
    L59:
        View r118 = this.f290899r;
        if (r118 == null) goto L69;
        j19.c.d(r118);
        return;
    L69:
        return;
    L62:
        View r119 = this.f290899r;
        if (r119 == null) goto L65;
        e1.x(r119);
    L65:
        View r120 = this.f290899r;
        if (r120 == null) goto L71;
        r120.setOnClickListener(new x(this));
        return;
    L71:
        return;
    L45:
        r116 = false;
        goto L46
    L42:
        r115 = 0;
    L32:
        r111 = 0;
    L38:
        r113 = false;
        goto L39
    }

    @Override // com.larus.avatar.impl.scan.component.b
    public final void ts() {
        ConstraintLayout r100 = this.f290895n;
        if (r100 == null) goto L5;
        e1.x(r100);
    L5:
        TextView r101 = this.f290897p;
        if (r101 == null) goto L8;
        e1.x(r101);
    L8:
        View r102 = this.f290896o;
        if (r102 == null) goto L11;
        j19.c.d(r102);
    L11:
        View r103 = this.f290898q;
        if (r103 == null) goto L14;
        e1.x(r103);
    L14:
        View r104 = this.f290899r;
        if (r104 == null) goto L18;
        j19.c.d(r104);
    L18:
        if (((com.larus.avatar.impl.scan.view.a) this.f290901t.getValue()).a() == false) goto L22;
        ScanCameraBeautyButton r105 = this.f290900s;
        if (r105 == null) goto L22;
        e1.x(r105);
    L22:
        TextView r106 = this.f290897p;
        if (r106 != null) goto L25;
    L29:
        ConstraintLayout r107 = this.f290895n;
        if (r107 == null) goto L33;
        r107.setOnClickListener(new b0(this));
        return;
    L33:
        return;
    L25:
        if (z2.f365865a.l1() == false) goto L27;
        String r108 = getContext().getString(R.string.larus_simplifyReplicaGen_btn_startCreating);
    L28:
        r106.setText(r108);
        goto L29
    L27:
        r108 = AppHost.f326268a.getApplication().getString(R.string.larus_creation_replica_video_btn_record);
        goto L28
    }

    @Override // com.larus.avatar.impl.scan.component.b
    public final void wG() {
        ConstraintLayout r100 = this.f290895n;
        if (r100 == null) goto L5;
        e1.x(r100);
    L5:
        TextView r101 = this.f290897p;
        if (r101 == null) goto L8;
        e1.x(r101);
    L8:
        View r102 = this.f290896o;
        if (r102 == null) goto L11;
        j19.c.d(r102);
    L11:
        View r103 = this.f290898q;
        if (r103 == null) goto L14;
        e1.x(r103);
    L14:
        View r104 = this.f290899r;
        if (r104 == null) goto L17;
        j19.c.d(r104);
    L17:
        ScanCameraBeautyButton r105 = this.f290900s;
        if (r105 == null) goto L20;
        j19.c.d(r105);
    L20:
        TextView r106 = this.f290897p;
        if (r106 == null) goto L23;
        r106.setText(AppHost.f326268a.getApplication().getString(R.string.larus_creation_replica_video_btn_record_again));
    L23:
        ConstraintLayout r107 = this.f290895n;
        if (r107 == null) goto L27;
        r107.setOnClickListener(new y(this));
        return;
    }

    public ScanCameraBtnComponent() {
        this.f290894m = LazyKt.lazy(new z(this));
        this.f290901t = LazyKt.lazy(new a0(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Fragment r100 = com.larus.avatar.impl.scan.utils.c.b(this);
        if (r100 == null) goto L5;
        s1a.a.a(r100, this, b.class);
    L5:
        QuotaValidationManager.b();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f290895n = (ConstraintLayout) F2().findViewById(R.id.btn_container);
        this.f290896o = F2().findViewById(R.id.btn_loading);
        this.f290897p = (TextView) F2().findViewById(R.id.btn_text);
        this.f290898q = F2().findViewById(R.id.btn_mask);
        this.f290899r = F2().findViewById(R.id.go_upload_container);
        ConstraintLayout r101 = this.f290895n;
        if (r101 == null) goto L5;
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(-1, i5.h0());
        r102.bottomToBottom = 0;
        r102.startToStart = 0;
        r102.endToEnd = 0;
        r102.setMarginStart(i5.h());
        r102.setMarginEnd(i5.h());
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = i5.b0();
        r101.setLayoutParams(r102);
    L5:
        this.f290900s = (ScanCameraBeautyButton) F2().findViewById(R.id.beauty_button);
        if (((com.larus.avatar.impl.scan.view.a) this.f290901t.getValue()).a() == false) goto L13;
        ScanCameraBeautyButton r103 = this.f290900s;
        if (r103 == null) goto L17;
        com.larus.avatar.impl.scan.view.a r104 = (com.larus.avatar.impl.scan.view.a) this.f290901t.getValue();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "button");
        r104.f291221d = r103;
        r103.setBeautyLevel(r104.f291220c);
        ScanCameraViewModel r105 = r104.f291219b;
        if (r105 == null) goto L12;
        r105.setBeautyLevel(r104.f291220c);
    L12:
        r103.setOnBeautyClickListener(new com.larus.avatar.impl.scan.view.b(r104));
        return;
    L17:
        return;
    L13:
        ScanCameraBeautyButton r106 = this.f290900s;
        if (r106 == null) goto L19;
        j19.c.d(r106);
        return;
    }
}
