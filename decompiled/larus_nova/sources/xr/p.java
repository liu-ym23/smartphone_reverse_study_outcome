package xr;

import android.graphics.Rect;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public interface p extends o {

    public static final class a {
        public static /* synthetic */ c a(p r100) {
            return r100.newGPViewAppearObserver(200, false, 0.5f, false);
        }
    }

    void Q0(com.lynx.tasm.behavior.ui.view.a r100, com.lynx.tasm.behavior.ui.view.a r101, String r102, Map r103, Map r104, boolean r105, String r106);

    Map<String, String> a1(View r100, String r101);

    void appendHijackInfo(Map<String, String> r100);

    void f(Map r100);

    void filterRouterParams(View r100, HashMap<String, Object> r101);

    void filterViewParams(View r100, HashMap<String, Object> r101, Map<String, ? extends Object> r102, boolean r103);

    String getTrackEventName(View r100, int r101, boolean r102);

    Map<String, Object> getViewTrackData(View r100);

    void monitorAppear(View r100, float r101, boolean r102, boolean r103, Rect r104, Function2<? super Boolean, ? super Float, Unit> r105);

    @Deprecated(message = "使用monitorAppear方法代替")
    com.bytedance.android.gamecp.common.track.monitor.a newGPViewAppearObserver(long r100, boolean r101, float r102, boolean r103);

    void registerPageParamNode(Object r100, View r101, Map<String, ? extends Map<String, String>> r102, boolean r103, boolean r104);

    void sendLog(View r100, String r101, Map<String, String> r102);

    void sendViewTrackLog(View r100, int r101, boolean r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104, float r105);

    void setViewTrackAttrs(View r100, Map<String, ? extends Object> r101);

    void setViewTrackData(View r100, String r101, int r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104, boolean r105);

    void unRegisterPageParamNode(Object r100, View r101);

    void updatePageParamNode(View r100, Map<String, ? extends Map<String, String>> r101);

    @Deprecated(message = "")
    Map<String, String> v();

    boolean viewIsWillDetached(View r100);
}
