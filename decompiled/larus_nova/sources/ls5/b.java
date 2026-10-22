package ls5;

import android.webkit.JavascriptInterface;
import com.bytedance.ee.lark.nativecomponent.core.config.RenderTypes;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f510540c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final txb.a f510541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ls5.a f510542b;

    public static final class a {
        public static String a(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "renderTypes");
            JSONObject r101 = new JSONObject();
            JSONObject r102 = new JSONObject();
            Iterator r103 = r100.entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L10;
            Map.Entry r104 = (Map.Entry) r103.next();
            JSONObject r105 = new JSONObject();
            JSONArray r106 = new JSONArray();
            Iterator r107 = ((Iterable) r104.getValue()).iterator();
        L7:
            if (r107.hasNext() == false) goto L9;
            r106.put(((RenderTypes) r107.next()).getTypeName());
            goto L7
        L9:
            r105.put("supportRenderTypes", r106);
            r102.put((String) r104.getKey(), r105);
            goto L4
        L10:
            r101.put("components", r102);
            return r101.toString();
        }
    }

    static {
    }

    @JavascriptInterface
    public final String componentConfig() {
        return this.f510542b.a();
    }

    @JavascriptInterface
    public final String hostConfig() {
        this.f510542b.b();
        return new JSONObject().toString();
    }

    public b(txb.a r100, ls5.a r101) {
        Intrinsics.checkNotNullParameter(r101, "mClient");
        this.f510541a = r100;
        this.f510542b = r101;
    }
}
