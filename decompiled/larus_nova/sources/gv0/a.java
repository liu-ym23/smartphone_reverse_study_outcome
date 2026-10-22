package gv0;

import android.text.TextUtils;
import com.bytedance.android.live.profit.taskcenter.i;
import com.bytedance.android.live.profit.taskcenter.panel.trace.LiveTaskPanelTraceMonitor;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l01.d;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements ev0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f482810a = null;

    public a() {
    }

    static {
        f482810a = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static HashMap c() {
        return (HashMap) i.f89029b.getValue(null, i.f89028a[0]);
    }

    @Override // ev0.a
    public final void a(fv0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frequencyParams");
        String r101 = r100.f478948a;
        if (by0.b.a(r101) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L16;
        String r102 = r101 + ((d) f.a(d.class)).getCurrentUserId();
        String r103 = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).format(new Date());
        String r104 = r102 + "-lastShowDate";
        String r105 = (String) c().get(r104);
        String r106 = r102 + "-showCount";
        String r107 = (String) c().get(r106);
        if (r107 == null) goto L10;
        int r108 = CastIntegerProtector.parseInt(r107);
    L12:
        if (TextUtils.equals(r103, r105) == false) goto L14;
        HashMap r109 = c();
        r109.put(r106, String.valueOf(r108 + 1));
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        i.f89029b.setValue(null, i.f89028a[0], r109);
        return;
    L14:
        HashMap r110 = c();
        r110.put(r104, r103);
        r110.put(r106, "1");
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        i.f89029b.setValue(null, i.f89028a[0], r110);
        return;
    L10:
        r108 = 0;
        goto L12
    }

    @Override // ev0.a
    public final boolean b(fv0.a r110) {
        Intrinsics.checkNotNullParameter(r110, "frequencyParams");
        int r100 = r110.f478949b;
        String r111 = r110.f478948a;
        String r101 = r111 + ((d) f.a(d.class)).getCurrentUserId();
        String r102 = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).format(new Date());
        String r103 = (String) c().get(r101 + "-lastShowDate");
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r104 = (String) c().get(r101 + "-showCount");
        if (r104 == null) goto L8;
        int r105 = CastIntegerProtector.parseInt(r104);
    L10:
        if (by0.b.a(r111) == false) goto L17;
        if (r100 <= 0) goto L17;
        if (TextUtils.equals(r102, r103) == false) goto L17;
        if (r105 <= r100) goto L17;
        boolean r106 = false;
    L18:
        Map r112 = MapsKt.mapOf(new Pair[]{TuplesKt.to("daily_limit", String.valueOf(r100)), TuplesKt.to("scene", r111), TuplesKt.to("key", r101), TuplesKt.to("current_date", r102), TuplesKt.to("last_data_sp", r103), TuplesKt.to("show_count_sp", String.valueOf(r105)), TuplesKt.to("result", Boolean.valueOf(r106))});
        int r107 = LiveTaskPanelTraceMonitor.f89052a;
        LiveTaskPanelTraceMonitor.a(LiveTaskPanelTraceMonitor.EventName.TTLIVE_TASK_PANEL_MANAGE.getEventName(), LiveTaskPanelTraceMonitor.Step.CHECK_FREQUENCY_DAILY.getStep(), r112);
        return r106;
    L17:
        r106 = true;
        goto L18
    L8:
        r105 = 0;
        goto L10
    }
}
