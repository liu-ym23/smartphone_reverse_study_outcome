package com.larus.uaigc.createpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.minor.model.MinorConfigItems;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.createpage.component.instruction.CreationEditorComponent;
import com.larus.uaigc.impl.databinding.LarusFragmentHalfCreationPageBinding;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0001jB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00108\u001a\u00020+2\u0006\u00109\u001a\u0002032\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u0010:\u001a\u00020+H\u0016J\b\u0010;\u001a\u00020+H\u0002J\u000f\u0010<\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\b=J\b\u0010>\u001a\u00020+H\u0002J\b\u0010?\u001a\u00020+H\u0002J'\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020\u0018H\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\u0018H\u0000¢\u0006\u0002\bHJ\"\u0010I\u001a\u00020+2\u0006\u0010A\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0017J\b\u0010J\u001a\u00020+H\u0002J\b\u0010K\u001a\u00020+H\u0002J\n\u0010L\u001a\u0004\u0018\u000103H\u0016J\u001a\u0010M\u001a\u00020+2\u0006\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010N\u001a\u00020+H\u0002J\b\u0010O\u001a\u00020+H\u0016J\u001f\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u00112\b\u0010R\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\bSJ\u0012\u0010T\u001a\u0004\u0018\u00010\u000e2\u0006\u0010Q\u001a\u00020\u0011H\u0002J\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u000207H\u0002J\u0014\u0010X\u001a\u00020+*\u00020Y2\u0006\u0010W\u001a\u000207H\u0002J\b\u0010Z\u001a\u00020+H\u0002J\b\u0010[\u001a\u00020+H\u0002J\u0010\u0010\\\u001a\u00020+2\u0006\u0010W\u001a\u000207H\u0002J\b\u0010]\u001a\u00020+H\u0002J\u0018\u0010^\u001a\u00020+2\u0006\u0010_\u001a\u00020\u00132\u0006\u0010`\u001a\u00020\u0018H\u0002J\u0018\u0010a\u001a\u00020+2\u0006\u0010_\u001a\u00020\u00132\u0006\u0010b\u001a\u00020\u0016H\u0002J\b\u0010c\u001a\u00020\u0018H\u0002J\u001a\u0010d\u001a\u0002002\u0006\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010e\u001a\u00020+H\u0002J\b\u0010f\u001a\u00020\u001dH\u0002J\b\u0010g\u001a\u00020+H\u0002J\b\u0010h\u001a\u00020+H\u0002J\b\u0010i\u001a\u00020\u0017H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006k"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHalfChatFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/uaigc/bean/createpage/ICreationHalfHost;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentHalfCreationPageBinding;", "instructionArgumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "creationHalfContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "hostContainer", "Landroid/widget/FrameLayout;", "hostFragmentRef", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "hostChatRoot", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "hostRootBottomPaddingInterceptor", "Lkotlin/Function2;", "", "", "", "originalHostRootBottomPaddingInterceptor", "hasPendingResult", "pendingResultCode", "pendingResultData", "Landroid/content/Intent;", "resultDelivered", "dismissRequested", "creationEditorAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getCreationEditorAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "creationEditorAbility$delegate", "Lkotlin/Lazy;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "autoLogEnterPage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "dismiss", "getPreviousPage", "getPreviousPage$impl_mainlandRelease", "bindToVContext", "attachComponent", "onResult", "requestCode", "resultCode", "data", "onResult$impl_mainlandRelease", "isDismissRequested", "isDismissRequested$impl_mainlandRelease", "shouldUseCompactForsetiImeFix", "shouldUseCompactForsetiImeFix$impl_mainlandRelease", "onActivityResult", "initBackPressed", "requestDismissPage", "getContentView", "setCreationHalfResult", "deliverPendingResultIfNeeded", "finishCreationHalfPage", "showPageFragment", "parentFragment", "tag", "showPageFragment$impl_mainlandRelease", "ensureHostContainer", "createHostLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", RootDescription.ROOT_ELEMENT, "compensateHostPadding", "Landroid/view/ViewGroup$MarginLayoutParams;", "dismissPageAllowingStateLoss", "scheduleRemoveHostContainer", "installHostRootInsetsGuard", "restoreHostRootInsets", "resetHostRootImeInsets", "chatRoot", "shouldPinBottomPadding", "pinHostRootBottomPadding", "targetBottom", "shouldPinHostRootBottomPadding", "buildResultBundle", "cancelPendingEditorIme", "buildCancelResultIntent", "deliverCancelResultIfNeeded", "deliverPendingResultOrCancelIfNeeded", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationHalfChatFragment extends TraceFragment implements ny9.i {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f371364p = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusFragmentHalfCreationPageBinding f371365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f371366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<Fragment> f371367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ChatConstraintLayout f371368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super Integer, ? super String, Boolean> f371369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f371370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f371371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Intent f371372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f371373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f371374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f371375o;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // ny9.i
    public final void YV() {
        this.f371374n = true;
        U90();
        View r100 = getView();
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        ICoreInputAbility r101 = (ICoreInputAbility) s1a.a.g(this).getAbility(ICoreInputAbility.class);
        if (r101 == null) goto L8;
        r101.qp(true);
    L8:
        Z90();
        W90();
        if (isAdded() == true) goto L20;
        FrameLayout r102 = this.f371366f;
        Z90();
        if (r102 != null) goto L18;
        this.f371367g = null;
        return;
    L18:
        r102.post(new b0(r102));
        this.f371366f = null;
        this.f371367g = null;
        return;
    L20:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Object r104 = Result.m9449constructorimpl(Integer.valueOf(getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss()));     // Catch: Throwable -> L12
    L14:
        Result.m9448boximpl(r104);
        return;
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "CreationHalfChatFragment";
    }

    public final void U90() {
        ys8.a r100 = (ys8.a) this.f371375o.getValue();
        if ((r100 instanceof CreationEditorComponent) == false) goto L5;
        CreationEditorComponent r101 = (CreationEditorComponent) r100;
    L6:
        if (r101 == null) goto L8;
        r101.C3();
    L8:
        py9.a r102 = (py9.a) s1a.a.g(this).getAbility(py9.a.class);
        if (r102 == null) goto L12;
        r102.NM();
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void V90() {
        if (this.f371373m == false) goto L5;
        return;
    L5:
        if (this.f371370j == true) goto L10;
        Intent r100 = new Intent();
        r100.putExtra(MinorConfigItems.AI_CREATION, true);
        r100.putExtra("end_modify", true);
        Dc(0, r100);
        return;
    }

    public final void X90() {
        if (this.f371374n == false) goto L5;
        return;
    L5:
        this.f371374n = true;
        U90();
        py9.a r100 = (py9.a) s1a.a.g(this).getAbility(py9.a.class);
        if (r100 == null) goto L9;
        r100.Gj();
        return;
    L9:
        V90();
        YV();
    }

    public final void Z90() {
        ChatConstraintLayout r100 = this.f371368h;
        if (r100 != null) goto L5;
        return;
    L5:
        z2.f365865a.w3();
        Y90(r100);
        this.f371368h = null;
        this.f371369i = null;
    }

    public final boolean aa0() {
        WeakReference<Fragment> r100 = this.f371367g;
        xe8.a r101 = null;
        if (r100 == null) goto L6;
        Fragment r102 = r100.get();
        if (r102 == null) goto L6;
    L11:
        if ((r102 instanceof xe8.a) == false) goto L14;
        r101 = (xe8.a) r102;
    L14:
        if (r101 == null) goto L21;
        ChatBubbleParams r103 = r101.Mz();
        if (r103 != null) goto L18;
        return false;
    L18:
        if (r103.f296841b != true) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L6:
        WeakReference<Fragment> r104 = s0.f372604b;
        if (r104 == null) goto L9;
        r102 = r104.get();
        goto L11
    L9:
        r102 = null;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        FrameLayout r100 = this.f371366f;
        if ((r100 instanceof h0) == false) goto L5;
        h0 r101 = (h0) r100;
    L6:
        if (r101 == null) goto L8;
        r101.f372558a = null;
        r101.f372559b = null;
    L8:
        U90();
        Z90();
        W90();
        super.onDestroyView();
        this.f371365e = null;
        FrameLayout r102 = this.f371366f;
        Z90();
        if (r102 != null) goto L11;
        this.f371367g = null;
        return;
    L11:
        r102.post(new b0(r102));
        this.f371366f = null;
        this.f371367g = null;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public CreationHalfChatFragment() {
        this.f371375o = LazyKt.lazy(new z(this));
    }

    public final void W90() {
        V90();
        if (this.f371373m == false) goto L5;
        return;
    L5:
        if (this.f371370j == false) goto L31;
        WeakReference<Fragment> r100 = this.f371367g;
        if (r100 == null) goto L11;
        ActivityResultCaller r101 = (Fragment) r100.get();
        if (r101 == null) goto L11;
    L16:
        if ((r101 instanceof xe8.a) == false) goto L32;
        int r102 = this.f371371k;
        Intent r103 = this.f371372l;
        if (r103 == null) goto L22;
        Bundle r104 = r103.getExtras();
        if (r104 == null) goto L22;
    L23:
        Bundle r105 = new Bundle(r104);
        if (r105.getBoolean("end_modify") == false) goto L28;
        r105.putBoolean("restore_action_bar_on_return", true);
        if (r102 != 0) goto L28;
        r105.putBoolean("close_instruction_editor_on_return", true);
    L28:
        this.f371373m = true;
        ((xe8.a) r101).Lc(r105, 100, this.f371371k);
        return;
    L22:
        r104 = new Bundle();
        goto L23
    L32:
        return;
    L11:
        WeakReference<Fragment> r106 = s0.f372604b;
        if (r106 == null) goto L14;
        r101 = (Fragment) r106.get();
        goto L16
    L14:
        r101 = null;
        goto L16
    }

    @Override // ny9.i
    public final View getContentView() {
        return getView();
    }

    public static void Y90(ChatConstraintLayout r100) {
        Function2<Integer, String, Boolean> r101 = r100.getInterruptBottomPaddingUpdate();
        r100.setInterruptBottomPaddingUpdate(new f0());     // Catch: Throwable -> L6
        r100.u6();     // Catch: Throwable -> L6
        r100.setInterruptBottomPaddingUpdate(r101);
        return;
    L6:
        th = move-exception;
        r100.setInterruptBottomPaddingUpdate(r101);
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        t1a.b r101 = s1a.a.g(this);
        de8.c r102 = de8.c.f468084s;
        r101.n(de8.c.a.a(getArguments()), de8.c.class);
        Bundle r103 = getArguments();
        ChatPageContext r104 = null;
        if (r103 == null) goto L5;
        ChatPageContext r105 = (ChatPageContext) r103.getParcelable("chat_page_context");
    L7:
        if ((r105 instanceof ChatPageContext) == false) goto L9;
        r104 = r105;
    L9:
        if (r104 == null) goto L11;
        s1a.a.g(this).n(r104, ChatPageContext.class);
    L11:
        ny9.s r106 = new ny9.s(getArguments());
        s1a.a.g(this).n(r106, ny9.s.class);
        s1a.a.g(this).n(new ny9.u(r106), ny9.u.class);
        return;
    L5:
        r105 = null;
        goto L7
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new c0(this));
    }

    @Override // ny9.i
    public final void Dc(int r100, Intent r101) {
        if (this.f371373m == false) goto L5;
        return;
    L5:
        this.f371371k = r100;
        this.f371372l = r101;
        this.f371370j = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FrameLayout r102 = this.f371366f;
        ConstraintLayout r103 = null;
        if ((r102 instanceof h0) == false) goto L5;
        h0 r104 = (h0) r102;
    L6:
        if (r104 == null) goto L11;
        LarusFragmentHalfCreationPageBinding r105 = this.f371365e;
        if (r105 == null) goto L10;
        r103 = r105.f373124c;
    L10:
        r104.f372558a = r103;
        r104.f372560c = false;
        r104.f372559b = new a0(this);
    L11:
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new CreationHalfChatFragment$initBackPressed$1(this));
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        ys8.a r103 = (ys8.a) this.f371375o.getValue();
        if (r103 == null) goto L6;
        r103.pz(r101, r102);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        LarusFragmentHalfCreationPageBinding r103 = LarusFragmentHalfCreationPageBinding.a(r100, r101);
        this.f371365e = r103;
        ViewStub r104 = r103.f373126e;
        if (r104 == null) goto L6;
        InputViewCreatorDelegate.f298409b.a(r104, Integer.valueOf(R.id.input_delegate));
    L6:
        if (aa0() == true) goto L12;
        LarusFragmentHalfCreationPageBinding r105 = this.f371365e;
        if (r105 == null) goto L12;
        ChatConstraintLayout r106 = r105.f373127f;
        if (r106 == null) goto L12;
        r106.post(new y(this));
    L12:
        LarusFragmentHalfCreationPageBinding r107 = this.f371365e;
        if (r107 == null) goto L17;
        ConstraintLayout r108 = r107.f373124c;
        if (r108 == null) goto L17;
        com.larus.uaigc.createpage.utils.p.a(r108);
    L17:
        LarusFragmentHalfCreationPageBinding r109 = this.f371365e;
        if (r109 != null) goto L22;
        return null;
    L22:
        return r109.f373127f;
    }
}
