package qt2;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.service.k;
import com.bytedance.android.livesdk.star.StayTimeTaskWidget;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements xo2.g {

    public static final class a implements k.b<xo2.g> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [R, qt2.g] */
        @Override // com.bytedance.android.livesdk.service.k.b
        public final k.b.a<xo2.g> setup(k.b.a<xo2.g> r100) {
            r100.f158001a = new g();
            r100.f158002b = true;
            return r100;
        }
    }

    public g() {
    }

    @Override // xo2.g
    public final Class<? extends LiveRecyclableWidget> a() {
        return StayTimeTaskWidget.class;
    }
}
