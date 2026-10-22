package f4c;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.y0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements b08.b<TextView, w3c.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f475603a = null;

    static {
        f475603a = new g();
    }

    public g() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        TextView r101 = (TextView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setVisibility(8);
    }

    public static void a(TextView r100, w3c.g r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r101.getClass();
        if (TextUtils.isEmpty(r101.f558235a) == false) goto L6;
        r100.setVisibility(8);
        return;
    L6:
        r100.setVisibility(0);
        if (r101.f558241g == false) goto L10;
        r100.setTextColor(r100.getContext().getResources().getColor(R.color.primary_fill_default));
    L16:
        if (CollectionUtils.isEmpty(r101.f558239e) == true) goto L18;
        j4c.a.a(new SpannableStringBuilder(r101.f558235a), r100, r101.f558239e, r100.getContext().getResources().getColor(r101.f558238d));
        return;
    L18:
        if (CollectionUtils.isEmpty(r101.f558237c) == false) goto L20;
        r100.setText(r101.f558235a);
        return;
    L20:
        r100.setText(y0.c(r101.f558235a, r101.f558237c, r100.getContext().getResources().getColor(r101.f558238d)));
        return;
    L10:
        if (r101.f558236b == true) goto L12;
    L14:
        r100.setTextColor(r100.getContext().getResources().getColor(R.color.text_placeholder));
        goto L16
    L12:
        if (r101.f558240f == false) goto L14;
        r100.setTextColor(r100.getContext().getResources().getColor(R.color.text_title));
        goto L16
    }

    @Override // b08.b
    public final /* bridge */ /* synthetic */ void bind(View r100, w3c.g r101) {
        a((TextView) r100, r101);
    }
}
