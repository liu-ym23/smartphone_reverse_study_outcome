package gz2;

import android.os.SystemClock;
import com.bytedance.android.monitorV2.util.k;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class g extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f483381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f483382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f483383j;

    public g() {
    }

    @Override // gz2.a
    public final boolean a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "accessor");
        String r101 = "";
        String r102 = r100.e("bridge_name", "");
        if (r102 == null) goto L7;
        r101 = r102;
    L7:
        return this.f483366d.contains(r101);
    }

    @Override // gz2.a
    public final void d(k r100) {
        Intrinsics.checkNotNullParameter(r100, "accessor");
        Long r101 = r100.c(HiAnalyticsConstant.BI_KEY_COST_TIME, 0L);
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L7:
        if (r102 <= 0) goto L10;
        c(new a.C6084a(r102, r100));
        return;
    L10:
        return;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // gz2.a
    public final void e(long r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r111, "result");
        ArrayList r100 = new ArrayList();
        List<a.C6084a> r101 = this.f483368f;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L3:
        int r104 = 0;
        long r105 = 0;
        if (r103.hasNext() == false) goto L13;
        Object r106 = r103.next();
        Long r107 = k.d(((a.C6084a) r106).f483371b, "callback_ts");
        if (r107 == null) goto L9;
        r105 = r107.longValue();
    L9:
        if (((System.currentTimeMillis() - SystemClock.elapsedRealtime()) + r105) >= r110) goto L11;
        r104 = 1;
    L11:
        if (r104 == 0) goto L3;
        r102.add(r106);
        goto L3
    L13:
        int r112 = r102.size();
        this.f483381h = r112;
        if (r112 <= 0) goto L38;
        Iterator r113 = r102.iterator();
    L17:
        if (r113.hasNext() == false) goto L37;
        Object r114 = r113.next();
        int r108 = r104 + 1;
        if (r104 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        a.C6084a r115 = (a.C6084a) r114;
        if (r104 >= this.f483364b) goto L36;
        JSONObject r109 = new JSONObject();
        String r116 = "";
        String r117 = r115.f483371b.e(BdpAppEventConstant.PARAMS_REQUEST_URL, "");
        if (r117 == null) goto L27;
        r116 = r117;
    L27:
        r109.put(BdpAppEventConstant.PARAMS_REQUEST_URL, r116);
        long r118 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        Long r119 = k.d(r115.f483371b, "invoke_ts");
        if (r119 == null) goto L30;
        long r120 = r119.longValue();
    L31:
        r109.put("request_start", r118 + r120);
        long r121 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        Long r122 = k.d(r115.f483371b, "callback_ts");
        if (r122 == null) goto L34;
        long r123 = r122.longValue();
    L35:
        r109.put("request_end", r121 + r123);
        r100.add(r109);
        goto L36
    L34:
        r123 = 0;
        goto L35
    L30:
        r120 = 0;
    L36:
        this.f483382i += r115.f483370a;
        r104 = r108;
        goto L17
    L37:
        this.f483383j = this.f483382i / ((long) this.f483381h);
    L38:
        JSONObject r124 = new JSONObject();
        l.o(r124, "request_dur_avg", this.f483383j);
        l.n(r124, "request_count", this.f483381h);
        l.o(r124, "request_dur_sum", this.f483382i);
        l.p(r124, "request_dur_list", new JSONArray(r100));
        l.p(r111, "request_dur", r124);
    }
}
