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
public final class i extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f483387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f483388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f483389j;

    public i() {
    }

    @Override // gz2.a
    public final boolean a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "accessor");
        String r101 = "";
        String r102 = r100.e("res_info.res_type", "");
        if (r102 == null) goto L7;
        r101 = r102;
    L7:
        return this.f483365c.contains(r101);
    }

    @Override // gz2.a
    public final void d(k r100) {
        Intrinsics.checkNotNullParameter(r100, "accessor");
        Long r101 = r100.a(0L);
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
    public final void e(long r100, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        ArrayList r101 = new ArrayList();
        List<a.C6084a> r102 = this.f483368f;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L3:
        int r105 = 0;
        if (r104.hasNext() == false) goto L14;
        Object r106 = r104.next();
        Long r107 = k.d(((a.C6084a) r106).f483371b, "res_load_perf.res_load_finish");
        if (r107 == null) goto L8;
        long r108 = r107.longValue();
    L10:
        if (r108 >= r100) goto L12;
        r105 = 1;
    L12:
        if (r105 == 0) goto L3;
        r103.add(r106);
        goto L3
    L8:
        r108 = 0;
        goto L10
    L14:
        int r109 = r103.size();
        this.f483387h = r109;
        if (r109 <= 0) goto L27;
        Iterator r111 = r103.iterator();
    L18:
        if (r111.hasNext() == false) goto L26;
        Object r112 = r111.next();
        int r113 = r105 + 1;
        if (r105 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        a.C6084a r114 = (a.C6084a) r112;
        if (r105 >= this.f483364b) goto L25;
        r101.add(a.b(r114.f483371b.f163240a, "sub_res_dur"));
    L25:
        this.f483388i += r114.f483370a;
        r105 = r113;
        goto L18
    L26:
        this.f483389j = this.f483388i / ((long) this.f483387h);
    L27:
        JSONObject r115 = new JSONObject();
        l.o(r115, "res_dur_avg", this.f483389j);
        l.n(r115, "res_count", this.f483387h);
        l.o(r115, "res_dur_sum", this.f483388i);
        l.p(r115, "sub_res_dur_list", new JSONArray(r101));
        l.p(r110, "sub_res_dur", r115);
    }
}
