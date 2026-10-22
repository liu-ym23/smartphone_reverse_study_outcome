package com.larus.office.base.permission;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.permission.PermissionSdk;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.larus.office.base.preview.DocMeta;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.permission.DocPermissionData;
import com.larus.office.permission.DocPermissionFullData;
import com.larus.office.permission.VisibilityStatus;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000f\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0018\u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020)H\u0096@¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u00122\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\n\u00100\u001a\u0004\u0018\u00010)H\u0016J\b\u00101\u001a\u00020\u0012H\u0002J\b\u00102\u001a\u00020\u0012H\u0002J\b\u00103\u001a\u00020\u0012H\u0002J\b\u00104\u001a\u00020\u0012H\u0002J\b\u00105\u001a\u00020\u0012H\u0002J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\rH\u0002J\u001c\u00109\u001a\u0016\u0012\u0004\u0012\u00020;\u0018\u00010:j\n\u0012\u0004\u0012\u00020;\u0018\u0001`<H\u0002J\u000e\u0010=\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020\u0012H\u0002J\u001a\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020\u001e2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006E"}, d2 = {"Lcom/larus/office/base/permission/FileApplyPermissionContainerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/office/base/component/permission/NoPermissionPageHost;", "<init>", "()V", "officeContainerFragment", "permissionAbility", "Lcom/larus/office/base/component/permission/IOfficePermissionChangeAbility;", "permissionDisposable", "Lio/reactivex/disposables/Disposable;", "skeletonLoadingContainer", "Landroid/view/View;", "isPasswordPageShowing", "", "permissionListener", "com/larus/office/base/permission/FileApplyPermissionContainerFragment$permissionListener$1", "Lcom/larus/office/base/permission/FileApplyPermissionContainerFragment$permissionListener$1;", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "attachPermissionComponent", LiveCommonConstants.REASON_ON_DEDTROY, "getToken", "", "getSupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getOfficeContainerFragment", "setOfficeContainerFragment", WidgetService.PARAM_FRAGMENT, "getNoPermissionContainerId", "", "getOfficeContainerId", "createOfficeFragment", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runWhenAdded", "action", "Lkotlin/Function0;", "getNoPermissionBundleData", "Lcom/larus/office/base/component/permission/NoPermissionBundleData;", "getHostContext", "showSkeletonLoading", "hideSkeletonLoading", "showInitialNoPermissionPage", "showPasswordInputFragment", "hidePasswordInputFragment", "buildInitialPermission", "Lcom/larus/office/permission/DocPermissionFullData;", "needInputPassword", "getRestDocs", "Ljava/util/ArrayList;", "Lcom/larus/office/base/preview/DocMeta;", "Lkotlin/collections/ArrayList;", "awaitOfficeSdkReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startPermissionObserve", "convertToDocPermissionFullData", "token", "docPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileApplyPermissionContainerFragment extends Fragment implements com.larus.office.base.component.permission.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f360608j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f360609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.office.base.component.permission.a f360610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f360611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f360612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f360613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f360614i;

    public static final class a {
    }

    public static final class b implements com.larus.office.base.component.permission.a.InterfaceC4430a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileApplyPermissionContainerFragment f360615a;

        public b(FileApplyPermissionContainerFragment r100) {
            this.f360615a = r100;
        }

        @Override // com.larus.office.base.component.permission.a.InterfaceC4430a
        public final void a(DocPermissionFullData r100) {
            Intrinsics.checkNotNullParameter(r100, "permission");
            if (this.f360615a.isAdded() == true) goto L5;
            return;
        L5:
            FLogger r101 = FLogger.f375446a;
            StringBuilder r102 = new StringBuilder("onPermissionStateChanged: canRead=");
            r102.append(fo9.e.c(r100));
            r102.append(", reviewSuccess=");
            r102.append(fo9.e.f(r100));
            r102.append(", needPwd=");
            fo9.h r103 = r100.getPublicPermissions();
            if (r103 == null) goto L8;
            Boolean r104 = r103.f478185a;
        L9:
            r102.append(r104);
            r101.i("FileApplyPermContainer", r102.toString());
            if (fo9.e.c(r100) == true) goto L12;
        L14:
            fo9.h r105 = r100.getPublicPermissions();
            if (r105 == null) goto L17;
            boolean r106 = Intrinsics.areEqual(r105.f478185a, Boolean.TRUE);
        L19:
            if (r106 == false) goto L30;
            FileApplyPermissionContainerFragment r107 = this.f360615a;
            if (r107.f360613h == true) goto L30;
            if (r107.isAdded() == false) goto L44;
            r101.i("FileApplyPermContainer", "showPasswordInputFragment");
            r107.f360613h = true;
            PasswordInputFragment r108 = new PasswordInputFragment();
            r107.f360609d = r108;
            FragmentTransaction r109 = r107.getChildFragmentManager().beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r109, r108, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "file_apply_password_fragment", R.id.office_container) == true) goto L29;
            r109 = r109.replace(R.id.office_container, r108, "file_apply_password_fragment");
        L29:
            r109.commitAllowingStateLoss();
            return;
        L44:
            return;
        L30:
            if (r106 == true) goto L42;
            FileApplyPermissionContainerFragment r110 = this.f360615a;
            if (r110.f360613h == true) goto L34;
            return;
        L34:
            if (r110.isAdded() == false) goto L45;
            r101.i("FileApplyPermContainer", "hidePasswordInputFragment");
            r110.f360613h = false;
            Fragment r111 = r110.getChildFragmentManager().findFragmentByTag("file_apply_password_fragment");
            if (r111 == null) goto L39;
            r110.getChildFragmentManager().beginTransaction().remove(r111).commitAllowingStateLoss();
        L39:
            r110.f360609d = null;
            return;
        L45:
            return;
        L42:
            return;
        L17:
            r106 = false;
            goto L19
        L12:
            if (fo9.e.f(r100) == false) goto L14;
            return;
        L8:
            r104 = null;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.larus.office.base.permission.FileApplyPermissionContainerFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.office.base.permission.FileApplyPermissionContainerFragment$onViewCreated$1", f = "FileApplyPermissionContainerFragment.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FileApplyPermissionContainerFragment this$0;

        public AnonymousClass1(FileApplyPermissionContainerFragment r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            boolean r102 = true;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L11:
            FileApplyPermissionContainerFragment r111 = this.this$0;
            int r103 = FileApplyPermissionContainerFragment.f360608j;
            Bundle r104 = r111.getArguments();
            Disposable r105 = null;
            if (r104 == null) goto L14;
            String r106 = r104.getString("office_permission_doc_token");
        L15:
            int r107 = 0;
            if (r106 == null) goto L22;
            if (StringsKt.isBlank(r106) == true) goto L22;
            r102 = false;
        L22:
            if (r102 == false) goto L53;
            FLogger r108 = FLogger.f375446a;
            r108.w("FileApplyPermContainer", "startPermissionObserve: token is null or blank");
            r111.U90();
            r108.i("FileApplyPermContainer", "showInitialNoPermissionPage");
            com.larus.office.base.component.permission.a r109 = r111.f360610e;
            if (r109 == null) goto L51;
            r109.V0(r111.T90(), new k());
        L51:
            return Unit.INSTANCE;
        L53:
            Bundle r112 = r111.getArguments();     // Catch: Exception -> L52
            if (r112 == null) goto L30;
            int r113 = (int) r112.getLong("office_permission_doc_type", 0);
        L31:
            FLogger r114 = FLogger.f375446a;
            StringBuilder r115 = new StringBuilder("startPermissionObserve: token=");
            int r116 = com.larus.office.base.utils.f.f361173a;
            r115.append(com.larus.office.base.utils.f.b(r106));
            r115.append(", type=");
            r115.append(r113);
            r115.append(", restDocsSize=");
            Bundle r117 = r111.getArguments();
            if (r117 == null) goto L34;
            ArrayList<DocMeta> r118 = com.larus.office.base.preview.a.a(r117, "office_permission_doc_list_to_apply_permission");
        L35:
            if (r118 == null) goto L37;
            r107 = r118.size();
        L37:
            r115.append(r107);
            r114.i("FileApplyPermContainer", r115.toString());
            Disposable r119 = r111.f360611f;
            if (r119 == null) goto L40;
            r119.dispose();
        L40:
            IOfficeSdkServiceV2 r120 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
            if (r120 == null) goto L49;
            gk5.e r121 = r120.q0();
            if (r121 == null) goto L49;
            com.bytedance.ee.permission.a r122 = r121.i0();
            if (r122 == null) goto L49;
            com.bytedance.ee.permission.b r123 = ((PermissionSdk) r122).a();
            if (r123 == null) goto L49;
            r105 = r123.c(r106, r113, new n(r111, r106, r113));
        L49:
            r111.f360611f = r105;
            goto L51
        L34:
            r118 = null;
        L30:
            r113 = 0;
            goto L31
        L14:
            r106 = null;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            FileApplyPermissionContainerFragment r124 = this.this$0;
            this.label = 1;
            if (FileApplyPermissionContainerFragment.S90(r124, this) != r100) goto L11;
            return r100;
        }
    }

    static {
    }

    @Override // com.larus.office.base.component.permission.c
    public final int C3() {
        return R.id.office_container;
    }

    @Override // com.larus.office.base.component.permission.c
    public final int J7() {
        return R.id.no_permission_container;
    }

    @Override // com.larus.office.base.component.permission.c
    public final Object V3(Context r100, Continuation<? super Fragment> r101) {
        return null;
    }

    public final DocPermissionFullData T90() {
        DocPermissionFullData r100 = new DocPermissionFullData();
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        String r102 = r101.getString("office_permission_doc_token");
    L6:
        r100.setToken(r102);
        r100.setVisibilityStatus(VisibilityStatus.NORMAL.getValue());
        DocPermissionData r103 = new DocPermissionData();
        boolean r104 = false;
        r103.setReadable(false);
        r103.setEditable(false);
        r103.setOwner(false);
        r103.setManager(false);
        r100.setPermissions(r103);
        fo9.f r105 = new fo9.f();
        Bundle r106 = getArguments();
        if (r106 == null) goto L9;
        Boolean r107 = Boolean.valueOf(r106.getBoolean("office_permission_can_apply_permission", true));
    L10:
        r105.f478184d = r107;
        r100.setOwner(r105);
        fo9.h r108 = new fo9.h();
        com.larus.office.base.component.permission.a r109 = this.f360610e;
        if (r109 == null) goto L13;
        r104 = r109.k9();
    L13:
        r108.f478185a = Boolean.valueOf(r104);
        r100.setPublicPermissions(r108);
        return r100;
    L9:
        r107 = Boolean.TRUE;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void U90() {
        FLogger.f375446a.i("FileApplyPermContainer", "hideSkeletonLoading");
        View r100 = this.f360612g;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // com.larus.office.base.component.permission.c
    public final com.larus.office.base.component.permission.b X2() {
        FLogger.f375446a.i("FileApplyPermContainer", "getNoPermissionBundleData");
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("office_permission_doc_token");
    L6:
        com.larus.office.base.component.permission.a r102 = this.f360610e;
        if (r102 == null) goto L13;
        DocPermissionFullData r103 = r102.C4();
        if (r103 == null) goto L13;
        fo9.f r104 = r103.getOwner();
        if (r104 == null) goto L13;
        String r105 = r104.f478181a;
    L14:
        Bundle r106 = getArguments();
        if (r106 == null) goto L17;
        long r107 = r106.getLong("office_permission_doc_type");
    L18:
        Bundle r108 = getArguments();
        if (r108 == null) goto L21;
        String r109 = r108.getString("office_permission_enter_from");
    L22:
        Bundle r110 = getArguments();
        if (r110 == null) goto L25;
        String r111 = r110.getString("office_permission_apply_permission_message_id");
    L26:
        Bundle r112 = getArguments();
        if (r112 == null) goto L29;
        String r113 = r112.getString("office_permission_apply_permission_conversation_id");
    L30:
        Bundle r114 = getArguments();
        if (r114 == null) goto L33;
        ArrayList<DocMeta> r115 = com.larus.office.base.preview.a.a(r114, "office_permission_doc_list_to_apply_permission");
    L35:
        return new com.larus.office.base.component.permission.b(r101, null, r105, r107, r109, r111, r113, r115);
    L33:
        r115 = null;
        goto L35
    L29:
        r113 = null;
        goto L30
    L25:
        r111 = null;
        goto L26
    L21:
        r109 = null;
        goto L22
    L17:
        r107 = 0;
    L13:
        r105 = null;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    public FileApplyPermissionContainerFragment() {
        this.f360614i = new b(this);
    }

    @Override // com.larus.office.base.component.permission.c
    public final Context getHostContext() {
        return getContext();
    }

    @Override // com.larus.office.base.component.permission.c
    public final String getToken() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("office_permission_doc_token");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.larus.office.base.component.permission.a r100 = this.f360610e;
        if (r100 == null) goto L5;
        r100.LR(this.f360614i);
    L5:
        Disposable r101 = this.f360611f;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f360611f = null;
    }

    @Override // com.larus.office.base.component.permission.c
    public final FragmentManager y1() {
        return getChildFragmentManager();
    }

    @Override // com.larus.office.base.component.permission.c
    public final Fragment d5() {
        return this.f360609d;
    }

    @Override // com.larus.office.base.component.permission.c
    public final void d7(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (getView() == null) goto L9;
        r100.invoke();
        return;
    }

    @Override // com.larus.office.base.component.permission.c
    public final void x5(Fragment r100) {
        this.f360609d = r100;
    }

    public static final Object S90(FileApplyPermissionContainerFragment r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof FileApplyPermissionContainerFragment$awaitOfficeSdkReady$1) == false) goto L7;
        FileApplyPermissionContainerFragment$awaitOfficeSdkReady$1 r102 = (FileApplyPermissionContainerFragment$awaitOfficeSdkReady$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L24
    L21:
        ik5.a r107 = (ik5.a) r104;     // Catch: Exception -> L24
    L22:
        FLogger.f375446a.i("FileApplyPermContainer", "awaitOfficeSdkReady: done");     // Catch: Exception -> L24
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        FLogger.f375446a.i("FileApplyPermContainer", "awaitOfficeSdkReady: start");     // Catch: Exception -> L24
        IOfficeSdkServiceV2 r108 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L24
        if (r108 == null) goto L22;
        r102.label = 1;     // Catch: Exception -> L24
        r104 = r108.o0(15000, r102);     // Catch: Exception -> L24
        if (r104 != r105) goto L21;
        return r105;
    L24:
        e = move-exception;
        FLogger.f375446a.e("FileApplyPermContainer", "awaitOfficeSdkReady failed: " + e.getMessage());
    L7:
        r102 = new FileApplyPermissionContainerFragment$awaitOfficeSdkReady$1(r100, r101);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        this.f360612g = r100.findViewById(R.id.skeleton_loading_container);
        FLogger r101 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("onViewCreated: token=");
        int r102 = com.larus.office.base.utils.f.f361173a;
        r111.append(com.larus.office.base.utils.f.b(getToken()));
        r111.append(", docType=");
        Bundle r103 = getArguments();
        if (r103 == null) goto L5;
        Long r104 = Long.valueOf(r103.getLong("office_permission_doc_type"));
    L6:
        r111.append(r104);
        r111.append(", canApply=");
        Bundle r105 = getArguments();
        if (r105 == null) goto L9;
        Boolean r106 = Boolean.valueOf(r105.getBoolean("office_permission_can_apply_permission"));
    L10:
        r111.append(r106);
        r111.append(", restDocsSize=");
        Bundle r107 = getArguments();
        if (r107 == null) goto L13;
        ArrayList<DocMeta> r108 = com.larus.office.base.preview.a.a(r107, "office_permission_doc_list_to_apply_permission");
    L15:
        if (r108 == null) goto L17;
        int r109 = r108.size();
    L18:
        r111.append(r109);
        r101.i("FileApplyPermContainer", r111.toString());
        k1a.b.a(this, new j(this));
        com.larus.office.base.component.permission.a r112 = (com.larus.office.base.component.permission.a) s1a.a.g(this).getAbility(com.larus.office.base.component.permission.a.class);
        this.f360610e = r112;
        if (r112 == null) goto L21;
        r112.mW(this);
    L21:
        com.larus.office.base.component.permission.a r113 = this.f360610e;
        if (r113 == null) goto L24;
        r113.R20(this.f360614i);
    L24:
        StringBuilder r114 = new StringBuilder("attachPermissionComponent: abilityReady=");
        if (this.f360610e == null) goto L27;
        boolean r115 = true;
    L28:
        r114.append(r115);
        r101.i("FileApplyPermContainer", r114.toString());
        r101.i("FileApplyPermContainer", "showSkeletonLoading");
        View r116 = this.f360612g;
        if (r116 == null) goto L31;
        r116.setVisibility(0);
    L31:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L27:
        r115 = false;
        goto L28
    L17:
        r109 = 0;
        goto L18
    L13:
        r108 = null;
        goto L15
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.larus_fragment_file_apply_permission_container, r101, false);
    }
}
