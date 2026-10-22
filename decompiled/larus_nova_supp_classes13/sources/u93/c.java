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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface c {
    void a();

    void b(View r1, Bundle r2);

    void c(List r1, int r2);

    void d(LayoutInflater r1, ViewGroup r2, Bundle r3);

    void e(String r1, ECHybridNetworkVO r2, String r3, boolean r4, HomePageDTO r5);

    void f(HomePageDTO r1);

    void g(boolean r1);

    void i(View r1, Bundle r2);

    void j(HomePageDTO r1);

    void k(HomePageDTO r1, k r2);

    void l(String r1);

    void m(Configuration r1, int r2, int r3);

    void n(LayoutInflater r1, ViewGroup r2, Bundle r3, View r4);

    void onCreate(Bundle r1);

    void onDestroy();

    void onDestroyView();

    void onFirstScreen();

    void onStop();
}
