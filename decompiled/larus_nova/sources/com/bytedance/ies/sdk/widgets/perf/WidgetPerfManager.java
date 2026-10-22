package com.bytedance.ies.sdk.widgets.perf;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class WidgetPerfManager {
    private int coldFirst;
    private final List<String> duplicateWidget;
    private boolean isAnchor;
    private long load_duration;
    private long other_duration;
    private long p0_duration;
    private long p1_duration;
    private long p2_duration;
    private boolean reported;
    private long startRoomTime;
    private int widgetLoadLevel;
    private final Map<String, WidgetCostModule> widgetMap;

    /* JADX INFO: renamed from: com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class WidgetPerfManagerHolder {
        private static final WidgetPerfManager instance = null;

        private WidgetPerfManagerHolder() {
        }

        static {
            instance = new WidgetPerfManager(null);
        }

        public static /* synthetic */ WidgetPerfManager access$100() {
            return instance;
        }
    }

    public void onStopRoom(Map<String, Object> r100) {
    }

    public void report() {
        if (this.widgetMap.isEmpty() == false) goto L31;
        return;
    L31:
        Map<String, String> r100 = WidgetService.getInstance().getLogCommonParams(this.widgetMap);     // Catch: Exception -> L28
        JSONArray r101 = new JSONArray();     // Catch: Exception -> L28
        Iterator<Map.Entry<String, WidgetCostModule>> r102 = this.widgetMap.entrySet().iterator();     // Catch: Exception -> L28
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L7:
        if (r102.hasNext() == false) goto L21;
        Map.Entry<String, WidgetCostModule> r110 = r102.next();     // Catch: Exception -> L28
        String r111 = r110.getKey();     // Catch: Exception -> L28
        WidgetCostModule r112 = r110.getValue();     // Catch: Exception -> L28
        int r113 = r112.level;     // Catch: Exception -> L28
        if (r113 == 0) goto L19;
        if (r113 != 1) goto L12;
        r104 = r104 + 1;     // Catch: Exception -> L28
    L20:
        JSONObject r114 = new JSONObject();     // Catch: Exception -> L28
        r114.put("widget_name", r111);     // Catch: Exception -> L28
        r114.put("index", r112.index);     // Catch: Exception -> L28
        r114.put("load_offset", r112.getLoadOffset(this.startRoomTime));     // Catch: Exception -> L28
        r114.put(ImageNetworkRequestsMonitor.KEY_IMAGE_LOAD, r112.getLoadDuration());     // Catch: Exception -> L28
        r114.put("inflate_time", r112.getInflateDuration());     // Catch: Exception -> L28
        r114.put("continue_load_time", r112.getContinueLoadDuration());     // Catch: Exception -> L28
        r114.put("total", r112.getTotal());     // Catch: Exception -> L28
        r114.put("is_async", r112.isAsync);     // Catch: Exception -> L28
        r114.put("is_recycle", r112.isRecycle);     // Catch: Exception -> L28
        r114.put("has_ui", r112.hasUI);     // Catch: Exception -> L28
        r114.put("level", r112.level);     // Catch: Exception -> L28
        r101.put(r114.toString());     // Catch: Exception -> L28
        goto L7
    L12:
        if (r113 != 2) goto L14;
        r105 = r105 + 1;     // Catch: Exception -> L28
        goto L20
    L14:
        if (r113 != 3) goto L20;
        r106 = r106 + 1;     // Catch: Exception -> L28
        goto L20
    L19:
        r103 = r103 + 1;     // Catch: Exception -> L28
        goto L20
    L21:
        HashMap r107 = new HashMap();     // Catch: Exception -> L28
        r107.put("p0_count", r103 + "");     // Catch: Exception -> L28
        r107.put("p0_duration", this.p0_duration + "");     // Catch: Exception -> L28
        r107.put("p1_count", r104 + "");     // Catch: Exception -> L28
        r107.put("p1_duration", this.p1_duration + "");     // Catch: Exception -> L28
        r107.put("p2_count", r105 + "");     // Catch: Exception -> L28
        r107.put("p2_duration", this.p2_duration + "");     // Catch: Exception -> L28
        r107.put("other_count", r106 + "");     // Catch: Exception -> L28
        r107.put("other_duration", this.other_duration + "");     // Catch: Exception -> L28
        r107.put("load_count", this.widgetMap.size() + "");     // Catch: Exception -> L28
        r107.put("load_duration", this.load_duration + "");     // Catch: Exception -> L28
        r107.put("widget_list", r101.toString());     // Catch: Exception -> L28
        r107.put("is_cold_first", String.valueOf(this.coldFirst));     // Catch: Exception -> L28
        r107.put("widget_load_level", String.valueOf(this.widgetLoadLevel));     // Catch: Exception -> L28
        r107.put("user_type", WidgetService.getInstance().getUserType(this.isAnchor));     // Catch: Exception -> L28
        if (r100 != null) goto L24;
    L26:
        WidgetService.getInstance().sendLog("livesdk_widget_performance", r107, new Object[0]);     // Catch: Exception -> L28
        this.widgetMap.clear();     // Catch: Exception -> L28
        this.reported = true;     // Catch: Exception -> L28
        this.coldFirst = 0;     // Catch: Exception -> L28
        this.widgetLoadLevel = -1;     // Catch: Exception -> L28
        this.p0_duration = 0;     // Catch: Exception -> L28
        this.p1_duration = 0;     // Catch: Exception -> L28
        this.p2_duration = 0;     // Catch: Exception -> L28
        this.other_duration = 0;     // Catch: Exception -> L28
        this.load_duration = 0;     // Catch: Exception -> L28
        return;
    L24:
        if (r100.containsKey("action_type") == false) goto L26;
        r107.put("action_type", r100.get("action_type"));     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    }

    private WidgetPerfManager() {
        this.reported = false;
        this.coldFirst = 0;
        this.widgetLoadLevel = -1;
        this.p0_duration = 0;
        this.p1_duration = 0;
        this.p2_duration = 0;
        this.other_duration = 0;
        this.load_duration = 0;
        this.startRoomTime = -1;
        this.widgetMap = new LinkedHashMap();
        this.duplicateWidget = new ArrayList();
    }

    public static WidgetPerfManager getInstance() {
        return WidgetPerfManagerHolder.access$100();
    }

    public Map<String, WidgetCostModule> getWidgetMap() {
        return this.widgetMap;
    }

    public /* synthetic */ WidgetPerfManager(AnonymousClass1 r100) {
        this();
    }

    public WidgetCostModule getWidgetCostModule(Widget r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return this.widgetMap.get(r100.getClass().getSimpleName());
    }

    public float getWidgetLoadOffset(Widget r100) {
        if (r100 != null) goto L5;
        return -1.0f;
    L5:
        WidgetCostModule r101 = this.widgetMap.get(r100.getClass().getSimpleName());
        if (r101 != null) goto L9;
        return -1.0f;
    L9:
        return r101.onLoadStart - this.startRoomTime;
    }

    public Map<String, WidgetCostModule> getWidgetLoadTrace(Widget r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, WidgetCostModule>> r102 = this.widgetMap.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, WidgetCostModule> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());
        if (TextUtils.equals(r103.getKey(), r100.getClass().getSimpleName()) == false) goto L7;
    L10:
        return r101;
    }

    public void onStartRoom(Map<String, Object> r100) {
        if (this.startRoomTime != (-1)) goto L5;
        LinkedHashMap r101 = new LinkedHashMap(this.widgetMap);
        this.widgetMap.clear();
        this.coldFirst = 1;
    L6:
        this.startRoomTime = System.currentTimeMillis();
        if (this.reported == true) goto L9;
        report();
    L9:
        if (r101 == null) goto L11;
        this.widgetMap.putAll(r101);
    L11:
        this.reported = false;
        this.widgetLoadLevel = -1;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public void onWidgetLoaded(int r100) {
        this.widgetLoadLevel = r100;
        if (r100 != 0) goto L6;
        this.p0_duration = System.currentTimeMillis() - this.startRoomTime;
        return;
    L6:
        if (r100 != 1) goto L9;
        this.p1_duration = (System.currentTimeMillis() - this.startRoomTime) - this.p0_duration;
        return;
    L9:
        if (r100 != 2) goto L12;
        this.p2_duration = ((System.currentTimeMillis() - this.startRoomTime) - this.p0_duration) - this.p1_duration;
        return;
    L12:
        if (r100 != 3) goto L20;
        this.other_duration = (((System.currentTimeMillis() - this.startRoomTime) - this.p0_duration) - this.p1_duration) - this.p2_duration;
        this.load_duration = System.currentTimeMillis() - this.startRoomTime;
        if (this.reported == true) goto L21;
        report();
        return;
    L21:
        return;
    }

    public void setIsAnchor(boolean r100) {
        this.isAnchor = r100;
    }

    public void onPerfEnd(Widget r100, String r101) {
        if (this.reported == false) goto L5;
        return;
    L5:
        long r102 = System.currentTimeMillis();
        String r103 = r100.getClass().getSimpleName();
        WidgetCostModule r104 = this.widgetMap.get(r103);
        if (this.duplicateWidget.contains(r103) == false) goto L8;
        return;
    L8:
        if (r104 != null) goto L11;
        r104 = new WidgetCostModule();
        this.widgetMap.put(r103, r104);
    L11:
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_ON_LOAD) == false) goto L14;
        r104.onLoadEnd = r102;
        return;
    L14:
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_INFLATE) == false) goto L17;
        r104.onInflateEnd = r102;
        return;
    L17:
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_ON_CONTINUE_LOAD) == false) goto L20;
        r104.onContinueLoadEnd = r102;
        return;
    L20:
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_ON_CREATE) == false) goto L23;
        r104.onCreateEnd = r102;
        return;
    L23:
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_ON_START) == false) goto L26;
        r104.onStartEnd = r102;
        return;
    L26:
        if (TextUtils.equals(r101, "onResume") == false) goto L34;
        r104.onResumeEnd = r102;
        return;
    }

    public void onPerfStart(Widget r100, String r101) {
        if (this.reported == false) goto L5;
        return;
    L5:
        long r102 = System.currentTimeMillis();
        String r103 = r100.getClass().getSimpleName();
        WidgetCostModule r104 = this.widgetMap.get(r103);
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_ON_LOAD) == false) goto L11;
        if (r104 == null) goto L11;
        this.duplicateWidget.add(r103);
        return;
    L11:
        if (this.duplicateWidget.contains(r103) == false) goto L13;
        return;
    L13:
        if (r104 != null) goto L16;
        r104 = new WidgetCostModule();
        r104.onLoadStart = r102;
        r104.index = this.widgetMap.size();
        r104.isAsync = r100.getStatusAsync();
        r104.isRecycle = r100.getStatusRecycle();
        r104.hasUI = r100.getStatusHasUI();
        this.widgetMap.put(r103, r104);
    L16:
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_ON_LOAD) == false) goto L19;
        r104.onLoadStart = r102;
        return;
    L19:
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_INFLATE) == false) goto L22;
        r104.onInflateStart = r102;
        return;
    L22:
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_ON_CONTINUE_LOAD) == false) goto L25;
        r104.onContinueLoadStart = r102;
        r104.level = this.widgetLoadLevel + 1;
        return;
    L25:
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_ON_CREATE) == false) goto L28;
        r104.onCreateStart = r102;
        return;
    L28:
        if (TextUtils.equals(r101, WidgetCostModule.TYPE_ON_START) == false) goto L31;
        r104.onStartStart = r102;
        return;
    L31:
        if (TextUtils.equals(r101, "onResume") == false) goto L39;
        r104.onResumeStart = r102;
        return;
    }
}
