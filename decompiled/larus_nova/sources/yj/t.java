package yj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.android.ec.hybrid.ui.IHybridLiveBoxView;
import com.bytedance.android.ec.hybrid.ui.IHybridVideoBoxView;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface t {
    void createPlayViewAndSave(Context r100, String r101);

    boolean drawBigImage(m8a.d r100, Context r101, Canvas r102, ImageRequest r103, m8a.d.a r104, DisplayMetrics r105);

    void enterDetailByMediaWrapper(HashMap<String, Object> r100, View r101, Context r102, String r103, String r104, String r105, String r106);

    void forbidExitAnima(String r100);

    List<Object> getBehaviorsFromXelemet();

    IHybridLiveBoxView getHybridLiveBoxView(Context r100);

    IHybridLiveBoxView getHybridLiveBoxViewWithReUse(Context r100, boolean r101);

    IHybridVideoBoxView getHybridVideoBoxView(Context r100, boolean r101);

    List<Object> getImageBehaviors(String r100, String r101, Map<String, ? extends Object> r102, String r103, boolean r104, boolean r105);

    Integer getSplitWidth();

    boolean isOptProductCardTransition();

    void setGylActivityBitmap(Bitmap r100, String r101);

    void setGylItemViewBitmap(Bitmap r100, String r101);

    void videoEnterDetailByCover(HashMap<String, Object> r100, View r101, String r102, boolean r103);
}
