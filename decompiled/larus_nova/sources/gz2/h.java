package gz2;

import com.bytedance.android.monitorV2.util.k;
import com.bytedance.android.monitorV2.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class h extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f483384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f483385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f483386j;

    public h() {
    }

    @Override // gz2.a
    public final boolean a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "accessor");
        String r101 = "";
        String r102 = r100.e("info.jsb_name", "");
        if (r102 == null) goto L7;
        r101 = r102;
    L7:
        return this.f483366d.contains(r101);
    }

    @Override // gz2.a
    public final void d(k r100) {
        Intrinsics.checkNotNullParameter(r100, "accessor");
        Long r101 = r100.c("perf.jsb_call", 0L);
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
        Long r107 = k.d(((a.C6084a) r106).f483371b, "perf.jsb_func_call_end");
        if (r107 == null) goto L9;
        r105 = r107.longValue();
    L9:
        if (r105 >= r110) goto L11;
        r104 = 1;
    L11:
        if (r104 == 0) goto L3;
        r102.add(r106);
        goto L3
    L13:
        int r112 = r102.size();
        this.f483384h = r112;
        if (r112 <= 0) goto L34;
        Iterator r113 = r102.iterator();
    L17:
        if (r113.hasNext() == false) goto L33;
        Object r114 = r113.next();
        int r108 = r104 + 1;
        if (r104 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        a.C6084a r115 = (a.C6084a) r114;
        if (r104 >= this.f483364b) goto L32;
        JSONObject r109 = new JSONObject();
        Long r116 = k.d(r115.f483371b, "perf.jsb_func_call_start");
        if (r116 == null) goto L26;
        long r117 = r116.longValue();
    L27:
        r109.put("request_start", r117);
        Long r118 = k.d(r115.f483371b, "perf.jsb_callback_call_start");
        if (r118 == null) goto L30;
        long r119 = r118.longValue();
    L31:
        r109.put("request_end", r119);
        r100.add(r109);
        goto L32
    L30:
        r119 = 0;
        goto L31
    L26:
        r117 = 0;
    L32:
        this.f483385i += r115.f483370a;
        r104 = r108;
        goto L17
    L33:
        this.f483386j = this.f483385i / ((long) this.f483384h);
    L34:
        JSONObject r120 = new JSONObject();
        l.o(r120, "request_dur_avg", this.f483386j);
        l.n(r120, "request_count", this.f483384h);
        l.o(r120, "request_dur_sum", this.f483385i);
        l.p(r120, "request_dur_list", new JSONArray(r100));
        l.p(r111, "request_dur", r120);
    }
}
