package rm3;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.live.uikit.toast.CustomToast;
import com.bytedance.android.livesdk.utils.LiveLoggerUtil;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f538539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f538540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f538541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f538542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f538543e = null;

    public c() {
    }

    static {
        f538543e = new c();
    }

    private final Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L15;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == true) goto L11;
        r100 = null;
    L11:
        ContextWrapper r101 = (ContextWrapper) r100;
        if (r101 != null) goto L13;
        r100 = null;
        goto L3
    L13:
        r100 = r101.getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L15:
        return null;
    }

    public static void c(Context r100, String r101, Drawable r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "img");
        if (r100 == null) goto L6;
        a(r100, r101, r102, 0, false);
        return;
    }

    public static void d(Context r100, int r101, int r102) {
        if (r100 == null) goto L5;
        a(r100, r100.getString(r101), r100.getResources().getDrawable(r102), 0, false);
        return;
    }

    public static void f(Context r100, int r101, boolean r102, int r103) {
        if ((r103 & 8) == 0) goto L5;
        r102 = false;
    L5:
        if (r100 == null) goto L8;
        b(r100, r100.getString(r101), 0, r102, false);
        return;
    }

    public static void a(Context r100, String r101, Drawable r102, int r103, boolean r104) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r101, f538541c)) == false) goto L8;
    L9:
        f538541c = r101;
        f538542d = System.currentTimeMillis();
        View r105 = LayoutInflater.from(r100).inflate(R.layout.uicomponent_text_img_toast, null);
        if (r105 == null) goto L20;
        ImageView r106 = (ImageView) r105.findViewById(R.id.toast_img);
        ((TextView) r105.findViewById(R.id.toast_text)).setText(r101);
        r106.setImageDrawable(r102);
        c r107 = f538543e;
        if (NotificationManagerCompat.from(r100).areNotificationsEnabled() == false) goto L14;
        Toast r108 = new Toast(r100);
        r108.setGravity(17, 0, 0);
        r108.setView(r105);
        r108.setDuration(r103);
        r108.show();
        LiveLoggerUtil.f158753b.getClass();
        LiveLoggerUtil.a(r101);
        return;
    L14:
        if (r104 == false) goto L22;
        Activity r109 = r107.getActivity(r100);
        if (r109 == null) goto L23;
        new a(r109, r105).b();
        LiveLoggerUtil.f158753b.getClass();
        LiveLoggerUtil.a(r101);
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L8:
        if ((System.currentTimeMillis() - f538542d) >= CustomToast.LENGTH_SHORT) goto L9;
    }

    public static void b(Context r100, String r101, int r102, boolean r103, boolean r104) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r101, f538539a)) == false) goto L8;
    L9:
        f538539a = r101;
        f538540b = System.currentTimeMillis();
        if (r104 == false) goto L12;
        int r105 = R.style.uicomponent_toast_text_style_not_single_line;
    L13:
        TextView r106 = new TextView(new ContextThemeWrapper(r100, r105));
        r106.setBackground(r100.getResources().getDrawable(R.drawable.uicomponent_toast_bg));
        r106.setText(r101);
        c r107 = f538543e;
        if (NotificationManagerCompat.from(r100).areNotificationsEnabled() == false) goto L16;
        Toast r108 = new Toast(r100);
        r108.setGravity(17, 0, 0);
        r108.setView(r106);
        r108.setDuration(r102);
        r108.show();
        LiveLoggerUtil.f158753b.getClass();
        LiveLoggerUtil.a(r101);
        return;
    L16:
        if (r103 == false) goto L23;
        Activity r109 = r107.getActivity(r100);
        if (r109 == null) goto L24;
        new a(r109, r106).b();
        LiveLoggerUtil.f158753b.getClass();
        LiveLoggerUtil.a(r101);
        return;
    L24:
        return;
    L23:
        return;
    L12:
        r105 = R.style.uicomponent_toast_text_style;
        goto L13
    L8:
        if ((System.currentTimeMillis() - f538540b) >= CustomToast.LENGTH_SHORT) goto L9;
    }

    public static void e(Context r100, String r101, int r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r100 == null) goto L6;
        b(r100, r101, r102, r103, r104);
        return;
    }

    public static /* synthetic */ void g(Context r100, String r101, int r102, boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = false;
    L8:
        e(r100, r101, r102, r103, false);
    }
}
