package we3;

import com.bytedance.android.shopping.ligo.container.event.LiveLigoCartStatusChangeEventData;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListFloatBottomHeightEventData;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListJumpToOtherPageEventData;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListSlideEventData;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a<T extends Serializable> extends z83.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f559386b;

    /* JADX INFO: renamed from: we3.a$a, reason: collision with other inner class name */
    public static final class C8100a extends a<LiveLigoCartStatusChangeEventData> {
        public C8100a(LiveLigoCartStatusChangeEventData r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("ecom.promotion_list.cart_status_change", r100);
        }
    }

    public static final class b extends a<LiveLigoListFloatBottomHeightEventData> {
        public b(LiveLigoListFloatBottomHeightEventData r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("ecom.promotion_list.bottom_height_changed", r100);
        }
    }

    public static final class c extends a<LiveLigoListJumpToOtherPageEventData> {
        public c(LiveLigoListJumpToOtherPageEventData r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("ecom.promotion_list.jump_to_other_page", r100);
        }
    }

    public static final class d extends a<LiveLigoListSlideEventData> {
        public d(LiveLigoListSlideEventData r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("ecom.promotion_list.slide", r100);
        }
    }

    public a() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, Serializable r101) {
        super(r100);
        this.f559386b = r101;
    }
}
