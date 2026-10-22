package com.larus.drive.sdk.impl.view.preview;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.larus.drive.sdk.api.IDriveSdkServiceV2;
import com.larus.drive.sdk.impl.databinding.LarusFragmentDriveOfficePreviewBinding;
import com.larus.drive.sdk.impl.store.DrivePreviewRequestStore;
import com.larus.nova.R;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\u0016\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010,R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/drive/sdk/impl/view/preview/DriveOfficePreviewFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusFragmentDriveOfficePreviewBinding;", "previewOpenRequest", "Lcom/bytedance/ee/drive/preview/DrivePreviewOpenRequest;", "extraHostAbility", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "launchRequestId", "", "aiPreviewSession", "Lcom/larus/drive/sdk/impl/store/AiFilePreviewSession;", "sourceConversationId", "sourceBotId", "bindExtraHostAbility", "ability", "bindReloadInterceptor", "interceptor", "bindSourceConversation", "conversationId", "botId", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "initConfig", "attachPreviewIfNeeded", "markContentReadyOrClose", "failBeforeContentReady", "resolvePreviewFragment", "request", "(Lcom/bytedance/ee/drive/preview/DrivePreviewOpenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOfficePreviewFragment extends Fragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f342278l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusFragmentDriveOfficePreviewBinding f342279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DrivePreviewOpenRequest f342280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.browser.plugin.i f342281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.container.f f342282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f342283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.larus.drive.sdk.impl.store.a f342284i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f342285j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f342286k;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f342279d = null;
        super.onDestroyView();
    }

    public final void T90() {
        String r100 = this.f342283h;
        if (r100 != null) goto L5;
        return;
    L5:
        FLogger.f375446a.w("DriveOfficePreview", "preview failed before content ready");
        DrivePreviewRequestStore.f341970a.d(r100);
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L9;
        r101.finish();
        return;
    }

    public final void U90() {
        String r100 = this.f342283h;
        if (r100 != null) goto L5;
        return;
    L5:
        DrivePreviewRequestStore r101 = DrivePreviewRequestStore.f341970a;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, "requestId");     // Catch: Throwable -> L36
        DrivePreviewRequestStore.h(SystemClock.elapsedRealtime());     // Catch: Throwable -> L36
        LinkedHashMap<String, DrivePreviewRequestStore.a> r102 = DrivePreviewRequestStore.f341971b;     // Catch: Throwable -> L36
        DrivePreviewRequestStore.a r103 = r102.get(r100);     // Catch: Throwable -> L36
        boolean r104 = false;
        if (r103 != null) goto L13;
        monitor-exit(r101);
    L30:
        if (r104 == true) goto L34;
        FLogger.f375446a.w("DriveOfficePreview", "close stale AI file preview container");
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L40;
        r105.finish();
        return;
    L40:
        return;
    L34:
        FLogger.f375446a.i("DriveOfficePreview", "preview content ready");
        return;
    L13:
        if (r103.f341977d != null) goto L16;
        monitor-exit(r101);
        goto L30
    L16:
        Function0<Boolean> r106 = r103.f341979f;     // Catch: Throwable -> L36
        if (r106 != null) goto L19;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == false) goto L27;
        r102.remove(r100);     // Catch: Throwable -> L36
        FLogger.f375446a.i("DrivePreviewRequestStore", "cancel inactive launch on ready, pendingCount=" + DrivePreviewRequestStore.e() + ", activeCount=" + DrivePreviewRequestStore.b());     // Catch: Throwable -> L36
        monitor-exit(r101);
        goto L30
    L27:
        r103.f341978e = null;     // Catch: Throwable -> L36
        r103.f341979f = null;     // Catch: Throwable -> L36
        FLogger.f375446a.i("DrivePreviewRequestStore", "mark content ready, pendingCount=" + DrivePreviewRequestStore.e() + ", activeCount=" + DrivePreviewRequestStore.b());     // Catch: Throwable -> L36
        monitor-exit(r101);
        r104 = true;
        goto L30
    L19:
        if (r106.invoke().booleanValue() == true) goto L21;
        r107 = true;
    L36:
        th = move-exception;
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        String r100 = this.f342283h;
        if (r100 == null) goto L15;
        FragmentActivity r101 = getActivity();
        boolean r102 = false;
        if (r101 == null) goto L10;
        if (r101.isChangingConfigurations() != true) goto L10;
        r102 = true;
    L10:
        if ((!r102) == true) goto L13;
        r100 = null;
    L13:
        if (r100 == null) goto L15;
        DrivePreviewRequestStore r103 = DrivePreviewRequestStore.f341970a;
        r103.c(r100);
        r103.g(r100);
    L15:
        super.onDestroy();
    }

    public DriveOfficePreviewFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        if (r102 == null) goto L5;
        String r103 = r102.getString("ai_file_preview_launch_request_id");
    L6:
        this.f342283h = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L9;
        String r105 = r104.getString("drive_preview_source_conversation_id");
    L10:
        this.f342285j = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L13;
        String r107 = r106.getString("drive_preview_source_bot_id");
    L14:
        this.f342286k = r107;
        String r108 = this.f342283h;
        if (r108 == null) goto L28;
        DrivePreviewRequestStore r109 = DrivePreviewRequestStore.f341970a;
        monitor-enter(r109);
        Intrinsics.checkNotNullParameter(r108, "requestId");     // Catch: Throwable -> L25
        DrivePreviewRequestStore.a r110 = DrivePreviewRequestStore.a(r108, true);     // Catch: Throwable -> L25
        if (r110 != null) goto L22;
        monitor-exit(r109);
        goto L28
    L22:
        com.larus.drive.sdk.impl.store.a r111 = r110.f341977d;     // Catch: Throwable -> L25
        monitor-exit(r109);
    L29:
        this.f342284i = r111;
        if (r111 == null) goto L33;
        DrivePreviewOpenRequest r112 = r111.f341980a;
        if (r112 == null) goto L33;
    L41:
        this.f342280e = r112;
        FLogger r113 = FLogger.f375446a;
        if (this.f342283h != null) goto L44;
        String r114 = "legacy";
    L45:
        r113.i("DriveOfficePreview", "init preview request, source=".concat(r114));
        if (getChildFragmentManager().findFragmentByTag("drive_office_preview_content") == null) goto L48;
        U90();
        return;
    L48:
        DrivePreviewOpenRequest r115 = this.f342280e;
        if (r115 != null) goto L51;
        r113.e("DriveOfficePreview", "preview request is empty");
        T90();
        return;
    L51:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DriveOfficePreviewFragment$attachPreviewIfNeeded$1(this, r115, null), 3, null);
        return;
    L44:
        r114 = "ai";
    L33:
        Bundle r116 = getArguments();
        if (r116 == null) goto L36;
        Serializable r117 = r116.getSerializable(DrivePreviewOpenRequest.EXTRA_KEY);
    L38:
        if ((r117 instanceof DrivePreviewOpenRequest) == false) goto L40;
        r112 = (DrivePreviewOpenRequest) r117;
        goto L41
    L40:
        r112 = null;
        goto L41
    L36:
        r117 = null;
    L25:
        th = move-exception;
        throw th;
    L28:
        r111 = null;
        goto L29
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static final Object S90(DriveOfficePreviewFragment r100, DrivePreviewOpenRequest r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof DriveOfficePreviewFragment$resolvePreviewFragment$1) == false) goto L7;
        DriveOfficePreviewFragment$resolvePreviewFragment$1 r103 = (DriveOfficePreviewFragment$resolvePreviewFragment$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        IOfficeSdkServiceV2 r108 = (IOfficeSdkServiceV2) r103.L$1;
        DrivePreviewOpenRequest r109 = (DrivePreviewOpenRequest) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L20:
        ik5.a r110 = (ik5.a) r105;
        JobKt.ensureActive(r103.getContext());
        if (r110 == null) goto L74;
        gk5.e r111 = r108.q0();
        if (r111 == null) goto L72;
        com.bytedance.ee.drive.preview.d r112 = r111.Y2();
        if (r112 == null) goto L72;
        List r113 = CollectionsKt.createListBuilder();
        IDriveSdkServiceV2.Companion r114 = IDriveSdkServiceV2.f341560a;
        com.larus.drive.sdk.impl.store.a r115 = r100.f342284i;
        if (r115 == null) goto L30;
        String r116 = r115.f341986g;
        if (r116 == null) goto L30;
    L31:
        if (r115 == null) goto L34;
        String r117 = r115.f341987h;
        if (r117 == null) goto L34;
    L35:
        r113.addAll(r114.f(r100, r116, r117));
        com.bytedance.ee.bear.browser.plugin.i r118 = r100.f342281f;
        if (r118 == null) goto L38;
        Boxing.boxBoolean(r113.add(r118));
    L38:
        String r119 = r100.f342283h;
        if (r119 != null) goto L41;
    L58:
        List<? extends com.bytedance.ee.bear.browser.plugin.i> r120 = CollectionsKt.build(r113);
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L61
        Object r122 = Result.m9449constructorimpl(r112.Ae(r109, r120, null, r100.f342282g));     // Catch: Throwable -> L61
    L63:
        r106 = r122;
        if (Result.m9456isSuccessimpl(r106) == false) goto L66;
        Fragment r123 = (Fragment) r106;
        FLogger.f375446a.i("DriveOfficePreview", "open drive preview");
    L66:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r106);
        if (r124 == null) goto L69;
        FLogger.f375446a.e("DriveOfficePreview", "open drive preview failed", r124);
    L69:
        ResultKt.throwOnFailure(r106);
    L70:
        return r106;
    L61:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L63
    L41:
        if (Intrinsics.areEqual(r109.getCurrent().getAppId(), "doubao_ai_msg") == true) goto L44;
        r119 = null;
    L44:
        if (r119 == null) goto L58;
        com.larus.drive.sdk.impl.store.a r126 = r100.f342284i;
        if (r126 == null) goto L52;
        DrivePreviewOpenRequest r127 = r126.f341980a;
        if (r127 == null) goto L52;
        DrivePreviewOpenItem r128 = r127.getCurrent();
        if (r128 == null) goto L52;
        String r129 = r128.getFileExt();
    L53:
        com.larus.drive.sdk.impl.store.a r130 = r100.f342284i;
        if (r130 == null) goto L56;
        String r131 = r130.f341988i;
    L57:
        r113.add(new i89.d(r100, r119, r129, r131));
        goto L58
    L56:
        r131 = null;
    L52:
        r129 = null;
    L34:
        r117 = r100.f342286k;
    L30:
        r116 = r100.f342285j;
    L72:
        throw new IllegalStateException("drive preview sdk unavailable".toString());
    L74:
        throw new IllegalStateException("office sdk init timeout".toString());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        IOfficeSdkServiceV2 r132 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r132 == null) goto L76;
        IOfficeSdkServiceV2.a.b(r132, false, "DriveOfficePreview", 5);
        r103.L$0 = r101;
        r103.L$1 = r132;
        r103.label = 1;
        Object r133 = r132.o0(15000, r103);
        if (r133 == r106) goto L70;
        r109 = r101;
        r108 = r132;
        r105 = r133;
        goto L20
    L76:
        throw new IllegalStateException("office sdk service unavailable".toString());
    L7:
        r103 = new DriveOfficePreviewFragment$resolvePreviewFragment$1(r100, r102);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_fragment_drive_office_preview, r101, false);
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.drive_office_preview_content);
        if (r104 == null) goto L7;
        FrameLayout r105 = (FrameLayout) r103;
        this.f342279d = new LarusFragmentDriveOfficePreviewBinding(r105, r104);
        return r105;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(R.id.drive_office_preview_content)));
    }
}
