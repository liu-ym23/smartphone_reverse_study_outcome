package g42;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface d {

    public static final class a {
        public static void a(h r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "map");
        }

        public static void b(d r100, HighlightItem r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, "map");
            r100.c(r101, r102);
        }

        public static void c(d r100, HighlightItem r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, "map");
            r100.c(r101, r102);
        }

        public static void d(d r100, HighlightItem r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, "map");
            r100.c(r101, r102);
        }

        public static void e(d r100, HighlightItem r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, "map");
            r100.c(r101, r102);
        }

        public static void f(d r100, HighlightItem r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, "map");
            r100.c(r101, r102);
        }

        public static void g(d r100, HighlightItem r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, "map");
            r100.c(r101, r102);
        }
    }

    void a(HighlightItem r100, Map<String, String> r101);

    void b(HighlightItem r100, Map<String, String> r101);

    void c(HighlightItem r100, Map<String, String> r101);

    void d(h<?> r100, Map<String, String> r101);

    void e(HighlightItem r100, Map<String, String> r101);

    void f(HighlightItem r100, Map<String, String> r101);

    void g(HighlightItem r100, Map<String, String> r101);

    void h(HighlightItem r100, Map<String, String> r101);
}
