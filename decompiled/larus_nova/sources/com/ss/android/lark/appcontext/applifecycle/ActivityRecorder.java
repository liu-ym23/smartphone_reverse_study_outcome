package com.ss.android.lark.appcontext.applifecycle;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class ActivityRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a<Activity>> f408773a;

    /* JADX INFO: loaded from: classes34.dex */
    public static final class a<T> extends WeakReference<T> implements Comparable<a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Lifecycle.Event f408774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f408775b;

        /* JADX INFO: renamed from: com.ss.android.lark.appcontext.applifecycle.ActivityRecorder$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4745a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f408776a = null;

            static {
                int[] r100 = new int[Lifecycle.Event.values().length];
                r100[Lifecycle.Event.ON_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[Lifecycle.Event.ON_RESUME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f408776a = r100;
            }
        }

        public final int hashCode() {
            return this.f408775b;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "other");
            Lifecycle.Event r102 = r101.f408774a;
            int[] r103 = C4745a.f408776a;
            int r104 = r103[r102.ordinal()];
            int r105 = 0;
            if (r104 == 1) goto L7;
            if (r104 == 2) goto L6;
            int r106 = 0;
        L8:
            int r107 = r103[this.f408774a.ordinal()];
            if (r107 == 1) goto L13;
            if (r107 != 2) goto L15;
            r105 = 2;
        L15:
            return r106 - r105;
        L13:
            r105 = 1;
            goto L15
        L6:
            r106 = 2;
            goto L8
        L7:
            r106 = 1;
            goto L8
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            return false;
        L5:
            if (this.f408775b != ((a) r100).f408775b) goto L9;
            return true;
        L9:
            return false;
        }

        public a(T r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r101, "state");
            super(r100);
            this.f408774a = r101;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            this.f408775b = r102;
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f408777a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f408777a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Activity a() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        c(new ActivityRecorder$getTopActivity$1(r100));
        return (Activity) r100.element;
    }

    public ActivityRecorder() {
        this.f408773a = new LinkedList();
    }

    public final void c(Function1<? super Activity, Boolean> r100) {
        LinkedList<a<Activity>> r101 = this.f408773a;
        monitor-enter(r101);
        Iterator<a<Activity>> r102 = this.f408773a.iterator();     // Catch: Throwable -> L17
    L6:
        if (r102.hasNext() == false) goto L14;
        Activity r103 = r102.next().get();     // Catch: Throwable -> L17
        if (r103 != null) goto L10;
        r102.remove();     // Catch: Throwable -> L17
        goto L6
    L10:
        if (r100.invoke(r103).booleanValue() == false) goto L6;
        monitor-exit(r101);
        return;
    L14:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r101);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static void b(LinkedList r100, a r101) {
        monitor-enter(r100);
        r100.remove(r101);     // Catch: Throwable -> L6
        monitor-exit(r100);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
