package tvb;

import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kub.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f547708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<d> f547709b;

    /* JADX INFO: renamed from: tvb.a$a, reason: collision with other inner class name */
    public static final class C7783a {
    }

    static {
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r101 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r101.e("feishu_record_id", r100);
        r101.e("end_method", "feishu_recording_detail_page");
        a(r100, "click_feishu_recording_end", r101.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(c r100, Function0<? extends d> r101) {
        Intrinsics.checkNotNullParameter(r100, "businessTracker");
        Intrinsics.checkNotNullParameter(r101, "hostTrackerProvider");
        this.f547708a = r100;
        this.f547709b = r101;
    }

    public final void a(String r100, String r101, JSONObject r102) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r103 = this.f547708a.c(r100);
        if (r103 != null) goto L6;
        lvb.a.h("MmDoubaoBusinessTracker", "[sendDoubaoEvent] skip: context missing, eventName=" + r101 + ", sessionId=" + r100);
        return;
    L6:
        DoubaoStatisticInfo r104 = r103.f435417c;
        if (r104 != null) goto L10;
        lvb.a.h("MmDoubaoBusinessTracker", "[sendDoubaoEvent] skip: doubaoStatisticInfo missing, eventName=" + r101 + ", sessionId=" + r100);
        return;
    L10:
        d r105 = this.f547709b.invoke();
        if (r105 != null) goto L14;
        lvb.a.h("MmDoubaoBusinessTracker", "[sendDoubaoEvent] skip: host tracker missing, eventName=" + r101 + ", sessionId=" + r100);
        return;
    L14:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r106 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r106.f(r104.toJSONObject());
        r106.f(r102);
        r106.f(r103.f435416b.asTrackerParams().a());
        JSONObject r107 = r106.a();
        lvb.a.a("MmDoubaoBusinessTracker", "[sendDoubaoEvent] eventName=" + r101 + ", sessionId=" + r100 + ", params=" + r107);
        r105.sendEvent(r101, r107);
    }
}
