package so;

import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.core.widget.AspectRatioFrameLayout;
import com.google.gson.annotations.SerializedName;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends com.bytedance.android.ec.window.base.dynamicview.renderer.a<AspectRatioFrameLayout, a> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lso/b$a;", "Lto/a;", "", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "Ljava/lang/Float;", "c", "()Ljava/lang/Float;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends to.a {

        @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
        private final Float ratio;

        public final Float c() {
            return this.ratio;
        }
    }

    public b() {
        super(AspectRatioFrameLayout.class, a.class, "ratio_modifiable_frame_group");
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final void c(View r100) {
        AspectRatioFrameLayout r101 = (AspectRatioFrameLayout) r100;
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        r101.setRatio(1.0f);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final to.a d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        return a(r100);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final void b(View r100, to.a r101) {
        AspectRatioFrameLayout r102 = (AspectRatioFrameLayout) r100;
        a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r102, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r103, "vo");
        Float r104 = r103.c();
        if (r104 == null) goto L5;
        float r105 = r104.floatValue();
    L6:
        r102.setRatio(1.0f / r105);
        return;
    L5:
        r105 = 1.0f;
        goto L6
    }
}
