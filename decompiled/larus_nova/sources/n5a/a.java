package n5a;

import com.bytedance.android.ec.slice.SliceInitService;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallback;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallbackResult;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformViewDataProtocol;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformViewPlugin;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlatformMethodCallback f518054a;

    public a(PlatformViewPlugin.b r100) {
        this.f518054a = r100;
    }

    public final void a(PlatformMethodCallbackResult r100) {
        this.f518054a.invoke(r100.ordinal(), SliceInitService.DEFAULT_SWITCH, PlatformViewDataProtocol.JSON_STRING);
    }

    public final void b(PlatformMethodCallbackResult r100, Map<String, Object> r101) {
        JSONObject r102 = new JSONObject(r101);
        this.f518054a.invoke(r100.ordinal(), r102.toString(), PlatformViewDataProtocol.JSON_STRING);
    }
}
