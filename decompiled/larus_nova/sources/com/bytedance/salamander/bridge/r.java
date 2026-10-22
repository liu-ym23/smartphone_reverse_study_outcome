package com.bytedance.salamander.bridge;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class r implements JsEventSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<String, Map<String, Object>, Unit> f268580a;

    /* JADX WARN: Multi-variable type inference failed */
    public r(Function2<? super String, ? super Map<String, Object>, Unit> r100) {
        this.f268580a = r100;
    }

    @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
    public final void onReceiveJsEvent(Js2NativeEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        Function2<String, Map<String, Object>, Unit> r101 = this.f268580a;
        String r102 = r100.getEventName();
        XReadableMap r103 = r100.getParams();
        if (r103 == null) goto L17;
        Map<String, Object> r104 = r103.toMap();
        if (r104 == null) goto L17;
        Map r105 = MapsKt.toMutableMap(r104);
        if (r105 == null) goto L17;
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator r107 = r105.entrySet().iterator();
    L10:
        if (r107.hasNext() == false) goto L18;
        Map.Entry r108 = (Map.Entry) r107.next();
        if (r108.getValue() == null) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == false) goto L10;
        r106.put(r108.getKey(), r108.getValue());
        goto L10
    L14:
        r109 = false;
    L18:
        Map<String, Object> r110 = TypeIntrinsics.asMutableMap(r106);
        if (r110 != null) goto L21;
        r110 = new LinkedHashMap();
    L21:
        r101.invoke(r102, r110);
        return;
    L17:
        r106 = null;
        goto L18
    }
}
