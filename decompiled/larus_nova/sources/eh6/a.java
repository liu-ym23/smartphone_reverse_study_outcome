package eh6;

import ch6.g;
import ch6.l;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybGuestLinkGetAction;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybLinkCallScene;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMainLinkGetAction;
import com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMediaGetAction;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f472656a = 0;

    /* JADX INFO: renamed from: eh6.a$a, reason: collision with other inner class name */
    public static final class C5778a {
        public static JsonObject a(l r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            MultiLinkHybLinkCallScene r101 = r100.f23796a;
            MultiLinkHybLinkCallScene r102 = MultiLinkHybLinkCallScene.NotDefine;
            if (r101 != r102) goto L8;
        L22:
            StringBuilder r103 = new StringBuilder("getHybLinkGetCallRsp but null callSceneReady=");
            if (r100.f23796a != r102) goto L25;
            boolean r104 = true;
        L26:
            r103.append(r104);
            r103.append(" callTypeReady=");
            r103.append(r100.f23797b instanceof g);
            jy0.b.d("HybLinkManager-BaseGetRoute", r103.toString());
            return null;
        L25:
            r104 = false;
            goto L26
        L8:
            if ((r100.f23797b instanceof g) == true) goto L22;
            JsonObject r105 = new JsonObject();
            r105.addProperty("call_scene", r100.f23796a.getCallSceneType());
            ch6.e.a r106 = ch6.e.f23782c0;
            ch6.e r107 = r100.f23797b;
            r106.getClass();
            Intrinsics.checkNotNullParameter(r107, "changeAction");
            if ((r107 instanceof MultiLinkHybMediaGetAction) == false) goto L14;
            String r108 = ((MultiLinkHybMediaGetAction) r107).getActionType();
        L20:
            r105.addProperty("get_status_type", r108);
            r105.add("get_status_rsp_extra", r100.f23798c);
            return r105;
        L14:
            if ((r107 instanceof MultiLinkHybMainLinkGetAction) == false) goto L17;
            r108 = ((MultiLinkHybMainLinkGetAction) r107).getActionType();
            goto L20
        L17:
            if ((r107 instanceof MultiLinkHybGuestLinkGetAction) == false) goto L19;
            r108 = ((MultiLinkHybGuestLinkGetAction) r107).getActionType();
            goto L20
        L19:
            r108 = "";
            goto L20
        }
    }

    static {
    }
}
