package we3;

import com.bytedance.android.shopping.ligo.container.event.LiveLigoCartStatusChangeEventData;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListFloatBottomHeightEventData;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListJumpToOtherPageEventData;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListSlideEventData;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a<T extends Serializable> extends z83.b {
    public final T b;

    /* JADX INFO: renamed from: we3.a$a, reason: collision with other inner class name */
    public static final class C0238a extends a<LiveLigoCartStatusChangeEventData> {
        public C0238a(LiveLigoCartStatusChangeEventData r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            super("ecom.promotion_list.cart_status_change", r2);
        }
    }

    public static final class b extends a<LiveLigoListFloatBottomHeightEventData> {
        public b(LiveLigoListFloatBottomHeightEventData r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            super("ecom.promotion_list.bottom_height_changed", r2);
        }
    }

    public static final class c extends a<LiveLigoListJumpToOtherPageEventData> {
        public c(LiveLigoListJumpToOtherPageEventData r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            super("ecom.promotion_list.jump_to_other_page", r2);
        }
    }

    public static final class d extends a<LiveLigoListSlideEventData> {
        public d(LiveLigoListSlideEventData r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            super("ecom.promotion_list.slide", r2);
        }
    }

    public a() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r1, Serializable r2) {
        super(r1);
        this.b = r2;
    }
}
