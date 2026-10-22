package com.enroll.audio.enroll.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.enroll.audio.enroll.IBtHeadsetEnrollService;
import com.enroll.audio.enroll.animation.AnimationType;
import com.enroll.audio.enroll.model.TeamEnrollState;
import com.enroll.audio.enroll.model.TeamMember;
import com.enroll.audio.enroll.model.TeamState;
import com.enroll.audio.enroll.model.TipsCode;
import com.enroll.audio.enroll.vm.EnrollViewModel;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\fJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0012\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\"H\u0014J4\u0010)\u001a\u00020\"2\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0/H\u0002J@\u00100\u001a\u00020\"2\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020,0+2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\"0/2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"03H\u0002J\u000e\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0010H\u0002J\b\u00106\u001a\u00020\"H\u0002J\f\u0010:\u001a\u00020\b*\u00020\bH\u0002J\u001c\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0<2\u0006\u0010=\u001a\u00020\bH\u0002J\u0014\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0<H\u0002J\u0012\u0010?\u001a\u00020\"2\b\b\u0002\u0010@\u001a\u00020\u0013H\u0002J\b\u0010A\u001a\u00020\"H\u0014J\b\u0010B\u001a\u00020\"H\u0002J\u0018\u0010C\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010D\u001a\u00020'H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u00107\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006F"}, d2 = {"Lcom/enroll/audio/enroll/view/EnrollStageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/enroll/audio/enroll/BtHeadsetAsrCallback;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "sentence", "Lcom/enroll/audio/enroll/model/EnrollSentence;", "teamViews", "", "Lcom/enroll/audio/enroll/view/EnrollTeamView;", "firstShowDispatched", "", "stageTeam", "getStageTeam", "()Lcom/enroll/audio/enroll/view/EnrollTeamView;", "candidateTeam", "getCandidateTeam", "doneTeams", "", "getDoneTeams", "()Ljava/util/List;", "viewModel", "Lcom/enroll/audio/enroll/vm/EnrollViewModel;", "getViewModel", "()Lcom/enroll/audio/enroll/vm/EnrollViewModel;", "observe", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getTeamFromTaskId", DBDefinition.TASK_ID, "", "onAttachedToWindow", "animateToCandidate", "args", "", "", "index", "onEnd", "Lkotlin/Function0;", "animateToStage", "firstLineEnd", "end", "Lkotlin/Function1;", "getTipsFirstShowAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "animateToDone", "parentID", "getParentID", "()I", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "makePair", "Lkotlin/Pair;", "head", "arrangeNextTeam", "showNextTeam", "firstTime", "onDetachedFromWindow", "clear", "onAsrResult", "resp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollStageView extends ConstraintLayout implements com.enroll.audio.enroll.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pair<Integer, Integer> f273890e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jt7.f f273891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<EnrollTeamView> f273892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f273893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EnrollViewModel f273894d;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f273895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EnrollTeamView f273896b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            FLogger.f375446a.i("EnrollStageView", "animator cancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            FLogger.f375446a.i("EnrollStageView", "animator end");
            this.f273895a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            this.f273896b.setVisibility(0);
        }

        public b(Function0 r100, EnrollTeamView r101) {
            this.f273895a = r100;
            this.f273896b = r101;
        }
    }

    private final int getParentID() {
        return R.id.stage_area;
    }

    static {
        f273890e = TuplesKt.to(-2, -2);
    }

    public final void clear() {
        FLogger.f375446a.i("EnrollStageView", "clear the teamViews ...");
        Iterator r100 = ((ArrayList) this.f273892b).iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        EnrollTeamView r101 = (EnrollTeamView) r100.next();
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "callback");
        String r102 = r101.T5();
        FLogger.f375446a.i("EnrollTeamView", "releaseAsrResource stopRecord deviceType=" + r101.f273906d.getEnrollDeviceType() + " taskId=" + r102);
        IBtHeadsetEnrollService.f273707a.getClass();
        IBtHeadsetEnrollService r103 = IBtHeadsetEnrollService.a.a();
        if (r103 == null) goto L9;
        r103.a(r102);
    L9:
        if (Intrinsics.areEqual(r101.getParent(), this) == false) goto L4;
        removeView(r101);
        goto L4
    L11:
        ((ArrayList) this.f273892b).clear();
    }

    public final EnrollTeamView getCandidateTeam() {
        Iterator<T> r100 = this.f273892b.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((EnrollTeamView) r101).getState() != TeamState.CANDIDATE) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L13:
        return (EnrollTeamView) r101;
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L13
    }

    public final List<EnrollTeamView> getDoneTeams() {
        List<EnrollTeamView> r100 = this.f273892b;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((EnrollTeamView) r103).getState() != TeamState.DONE) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r104 = false;
        goto L9
    L11:
        return r101;
    }

    public final EnrollTeamView getStageTeam() {
        Iterator<T> r100 = this.f273892b.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((EnrollTeamView) r101).getState() != TeamState.ONSTAGE) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L13:
        return (EnrollTeamView) r101;
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L13
    }

    private final List<SpringAnimation> getTipsFirstShowAnimator() {
        ViewParent r100 = getParent();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup");
        final AppCompatTextView r101 = (AppCompatTextView) ((ViewGroup) r100).findViewById(R.id.tip_view);
        float r102 = getResources().getDimension(R.dimen.enroll_tip_view_translate);
        SpringAnimation r103 = new SpringAnimation(r101, DynamicAnimation.TRANSLATION_Y, 0.0f);
        r103.setStartValue(r102);
        r103.getSpring().setStiffness(60.0f);
        r103.getSpring().setDampingRatio(0.8f);
        SpringAnimation r104 = new SpringAnimation(r101, DynamicAnimation.ALPHA, 1.0f);
        r104.setStartValue(0.0f);
        r104.getSpring().setStiffness(60.0f);
        r104.getSpring().setDampingRatio(0.8f);
        r104.addUpdateListener(new j(r101));
        r104.addEndListener(new k(r101));
        return CollectionsKt.mutableListOf(new SpringAnimation[]{r103, r104});
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        clear();
        int r100 = 0;
    L4:
        if (r100 >= 5) goto L12;
        EnrollTeamView r101 = new EnrollTeamView(getContext());
        r101.setIndex(r100);
        r101.setUuid(UUID.randomUUID());
        List<jt7.g> r102 = this.f273891a.b();
        if (r102 != null) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        jt7.g r103 = (jt7.g) CollectionsKt.getOrNull(r102, r100);
        if (r103 != null) goto L11;
        r103 = new jt7.g(r100, 62);
    L11:
        r101.setTeam(r103);
        r101.setState(TeamState.NA);
        r101.setVisibility(8);
        ((ArrayList) this.f273892b).add(r101);
        addView(r101);
        r100 = r100 + 1;
        goto L4
    L12:
        FLogger.f375446a.i("EnrollStageView", "onAttachedToWindow with teamViewsize " + ((ArrayList) this.f273892b).size());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.f375446a.i("EnrollStageView", "onDetachedFromWindow");
        clear();
    }

    public final EnrollViewModel getViewModel() {
        return this.f273894d;
    }

    public EnrollStageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final Pair<Integer, Integer> T5(int r100) {
        int r101 = 0;
        if (r100 >= 0) goto L7;
        return TuplesKt.to(0, 1);
    L7:
        if (r100 < 5) goto L9;
        r100 = -1;
    L11:
        int r102 = r100 + 1;
        if (r102 < 5) goto L14;
        r101 = -1;
    L18:
        return TuplesKt.to(Integer.valueOf(r100), Integer.valueOf(r101));
    L14:
        if (r102 < 0) goto L18;
        r101 = r102;
        goto L18
    L9:
        if (r100 >= 0) goto L11;
        r100 = 0;
        goto L11
    }

    public final void U5(LifecycleOwner r110) {
        Intrinsics.checkNotNullParameter(r110, "lifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), null, null, new EnrollStageView$observe$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), null, null, new EnrollStageView$observe$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), null, null, new EnrollStageView$observe$3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), null, null, new EnrollStageView$observe$4(this, null), 3, null);
    }

    public final void V5(boolean r100) {
        if (getStageTeam() != null) goto L6;
        Pair<Integer, Integer> r101 = T5(-1);
    L21:
        if (Intrinsics.areEqual(r101, f273890e) == false) goto L23;
        return;
    L23:
        int r102 = r101.getFirst().intValue();
        final int r103 = r101.getSecond().intValue();
        FLogger.f375446a.i("EnrollStageView", "showNextTeam will onStage " + r102 + ", and candidata is " + r103);
        if (r102 != r103) goto L28;
        if (r102 != Integer.MAX_VALUE) goto L28;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EnrollStageView$showNextTeam$1(this, null), 3, null);
        return;
    L28:
        if (r100 == true) goto L32;
        EnrollTeamView r104 = getStageTeam();
        ArrayList r105 = new ArrayList();
        if (r104 == null) goto L32;
        r104.setState(TeamState.DONE);
        r104.S5(new q(r104, r105));
    L32:
        if (r100 == false) goto L34;
        R5(MapsKt.mapOf(TuplesKt.to("no-anim", Boolean.TRUE)), r102, new l(this, r103));
        return;
    L34:
        S5(this, new m(this, r103), new n());
        return;
    L6:
        if (getCandidateTeam() == null) goto L9;
        EnrollTeamView r106 = getStageTeam();
        Intrinsics.checkNotNull(r106);
        r101 = T5(r106.getIndex() + 1);
        goto L21
    L9:
        if (getCandidateTeam() != null) goto L16;
        if (getStageTeam() == null) goto L16;
        if ((!getDoneTeams().isEmpty()) == false) goto L16;
        r101 = TuplesKt.to(Integer.MAX_VALUE, Integer.MAX_VALUE);
    L16:
        if (getStageTeam() == null) goto L37;
        if (getCandidateTeam() != null) goto L37;
        r101 = f273890e;
    L37:
        throw new RuntimeException("should not reach here s:" + getStageTeam() + " c:" + getCandidateTeam() + " d:" + getDoneTeams());
    }

    public EnrollStageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // com.enroll.audio.enroll.a
    public final void J0(String r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r211, "resp");
        FLogger r100 = FLogger.f375446a;
        r100.i("EnrollStageView", "onAsrResult " + r210 + " respLen:" + r211.length());
        ct7.a r101 = (ct7.a) GsonProtectorUtils.fromJson(new Gson(), r211, ct7.a.class);
        StringBuilder r102 = new StringBuilder("onAsrResult with entity ---> textLen:");
        String r103 = r101.d();
        boolean r104 = false;
        if (r103 == null) goto L5;
        int r105 = r103.length();
    L6:
        r102.append(r105);
        r102.append(" vadEnd:");
        r102.append(r101.e());
        r102.append(" errorCode:");
        r102.append(r101.b());
        r100.i("EnrollStageView", r102.toString());
        Iterator r106 = ((ArrayList) this.f273892b).iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((EnrollTeamView) r107).T5(), r210) == false) goto L8;
    L13:
        EnrollTeamView r108 = (EnrollTeamView) r107;
        if (r108 == null) goto L97;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "resp");
        String r109 = r101.d();
        String r110 = "";
        if (r109 != null) goto L18;
        r109 = "";
    L18:
        FLogger r111 = FLogger.f375446a;
        StringBuilder r112 = new StringBuilder("onAsrResponseStream : textLen=");
        r112.append(r109.length());
        r112.append(" vadEnd=");
        r112.append(r101.e());
        r112.append(" errorCode=");
        r112.append(r101.b());
        r112.append(" , size ");
        r112.append(r109.length());
        r112.append(" , rawSize: ");
        jt7.g r113 = r108.f273910h;
        if (r113 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r113 = null;
    L21:
        String r114 = r113.b();
        if (r114 != null) goto L24;
        r114 = "";
    L24:
        int r115 = r108.s6(r114).length();
        jt7.g r116 = r108.f273910h;
        if (r116 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r116 = null;
    L27:
        String r117 = r116.e();
        if (r117 != null) goto L30;
        r117 = "";
    L30:
        r112.append(r115 + r108.s6(r117).length());
        r111.i("EnrollTeamView", r112.toString());
        int r118 = r108.s6(r109).length();
        jt7.g r119 = r108.f273910h;
        if (r119 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r119 = null;
    L33:
        String r120 = r119.b();
        if (r120 != null) goto L36;
        r120 = "";
    L36:
        int r121 = r108.s6(r120).length();
        jt7.g r122 = r108.f273910h;
        if (r122 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r122 = null;
    L39:
        String r123 = r122.e();
        if (r123 == null) goto L43;
        r110 = r123;
    L43:
        int r124 = r121 + r108.s6(r110).length();
        if ((r108.f273907e + r118) < r124) goto L46;
        boolean r125 = true;
    L47:
        r111.i("EnrollTeamView", "onAsrResponseStream oversize ? " + r125 + " with enrollState " + r108.f273912j.getValue() + " ... rawlength " + r124 + "  givenLength " + r118 + " historyLength " + r108.f273907e);
        if (EnrollTeamView.F.getValue().contains(Integer.valueOf(r101.b())) == false) goto L63;
        r111.i("EnrollTeamView", "onAsrResponseStream get error code of " + r101.b());
        int r126 = r101.b();
        if (r126 != 500) goto L52;
        r108.f273906d.reportEvent(new jt7.q(TipsCode.TIPS_CODE_ASR_TASK_START_FAILED, null));
    L62:
        BuildersKt.launch$default(r108.f273905c, null, null, new EnrollTeamView$onAsrResponseStream$2(r108, null), 3, null);
        r108.U5();
        return;
    L52:
        if (r126 != 504) goto L54;
        r108.f273906d.reportEvent(new jt7.q(TipsCode.TIPS_CODE_ASR_SESSION_START_FAILED, null));
        goto L62
    L54:
        if (r126 != 505) goto L62;
        if (r108.E == true) goto L59;
        r108.f273906d.reportEvent(new jt7.q(TipsCode.TIPS_CODE_ASR_NETWORK_ERROR, null));
        r108.E = true;
    L59:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$onAsrResponseStream$1(r108, null), 3, null);
        goto L62
    L63:
        r108.E = false;
        BuildersKt.launch$default(r108.f273905c, null, null, new EnrollTeamView$onAsrResponseStream$3(r108, r118, r124, null), 3, null);
        if (r101.e() == true) goto L67;
        if (r125 == true) goto L67;
    L69:
        if (r125 == false) goto L71;
        return;
    L71:
        if (r101.e() == true) goto L73;
    L78:
        boolean r127 = false;
    L80:
        if (r101.e() == false) goto L82;
    L87:
        r108.f273906d.reportEvent(jt7.a.f500323a);
        r111.i("EnrollTeamView", "------ startTimeout ------");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$startTimeout$1(r108, null), 3, null);
        r111.i("EnrollTeamView", "------ restartAsrTimer ------");
        Job r128 = r108.f273915m;
        if (r128 == null) goto L90;
        Job.DefaultImpls.cancel$default(r128, null, 1, null);
    L90:
        r108.f273915m = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$restartAsrTimer$1(r108, null), 3, null);
    L91:
        if (r127 == false) goto L101;
        r108.f273907e += r118;
        r111.i("EnrollTeamView", "onAsrResponseStream vad end , but text is not enough , historyLength " + r108.f273907e);
        return;
    L101:
        return;
    L82:
        if (r109.length() != 0) goto L84;
        r104 = true;
    L84:
        if (r104 == true) goto L87;
        r111.i("EnrollTeamView", "onAsrResponseStream cancel timeout");
        r108.f273906d.reportEvent(jt7.b.f500324a);
        r108.V5();
        r108.U5();
        goto L91
    L73:
        if (r109.length() <= 0) goto L75;
        boolean r129 = true;
    L76:
        if (r129 == false) goto L78;
        r127 = true;
        goto L80
    L75:
        r129 = false;
    L67:
        if (r108.f273912j.getValue() != TeamEnrollState.ENROLLING) goto L69;
        r108.f273911i = r101;
        EnrollTeamView.V6(r108, TeamEnrollState.OVERSIZE);
        r108.f273907e = 0;
        r108.U5();
        return;
    L46:
        r125 = false;
        goto L47
    L97:
        return;
    L12:
        r107 = null;
        goto L13
    L5:
        r105 = 0;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [com.enroll.audio.enroll.view.a, java.lang.Object] */
    public EnrollStageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f273892b = new ArrayList();
        FragmentActivity r103 = (FragmentActivity) r100;
        EnrollViewModel r104 = (EnrollViewModel) new ViewModelProvider(r103).get(EnrollViewModel.class);
        this.f273894d = r104;
        if (r104 == null) goto L22;
        InputStream r105 = r103.getAssets().open("sentence.json");
        int r106 = kt7.c.f506070a;
        Intrinsics.checkNotNullParameter(r105, "inputStream");
        StringBuilder r107 = new StringBuilder();
        BufferedReader r108 = new BufferedReader(new InputStreamReader(r105));
    L23:
        String r109 = r108.readLine();     // Catch: Throwable -> L16
        if (r109 == null) goto L8;
        r107.append(r109);     // Catch: Throwable -> L16
        goto L23
    L8:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r108, null);
        String r111 = r107.toString();
        FLogger r112 = FLogger.f375446a;
        r112.i("EnrollStageView", "json length is " + r111.length());
        jt7.f r113 = (jt7.f) GsonProtectorUtils.fromJson(new Gson(), r111, jt7.f.class);
        this.f273891a = r113;
        r112.i("EnrollStageView", "sentence size=" + r113.a() + " version=" + r113.c());
        this.f273894d.getEnrollSentences().clear();
        List<jt7.g> r114 = this.f273894d.getEnrollSentences();
        List<jt7.g> r115 = r113.b();
        if (r115 != null) goto L12;
        r115 = CollectionsKt.emptyList();
    L12:
        r114.addAll(CollectionsKt.filterNotNull(r115));
        this.f273894d.setEnrollSentence(r113);
        int r116 = com.enroll.audio.enroll.e.f273728a;
        ?? r117 = new com.enroll.audio.enroll.view.a(this);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r117, "closure");
        if (getViewTreeObserver().isAlive() == false) goto L28;
        getViewTreeObserver().addOnGlobalLayoutListener(new com.enroll.audio.enroll.c(this, r117));
        return;
    L28:
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);
        throw th;
    L22:
        throw new RuntimeException("viewModel is null");
    }

    public static void S5(final EnrollStageView r110, final Function0 r111, final Function1 r210) {
        Map r100 = MapsKt.emptyMap();
        final EnrollTeamView r101 = r110.getCandidateTeam();
        if (r101 == null) goto L65;
        r101.setState(TeamState.ONSTAGE);
        int r102 = r101.getTextLines();
        FLogger r103 = FLogger.f375446a;
        r103.i("EnrollTeamView", "onStageReset");
        r101.n6();
        LinkedHashMap r104 = new LinkedHashMap();
        List<SpringAnimation> r105 = new ArrayList();
        boolean r106 = Intrinsics.areEqual(r100.get(SoloKtvContext.SOLO_PAGE_FIRST), Boolean.TRUE);
        if (r106 == false) goto L8;
        r105 = r110.getTipsFirstShowAnimator();
    L8:
        r110.f273894d.getStageingIndex().setValue(Integer.valueOf(r101.getIndex()));
        r103.i("EnrollStageView", "animateToStage set stageingIndex " + r101.getIndex() + " firstShow=" + r106);
        final int r107 = 0;
    L9:
        if (r107 >= r102) goto L46;
        List r112 = (List) r104.get(Integer.valueOf(r107));
        if (r112 != null) goto L13;
        r112 = new ArrayList();
    L13:
        TeamMember.Companion.getClass();
        SpringAnimation r113 = new SpringAnimation(r101.Y5(TeamMember.a.a(r107)), DynamicAnimation.TRANSLATION_Y, r101.Z5(TeamMember.a.a(r107)));
        TeamMember r114 = TeamMember.a.a(r107);
        Intrinsics.checkNotNullParameter(r114, "teamMember");
        float r115 = r101.f273906d.getFootGuideLine();
        if (r114 == TeamMember.TITLE) goto L30;
        Iterator r116 = ((ArrayList) r101.f273927y).iterator();
    L18:
        if (r116.hasNext() == false) goto L25;
        Object r117 = r116.next();
        if (((Pair) r117).getFirst() != r114) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == false) goto L18;
        Object r109 = r117;
    L26:
        Pair r118 = (Pair) r109;
        if (r118 != null) goto L29;
        r115 = 0.0f;
        goto L30
    L29:
        r115 = (r115 + ((Number) et7.h.f473934d.getValue()).floatValue()) + (((Number) et7.h.f473936f.getValue()).floatValue() * ((TeamMember) r118.getFirst()).getOrder());
        goto L30
    L22:
        r108 = false;
        goto L23
    L25:
        r109 = null;
    L30:
        r113.setStartValue(r115);
        r113.getSpring().setStiffness(960.0f);
        r113.getSpring().setDampingRatio(1.3f);
        r112.add(r113);
        TeamMember.Companion.getClass();
        SpringAnimation r119 = new SpringAnimation(r101.Y5(TeamMember.a.a(r107)), DynamicAnimation.ALPHA, 0.7f);
        r119.setStartValue(0.0f);
        r119.getSpring().setStiffness(120.0f);
        r119.getSpring().setDampingRatio(1.3f);
        if (r106 == false) goto L33;
        r119.addUpdateListener(new r(r101, r107));
        r119.addEndListener(new com.enroll.audio.enroll.view.b(r107, r101));
    L33:
        r112.add(r119);
        SpringAnimation r120 = new SpringAnimation(r101.Y5(TeamMember.a.a(r107)), DynamicAnimation.SCALE_X, 1.0f);
        r120.setStartValue(0.6f);
        r120.getSpring().setStiffness(120.0f);
        r120.getSpring().setDampingRatio(0.8f);
        SpringAnimation r121 = new SpringAnimation(r101.Y5(TeamMember.a.a(r107)), DynamicAnimation.SCALE_Y, 1.0f);
        r121.setStartValue(0.6f);
        r121.getSpring().setStiffness(120.0f);
        r121.getSpring().setDampingRatio(0.8f);
        r112.add(r120);
        r112.add(r121);
        if (r107 != 0) goto L37;
        r113.addEndListener(new c(r110, r101));
    L37:
        if (r107 != 1) goto L41;
        r113.addEndListener(new d(r111));
    L41:
        if (r107 != (r102 - 1)) goto L44;
        r113.addEndListener(new e(r101, r210));
    L44:
        r104.put(Integer.valueOf(r107), r112);
        r107 = r107 + 1;
        goto L9
    L46:
        if ((!r105.isEmpty()) == true) goto L49;
        r105 = null;
    L49:
        if (r105 == null) goto L54;
        Iterator<T> r122 = r105.iterator();
    L52:
        if (r122.hasNext() == false) goto L54;
        ((SpringAnimation) r122.next()).start();
    L54:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollStageView$animateToStage$6(r101, r100, r102, r104, null), 3, null);
        return;
    }

    public final void R5(Map<String, ? extends Object> r210, int r211, Function0<Unit> r212) {
        Iterator r100 = ((ArrayList) this.f273892b).iterator();
    L3:
        jt7.g r101 = null;
        if (r100.hasNext() == false) goto L13;
        Object r102 = r100.next();
        EnrollTeamView r103 = (EnrollTeamView) r102;
        if (r103.getIndex() == r211) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L3;
    L14:
        final EnrollTeamView r105 = (EnrollTeamView) r102;
        ConstraintLayout r106 = (ConstraintLayout) findViewById(R.id.stage_area);
        FLogger r107 = FLogger.f375446a;
        r107.i("EnrollStageView", "animateToCandidate " + r105);
        if (r105 != null) goto L17;
        return;
    L17:
        boolean r108 = Intrinsics.areEqual(r210.get("no-anim"), Boolean.TRUE);
        StringBuilder r109 = new StringBuilder("prepare with index ");
        r109.append(r105.f273908f);
        r109.append(" and team index=");
        jt7.g r110 = r105.f273910h;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r110 = null;
    L20:
        r109.append(r110.a());
        r109.append(" lines=");
        jt7.g r111 = r105.f273910h;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r111 = null;
    L23:
        r109.append(r111.c());
        r107.i("EnrollTeamView", r109.toString());
        jt7.g r112 = r105.f273910h;
        if (r112 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r112 = null;
    L26:
        r105.f273908f = r112.a();
        TextView r113 = r105.f273928z;
        jt7.g r114 = r105.f273910h;
        if (r114 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r114 = null;
    L29:
        String r115 = r114.e();
        if (r115 != null) goto L32;
        r115 = "";
    L32:
        r113.setText(r115);
        jt7.g r116 = r105.f273910h;
        if (r116 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r116 = null;
    L35:
        String r117 = r116.b();
        if (r117 != null) goto L38;
        String r118 = "";
    L39:
        List r119 = StringsKt.split$default(r118, new String[]{"$"}, false, 0, 6, null);
        int r120 = r119.size();
        jt7.g r121 = r105.f273910h;
        if (r121 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
    L44:
        if (r120 != r101.c()) goto L64;
        int r122 = r119.size();
        if (r122 == 1) goto L54;
        if (r122 != 2) goto L49;
        r105.A.setText((CharSequence) ListProtector.get(r119, 0));
        r105.B.setText((CharSequence) ListProtector.get(r119, 1));
    L55:
        r105.setState(TeamState.CANDIDATE);
        r105.setVisibility(0);
        ConstraintLayout.LayoutParams r123 = new ConstraintLayout.LayoutParams(-1, -1);
        r123.topToBottom = getParentID();
        r123.bottomToBottom = getParentID();
        r123.startToStart = getParentID();
        r123.endToEnd = getParentID();
        setBackgroundColor(0);
        r105.setLayoutParams(r123);
        r105.setBackgroundColor(getContext().getResources().getColor(R.color.enroll_bg_voice_enroll));
        r105.n6();
        if (r106 == null) goto L58;
        r106.requestLayout();
    L58:
        if (r108 == false) goto L61;
        r105.setAlpha(1.0f);
        EnrollTeamView.k6(r105, TeamMember.ALL, AnimationType.FADE_IN_TO_CANDIDATE, 1.0f);
        r105.setVisibility(0);
        r212.invoke();
        return;
    L61:
        ValueAnimator r124 = new ValueAnimator();
        r124.setIntValues(new int[]{0, 1});
        r124.setDuration(500);
        r124.addUpdateListener(new p(r105));
        r124.addListener(new b(r212, r105));
        r107.i("EnrollStageView", "start animator to candidate with tv " + r105);
        r124.start();
        return;
    L49:
        if (r122 != 3) goto L52;
        r105.A.setText((CharSequence) ListProtector.get(r119, 0));
        r105.B.setText((CharSequence) ListProtector.get(r119, 1));
        r105.C.setText((CharSequence) ListProtector.get(r119, 2));
        goto L55
    L52:
        throw new RuntimeException("invalid subtitleLines");
    L54:
        r105.A.setText((CharSequence) ListProtector.get(r119, 0));
        goto L55
    L64:
        throw new RuntimeException("invalid subtitleLines , not equal with $ ");
    L42:
        r101 = r121;
        goto L44
    L38:
        r118 = r117;
        goto L39
    L8:
        if (r103.getState() != TeamState.NA) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }
}
