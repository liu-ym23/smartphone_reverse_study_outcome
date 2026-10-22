package u37;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f548609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PushNotificationExtra f548610b;

    public static void a(View r100, List r101) {
        if ((r100 instanceof ViewGroup) == false) goto L11;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L18;
        View r105 = r102.getChildAt(r104);
        if (r105 == null) goto L9;
        a(r105, r101);
    L9:
        r104 = r104 + 1;
        goto L5
    L18:
        return;
    L11:
        if ((r100 instanceof TextView) == false) goto L17;
        ArrayList r106 = (ArrayList) r101;
        r106.add(Integer.valueOf(r100.getId()));
        return;
    }

    public final void b(RemoteViews r110, View r111) {
        int r100 = this.f548610b.f266049i;
        if (r100 == 0) goto L11;
        c(r110, "app_name_text", "android", r100, r111);
        c(r110, "time_divider", "android", r100, r111);
        c(r110, "time", "android", r100, r111);
        if (ToolUtils.isTargetBrandDevice(ToolUtils.VIVO) == false) goto L11;
        if (this.f548610b.f266053m == false) goto L9;
        c(r110, "sub_time_divider", DimLocationCheckUtil.VIVO, 0, r111);
        c(r110, "sub_time", DimLocationCheckUtil.VIVO, 0, r111);
        goto L11
    L9:
        c(r110, "sub_time_divider", DimLocationCheckUtil.VIVO, r100, r111);
        c(r110, "sub_time", DimLocationCheckUtil.VIVO, r100, r111);
    L11:
        if (this.f548610b.f266053m == false) goto L13;
        c(r110, "time", "android", 0, r111);
        c(r110, "time_divider", "android", 0, r111);
    L13:
        int r101 = this.f548610b.f266050j;
        if (r101 == 0) goto L16;
        c(r110, "title", "android", r101, r111);
    L16:
        int r102 = this.f548610b.f266051k;
        if (r102 == 0) goto L20;
        c(r110, "text", "android", r102, r111);
        return;
    }

    public a(Context r100, PushNotificationExtra r101, NotificationBody r102) {
        this.f548609a = r100;
        this.f548610b = r101;
    }

    public static void c(RemoteViews r100, String r101, String r102, int r103, View r104) {
        int r105 = Resources.getSystem().getIdentifier(r101, "id", r102);
        if ((r104.findViewById(r105) instanceof TextView) == false) goto L6;
        r100.setTextColor(r105, r103);
        return;
    }
}
