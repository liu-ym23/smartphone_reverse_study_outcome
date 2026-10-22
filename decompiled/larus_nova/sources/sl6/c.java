package sl6;

import com.ss.android.ugc.aweme.poi.event.GoodsDetailPageCloseEvent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f542470a = null;

    static {
        f542470a = new c();
    }

    public c() {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void closeGoodsDetailPage(GoodsDetailPageCloseEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "pdpCloseEvent");
        Iterator<at6.c> r101 = b.f542469a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        at6.c r102 = r101.next();
        if (r102 == null) goto L4;
        r102.OZ();
        goto L4
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onJsEvent(ln6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = r100.f510038b.optString("eventName");
        JSONObject r102 = r100.f510038b.optJSONObject("data");
        if (r102 != null) goto L5;
        r102 = new JSONObject();
    L5:
        CopyOnWriteArraySet<at6.c> r103 = b.f542469a;
        Iterator<T> r104 = b.f542469a.iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        at6.c r105 = (at6.c) r104.next();
        if (r105 == null) goto L7;
        r105.Pd(r101, r102);
        goto L7
    }
}
