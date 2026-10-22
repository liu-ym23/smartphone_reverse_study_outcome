package com.bytedance.ies.sdk.widgets.priority;

import android.text.TextUtils;
import android.view.Choreographer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.api.IWidgetLoader;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class GroupSchedule {
    public List<String> continueLoadList;
    public int currentLoadLevel;
    public PriorityModule.WidgetScene currentScene;
    private Choreographer.FrameCallback frameCallback;
    public long lastFrameTimeStamp;
    public Map<String, String> loadedTetrisList;
    public Map<String, Object> loadedWidgetList;
    public Map<String, ILoadTask<?>> pendingFrameList;
    public Map<Integer, Map<String, ILoadTask<?>>> pendingLoadList;
    public boolean splitFrame;

    public static class GroupScheduleHolder {
        private static final GroupSchedule instance = null;

        private GroupScheduleHolder() {
        }

        static {
            instance = new GroupSchedule(null);
        }

        public static /* synthetic */ GroupSchedule access$100() {
            return instance;
        }
    }

    public void onStartRoom() {
    }

    private void clearData() {
        this.loadedWidgetList.clear();
        this.loadedTetrisList.clear();
        this.pendingLoadList.clear();
        this.pendingFrameList.clear();
        this.continueLoadList.clear();
        this.frameCallback = null;
        this.lastFrameTimeStamp = 0;
    }

    private boolean isDropFrame() {
        boolean r100 = false;
        if (this.currentLoadLevel != 4) goto L6;
        return false;
    L6:
        if (this.lastFrameTimeStamp > 0) goto L9;
        this.lastFrameTimeStamp = System.nanoTime();
        aLogI("【widget】", "isDropFrame skip: false first frame");
        return false;
    L9:
        long r101 = System.nanoTime();
        float r102 = (r101 - this.lastFrameTimeStamp) / 1000000.0f;
        if (r102 <= (WidgetService.getInstance().getFrameRatio() * 16.6f)) goto L12;
        r100 = true;
    L12:
        aLogI("【widget】", "isDropFrame skip: " + r100 + " frameGap:" + r102 + " currentLoadTimeStamp:" + r101 + " lastFrameTimeStamp:" + this.lastFrameTimeStamp);
        return r100;
    }

    private GroupSchedule() {
        this.loadedWidgetList = new LinkedHashMap();
        this.loadedTetrisList = new LinkedHashMap();
        this.pendingLoadList = new LinkedHashMap();
        this.pendingFrameList = new LinkedHashMap();
        this.continueLoadList = new ArrayList();
    }

    private boolean enableFrameLoad() {
        return WidgetService.getInstance().enableFrameLoad();
    }

    public static GroupSchedule getInstance() {
        return GroupScheduleHolder.access$100();
    }

    private void initFrameCallback() {
        if (usePriority() == true) goto L5;
    L9:
        aLogI("【widget】", "enableFrameLoad not enable");
        return;
    L5:
        if (enableFrameLoad() == false) goto L9;
        aLogI("【widget】", "initFrameCallback");
        this.frameCallback = new AnonymousClass1(this);
        Choreographer.getInstance().postFrameCallback(this.frameCallback);
    }

    private boolean usePriority() {
        if (WidgetService.getInstance().isNewPriority() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.currentScene == null) goto L7;
        return true;
    }

    public /* synthetic */ GroupSchedule(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ boolean access$300(GroupSchedule r100) {
        return r100.isDropFrame();
    }

    public static /* synthetic */ Choreographer.FrameCallback access$400(GroupSchedule r100) {
        return r100.frameCallback;
    }

    private void exitRoom(String r100) {
        if (this.frameCallback == null) goto L5;
        Choreographer.getInstance().removeFrameCallback(this.frameCallback);
    L5:
        clearData();
        this.splitFrame = false;
        this.currentScene = null;
        this.currentLoadLevel = -1;
    }

    private void initScene(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        PriorityModule r101 = PriorityManager.getInstance().getPriorityModule();
        if (r101 != null) goto L8;
        return;
    L8:
        this.splitFrame = r101.splitFrame;
        this.currentScene = r101.getScene(r100);
        StringBuilder r102 = new StringBuilder("initScene currentScene:");
        PriorityModule.WidgetScene r103 = this.currentScene;
        if (r103 != null) goto L11;
        String r104 = "";
    L12:
        r102.append(r104);
        aLogI("【widget】", r102.toString());
        return;
    L11:
        r104 = r103.sceneName;
        goto L12
    }

    private boolean isPendingFrameLoad(String r100) {
        Iterator<String> r101 = this.pendingFrameList.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (TextUtils.equals(getWidgetTagName(r101.next()), r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean isWidgetLoaded(String r100) {
        Iterator<String> r101 = this.loadedWidgetList.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (TextUtils.equals(getWidgetTagName(r101.next()), r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private void loadWidgets(String r100) {
        if (usePriority() == true) goto L5;
    L50:
        aLogI("【widget】", "loadWidgets skip opName: " + r100);
        return;
    L5:
        if (this.currentLoadLevel == 4) goto L50;
        aLogI("【widget】", "loadWidgets start opName: " + r100);
        Map<String, ILoadTask<?>> r101 = this.pendingLoadList.get(Integer.valueOf(PriorityModule.opNameToLevel(r100)));
        if (r101 != null) goto L10;
    L25:
        PriorityModule.Opportunity r102 = this.currentScene.getOpportunity(r100);
        if (r102 == null) goto L49;
        List<PriorityModule.WidgetInfo> r103 = r102.getAllWidgets();
        if (r103 == null) goto L78;
        Iterator<PriorityModule.WidgetInfo> r104 = r103.iterator();
    L31:
        if (r104.hasNext() == false) goto L79;
        final PriorityModule.WidgetInfo r105 = r104.next();
        if (isWidgetLoaded(r105.widget) == true) goto L48;
        if (isPendingFrameLoad(r105.widget) == true) goto L48;
        final IWidgetLoader r106 = WidgetService.getInstance().getWidgetLoader(r105.widget);
        if (r106 == null) goto L39;
        if (this.frameCallback == null) goto L47;
        if (enableFrameLoad() == false) goto L47;
        if (isDropFrame() == false) goto L47;
        this.pendingFrameList.put(r105.widget, new AnonymousClass2(this, r106, r105));
        aLogI("【widget】", "enqueueLoad pendingFrameList widgetTag:" + r105.widget);
    L47:
        aLogI("【widget】", "start load config widget: " + r105.widget);
        this.loadedWidgetList.put(r105.widget, r106.load(r105.widget, this.loadedTetrisList));
        goto L31
    L39:
        aLogI("【widget】", "skip load widget(widgetLoader null): " + r105.widget);
    L48:
        aLogI("【widget】", "skip load widget(containsKey): " + r105.widget);
        goto L31
    L79:
        return;
    L78:
        return;
    L49:
        return;
    L10:
        if (r101.isEmpty() == true) goto L25;
        Iterator<Map.Entry<String, ILoadTask<?>>> r107 = r101.entrySet().iterator();
    L13:
        if (r107.hasNext() == false) goto L25;
        Map.Entry<String, ILoadTask<?>> r108 = r107.next();
        String r109 = r108.getKey();
        if (this.loadedWidgetList.containsKey(r109) == true) goto L16;
        if (this.frameCallback == null) goto L24;
        if (enableFrameLoad() == false) goto L24;
        if (isDropFrame() == false) goto L24;
        this.pendingFrameList.put(r109, r108.getValue());
        aLogI("【widget】", "enqueueLoad pendingFrameList widgetTag:" + r109);
    L24:
        aLogI("【widget】", "enqueueLoad run widgetTag:" + r109 + " level:" + this.currentLoadLevel);
        this.loadedWidgetList.put(r109, r108.getValue().run());
        goto L13
    L16:
        aLogI("【widget】", "load pendingLoadList containsKey: " + r109);
        goto L13
    }

    public String getWidgetTagName(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String[] r101 = r100.split("@");
        if (r101.length == 2) goto L9;
        return null;
    L9:
        return r101[0];
    }

    public boolean isLayerLoaded(String r100) {
        return this.loadedTetrisList.containsKey(r100);
    }

    public void onRoomEnter(String r100) {
        initScene(r100);
    }

    public void onRoomExit(String r100) {
        exitRoom(r100);
    }

    public void onRoomPreload(String r100) {
        initScene(r100);
    }

    public void onWidgetLoadEnd(int r100) {
        if (r100 != 3) goto L12;
        this.currentLoadLevel = 4;
        if (this.frameCallback != null) goto L7;
        aLogI("【widget】", "onWidgetLoadEnd frameCallback == null");
    L10:
        this.frameCallback = null;
        return;
    L7:
        if (this.pendingFrameList.size() != 0) goto L10;
        Choreographer.getInstance().removeFrameCallback(this.frameCallback);
        goto L10
    }

    public void onWidgetLoadStart(int r100) {
        aLogI("【widget】", "onWidgetLoadStart level: " + r100);
        this.currentLoadLevel = r100;
        if (usePriority() == true) goto L5;
        return;
    L5:
        if (r100 != 0) goto L8;
        clearData();
        loadWidgets("p0");
        initFrameCallback();
        return;
    L8:
        if (r100 != 1) goto L11;
        loadWidgets("p1");
        return;
    L11:
        if (r100 != 2) goto L14;
        loadWidgets("p2");
        return;
    L14:
        if (r100 != 3) goto L20;
        loadWidgets("other");
        return;
    }

    private void aLogI(String r100, String r101) {
        WidgetService.getInstance().aLogI(r100, r101);
    }

    public void enqueueContinueLoad(Widget r100, Runnable r101) {
        if (usePriority() == true) goto L5;
    L12:
        aLogI("【widget】", "enqueueContinueLoad skip widgetTag:" + r100.getWidgetTag() + " level:" + this.currentLoadLevel);
        r101.run();
        return;
    L5:
        if (this.currentLoadLevel == 4) goto L12;
        if (this.continueLoadList.contains(r100.getWidgetTag()) == false) goto L10;
        aLogI("【widget】", "enqueueContinueLoad containsKey: " + r100.getWidgetTag());
        return;
    L10:
        aLogI("【widget】", "enqueueContinueLoad run widgetTag:" + r100.getWidgetTag() + " level:" + this.currentLoadLevel);
        r101.run();
        this.continueLoadList.add(r100.getWidgetTag());
    }

    public <T> T enqueueLoad(Widget r100, ILoadTask<T> r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r102 = r100.getWidgetTag();
        if (usePriority() == true) goto L8;
    L35:
        aLogI("【widget】", "enqueueLoad skip widgetTag:" + r102 + " level:" + this.currentLoadLevel);
        return r101.run();
    L8:
        if (this.currentLoadLevel == 4) goto L35;
        String r103 = getWidgetTagName(r102);
        int r104 = this.currentScene.getWidgetLevel(r103);
        if (r104 == (-1)) goto L20;
        if (this.currentLoadLevel >= r104) goto L20;
        Map<String, ILoadTask<?>> r105 = this.pendingLoadList.get(Integer.valueOf(r104));
        if (r105 != null) goto L17;
        r105 = new LinkedHashMap();
        this.pendingLoadList.put(Integer.valueOf(r104), r105);
    L17:
        r105.put(r102, r101);
        aLogI("【widget】", "enqueueLoad pendingLoad: " + r102);
        return null;
    L20:
        if (this.loadedWidgetList.containsKey(r102) == false) goto L24;
        aLogI("【widget】", "enqueueLoad containsKey: " + r102);
        return (T) this.loadedWidgetList.get(r102);
    L24:
        if (this.frameCallback != null) goto L26;
    L33:
        aLogI("【widget】", "enqueueLoad run widgetTag:" + r102 + " level:" + this.currentLoadLevel);
        T r106 = r101.run();
        this.loadedWidgetList.put(r102, r106);
        return r106;
    L26:
        if (enableFrameLoad() == false) goto L33;
        if (canFrameLoad(r100, r103, this.currentScene) == false) goto L33;
        if (isDropFrame() == false) goto L33;
        this.pendingFrameList.put(r102, r101);
        aLogI("【widget】", "enqueueLoad pendingFrameList widgetTag:" + r102);
        return null;
    }

    public static /* synthetic */ void access$200(GroupSchedule r100, String r101, String r102) {
        r100.aLogI(r101, r102);
    }

    private boolean canFrameLoad(Widget r100, String r101, PriorityModule.WidgetScene r102) {
        if (r102 == null) goto L13;
        List<String> r103 = r102.frameLoadList;
        if (r103 == null) goto L13;
        Iterator<String> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        if (TextUtils.equals(r104.next(), r101) == false) goto L8;
        return true;
    L13:
        if (r100.containerView == null) goto L32;
        DataCenter r105 = r100.dataCenter;
        if (r105 != null) goto L19;
        aLogI("【widget】", "canFrameLoad widget.dataCenter == null" + r100.getWidgetTag() + " level:" + this.currentLoadLevel);
        return false;
    L19:
        if (r105.isCleared() == false) goto L23;
        aLogI("【widget】", "canFrameLoad dataCenter.isCleared" + r100.getWidgetTag() + " level:" + this.currentLoadLevel);
        return false;
    L23:
        if (r100.getLayoutId() != 0) goto L25;
    L30:
        return false;
    L25:
        if (r100.getLayoutView() != null) goto L30;
        if (r100.getStatusAsync() == false) goto L34;
        return true;
    L34:
        return false;
    L32:
        if (r100.getStatusAsync() == false) goto L34;
        return true;
    }
}
