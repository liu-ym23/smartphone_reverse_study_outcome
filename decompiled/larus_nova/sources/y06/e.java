package y06;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.f;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends com.bytedance.ies.bullet.core.kit.bridge.c implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m16.b f565589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f565590d;

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f565590d;
    }

    public e(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f565589c = r100;
        this.f565590d = "getBridgeList";
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r100, IBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        BulletContext r102 = (BulletContext) this.f565589c.c(BulletContext.class);
        if (r102 == null) goto L15;
        JSONArray r103 = new JSONArray();
        f r104 = r102.f246447o;
        if (r104 == null) goto L14;
        Map<String, com.bytedance.ies.bullet.service.base.bridge.a> r105 = r104.xu();
        if (r105 == null) goto L14;
        Set<Map.Entry<String, com.bytedance.ies.bullet.service.base.bridge.a>> r106 = r105.entrySet();
        if (r106 == null) goto L14;
        Iterator<T> r107 = r106.iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        Map.Entry r108 = (Map.Entry) r107.next();
        JSONObject r109 = new JSONObject();
        r109.put("name", r108.getKey());
        r109.put("impl", r108.getValue().getClass().getName());
        r103.put(r109);
    L14:
        JSONObject r110 = new JSONObject();
        r110.put("list", r103);
        r101.onComplete(r110);
        Unit r111 = Unit.INSTANCE;
    L16:
        if (r111 != null) goto L20;
        r101.onError(0, "bullet context empty");
        return;
    L20:
        return;
    L15:
        r111 = null;
        goto L16
    }
}
