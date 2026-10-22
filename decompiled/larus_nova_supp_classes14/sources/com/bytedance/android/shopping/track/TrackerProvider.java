package com.bytedance.android.shopping.track;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/track/TrackerProvider;", "Landroidx/lifecycle/ViewModel;", "", "tracker", "Ljava/lang/Object;", "getTracker", "()Ljava/lang/Object;", "setTracker", "(Ljava/lang/Object;)V", "<init>", "()V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrackerProvider extends ViewModel {
    public static final a Companion = null;
    private Object tracker;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(Context r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            FragmentActivity r3 = d0.a.getActivity(r1);
            if (r3 == null) goto L7;
            ((TrackerProvider) ViewModelProviders.of(r3).get(TrackerProvider.class)).setTracker(r2);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final <T> void setTracker(Context r1, T r2) {
        Companion.getClass();
        a.a(r1, r2);
    }

    public TrackerProvider() {
    }

    public final Object getTracker() {
        return this.tracker;
    }

    @JvmStatic
    public static final /* synthetic */ <T> T getTracker(Context r2) {
        Companion.getClass();
        if (r2 == null) goto L13;
        Activity r3 = d0.a.getActivity(r2);
        if ((r3 instanceof FragmentActivity) == true) goto L8;
        r3 = null;
    L8:
        FragmentActivity r4 = (FragmentActivity) r3;
        if (r4 == null) goto L14;
        T r0 = (T) ((TrackerProvider) ViewModelProviders.of(r4).get(TrackerProvider.class)).getTracker();
        Intrinsics.reifiedOperationMarker(2, "T");
        return r0;
    L14:
        return null;
    L13:
        return null;
    }

    public final void setTracker(Object r1) {
        this.tracker = r1;
    }
}
