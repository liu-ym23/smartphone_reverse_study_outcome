package com.obric.audio.enroll.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
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
import com.google.gson.Gson;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.IEnrollService;
import com.obric.audio.enroll.animation.AnimationType;
import com.obric.audio.enroll.model.TeamEnrollState;
import com.obric.audio.enroll.model.TeamMember;
import com.obric.audio.enroll.model.TeamState;
import com.obric.audio.enroll.model.TipsCode;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
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

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\fJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0012\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020&H\u0014J4\u0010,\u001a\u00020&2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020&02H\u0002J@\u00103\u001a\u00020&2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020/0.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020&022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020&06H\u0002J\u000e\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0010H\u0002J\b\u00109\u001a\u00020&H\u0002J\f\u0010=\u001a\u00020\b*\u00020\bH\u0002J\u001c\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0?2\u0006\u0010@\u001a\u00020\bH\u0002J\u0014\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0?H\u0002J\u0012\u0010B\u001a\u00020&2\b\b\u0002\u0010C\u001a\u00020\u0013H\u0002J\b\u0010D\u001a\u00020&H\u0014J\b\u0010E\u001a\u00020&H\u0002J\u0018\u0010F\u001a\u00020&2\u0006\u0010*\u001a\u00020\"2\u0006\u0010G\u001a\u00020\"H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010:\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006I"}, d2 = {"Lcom/obric/audio/enroll/view/EnrollStageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/audio/enroll/EnrollAsrCallback;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "sentence", "Lcom/obric/audio/enroll/model/EnrollSentence;", "teamViews", "", "Lcom/obric/audio/enroll/view/EnrollTeamView;", "firstShowDispatched", "", "stageTeam", "getStageTeam", "()Lcom/obric/audio/enroll/view/EnrollTeamView;", "candidateTeam", "getCandidateTeam", "doneTeams", "", "getDoneTeams", "()Ljava/util/List;", "viewModel", "Lcom/obric/audio/enroll/vm/EnrollViewModel;", "getViewModel", "()Lcom/obric/audio/enroll/vm/EnrollViewModel;", "resolveSentenceAssetName", "", "getCurrentLocale", "Ljava/util/Locale;", "observe", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getTeamFromTaskId", DBDefinition.TASK_ID, "onAttachedToWindow", "animateToCandidate", "args", "", "", "index", "onEnd", "Lkotlin/Function0;", "animateToStage", "firstLineEnd", "end", "Lkotlin/Function1;", "getTipsFirstShowAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "animateToDone", "parentID", "getParentID", "()I", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "makePair", "Lkotlin/Pair;", "head", "arrangeNextTeam", "showNextTeam", "firstTime", "onDetachedFromWindow", "clear", "onAsrResult", "resp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollStageView extends ConstraintLayout implements com.obric.audio.enroll.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pair<Integer, Integer> f395676e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qia.f f395677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<EnrollTeamView> f395678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f395679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EnrollViewModel f395680d;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f395681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EnrollTeamView f395682b;

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
            this.f395681a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            this.f395682b.setVisibility(0);
        }

        public b(Function0 r100, EnrollTeamView r101) {
            this.f395681a = r100;
            this.f395682b = r101;
        }
    }

    private final int getParentID() {
        return R.id.stage_area;
    }

    static {
        f395676e = TuplesKt.to(-2, -2);
    }

    public final void clear() {
        FLogger.f375446a.i("EnrollStageView", "clear the teamViews ...");
        Iterator r100 = ((ArrayList) this.f395678b).iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        EnrollTeamView r101 = (EnrollTeamView) r100.next();
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "callback");
        String r102 = r101.U5();
        FLogger.f375446a.i("EnrollTeamView", "releaseAsrResource stopRecord deviceType=" + r101.f395692d.getEnrollDeviceType() + " taskId=" + r102);
        IEnrollService.f395407a.getClass();
        IEnrollService r103 = IEnrollService.a.a();
        if (r103 == null) goto L9;
        r103.a(r102);
    L9:
        if (Intrinsics.areEqual(r101.getParent(), this) == false) goto L4;
        removeView(r101);
        goto L4
    L11:
        ((ArrayList) this.f395678b).clear();
    }

    public final EnrollTeamView getCandidateTeam() {
        Iterator<T> r100 = this.f395678b.iterator();
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
        List<EnrollTeamView> r100 = this.f395678b;
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
        Iterator<T> r100 = this.f395678b.iterator();
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
        float r102 = getResources().getDimension(R.dimen.sva_tip_view_translate);
        SpringAnimation r103 = new SpringAnimation(r101, DynamicAnimation.TRANSLATION_Y, 0.0f);
        r103.setStartValue(r102);
        r103.getSpring().setStiffness(60.0f);
        r103.getSpring().setDampingRatio(0.8f);
        SpringAnimation r104 = new SpringAnimation(r101, DynamicAnimation.ALPHA, 1.0f);
        r104.setStartValue(0.0f);
        r104.getSpring().setStiffness(60.0f);
        r104.getSpring().setDampingRatio(0.8f);
        r104.addUpdateListener(new com.obric.audio.enroll.view.a(r101));
        r104.addEndListener(new j(r101));
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
        List<qia.g> r102 = this.f395677a.a();
        if (r102 != null) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        qia.g r103 = (qia.g) CollectionsKt.getOrNull(r102, r100);
        if (r103 != null) goto L11;
        r103 = new qia.g(r100, 126);
    L11:
        r101.setTeam(r103);
        r101.setState(TeamState.NA);
        r101.setVisibility(8);
        ((ArrayList) this.f395678b).add(r101);
        addView(r101);
        r100 = r100 + 1;
        goto L4
    L12:
        FLogger.f375446a.i("EnrollStageView", "onAttachedToWindow with teamViewsize " + ((ArrayList) this.f395678b).size());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.f375446a.i("EnrollStageView", "onDetachedFromWindow");
        clear();
    }

    public final EnrollViewModel getViewModel() {
        return this.f395680d;
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
        if (Intrinsics.areEqual(r101, f395676e) == false) goto L23;
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
        r104.T5(new g(r104, r105));
    L32:
        if (r100 == false) goto L34;
        R5(MapsKt.mapOf(TuplesKt.to("no-anim", Boolean.TRUE)), r102, new k(this, r103));
        return;
    L34:
        S5(this, new l(this, r103), new m());
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
        r101 = f395676e;
    L37:
        throw new RuntimeException("should not reach here s:" + getStageTeam() + " c:" + getCandidateTeam() + " d:" + getDoneTeams());
    }

    public EnrollStageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // com.obric.audio.enroll.a
    public final void J0(String r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r211, "resp");
        FLogger r100 = FLogger.f375446a;
        r100.i("EnrollStageView", "onAsrResult " + r210 + ' ' + r211);
        kia.a r101 = (kia.a) GsonProtectorUtils.fromJson(new Gson(), r211, kia.a.class);
        StringBuilder r102 = new StringBuilder("onAsrResult with entity ---> : ");
        r102.append(r211);
        r100.i("EnrollStageView", r102.toString());
        Iterator r103 = ((ArrayList) this.f395678b).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((EnrollTeamView) r104).U5(), r210) == false) goto L4;
    L9:
        EnrollTeamView r105 = (EnrollTeamView) r104;
        if (r105 == null) goto L90;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "resp");
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("onAsrResponseStream :");
        r107.append(r101);
        r107.append(" , size ");
        r107.append(r101.b().length());
        r107.append(" , rawSize: ");
        qia.g r108 = r105.f395696h;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r108 = null;
    L14:
        String r109 = r108.c();
        String r110 = "";
        if (r109 != null) goto L17;
        r109 = "";
    L17:
        int r111 = r105.u6(r109).length();
        qia.g r112 = r105.f395696h;
        if (r112 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r112 = null;
    L20:
        String r113 = r112.f();
        if (r113 != null) goto L23;
        r113 = "";
    L23:
        r107.append(r111 + r105.u6(r113).length());
        r106.i("EnrollTeamView", r107.toString());
        int r114 = r105.u6(r101.b()).length();
        qia.g r115 = r105.f395696h;
        if (r115 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r115 = null;
    L26:
        String r116 = r115.c();
        if (r116 != null) goto L29;
        r116 = "";
    L29:
        int r117 = r105.u6(r116).length();
        qia.g r118 = r105.f395696h;
        if (r118 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r118 = null;
    L32:
        String r119 = r118.f();
        if (r119 == null) goto L36;
        r110 = r119;
    L36:
        int r120 = r117 + r105.u6(r110).length();
        boolean r121 = false;
        if ((r105.f395693e + r114) < r120) goto L39;
        boolean r122 = true;
    L40:
        r106.i("EnrollTeamView", "onAsrResponseStream oversize ? " + r122 + " with enrollState " + r105.f395698j.getValue() + " ... rawlength " + r120 + "  givenLength " + r114 + " historyLength " + r105.f395693e);
        if (EnrollTeamView.G.getValue().contains(Integer.valueOf(r101.a())) == false) goto L56;
        r106.i("EnrollTeamView", "onAsrResponseStream get error code of " + r101.a());
        int r123 = r101.a();
        if (r123 != 500) goto L45;
        r105.f395692d.reportEvent(new qia.q(TipsCode.TIPS_CODE_ASR_TASK_START_FAILED));
    L55:
        BuildersKt.launch$default(r105.f395691c, null, null, new EnrollTeamView$onAsrResponseStream$2(r105, null), 3, null);
        r105.V5();
        return;
    L45:
        if (r123 != 504) goto L47;
        r105.f395692d.reportEvent(new qia.q(TipsCode.TIPS_CODE_ASR_SESSION_START_FAILED));
        goto L55
    L47:
        if (r123 != 505) goto L55;
        if (r105.F == true) goto L52;
        r105.f395692d.reportEvent(new qia.q(TipsCode.TIPS_CODE_ASR_NETWORK_ERROR));
        r105.F = true;
    L52:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$onAsrResponseStream$1(r105, null), 3, null);
        goto L55
    L56:
        r105.F = false;
        BuildersKt.launch$default(r105.f395691c, null, null, new EnrollTeamView$onAsrResponseStream$3(r105, r114, r120, null), 3, null);
        if (r101.c() == true) goto L60;
        if (r122 == true) goto L60;
    L62:
        if (r122 == false) goto L64;
        return;
    L64:
        if (r101.c() == true) goto L66;
    L71:
        boolean r124 = false;
    L73:
        if (r101.c() == false) goto L75;
    L80:
        r105.f395692d.reportEvent(qia.a.f533209a);
        r106.i("EnrollTeamView", "------ startTimeout ------");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$startTimeout$1(r105, null), 3, null);
        r106.i("EnrollTeamView", "------ restartAsrTimer ------");
        Job r125 = r105.f395702n;
        if (r125 == null) goto L83;
        Job.DefaultImpls.cancel$default(r125, null, 1, null);
    L83:
        r105.f395702n = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollTeamView$restartAsrTimer$1(r105, null), 3, null);
    L84:
        if (r124 == false) goto L94;
        r105.f395693e += r114;
        r106.i("EnrollTeamView", "onAsrResponseStream vad end , but text is not enough , historyLength " + r105.f395693e);
        return;
    L94:
        return;
    L75:
        if (r101.b().length() != 0) goto L77;
        r121 = true;
    L77:
        if (r121 == true) goto L80;
        r106.i("EnrollTeamView", "onAsrResponseStream cancel timeout");
        r105.f395692d.reportEvent(qia.b.f533210a);
        r105.Y5();
        r105.V5();
        goto L84
    L66:
        if (r101.b().length() <= 0) goto L68;
        boolean r126 = true;
    L69:
        if (r126 == false) goto L71;
        r124 = true;
        goto L73
    L68:
        r126 = false;
    L60:
        if (r105.f395698j.getValue() != TeamEnrollState.ENROLLING) goto L62;
        r105.f395697i = r101;
        EnrollTeamView.l7(r105, TeamEnrollState.OVERSIZE);
        r105.f395693e = 0;
        r105.V5();
        return;
    L39:
        r122 = false;
        goto L40
    L90:
        return;
    L8:
        r104 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r8v12, types: [com.obric.audio.enroll.view.n, java.lang.Object] */
    public EnrollStageView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f395678b = new ArrayList();
        EnrollViewModel r102 = (EnrollViewModel) new ViewModelProvider((FragmentActivity) r100).get(EnrollViewModel.class);
        this.f395680d = r102;
        if (r102 == null) goto L56;
        Configuration r103 = r100.getResources().getConfiguration();
        boolean r104 = false;
        if (Build.VERSION.SDK_INT < 24) goto L10;
        Locale r105 = r103.getLocales().get(0);
        if (r105 != null) goto L9;
        r105 = Locale.getDefault();
    L9:
        Intrinsics.checkNotNull(r105);
    L14:
        String r111 = r105.getLanguage();
        Locale r106 = Locale.ROOT;
        String r112 = r111.toLowerCase(r106);
        String r107 = r105.getScript().toLowerCase(r106);
        String r108 = r105.toLanguageTag().toLowerCase(r106);
        if (Intrinsics.areEqual(r112, "zh") == true) goto L17;
    L34:
        FLogger.f375446a.i("EnrollStageView", "resolveSentenceAssetName language=" + r112 + " languageTag=" + r108 + " script=" + r107 + " isTraditionalChinese=" + r104);
        if (r104 == false) goto L37;
        String r109 = "sentence_hk.json";
    L38:
        InputStream r113 = ((FragmentActivity) r100).getAssets().open(r109);
        int r114 = sia.c.f542254a;
        Intrinsics.checkNotNullParameter(r113, "inputStream");
        StringBuilder r115 = new StringBuilder();
        BufferedReader r116 = new BufferedReader(new InputStreamReader(r113));
    L59:
        String r117 = r116.readLine();     // Catch: Throwable -> L50
        if (r117 == null) goto L42;
        r115.append(r117);     // Catch: Throwable -> L50
        goto L59
    L42:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L50
        CloseableKt.closeFinally(r116, null);
        String r119 = r115.toString();
        FLogger r120 = FLogger.f375446a;
        r120.i("EnrollStageView", "load sentence asset: " + r109 + ", json is " + r119);
        qia.f r121 = (qia.f) GsonProtectorUtils.fromJson(new Gson(), r119, qia.f.class);
        this.f395677a = r121;
        r120.i("EnrollStageView", "sentence is " + r121);
        this.f395680d.getEnrollSentences().clear();
        List<qia.g> r122 = this.f395680d.getEnrollSentences();
        List<qia.g> r123 = r121.a();
        if (r123 != null) goto L46;
        r123 = CollectionsKt.emptyList();
    L46:
        r122.addAll(CollectionsKt.filterNotNull(r123));
        this.f395680d.setEnrollSentence(r121);
        int r124 = com.obric.audio.enroll.f.f395442a;
        ?? r125 = new n(this);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r125, "closure");
        if (getViewTreeObserver().isAlive() == false) goto L62;
        getViewTreeObserver().addOnGlobalLayoutListener(new com.obric.audio.enroll.e(this, r125));
        return;
    L62:
        return;
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        CloseableKt.closeFinally(r116, th);
        throw th;
    L37:
        r109 = "sentence.json";
        goto L38
    L17:
        if (Intrinsics.areEqual(r107, "hant") == false) goto L19;
    L31:
        boolean r126 = true;
    L32:
        if (r126 == false) goto L34;
        r104 = true;
        goto L34
    L19:
        if (StringsKt.contains$default(r108, "hant", false, 2, null) == true) goto L31;
        if (Intrinsics.areEqual(r107, "hans") == false) goto L24;
    L30:
        r126 = false;
        goto L32
    L24:
        if (StringsKt.contains$default(r108, "hans", false, 2, null) == true) goto L30;
        if (StringsKt.contains$default(r108, "-cn", false, 2, null) == true) goto L30;
        if (StringsKt.contains$default(r108, "-sg", false, 2, null) == false) goto L31;
    L10:
        r105 = r103.locale;
        if (r105 != null) goto L13;
        r105 = Locale.getDefault();
    L13:
        Intrinsics.checkNotNull(r105);
        goto L14
    L56:
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
        r101.o6();
        LinkedHashMap r104 = new LinkedHashMap();
        List<SpringAnimation> r105 = new ArrayList();
        boolean r106 = Intrinsics.areEqual(r100.get(SoloKtvContext.SOLO_PAGE_FIRST), Boolean.TRUE);
        if (r106 == false) goto L8;
        r105 = r110.getTipsFirstShowAnimator();
    L8:
        r110.f395680d.getStageingIndex().setValue(Integer.valueOf(r101.getIndex()));
        r103.i("EnrollStageView", "animateToStage set stageingIndex " + r101.getIndex() + " firstShow=" + r106);
        final int r107 = 0;
    L9:
        if (r107 >= r102) goto L46;
        List r112 = (List) r104.get(Integer.valueOf(r107));
        if (r112 != null) goto L13;
        r112 = new ArrayList();
    L13:
        TeamMember.Companion.getClass();
        SpringAnimation r113 = new SpringAnimation(r101.Z5(TeamMember.a.a(r107)), DynamicAnimation.TRANSLATION_Y, r101.b6(TeamMember.a.a(r107)));
        TeamMember r114 = TeamMember.a.a(r107);
        Intrinsics.checkNotNullParameter(r114, "teamMember");
        float r115 = r101.f395692d.getFootGuideLine();
        if (r114 == TeamMember.TITLE) goto L30;
        Iterator r116 = ((ArrayList) r101.f395714z).iterator();
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
        r115 = (r115 + ((Number) mia.h.f514132d.getValue()).floatValue()) + (((Number) mia.h.f514134f.getValue()).floatValue() * ((TeamMember) r118.getFirst()).getOrder());
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
        SpringAnimation r119 = new SpringAnimation(r101.Z5(TeamMember.a.a(r107)), DynamicAnimation.ALPHA, 0.7f);
        r119.setStartValue(0.0f);
        r119.getSpring().setStiffness(120.0f);
        r119.getSpring().setDampingRatio(1.3f);
        if (r106 == false) goto L33;
        r119.addUpdateListener(new q(r101, r107));
        r119.addEndListener(new r(r107, r101));
    L33:
        r112.add(r119);
        SpringAnimation r120 = new SpringAnimation(r101.Z5(TeamMember.a.a(r107)), DynamicAnimation.SCALE_X, 1.0f);
        r120.setStartValue(0.6f);
        r120.getSpring().setStiffness(120.0f);
        r120.getSpring().setDampingRatio(0.8f);
        SpringAnimation r121 = new SpringAnimation(r101.Z5(TeamMember.a.a(r107)), DynamicAnimation.SCALE_Y, 1.0f);
        r121.setStartValue(0.6f);
        r121.getSpring().setStiffness(120.0f);
        r121.getSpring().setDampingRatio(0.8f);
        r112.add(r120);
        r112.add(r121);
        if (r107 != 0) goto L37;
        r113.addEndListener(new com.obric.audio.enroll.view.b(r110, r101));
    L37:
        if (r107 != 1) goto L41;
        r113.addEndListener(new c(r111));
    L41:
        if (r107 != (r102 - 1)) goto L44;
        r113.addEndListener(new d(r101, r210));
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
        Iterator r100 = ((ArrayList) this.f395678b).iterator();
    L3:
        qia.g r101 = null;
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
        r109.append(r105.f395694f);
        r109.append(" and team is ");
        qia.g r110 = r105.f395696h;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r110 = null;
    L20:
        r109.append(r110);
        r107.i("EnrollTeamView", r109.toString());
        qia.g r111 = r105.f395696h;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r111 = null;
    L23:
        r105.f395694f = r111.a();
        TextView r112 = r105.A;
        qia.g r113 = r105.f395696h;
        if (r113 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r113 = null;
    L26:
        String r114 = r113.f();
        if (r114 != null) goto L29;
        r114 = "";
    L29:
        r112.setText(r114);
        qia.g r115 = r105.f395696h;
        if (r115 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r115 = null;
    L32:
        String r116 = r115.c();
        if (r116 != null) goto L35;
        String r117 = "";
    L36:
        List r118 = StringsKt.split$default(r117, new String[]{"$"}, false, 0, 6, null);
        int r119 = r118.size();
        qia.g r120 = r105.f395696h;
        if (r120 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
    L41:
        if (r119 != r101.d()) goto L61;
        int r121 = r118.size();
        if (r121 == 1) goto L51;
        if (r121 != 2) goto L46;
        r105.B.setText((CharSequence) ListProtector.get(r118, 0));
        r105.C.setText((CharSequence) ListProtector.get(r118, 1));
    L52:
        r105.setState(TeamState.CANDIDATE);
        r105.setVisibility(0);
        ConstraintLayout.LayoutParams r122 = new ConstraintLayout.LayoutParams(-1, -1);
        r122.topToBottom = getParentID();
        r122.bottomToBottom = getParentID();
        r122.startToStart = getParentID();
        r122.endToEnd = getParentID();
        setBackgroundColor(0);
        r105.setLayoutParams(r122);
        r105.setBackgroundColor(getContext().getResources().getColor(R.color.bg_voice_enroll));
        r105.o6();
        if (r106 == null) goto L55;
        r106.requestLayout();
    L55:
        if (r108 == false) goto L58;
        r105.setAlpha(1.0f);
        EnrollTeamView.n6(r105, TeamMember.ALL, AnimationType.FADE_IN_TO_CANDIDATE, 1.0f);
        r105.setVisibility(0);
        r212.invoke();
        return;
    L58:
        ValueAnimator r123 = new ValueAnimator();
        r123.setIntValues(new int[]{0, 1});
        r123.setDuration(500);
        r123.addUpdateListener(new p(r105));
        r123.addListener(new b(r212, r105));
        r107.i("EnrollStageView", "start animator to candidate with tv " + r105);
        r123.start();
        return;
    L46:
        if (r121 != 3) goto L49;
        r105.B.setText((CharSequence) ListProtector.get(r118, 0));
        r105.C.setText((CharSequence) ListProtector.get(r118, 1));
        r105.D.setText((CharSequence) ListProtector.get(r118, 2));
        goto L52
    L49:
        throw new RuntimeException("invalid subtitleLines");
    L51:
        r105.B.setText((CharSequence) ListProtector.get(r118, 0));
        goto L52
    L61:
        throw new RuntimeException("invalid subtitleLines , not equal with $ ");
    L39:
        r101 = r120;
        goto L41
    L35:
        r117 = r116;
        goto L36
    L8:
        if (r103.getState() != TeamState.NA) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }
}
