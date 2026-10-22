package dd7;

import com.bytedance.sdk.bridge.Logger;
import com.bytedance.sdk.bridge.js.spec.JsBridgeContext;
import com.bytedance.sdk.bridge.model.BridgeResult;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends JsBridgeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dd7.a f468026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f468027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f468028c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.bridge.js.spec.JsBridgeContext, com.bytedance.sdk.bridge.model.IBridgeContext
    public final void callback(BridgeResult r100) {
        if (this.f468026a.f468023a == null) goto L17;
        JavaOnlyMap r101 = new JavaOnlyMap();
        if (r100.isRaw() == false) goto L9;
        JSONObject r102 = r100.getData();
        if (r102 == null) goto L13;
        r101 = f.b(r102);
    L13:
        Callback r103 = this.f468026a.f468023a;
        if (r103 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        r103.invoke(new Object[]{r101});
        goto L17
    L9:
        JSONObject r104 = r100.getData();
        if (r104 == null) goto L12;
        r101.put("data", f.b(r104));
    L12:
        r101.put("code", Integer.valueOf(r100.getCode()));
        r101.put("message", r100.getMessage());
        r101.put("func", this.f468027b);
        r101.put("callbackId", getCallBackId());
        Logger r105 = Logger.f269563c;
        Objects.toString(r101.get("data"));
        r105.getClass();
        Logger.a();
    L17:
        this.f468026a.f468023a = null;
    }

    public d(dd7.a r100, String r101, String r102, b r110) {
        super(r100, r101, null, 4, null);
        this.f468026a = r100;
        this.f468027b = r102;
        this.f468028c = r110;
    }
}
