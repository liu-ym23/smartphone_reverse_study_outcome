package pn4;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.lark.SpaceRouteBean;
import com.ss.android.lark.integrator.ccm.CCMApiImpl;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public interface e {
    void a();

    void b(String r100, String r101, String r102, CCMApiImpl.f r103);

    boolean c(String r100, String r101, String r102);

    void clip(WebView r100, String r101);

    void createDoc(Activity r100);

    void d(NetService r100, String r101, Context r102, e05.c r103);

    void destroyQuickLaunchBarItem(Context r100);

    boolean e(Context r100, String r101, int r102, int r103, Map<String, String> r104, Fragment r105, String r106);

    boolean f(SpaceRouteBean r100);

    void g(List<String> r100);

    String getDocumentDefaultName(Context r100, int r101);

    void h(com.ss.android.lark.integrator.ccm.spacekit.i r100);

    boolean i(Context r100, String r101, Map<String, String> r102, Fragment r103, String r104);

    String j(String r100);

    void k(NetService r100, Context r101, String r102, cmb.a r103);

    String l(String r100);

    boolean open(String r100, Map<String, String> r101);

    void stopClip(WebView r100);
}
