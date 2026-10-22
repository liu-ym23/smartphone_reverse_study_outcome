package wz7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.avatar.AvatarType;
import com.larksuite.component.ui.imageview.LKUIBadgeDrawable2;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import sz7.q;
import sz7.v;
import wz7.d;

/* JADX INFO: loaded from: classes24.dex */
public class c<T extends d> implements b08.b<View, T> {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f561962a = null;

        static {
            int[] r100 = new int[AvatarType.values().length];
            r100[AvatarType.THRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AvatarType.TOPIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AvatarType.MICROAPP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f561962a = r100;
        }
    }

    public c() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = LKUIBadgeDrawable2.f284145i;
        LKUIBadgeDrawable2.a.a(r100, 1).setVisible(false, false);
    }

    public Drawable a(Context r110, T r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r111 == null) goto L26;
        AvatarType r100 = r111.f561963a;
        boolean r101 = v.f544033a;
        int r102 = -1;
        if (v.a.a() == false) goto L19;
        if (r100 != null) goto L9;
        int r103 = -1;
    L10:
        if (r103 != 1) goto L12;
        r102 = R.drawable.icon_feed_thread;
        goto L19
    L12:
        if (r103 != 2) goto L14;
        r102 = R.drawable.icon_feed_topic;
        goto L19
    L14:
        if (r103 != 3) goto L19;
        r102 = R.drawable.icon_feed_mini_app;
        goto L19
    L9:
        r103 = a.f561962a[r100.ordinal()];
    L19:
        if (r102 <= 0) goto L22;
        return AppCompatResources.getDrawable(r110, r102);
    L22:
        if (TextUtils.isEmpty(r111.f561965c) == true) goto L24;
    L25:
        int r104 = r111.f561966d.getPxValue(r110);
        q r105 = new q(r110, false);
        r105.f544015h = true;
        q.d(r105, r111.f561965c, null, r104, r104, r111.f561964b, false, null);
        return r105;
    L24:
        if (r111.f561964b != null) goto L25;
    L26:
        return null;
    }

    @Override // b08.b
    public final void bind(View r110, Object r111) {
        d r112 = (d) r111;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r112, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Context r100 = r110.getContext();
        Intrinsics.checkNotNull(r100);
        Drawable r101 = a(r100, r112);
        if (r101 == null) goto L12;
        int r113 = r112.f561966d.getPxValue(r100);
        int r102 = (int) j08.b.a(r100, 1.5f);
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(1);
        if (r113 <= 0) goto L10;
        int r104 = Math.max(r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
        int r105 = r102 * 2;
        if ((r104 + r105) <= r113) goto L10;
        int r106 = r113 - r105;
        r101.setBounds(0, 0, r106, r106);
        r103.setSize(r113, r113);
    L11:
        r103.setColor(ContextCompat.getColor(r100, R.color.lkui_N50));
    L13:
        if (r101 == null) goto L16;
        if (r103 == null) goto L16;
        int r114 = LKUIBadgeDrawable2.f284145i;
        LKUIBadgeDrawable2.b r115 = LKUIBadgeDrawable2.a.a(r110, 1).c();
        r115.f284163j = 2;
        r115.f284162i = r103;
        r115.f284160g = r101;
        r115.f284165l.setVisible(true, false);
        r115.a();
        return;
    L16:
        int r116 = LKUIBadgeDrawable2.f284145i;
        LKUIBadgeDrawable2.b r117 = LKUIBadgeDrawable2.a.a(r110, 1).c();
        r117.f284165l.setVisible(false, false);
        r117.a();
        return;
    L10:
        int r107 = r102 * 2;
        r103.setSize(r101.getIntrinsicWidth() + r107, r101.getIntrinsicWidth() + r107);
        goto L11
    L12:
        r103 = null;
        goto L13
    }
}
