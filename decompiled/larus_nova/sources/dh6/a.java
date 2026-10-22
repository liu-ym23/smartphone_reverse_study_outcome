package dh6;

import ch6.j;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybGuestLinkCBEvent;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybLinkCallScene;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMainLinkCBEvent;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMediaCBEvent;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f468615a = 0;

    /* JADX INFO: renamed from: dh6.a$a, reason: collision with other inner class name */
    public static final class C5671a {
        public static JsonObject a(j r100) {
            MultiLinkHybLinkCallScene r101 = r100.f23791a;
            MultiLinkHybLinkCallScene r102 = MultiLinkHybLinkCallScene.NotDefine;
            if (r101 == r102) goto L16;
            JsonObject r103 = new JsonObject();
            r103.addProperty("call_scene", r100.f23791a.getCallSceneType());
            ch6.c.a r104 = ch6.c.f23779b0;
            ch6.c r105 = r100.f23792b;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, "event");
            if ((r105 instanceof MultiLinkHybMediaCBEvent) == false) goto L8;
            String r106 = ((MultiLinkHybMediaCBEvent) r105).getEventType();
        L14:
            r103.addProperty("event_type", r106);
            r103.add("event_extra", r100.f23793c);
            return r103;
        L8:
            if ((r105 instanceof MultiLinkHybMainLinkCBEvent) == false) goto L11;
            r106 = ((MultiLinkHybMainLinkCBEvent) r105).getEventType();
            goto L14
        L11:
            if ((r105 instanceof MultiLinkHybGuestLinkCBEvent) == false) goto L13;
            r106 = ((MultiLinkHybGuestLinkCBEvent) r105).getEventType();
            goto L14
        L13:
            r106 = "";
            goto L14
        L16:
            StringBuilder r107 = new StringBuilder("getHybLinkEventJson fail callSceneReady=");
            if (r100.f23791a != r102) goto L19;
            boolean r108 = true;
        L20:
            r107.append(r108);
            r107.append(" eventTypeReady=false");
            jy0.b.d("HybLinkManager-BaseAdapter", r107.toString());
            return null;
        L19:
            r108 = false;
            goto L20
        }
    }

    static {
    }
}
