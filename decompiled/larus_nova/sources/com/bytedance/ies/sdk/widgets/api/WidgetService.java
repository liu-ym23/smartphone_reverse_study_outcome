package com.bytedance.ies.sdk.widgets.api;

import android.text.TextUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.inflater.IAsyncExecutor;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import com.bytedance.ies.sdk.widgets.priority.GroupSchedule;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class WidgetService implements IWidgetService {
    public static final String PARAM_FRAGMENT = "fragment";
    public static final String PARAM_ROOM = "room";
    public static final String PARAM_ROOM_ENGINE = "room_engine";
    public static final String PARAM_ROOM_EXTRA = "room_extra";
    public static final String PARAM_ROOM_SESSION = "room_session";
    private IAsyncExecutor asyncExecutor;
    public Map<String, IWidgetLoader> creatorMap;
    private Map<Integer, Long> levelTimestamp;
    public IWidgetService service;

    public static class WidgetReporterHolder {
        private static final WidgetService reporter = null;

        private WidgetReporterHolder() {
        }

        static {
            reporter = new WidgetService();
        }

        public static /* synthetic */ WidgetService access$000() {
            return reporter;
        }
    }

    public void onOrientationChange(int r100) {
    }

    public void onRoomBackground() {
    }

    public void onRoomPrepare() {
    }

    public void unRegisterAsyncExecutor() {
        this.asyncExecutor = null;
    }

    public WidgetService() {
        this.creatorMap = new HashMap();
        this.levelTimestamp = new HashMap();
        this.asyncExecutor = null;
    }

    public static WidgetService getInstance() {
        return WidgetReporterHolder.access$000();
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public boolean enableFrameLoad() {
        if (getService() != null) goto L5;
        return false;
    L5:
        return getService().enableFrameLoad();
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public float getFrameRatio() {
        if (getService() != null) goto L5;
        return 1.0f;
    L5:
        return getService().getFrameRatio();
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public boolean isNewPriority() {
        if (getService() != null) goto L5;
        return false;
    L5:
        return getService().isNewPriority();
    }

    public IAsyncExecutor getAsyncExecutor() {
        return this.asyncExecutor;
    }

    public IWidgetService getService() {
        return this.service;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public Map<String, String> getLogCommonParams(Map<String, WidgetCostModule> r100) {
        if (getService() != null) goto L5;
        return null;
    L5:
        return getService().getLogCommonParams(r100);
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public String getRoomScene(Widget r100) {
        if (getService() == null) goto L6;
        String r101 = getService().getRoomScene(r100);
        aLogI("【widget】", "getRoomScene by widget: " + r101);
        return r101;
    L6:
        return null;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public String getUserType(boolean r100) {
        if (getService() != null) goto L5;
        return null;
    L5:
        return getService().getUserType(r100);
    }

    public IWidgetLoader getWidgetLoader(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return this.creatorMap.get(r100);
    }

    public boolean isLayerLoaded(String r100) {
        return GroupSchedule.getInstance().isLayerLoaded(r100);
    }

    public void onRoomEnter(Map<String, Object> r100) {
        String r101 = getRoomScene(r100);
        GroupSchedule.getInstance().onRoomEnter(r101);
    }

    public void onRoomExit(Map<String, Object> r100) {
        String r101 = getRoomScene(r100);
        GroupSchedule.getInstance().onRoomExit(r101);
    }

    public void onRoomPreload(Map<String, Object> r100) {
        String r101 = getRoomScene(r100);
        GroupSchedule.getInstance().onRoomPreload(r101);
    }

    public void onStartRoom(Map<String, Object> r100) {
        WidgetPerfManager.getInstance().onStartRoom(r100);
        GroupSchedule.getInstance().onStartRoom();
    }

    public void onStopRoom(Map<String, Object> r100) {
        WidgetPerfManager.getInstance().onStopRoom(r100);
    }

    public void onWidgetLoadEnd(int r100) {
        aLogI("【widget】", "onWidgetLoadEnd: " + r100);
        if (this.levelTimestamp.containsKey(Integer.valueOf(r100)) == false) goto L5;
        aLogI("【widget】", "onWidgetLoadEnd cost: " + (System.currentTimeMillis() - this.levelTimestamp.remove(Integer.valueOf(r100)).longValue()));
    L5:
        WidgetPerfManager.getInstance().onWidgetLoaded(r100);
        GroupSchedule.getInstance().onWidgetLoadEnd(r100);
    }

    public void onWidgetLoadStart(int r100) {
        aLogI("【widget】", "onWidgetLoadStart: " + r100);
        this.levelTimestamp.put(Integer.valueOf(r100), Long.valueOf(System.currentTimeMillis()));
        GroupSchedule.getInstance().onWidgetLoadStart(r100);
    }

    public void register(IWidgetService r100) {
        this.service = r100;
    }

    public void registerAsyncExecutor(IAsyncExecutor r100) {
        this.asyncExecutor = r100;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public String getRoomScene(Map<String, Object> r100) {
        if (getService() == null) goto L6;
        String r101 = getService().getRoomScene(r100);
        aLogI("【widget】", "getRoomScene by params: " + r101);
        return r101;
    L6:
        return null;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public void aLogI(String r100, String r101) {
        if (getService() == null) goto L6;
        getService().aLogI(r100, r101);
        return;
    }

    public void registerWidgetLoader(Collection<String> r100, IWidgetLoader r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L13;
        if (r101 == null) goto L14;
        Iterator<String> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();
        this.creatorMap.put(r103, r101);
        goto L9
    L15:
        return;
    L14:
        return;
    }

    public void registerWidgetLoader(String r100, IWidgetLoader r101) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == null) goto L9;
        this.creatorMap.put(r100, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public void sendLog(String r100, Map<String, String> r101, Object... r102) {
        if (getService() == null) goto L6;
        getService().sendLog(r100, r101, r102);
        return;
    }
}
