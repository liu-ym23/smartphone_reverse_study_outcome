package uz7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sz7.v;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends c<ImageView, d> {
    @Override // uz7.c
    public final void b(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public e() {
    }

    @Override // uz7.c, b08.b
    public final /* bridge */ /* synthetic */ void unbind(View r100) {
        b((ImageView) r100);
    }

    @Override // uz7.c
    public final /* bridge */ /* synthetic */ void a(ImageView r100, AvatarModel r101) {
        c(r100, (d) r101);
    }

    @Override // uz7.c, b08.b
    public final /* bridge */ /* synthetic */ void bind(View r100, Object r101) {
        c((ImageView) r100, (d) r101);
    }

    public final void c(ImageView r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r102 = b.f552200a;
        Intrinsics.checkNotNullParameter(r100, "view");
        Drawable r103 = null;
        if (((b) r100.getTag(R.id.feature_ui_component_chatter_avatar_loader)) != null) goto L24;
        Context r104 = r100.getContext();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r105 = r101.f284042a;
        if (r105 == null) goto L7;
        r103 = r105;
    L10:
        if (r103 != null) goto L22;
        boolean r106 = v.f544033a;
        if (v.a.a() == false) goto L21;
        String r107 = r101.f284044c;
        if (r107 != null) goto L16;
    L18:
        boolean r108 = false;
    L19:
        if (r108 == false) goto L21;
    L16:
        if (StringsKt.isBlank(r107) == true) goto L18;
        r108 = true;
    L21:
        rz7.a.f539978a.getDocIconProvider().a();
        r100.setImageResource(0);
        return;
    L22:
        super.a(r100, r101);
        return;
    L7:
        int r109 = r101.f284043b;
        if (r109 <= 0) goto L10;
        r103 = UDIconUtils.getIconDrawable(r104, r109);
        goto L10
    L24:
        throw null;
    }
}
