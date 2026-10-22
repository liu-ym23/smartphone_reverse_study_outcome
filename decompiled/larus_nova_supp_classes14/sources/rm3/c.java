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
import com.bytedance.android.livesdk.utils.LiveLoggerUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static String a;
    public static long b;
    public static String c;
    public static long d;
    public static final c e = null;

    public c() {
    }

    static {
        e = new c();
    }

    private final Activity getActivity(Context r3) {
    L3:
        if (r3 == null) goto L15;
        if ((r3 instanceof Activity) == true) goto L7;
        if ((r3 instanceof ContextWrapper) == true) goto L11;
        r3 = null;
    L11:
        ContextWrapper r4 = (ContextWrapper) r3;
        if (r4 != null) goto L13;
        r3 = null;
        goto L3
    L13:
        r3 = r4.getBaseContext();
        goto L3
    L7:
        return (Activity) r3;
    L15:
        return null;
    }

    public static void c(Context r1, String r2, Drawable r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r3, "img");
        if (r1 == null) goto L6;
        a(r1, r2, r3, 0, false);
        return;
    }

    public static void d(Context r1, int r2, int r3) {
        if (r1 == null) goto L5;
        a(r1, r1.getString(r2), r1.getResources().getDrawable(r3), 0, false);
        return;
    }

    public static void f(Context r1, int r2, boolean r3, int r4) {
        if ((r4 & 8) == 0) goto L5;
        r3 = false;
    L5:
        if (r1 == null) goto L8;
        b(r1, r1.getString(r2), 0, r3, false);
        return;
    }

    public static void a(Context r5, String r6, Drawable r7, int r8, boolean r9) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r6, c)) == false) goto L8;
    L9:
        c = r6;
        d = System.currentTimeMillis();
        View r0 = LayoutInflater.from(r5).inflate(2131568119, null);
        if (r0 == null) goto L20;
        ImageView r1 = (ImageView) r0.findViewById(2131388948);
        ((TextView) r0.findViewById(2131388953)).setText(r6);
        r1.setImageDrawable(r7);
        c r10 = e;
        if (NotificationManagerCompat.from(r5).areNotificationsEnabled() == false) goto L14;
        Toast r11 = new Toast(r5);
        r11.setGravity(17, 0, 0);
        r11.setView(r0);
        r11.setDuration(r8);
        r11.show();
        LiveLoggerUtil.b.getClass();
        LiveLoggerUtil.a(r6);
        return;
    L14:
        if (r9 == false) goto L22;
        Activity r12 = r10.getActivity(r5);
        if (r12 == null) goto L23;
        new a(r12, r0).b();
        LiveLoggerUtil.b.getClass();
        LiveLoggerUtil.a(r6);
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L8:
        if ((System.currentTimeMillis() - d) >= 2500) goto L9;
    }

    public static void b(Context r5, String r6, int r7, boolean r8, boolean r9) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r6, a)) == false) goto L8;
    L9:
        a = r6;
        b = System.currentTimeMillis();
        if (r9 == false) goto L12;
        int r10 = 2131954910;
    L13:
        TextView r0 = new TextView(new ContextThemeWrapper(r5, r10));
        r0.setBackground(r5.getResources().getDrawable(2131256366));
        r0.setText(r6);
        c r11 = e;
        if (NotificationManagerCompat.from(r5).areNotificationsEnabled() == false) goto L16;
        Toast r12 = new Toast(r5);
        r12.setGravity(17, 0, 0);
        r12.setView(r0);
        r12.setDuration(r7);
        r12.show();
        LiveLoggerUtil.b.getClass();
        LiveLoggerUtil.a(r6);
        return;
    L16:
        if (r8 == false) goto L23;
        Activity r13 = r11.getActivity(r5);
        if (r13 == null) goto L24;
        new a(r13, r0).b();
        LiveLoggerUtil.b.getClass();
        LiveLoggerUtil.a(r6);
        return;
    L24:
        return;
    L23:
        return;
    L12:
        r10 = 2131954909;
        goto L13
    L8:
        if ((System.currentTimeMillis() - b) >= 2500) goto L9;
    }

    public static void e(Context r1, String r2, int r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (r1 == null) goto L6;
        b(r1, r2, r3, r4, r5);
        return;
    }

    public static /* synthetic */ void g(Context r2, String r3, int r4, boolean r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = false;
    L8:
        e(r2, r3, r4, r5, false);
    }
}
