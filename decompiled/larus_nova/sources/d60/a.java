package d60;

import a60.d;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f467102a = null;

    static {
        f467102a = new AtomicLong();
    }

    public static final JSONObject a(List<d> r110) {
        Intrinsics.checkNotNullParameter(r110, "events");
        List<d> r111 = r110;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L31;
        d r101 = (d) r112.next();
        Intrinsics.checkNotNullParameter(r101, "event");
        e r102 = r101.f1934a;
        JSONObject r103 = r101.f1935b;
        JSONObject r104 = r101.f1936c;
        JSONObject r105 = r101.f1937d;
        Intrinsics.checkNotNullParameter(r102, "traceMeta");
        JSONObject r106 = new JSONObject();
        b.a(r106, "event_type", r102.f64998a);
        b.a(r106, "business_type", r102.f64999b);
        b.a(r106, BindCardPayConfirmConstants.Key.TRACE_ID, r102.f65000c);
        b.a(r106, "log_id", r102.f65001d);
        b.a(r106, "product_id", r102.f65002e);
        b.a(r106, "step", r102.f65003f);
        b.a(r106, "room_id", r102.f65004g);
        b.a(r106, "anchor_id", r102.f65005h);
        b.a(r106, "user_id", r102.f65006i);
        Integer r107 = r102.f65007j;
        JSONObject r108 = null;
        if (r107 == null) goto L8;
        String r109 = String.valueOf(r107.intValue());
    L9:
        b.a(r106, "err_code", r109);
        b.a(r106, LocationMonitorConst.ERR_MSG, r102.f65008k);
        b.a(r106, "index", r102.f65009l);
        IMiddleWareHostContext r113 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r113 == null) goto L14;
        String r114 = r113.getChannel();
        if (r114 == null) goto L14;
        b.a(r106, "channel", r114);
    L14:
        if (r105 != null) goto L16;
    L18:
        b.a(r106, "category", r103);
        b.a(r106, "metric", r104);
        if (r105 == null) goto L30;
        JSONObject r115 = new JSONObject();
        Iterator<String> r116 = r105.keys();
    L23:
        if (r116.hasNext() == false) goto L29;
        String r117 = r116.next();
        Object r118 = r105.opt(r117);
        if (r118 == null) goto L27;
        String r119 = r118.toString();
    L28:
        b.a(r115, r117, r119);
        goto L23
    L27:
        r119 = null;
        goto L28
    L29:
        r108 = r115;
    L30:
        b.a(r106, "extra", r108);
        r100.add(r106);
        goto L4
    L16:
        if (r105.opt("timestamp") == null) goto L18;
        b.a(r106, "timestamp", Long.valueOf(r105.optLong("timestamp")));
        goto L18
    L8:
        r109 = null;
        goto L9
    L31:
        JSONObject r120 = new JSONObject();
        b.a(r120, "timestamp", Long.valueOf(System.currentTimeMillis()));
        b.a(r120, "seq_num", Long.valueOf(f467102a.getAndIncrement()));
        b.a(r120, "data", r100);
        return r120;
    }
}
