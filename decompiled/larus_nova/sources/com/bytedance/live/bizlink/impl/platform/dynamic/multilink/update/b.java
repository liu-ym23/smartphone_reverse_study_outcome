package com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update;

import ch6.f;
import ch6.i;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybGuestLinkChangeAction;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybLinkCallScene;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMainLinkChangeAction;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMediaChangeAction;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f254896a = 0;

    public static final class a {
        public static JsonObject a(i r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            MultiLinkHybLinkCallScene r101 = r100.f23788b;
            MultiLinkHybLinkCallScene r102 = MultiLinkHybLinkCallScene.NotDefine;
            if (r101 != r102) goto L8;
        L22:
            StringBuilder r103 = new StringBuilder("getHybLinkChangeCallRsp but null callSceneReady=");
            if (r100.f23788b != r102) goto L25;
            boolean r104 = true;
        L26:
            r103.append(r104);
            r103.append(" callTypeReady=");
            r103.append(r100.f23789c instanceof f);
            jy0.b.d("HybLinkManager-BaseChangeRoute", r103.toString());
            return null;
        L25:
            r104 = false;
            goto L26
        L8:
            if ((r100.f23789c instanceof f) == true) goto L22;
            JsonObject r105 = new JsonObject();
            r105.addProperty("is_sync_call", Boolean.valueOf(r100.f23787a));
            r105.addProperty("call_scene", r100.f23788b.getCallSceneType());
            ch6.b.a r106 = ch6.b.f23777a0;
            ch6.b r107 = r100.f23789c;
            r106.getClass();
            Intrinsics.checkNotNullParameter(r107, "changeAction");
            if ((r107 instanceof MultiLinkHybMediaChangeAction) == false) goto L14;
            String r108 = ((MultiLinkHybMediaChangeAction) r107).getActionType();
        L20:
            r105.addProperty("act_type", r108);
            r105.add("act_rsp_extra", r100.f23790d);
            return r105;
        L14:
            if ((r107 instanceof MultiLinkHybMainLinkChangeAction) == false) goto L17;
            r108 = ((MultiLinkHybMainLinkChangeAction) r107).getActionType();
            goto L20
        L17:
            if ((r107 instanceof MultiLinkHybGuestLinkChangeAction) == false) goto L19;
            r108 = ((MultiLinkHybGuestLinkChangeAction) r107).getActionType();
            goto L20
        L19:
            r108 = "";
            goto L20
        }
    }

    static {
    }
}
