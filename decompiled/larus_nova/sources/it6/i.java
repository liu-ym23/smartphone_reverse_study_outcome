package it6;

import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.poi.poidetail.container.plugin.business.PoiBusinessHomedLiveFloatPlugin$manager$2;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface i {
    void a(Fragment r100, FrameLayout r101, HashMap<String, String> r102);

    void b(FragmentActivity r100, Window r101);

    void c(int r100);

    void d(FragmentActivity r100, Window r101);

    boolean e();

    void f(Fragment r100, FrameLayout r101);

    void g(FragmentActivity r100, Window r101);

    JSONObject getCurrentRoomInfo(FragmentActivity r100);

    Integer getFloatWindowBottomMargin();

    void h();

    void i(FragmentActivity r100, Window r101);

    boolean isFloatWindowShowing();

    long j();

    void k(DitoFragment r100, FrameLayout r101, PoiBusinessHomedLiveFloatPlugin$manager$2.a r102);

    Boolean l();

    void m();

    boolean n();

    void o(FragmentActivity r100, String r101, boolean r102, HashMap r103, Function0 r104);

    void setFloatWindowBottomMargin(int r100);
}
