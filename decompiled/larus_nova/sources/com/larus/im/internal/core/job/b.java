package com.larus.im.internal.core.job;

import com.larus.im.bean.job.AIJobRequestState;
import com.larus.im.bean.job.AIJobRequestStatus;
import com.larus.im.bean.job.AIJobRequestType;
import com.larus.im.internal.jni.observer.OmniAIJobDispatcherKt;
import com.larus.im.internal.jni.observer.OmniAIJobObserver;
import com.larus.im.service.AIJobObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<AIJobObserver> f347659a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f347660b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<AIJobObserver, Long> f347661c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f347662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f347663e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AIJobRequestState f347664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static AIJobRequestState f347665g;

    public static final class a implements OmniAIJobObserver {
        public a() {
        }

        @Override // com.larus.im.internal.jni.observer.OmniAIJobObserver
        public final void onJobsChanged(List<String> r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "changedIds");
            Intrinsics.checkNotNullParameter(r101, "deletedIds");
            CopyOnWriteArrayList<AIJobObserver> r102 = b.f347659a;
            List r103 = CollectionsKt.plus(r100, r101);
            ArrayList r104 = new ArrayList();
            Iterator r105 = r103.iterator();
        L4:
            if (r105.hasNext() == false) goto L11;
            Object r106 = r105.next();
            if (((String) r106).length() <= 0) goto L8;
            boolean r107 = true;
        L9:
            if (r107 == false) goto L4;
            r104.add(r106);
            goto L4
        L8:
            r107 = false;
            goto L9
        L11:
            List r108 = CollectionsKt.distinct(r104);
            if (r108.isEmpty() == true) goto L21;
            com.larus.im.internal.database.utils.e.d(new AIJobDispatcher$notifyJobsChanged$1(r108, null));
            return;
        }

        @Override // com.larus.im.internal.jni.observer.OmniAIJobObserver
        public final void onRequestStateChanged(int r100, int r110, int r111, String r112) {
            Intrinsics.checkNotNullParameter(r112, "errorMessage");
            AIJobRequestType.Companion.getClass();
            AIJobRequestType[] r101 = AIJobRequestType.values();
            int r102 = r101.length;
            boolean r103 = false;
            int r104 = 0;
        L4:
            if (r104 >= r102) goto L12;
            AIJobRequestType r105 = r101[r104];
            if (r105.getValue() != r100) goto L8;
            boolean r106 = true;
        L9:
            if (r106 == true) goto L13;
            r104 = r104 + 1;
        L13:
            if (r105 != null) goto L15;
            return;
        L15:
            AIJobRequestStatus.Companion.getClass();
            AIJobRequestStatus[] r107 = AIJobRequestStatus.values();
            int r108 = r107.length;
            int r109 = 0;
        L16:
            if (r109 >= r108) goto L24;
            AIJobRequestStatus r113 = r107[r109];
            if (r113.getValue() != r110) goto L20;
            boolean r114 = true;
        L21:
            if (r114 == true) goto L25;
            r109 = r109 + 1;
        L25:
            if (r113 != null) goto L27;
            return;
        L27:
            CopyOnWriteArrayList<AIJobObserver> r115 = b.f347659a;
            if (r112.length() <= 0) goto L30;
            r103 = true;
        L30:
            if (r103 == true) goto L33;
            r112 = null;
        L33:
            AIJobRequestState r116 = new AIJobRequestState(r105, r113, r111, r112);
            Object r117 = b.f347663e;
            monitor-enter(r117);
            int r118 = C4346b.f347666a[r116.getRequestType().ordinal()];     // Catch: Throwable -> L47
            if (r118 != 1) goto L38;
            b.f347664f = r116;     // Catch: Throwable -> L47
        L43:
            Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L47
            monitor-exit(r117);
            com.larus.im.internal.database.utils.e.d(new AIJobDispatcher$notifyRequestStates$1(CollectionsKt.listOf(r116), null));
            return;
        L38:
            if (r118 != 2) goto L41;
            b.f347665g = r116;     // Catch: Throwable -> L47
            goto L43
        L41:
            throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            throw th;
        L20:
            r114 = false;
            goto L21
        L24:
            r113 = null;
            goto L25
        L8:
            r106 = false;
            goto L9
        L12:
            r105 = null;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.job.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes29.dex */
    public /* synthetic */ class C4346b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f347666a = null;

        static {
            int[] r100 = new int[AIJobRequestType.values().length];
            r100[AIJobRequestType.JOB_CHAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AIJobRequestType.RECOMMEND_JOB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f347666a = r100;
        }
    }

    static {
        f347659a = new CopyOnWriteArrayList();
        f347660b = new Object();
        f347661c = new LinkedHashMap();
        f347663e = new Object();
        f347664f = b(AIJobRequestType.JOB_CHAIN);
        f347665g = b(AIJobRequestType.RECOMMEND_JOB);
        OmniAIJobDispatcherKt.GetOmniAIJobDispatcher().registerGlobal(new a());
    }

    public static List a() {
        Object r100 = f347663e;
        monitor-enter(r100);
        List r101 = CollectionsKt.listOf(new AIJobRequestState[]{f347664f, f347665g});     // Catch: Throwable -> L8
        monitor-exit(r100);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    public static void c() {
        Object r100 = f347663e;
        monitor-enter(r100);
        f347664f = b(AIJobRequestType.JOB_CHAIN);     // Catch: Throwable -> L8
        AIJobRequestState r101 = b(AIJobRequestType.RECOMMEND_JOB);     // Catch: Throwable -> L8
        f347665g = r101;     // Catch: Throwable -> L8
        List r102 = CollectionsKt.listOf(new AIJobRequestState[]{f347664f, r101});     // Catch: Throwable -> L8
        monitor-exit(r100);
        com.larus.im.internal.database.utils.e.d(new AIJobDispatcher$notifyRequestStates$1(r102, null));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static AIJobRequestState b(AIJobRequestType r100) {
        return new AIJobRequestState(r100, AIJobRequestStatus.IDLE, 0, null, 12, null);
    }
}
