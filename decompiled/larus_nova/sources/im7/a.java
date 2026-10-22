package im7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.s;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements JsEventSubscriber {
    public a() {
    }

    @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
    public final void onReceiveJsEvent(Js2NativeEvent r100) {
        if ((!Intrinsics.areEqual(r100.getEventName(), "luckySaveWidgetBubbleState")) == false) goto L5;
        return;
    L5:
        XReadableMap r101 = r100.getParams();
        Boolean r102 = null;
        if (r101 == null) goto L8;
        String r103 = s.f(r101, "widget_name", "");
    L9:
        if (r101 == null) goto L11;
        String r104 = s.f(r101, "bubble_text", "");
    L12:
        boolean r105 = false;
        if (r101 == null) goto L15;
        r102 = Boolean.valueOf(s.b(r101, "enable_show_bubble", false));
    L15:
        com.bytedance.ug.sdk.luckydog.api.log.a.c("LuckyWidgetManager", "luckySaveWidgetBubbleState, widgetName=" + r103 + ", bubbleText=" + r104 + ", enableShowBubble=" + r102);
        Gson r106 = f.f490539a;
        if (r102 == null) goto L18;
        r105 = r102.booleanValue();
    L18:
        f.a(r103, r104, r105);
        return;
    L11:
        r104 = null;
        goto L12
    L8:
        r103 = null;
        goto L9
    }
}
