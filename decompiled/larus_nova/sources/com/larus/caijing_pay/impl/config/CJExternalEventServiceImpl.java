package com.larus.caijing_pay.impl.config;

import com.android.ttcjpaysdk.base.service.ICJExternalEventCenterCallback;
import com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalEventService;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import f66.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016J(\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJExternalEventServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/container/old_container/CJExternalEventService;", "<init>", "()V", "enqueueEvent", "", "eventName", "", "timestamp", "", "params", "Lorg/json/JSONObject;", "registerJsEventSubscriber", "", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJExternalEventCenterCallback;", "unregisterJsEventSubscriber", "subscriber", "registerSubscriber", "containerId", "unregisterSubscriber", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJExternalEventServiceImpl implements CJExternalEventService {

    /* JADX INFO: loaded from: classes26.dex */
    public static final class a implements JsEventSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ICJExternalEventCenterCallback f321296a;

        public a(ICJExternalEventCenterCallback r100) {
            this.f321296a = r100;
        }

        @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
        public final void onReceiveJsEvent(Js2NativeEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "jsEvent");
            ICJExternalEventCenterCallback r101 = this.f321296a;
            String r102 = r100.getEventName();
            XReadableMap r103 = r100.getParams();
            if (r103 == null) goto L5;
            Map<String, ? extends Object> r104 = r103.toMap();
        L6:
            r101.onReceiveEvent(r102, r104);
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class b implements XBridgeMethod.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ICJExternalEventCenterCallback f321297a;

        public b(ICJExternalEventCenterCallback r100) {
            this.f321297a = r100;
        }

        @Override // com.bytedance.ies.xbridge.XBridgeMethod.b
        public final void sendJsEvent(String r100, XReadableMap r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            ICJExternalEventCenterCallback r102 = this.f321297a;
            if (r101 == null) goto L5;
            Map<String, ? extends Object> r103 = r101.toMap();
        L6:
            r102.onReceiveEvent(r100, r103);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public CJExternalEventServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalEventService
    public Object registerJsEventSubscriber(String r100, ICJExternalEventCenterCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "callback");
        a r102 = new a(r101);
        EventCenter.registerJsEventSubscriber(r100, r102);
        return r102;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalEventService
    public void unregisterJsEventSubscriber(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if ((r101 instanceof JsEventSubscriber) == false) goto L6;
        EventCenter.unregisterJsEventSubscriber(r100, (JsEventSubscriber) r101);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalEventService
    public void unregisterSubscriber(Object r100, String r101) {
        if ((r100 instanceof com.bytedance.ies.xbridge.event.b) == false) goto L6;
        EventCenter.unregisterSubscriber((com.bytedance.ies.xbridge.event.b) r100, r101);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalEventService
    public void enqueueEvent(String r100, long r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (r102 != null) goto L5;
        r102 = new JSONObject();
    L5:
        EventCenter.enqueueEvent(new Event(r100, r101, new d(r102)));
    }

    /* JADX INFO: renamed from: registerSubscriber, reason: collision with other method in class */
    public void m8548registerSubscriber(String r100, long r101, String r110, ICJExternalEventCenterCallback r111) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "callback");
        EventCenter.registerSubscriber(new com.bytedance.ies.xbridge.event.b(r100, r101, new b(r111), null), r110);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalEventService
    public /* bridge */ /* synthetic */ Object registerSubscriber(String r100, long r101, String r102, ICJExternalEventCenterCallback r103) {
        m8548registerSubscriber(r100, r101, r102, r103);
        return Unit.INSTANCE;
    }
}
