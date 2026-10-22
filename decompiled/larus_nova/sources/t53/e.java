package t53;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.track.TrackerProvider;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {
    public static final void a(com.bytedance.android.ec.core.event.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$buildWithBase");
        TrackerProvider.a r102 = TrackerProvider.Companion;
        if (r101 == null) goto L10;
        Activity r103 = d0.f165305a.getActivity(r101);
        if ((r103 instanceof FragmentActivity) == true) goto L8;
        r103 = null;
    L8:
        FragmentActivity r104 = (FragmentActivity) r103;
        if (r104 == null) goto L10;
        Object r105 = ((TrackerProvider) ViewModelProviders.of(r104).get(TrackerProvider.class)).getTracker();
        if ((r105 instanceof a) == true) goto L14;
        r105 = null;
    L14:
        a r106 = (a) r105;
    L15:
        if (r106 == null) goto L18;
        int r107 = a.f544620b;
        r106.a(r100, null);
        return;
    L18:
        return;
    L10:
        r106 = null;
        goto L15
    }

    public static final void b(com.bytedance.android.ec.core.event.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$buildWithBaseParams");
        TrackerProvider.a r102 = TrackerProvider.Companion;
        a r103 = null;
        Object r104 = null;
        r103 = null;
        if (r101 == null) goto L16;
        Activity r105 = d0.f165305a.getActivity(r101);
        if ((r105 instanceof FragmentActivity) == true) goto L8;
        r105 = null;
    L8:
        FragmentActivity r106 = (FragmentActivity) r105;
        if (r106 == null) goto L16;
        Object r107 = ((TrackerProvider) ViewModelProviders.of(r106).get(TrackerProvider.class)).getTracker();
        if ((r107 instanceof a) == false) goto L15;
        r104 = r107;
    L15:
        r103 = (a) r104;
    L16:
        if (r103 == null) goto L19;
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.appendBaseParams(r103.f544621a);
        return;
    }

    public static final void c(com.bytedance.android.ec.core.event.a r100, Context r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$postWithBase");
        TrackerProvider.a r103 = TrackerProvider.Companion;
        if (r101 == null) goto L10;
        Activity r104 = d0.f165305a.getActivity(r101);
        if ((r104 instanceof FragmentActivity) == true) goto L8;
        r104 = null;
    L8:
        FragmentActivity r105 = (FragmentActivity) r104;
        if (r105 == null) goto L10;
        Object r106 = ((TrackerProvider) ViewModelProviders.of(r105).get(TrackerProvider.class)).getTracker();
        if ((r106 instanceof a) == true) goto L14;
        r106 = null;
    L14:
        a r107 = (a) r106;
    L15:
        if (r107 == null) goto L17;
        r107.a(r100, r102);
    L17:
        r100.post(null, null);
        return;
    L10:
        r107 = null;
        goto L15
    }
}
