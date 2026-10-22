package sm;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public interface g {

    public static final class a {
        public static void a(com.bytedance.android.ec.store.repository.vo.l r100, Map r101, List r102, List r103) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "eventParams");
            Intrinsics.checkNotNullParameter(r102, "tagCodeList");
            Intrinsics.checkNotNullParameter(r103, "highlightTagCode");
        }
    }

    void a(View r100);

    void b(StoreV2ProductItemVO r100);

    void c(StoreV2ProductItemVO r100);

    void d(StoreV2ProductItemVO r100);

    void e(StoreV2ProductItemVO r100);

    void f(StoreV2ProductItemVO r100);

    void g(StoreV2ProductItemVO r100);

    void h(StoreV2ProductItemVO r100);

    void i(StoreV2ProductItemVO r100, int r101);

    void j(com.bytedance.android.ec.store.repository.vo.l r100, Map r101, List r102, List r103);
}
