package com.bytedance.android.shopping.feed.event;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.shopping.track.TrackerProvider;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final void b(com.bytedance.android.ec.core.event.a r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$buildWithBaseParams");
        TrackerProvider.a r0 = TrackerProvider.Companion;
        o1 r1 = null;
        Object r4 = null;
        r1 = null;
        if (r3 == null) goto L16;
        Activity r5 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(r3);
        if ((r5 instanceof FragmentActivity) == true) goto L8;
        r5 = null;
    L8:
        FragmentActivity r6 = (FragmentActivity) r5;
        if (r6 == null) goto L16;
        Object r7 = ViewModelProviders.of(r6).get(TrackerProvider.class).getTracker();
        if ((r7 instanceof o1) == false) goto L15;
        r4 = r7;
    L15:
        r1 = (o1) r4;
    L16:
        if (r1 == null) goto L19;
        Intrinsics.checkNotNullParameter(r2, "event");
        r2.appendBaseParams(r1.a);
        return;
    }

    public static final void d(com.bytedance.android.ec.core.event.a r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$postWithBaseParams");
        TrackerProvider.a r0 = TrackerProvider.Companion;
        if (r3 == null) goto L10;
        Activity r4 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(r3);
        if ((r4 instanceof FragmentActivity) == true) goto L8;
        r4 = null;
    L8:
        FragmentActivity r5 = (FragmentActivity) r4;
        if (r5 == null) goto L10;
        Object r6 = ViewModelProviders.of(r5).get(TrackerProvider.class).getTracker();
        if ((r6 instanceof o1) == true) goto L14;
        r6 = null;
    L14:
        o1 r7 = (o1) r6;
    L15:
        if (r7 == null) goto L17;
        Intrinsics.checkNotNullParameter(r2, "event");
        r2.appendBaseParams(r7.a);
    L17:
        r2.post(null, null);
        return;
    L10:
        r7 = null;
        goto L15
    }

    public static final void a(com.bytedance.android.ec.core.event.a r2, Context r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$buildWithBase");
        TrackerProvider.a r0 = TrackerProvider.Companion;
        o1 r1 = null;
        Object r5 = null;
        r1 = null;
        if (r3 == null) goto L16;
        Activity r6 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(r3);
        if ((r6 instanceof FragmentActivity) == true) goto L8;
        r6 = null;
    L8:
        FragmentActivity r7 = (FragmentActivity) r6;
        if (r7 == null) goto L16;
        Object r8 = ViewModelProviders.of(r7).get(TrackerProvider.class).getTracker();
        if ((r8 instanceof o1) == false) goto L15;
        r5 = r8;
    L15:
        r1 = (o1) r5;
    L16:
        if (r1 == null) goto L19;
        r1.a(r2, r4);
        return;
    }

    public static final void c(com.bytedance.android.ec.core.event.a r2, Context r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$postWithBase");
        TrackerProvider.a r0 = TrackerProvider.Companion;
        if (r3 == null) goto L10;
        Activity r5 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(r3);
        if ((r5 instanceof FragmentActivity) == true) goto L8;
        r5 = null;
    L8:
        FragmentActivity r6 = (FragmentActivity) r5;
        if (r6 == null) goto L10;
        Object r7 = ViewModelProviders.of(r6).get(TrackerProvider.class).getTracker();
        if ((r7 instanceof o1) == true) goto L14;
        r7 = null;
    L14:
        o1 r8 = (o1) r7;
    L15:
        if (r8 == null) goto L17;
        r8.a(r2, r4);
    L17:
        r2.post(null, null);
        return;
    L10:
        r8 = null;
        goto L15
    }
}
