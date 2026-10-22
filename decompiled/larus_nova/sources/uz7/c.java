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

/* JADX INFO: loaded from: classes24.dex */
public class c<V extends ImageView, M extends AvatarModel> implements b08.b<V, M> {
    public c() {
    }

    public void b(V r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // b08.b
    public /* bridge */ /* synthetic */ void unbind(View r100) {
        b((ImageView) r100);
    }

    public void a(V r100, M r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r102 = b.f552200a;
        Intrinsics.checkNotNullParameter(r100, "view");
        Drawable r103 = null;
        if (((b) r100.getTag(R.id.feature_ui_component_chatter_avatar_loader)) != null) goto L17;
        Context r104 = r100.getContext();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r105 = r101.f284042a;
        if (r105 == null) goto L7;
        r103 = r105;
    L10:
        if (r103 == null) goto L13;
        r100.setImageDrawable(r103);
        return;
    L13:
        if (r101.f284049h == false) goto L15;
        rz7.a.f539978a.getAvatarLoader().a(r100.getContext(), r100, r101);
        return;
    L15:
        rz7.a.f539978a.getAvatarLoader().b(r100.getContext(), r100, r101);
        return;
    L7:
        int r106 = r101.f284043b;
        if (r106 <= 0) goto L10;
        r103 = UDIconUtils.getIconDrawable(r104, r106);
        goto L10
    L17:
        throw null;
    }

    @Override // b08.b
    public /* bridge */ /* synthetic */ void bind(View r100, Object r101) {
        a((ImageView) r100, (AvatarModel) r101);
    }
}
