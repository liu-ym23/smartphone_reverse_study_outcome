package u93;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public interface c {
    void a();

    void b(View r100, Bundle r101);

    void c(List r100, int r101);

    void d(LayoutInflater r100, ViewGroup r101, Bundle r102);

    void e(String r100, ECHybridNetworkVO r101, String r102, boolean r103, HomePageDTO r104);

    void f(HomePageDTO r100);

    void g(boolean r100);

    void i(View r100, Bundle r101);

    void j(HomePageDTO r100);

    void k(HomePageDTO r100, k r101);

    void l(String r100);

    void m(Configuration r100, int r101, int r102);

    void n(LayoutInflater r100, ViewGroup r101, Bundle r102, View r103);

    void onCreate(Bundle r100);

    void onDestroy();

    void onDestroyView();

    void onFirstScreen();

    void onStop();
}
