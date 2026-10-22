package yg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567498a = 0;

    static {
    }

    public static vg2.a a(xg2.c r100, EventType r101, String r102, Map r110) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r102, "eventName");
        vg2.a r103 = new vg2.a(r102, r101, r100.f563597b.getModule(), r100.f563597b.getAction(), r100.f563596a);
        if (r103.f554676a != null) goto L5;
        return r103;
    L5:
        if (r110 == null) goto L11;
        Iterator r104 = r110.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L11;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.f554676a.put("extra_" + ((String) r105.getKey()), String.valueOf(r105.getValue()));
    L11:
        if ((r100 instanceof xg2.a) == true) goto L13;
        r100 = null;
    L13:
        xg2.a r106 = (xg2.a) r100;
        if (r106 == null) goto L16;
        r103.f554676a.put("error_type", r106.f563592d.getValue());
        r103.f554676a.put("error_code", String.valueOf(r106.f563593e));
        r103.f554676a.put("error_msg", r106.f563594f);
    L16:
        return r103;
    }
}
