package fa;

import android.content.Context;
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
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f475990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f475991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f475992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f475993d;

    static {
    }

    public static void b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r101, f475990a) == true) goto L10;
    L11:
        f475990a = r101;
        f475991b = System.currentTimeMillis();
        TextView r102 = new TextView(new ContextThemeWrapper(r100, R.style.annie_toast_text_style));
        r102.setBackground(r100.getResources().getDrawable(R.drawable.annie_toast_bg));
        r102.setText(r101);
        if (NotificationManagerCompat.from(r100).areNotificationsEnabled() == false) goto L17;
        Toast r103 = new Toast(r100);
        r103.setGravity(17, 0, 0);
        r103.setView(r102);
        r103.setDuration(0);
        r103.show();
        return;
    L17:
        Toast r104 = new Toast(r100);     // Catch: Throwable -> L16
        r104.setGravity(17, 0, 0);     // Catch: Throwable -> L16
        r104.setView(r102);     // Catch: Throwable -> L16
        r104.setDuration(0);     // Catch: Throwable -> L16
        r104.show();     // Catch: Throwable -> L16
        return;
    L23:
        return;
    L10:
        if ((System.currentTimeMillis() - f475991b) >= CustomToast.LENGTH_SHORT) goto L11;
    }

    public static void a(Context r100, String r101, Drawable r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "img");
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r101, f475992c) == true) goto L10;
    L11:
        f475992c = r101;
        f475993d = System.currentTimeMillis();
        View r103 = LayoutInflater.from(r100).inflate(R.layout.annie_text_img_toast, null);
        if (r103 == null) goto L23;
        ImageView r104 = (ImageView) r103.findViewById(R.id.toast_img);
        ((TextView) r103.findViewById(R.id.toast_text)).setText(r101);
        r104.setImageDrawable(r102);
        if (NotificationManagerCompat.from(r100).areNotificationsEnabled() == false) goto L19;
        Toast r105 = new Toast(r100);
        r105.setGravity(17, 0, 0);
        r105.setView(r103);
        r105.setDuration(0);
        r105.show();
        return;
    L19:
        Toast r106 = new Toast(r100);     // Catch: Throwable -> L18
        r106.setGravity(17, 0, 0);     // Catch: Throwable -> L18
        r106.setView(r103);     // Catch: Throwable -> L18
        r106.setDuration(0);     // Catch: Throwable -> L18
        r106.show();     // Catch: Throwable -> L18
        return;
    L26:
        return;
    L23:
        return;
    L10:
        if ((System.currentTimeMillis() - f475993d) >= CustomToast.LENGTH_SHORT) goto L11;
    }
}
