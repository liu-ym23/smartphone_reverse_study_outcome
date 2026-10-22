package j36;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.k;
import com.bytedance.ies.bullet.core.kit.bridge.c;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import h16.e;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "bullet.setTracert", owner = "liushaocong")
public final class a extends c implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m16.b f497115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f497116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IBridgeMethod.Access f497117e;

    /* JADX INFO: renamed from: j36.a$a, reason: collision with other inner class name */
    public static final class C6390a {
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.i0
    public final void release() {
    }

    private final BulletContext getContext() {
        e r100 = (e) this.f497115c.c(e.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBulletContext();
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f497117e;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f497116d;
    }

    public a(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f497115c = r100;
        this.f497116d = "bullet.setTracert";
        this.f497117e = IBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r100, IBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        BulletContext r102 = getContext();
        JSONObject r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getSessionId();
    L6:
        if (r104 != null) goto L9;
        r101.onError(-1, "no sessionId");
        return;
    L9:
        Object r105 = r100.opt("categoryDict");
        if ((r105 instanceof JSONObject) == false) goto L12;
        JSONObject r106 = (JSONObject) r105;
    L13:
        Object r107 = r100.opt("timelineDict");
        if ((r107 instanceof JSONObject) == false) goto L16;
        r103 = (JSONObject) r107;
    L16:
        BulletContext r108 = getContext();
        if (r108 == null) goto L21;
        k r109 = r108.f246436d;
        if (r109 == null) goto L21;
        boolean r110 = r109.b(r106, r103);
    L23:
        if (r110 == false) goto L25;
        JSONObject r111 = new JSONObject();
        r111.put("code", 1);
        r101.onComplete(r111);
        return;
    L25:
        JSONObject r112 = new JSONObject();
        r112.put("code", 2);
        r101.onComplete(r112);
        return;
    L21:
        r110 = false;
        goto L23
    L12:
        r106 = null;
        goto L13
    L5:
        r104 = null;
        goto L6
    }
}
