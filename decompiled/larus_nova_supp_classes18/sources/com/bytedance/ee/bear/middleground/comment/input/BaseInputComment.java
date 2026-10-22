package com.bytedance.ee.bear.middleground.comment.input;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentWrapper;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.middleground.comment.audio.MotionImageView;
import com.bytedance.ee.bear.middleground.comment.audio.RecordViewModel;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceMentionPermissionHelper;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter;
import com.bytedance.ee.bear.middleground.comment.input.utils.ImageUtils;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.widget.BotAtHintView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.bear.middleground.comment.widget.CommentVoiceBarLayout;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.widget.AtFinderView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.ui.button.LKUICheckBox2;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseInputComment implements kf5.b {
    public static final /* synthetic */ int g0 = 0;
    public final ViewGroup A;
    public AnimatorSet B;
    public AnimatorSet C;
    public Boolean D;
    public final LKUICheckBox2 E;
    public final TextView F;
    public final View G;
    public final Flow H;
    public final ImageView I;
    public final LinearLayout J;
    public View K;
    public AtFinderView L;
    public FileSelectConfig M;
    public DialogFragment N;
    public bb5.b O;
    public bb5.h P;
    public final RecordViewModel Q;
    public final Lazy<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g> R;
    public final Lazy<CommentImmersiveVoiceTouchDelegate> S;
    public final Lazy T;
    public final ImageView U;
    public final RecyclerView V;
    public final CommentImageAdapter W;
    public final b2 X;
    public LiveData<ConnectionService.NetworkState> Y;
    public final h Z;
    public final com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public IImageViewer a0;
    public final com.bytedance.ee.bear.middleground.comment.control.z b;
    public com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a b0;
    public final Function1<String, Unit> c;
    public boolean c0;
    public final Function5<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Boolean, Unit> d;
    public final boolean d0;
    public final Map<String, String> e;
    public final boolean e0;
    public final Function0<ViewGroup> f;
    public final k f0;
    public final Function0<FragmentManager> g;
    public final SharePermissionViewModel h;
    public final String i;
    public CommentInputRequest j;
    public final View k;
    public final ConstraintLayout l;
    public CommentEditText m;
    public final ImageView n;
    public final ImageView o;
    public final ImageView p;
    public final MotionImageView q;
    public final FrameLayout r;
    public final AppCompatImageView s;
    public final AppCompatImageView t;
    public BotAtHintView u;
    public final Lazy v;
    public final View w;
    public final View x;
    public final View y;
    public final View z;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.BaseInputComment$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.BaseInputComment$2, reason: invalid class name */
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

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.BaseInputComment$3, reason: invalid class name */
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
        public /* bridge */ /* synthetic */ Object m171invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.BaseInputComment$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/fragment/app/FragmentManager;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass4 extends Lambda implements Function0<FragmentManager> {
        final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p $configComment;

        public AnonymousClass4(com.bytedance.ee.bear.middleground.comment.uitls.p r1) {
            this.$configComment = r1;
            super(0);
        }

        public final FragmentManager invoke() {
            return this.$configComment.d();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m172invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.input.BaseInputComment$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<com.bytedance.ee.bear.middleground.comment.widget.b, Unit> {
        public AnonymousClass5(Object r8) {
            super(1, r8, BaseInputComment.class, "handleBotHintAction", "handleBotHintAction(Lcom/bytedance/ee/bear/middleground/comment/widget/BotAtHintInfo;)V", 0);
        }

        public final void invoke(com.bytedance.ee.bear.middleground.comment.widget.b r6) {
            Intrinsics.checkNotNullParameter(r6, "p0");
            final BaseInputComment r0 = (BaseInputComment) ((CallableReference) this).receiver;
            int r1 = BaseInputComment.g0;
            final ve5.c r7 = r0.H().i(r6);
            if ((r7 instanceof ve5.c.b) == false) goto L6;
            int r2 = a2.a;
            a2.a(r0.a.getActivity(), r0, new BaseInputComment$handleBotHintAction$1(r0), new BaseInputComment$handleBotHintAction$2(r0), new BaseInputComment$handleBotHintAction$3(r7));
            return;
        L6:
            if (Intrinsics.areEqual(r7, ve5.c.a.a) == false) goto L9;
            return;
        L9:
            throw new NoWhenBranchMatchedException();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.ee.bear.middleground.comment.widget.b) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BaseInputComment a;

        public a(BaseInputComment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            BaseInputComment r4 = this.a;
            r4.a.N.a(new ef5.a0(r4.X.e.is_whole));
        }
    }

    public static final class b {
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ BaseInputComment a;

        public c(BaseInputComment r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Object r3 = r2.getAnimatedValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            this.a.A.getLayoutParams().height = ((Integer) r3).intValue();
            this.a.A.requestLayout();
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ BaseInputComment a;
        public final /* synthetic */ List<FileBean> b;

        public d(BaseInputComment r1, List<? extends FileBean> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r15) {
            Intrinsics.checkNotNullParameter((List) r15, "it");
            Lazy r16 = ImageUtils.a;
            BaseInputComment r17 = this.a;
            CommentInputRequest r0 = r17.j;
            com.bytedance.ee.bear.middleground.comment.uitls.p r18 = r17.a;
            List<FileBean> r1 = this.b;
            Intrinsics.checkNotNullParameter(r0, "inputRequest");
            Intrinsics.checkNotNullParameter(r18, "configComment");
            Intrinsics.checkNotNullParameter(r1, "selectedImages");
            LinkedHashMap r2 = new LinkedHashMap();
            Iterator<FileBean> r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L7;
            FileBean r4 = r3.next();
            Integer r6 = Integer.valueOf(r4.getId());
            StringBuilder r7 = new StringBuilder();
            r7.append(r6);
            r7.append(System.currentTimeMillis());
            r4.setUuid(r7.toString());
            String r8 = r4.getPath();
            StringBuilder r13 = new StringBuilder("docsource://com.bytedance.net/file/f/");
            ((v45.a) org.koin.java.a.c(v45.a.class, null, null, 6)).c();
            r13.append(r4.getUuid());
            r13.append(r8.substring(StringsKt.lastIndexOf$default(r8, ".", 0, false, 6, null)));
            String r5 = r13.toString();
            r2.put(r5, r4.getPath());
            r4.setPath(r5);
            goto L4
        L7:
            return ((v45.a) org.koin.java.a.c(v45.a.class, null, null, 6)).i(r0.getDocUrl(), r18.i, r2);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ BaseInputComment a;
        public final /* synthetic */ List<FileBean> b;

        public e(BaseInputComment r1, List<? extends FileBean> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            tt5.a.h(this.a.L(), "saveImagesToLocal...");
            this.a.Q(this.b);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ BaseInputComment a;

        public f(BaseInputComment r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            String r0 = this.a.L();
            tt5.a.e(r0, "Failed to insertImages2Local...", (Throwable) r4, false);
            this.a.Q(CollectionsKt.emptyList());
        }
    }

    public static final class g extends za5.b {
        public final /* synthetic */ BaseInputComment a;

        public g(BaseInputComment r1) {
            this.a = r1;
        }

        public final void c(List<? extends FileBean> r4) {
            Intrinsics.checkNotNullParameter(r4, "fileList");
            tt5.a.h(this.a.L(), "onSelectFileBeanList... fileList = " + r4.size());
            this.a.P(r4);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ BaseInputComment a;

        public h(BaseInputComment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ConnectionService.NetworkState r3 = (ConnectionService.NetworkState) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            boolean r0 = true;
            if (r3.a() == true) goto L6;
            r0 = false;
        L6:
            this.a.b0(r0);
        }
    }

    public static final class i implements Animator.AnimatorListener {
        public final /* synthetic */ BaseInputComment a;
        public final /* synthetic */ AnimatorSet b;
        public final /* synthetic */ AnimatorSet c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            this.a.A.setVisibility(8);
            this.c.removeAllListeners();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.A.setVisibility(8);
            this.b.removeAllListeners();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            this.a.A.setVisibility(0);
        }

        public i(BaseInputComment r1, AnimatorSet r2, AnimatorSet r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ BaseInputComment a;

        public j(BaseInputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseInputComment r0 = this.a;     // Catch: Throwable -> L6
            LiveData<ConnectionService.NetworkState> r1 = r0.Y;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.removeObserver(r0.Z);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ BaseInputComment a;

        public k(BaseInputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.p0(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ BaseInputComment a;

        public l(BaseInputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseInputComment r0 = this.a;     // Catch: Throwable -> L4
            List<ve5.m> r1 = r0.B(r0.A());     // Catch: Throwable -> L4
            ve5.e r2 = r0.H();     // Catch: Throwable -> L4
            r2.getClass();     // Catch: Throwable -> L4
            Intrinsics.checkNotNullParameter(r1, "mentions");     // Catch: Throwable -> L4
            r2.l(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class m implements Runnable {
        public final /* synthetic */ BaseInputComment a;

        public m(BaseInputComment r1) {
            this.a = r1;
        }

        public final void a() {
            kn4.g r0 = this.a.e().getAtWindow();
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L12;
            this.a.n.setSelected(false);
            kn4.g r2 = this.a.e().getAtWindow();
            if (r2 == null) goto L12;
            r2.j();
        L12:
            this.a.U.setSelected(true);
            this.a.v();
            FileSelectConfig r3 = this.a.J();
            r3.maxSelectImageNum = 9 - ((ArrayList) this.a.X.k).size();
            FileSelectConfig r4 = this.a.J();
            r4.ccmPickViewHeight = this.a.K();
            this.a.s0();
            return;
        L5:
            if (r0.isShowing() != true) goto L7;
            r1 = true;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class n implements Runnable {
        public final /* synthetic */ BaseInputComment a;

        public n(BaseInputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rcb.c.h(this.a.e(), null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract void C();

    public ViewGroup E() {
        return null;
    }

    public abstract int K();

    public abstract void S();

    public abstract void Z();

    @Override // kf5.b
    public void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    @Override // kf5.b
    public void b() {
    }

    @Override // kf5.b
    public void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    public void d0() {
    }

    public void f0() {
    }

    @Override // kf5.b
    public void q(boolean r1) {
    }

    public void v() {
    }

    public abstract void y0();

    static {
        cu5.c.b(100);
    }

    public final AtFinderView F() {
        AtFinderView r0 = this.L;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("atList");
        return null;
    }

    public final BotAtHintView G() {
        BotAtHintView r0 = this.u;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("botAtHintView");
        return null;
    }

    public final ve5.e H() {
        return (ve5.e) this.v.getValue();
    }

    public final View I() {
        View r0 = this.K;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("commentVoiceBar");
        return null;
    }

    public final FileSelectConfig J() {
        FileSelectConfig r0 = this.M;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fileSelectConfig");
        return null;
    }

    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g M() {
        return (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g) this.R.getValue();
    }

    public final CommentVoiceMentionPermissionHelper N() {
        return (CommentVoiceMentionPermissionHelper) this.T.getValue();
    }

    public final void R() {
        rcb.c.c(this.k.getContext());
        rcb.c.d((View) this.f.invoke());
    }

    public void T() {
        com.bytedance.ee.bear.middleground.comment.uitls.p r0 = this.a;
        int r2 = 8;
        if (r0.e0 == false) goto L20;
        AppCompatImageView r1 = this.s;
        boolean r3 = true;
        if (r0.f0 == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L12;
        int r5 = 0;
    L13:
        r1.setVisibility(r5);
        AppCompatImageView r6 = this.t;
        if (this.X.e.visibilityBean.getType() != 0) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        r2 = 0;
    L19:
        r6.setVisibility(r2);
        return;
    L12:
        r5 = 8;
        goto L13
    L7:
        if (this.X.e.isCreate() == false) goto L9;
        r4 = true;
        goto L10
    L20:
        this.t.setVisibility(8);
        this.s.setVisibility(8);
    }

    public final CommentImmersiveVoiceTouchDelegate V() {
        if (this.S.isInitialized() == true) goto L7;
        return null;
    L7:
        return (CommentImmersiveVoiceTouchDelegate) this.S.getValue();
    }

    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g W() {
        if (this.R.isInitialized() == true) goto L7;
        return null;
    L7:
        return (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g) this.R.getValue();
    }

    public boolean c0() {
        IImageViewer r0 = this.a0;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L14;
        IImageViewer r2 = this.a0;
        if (r2 == null) goto L12;
        r2.close();
    L12:
        return true;
    L14:
        if (this.U.isSelected() == false) goto L16;
        x(false);
    L16:
        return false;
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // kf5.b
    public void destroy() {
        this.X.b();
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = W();
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        CommentImmersiveVoiceTouchDelegate r1 = V();
        if (r1 == null) goto L9;
        r1.a();
        return;
    }

    @Override // kf5.b
    public final CommentEditText e() {
        CommentEditText r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        return null;
    }

    public void g0() {
        this.X.f = false;
        com.bytedance.ee.util.ui.m.a(new j(this));
        com.bytedance.ee.util.ui.j.e(this.f0);
        p0(false);
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = W();
        if (r0 == null) goto L6;
        r0.d();
        return;
    L6:
        this.Q.i();
    }

    @Override // kf5.b
    public final boolean isShowing() {
        if (this.k.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void m0() {
        ImageView r0 = this.o;
        if (this.X.j() == true) goto L7;
        if (this.a.g0.a == false) goto L7;
    L8:
        int r1 = 0;
    L10:
        r0.setVisibility(r1);
        return;
    L7:
        if (this.j.isShowAreaSelectBtn == true) goto L8;
        r1 = 8;
        goto L10
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void o0() {
        if (this.a.o != 0) goto L5;
    L11:
        String r0 = this.a.getActivity().getString(2131887661);
    L12:
        Intrinsics.checkNotNull(r0);
        e().setHint(this.X.e.resolveInputHint(r0));
        boolean r1 = true;
        if (this.a.B == false) goto L15;
        this.h.i(e(), true, new BaseInputComment$setInputConfig$1(this));
    L15:
        FrameLayout r2 = this.r;
        int r3 = 8;
        if (this.X.f() == true) goto L18;
    L25:
        int r4 = 8;
    L26:
        r2.setVisibility(r4);
        this.o.setSelected(this.a.g0.b);
        if (this.o.isSelected() == true) goto L38;
        LiveData<ConnectionService.NetworkState> r5 = this.Y;
        if (r5 == null) goto L35;
        ConnectionService.NetworkState r6 = (ConnectionService.NetworkState) r5.getValue();
        if (r6 == null) goto L35;
        if (r6.a() != true) goto L35;
    L36:
        if (r1 == true) goto L38;
        this.o.setEnabled(false);
    L35:
        r1 = false;
    L38:
        m0();
        ImageView r7 = this.U;
        if (this.X.c.E == false) goto L41;
        r3 = 0;
    L41:
        r7.setVisibility(r3);
        q0();
        CommentEditText r8 = e();
        CharSequence r9 = e().getHint();
        if (r9 == null) goto L45;
        String r10 = r9.toString();
        if (r10 == null) goto L45;
    L46:
        r8.setOriginHint(r10);
        boolean r11 = this.X.e.is_whole;
        if (r11 == false) goto L49;
        String r12 = "full_comment";
    L50:
        if (r11 == false) goto L52;
        String r13 = "full_comment";
    L53:
        int r14 = AtUtils.h(this.a.k);
        if (TextUtils.isEmpty(this.a.I) == true) goto L56;
        int r15 = 24;
    L57:
        CommentEditText r16 = e();
        com.bytedance.ee.bear.middleground.comment.uitls.p r17 = this.a;
        bo4.d r18 = new bo4.d(r17.i, r15, r12, r13, r17.I);
        kn4.g r19 = r16.k1;
        if (r19 == null) goto L61;
        r19.g(r18);
        return;
    L61:
        return;
    L56:
        r15 = r14;
        goto L57
    L52:
        r13 = "part_comment";
        goto L53
    L49:
        r12 = "part_comment";
    L45:
        r10 = "";
        goto L46
    L18:
        if (this.X.j() == true) goto L20;
    L22:
        boolean r20 = false;
    L23:
        if (r20 == true) goto L25;
        r4 = 0;
        goto L26
    L20:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L22;
        r20 = true;
        goto L23
    L5:
        if (this.X.e.isCreate() == true) goto L11;
        if (this.X.e.visibilityBean.getType() == 0) goto L10;
        r0 = this.a.getActivity().getString(2131889228);
        goto L12
    L10:
        r0 = this.a.getActivity().getString(2131887629);
        goto L12
    }

    public final void q0() {
        RecyclerView r0 = this.V;
        b2 r1 = this.X;
        if (r1.c.F == true) goto L5;
    L7:
        int r2 = 8;
    L8:
        r0.setVisibility(r2);
        return;
    L5:
        if ((!r1.k.isEmpty()) == false) goto L7;
        r2 = 0;
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void r0() {
        boolean r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        AppCompatImageView r1 = this.q;
        if (r0 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r1.setEnabled(r2);
        return;
    L5:
        if (this.X.f() == false) goto L7;
        r2 = true;
        goto L8
    }

    @Override // kf5.b
    public final void s() {
        ((ArrayList) this.X.k).clear();
        CommentImageAdapter r0 = this.W;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r1 = this.X.k;
        r0.p.dispose();
        r0.z2(r1, false);
        A0();
    }

    @Override // kf5.b
    public final int t() {
        return this.l.getMeasuredHeight();
    }

    public void v0() {
        if (this.U.isSelected() == true) goto L5;
        i0(new m(this));
        return;
    L5:
        if (this.e0 == true) goto L7;
        w0(0);
        x(false);
        return;
    L7:
        x(true);
    }

    public com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f w() {
        FragmentActivity r2 = this.a.getActivity();
        Fragment r3 = this.a.b;
        CommentVoiceEditTextBridge r5 = new CommentVoiceEditTextBridge(e());
        Function0<ViewGroup> r6 = new BaseInputComment$buildVoiceInputContext$1(this);
        com.bytedance.ee.bear.middleground.comment.uitls.p r7 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r8 = r7.d0;
        String r9 = du5.b.g(r7.i);
        String r10 = this.a.k.getType();
        int r11 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.e.a;
        return new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f(r2, r3, r5, r6, r8, r9, r10, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.e.a(this.a), new BaseInputComment$buildVoiceInputContext$2(this), new BaseInputComment$buildVoiceInputContext$3(this), null, new BaseInputComment$buildVoiceInputContext$4(this), new BaseInputComment$buildVoiceInputContext$5(this), new BaseInputComment$buildVoiceInputContext$6(this), new BaseInputComment$buildVoiceInputContext$7(this), null, new BaseInputComment$buildVoiceInputContext$8(this), new BaseInputComment$buildVoiceInputContext$9(this), new BaseInputComment$buildVoiceInputContext$10(N()), new BaseInputComment$buildVoiceInputContext$11(this), this.b.k1(), new BaseInputComment$buildVoiceInputContext$12(this), new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.o(new BaseInputComment$buildVoiceInputContext$13(this), new BaseInputComment$buildVoiceInputContext$14(this), new BaseInputComment$buildVoiceInputContext$15(this), new BaseInputComment$buildVoiceInputContext$16(this), new BaseInputComment$buildVoiceInputContext$17(this)), null, new BaseInputComment$buildVoiceInputContext$18(this), 268185600, 8);
    }

    public final List<un5.l> A() {
        Editable r0 = e().getText();
        if (r0 == null) goto L11;
        Editable r1 = e().getText();
        if (r1 == null) goto L7;
        int r2 = r1.length();
    L8:
        un5.l[] r3 = (un5.l[]) r0.getSpans(0, r2, un5.l.class);
        if (r3 == null) goto L11;
        List<un5.l> r4 = ArraysKt.toList(r3);
    L12:
        if (r4 == null) goto L14;
        return r4;
    L14:
        return CollectionsKt.emptyList();
    L7:
        r2 = 0;
    L11:
        r4 = null;
        goto L12
    }

    public final void A0() {
        Editable r0 = e().getText();
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
    L7:
        boolean r2 = false;
        if (TextUtils.isEmpty(com.bytedance.ee.bear.middleground.comment.uitls.n.f(r1)) == true) goto L10;
    L13:
        boolean r3 = true;
    L14:
        ImageView r4 = this.p;
        if (r3 == true) goto L17;
    L19:
        r4.setEnabled(r2);
        return;
    L17:
        if (this.c0 == true) goto L19;
        r2 = true;
        goto L19
    L10:
        if ((!this.X.k.isEmpty()) == true) goto L13;
        r3 = false;
    L6:
        r1 = "";
        goto L7
    }

    public boolean X() {
        kn4.g r0 = e().getAtWindow();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public void h0() {
        e().setEnabled(true);
        this.q.setSelected(false);
    }

    @Override // kf5.b
    public final void l() {
        String r0 = L();
        StringBuilder r1 = new StringBuilder("restoreInputStatus()... isShowing = ");
        r1.append(isShowing());
        r1.append(", insertImageView.isSelected = ");
        r1.append(this.U.isSelected());
        r1.append(", atWindow.isShowing = ");
        kn4.g r2 = e().getAtWindow();
        if (r2 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r2.isShowing());
    L6:
        r1.append(r3);
        tt5.a.h(r0, r1.toString());
        if (isShowing() == true) goto L10;
        return;
    L10:
        if (this.U.isSelected() == false) goto L13;
        return;
    L13:
        if (this.q.isSelected() == false) goto L15;
        return;
    L15:
        w0(100);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void n0() {
        boolean r0 = X();
        tt5.a.h(L(), "setAtView: isAtWindowShowing:" + r0);
        if (r0 == false) goto L7;
        this.n.setSelected(false);
        kn4.g r1 = e().getAtWindow();
        if (r1 == null) goto L12;
        r1.j();
        return;
    L12:
        return;
    L7:
        this.n.setSelected(true);
        e().J();
        if (this.e0 == true) goto L10;
        w0(0);
        x(false);
        return;
    L10:
        x(true);
    }

    public void s0() {
        tt5.a.h(L(), "showFileSelectFragment in BaseInputComment");
        if (this.a.X.f() == false) goto L6;
        u0();
        return;
    L6:
        int r0 = com.bytedance.ee.bear.fileselector.d.a;
        this.N = com.bytedance.ee.bear.fileselector.d.a.c(this.a.getActivity(), (FragmentManager) this.g.invoke(), J(), "Comment#InputComment_ImageSelector");
    }

    public final boolean u0() {
        tt5.a.h(L(), "showHostImageSelectorFragment in BaseInputComment");
        int r3 = K();
        int r4 = 9 - ((ArrayList) this.X.k).size();
        Function1<List<? extends ew4.f>, Unit> r5 = new BaseInputComment$showHostImageSelectorFragment$request$1(this);
        Function1<CommentImageSelectorDismissReason, Unit> r6 = new BaseInputComment$showHostImageSelectorFragment$request$2(this);
        bb5.b r1 = this.O;
        if (r1 != null) goto L5;
        ew4.d.a.getClass();
        ew4.d r7 = ew4.d.a.b;
    L6:
        ew4.e r0 = new ew4.e(r3, r4, r5, r6, r7);
        DialogFragment r2 = this.a.X.e(new p(this), r0);
        if (r2 != null) goto L18;
        return false;
    L18:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L11
        this.N = r2;     // Catch: Throwable -> L11
        t0(r2);     // Catch: Throwable -> L11
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L17;
        tt5.a.e(L(), "showHostImageSelectorFragment failed", r10, false);
        this.N = null;
    L17:
        return Result.isSuccess-impl(r9);
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L5:
        r7 = new l0(r1);
        goto L6
    }

    public void z() {
        kn4.g r0 = e().getAtWindow();
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isShowing() != true) goto L7;
    L8:
        if (r2 == false) goto L13;
        this.n.setSelected(false);
        kn4.g r1 = e().getAtWindow();
        if (r1 == null) goto L13;
        r1.j();
    L13:
        if (this.U.isSelected() == false) goto L16;
        x(false);
        return;
    L16:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public String L() {
        return this.i;
    }

    @Override // kf5.b
    public final b2 f() {
        return this.X;
    }

    @Override // kf5.b
    public final View getRootView() {
        return this.k;
    }

    @Override // kf5.b
    public final CommentInputRequest i() {
        return this.j;
    }

    public static final void u(BaseInputComment r2) {
        if (r2.q.isSelected() == false) goto L8;
        r2.a.d0.m("text_edit");
        com.bytedance.ee.bear.middleground.comment.audio.b r3 = r2.q.a;
        if (r3 == null) goto L12;
        r3.onClick();
        return;
    L12:
        return;
    L8:
        if (r2.e0 == true) goto L10;
        r2.w0(0);
        r2.x(false);
        return;
    L10:
        r2.x(true);
    }

    public static /* synthetic */ void x0(BaseInputComment r2) {
        r2.w0(0);
    }

    public static /* synthetic */ boolean y(BaseInputComment r1) {
        return r1.x(false);
    }

    public final List<ve5.m> B(List<? extends un5.l> r8) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L43;
        un5.l r1 = (un5.l) r9.next();
        String r2 = r1.d;
        ve5.m r3 = null;
        if (r2 != null) goto L8;
    L41:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        if ((!StringsKt.isBlank(r2)) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L41;
        String r4 = r1.a();
        if (r4 == null) goto L23;
        String r5 = StringsKt.removePrefix(r4, "@");
        if (r5 == null) goto L23;
        if ((!StringsKt.isBlank(r5)) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L23;
    L40:
        r3 = new ve5.m(r2, r5, r1.q);
    L23:
        String r6 = r1.i;
        if (r6 == null) goto L30;
        r5 = StringsKt.removePrefix(r6, "@");
        if (r5 == null) goto L30;
        if ((!StringsKt.isBlank(r5)) == false) goto L30;
    L31:
        if (r5 != null) goto L40;
        r5 = r1.f;
        if (r5 != null) goto L35;
    L37:
        r5 = null;
    L38:
        if (r5 != null) goto L40;
    L35:
        if ((!StringsKt.isBlank(r5)) == false) goto L37;
    L30:
        r5 = null;
        goto L31
    L43:
        return r0;
    }

    public final void O(bo4.a r5) {
        ve5.e r0 = H();
        if (r5 == null) goto L5;
        String r1 = r5.e;
    L6:
        boolean r2 = false;
        if (r5 == null) goto L9;
        int r3 = r5.y;
    L10:
        r0.c(r1, r3);
        if (r5 != null) goto L13;
    L15:
        if (r2 == false) goto L18;
        H().h(r5);
        return;
    L18:
        return;
    L13:
        if (r5.y != 4) goto L15;
        r2 = true;
        goto L15
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void P(List<? extends FileBean> r3) {
        Intrinsics.checkNotNullParameter(r3, "fileList");
        Flowable.just(r3).flatMap(new d(this, r3)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new e(this, r3), new f(this));
    }

    public void Q(List<? extends FileBean> r6) {
        Intrinsics.checkNotNullParameter(r6, "selectedImages");
        tt5.a.b(L(), "Receive selected images. " + r6);
        x(false);
        w0(50);
        if (((ArrayList) this.X.k).size() != 9) goto L7;
        Toast.showFailureText(this.a.getActivity(), xo5.a.c(this.a.getActivity(), 2131886932, "count", "9"));
        return;
    L7:
        if ((!r6.isEmpty()) == true) goto L9;
        return;
    L9:
        if ((r6.size() + ((ArrayList) this.X.k).size()) <= 9) goto L11;
        r6 = r6.subList(0, 9 - ((ArrayList) this.X.k).size());
    L11:
        this.X.getClass();
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r7 = b2.e(r6);
        this.W.z2(r7, true);
        b2 r1 = this.X;
        r1.getClass();
        ((ArrayList) r7).isEmpty();
        ((ArrayList) r1.k).addAll(r7);
        A0();
        this.a.N.a(new ef5.s(0, r7, this));
        q0();
    }

    public final void Y(boolean r14) {
        boolean r0 = this.h.e();
        int r2 = 8;
        if (this.d0 == false) goto L8;
        tt5.a.h(L(), "mentionBatchAskOwnerEnable is true, currUserManageCollaborator is " + r0);
        if (r0 == true) goto L7;
        this.F.setText(com.bytedance.ee.util.ui.n.x(this.k.getContext(), 2131889126));
    L14:
        Editable r1 = e().getText();
        if (r1 == null) goto L28;
        Editable r4 = e().getText();
        if (r4 == null) goto L19;
        int r5 = r4.length();
    L20:
        un5.l[] r3 = (un5.l[]) r1.getSpans(0, r5, un5.l.class);
        if (r3 == null) goto L28;
        int r6 = r3.length;
        int r7 = 0;
        boolean r8 = false;
    L23:
        if (r7 >= r6) goto L30;
        if (r3[r7].j == false) goto L27;
        r8 = true;
    L27:
        r7 = r7 + 1;
    L30:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L35;
        if (Intrinsics.areEqual(this.D, Boolean.valueOf(r8)) == false) goto L35;
        return;
    L35:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L37;
        this.D = Boolean.valueOf(r8);
    L37:
        AnimatorSet r9 = this.B;
        if (r9 != null) goto L40;
    L42:
        boolean r10 = false;
    L43:
        if (r10 == false) goto L46;
        if (r8 == false) goto L46;
        return;
    L46:
        AnimatorSet r11 = this.C;
        if (r11 != null) goto L49;
    L51:
        boolean r12 = false;
    L52:
        if (r12 == false) goto L56;
        if (r8 == true) goto L56;
        return;
    L56:
        if (this.A.getVisibility() != 0) goto L58;
        boolean r13 = true;
    L59:
        if (r13 != r8) goto L75;
        AnimatorSet r15 = this.B;
        if (r15 != null) goto L63;
    L65:
        boolean r16 = false;
    L66:
        if (r16 == true) goto L75;
        AnimatorSet r17 = this.C;
        if (r17 != null) goto L70;
    L72:
        boolean r18 = false;
    L73:
        if (r18 == true) goto L75;
        return;
    L70:
        if (r17.isRunning() != true) goto L72;
        r18 = true;
        goto L73
    L63:
        if (r15.isRunning() != true) goto L65;
        r16 = true;
    L75:
        if (r8 == false) goto L96;
        com.bytedance.ee.bear.middleground.comment.uitls.p r19 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r20 = r19.d0;
        CommentInputRequest r21 = this.j;
        String r22 = r21.comment_id;
        if (r22 != null) goto L79;
        r22 = "";
    L79:
        String r23 = r21.reply_id;
        if (r23 != null) goto L82;
        String r24 = "";
    L83:
        CommentPlugin.g r25 = r19.R;
        if (r25 != null) goto L86;
    L88:
        boolean r110 = false;
    L89:
        CommentPlugin.g r26 = this.a.R;
        if (r26 != null) goto L92;
    L94:
        boolean r111 = false;
    L95:
        r20.f(r22, r24, r110, r111, this.j.visibilityBean.getReportVisibility());
        goto L96
    L92:
        if (r26.c() != true) goto L94;
        r111 = true;
        goto L95
    L86:
        if (r25.b() != true) goto L88;
        r110 = true;
        goto L89
    L82:
        r24 = r23;
    L96:
        AnimatorSet r27 = this.C;
        if (r27 == null) goto L99;
        r27.cancel();
    L99:
        AnimatorSet r28 = this.B;
        if (r28 == null) goto L102;
        r28.cancel();
    L102:
        this.E.setChecked(false);
        ViewGroup r29 = this.A;
        if (r8 == false) goto L105;
        r2 = 0;
    L105:
        r29.setVisibility(r2);
        if (r14 == false) goto L120;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L116;
        if (r8 == false) goto L116;
        ViewGroup r112 = this.A;
        ViewGroup.LayoutParams r30 = r112.getLayoutParams();
        if (r30 == null) goto L113;
        r30.height = -2;
    L114:
        r112.setLayoutParams(r30);
        this.A.setAlpha(1.0f);
        this.A.requestLayout();
        return;
    L113:
        r30 = null;
    L116:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L136;
        this.A.setAlpha(0.0f);
        return;
    L136:
        return;
    L120:
        if (this.B != null) goto L122;
    L123:
        int r113 = View.MeasureSpec.makeMeasureSpec(1073741823, 0);
        this.A.getLayoutParams().height = -2;
        this.A.measure(r113, r113);
        this.B = D(0, this.A.getMeasuredHeight(), 0.0f, 1.0f);
        this.C = D(this.A.getMeasuredHeight(), 0, 1.0f, 0.0f);
    L124:
        if (r8 == false) goto L128;
        AnimatorSet r114 = this.B;
        if (r114 == null) goto L137;
        r114.start();
        return;
    L137:
        return;
    L128:
        AnimatorSet r115 = this.C;
        if (r115 == null) goto L139;
        r115.addListener(new i(this, r115, r115));
        r115.start();
        return;
    L139:
        return;
    L122:
        if (this.C != null) goto L124;
    L58:
        r13 = false;
        goto L59
    L49:
        if (r11.isRunning() != true) goto L51;
        r12 = true;
        goto L52
    L40:
        if (r9.isRunning() != true) goto L42;
        r10 = true;
        goto L43
    L19:
        r5 = 0;
    L28:
        r8 = false;
        goto L30
    L7:
        this.F.setText(com.bytedance.ee.util.ui.n.x(this.k.getContext(), 2131889123));
        goto L14
    L8:
        if (r0 == true) goto L14;
        tt5.a.h(L(), "currUserManageCollaborator is false");
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L12;
        this.D = Boolean.FALSE;
    L12:
        this.A.setVisibility(8);
    }

    public void a0(CommentImageSelectorDismissReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.U.setSelected(false);
        if (r3 == CommentImageSelectorDismissReason.PASSIVE_INPUT_OTHER_ACTION) goto L6;
        e().requestFocus();
        w0(50);
        return;
    }

    public void b0(boolean r3) {
        this.n.setEnabled(r3);
        r0();
        boolean r0 = true;
        if (r3 == true) goto L5;
        e().setEnabled(true);
    L5:
        CommentImageAdapter r1 = this.W;
        r1.a = r3;
        r1.notifyDataSetChanged();
        this.U.setEnabled(r3);
        ImageView r2 = this.o;
        if (r3 == false) goto L8;
    L11:
        r2.setEnabled(r0);
        return;
    L8:
        if (r2.isSelected() == true) goto L11;
        r0 = false;
        goto L11
    }

    public void i0(m r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        S();
        r2.run();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kf5.b
    public final void j(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "userIds");
        this.h.l(r4);
        this.h.i(e(), true, new BaseInputComment$updateUserPermission$1(this));
    }

    @Override // kf5.b
    public void n(SmartReplyDataForInsert r2) {
        this.X.l = r2;
    }

    @Override // kf5.b
    public final void o(List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3) {
        b2 r0 = this.X;
        ((ArrayList) r0.k).clear();
        if (r3 == null) goto L5;
        ArrayList r1 = (ArrayList) r0.k;
        r1.addAll(r3);
    L5:
        CommentImageAdapter r4 = this.W;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2 = this.X.k;
        r4.p.dispose();
        r4.z2(r2, false);
        q0();
        A0();
    }

    @Override // kf5.b
    public final void p(CommentInputRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.j = r2;
        this.X.l(r2);
    }

    public final void p0(boolean r1) {
        this.c0 = r1;
        A0();
    }

    @Override // kf5.b
    public final void r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        e().setRichText(r2);
        if (r2.length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        e().post(new l(this));
        return;
    L9:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void t0(DialogFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        FragmentManager r0 = (FragmentManager) this.g.invoke();
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "Comment#InputComment_ImageSelector", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r4, r1) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r4.show(r0, "Comment#InputComment_ImageSelector");
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kf5.b
    public void update(boolean r5) {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r0.g("ccm.mobile.set_empty_text_when_update_input_comment") == false) goto L5;
        r("");
    L5:
        tt5.a.h(L(), "update()");
        o0();
        if (r0.g("ccm.mobile.ui_state_fix_enable") == false) goto L8;
        tt5.a.h(L(), "ui state fix enable is on");
        T();
    L8:
        this.a.N.a(new ef5.p(this));
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L11;
        this.D = null;
    L11:
        this.h.i(e(), false, new C03521(this));
        if (r5 == false) goto L15;
        w0(50);
        e().requestFocus();
        return;
    }

    public void w0(long r3) {
        e().postDelayed(new n(this), r3);
        T();
    }

    public boolean x(boolean r7) {
        boolean r1 = false;
        this.U.setSelected(false);
        if (this.e0 == true) goto L7;
        tt5.a.h(L(), "closeImageSelectorView in BaseInputComment, fg is off");
        int r8 = com.bytedance.ee.bear.fileselector.d.a;
        return com.bytedance.ee.bear.fileselector.d.a.a((FragmentManager) this.g.invoke(), "Comment#InputComment_ImageSelector");
    L7:
        if (this.a.X.f() == true) goto L13;
        int r0 = com.bytedance.ee.bear.fileselector.d.a;
        boolean r2 = com.bytedance.ee.bear.fileselector.d.a.a((FragmentManager) this.g.invoke(), "Comment#InputComment_ImageSelector");
        if (r7 == false) goto L11;
        w0(0);
    L11:
        tt5.a.h(L(), "closeImageSelectorView in BaseInputComment, fg is on, use default selector, showKeyboardAfterDismiss=" + r7 + ", dismissedByManager=" + r2);
        return r2;
    L13:
        DialogFragment r3 = this.N;
        if (r7 == false) goto L16;
        CommentImageSelectorDismissReason r4 = CommentImageSelectorDismissReason.PASSIVE_INPUT_HOST_CLOSE;
    L17:
        if (r3 != null) goto L19;
    L21:
        if (r7 == false) goto L24;
        if (r1 == true) goto L24;
        w0(0);
    L24:
        tt5.a.h(L(), "closeImageSelectorView in BaseInputComment, fg is on, use host selector, showKeyboardAfterDismiss=" + r7 + ", dismissedByHost=" + r1 + ", reason=" + r4);
        return r1;
    L19:
        if (this.a.X.c(r3, r4) != true) goto L21;
        r1 = true;
        goto L21
    L16:
        r4 = CommentImageSelectorDismissReason.PASSIVE_INPUT_OTHER_ACTION;
        goto L17
    }

    public void z0(boolean r3) {
        ViewGroup.LayoutParams r0 = e().getLayoutParams();
        if (r3 == false) goto L6;
        if (r0 == null) goto L8;
        r0.height = (int) this.a.getActivity().getResources().getDimension(2131165348);
    L8:
        e().requestLayout();
        return;
    L6:
        if (r0 == null) goto L8;
        r0.height = -2;
        goto L8
    }

    public final void B0(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r2 instanceof TextView) == false) goto L5;
        TextView r4 = (TextView) r2;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        int r5 = r3.getAction() & 255;
        if (r5 != 0) goto L11;
        r4.setText(2131890974);
        return;
    L11:
        if (r5 != 1) goto L13;
    L15:
        r4.setText(2131890964);
        return;
    L13:
        if (r5 == 3) goto L15;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void U(bb5.b r5, bb5.h r6) {
        Intrinsics.checkNotNullParameter(r5, "dialogLifecycle");
        this.O = r5;
        this.P = r6;
        FileSelectConfig.e r0 = FileSelectConfig.ccmAlbumBuilder();
        FileSelectConfig r1 = ((FileSelectConfig.c) r0).a;
        r1.adjustHeightByKeyboard = false;
        r1.showGif = true;
        r1.showVideo = false;
        r1.enableImageCompress = true;
        r1.actionType = 1;
        r1.totalMaxPhotoCount = 9;
        g r2 = new g(this);
        FileSelectConfig r3 = ((FileSelectConfig.c) r0).a;
        r3.fileSelectListener = r2;
        r3.dialogLifecycle = r5;
        r3.onDismissListener = r6;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.bitable.comment_memory_leak_fix_enable") == false) goto L10;
        com.bytedance.ee.bear.middleground.comment.uitls.p r7 = this.a;
        if (r7.V == false) goto L7;
    L12:
        FileSelectConfig r8 = r0.a();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        this.M = r8;
        return;
    L7:
        if (ForsetiHelper.s(r7.b) == false) goto L12;
        ((FileSelectConfig.c) r0).a.container = this.a.c;
        goto L12
    L10:
        if (ForsetiHelper.s(this.a.b) == false) goto L12;
        ((FileSelectConfig.c) r0).a.container = this.a.c;
        goto L12
    }

    @Override // kf5.b
    public void d(final boolean r8, boolean r9) {
        tt5.a.h(L(), "dismiss(), bySend: " + r8 + ", isShowing: " + isShowing());
        if (isShowing() == true) goto L5;
        return;
    L5:
        ViewGroup r2 = null;
        if (r8 == true) goto L12;
        Pair[] r3 = new Pair[3];
        r3[0] = new Pair("is_full_comment_flag", String.valueOf(this.j.is_whole));
        if (this.a.V == false) goto L10;
        String r4 = "discussion";
    L11:
        r3[1] = TuplesKt.to(ResourceData.KEY_TYPE, r4);
        r3[2] = TuplesKt.to("comment_visible_range", this.j.visibilityBean.getReportVisibility());
        this.a.d0.g("cancel_click", null, null, MapsKt.mutableMapOf(r3));
        goto L12
    L10:
        r4 = "comment";
    L12:
        kn4.g r5 = e().getAtWindow();
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L22;
        kn4.g r7 = e().getAtWindow();
        if (r7 == null) goto L22;
        r7.close();
    L22:
        CommentEditText r10 = e();
        r10.getClass();
        tt5.a.h("Comment#CommentEditText", "onInputHide");
        if (r10.V1 == true) goto L25;
    L27:
        e().setFragment(null);
        IImageViewer r1 = this.a0;
        if (r1 == null) goto L30;
        r1.close();
    L30:
        this.a0 = null;
        x(false);
        h0();
        if (r9 == false) goto L33;
        rcb.c.d(this.l);
    L33:
        ViewParent r11 = this.k.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L36;
        r2 = (ViewGroup) r11;
    L36:
        if (r2 == null) goto L38;
        r2.removeView(this.k);
    L38:
        this.Q.f();
        H().d();
        int r12 = com.bytedance.ee.bear.middleground.comment.uitls.n.a;
        com.bytedance.ee.bear.middleground.comment.uitls.n.a(e(), new BaseInputComment$dismiss$closeD$1(this, r8));
        return;
    L25:
        if (r10.g2 == true) goto L27;
        tt5.a.h("Comment#CommentEditText", "edittext is hidden after stopping recording, so force stop update audio text");
        r10.g2 = true;
        goto L27
    L15:
        if (r5.isShowing() != true) goto L17;
        r6 = true;
        goto L18
    }

    public boolean e0(View r4, MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "event");
        B0(r4, r5);
        if ((!(this instanceof AsideInputComment)) == false) goto L7;
        int r0 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a;
        if (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a(this.a.getActivity(), r5, this.b.P()) == false) goto L7;
        return true;
    L7:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r1 = M();
        if (r1 != null) goto L12;
        return false;
    L12:
        return r1.f(r4, r5);
    }

    @Override // kf5.b
    public void g(String r3, DriveCommentWrapper.7 r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.h.k(r3, true, r4);
    }

    public void j0(boolean r8, Boolean r9) {
        k0(r8, r9, null, null, true, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void l0(CharSequence r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "content");
        if (StringsKt.isBlank(r11) == false) goto L6;
        tt5.a.h(L(), "sendVoiceCommentDirectly skip: blank content");
        return;
    L6:
        Editable r0 = e().getText();
        int r2 = 0;
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L22;
        Boolean r5 = Boolean.valueOf(r12);
        int r13 = CommentVoiceEditTextBridge.i;
        k0(true, r5, CommentVoiceEditTextBridge.a.b(r11), CollectionsKt.emptyList(), false, r11.toString());
        return;
    L22:
        s();
        Editable r4 = e().getText();
        if (r4 == null) goto L30;
        Editable r6 = e().getText();
        if (r6 == null) goto L27;
        int r7 = r6.length();
    L29:
        if (r4.replace(0, r7, r11) == null) goto L30;
    L31:
        UDEditText r14 = e();
        Editable r8 = e().getText();
        if (r8 == null) goto L34;
        r2 = r8.length();
    L34:
        r14.setSelection(r2);
        this.h.i(e(), true, new BaseInputComment$sendVoiceCommentDirectly$1(this));
        j0(true, Boolean.valueOf(r12));
        return;
    L27:
        r7 = 0;
    L30:
        e().setText(new SpannableStringBuilder(r11));
        Unit r15 = Unit.INSTANCE;
        goto L31
    L15:
        if ((!((ArrayList) this.X.k).isEmpty()) == true) goto L18;
        r3 = false;
        goto L19
    L9:
        if (StringsKt.isBlank(r0) == true) goto L12;
        r1 = false;
        goto L13
    }

    @Override // kf5.b
    public void m(List r2, com.bytedance.ee.bear.drive.biz.comment.e1 r3) {
        Intrinsics.checkNotNullParameter(r2, "userIds");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.h.j(r2, r3);
    }

    public final AnimatorSet D(int r6, int r7, float r8, float r9) {
        AnimatorSet r0 = new AnimatorSet();
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{r6, r7});
        r10.addUpdateListener(new c(this));
        r0.playTogether(new Animator[]{r10, ObjectAnimator.ofFloat(this.A, "alpha", new float[]{r8, r9})});
        r0.setDuration(100);
        return r0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kf5.b
    public void h(boolean r5, boolean r6, boolean r7, boolean r8, boolean r9) {
        r("");
        tt5.a.h(L(), "show(), showRecordPanel: " + r5 + ", showAt: " + r6 + ", showKeyBoard: " + r7 + ", inputRequest: " + this.X.e);
        C();
        this.a.N.a(new ef5.t(this));
        this.h.n();
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
        this.D = null;
    L5:
        this.h.i(e(), false, new BaseInputComment$show$1(this));
        List<ve5.m> r0 = B(A());
        ve5.e r1 = H();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "mentions");
        r1.l(r0);
        H().j();
        this.E.setChecked(r9);
        if (r6 == false) goto L8;
        this.n.performClick();
    L8:
        if (r5 == false) goto L12;
        e().setShowSoftInputOnFocus(false);
        e().requestFocus();
        com.bytedance.ee.bear.middleground.comment.audio.b r10 = this.q.a;
        if (r10 == null) goto L16;
        r10.onClick();
    L16:
        this.b.B0().invoke();
        return;
    L12:
        if (r8 == false) goto L14;
        v0();
        goto L16
    L14:
        if (r7 == false) goto L16;
        w0(50);
        e().requestFocus();
        goto L16
    }

    public final void k0(final boolean r13, Boolean r14, final String r15, final List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r16, final boolean r17, final String r18) {
        h0();
        tt5.a.h(L(), "sendComment");
        if (r14 == null) goto L6;
        boolean r8 = r14.booleanValue();
    L14:
        CommentVoiceMentionPermissionHelper r9 = N();
        CharSequence r0 = e().getText();
        if (r0 != null) goto L18;
        r0 = "";
    L18:
        r9.e(r0, r8, new BaseInputComment$sendCommentInternal$1(this, r13, r15, r16, r17, r18));
        return;
    L6:
        if (this.A.getVisibility() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
    L13:
        r8 = false;
        goto L14
    L11:
        if (this.E.b == false) goto L13;
        r8 = true;
        goto L14
    L8:
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.widget.ImageView, com.bytedance.ee.bear.middleground.comment.audio.MotionImageView] */
    public BaseInputComment(com.bytedance.ee.bear.middleground.comment.uitls.p r17, com.bytedance.ee.bear.middleground.comment.control.z r18, com.bytedance.ee.bear.middleground.comment.control.t r19, Function1<? super String, Unit> r20, CommentInputRequest r21, Function5<? super String, ? super List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, ? super Boolean, ? super String, ? super Boolean, Unit> r22, Map<String, String> r23, Function0<? extends ViewGroup> r24, Function0<? extends FragmentManager> r25, SharePermissionViewModel r26, int r27) {
        Intrinsics.checkNotNullParameter(r17, "configComment");
        Intrinsics.checkNotNullParameter(r18, "commentListeners");
        Intrinsics.checkNotNullParameter(r19, "dataControl");
        Intrinsics.checkNotNullParameter(r20, "createCallBack");
        Intrinsics.checkNotNullParameter(r21, "inputRequest");
        Intrinsics.checkNotNullParameter(r22, "dismissCallback");
        Intrinsics.checkNotNullParameter(r24, "getViewParent");
        Intrinsics.checkNotNullParameter(r25, "getFragmentManager");
        Intrinsics.checkNotNullParameter(r26, "sharePermissionViewModel");
        this.a = r17;
        this.b = r18;
        this.c = r20;
        this.d = r22;
        this.e = r23;
        this.f = r24;
        this.g = r25;
        this.h = r26;
        this.i = "Comment#BaseInputComment";
        this.j = r21;
        this.v = LazyKt.lazy(new BaseInputComment$botMentionHintCoordinator$2(this));
        this.Q = new RecordViewModel(r17);
        this.R = LazyKt.lazy(new BaseInputComment$voiceAdapterLazy$1(this));
        this.S = LazyKt.lazy(new BaseInputComment$immersiveVoiceTouchDelegateLazy$1(this));
        this.T = LazyKt.lazy(new BaseInputComment$voiceMentionPermissionHelper$2(this));
        CommentImageAdapter r4 = new CommentImageAdapter();
        this.W = r4;
        b2 r5 = new b2(r17, r19, r18);
        this.X = r5;
        this.Z = new h(this);
        com.bytedance.ee.bear.appsetting.c r2 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.d0 = r2.g("ccm.mobile.comment_batch_askowner");
        this.e0 = !r2.g("ccm_mobile_ccm_at_doubao_reverse_in_feishu");
        View r3 = LayoutInflater.from(r17.getActivity()).inflate(r27, null);
        this.k = r3;
        ConstraintLayout r6 = r3.findViewById(2131375341);
        this.l = r6;
        this.A = (ViewGroup) r6.findViewById(2131365642);
        LKUICheckBox2 r7 = r6.findViewById(2131365640);
        this.E = r7;
        this.F = (TextView) r3.findViewById(2131365655);
        View r8 = r6.findViewById(2131365659);
        this.G = r8;
        CommentEditText r9 = (CommentEditText) r6.findViewById(2131369299);
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.m = r9;
        FrameLayout r10 = (FrameLayout) r6.findViewById(2131372887);
        this.r = r10;
        ?? r11 = (MotionImageView) r6.findViewById(2131367301);
        this.q = r11;
        ImageView r12 = (ImageView) r6.findViewById(2131369295);
        this.n = r12;
        ImageView r13 = (ImageView) r6.findViewById(2131369294);
        this.o = r13;
        ImageView r14 = (ImageView) r6.findViewById(2131369348);
        this.p = r14;
        this.w = r6.findViewById(2131369209);
        this.x = r6.findViewById(2131369210);
        ImageView r15 = (ImageView) r6.findViewById(2131369305);
        this.U = r15;
        RecyclerView r16 = r6.findViewById(2131385004);
        this.V = r16;
        this.H = r6.findViewById(2131369298);
        LinearLayout r110 = (LinearLayout) r6.findViewById(2131369296);
        this.J = r110;
        View r28 = r6.findViewById(2131367474);
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        this.K = r28;
        Object r29 = I();
        if ((r29 instanceof CommentVoiceBarLayout) == false) goto L5;
        CommentVoiceBarLayout r30 = (CommentVoiceBarLayout) r29;
    L6:
        if (r30 == null) goto L9;
        r30.setToggleIconConfig(r17.X.l());
    L9:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L12;
        we5.a.a(r110, r10, r15);
    L12:
        this.I = (ImageView) r6.findViewById(2131369297);
        this.y = r6.findViewById(2131369189);
        this.z = r6.findViewById(2131369190);
        this.s = r6.findViewById(2131369309);
        AppCompatImageView r31 = r6.findViewById(2131369302);
        this.t = r31;
        BotAtHintView r32 = (BotAtHintView) r6.findViewById(2131364352);
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        this.u = r32;
        G().setCommentAnalytic(r17.d0);
        G().setOnActionClick(new AnonymousClass5(this));
        G().setRecyclerNestedScrollingEnabled(true);
        if (r17.G == false) goto L15;
        zz7.a.d(e(), LarkFont.BODY0);
    L15:
        r17.h.getClass();
        r5.l(this.j);
        r16.setLayoutManager(new LinearLayoutManager(r17.getActivity(), 0, false));
        r16.addItemDecoration(new BaseInputComment$initDefaultData$1());
        r4.a = r5.c.E;
        r4.notifyDataSetChanged();
        r16.setAdapter(r4);
        e().setPreImeListener(new t(this));
        e().setMovementMethod(new com.bytedance.ee.bear.middleground.comment.widget.l0());
        q0();
        r0();
        e().setOnPasteListener(new v(this));
        r17.h.getClass();
        if (com.bytedance.ee.bear.middleground.comment.p.c() != true) goto L18;
        r12.setVisibility(8);
    L18:
        e().setFragment(r17.b);
        r13.setOnClickListener(new d0(this));
        e().addOnAttachStateChangeListener(new e0(this));
        r8.setOnClickListener(new f0(this));
        r7.setOnCheckedChangeListener(new g0(this));
        if (rcb.b.a(r17.getActivity()) == false) goto L21;
        e().setOnEditorActionListener(new h0(this));
    L21:
        e().addTextChangedListener(new BaseInputComment$setListener$6(this));
        r14.setOnClickListener(new i0(this));
        e().setOnClickListener(new j0(this));
        e().setOnTouchListener(new k0(this));
        r11.setOnTouchListener(new w(this));
        r11.setMotionCallbackListener(new BaseInputComment$setListener$11(this));
        View r33 = I().findViewById(2131387913);
        if (r33 == null) goto L24;
        r33.setOnClickListener(new x(this));
    L24:
        View r34 = I().findViewById(2131371700);
        if (r34 == null) goto L27;
        r34.setOnTouchListener(new y(this));
    L27:
        bf5.a r35 = r17.S;
        int r36 = r17.k.b;
        gj5.c r37 = r35.a(r17.i);
        r12.setOnClickListener(new com.bytedance.ee.bear.middleground.comment.input.utils.a(new BaseInputComment$setListener$14(this)));
        Ref.ObjectRef r38 = new Ref.ObjectRef();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r39 = jg5.e.a.a.g();
        if (r39 == false) goto L31;
        r38.element = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity("", sbb.e.l, BizDomain.FileBizDomainCCM, ""), "ATTACHMENT_UPLOAD"), null);
    L31:
        if (r37.a == false) goto L33;
        float r40 = 1.0f;
    L34:
        r15.setAlpha(r40);
        r15.setOnClickListener(new z(this, r39, r38, r37));
        r4.j = new a0(this);
        r4.k = new b0(this);
        r6.setOnClickListener(c0.a);
        r4.g = r17.i;
        r4.h = r17.k.b;
        r31.setOnClickListener(new a(this));
        this.f0 = new k(this);
        return;
    L33:
        r40 = 0.5f;
        goto L34
    L5:
        r30 = null;
        goto L6
    }
}
