package com.bytedance.ee.bear.middleground.comment.input;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.atfinder.AtFinderViewModel;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.bytedance.ee.bear.fileselector.FileSelectFragment;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelBottomSheetDialog;
import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView;
import com.bytedance.ee.bear.middleground.comment.audio.RecordViewModel;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.widget.CommentVoiceBarLayout;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.widget.AtFinderView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AsideInputComment extends BaseInputComment {
    public static final int t0 = 0;
    public final Function1<Integer, Unit> h0;
    public final String i0;
    public Function0<Unit> j0;
    public RecordPanelBottomSheetDialog k0;
    public final ImageView l0;
    public boolean m0;
    public int n0;
    public int o0;
    public final sa5.b p0;
    public Job q0;
    public final e r0;
    public final f s0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.AsideInputComment$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.AsideInputComment$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0002\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<unused var>", "", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail$ExtraEntity$CommentImageEntity;", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda implements Function5<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Boolean, Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(5);
        }

        public final void invoke(String r1, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2, boolean r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r1, "<unused var>");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
            invoke((String) r7, (List) r8, ((Boolean) r9).booleanValue(), (String) r10, ((Boolean) r11).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.AsideInputComment$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass3 extends Lambda implements Function0<FrameLayout> {
        final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p $configComment;

        public AnonymousClass3(com.bytedance.ee.bear.middleground.comment.uitls.p r1) {
            this.$configComment = r1;
            super(0);
        }

        public final FrameLayout invoke() {
            return this.$configComment.c;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m161invoke() {
            return invoke();
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ AsideInputComment a;

        public b(AsideInputComment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            RecordPanelBottomSheetDialog r3 = this.a.k0;
            if (r3 == null) goto L8;
            RecordPanelView r4 = r3.k;
            if (r4 == null) goto L9;
            r4.f();
            return;
        L9:
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ AsideInputComment a;

        public c(AsideInputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.K0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ AsideInputComment a;

        public d(AsideInputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.K0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        t0 = com.bytedance.ee.util.ui.n.d(12);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final ViewGroup E() {
        return this.a.d;
    }

    public final void F0() {
        com.bytedance.ee.util.ui.m.a(new o(this));
        Job r0 = this.q0;
        Job r1 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        final Channel r2 = ChannelKt.Channel$default(0, null, null, 7, null);
        final Lazy r3 = LazyKt.lazy(new AsideInputComment$observeKeyboard$keyboardHeightObserver$2(this, r2));
        Fragment r4 = this.a.b;
        if (r4 == null) goto L10;
        LifecycleCoroutineScope r5 = LifecycleOwnerKt.getLifecycleScope(r4);
        if (r5 == null) goto L10;
        r1 = BuildersKt.launch$default(r5, Dispatchers.getMain().getImmediate(), null, new AsideInputComment$observeKeyboard$1(this, r3, r2, null), 2, null);
    L10:
        this.q0 = r1;
        if (r1 == null) goto L13;
        r1.invokeOnCompletion(new AsideInputComment$observeKeyboard$2(this, r3));
    L13:
        sa5.b r6 = this.p0;
        if (r6 == null) goto L16;
        r6.e(this.r0);
    L16:
        this.a.getActivity().registerComponentCallbacks(this.s0);
        this.Q.g.removeObservers(this.a.getActivity());
        this.Q.g.observe(this.a.getActivity(), new b(this));
    }

    public final boolean H0() {
        RecordPanelBottomSheetDialog r0 = this.k0;
        if (r0 == null) goto L9;
        Dialog r1 = r0.getDialog();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.isShowing() != true) goto L9;
    L10:
        String r3 = this.i0;
        StringBuilder r4 = new StringBuilder("hideRecordPanel: ");
        r4.append(this.k0);
        r4.append(' ');
        RecordPanelBottomSheetDialog r5 = this.k0;
        if (r5 == null) goto L15;
        Dialog r6 = r5.getDialog();
        if (r6 == null) goto L15;
        Boolean r7 = Boolean.valueOf(r6.isShowing());
    L16:
        r4.append(r7);
        r4.append(' ');
        RecordPanelBottomSheetDialog r8 = this.k0;
        if (r8 == null) goto L19;
        Boolean r9 = Boolean.valueOf(r8.isAdded());
    L20:
        r4.append(r9);
        r4.append(' ');
        RecordPanelBottomSheetDialog r10 = this.k0;
        if (r10 == null) goto L23;
        Boolean r11 = Boolean.valueOf(r10.isResumed());
    L24:
        r4.append(r11);
        tt5.a.h(r3, r4.toString());
        RecordPanelBottomSheetDialog r12 = this.k0;
        if (r12 == null) goto L27;
        J0(r12);
    L27:
        this.k0 = null;
        this.q.setSelected(false);
        return r2;
    L23:
        r11 = null;
        goto L24
    L19:
        r9 = null;
    L15:
        r7 = null;
    L9:
        r2 = false;
        goto L10
    }

    public final void I0() {
        if (this.U.isSelected() == true) goto L5;
        w0(0);
    L5:
        this.Q.i();
        H0();
        this.q.setSelected(false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final int K() {
        if (com.bytedance.ee.util.ui.n.C(this.a.getActivity()) == false) goto L5;
        int r0 = 2;
    L6:
        int r2 = this.a.r.keyBoardRawHeightWithOrientation(r0);
        Resources r3 = this.a.getActivity().getResources();
        if (r0 != 1) goto L9;
        int r1 = 2131165647;
    L10:
        int r4 = r3.getDimensionPixelSize(r1);
        if ((r4 * (1 - 0.1f)) > r2) goto L14;
        return r2;
    L14:
        return r4;
    L9:
        r1 = 2131165646;
        goto L10
    L5:
        r0 = 1;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final boolean c0() {
        if (this.U.isSelected() == false) goto L8;
        boolean r0 = x(false);
        if (r0 == false) goto L8;
        return r0;
    L8:
        return super.c0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void s0() {
        tt5.a.h(this.i0, "showFileSelectFragment in AsideInputComment");
        J().adjustHeightByKeyboard = true;
        if (this.a.X.f() == false) goto L6;
        u0();
        return;
    L6:
        int r0 = com.bytedance.ee.bear.fileselector.d.a;
        FileSelectFragment r1 = com.bytedance.ee.bear.fileselector.d.a.b(this.a.getActivity(), J());
        this.N = r1;
        D0(r1, this.a.d(), "FileSelectorManager");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f w() {
        final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r1 = super.w();
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r8 = new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a(true, false, Integer.valueOf(UIUtils.dp2px(this.a.getActivity(), 36.0f)), Integer.valueOf(UIUtils.dp2px(this.a.getActivity(), 2.0f)), null);
        int r2 = UIUtils.dp2px(this.a.getActivity(), 12.0f);
        int r11 = UIUtils.dp2px(this.a.getActivity(), 12.0f);
        return com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f.a(r1, new AsideInputComment$buildVoiceInputContext$1$1(this), true, null, new AsideInputComment$buildVoiceInputContext$1$2(this), new AsideInputComment$buildVoiceInputContext$1$3(this), new AsideInputComment$buildVoiceInputContext$1$4(this), r8, true, Integer.valueOf(r2), r11, new AsideInputComment$buildVoiceInputContext$1$5(this), new AsideInputComment$buildVoiceInputContext$1$6(this), new AsideInputComment$buildVoiceInputContext$1$7(this, r1), -469118977, 30);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void C() {
        I().setVisibility(8);
        this.J.setVisibility(0);
        o0();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ui_state_fix_enable") == false) goto L6;
        tt5.a.h(this.i0, "ui state fix enable is on");
        T();
    L6:
        if (Intrinsics.areEqual((ViewGroup) this.f.invoke(), this.k.getParent()) == true) goto L12;
        ViewGroup r0 = (ViewGroup) this.k.getParent();
        if (r0 == null) goto L10;
        r0.removeView(this.k);
    L10:
        ((ViewGroup) this.f.invoke()).addView(this.k);
        return;
    }

    public final boolean G0() {
        kn4.g r0 = e().getAtWindow();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L16;
        this.n.setSelected(false);
        kn4.g r2 = e().getAtWindow();
        if (r2 == null) goto L12;
        r2.j();
    L12:
        kn4.g r3 = e().getAtWindow();
        if (r3 == null) goto L15;
        r3.close();
    L15:
        return true;
    L16:
        return false;
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void K0() {
        Editable r0 = e().getText();
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        boolean r2 = true;
        int r3 = 0;
        if (com.bytedance.ee.bear.middleground.comment.uitls.n.f(r1).length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        ImageView r5 = this.l0;
        if (I().getVisibility() != 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L21;
        if (r4 == false) goto L21;
        if (this.m0 == true) goto L21;
    L22:
        if (r2 == true) goto L25;
        r3 = 8;
    L25:
        r5.setVisibility(r3);
        return;
    L21:
        r2 = false;
        goto L22
    L15:
        r6 = false;
        goto L16
    L11:
        r4 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void T() {
        super.T();
        this.s.setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final boolean X() {
        kn4.g r0 = e().getAtWindow();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void d0() {
        I().post(new c(this));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void g0() {
        super.g0();
        Job r0 = this.q0;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.a.getActivity().unregisterComponentCallbacks(this.s0);
        sa5.b r1 = this.p0;
        if (r1 == null) goto L8;
        r1.d(this.r0);
    L8:
        this.Q.g.removeObservers(this.a.getActivity());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void h0() {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = W();
        if (r0 == null) goto L5;
        r0.d();
    L5:
        H0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void v0() {
        super.v0();
        H0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void y0() {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = M();
        if (r0 == null) goto L7;
        r0.h();
        d0();
        return;
    L7:
        if (this.k0 == null) goto L9;
        I0();
        return;
    L9:
        this.q.setSelected(true);
        x(false);
        G0();
        R();
        this.q.post(new n(this));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void z() {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L7;
        super.z();
        return;
    L7:
        if (this.U.isSelected() == false) goto L10;
        x(false);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final String L() {
        return this.i0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void S() {
        R();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void Z() {
        R();
    }

    public static View C0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void J0(DialogFragment r4) {
        tt5.a.h(this.i0, "safeDismiss in AsideInputComment");
    L21:
        e = move-exception;
        tt5.a.e(this.i0, "safeDismiss: error:", e, false);
        return;
    L4:
        if (r4.isRemoving() == false) goto L8;
        tt5.a.h(this.i0, "safeDismiss: dialogFragment isStateSaved or isRemoving");     // Catch: Exception -> L21
        return;
    L8:
        if (r4.getFragmentManager() != null) goto L11;
        return;
    L11:
        if (r4.isAdded() == true) goto L24;
        tt5.a.k(this.i0, "safeDismiss: dialogFragment not added");     // Catch: Exception -> L21
        return;
    L24:
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L16
    L28:
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L21
        Throwable r5 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L21
        if (r5 == null) goto L27;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L21
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void Q(List<? extends FileBean> r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedImages");
        super.Q(r2);
        e().requestFocus();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void b0(boolean r6) {
        super.b0(r6);
        RecordPanelBottomSheetDialog r0 = this.k0;
        if (r0 == null) goto L24;
        RecordPanelView r1 = r0.k;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r6 == false) goto L9;
    L12:
        boolean r3 = true;
    L13:
        r1.setEnabled(r3);
        RecordViewModel r4 = this.Q;
        r4.h = r6;
        if (r6 == false) goto L16;
        return;
    L16:
        if (r4.d == true) goto L18;
        return;
    L18:
        if (r1.c() == false) goto L22;
        r1.d(true);
        RecordViewModel r7 = r1.l;
        if (r7 == null) goto L28;
        r7.g();
        return;
    L28:
        return;
    L22:
        this.Q.i();
        e().P();
        this.Q.g();
        z0(false);
        return;
    L9:
        if (r1.getVisibility() != 8) goto L12;
        r3 = false;
        goto L13
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void t0(DialogFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        D0(r3, this.a.d(), "Comment#InputComment_ImageSelector");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final boolean x(boolean r6) {
        tt5.a.h(this.i0, "closeImageSelectorView in AsideInputComment");
        boolean r1 = true;
        if (this.e0 == true) goto L5;
    L20:
        DialogFragment r0 = this.N;
        if (r0 == null) goto L27;
        Dialog r2 = r0.getDialog();
        if (r2 == null) goto L27;
        if (r2.isShowing() != true) goto L27;
    L28:
        DialogFragment r3 = this.N;
        if (r3 == null) goto L31;
        J0(r3);
    L31:
        if (r1 == false) goto L33;
        e().requestFocus();
    L33:
        tt5.a.h(this.i0, "closeImageSelectorView in AsideInputComment, use default selector, showKeyboardAfterDismiss=" + r6 + ", isShowing=" + r1);
        this.U.setSelected(false);
        return r1;
    L27:
        r1 = false;
        goto L28
    L5:
        if (this.a.X.f() == false) goto L20;
        this.U.setSelected(false);
        DialogFragment r4 = this.N;
        if (r6 == false) goto L9;
        CommentImageSelectorDismissReason r5 = CommentImageSelectorDismissReason.PASSIVE_INPUT_HOST_CLOSE;
    L10:
        if (r4 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r6 == false) goto L18;
        if (r1 == true) goto L18;
        e().requestFocus();
    L18:
        tt5.a.h(this.i0, "closeImageSelectorView in AsideInputComment, use host selector, showKeyboardAfterDismiss=" + r6 + ", dismissedByHost=" + r1 + ", reason=" + r5);
        return r1;
    L12:
        if (this.a.X.c(r4, r5) != true) goto L14;
    L9:
        r5 = CommentImageSelectorDismissReason.PASSIVE_INPUT_OTHER_ACTION;
        goto L10
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void z0(boolean r2) {
        tt5.a.h(this.i0, "switchEditTextStatus: ");
    }

    public static final void E0(AsideInputComment r5, int r6) {
        int r0 = C0(r5.a.getActivity().getWindow()).getHeight();
        int r1 = com.ss.android.lark.utils.m0.a(r5.a.getActivity());
        int r2 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.m.a;
        View r3 = r5.k;
        int r4 = t0;
        Intrinsics.checkNotNullParameter(r3, "targetView");
        int r7 = (r0 - r6) - r1;
        float r8 = com.bytedance.ee.util.ui.n.b(r3).bottom;
        float r9 = r7;
        if (r8 <= r9) goto L5;
        int r10 = ((int) (r8 - r9)) + r4;
    L6:
        if (r10 <= 0) goto L9;
        tt5.a.h(r5.i0, "adjustPositionForBottomView: height:" + r10 + " bottomViewHeight:" + r6);
        r5.h0.invoke(Integer.valueOf(r10));
        return;
    L9:
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final boolean e0(View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "event");
        int r0 = r4.getAction() & 255;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
    L8:
        this.m0 = false;
        I().post(new d(this));
    L10:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r1 = M();
        if (r1 == null) goto L20;
        B0(r3, r4);
        Boolean r2 = Boolean.valueOf(r1.b(r3, r4));
        if (r2.booleanValue() == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L22;
        return r2.booleanValue();
    L22:
        return super.e0(r3, r4);
    L20:
        return super.e0(r3, r4);
    L6:
        if (r0 == 3) goto L8;
    L9:
        this.m0 = true;
        K0();
        goto L10
    }

    @Override // com.bytedance.ee.bear.middleground.comment.input.BaseInputComment
    public final void j0(boolean r1, Boolean r2) {
        super.j0(r1, r2);
        R();
        e().clearFocus();
        Function0<Unit> r3 = this.j0;
        if (r3 == null) goto L5;
        r3.invoke();
    L5:
        H0();
    }

    public static void D0(DialogFragment r1, FragmentManager r2, String r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r1.show(r2, r3);
    }

    @Override // kf5.b
    public final void k(String r4, boolean r5, ArrayList<String> r6) {
        tt5.a.h(this.i0, "setMentionOwnerAndAuthors() called with: ownerId = " + r4 + ", isOwner = " + r5 + ", authors = " + r6);
        AtFinderView r0 = F();
        if (r0 == null) goto L8;
        AtFinderViewModel r1 = r0.e;
        if (r1 == null) goto L9;
        r1.setOwnerAndAuthors(r4, r5, r6);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34, types: [android.view.View, android.view.ViewGroup, androidx.appcompat.widget.LinearLayoutCompat, com.bytedance.ee.bear.middleground.comment.widget.CommentVoiceBarLayout] */
    /* JADX WARN: Type inference failed for: r0v76 */
    public AsideInputComment(final com.bytedance.ee.bear.middleground.comment.uitls.p r18, com.bytedance.ee.bear.middleground.comment.control.z r19, com.bytedance.ee.bear.middleground.comment.control.t r20, Function1 r21, CommentInputRequest r22, Function5 r23, Function0 r24, SharePermissionViewModel r25, bb5.i r26, Function1 r27) {
        Function0<FragmentManager> r9 = new AnonymousClass4(r18);
        Intrinsics.checkNotNullParameter(r18, "configComment");
        Intrinsics.checkNotNullParameter(r19, "commentListeners");
        Intrinsics.checkNotNullParameter(r20, "dataControl");
        Intrinsics.checkNotNullParameter(r21, "createCallBack");
        Intrinsics.checkNotNullParameter(r22, "inputRequest");
        Intrinsics.checkNotNullParameter(r23, "dismissCallback");
        Intrinsics.checkNotNullParameter(r24, "getViewParent");
        Intrinsics.checkNotNullParameter(r9, "getFragmentManager");
        Intrinsics.checkNotNullParameter(r25, "sharePermissionViewModel");
        Intrinsics.checkNotNullParameter(r26, "dialogLifecycle");
        Intrinsics.checkNotNullParameter(r27, "avoidKeyboard");
        super(r18, r19, r20, r21, r22, r23, null, r24, r9, r25, 2131559848);
        this.h0 = r27;
        this.i0 = "Comment#AsideInputComment";
        this.l0 = (ImageView) this.l.findViewById(2131369303);
        this.n0 = r18.getActivity().getResources().getConfiguration().orientation;
        this.o0 = r18.getActivity().getResources().getConfiguration().screenLayout;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r0 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a;
        FragmentActivity r1 = r18.getActivity();
        Fragment r2 = r18.b;
        r0.getClass();
        this.p0 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r1, r2);
        this.r0 = new e(this);
        this.s0 = new f(this);
        this.l.setBackground(null);
        this.H.setBackground(null);
        this.H.setBackgroundResource(2131238282);
        this.H.setBackgroundTintList(null);
        Object r3 = I();
        if ((r3 instanceof CommentVoiceBarLayout) == false) goto L5;
        ?? r4 = (CommentVoiceBarLayout) r3;
    L7:
        if (r4 == 0) goto L28;
        CommentVoiceBarLayout.UiMode r11 = CommentVoiceBarLayout.UiMode.ASIDE;
        ew4.g r13 = r18.X.l();
        Intrinsics.checkNotNullParameter(r11, "mode");
        r4.setToggleIconConfig(r13);
        ViewGroup.LayoutParams r12 = r4.getLayoutParams();
        if (r12 == null) goto L26;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r12;
        r14.height = UIUtils.dp2px(r4.getContext(), 36.0f);
        r14.leftMargin = UIUtils.dp2px(r4.getContext(), 8.0f);
        r14.rightMargin = UIUtils.dp2px(r4.getContext(), 8.0f);
        r14.bottomMargin = UIUtils.dp2px(r4.getContext(), 12.0f);
        r4.setLayoutParams(r14);
        r4.setMinimumHeight(UIUtils.dp2px(r4.getContext(), 36.0f));
        r4.setBackgroundResource(2131233335);
        r4.setGravity(16);
        r4.setPadding(UIUtils.dp2px(r4.getContext(), 10.0f), 0, UIUtils.dp2px(r4.getContext(), 36.0f), 0);
        AppCompatImageView r15 = r4.findViewById(2131387913);
        if (r15 == null) goto L17;
        r15.setMinimumHeight(0);
        r15.setBackground(null);
        r15.setPadding(0, 0, 0, 0);
        r15.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageViewCompat.setImageTintList(r15, ContextCompat.getColorStateList(r15.getContext(), 2131102418));
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L16;
        r16.width = UIUtils.dp2px(r15.getContext(), 16.0f);
        r16.height = UIUtils.dp2px(r15.getContext(), 16.0f);
        r15.setLayoutParams(r16);
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L17:
        TextView r5 = (TextView) r4.findViewById(2131371700);
        if (r5 == null) goto L24;
        r5.setMinimumHeight(0);
        r5.setBackground(null);
        r5.setPadding(0, 0, 0, 0);
        r5.setGravity(17);
        r5.setIncludeFontPadding(false);
        r5.setTypeface(Typeface.create("sans-serif-medium", 0));
        r5.setTextColor(ContextCompat.getColor(r5.getContext(), 2131102418));
        r5.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r5, UIUtils.dp2px(r5.getContext(), 22.0f));
        ViewGroup.LayoutParams r17 = r5.getLayoutParams();
        if (r17 == null) goto L23;
        r17.height = -1;
        r5.setLayoutParams(r17);
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L24:
        r4.requestLayout();
        goto L28
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L28:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L46;
        int r6 = UIUtils.dp2px(this.a.getActivity(), 36.0f);
        int r8 = UIUtils.dp2px(this.a.getActivity(), 9.0f);
        int r110 = UIUtils.dp2px(this.a.getActivity(), 12.0f);
        int r7 = UIUtils.dp2px(this.a.getActivity(), 12.0f);
        int r10 = UIUtils.dp2px(this.a.getActivity(), 8.0f);
        Iterator r28 = CollectionsKt.listOf(new ImageView[]{this.n, this.q, this.U}).iterator();
    L31:
        if (r28.hasNext() == false) goto L37;
        ImageView r111 = (ImageView) r28.next();
        ViewGroup.LayoutParams r29 = r111.getLayoutParams();
        if (r29 == null) goto L36;
        r29.width = r6;
        r29.height = r6;
        r111.setLayoutParams(r29);
        r111.setPadding(r8, r8, r8, r8);
        goto L31
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L37:
        LinearLayout r30 = this.J;
        r30.setPadding(r110 - r8, r7, r110 - r10, r30.getPaddingBottom());
        LinearLayout r31 = this.J;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
        if (r32 == null) goto L45;
        ConstraintLayout.LayoutParams r33 = (ConstraintLayout.LayoutParams) r32;
        ((ViewGroup.MarginLayoutParams) r33).bottomMargin = r7;
        r31.setLayoutParams(r33);
        ImageView r34 = (ImageView) this.l.findViewById(2131369348);
        Intrinsics.checkNotNull(r34);
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
        if (r35 == null) goto L43;
        r35.width = r6;
        r35.height = r6;
        r34.setLayoutParams(r35);
        r34.setPadding(r10, r10, r10, r10);
        this.l0.setPadding(UIUtils.dp2px(this.a.getActivity(), 8.0f), UIUtils.dp2px(this.a.getActivity(), 16.0f), UIUtils.dp2px(this.a.getActivity(), 8.0f), UIUtils.dp2px(this.a.getActivity(), 16.0f));
        goto L46
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L45:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L46:
        View r36 = this.l.findViewById(2131369348);
        if (r36 == null) goto L49;
        this.l0.setOnClickListener(new j(r36));
    L49:
        e().addTextChangedListener(new k(this));
        View r37 = I().findViewById(2131387913);
        if (r37 == null) goto L52;
        r37.setOnClickListener(new l(this));
    L52:
        this.J.setBackground(null);
        e().setOnFocusChangeListener(new com.bytedance.ee.bear.middleground.comment.input.a(this, r19));
        U(new com.bytedance.ee.bear.middleground.comment.input.b(r26, this), new com.bytedance.ee.bear.middleground.comment.input.c(this));
        View r38 = LayoutInflater.from(this.k.getContext()).inflate(2131558734, null);
        AtFinderView r39 = (AtFinderView) r38.findViewById(2131363311);
        Intrinsics.checkNotNullParameter(r39, "<set-?>");
        this.L = r39;
        Intrinsics.checkNotNull(r38);
        F().setAtFinderViewDelegate(new g(this));
        int r40 = RangesKt.coerceAtMost(com.bytedance.ee.util.ui.n.d(300), ((C0(this.a.getActivity().getWindow()).getHeight() - pcb.a.a.b(this.a.getActivity()).keyBoardRawHeight()) - StatusBarUtil.getStatusBarHeight(this.a.getActivity())) - com.bytedance.ee.util.ui.n.d(50));
        int r41 = RangesKt.coerceAtMost(com.bytedance.ee.util.ui.n.d(300), C0(this.a.getActivity().getWindow()).getWidth() / 2);
        this.a.getActivity();
        bo4.c r42 = kn4.f.a().a();
        com.bytedance.ee.bear.middleground.comment.uitls.p r43 = this.a;
        kn4.h r44 = new kn4.h(r42, r43.k, r43.i);
        r44.m = r38;
        r44.k = 2;
        r44.o = r40;
        r44.n = r41;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L57;
        List r45 = CollectionsKt.listOfNotNull(new View[]{this.q, I().findViewById(2131371700), I().findViewById(2131387913)});
        r44.q.clear();
        if (r45 == null) goto L57;
        r44.q.addAll(r45);
    L57:
        r44.p = ((xe5.a) org.koin.java.a.c(xe5.a.class, null, null, 6)).a(this.e);
        ArrayList r46 = new ArrayList();
        r46.addAll(AtUtils.c());
        r46.addAll(ArraysKt.toList(com.bytedance.ee.bear.utils.a.c));
        r46.add("7");
        r44.j = r46;
        e().C(r44);
        kn4.g r47 = e().getAtWindow();
        if (r47 == null) goto L60;
        r47.b(new h(this));
    L60:
        kn4.g r48 = e().getAtWindow();
        if (r48 == null) goto L63;
        r48.j();
    L63:
        kn4.g r49 = e().getAtWindow();
        if (r49 == null) goto L66;
        r49.f(new i(this));
    L66:
        this.k.addOnAttachStateChangeListener(new com.bytedance.ee.bear.middleground.comment.input.d(this));
        return;
    L5:
        r4 = 0;
        goto L7
    }
}
