package pz6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.lottie.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f531121f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f531122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, k> f531124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f531125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f531126e;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f531127a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            if (r100.what != 1) goto L8;
            b r101 = this.f531127a.get();
            if (r101 == null) goto L9;
            r101.b();
            return;
        L9:
            return;
        }

        public a(b r100, Looper r101) {
            super(r101);
            this.f531127a = new WeakReference(r100);
        }
    }

    static {
        f531121f = new Object();
    }

    public final void b() {
        this.f531126e.removeMessages(1);
        Object r100 = f531121f;
        monitor-enter(r100);
        Iterator<Map.Entry<String, k>> r101 = this.f531124c.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r101.hasNext() == false) goto L10;
        k r102 = r101.next().getValue();     // Catch: Throwable -> L12
        Bitmap r103 = r102.f264454b;     // Catch: Throwable -> L12
        if (r103 == null) goto L6;
        r103.recycle();     // Catch: Throwable -> L12
        r102.f264454b = null;     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void a(String r100, Bitmap r101) {
        Object r102 = f531121f;
        monitor-enter(r102);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (((HashSet) this.f531125d).contains(r100) == true) goto L7;
        this.f531124c.get(r100).f264454b = r101;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
    }

    public b(Drawable.Callback r100, String r101, Map r102) {
        this.f531125d = new HashSet();
        this.f531123b = r101;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        if (r101.charAt(r101.length() - 1) == '/') goto L8;
        this.f531123b = r101.concat(HTTP.URL_DEFAULT);
    L8:
        if ((r100 instanceof View) == true) goto L11;
        this.f531124c = new HashMap();
        this.f531122a = null;
        return;
    L11:
        this.f531122a = ((View) r100).getContext();
        this.f531124c = r102;
        this.f531126e = new a(this, Looper.getMainLooper());
    }
}
