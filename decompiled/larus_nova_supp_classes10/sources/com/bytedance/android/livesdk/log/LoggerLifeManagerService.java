package com.bytedance.android.livesdk.log;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.config.ju0;
import com.bytedance.android.livesdk.config.rk0;
import com.bytedance.android.livesdk.log.scope.ScopeLoggerLifeManagerService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.logsdk.format.Spm;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LoggerLifeManagerService implements ILoggerLifeManagerService {
    private static final String PARAM_LIVE_PLATFORM = "_param_live_platform";
    private static final String PREFIX = "livesdk_";
    private static final String ROOM_ORIENTATION = "room_orientation";
    public static final String SDK_VERSION = "sdk_version";
    private h mConfig;
    private Set<String> noMappingEvents;

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void afterExecuteLogFilter() {
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getFakeTempMap() {
        return this.mConfig.getFakeTempMap();
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getMap() {
        return this.mConfig.getMap();
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter() {
        return this.mConfig.getSendLogFilter();
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public void initConfig() {
        this.mConfig.initConfig();
    }

    public LoggerLifeManagerService() {
        this.noMappingEvents = new CopyOnWriteArraySet();
        this.mConfig = new v();
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == false) goto L13;
        h r0 = this.mConfig;
        if ((r0 instanceof v) == false) goto L16;
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r1 = ((v) r0).b;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        r2.putAll(v.a());
    L16:
        ConcurrentHashMap r3 = jc1.k.a;     // Catch: Exception -> L12
        if (r3.containsKey(ILoggerLifeManagerService.class) == true) goto L14;
        r3.put(ILoggerLifeManagerService.class, this);     // Catch: Exception -> L12
    L14:
        this.noMappingEvents.add("livesdk_draw_room_bottom");
        this.noMappingEvents.add("livesdk_show_next_room");
        return;
    L13:
        initConfig();
        jc1.k.l(ILoggerLifeManagerService.class, this);
        goto L14
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void beforeExecuteLogFilter(Map<String, String> r3) {
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r0 = this.mConfig.getMap();
        if (r0.containsKey(am2.d.class) == false) goto L6;
        r0.get(am2.d.class).a(r3);
    L6:
        if (r0.containsKey(am2.i.class) == false) goto L9;
        r0.get(am2.i.class).a(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public ILoggerLifeManagerService getNewInstance(String r2) {
        return new ScopeLoggerLifeManagerService(r2);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public boolean needDropEventBySampling(String r2) {
        qm0.a r0 = om0.c.d();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.needDropEventBySampling(r2);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r2) {
        return this.mConfig.removeSendLogFilter(r2);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public <T> void unregister(Class<? extends T> r2) {
        this.mConfig.unregister(r2);
    }

    private void logEvent(String r5, Map<String, String> r6) {
        Spm r0 = Spm.obtain("a100.c100.d400");
        HashMap r1 = new HashMap();
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r7.next();
        r1.put(r2.getKey(), r2.getValue());
        goto L4
    L6:
        r0.args(r1).businessId(r5).apply("tea_event");
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public boolean addSendLogFilter(Object r2, com.bytedance.android.livesdk.log.filter.v r3) {
        return this.mConfig.addSendLogFilter(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void afterSendAppLog(String r2, Map<String, String> r3) {
        ce1.d r0 = ce1.e.a;
        if (r0 == null) goto L6;
        r0.b();
    L6:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L9;
        logEvent(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void beforeSendAppLog(String r5, Map<String, String> r6) {
        Map<Object, com.bytedance.android.livesdk.log.filter.v> r0 = this.mConfig.getSendLogFilter();
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r1 = this.mConfig.getMap();
        if (r6.containsKey(PARAM_LIVE_PLATFORM) == true) goto L5;
        r6.put(PARAM_LIVE_PLATFORM, "live");
    L5:
        r6.put("sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r6.put(ROOM_ORIENTATION, j0.d);
        Iterator<com.bytedance.android.livesdk.log.filter.v> r2 = r0.values().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().L9(r5, r6);
        goto L7
    L9:
        boolean r3 = false;
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r5.equals("livesdk_live_show") == false) goto L18;
        if (r6.containsKey("event_page") == false) goto L15;
        String r4 = r6.get("event_page");
    L15:
        if (r6.containsKey("event_module") == false) goto L24;
        String r7 = r6.get("event_module");
    L24:
        if (r6.containsKey("bypass_mapping") == false) goto L27;
        r3 = TextUtils.equals("true", r6.get("bypass_mapping"));
    L27:
        if (this.noMappingEvents.contains(r5) == true) goto L31;
        if (r3 == true) goto L31;
        Map<String, String> r8 = e0.a;
    L31:
        if (((Boolean) ju0.a.getValue()).booleanValue() == false) goto L33;
    L34:
        String r9 = ee1.a.a;
        ee1.a.a(r5, r6, r1.get(Room.class));
        return;
    L33:
        if (((Boolean) rk0.a.getValue()).booleanValue() == true) goto L34;
        return;
    L18:
        if (r6.containsKey("enter_from") == false) goto L21;
        String r10 = r6.get("enter_from");
    L21:
        if (r6.containsKey("source") == false) goto L24;
        String r11 = r6.get("source");
        goto L24
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public String onChangeEventName(boolean r3, String r4) {
        if (r4.startsWith("noLivePrefix") == false) goto L5;
        r4 = r4.split("noLivePrefix")[1];
        r3 = false;
    L5:
        if (r3 == true) goto L7;
        return r4;
    L7:
        if (r4.startsWith(PREFIX) == false) goto L9;
        return r4;
    L9:
        return PREFIX.concat(r4);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void onSendAppLog(String r2, Map<String, String> r3) {
        IHostLog r0 = jc1.k.f(IHostLog.class);
        if (r0 == null) goto L6;
        r0.logV3(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService, com.bytedance.android.livesdk.log.h
    public <T> void register(Class<? extends T> r2, com.bytedance.android.livesdk.log.filter.o<? extends T> r3) {
        this.mConfig.register(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.log.ILoggerLifeManagerService
    public void onExecuteLogFilter(Map<String, String> r7, Map<String, String> r8, Object... r9) {
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r0 = this.mConfig.getMap();
        if (r9 == null) goto L20;
        int r1 = r9.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L20;
        Object r3 = r9[r2];
        if (r3 == null) goto L19;
        if ((r3 instanceof Class) == false) goto L16;
        if (r0.containsKey(r3) == false) goto L19;
        r0.get(r3).a(r8);
        goto L19
    L16:
        if (r0.containsKey(r3.getClass()) == false) goto L19;
        ALogger.e("onExecuteLogFilter", "obj:" + r3);
        r0.get(r3.getClass()).u(r8, r3);
    L19:
        r2 = r2 + 1;
    L20:
        if (r7 != null) goto L22;
    L24:
        Map<String, String> r10 = n.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Map<? extends String, ? extends String> r11 = n.b();
        if (r11 == null) goto L34;
        r8.putAll(r11);
        return;
    L34:
        return;
    L22:
        if (r7.size() <= 0) goto L24;
        r8.putAll(r7);
        goto L24
    }
}
