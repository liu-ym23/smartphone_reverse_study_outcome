package vo1;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.CommonIconModel$loadHybridComponent$1;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface i {

    public static final class a {
        public static /* synthetic */ void a(i r100, Activity r101, String r102, IBaseBrowserService.PageFinishedListener r103, IBaseBrowserService.PageErrorListener r110) {
            r100.d(r101, r102, r103, r110, "");
        }
    }

    void a(String r100, Map<String, ? extends Object> r101);

    void b(String r100, CommonIconModel$loadHybridComponent$1.a r101);

    View c();

    void d(Activity r100, String r101, IBaseBrowserService.PageFinishedListener r102, IBaseBrowserService.PageErrorListener r103, String r104);

    boolean e();

    void f(Activity r100, String r101, LynxThreadStrategy r102, d0 r103);

    View g();

    void h(String r100, Map r101, CommonIconModel$loadHybridComponent$1.a r102);

    IHybridComponent.HybridType hybridType();

    void loadUrl(String r100);

    void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101);

    void release();

    <T> void sendJsEvent(String r100, T r101);
}
