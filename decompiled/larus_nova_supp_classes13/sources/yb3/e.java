package yb3;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.track.TrackerProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(com.bytedance.android.ec.core.event.a r2, Context r3) {
        TrackerProvider.a r0 = TrackerProvider.Companion;
        if (r3 == null) goto L10;
        Activity r4 = d0.a.getActivity(r3);
        if ((r4 instanceof FragmentActivity) == true) goto L8;
        r4 = null;
    L8:
        FragmentActivity r5 = (FragmentActivity) r4;
        if (r5 == null) goto L10;
        Object r6 = ViewModelProviders.of(r5).get(TrackerProvider.class).getTracker();
        if ((r6 instanceof d) == true) goto L14;
        r6 = null;
    L14:
        d r7 = (d) r6;
    L15:
        if (r7 == null) goto L17;
        Intrinsics.checkNotNullParameter(r2, "event");
        r2.appendExtraParams(r7.a);
    L17:
        r2.post(null, null);
        return;
    L10:
        r7 = null;
        goto L15
    }
}
