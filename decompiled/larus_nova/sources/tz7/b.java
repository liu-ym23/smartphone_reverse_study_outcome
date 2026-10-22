package tz7;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import uz7.c;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends c<ImageView, tz7.a> {

    public static final class a {
    }

    static {
    }

    @Override // uz7.c
    public final void b(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public b() {
    }

    @Override // uz7.c, b08.b
    public final /* bridge */ /* synthetic */ void unbind(View r100) {
        b((ImageView) r100);
    }

    @Override // uz7.c
    public final /* bridge */ /* synthetic */ void a(ImageView r100, AvatarModel r101) {
        c(r100, (tz7.a) r101);
    }

    @Override // uz7.c, b08.b
    public final /* bridge */ /* synthetic */ void bind(View r100, Object r101) {
        c((ImageView) r100, (tz7.a) r101);
    }

    public final void c(ImageView r100, tz7.a r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r102 = uz7.b.f552200a;
        Intrinsics.checkNotNullParameter(r100, "view");
        if (((uz7.b) r100.getTag(R.id.feature_ui_component_chatter_avatar_loader)) != null) goto L17;
        String r103 = r101.f548070m;
        if (r103 != null) goto L7;
    L9:
        String r104 = r101.f548069l;
        if (r104 != null) goto L12;
    L14:
        super.a(r100, r101);
        return;
    L12:
        if (TextUtils.isEmpty(r104) == true) goto L14;
        Log.i("DocsMetaBinder", "DocsMetaBinder bind,not meta");
        mbb.c.e(r100, r101.f548069l, r101.f548071n, r101.f548072o);
        return;
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L9;
        Log.i("DocsMetaBinder", "DocsMetaBinder bind with meta");
        mbb.c.f(r100, r101.f548069l, r101.f548070m, r101.f548071n, r101.f548072o);
        return;
    L17:
        throw null;
    }
}
