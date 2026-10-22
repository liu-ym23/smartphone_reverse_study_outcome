package com.ss.android.lark.insets;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes36.dex */
public final class AndroidQInsetsDispatchCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f427705a = 0;

    public static final class a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f427706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f427707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Space f427708c;

        public a(Function0<Unit> r100, ViewGroup r101, Space r102) {
            this.f427706a = r100;
            this.f427707b = r101;
            this.f427708c = r102;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, "<unused var>");
            Intrinsics.checkNotNullParameter(r101, "insets");
            this.f427706a.invoke();
            Sequence<View> r102 = ViewGroupKt.getChildren(this.f427707b);
            Space r103 = this.f427708c;
            Iterator<View> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L9;
            View r105 = r104.next();
            if (Intrinsics.areEqual(r105, r103) == true) goto L4;
            r105.dispatchApplyWindowInsets(r101.toWindowInsets());
            goto L4
        L9:
            return WindowInsetsCompat.CONSUMED;
        }
    }

    static {
        f427705a = View.generateViewId();
    }

    @JvmStatic
    public static final synchronized void a(final ViewGroup r100) {
        monitor-enter(AndroidQInsetsDispatchCompat.class);
        Intrinsics.checkNotNullParameter(r100, "viewGroup");     // Catch: Throwable -> L17
        if (Build.VERSION.SDK_INT <= 29) goto L10;
        monitor-exit(AndroidQInsetsDispatchCompat.class);
        return;
    L10:
        if (r100.getId() == 16908290) goto L14;
        b(r100, AndroidQInsetsDispatchCompat$resolveInner$1.INSTANCE);     // Catch: Throwable -> L17
        monitor-exit(AndroidQInsetsDispatchCompat.class);
        return;
    L14:
        b(r100, new AndroidQInsetsDispatchCompat$resolve$1(r100));     // Catch: Throwable -> L17
        monitor-exit(AndroidQInsetsDispatchCompat.class);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void b(ViewGroup r100, Function0<Unit> r101) {
        monitor-enter(AndroidQInsetsDispatchCompat.class);
        Intrinsics.checkNotNullParameter(r100, "viewGroup");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r101, "onDispatchWindowInset");     // Catch: Throwable -> L11
        int r102 = f427705a;     // Catch: Throwable -> L11
        if (((Space) r100.findViewById(r102)) == null) goto L8;
        monitor-exit(AndroidQInsetsDispatchCompat.class);
        return;
    L8:
        Space r103 = new Space(r100.getContext());     // Catch: Throwable -> L11
        r103.setId(r102);     // Catch: Throwable -> L11
        ViewCompat.setOnApplyWindowInsetsListener(r103, new a(r101, r100, r103));     // Catch: Throwable -> L11
        r100.addView(r103, 0);     // Catch: Throwable -> L11
        monitor-exit(AndroidQInsetsDispatchCompat.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
