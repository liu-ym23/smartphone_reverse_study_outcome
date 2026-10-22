package com.ss.android.lark.flow.replyinthread;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.replyinthread.pages.ThreadPageInitViewModel;
import com.ss.android.lark.replyinthread.pages.f;
import com.ss.android.lark.widget.codeblock.theme.CodeBlockV2ThemeManager;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zsb.d;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\"\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/ss/android/lark/flow/replyinthread/FlowReplyInThreadContainerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "viewModel", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInitViewModel;", "mFragment", "Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;", "getMFragment", "()Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;", "setMFragment", "(Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;)V", "closePageObserver", "Landroidx/lifecycle/Observer;", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupInitViewModel", "setupFragment", "pageInfo", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInfo;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", LiveCommonConstants.REASON_ON_DEDTROY, "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "shouldNotifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowReplyInThreadContainerFragment extends Hilt_FlowReplyInThreadContainerFragment implements c, d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f423931i = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ThreadPageInitViewModel f423932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Inject
    public FlowReplyInThreadFragment f423933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f423934h;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowReplyInThreadContainerFragment f423935a;

        public b(FlowReplyInThreadContainerFragment r100) {
            this.f423935a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L9;
            FragmentActivity r101 = this.f423935a.getActivity();
            if (r101 == null) goto L7;
            FlowToast.c(r101, R.string.Lark_Legacy_ErrorMessageTip);
        L7:
            zab.a.a(this.f423935a);
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    @Inject
    public FlowReplyInThreadContainerFragment() {
        this.f423934h = new b(this);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ThreadPageInitViewModel r100 = this.f423932f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L5:
        r100.getClosePageInfo().removeObserver(this.f423934h);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        CodeBlockV2ThemeManager.a();     // Catch: Throwable -> L8
        TableUtils.f412435a = null;     // Catch: Throwable -> L8
        ColumnsUtils.f412434a = null;     // Catch: Throwable -> L8
        TextLayoutBuilder.b();     // Catch: Throwable -> L8
        ChatCoreModule.a().getChatDependency().r();     // Catch: Throwable -> L8
        u.a.f416743a.a();     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // zsb.d
    public final boolean Cy(Notice r100) {
        ThreadPageInitViewModel r101 = this.f423932f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        f r102 = r101.getThreadPageLiveData().getValue();
        if (r102 == null) goto L9;
        String r103 = r102.a();
        if (r103 == null) goto L9;
    L11:
        return t0.b(r100, r103);
    L9:
        r103 = "";
        goto L11
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        if (r100 == null) goto L4;
        r100.remove("android:support:fragments");
    L4:
        super.onCreate(r100);
        v4b.a.a(requireContext());
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Log.i("FlowReplyInThreadContainer", "container Fragment created");
        ThreadPageInitViewModel r102 = (ThreadPageInitViewModel) new ViewModelProvider(this).get(ThreadPageInitViewModel.class);
        this.f423932f = r102;
        ThreadPageInitViewModel r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L5:
        r102.onCreate(getArguments());
        ThreadPageInitViewModel r104 = this.f423932f;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r104 = null;
    L8:
        r104.getClosePageInfo().observe(this, this.f423934h);
        ThreadPageInitViewModel r105 = this.f423932f;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r103.getThreadPageLiveData(), this, new whb.b(this));
        return;
    L11:
        r103 = r105;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        FlowReplyInThreadFragment r103 = this.f423933g;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        r103 = null;
    L6:
        r103.onActivityResult(r100, r101, r102);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = new FrameLayout(r100.getContext());
        r103.setId(R.id.fragment_container);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r103;
    }
}
