package f4c;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements b08.b<TextView, w3c.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f475599a = null;

    static {
        f475599a = new c();
    }

    public c() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        TextView r101 = (TextView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setVisibility(8);
    }

    @Override // b08.b
    public final void bind(View r100, w3c.d r101) {
        TextView r102 = (TextView) r100;
        w3c.d r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r103.getClass();
        TextUtils.isEmpty(null);
        r102.setVisibility(8);
    }
}
