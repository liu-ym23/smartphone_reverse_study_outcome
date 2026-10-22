package com.larus.livetutor.impl.utils.track;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.apm.ApmAgent;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.livetutor.impl.utils.HeartbeatTracker;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.platform.service.o;
import com.larus.settings.tutor.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveTutorTrackerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f356687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.livetutor.impl.tutor.controller.a f356688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f356689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HeartbeatTracker f356690d;

    public final Map<String, Object> a() {
        HashMap r100 = new HashMap(this.f356687a);
        com.larus.livetutor.impl.tutor.controller.a r101 = this.f356688b;
        if (r101 == null) goto L7;
        Map<String, Object> r102 = r101.getTrackerParams();
        if (r102 == null) goto L7;
        r100.putAll(r102);
    L7:
        return r100;
    }

    public LiveTutorTrackerService() {
        this.f356687a = new ConcurrentHashMap();
        this.f356690d = new HeartbeatTracker(d.a().getLiveTutorHeartRateIntervalMs(), new LiveTutorTrackerService$heartbeatTracker$1(this));
    }

    public static JSONObject c(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        JSONObject r102 = new JSONObject();
        Iterator<String> r103 = r100.keys();
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = r103.next();
        r102.put(r104, r100.opt(r104));
        goto L4
    L6:
        Iterator<String> r105 = r101.keys();
    L8:
        if (r105.hasNext() == false) goto L10;
        String r106 = r105.next();
        r102.put(r106, r101.opt(r106));
        goto L8
    L10:
        return r102;
    }

    public final void d(Map<String, ? extends Object> r100, com.larus.livetutor.impl.tutor.controller.a r101) {
        Intrinsics.checkNotNullParameter(r100, "commonParams");
        Map<String, Object> r102 = this.f356687a;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r104 = r100.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r105 = r104.next();
        if (r105.getValue() == null) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L4;
        r103.put(r105.getKey(), r105.getValue());
        goto L4
    L8:
        r106 = false;
        goto L9
    L11:
        ((ConcurrentHashMap) r102).putAll(r103);
        if (r101 == null) goto L15;
        this.f356688b = r101;
    L15:
        if (this.f356689c != null) goto L23;
        this.f356689c = Long.valueOf(System.currentTimeMillis());
        return;
    }

    public static void b(LiveTutorTrackerService r100, String r101, JSONObject r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r102 = new JSONObject();
    L6:
        if ((r103 & 4) == 0) goto L8;
        Function1 r104 = new b();
    L9:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r104, "modifyParams");
        UtilsKt.j(r102, r100.a());
        r104.invoke(r102);
        o.f365780a.reportEvent(r101, r102);
        return;
    L8:
        r104 = null;
        goto L9
    }

    public final void j(String r100, long r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "loadingType");
        if (r101 >= 0) goto L5;
        kj9.b.b("trackerLoadingTimeClick 纠正时间为0");
        r101 = 0;
    L5:
        JSONObject r104 = new JSONObject();
        r104.put("loading_type", r100);
        r104.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r102);
        r104.put("loading_time", r101);
        r104.put("loading_result", r103);
        Unit r105 = Unit.INSTANCE;
        b(this, "live_tutor_loading_time", r104, 4);
    }

    public static /* synthetic */ void k(LiveTutorTrackerService r100, String r101, long r102, String r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        r110 = null;
    L5:
        r100.j(r101, r102, r110, null);
    }

    public final void h(String r100, Long r101, String r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Intrinsics.checkNotNullParameter(r102, "errReason");
        JSONObject r105 = new JSONObject();
        r105.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r100);
        r105.put("err_reason", r102);
        r105.put(LocationMonitorConst.ERR_MSG, r104);
        r105.put("err_code", r103);
        r105.put("network_status", NetworkUtils.isNetworkAvailable(UtilsKt.c()));
        JSONObject r106 = new JSONObject();
        r106.put("duration", r101);
        b(this, "live_tutor_tracker", c(r105, r106), 4);
        UtilsKt.j(r105, a());
        ApmAgent.monitorEvent("live_tutor_tracker", r105, r106, new JSONObject());
    }

    public static /* synthetic */ void i(LiveTutorTrackerService r100, String r101, Long r102, String r103, int r110, int r111) {
        if ((r111 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.h(r101, r102, r103, r110, null);
    }

    public final void g(String r100, String r101, String r102, String r103, Long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        JSONObject r106 = new JSONObject();
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r100);
        r106.put("sub_page_name", r105);
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT, r101);
        r106.put("fail_reason", r102);
        r106.put("fail_reason_info", r103);
        r106.put("loading_time", r104);
        Unit r107 = Unit.INSTANCE;
        b(this, "live_tutor_item_show", r106, 4);
    }

    public final void f(String r100, String r101, String r102, Long r103, Long r104, Long r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "buttonType");
        JSONObject r107 = new JSONObject();
        r107.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r101);
        r107.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r100);
        r107.put("sub_page_name", r106);
        r107.put("current_state", r102);
        r107.put("loading_time", r103);
        r107.put("long_press_time", r104);
        r107.put("tutor_part_idx", r105);
        Unit r108 = Unit.INSTANCE;
        b(this, "live_tutor_click_button", r107, 4);
    }

    public static void e(LiveTutorTrackerService r100, String r101, Long r102, Long r103, Long r104, String r105, Boolean r106, int r107) {
        if ((r107 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r107 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r107 & 8) == 0) goto L12;
        r104 = null;
    L12:
        if ((r107 & 16) == 0) goto L15;
        r105 = null;
    L15:
        if ((r107 & 32) == 0) goto L17;
        r106 = null;
    L17:
        Intrinsics.checkNotNullParameter(r101, "itemType");
        JSONObject r108 = new JSONObject();
        r108.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r101);
        r108.put("err_reason", r105);
        if (r106 == null) goto L20;
        r108.put(LocationMonitorConst.IS_TIMEOUT, r106.booleanValue() ? 1 : 0);
    L20:
        JSONObject r109 = new JSONObject();
        r109.put("generate_duration", r102);
        r109.put("load_duration", r103);
        r109.put("save_duration", r104);
        b(r100, "live_tutor_tracker", c(r108, r109), 4);
        UtilsKt.j(r108, r100.a());
        ApmAgent.monitorEvent("live_tutor_tracker", r108, r109, new JSONObject());
    }
}
