package s37;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.camera.video.AudioStats;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.utility.Logger;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends s37.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Toast f540500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f540501o;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f540502a;

        public final void a() {
            e r100 = this.f540502a;     // Catch: Throwable -> L9
            r100.f540500n = new Toast(this.f540502a.f540480a);     // Catch: Throwable -> L9
            e r101 = this.f540502a;     // Catch: Throwable -> L9
            r101.f540501o = e.g(r101);     // Catch: Throwable -> L9
            e r102 = this.f540502a;     // Catch: Throwable -> L9
            if (r102.f540501o == true) goto L6;
            return;
        L6:
            if (r102.f540482c.f266062v <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
            r102.f540500n.setDuration(1);     // Catch: Throwable -> L9
            this.f540502a.f540500n.show();     // Catch: Throwable -> L9
            e r103 = this.f540502a;     // Catch: Throwable -> L9
            r103.f540492m.sendEmptyMessageDelayed(3111802, (long) (r103.f540482c.f266062v * 1000.0d));     // Catch: Throwable -> L9
            return;
        L14:
            return;
        L9:
            th = move-exception;
            Logger.e("ToastBannerNotification", th.getMessage());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e r100) {
            this.f540502a = r100;
        }
    }

    @Override // t37.a
    public final PendingIntent a(Context r100) {
        return null;
    }

    public static boolean g(e r100) {
        r100.getClass();
        boolean r101 = false;
        r100.f540500n.setGravity(49, 0, r100.f540487h);     // Catch: Throwable -> L13
        r100.f540500n.setView(r100.f540484e);     // Catch: Throwable -> L13
        r101 = true;
        Toast r102 = r100.f540500n;     // Catch: Throwable -> L11
        Field r103 = r102.getClass().getDeclaredField("mTN");     // Catch: Throwable -> L11
        r103.setAccessible(true);     // Catch: Throwable -> L11
        Object r104 = r103.get(r102);     // Catch: Throwable -> L11
        if (r104 == null) goto L12;
        Field r105 = r104.getClass().getDeclaredField("mParams");     // Catch: Throwable -> L11
        r105.setAccessible(true);     // Catch: Throwable -> L11
        Object r106 = r105.get(r104);     // Catch: Throwable -> L11
        if ((r106 instanceof WindowManager.LayoutParams) == false) goto L12;
        ((WindowManager.LayoutParams) r106).flags = 136;     // Catch: Throwable -> L11
    L11:
        x37.b.a("ToastBannerNotification", "initToast: reflection failure");
    L12:
        return r101;
    }

    @Override // s37.a
    public final void d(Message r100) {
        if (r100.what != 3111802) goto L8;
        Toast r101 = this.f540500n;
        if (r101 == null) goto L9;
        r101.cancel();
        return;
    L9:
        return;
    }

    @Override // s37.a
    public final void c(boolean r100, int r101) {
        Toast r102 = this.f540500n;
        if (r102 == null) goto L6;
        r102.cancel();
        return;
    }

    @Override // s37.a
    public final void f(String r100, int r101) {
        this.f540485f = r100;
        this.f540486g = r101;
        if (this.f540484e != null) goto L5;
        return;
    L5:
        this.f540492m.post(new a(this));
    }

    public e(Context r100, Notification.Builder r101, Intent r102, PushNotificationExtra r103, NotificationBody r104) {
        super(r100, r101, r102, r103, r104);
    }
}
