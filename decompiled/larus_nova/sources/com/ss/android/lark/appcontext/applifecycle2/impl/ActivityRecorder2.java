package com.ss.android.lark.appcontext.applifecycle2.impl;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public final class ActivityRecorder2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a<Activity>> f408876a;

    public static final class a<T> extends WeakReference<T> implements Comparable<a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Lifecycle.Event f408877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f408878b;

        /* JADX INFO: renamed from: com.ss.android.lark.appcontext.applifecycle2.impl.ActivityRecorder2$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4746a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f408879a = null;

            static {
                int[] r100 = new int[Lifecycle.Event.values().length];
                r100[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[Lifecycle.Event.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[Lifecycle.Event.ON_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[Lifecycle.Event.ON_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f408879a = r100;
            }
        }

        public final int hashCode() {
            return this.f408878b;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "other");
            Lifecycle.Event r102 = r101.f408877a;
            int[] r103 = C4746a.f408879a;
            int r104 = r103[r102.ordinal()];
            int r105 = 0;
            if (r104 == 1) goto L13;
            if (r104 == 2) goto L12;
            if (r104 == 3) goto L11;
            if (r104 == 4) goto L10;
            if (r104 == 5) goto L9;
            int r106 = 0;
        L14:
            int r107 = r103[this.f408877a.ordinal()];
            if (r107 == 1) goto L25;
            if (r107 == 2) goto L24;
            if (r107 == 3) goto L23;
            if (r107 == 4) goto L22;
            if (r107 != 5) goto L27;
            r105 = 5;
        L27:
            return r106 - r105;
        L22:
            r105 = 4;
            goto L27
        L23:
            r105 = 3;
            goto L27
        L24:
            r105 = 2;
            goto L27
        L25:
            r105 = 1;
            goto L27
        L9:
            r106 = 5;
            goto L14
        L10:
            r106 = 4;
            goto L14
        L11:
            r106 = 3;
            goto L14
        L12:
            r106 = 2;
            goto L14
        L13:
            r106 = 1;
            goto L14
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            return false;
        L5:
            if (this.f408878b != ((a) r100).f408878b) goto L9;
            return true;
        L9:
            return false;
        }

        public a(T r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r101, "state");
            super(r100);
            this.f408877a = r101;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            this.f408878b = r102;
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f408880a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[Lifecycle.Event.ON_RESUME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[Lifecycle.Event.ON_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f408880a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.appcontext.applifecycle2.impl.ActivityRecorder2$getActivity$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/app/Activity;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/app/Activity;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function1<Activity, Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return Boolean.TRUE;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Activity r100) {
            return invoke2(r100);
        }
    }

    public ActivityRecorder2() {
        this.f408876a = new LinkedList();
    }

    public final void b(Function1<? super a<Activity>, Boolean> r100) {
        LinkedList<a<Activity>> r101 = this.f408876a;
        monitor-enter(r101);
        Iterator<a<Activity>> r102 = this.f408876a.iterator();     // Catch: Throwable -> L17
    L6:
        if (r102.hasNext() == false) goto L14;
        a<Activity> r103 = r102.next();     // Catch: Throwable -> L17
        if (r103.get() != null) goto L10;
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

    /* JADX WARN: Multi-variable type inference failed */
    public final Activity getActivity(final Function1<? super Activity, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "accept");
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        b(new AnonymousClass2(r101, r100));
        return (Activity) r101.element;
    }

    public final void a(Activity r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "event");
        LinkedList<a<Activity>> r102 = this.f408876a;
        monitor-enter(r102);
        a<Activity> r103 = new a(r100, r101);     // Catch: Throwable -> L28
        switch(b.f408880a[r103.f408877a.ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L27;
        };     // Catch: Throwable -> L28
    L7:
        r102.remove(r103);     // Catch: Throwable -> L28
    L23:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r102);
        return;
    L8:
        Iterator<T> r105 = r102.iterator();     // Catch: Throwable -> L28
    L10:
        if (r105.hasNext() == false) goto L17;
        Object r106 = r105.next();     // Catch: Throwable -> L28
        if (((a) r106).f408878b != r103.f408878b) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L10;
    L18:
        a r108 = (a) r106;     // Catch: Throwable -> L28
        if (r108 == null) goto L23;
        Lifecycle.Event r109 = r103.f408877a;     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r109, "<set-?>");     // Catch: Throwable -> L28
        r108.f408877a = r109;     // Catch: Throwable -> L28
        CollectionsKt.sort(r102);     // Catch: Throwable -> L28
        goto L23
    L14:
        r107 = false;
        goto L15
    L17:
        r106 = null;
        goto L18
    L21:
        r102.remove(r103);     // Catch: Throwable -> L28
        r102.addFirst(r103);     // Catch: Throwable -> L28
        goto L23
    L22:
        r102.addLast(r103);     // Catch: Throwable -> L28
        goto L23
    L27:
        throw new IllegalArgumentException("state is error:" + r103.f408877a);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }
}
