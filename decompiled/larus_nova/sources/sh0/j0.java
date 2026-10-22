package sh0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i0 f541918a;

    static {
    }

    public static i0 a(DataCenter r100) {
        if (r100 != null) goto L6;
        return f541918a;
    L6:
        return (i0) r100.get("data_multi_link_talkroom_store");
    }

    public static void b(DataCenter r100) {
        f541918a = null;
        i0 r101 = a(r100);
        if (r101 == null) goto L5;
        r101.onDestory();
    L5:
        if (r100 == null) goto L8;
        r100.put("data_multi_link_talkroom_store", null);
        return;
    }

    @JvmStatic
    public static final i0 e(DataCenter r100) {
        return a(r100);
    }

    public static i0 c(DataCenter r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        i0 r102 = a(r100);
        if (r102 != null) goto L7;
        r102 = new i0(r101);
        if (r100 == null) goto L7;
        r100.put("data_multi_link_talkroom_store", r102);
    L7:
        f541918a = r102;
        return r102;
    }

    public static Object d(DataCenter r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        i0 r102 = a(r100);
        if (r102 == null) goto L7;
        ne0.g r103 = r102.f518850b;
        if (r103 == null) goto L7;
        return r103.a(r101);
    L7:
        return null;
    }

    public static void f(DataCenter r100, String r101, Observer r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        i0 r103 = a(r100);
        if (r103 == null) goto L8;
        ne0.g r104 = r103.f518850b;
        if (r104 == null) goto L9;
        r104.b(r101, r102);
        return;
    L9:
        return;
    }
}
