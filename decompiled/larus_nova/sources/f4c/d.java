package f4c;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements b08.b<ImageView, w3c.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f475600a = null;

    static {
        f475600a = new d();
    }

    public d() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        ImageView r101 = (ImageView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setVisibility(8);
    }

    @Override // b08.b
    public final void bind(View r100, w3c.e r101) {
        ImageView r102 = (ImageView) r100;
        w3c.e r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Drawable r104 = r103.f558227a;
        if (r104 == null) goto L5;
        r102.setVisibility(0);
        r102.setImageDrawable(r104);
        return;
    L5:
        r102.setVisibility(8);
    }
}
