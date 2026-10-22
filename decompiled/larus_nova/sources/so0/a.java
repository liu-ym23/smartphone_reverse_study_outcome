package so0;

import android.content.Context;
import android.view.Surface;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.widget.PreviewMiniAppWidgetDelegate;
import java.util.List;
import ko0.b;
import mh1.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public interface a extends uo0.a {
    void clickAnchorToolbarMiniApp();

    void closeShelfManagementPage();

    PreviewMiniAppWidgetDelegate d(Context r100, ViewGroup r101, PreviewSourceParam r102, String r103);

    boolean e();

    eq0.a getAnchorMiniAppWidgetDescriptor();

    int getCoexistComponent();

    MemoryStatus getMemoryStatus();

    String getPreviewStarOrderId();

    void h(boolean r100, boolean r101, JSONObject r102);

    void i(String r100, b r101);

    void mount(ShelfInfo r100);

    void notifyMiniAppStartLinkCastResult(boolean r100, Surface r101, int r102);

    void openChoosePage(String r100, String r101, p r102);

    void openCouponPage(Context r100, int r101, List<String> r102);

    void openExplainCardSettingDialog(JSONObject r100);

    void openLiveCastingMiniApp();

    void openMiniApp(String r100, b r101);

    void openShelfManagementPage();

    void pauseLinkCastWhenSceneSwitched(int r100, IOpenPlatformAnchorService.a r101);

    void reportBubbleShow(String r100, String r101);

    void reportDefaultOpenFirstExplainCardOn(String r100, String r101);

    void reportExitMpBind(String r100, String r101, String r102);

    void reportMpClick();

    void reportMpShow();

    void resumeLinkCastWhenSceneSwitched(IOpenPlatformAnchorService.a r100);

    void unmount();

    void updateMemoryStatus(int r100, boolean r101);
}
