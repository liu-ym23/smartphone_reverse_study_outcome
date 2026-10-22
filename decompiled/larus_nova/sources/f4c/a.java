package f4c;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements b08.b<TextView, w3c.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f475597a = null;

    static {
        f475597a = new a();
    }

    public a() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        TextView r101 = (TextView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setVisibility(8);
    }

    @Override // b08.b
    public final void bind(View r100, w3c.a r101) {
        TextView r102 = (TextView) r100;
        w3c.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (TextUtils.isEmpty(r103.f558221a) == false) goto L5;
    L8:
        r102.setVisibility(8);
        return;
    L5:
        if (r103.f558222b == false) goto L8;
        r102.setVisibility(0);
        r102.setText(r103.f558221a);
    }
}
