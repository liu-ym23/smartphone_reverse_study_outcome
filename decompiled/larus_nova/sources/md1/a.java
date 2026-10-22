package md1;

import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdkapi.depend.model.live.MetricTrackerData;
import com.bytedance.android.livesdkapi.paramtransfer.utils.RoomParamTransferUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f513263a = null;

    public a() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f513263a = new a();
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        LinkedList<MetricTrackerData> r102 = RoomParamTransferUtils.INSTANCE.getTrackerDataList();
        if (r102 == null) goto L21;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        MetricTrackerData r106 = (MetricTrackerData) r105;
        boolean r107 = true;
        if (Intrinsics.areEqual(r106.getEventName(), r100) == false) goto L10;
    L13:
        if (r107 == false) goto L6;
        r103.add(r105);
        goto L6
    L10:
        if (r106.isCommonMetric() == true) goto L13;
        r107 = false;
        goto L13
    L15:
        Iterator r108 = r103.iterator();
    L17:
        if (r108.hasNext() == false) goto L32;
        Map<String, String> r109 = ((MetricTrackerData) r108.next()).getFinalUseTracker();
        if (r109 == null) goto L17;
        r101.putAll(r109);
        goto L17
    L32:
        return;
    }
}
