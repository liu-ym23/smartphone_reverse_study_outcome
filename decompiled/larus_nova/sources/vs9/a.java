package vs9;

import com.bytedance.android.ec.slice.SliceInitService;
import com.ixigua.lib.track.TrackParams;
import com.larus.ivykit.web.TTWebViewService;
import com.larus.search.api.event.HybridEventParams;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f557113a = 0;

    static {
    }

    public static int a() {
        TTWebViewService r100 = (TTWebViewService) ServiceManager.get().getService(TTWebViewService.class);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.a() ? 1 : 0;
    }

    public static void b(String r100, boolean r101, HybridEventParams r102) {
        by7.a r103 = new by7.a("rich_media_picture_link_page_show");
        JSONObject r104 = new JSONObject();
        r104.put("url", r100);
        r104.put("webview_type", "self_webview");
        if (r101 == false) goto L5;
        String r105 = "1";
    L6:
        r104.put("is_success", r105);
        r104.put("is_ttwebview", a());
        if (r102 == null) goto L21;
        r104.put("enter_method", r102.f367379a);
        r104.put("local_page", r102.f367380b);
        r104.put("chat_type", r102.f367381c);
        String r106 = r102.f367385g;     // Catch: JSONException -> L14
        if (r106 != null) goto L12;
        r106 = SliceInitService.DEFAULT_SWITCH;
    L12:
        JSONObject r107 = new JSONObject(r106);     // Catch: JSONException -> L14
    L15:
        if (r107 == null) goto L21;
        Iterator<String> r108 = r107.keys();     // Catch: JSONException -> L23
    L18:
        if (r108.hasNext() == false) goto L21;
        String r109 = r108.next();     // Catch: JSONException -> L23
        r104.put(r109, r107.get(r109));     // Catch: JSONException -> L23
    L14:
        r107 = null;
    L21:
        TrackParams r110 = new TrackParams().merge(r104);
        r103.f21463a.merge(r110);
        r103.b();
        return;
    L5:
        r105 = "0";
        goto L6
    }
}
