package o63;

import com.bytedance.android.shopping.track.TrackCatcher;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public class b extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f522175c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f522176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522177b;

    public static final class a {
    }

    static {
        f522175c = new LinkedHashMap();
    }

    @Override // com.bytedance.android.ec.core.event.a
    public void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r100);
        if (StringsKt.startsWith$default(this.f522177b, "livesdk", false, 2, null) == false) goto L9;
        if (this.f522176a == false) goto L7;
        String r101 = "livesdk_matching_product_middle";
    L12:
        appendParam("page_name", r101, r100);
        Iterator r102 = ((LinkedHashMap) f522175c).entrySet().iterator();
    L14:
        if (r102.hasNext() == false) goto L16;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        String r105 = (String) r103.getValue();
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(r104, r105, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        goto L14
    L16:
        Lazy r106 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L21;
        String r107 = this.f522177b;
        getParams();
        TrackCatcher.c("match_purchase", r107, "");
        return;
    L21:
        return;
    L7:
        r101 = "livesdk_no_pic_matching_product_middle";
        goto L12
    L9:
        if (this.f522176a == false) goto L11;
        r101 = "matching_product_middle";
        goto L12
    L11:
        r101 = "no_pic_matching_product_middle";
        goto L12
    }

    @Override // com.bytedance.android.ec.core.event.a, tg.a
    public final String getEventName() {
        return this.f522177b;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
        this.f522177b = r100;
        this.f522176a = true;
    }
}
