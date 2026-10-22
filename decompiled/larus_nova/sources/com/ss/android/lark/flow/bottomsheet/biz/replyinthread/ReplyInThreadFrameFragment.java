package com.ss.android.lark.flow.bottomsheet.biz.replyinthread;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import bgb.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.replyinthread.pages.ThreadPageInitViewModel;
import com.ss.android.lark.widget.codeblock.theme.CodeBlockV2ThemeManager;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\"\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\u0012\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u0018H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/ss/android/lark/flow/bottomsheet/biz/replyinthread/ReplyInThreadFrameFragment;", "Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFrameFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mFragment", "Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;", "getMFragment", "()Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;", "setMFragment", "(Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;)V", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "bizViewModel", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInitViewModel;", "radiusTopContainer", "", "getRadiusTopContainer", "()F", "setRadiusTopContainer", "(F)V", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initContentContainer", "", "contentContainer", "savedInstanceState", "Landroid/os/Bundle;", "closePageObserver", "Landroidx/lifecycle/Observer;", "", "setupInitViewModel", "setupFragment", "pageInfo", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInfo;", "updateTitleBar", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "handleBack", "onNewIntent", "intent", "notifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "onDestroyView", "OnTitleBarActionClickListener", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReplyInThreadFrameFragment extends Hilt_ReplyInThreadFrameFragment implements c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f421977q = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Inject
    public FlowReplyInThreadFragment f421978l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FrameLayout f421979m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ThreadPageInitViewModel f421980n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f421981o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f421982p;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplyInThreadFrameFragment f421983a;

        public a(ReplyInThreadFrameFragment r100) {
            this.f421983a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L9;
            Context r101 = this.f421983a.getContext();
            if (r101 == null) goto L7;
            UDToast.show(r101, R.string.Lark_Legacy_ErrorMessageTip);
        L7:
            this.f421983a.finish();
            return;
        }
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.d
    public final void A0(Intent r100) {
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
        return b.a(this);
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.d
    public final boolean l1() {
        return false;
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
        return b.b(this);
    }

    public final FlowReplyInThreadFragment V90() {
        FlowReplyInThreadFragment r100 = this.f421978l;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        return null;
    }

    public ReplyInThreadFrameFragment() {
        this.f421981o = 24.0f;
        this.f421982p = new a(this);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ThreadPageInitViewModel r100 = this.f421980n;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bizViewModel");
        r100 = null;
    L5:
        r100.getClosePageInfo().removeObserver(this.f421982p);
        CodeBlockV2ThemeManager.a();
        TableUtils.f412435a = null;
        ColumnsUtils.f412434a = null;
        TextLayoutBuilder.b();
        ChatCoreModule.a().getChatDependency().r();
        u.a.f416743a.a();
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment
    public final float S90() {
        return this.f421981o;
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.d
    public final boolean y30(Notice r100) {
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        String r102 = r101.getString("key_params_thread_id");
    L6:
        if (r102 != null) goto L10;
        return true;
    L10:
        return t0.b(r100, r102);
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment
    public final void T90(FrameLayout r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "contentContainer");
        this.f421979m = r100;
        ThreadPageInitViewModel r102 = (ThreadPageInitViewModel) new ViewModelProvider(this).get(ThreadPageInitViewModel.class);
        this.f421980n = r102;
        ThreadPageInitViewModel r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bizViewModel");
        r102 = null;
    L5:
        r102.onCreate(getArguments());
        ThreadPageInitViewModel r104 = this.f421980n;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bizViewModel");
        r104 = null;
    L8:
        r104.getClosePageInfo().observe(this, this.f421982p);
        ThreadPageInitViewModel r105 = this.f421980n;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bizViewModel");
    L12:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r103.getThreadPageLiveData(), this, new bgb.b(this));
        V90().f423959w.observe(getViewLifecycleOwner(), new d(this));
        return;
    L11:
        r103 = r105;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        V90().onActivityResult(r100, r101, r102);
    }
}
