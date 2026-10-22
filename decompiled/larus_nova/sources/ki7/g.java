package ki7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mi7.h;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f503645a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f503646b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f503647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f503648d;

    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            if (r100.what != 37) goto L10;
            Object r101 = r100.obj;
            if ((r101 instanceof String) == true) goto L7;
            return;
        L7:
            if ("deep_link_settings_id".equals(r101.toString()) == false) goto L12;
            String r102 = g.f503645a;
            mi7.e.a(r102, "updating settings regularly");
            mi7.e.a(r102, "start to update Settings");
            h.b(new e());
            return;
        L12:
            return;
        }
    }

    public g() {
    }

    static {
        f503645a = g.class.getCanonicalName();
        f503646b = new a();
        f503647c = 0;
        f503648d = false;
    }

    public static void a(long r100) {
        mi7.e.c(f503645a, "postDelayUpdateTask()....");
        a r101 = f503646b;
        r101.removeMessages(37, "deep_link_settings_id");
        Message r102 = Message.obtain();
        r102.obj = "deep_link_settings_id";
        r102.what = 37;
        r101.sendMessageDelayed(r102, r100 * 1000);
    }
}
