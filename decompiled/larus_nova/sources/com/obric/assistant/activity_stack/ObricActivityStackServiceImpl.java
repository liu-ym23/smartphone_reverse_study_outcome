package com.obric.assistant.activity_stack;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.p;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0013\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J/\u0010\u0017\u001a\u0004\u0018\u0001H\u0019\"\b\b\u0000\u0010\u0019*\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u001cJ&\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u001fH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\nH\u0002J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006'"}, d2 = {"Lcom/obric/assistant/activity_stack/ObricActivityStackServiceImpl;", "Lcom/obric/assistant/activity_stack/IObricActivityStackService;", "<init>", "()V", "isInitialized", "", "initLock", "", "activityStartTime", "", "Landroid/app/Activity;", "", "startedActivities", "", "lastStartedActivity", "Ljava/lang/ref/WeakReference;", "init", "", "activityLifecycleCallbacks", "com/obric/assistant/activity_stack/ObricActivityStackServiceImpl$activityLifecycleCallbacks$1", "Lcom/obric/assistant/activity_stack/ObricActivityStackServiceImpl$activityLifecycleCallbacks$1;", "getActivityList", "", "getLastStartedActivity", "requireStarted", ExifInterface.GPS_DIRECTION_TRUE, "activityClass", "Ljava/lang/Class;", "(Ljava/lang/Class;Z)Landroid/app/Activity;", "findLastStartedActivity", "matcher", "Lkotlin/Function1;", "getLastStartedDefaultChatActivity", "isActivityStarted", "activity", "sortActivitiesByStartTime", "activityList", "getActivityListSortByStartTime", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActivityStackServiceImpl implements IObricActivityStackService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f385572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f385573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Activity, Long> f385574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Activity> f385575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<Activity> f385576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f385577f;

    public static final class a {
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricActivityStackServiceImpl f385578a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        public b(ObricActivityStackServiceImpl r100) {
            this.f385578a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ObricActivityStackServiceImpl r101 = this.f385578a;
            Map<Activity, Long> r102 = r101.f385574c;
            monitor-enter(r102);
            r101.f385574c.remove(r100);     // Catch: Throwable -> L13
            r101.f385575d.remove(r100);     // Catch: Throwable -> L13
            WeakReference<Activity> r103 = r101.f385576e;     // Catch: Throwable -> L13
            if (r103 == null) goto L7;
            Activity r104 = r103.get();     // Catch: Throwable -> L13
        L8:
            if (r104 != r100) goto L10;
            r101.f385576e = null;     // Catch: Throwable -> L13
        L10:
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(r102);
            return;
        L7:
            r104 = null;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ObricActivityStackServiceImpl r101 = this.f385578a;
            Map<Activity, Long> r102 = r101.f385574c;
            monitor-enter(r102);
            r101.f385574c.put(r100, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L7
            r101.f385575d.add(r100);     // Catch: Throwable -> L7
            r101.f385576e = new WeakReference(r100);     // Catch: Throwable -> L7
            FLogger.f375446a.i("ObricActivityStackServiceImpl", "onActivityStarted: " + r100);     // Catch: Throwable -> L7
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r102);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ObricActivityStackServiceImpl r101 = this.f385578a;
            Map<Activity, Long> r102 = r101.f385574c;
            monitor-enter(r102);
            r101.f385575d.remove(r100);     // Catch: Throwable -> L7
            monitor-exit(r102);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f385579a;

        public c(Map r100) {
            this.f385579a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Long r102 = (Long) this.f385579a.get((Activity) r100);
            long r103 = 0;
            if (r102 == null) goto L5;
            long r104 = r102.longValue();
        L6:
            Long r105 = Long.valueOf(r104);
            Long r106 = (Long) this.f385579a.get((Activity) r101);
            if (r106 == null) goto L10;
            r103 = r106.longValue();
        L10:
            return ComparisonsKt.compareValues(r105, Long.valueOf(r103));
        L5:
            r104 = 0;
            goto L6
        }
    }

    static {
    }

    @Override // com.obric.assistant.activity_stack.IObricActivityStackService
    public final List<Activity> b() {
        return e(AppHost.f326268a.a().g());
    }

    @Override // com.obric.assistant.activity_stack.IObricActivityStackService
    public final void init() {
        if (this.f385572a == false) goto L5;
        return;
    L5:
        Object r100 = this.f385573b;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.f385572a == false) goto L11;
        monitor-exit(r100);
        return;
    L11:
        AppHost.f326268a.getApplication().registerActivityLifecycleCallbacks(this.f385577f);     // Catch: Throwable -> L14
        this.f385572a = true;     // Catch: Throwable -> L14
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
    }

    public ObricActivityStackServiceImpl() {
        this.f385573b = new Object();
        this.f385574c = Collections.synchronizedMap(new WeakHashMap());
        this.f385575d = Collections.newSetFromMap(new WeakHashMap());
        this.f385577f = new b(this);
    }

    @Override // com.obric.assistant.activity_stack.IObricActivityStackService
    public final Activity c() {
        List<Activity> r100 = b();
        ListIterator<Activity> r101 = r100.listIterator(r100.size());
    L4:
        if (r101.hasPrevious() == false) goto L17;
        Activity r102 = r101.previous();
        Activity r103 = r102;
        if (p.e(r103) == true) goto L8;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L4;
    L19:
        return r102;
    L8:
        if (d(r103) == false) goto L14;
        if (r103.isFinishing() == true) goto L14;
        if (r103.isDestroyed() == true) goto L14;
        r104 = true;
        goto L15
    L17:
        r102 = null;
        goto L19
    }

    @Override // com.obric.assistant.activity_stack.IObricActivityStackService
    public final Activity a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "activityClass");
        List<Activity> r101 = AppHost.f326268a.a().g();
        Map<Activity, Long> r102 = this.f385574c;
        monitor-enter(r102);
        WeakReference<Activity> r103 = this.f385576e;     // Catch: Throwable -> L58
        if (r103 == null) goto L22;
        Activity r104 = r103.get();     // Catch: Throwable -> L58
        if (r104 == null) goto L22;
        if (this.f385574c.containsKey(r104) == false) goto L19;
        Intrinsics.checkNotNullParameter(r104, "activity");     // Catch: Throwable -> L58
        if (Boolean.valueOf(r100.isInstance(r104)).booleanValue() == false) goto L19;
        if (this.f385575d.contains(r104) == false) goto L19;
        if (r104.isFinishing() == true) goto L19;
        if (r104.isDestroyed() == true) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L22;
    L23:
        monitor-exit(r102);
        if (r104 == null) goto L38;
        ListIterator<Activity> r106 = r101.listIterator(r101.size());
    L27:
        if (r106.hasPrevious() == false) goto L34;
        Object r107 = r106.previous();
        if (((Activity) r107) != r104) goto L31;
        boolean r108 = true;
    L32:
        if (r108 == false) goto L27;
    L35:
        Object r109 = (Activity) r107;
        if (r109 == null) goto L38;
    L55:
        if (r109 != null) goto L57;
        return null;
    L57:
        return (Activity) r100.cast(r109);
    L31:
        r108 = false;
        goto L32
    L34:
        r107 = null;
    L38:
        List<Activity> r110 = e(r101);
        ListIterator<Activity> r111 = r110.listIterator(r110.size());
    L40:
        if (r111.hasPrevious() == false) goto L53;
        Object r112 = r111.previous();
        Activity r113 = (Activity) r112;
        Intrinsics.checkNotNullParameter(r113, "activity");
        if (Boolean.valueOf(r100.isInstance(r113)).booleanValue() == true) goto L44;
    L50:
        boolean r114 = false;
    L51:
        if (r114 == false) goto L40;
    L54:
        r109 = (Activity) r112;
        goto L55
    L44:
        if (d(r113) == false) goto L50;
        if (r113.isFinishing() == true) goto L50;
        if (r113.isDestroyed() == true) goto L50;
        r114 = true;
        goto L51
    L53:
        r112 = null;
    L19:
        r105 = false;
    L22:
        r104 = null;
    L58:
        th = move-exception;
        throw th;
    }

    public final boolean d(Activity r100) {
        Map<Activity, Long> r101 = this.f385574c;
        monitor-enter(r101);
        boolean r102 = this.f385575d.contains(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<Activity> e(List<? extends Activity> r100) {
        Intrinsics.checkNotNullParameter(r100, "activityList");
        Map<Activity, Long> r101 = this.f385574c;
        monitor-enter(r101);
        List<? extends Activity> r102 = r100;     // Catch: Throwable -> L16
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));     // Catch: Throwable -> L16
        Iterator<T> r104 = r102.iterator();     // Catch: Throwable -> L16
    L5:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();     // Catch: Throwable -> L16
        Map<Activity, Long> r106 = this.f385574c;     // Catch: Throwable -> L16
        Long r107 = r106.get((Activity) r105);     // Catch: Throwable -> L16
        if (r107 == null) goto L10;
        long r108 = r107.longValue();     // Catch: Throwable -> L16
    L11:
        r103.put(r105, Long.valueOf(r108));     // Catch: Throwable -> L16
        goto L5
    L10:
        r108 = 0;
        goto L11
    L13:
        monitor-exit(r101);
        return CollectionsKt.sortedWith(r100, new c(r103));
    L16:
        th = move-exception;
        throw th;
    }
}
