package g42;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface e {

    public static final class a {
        public static void a(c r100, HighlightItem r101) {
            Intrinsics.checkNotNullParameter(r100, "pinContainer");
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        }

        public static void update(e r100, c r101, HighlightItem r102) {
            Intrinsics.checkNotNullParameter(r101, "pinContainer");
            Intrinsics.checkNotNullParameter(r102, "highlightItem");
        }
    }

    void a(HighlightItem r100);

    void b(c r100, HighlightItem r101);

    void c(DataCenter r100, c r101, HighlightItem r102);

    int getContentHeight();

    int getMinHeight();

    View getView();

    void update(c r100, HighlightItem r101);
}
