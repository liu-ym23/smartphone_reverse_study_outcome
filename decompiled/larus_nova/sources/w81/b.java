package w81;

import com.bytedance.android.live.room.incentiveinfo.model.CarouselType;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f558614e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f558615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f558616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CarouselType f558617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w81.a f558618d;

    public static final class a {
        @JvmStatic
        public static b a(w81.a r100) {
            Intrinsics.checkNotNullParameter(r100, "dataInfo");
            return new b(CarouselType.ADD, r100);
        }

        @JvmStatic
        public static b b(w81.a r100) {
            Intrinsics.checkNotNullParameter(r100, "dataInfo");
            return new b(CarouselType.REMOVE, r100);
        }

        @JvmStatic
        public static b c(w81.a r100) {
            Intrinsics.checkNotNullParameter(r100, "dataInfo");
            return new b(CarouselType.UPDATE, r100);
        }
    }

    static {
    }

    public b(CarouselType r100, w81.a r101) {
        Intrinsics.checkNotNullParameter(r100, "operate");
        Intrinsics.checkNotNullParameter(r101, "dataInfo");
        this.f558617c = r100;
        this.f558618d = r101;
        this.f558615a = true;
        this.f558616b = true;
    }
}
