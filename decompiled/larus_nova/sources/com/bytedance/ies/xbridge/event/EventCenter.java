package com.bytedance.ies.xbridge.event;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.depend.IHostEventDepend;
import com.bytedance.ies.xbridge.utils.e;
import com.bytedance.ies.xbridge.utils.i;
import f66.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0007J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0007R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR-\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00190\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R3\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u001f0\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\"¨\u0006)"}, d2 = {"Lcom/bytedance/ies/xbridge/event/EventCenter;", "", "", "timeInMills", "", "setEventTTL", "", "eventName", "Lcom/bytedance/ies/xbridge/event/JsEventSubscriber;", "subscriber", "registerJsEventSubscriber", "containerId", "timestamp", "unregisterJsEventSubscriber", "Lcom/bytedance/ies/xbridge/event/b;", "registerSubscriber", "unregisterSubscriber", "Lcom/bytedance/ies/xbridge/event/Event;", "event", "enqueueEvent", "compatBroadcastEvent", "compatSendEvent", "release", "EVENT_EFFECTIVE_DURATION", "J", "Ljava/util/concurrent/CopyOnWriteArrayList;", "eventQueue$delegate", "Lkotlin/Lazy;", "getEventQueue", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "eventQueue", "Ljava/util/concurrent/ConcurrentHashMap;", "eventSubscribers$delegate", "getEventSubscribers", "()Ljava/util/concurrent/ConcurrentHashMap;", "eventSubscribers", "nativeSubscribers$delegate", "getNativeSubscribers", "nativeSubscribers", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class EventCenter {
    private static long EVENT_EFFECTIVE_DURATION;
    public static final EventCenter INSTANCE = null;
    private static final Lazy eventQueue$delegate = null;
    private static final Lazy eventSubscribers$delegate = null;
    private static final Lazy nativeSubscribers$delegate = null;

    public static final class a implements XBridgeMethod.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JsEventSubscriber f249473a;

        public a(JsEventSubscriber r100) {
            this.f249473a = r100;
        }

        @Override // com.bytedance.ies.xbridge.XBridgeMethod.b
        public final void sendJsEvent(String r100, XReadableMap r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            this.f249473a.onReceiveJsEvent(new Js2NativeEvent(r100, r101));
        }
    }

    private EventCenter() {
    }

    static {
        INSTANCE = new EventCenter();
        EVENT_EFFECTIVE_DURATION = 300000;
        eventQueue$delegate = LazyKt.lazy(EventCenter$eventQueue$2.INSTANCE);
        eventSubscribers$delegate = LazyKt.lazy(EventCenter$eventSubscribers$2.INSTANCE);
        nativeSubscribers$delegate = LazyKt.lazy(EventCenter$nativeSubscribers$2.INSTANCE);
    }

    private final CopyOnWriteArrayList<Event> getEventQueue() {
        return (CopyOnWriteArrayList) eventQueue$delegate.getValue();
    }

    private final ConcurrentHashMap<String, CopyOnWriteArrayList<b>> getEventSubscribers() {
        return (ConcurrentHashMap) eventSubscribers$delegate.getValue();
    }

    private final ConcurrentHashMap<JsEventSubscriber, ConcurrentHashMap<String, b>> getNativeSubscribers() {
        return (ConcurrentHashMap) nativeSubscribers$delegate.getValue();
    }

    private final void compatBroadcastEvent(Event r100) {
        if (r100.isBroadcast() == true) goto L5;
        return;
    L5:
        if (r100.getMapParams() != null) goto L14;
        if (r100.getParams() != null) goto L14;
        y56.a r101 = y56.a.f566240b;
        y56.a r102 = y56.a.f566240b;
        if (r102 == null) goto L43;
        IHostEventDepend r103 = r102.f566241a;
        if (r103 == null) goto L44;
        r103.broadcastEvent(r100.getEventName(), new LinkedHashMap());
        return;
    L44:
        return;
    L43:
        return;
    L14:
        if (r100.getMapParams() == null) goto L21;
        y56.a r104 = y56.a.f566240b;
        y56.a r105 = y56.a.f566240b;
        if (r105 == null) goto L46;
        IHostEventDepend r106 = r105.f566241a;
        if (r106 == null) goto L47;
        String r107 = r100.getEventName();
        Map<String, ? extends Object> r108 = r100.getMapParams();
        Intrinsics.checkNotNull(r108);
        r106.broadcastEvent(r107, r108);
        return;
    L47:
        return;
    L46:
        return;
    L21:
        if (r100.getParams() == null) goto L49;
        Map<String, Object> r109 = r100.getParams().toMap();
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r111 = r109.entrySet().iterator();
    L24:
        if (r111.hasNext() == false) goto L31;
        Map.Entry<String, Object> r112 = r111.next();
        if (r112.getValue() == null) goto L28;
        boolean r113 = true;
    L29:
        if (r113 == false) goto L24;
        r110.put(r112.getKey(), r112.getValue());
        goto L24
    L28:
        r113 = false;
        goto L29
    L31:
        y56.a r114 = y56.a.f566240b;
        y56.a r115 = y56.a.f566240b;
        if (r115 == null) goto L50;
        IHostEventDepend r116 = r115.f566241a;
        if (r116 == null) goto L51;
        r116.broadcastEvent(r100.getEventName(), r110);
        return;
    L51:
        return;
    L50:
        return;
    }

    @JvmStatic
    public static final void enqueueEvent(Event r110) {
        if (r110 == null) goto L4;
        String r100 = r110.getEventName();
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        long r101 = System.currentTimeMillis();
        ConcurrentSkipListSet r102 = new ConcurrentSkipListSet();
        Iterator<Event> r103 = INSTANCE.getEventQueue().iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        Event r104 = r103.next();
        if (Math.abs(r101 - r104.getTimestamp()) <= EVENT_EFFECTIVE_DURATION) goto L9;
        r102.add(r104);
        goto L9
    L13:
        Iterator r105 = r102.iterator();
    L15:
        if (r105.hasNext() == false) goto L17;
        Event r106 = (Event) r105.next();
        INSTANCE.getEventQueue().remove(r106);
        goto L15
    L17:
        EventCenter r107 = INSTANCE;
        r107.getEventQueue().add(r110);
        r107.compatBroadcastEvent(r110);
        CopyOnWriteArrayList<b> r108 = r107.getEventSubscribers().get(r110.getEventName());
        if (r108 == null) goto L23;
        Iterator<T> r109 = r108.iterator();
    L21:
        if (r109.hasNext() == false) goto L31;
        b r111 = (b) r109.next();
        INSTANCE.compatSendEvent(r110, r111);
        goto L21
    L31:
        return;
    L23:
        return;
    L4:
        r100 = null;
        goto L5
    }

    @JvmStatic
    public static final void release(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        Iterator<Map.Entry<String, CopyOnWriteArrayList<b>>> r101 = INSTANCE.getEventSubscribers().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<String, CopyOnWriteArrayList<b>> r102 = r101.next();
        Iterator<T> r103 = r102.getValue().iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        b r104 = (b) r103.next();
        if (Intrinsics.areEqual(r104.f249474a, r100) == false) goto L7;
        r102.getValue().remove(r104);
        goto L7
    }

    @JvmStatic
    public static final void setEventTTL(long r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        EVENT_EFFECTIVE_DURATION = r100;
    }

    private final void compatSendEvent(Event r100, b r101) {
        if (r100.getTargetContainerID() == null) goto L8;
        if (Intrinsics.areEqual(r100.getTargetContainerID(), r101.f249474a) == true) goto L8;
        return;
    L8:
        if (r100.getMapParams() != null) goto L19;
        if (r100.getParams() != null) goto L19;
        XBridgeMethod.b r102 = r101.f249476c;
        if (r102 == null) goto L14;
        r102.sendJsEvent(r100.getEventName(), r100.getParams());
    L14:
        IDLXBridgeMethod.b r103 = r101.f249478e;
        if (r103 == null) goto L17;
        r103.a(r100.getEventName(), r100.getMapParams());
    L17:
        int r104 = i.f249562a;
        i.a("Publish Event:" + r100.getEventName() + " no params");
        return;
    L19:
        if (r100.getMapParams() == null) goto L28;
        XBridgeMethod.b r105 = r101.f249476c;
        if (r105 == null) goto L23;
        String r106 = r100.getEventName();
        int r107 = e.f249556a;
        Map<String, Object> r108 = r100.getMapParams();
        Intrinsics.checkNotNull(r108);
        r105.sendJsEvent(r106, new d(e.d(r108)));
    L23:
        IDLXBridgeMethod.b r109 = r101.f249478e;
        if (r109 == null) goto L26;
        r109.a(r100.getEventName(), r100.getMapParams());
    L26:
        int r110 = i.f249562a;
        i.a("Publish Event:" + r100.getEventName() + " mapParams != null");
        return;
    L28:
        if (r100.getParams() == null) goto L53;
        XBridgeMethod.b r111 = r101.f249476c;
        if (r111 == null) goto L32;
        r111.sendJsEvent(r100.getEventName(), r100.getParams());
    L32:
        Map<String, Object> r112 = r100.getParams().toMap();
        LinkedHashMap r113 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r114 = r112.entrySet().iterator();
    L34:
        if (r114.hasNext() == false) goto L41;
        Map.Entry<String, Object> r115 = r114.next();
        if (r115.getValue() == null) goto L38;
        boolean r116 = true;
    L39:
        if (r116 == false) goto L34;
        r113.put(r115.getKey(), r115.getValue());
        goto L34
    L38:
        r116 = false;
        goto L39
    L41:
        IDLXBridgeMethod.b r117 = r101.f249478e;
        if (r117 == null) goto L44;
        r117.a(r100.getEventName(), r113);
    L44:
        int r118 = i.f249562a;
        i.a("Publish Event:" + r100.getEventName() + " params != null");
        return;
    }

    @JvmStatic
    public static final void registerJsEventSubscriber(String r100, JsEventSubscriber r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        registerJsEventSubscriber(r100, r101, System.currentTimeMillis(), UUID.randomUUID().toString());
    }

    @JvmStatic
    public static final void registerSubscriber(b r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        EventCenter r102 = INSTANCE;
        CopyOnWriteArrayList<b> r103 = r102.getEventSubscribers().get(r101);
        if (r103 != null) goto L10;
        r103 = new CopyOnWriteArrayList();
        r102.getEventSubscribers().put(r101, r103);
    L10:
        if (r103.contains(r100) == false) goto L12;
        r103.set(r103.indexOf(r100), r100);
    L13:
        r102.getEventSubscribers().put(r101, r103);
        Iterator<T> r104 = r102.getEventQueue().iterator();
    L15:
        if (r104.hasNext() == false) goto L21;
        Event r105 = (Event) r104.next();
        if (Intrinsics.areEqual(r105.getEventName(), r101) == false) goto L15;
        if (r100.f249475b > r105.getTimestamp()) goto L15;
        INSTANCE.compatSendEvent(r105, r100);
        goto L15
    L21:
        return;
    L12:
        r103.add(r100);
        goto L13
    }

    @JvmStatic
    public static final void unregisterJsEventSubscriber(String r100, JsEventSubscriber r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        EventCenter r102 = INSTANCE;
        ConcurrentHashMap<String, b> r103 = r102.getNativeSubscribers().get(r101);
        if (r103 == null) goto L11;
        b r104 = r103.get(r100);
        if (r104 == null) goto L8;
        unregisterSubscriber(r104, r100);
        b r105 = r103.remove(r100);
    L8:
        if (r103.isEmpty() == false) goto L12;
        r102.getNativeSubscribers().remove(r101);
        return;
    L12:
        return;
    }

    @JvmStatic
    public static final void unregisterSubscriber(b r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        CopyOnWriteArrayList<b> r102 = INSTANCE.getEventSubscribers().get(r101);
        if (r102 == null) goto L10;
        r102.remove(r100);
        return;
    }

    @JvmStatic
    public static final void registerJsEventSubscriber(String r100, JsEventSubscriber r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        Intrinsics.checkNotNullParameter(r102, "containerId");
        registerJsEventSubscriber(r100, r101, System.currentTimeMillis(), r102);
    }

    @JvmStatic
    public static final void registerJsEventSubscriber(String r100, JsEventSubscriber r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        registerJsEventSubscriber(r100, r101, r102, UUID.randomUUID().toString());
    }

    @JvmStatic
    public static final void registerJsEventSubscriber(String r100, JsEventSubscriber r101, long r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        Intrinsics.checkNotNullParameter(r110, "containerId");
        b r103 = new b(r110, r102, new a(r101), null);
        EventCenter r104 = INSTANCE;
        if (r104.getNativeSubscribers().get(r101) != null) goto L5;
        r104.getNativeSubscribers().put(r101, new ConcurrentHashMap());
    L5:
        ConcurrentHashMap<String, b> r105 = r104.getNativeSubscribers().get(r101);
        if (r105 == null) goto L8;
        b r106 = r105.put(r100, r103);
    L8:
        registerSubscriber(r103, r100);
    }
}
