package ya1;

import bb0.b;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.ktv.common.util.MusicInfoError;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mb0.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f567014a = null;

    public a() {
    }

    @Override // mb0.c
    public final void b(String r100, MusicPanel r101, HashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "musicPanel");
    }

    @Override // mb0.c
    public final void e(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
    }

    @Override // mb0.c
    public final void h(KtvMusic r100, MusicInfoError r101) {
        Intrinsics.checkNotNullParameter(r101, "errorInfo");
    }

    @Override // mb0.c
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
    }

    static {
        f567014a = new a();
    }

    public static void l(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        SoloKtvContext.Companion.getClass();
        Long r101 = SoloKtvContext.a.a().getCurrentSessionId();
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        r100.put("session_id", r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void m(JSONObject r100) {
        SoloKtvContext.Companion.getClass();
        SoloKtvContext r101 = SoloKtvContext.a.a();
        Long r102 = r101.getModel().c();
        if (r102 == null) goto L5;
        r100.put("room_id", r102.longValue());
    L5:
        Integer r103 = r101.isInSoloKtvPage().getValue();
        if (r103 == null) goto L16;
        int r104 = r103.intValue();
        if (r104 != 2) goto L11;
        String r105 = "middle";
    L14:
        r100.put("scene_id", r105);
        return;
    L11:
        if (r104 != 3) goto L13;
        r105 = "record";
        goto L14
    L13:
        r105 = "";
        goto L14
    }

    public final void n(int r110) {
        JSONObject r100 = new JSONObject();
        m(r100);
        r100.put("error_code", r110);
        nd0.c r101 = nd0.c.f518746a;
        LinkMonitorData r111 = LinkMonitorData.BusinessSoloKtvEnterPracticePageResult;
        nd0.c.p(r101, r111, r100, MultiLinkEventModule.SOLO_KTV, 0, null, false, null, 120);
        String r112 = "api call fail:" + r111.getEventTypeValue() + ", extra:" + r100;
        ALogger.i(b.b(), "SoloKtvFullLinkMonitor :" + r112 + ", invoke class :" + a.class.getSimpleName());
    }

    public final void o(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "failReason");
        JSONObject r100 = new JSONObject();
        m(r100);
        r100.put("error_code", r110);
        r100.put("reason", r111);
        nd0.c r101 = nd0.c.f518746a;
        LinkMonitorData r112 = LinkMonitorData.BusinessSoloKtvExportFail;
        nd0.c.p(r101, r112, r100, MultiLinkEventModule.SOLO_KTV, 0, null, false, null, 120);
        String r113 = "api call fail:" + r112.getEventTypeValue() + ", extra:" + r100;
        ALogger.i(b.b(), "SoloKtvFullLinkMonitor :" + r113 + ", invoke class :" + a.class.getSimpleName());
    }

    @Override // mb0.c
    public final void g(long r110, String r111, long r112) {
        Intrinsics.checkNotNullParameter(r111, "url");
        JSONObject r100 = new JSONObject();
        m(r100);
        r100.put("download_url", r111);
        r100.put("type", KtvSubElement.LYRIC);
        r100.put("resource_key", r110);
        r100.put("error_code", 0);
        r100.put("duration", r112);
        nd0.c.p(nd0.c.f518746a, LinkMonitorData.BusinessSoloKtvDownloadResult, r100, MultiLinkEventModule.SOLO_KTV, 0, null, false, null, 120);
        ALogger.i(b.b(), "SoloKtvFullLinkMonitor :type: lyric download success, invoke class :".concat(a.class.getSimpleName()));
    }

    @Override // mb0.c
    public final void i(String r110, long r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r110, "page");
        Intrinsics.checkNotNullParameter(r112, "extraParams");
        JSONObject r100 = new JSONObject();
        r100.put("page", r110);
        r100.put("duration", r111);
        Iterator<Map.Entry<String, String>> r113 = r112.entrySet().iterator();
    L4:
        if (r113.hasNext() == false) goto L6;
        Map.Entry<String, String> r114 = r113.next();
        r100.put(r114.getKey(), r114.getValue());
        goto L4
    L6:
        m(r100);
        LinkMonitorData r115 = LinkMonitorData.BusinessFirstFrameTime;
        Intrinsics.checkNotNullParameter(r115, "data");
        Intrinsics.checkNotNullParameter(r100, "extra");
        f567014a.m(r100);
        nd0.c.p(nd0.c.f518746a, r115, r100, MultiLinkEventModule.SOLO_KTV, 0, null, false, null, 120);
        String r116 = "businessName:" + r115.getEventTypeValue() + ", extra:" + r100;
        ALogger.i(b.b(), "SoloKtvFullLinkMonitor :" + r116 + ", invoke class :" + a.class.getSimpleName());
    }

    @Override // mb0.c
    public final void a(LinkMonitorData r110, long r111, Throwable r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r113, "extra");
        m(r113);
        nd0.c.r(nd0.c.f518746a, r110, MultiLinkEventModule.SOLO_KTV, r111, r112, r113, 32);
        String r114 = "api call fail:" + r110.getEventTypeValue() + ", extra:" + r113;
        ALogger.i(b.b(), "SoloKtvFullLinkMonitor :" + r114 + ", invoke class :" + a.class.getSimpleName());
    }

    @Override // mb0.c
    public final void c(long r110, String r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r113, "errorMsg");
        JSONObject r100 = new JSONObject();
        m(r100);
        r100.put("download_url", r111);
        r100.put("type", KtvSubElement.LYRIC);
        r100.put("resource_key", r110);
        r100.put("error_code", r112);
        r100.put("reason", r113);
        nd0.c.p(nd0.c.f518746a, LinkMonitorData.BusinessSoloKtvDownloadResult, r100, MultiLinkEventModule.SOLO_KTV, 0, null, false, null, 120);
        ALogger.i(b.b(), "SoloKtvFullLinkMonitor :type: lyric download failed, invoke class :".concat(a.class.getSimpleName()));
    }

    @Override // mb0.c
    public final void d(MusicPanel r110, String r111, String r112, long r113) {
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "downloadUrl");
        JSONObject r100 = new JSONObject();
        m(r100);
        r100.put("type", r111);
        r100.put("download_url", r112);
        if (r110 == null) goto L8;
        KtvMusic r101 = r110.f153577a;
        if (r101 == null) goto L8;
        String r102 = String.valueOf(r101.getMId());
        if (r102 == null) goto L8;
    L9:
        r100.put("resource_key", r102);
        r100.put("error_code", 0);
        r100.put("duration", r113);
        nd0.c.p(nd0.c.f518746a, LinkMonitorData.BusinessSoloKtvDownloadResult, r100, MultiLinkEventModule.SOLO_KTV, 0, null, false, null, 120);
        String r103 = b.b();
        ALogger.i(r103, "SoloKtvFullLinkMonitor :" + ("type: " + r111 + " download success") + ", invoke class :" + a.class.getSimpleName());
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // mb0.c
    public final void j(LinkMonitorData r110, long r111, String r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r112, "logId");
        Intrinsics.checkNotNullParameter(r113, "extra");
        m(r113);
        nd0.c.s(nd0.c.f518746a, r110, MultiLinkEventModule.SOLO_KTV, r111, r112, r113, 96);
        String r114 = "api call success:" + r110.getEventTypeValue() + ", extra:" + r113;
        ALogger.i(b.b(), "SoloKtvFullLinkMonitor :" + r114 + ", invoke class :" + a.class.getSimpleName());
    }

    @Override // mb0.c
    public final void f(MusicPanel r110, String r111, String r112, int r113, String r210) {
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "downloadUrl");
        Intrinsics.checkNotNullParameter(r210, "errorMsg");
        JSONObject r100 = new JSONObject();
        m(r100);
        r100.put("download_url", r112);
        r100.put("type", r111);
        if (r110 == null) goto L8;
        KtvMusic r101 = r110.f153577a;
        if (r101 == null) goto L8;
        String r102 = String.valueOf(r101.getMId());
        if (r102 == null) goto L8;
    L9:
        r100.put("resource_key", r102);
        r100.put("error_code", r113);
        r100.put("reason", r210);
        nd0.c.p(nd0.c.f518746a, LinkMonitorData.BusinessSoloKtvDownloadResult, r100, MultiLinkEventModule.SOLO_KTV, 0, null, false, null, 120);
        String r103 = b.b();
        ALogger.i(r103, "SoloKtvFullLinkMonitor :" + ("type: " + r111 + " download failed") + ", invoke class :" + a.class.getSimpleName());
        return;
    L8:
        r102 = "";
        goto L9
    }
}
