package y26;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.c;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import h16.e;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "bullet.getVisibleInfo", owner = "zhaoxin")
public final class a extends c implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f565716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBridgeMethod.Access f565717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f565718e;

    /* JADX INFO: renamed from: y26.a$a, reason: collision with other inner class name */
    public static final class C8298a {
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.i0
    public final void release() {
    }

    private final BulletContext getContext() {
        e r100 = (e) this.f565716c.c(e.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBulletContext();
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f565717d;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f565718e;
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f565716c = r100;
        this.f565717d = IBridgeMethod.Access.PRIVATE;
        this.f565718e = "bullet.getVisibleInfo";
    }

    public static JSONObject b(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("code", 1);
        JSONObject r102 = new JSONObject();
        r102.put("visible", Intrinsics.areEqual(r100, "1"));
        Unit r103 = Unit.INSTANCE;
        r101.put("data", r102);
        return r101;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r100, IBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        BulletContext r102 = getContext();
        if (r102 == null) goto L7;
        com.bytedance.ies.bullet.core.e r103 = r102.f246455w;
        if (r103 == null) goto L7;
        String r104 = r103.f246479g;
    L8:
        if (r104 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        r101.onComplete(b("-1"));
        return;
    L16:
        r101.onComplete(b(r104));
        return;
    L10:
        if (r104.length() == 0) goto L13;
        r105 = false;
    L7:
        r104 = null;
        goto L8
    }
}
