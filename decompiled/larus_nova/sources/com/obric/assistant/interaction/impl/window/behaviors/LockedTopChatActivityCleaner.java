package com.obric.assistant.interaction.impl.window.behaviors;

import android.app.Activity;
import android.content.ComponentName;
import com.larus.bmhome.chat.j4;
import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.LockedHelperActivity;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.system.ITaskStackService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/LockedTopChatActivityCleaner;", "", "<init>", "()V", "TAG", "", "LOCKED_FINISH_DELAY_MS", "", "hasTopChatActivityMatchingSystemTop", "", "source", "removeIfNeeded", "", "delayFinishWhenDeviceLocked", "evaluateTopChatActivity", "Lcom/obric/assistant/interaction/impl/window/behaviors/LockedTopChatActivityCleaner$TopChatActivityEvaluation;", "isIgnoredActivity", "activity", "Landroid/app/Activity;", "TopChatActivityEvaluation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LockedTopChatActivityCleaner {
    public static final LockedTopChatActivityCleaner INSTANCE = null;
    private static final long LOCKED_FINISH_DELAY_MS = 2000;
    private static final String TAG = "LockedTopChatActivityCleaner";

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BQ\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003J_\u0010\u001f\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/LockedTopChatActivityCleaner$TopChatActivityEvaluation;", "", "activityList", "Ljava/util/ArrayList;", "Landroid/app/Activity;", "Lkotlin/collections/ArrayList;", "candidate", "candidateComponent", "Landroid/content/ComponentName;", "candidateRuntimeComponent", "topComponent", "skipReason", "", "<init>", "(Ljava/util/ArrayList;Landroid/app/Activity;Landroid/content/ComponentName;Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getActivityList", "()Ljava/util/ArrayList;", "getCandidate", "()Landroid/app/Activity;", "getCandidateComponent", "()Landroid/content/ComponentName;", "getCandidateRuntimeComponent", "getTopComponent", "getSkipReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TopChatActivityEvaluation {
        private final ArrayList<Activity> activityList;
        private final Activity candidate;
        private final ComponentName candidateComponent;
        private final ComponentName candidateRuntimeComponent;
        private final String skipReason;
        private final ComponentName topComponent;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TopChatActivityEvaluation copy$default(TopChatActivityEvaluation r100, ArrayList r101, Activity r102, ComponentName r103, ComponentName r104, ComponentName r105, String r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.activityList;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.candidate;
        L8:
            Activity r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.candidateComponent;
        L11:
            ComponentName r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.candidateRuntimeComponent;
        L14:
            ComponentName r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.topComponent;
        L17:
            ComponentName r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.skipReason;
        L20:
            ArrayList r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final ArrayList<Activity> component1() {
            return this.activityList;
        }

        public final Activity component2() {
            return this.candidate;
        }

        public final ComponentName component3() {
            return this.candidateComponent;
        }

        public final ComponentName component4() {
            return this.candidateRuntimeComponent;
        }

        public final ComponentName component5() {
            return this.topComponent;
        }

        public final String component6() {
            return this.skipReason;
        }

        public final TopChatActivityEvaluation copy(ArrayList<Activity> r100, Activity r110, ComponentName r111, ComponentName r112, ComponentName r113, String r114) {
            Intrinsics.checkNotNullParameter(r100, "activityList");
            return new TopChatActivityEvaluation(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TopChatActivityEvaluation) == true) goto L8;
            return false;
        L8:
            TopChatActivityEvaluation r101 = (TopChatActivityEvaluation) r100;
            if (Intrinsics.areEqual(this.activityList, r101.activityList) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.candidate, r101.candidate) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.candidateComponent, r101.candidateComponent) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.candidateRuntimeComponent, r101.candidateRuntimeComponent) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.topComponent, r101.topComponent) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.skipReason, r101.skipReason) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r100 = this.activityList.hashCode() * 31;
            Activity r101 = this.candidate;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            ComponentName r105 = this.candidateComponent;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            ComponentName r108 = this.candidateRuntimeComponent;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            ComponentName r111 = this.topComponent;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            String r114 = this.skipReason;
            if (r114 == null) goto L23;
            r102 = r114.hashCode();
        L23:
            return r113 + r102;
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "TopChatActivityEvaluation(activityList=" + this.activityList + ", candidate=" + this.candidate + ", candidateComponent=" + this.candidateComponent + ", candidateRuntimeComponent=" + this.candidateRuntimeComponent + ", topComponent=" + this.topComponent + ", skipReason=" + this.skipReason + ')';
        }

        public final ArrayList<Activity> getActivityList() {
            return this.activityList;
        }

        public final Activity getCandidate() {
            return this.candidate;
        }

        public final ComponentName getCandidateComponent() {
            return this.candidateComponent;
        }

        public final ComponentName getCandidateRuntimeComponent() {
            return this.candidateRuntimeComponent;
        }

        public final String getSkipReason() {
            return this.skipReason;
        }

        public final ComponentName getTopComponent() {
            return this.topComponent;
        }

        public TopChatActivityEvaluation(ArrayList<Activity> r100, Activity r101, ComponentName r102, ComponentName r103, ComponentName r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "activityList");
            this.activityList = r100;
            this.candidate = r101;
            this.candidateComponent = r102;
            this.candidateRuntimeComponent = r103;
            this.topComponent = r104;
            this.skipReason = r105;
        }
    }

    static {
        INSTANCE = new LockedTopChatActivityCleaner();
    }

    private LockedTopChatActivityCleaner() {
    }

    public static /* synthetic */ Result a(List r100, String r101) {
        return removeIfNeeded$lambda$4(r100, r101);
    }

    public static /* synthetic */ void b(Function0 r100) {
        removeIfNeeded$lambda$5(r100);
    }

    private final TopChatActivityEvaluation evaluateTopChatActivity() {
        gd9.i r100 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r100);
        ArrayList r101 = new ArrayList(r100.a().d());
        Iterator r102 = CollectionsKt.asReversedMutable(r101).iterator();
    L3:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        Activity r105 = (Activity) r104;
        LockedTopChatActivityCleaner r106 = INSTANCE;
        Intrinsics.checkNotNull(r105);
        if ((!r106.isIgnoredActivity(r105)) == false) goto L3;
    L9:
        Activity r107 = (Activity) r104;
        ITaskStackService r108 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        if (r108 == null) goto L12;
        ComponentName r109 = r108.e();
    L13:
        if (r107 == null) goto L15;
        ComponentName r110 = r107.getComponentName();
    L16:
        if (r107 != null) goto L18;
    L28:
        ComponentName r111 = null;
    L29:
        if (r107 != null) goto L31;
        String r112 = "candidate_null";
    L50:
        String r113 = r112;
    L53:
        return new TopChatActivityEvaluation(r101, r107, r110, r111, r109, r113);
    L31:
        if (r109 != null) goto L34;
        r112 = "top_component_null";
        goto L50
    L34:
        if (Intrinsics.areEqual(r110, r109) == true) goto L39;
        if (Intrinsics.areEqual(r111, r109) == true) goto L39;
        r112 = "candidate_not_top";
    L39:
        if (ObricChatContextServiceDelegate.f386558b.e(r107) == true) goto L42;
        r112 = "candidate_not_chat_activity";
        goto L50
    L42:
        if (r107.isFinishing() == false) goto L45;
        r112 = "candidate_finishing";
        goto L50
    L45:
        if (r107.isDestroyed() == false) goto L48;
        r112 = "candidate_destroyed";
        goto L50
    L48:
        if (r107.getTaskId() != 0) goto L51;
        r112 = "candidate_task_id_zero";
        goto L50
    L51:
        r113 = null;
        goto L53
    L18:
        if ((r107 instanceof j4) == true) goto L20;
    L22:
        r103 = false;
    L23:
        if (r103 == false) goto L25;
        Activity r114 = r107;
    L26:
        if (r114 == null) goto L28;
        r111 = new ComponentName(r114, r114.getClass());
        goto L29
    L25:
        r114 = null;
        goto L26
    L20:
        if (HomeService.f344094a.o() == false) goto L22;
    L15:
        r110 = null;
        goto L16
    L12:
        r109 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    private final boolean isIgnoredActivity(Activity r100) {
        if ((r100 instanceof ChatWindowActivity) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r100 instanceof LockedHelperActivity) == true) goto L8;
        return false;
    }

    private static final void removeIfNeeded$lambda$5(Function0 r100) {
        r100.invoke();
    }

    public final boolean hasTopChatActivityMatchingSystemTop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        TopChatActivityEvaluation r101 = evaluateTopChatActivity();
        if (r101.getSkipReason() != null) goto L5;
        boolean r102 = true;
    L6:
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("hasTopChatActivityMatchingSystemTop, source=");
        r104.append(r100);
        r104.append(", result=");
        r104.append(r102);
        r104.append(", reason=");
        r104.append(r101.getSkipReason());
        r104.append(", stackSize=");
        r104.append(r101.getActivityList().size());
        r104.append(", candidate=");
        r104.append(r101.getCandidateComponent());
        r104.append(", candidateRuntimeComponent=");
        r104.append(r101.getCandidateRuntimeComponent());
        r104.append(", candidateTaskId=");
        Activity r105 = r101.getCandidate();
        if (r105 == null) goto L9;
        Integer r106 = Integer.valueOf(r105.getTaskId());
    L10:
        r104.append(r106);
        r104.append(", top=");
        r104.append(r101.getTopComponent());
        r103.i(TAG, r104.toString());
        return r102;
    L9:
        r106 = null;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    private static final Result removeIfNeeded$lambda$4(List r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Iterator r103 = r100.iterator();     // Catch: Throwable -> L8
    L4:
        if (r103.hasNext() == false) goto L6;
        ((Activity) r103.next()).finish();     // Catch: Throwable -> L8
        goto L4
    L6:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (Result.m9456isSuccessimpl(r104) == false) goto L13;
        Unit r105 = (Unit) r104;
        FLogger.f375446a.i(TAG, "finish success, source=" + r101 + ", finishCount=" + r100.size());
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r104);
        if (r106 == null) goto L17;
        FLogger.f375446a.e(TAG, "finish failed, source=" + r101 + ", finishCount=" + r100.size(), r106);
    L17:
        return Result.m9448boximpl(r104);
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.interaction.impl.window.behaviors.n] */
    public final void removeIfNeeded(final String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "source");
        TopChatActivityEvaluation r100 = evaluateTopChatActivity();
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("removeIfNeeded, source=");
        r102.append(r110);
        r102.append(", stackSize=");
        r102.append(r100.getActivityList().size());
        r102.append(", candidate=");
        r102.append(r100.getCandidateComponent());
        r102.append(", candidateRuntimeComponent=");
        r102.append(r100.getCandidateRuntimeComponent());
        r102.append(", candidateTaskId=");
        Activity r103 = r100.getCandidate();
        Integer r104 = null;
        if (r103 == null) goto L5;
        Integer r105 = Integer.valueOf(r103.getTaskId());
    L6:
        r102.append(r105);
        r102.append(", top=");
        r102.append(r100.getTopComponent());
        r102.append(", delayFinishWhenDeviceLocked=");
        r102.append(r111);
        r101.i(TAG, r102.toString());
        if (r100.getSkipReason() == null) goto L17;
        StringBuilder r112 = new StringBuilder("skip remove, source=");
        r112.append(r110);
        r112.append(", reason=");
        r112.append(r100.getSkipReason());
        r112.append(", candidate=");
        Activity r113 = r100.getCandidate();
        if (r113 == null) goto L11;
        String r114 = r113.getClass().getName();
    L12:
        r112.append(r114);
        r112.append(", candidateComponent=");
        r112.append(r100.getCandidateComponent());
        r112.append(", candidateRuntimeComponent=");
        r112.append(r100.getCandidateRuntimeComponent());
        r112.append(", candidateTaskId=");
        Activity r115 = r100.getCandidate();
        if (r115 == null) goto L15;
        r104 = Integer.valueOf(r115.getTaskId());
    L15:
        r112.append(r104);
        r112.append(", top=");
        r112.append(r100.getTopComponent());
        r101.i(TAG, r112.toString());
        return;
    L11:
        r114 = null;
        goto L12
    L17:
        ArrayList<Activity> r106 = r100.getActivityList();
        final ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L19:
        if (r108.hasNext() == false) goto L23;
        Object r109 = r108.next();
        if (isIgnoredActivity((Activity) r109) == true) goto L19;
        r107.add(r109);
        goto L19
    L23:
        final ?? r116 = new n(r107, r110);
        if (r111 == true) goto L26;
    L28:
        r116.invoke();
        return;
    L26:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L28;
        FLogger.f375446a.i(TAG, "delay finish, source=" + r110 + ", finishCount=" + r107.size() + ", delayMs=2000");
        t0.d(new o(r116), 2000);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
