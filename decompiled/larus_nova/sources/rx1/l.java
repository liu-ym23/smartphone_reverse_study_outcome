package rx1;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, b> f539781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f539782b = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f539783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f539784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f539785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f539786d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f539787e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f539788f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f539789g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f539790h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f539791i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f539792j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f539793k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f539794l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f539795m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f539796n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f539797o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public TimeInterpolator f539798p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f539799q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f539800r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public e f539801s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f539802t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f539803u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final String f539804v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final int f539805w;

        public final void a() {
            Map<String, b> r100 = l.f539781a;
            HashMap r101 = (HashMap) r100;
            if (r101.containsKey(this.f539799q) == false) goto L6;
            Logger.e("LiveFloatWindowManager", "Float window has been added!");
            return;
        L6:
            View r102 = this.f539784b;
            if (r102 != null) goto L10;
            Logger.e("LiveFloatWindowManager", "view can not be null!");
            return;
        L10:
            if (r102 != null) goto L12;
            this.f539784b = ((LayoutInflater) this.f539783a.getSystemService("layout_inflater")).inflate(0, null);
        L12:
            g r103 = new g(this);
            HashMap r104 = (HashMap) r100;
            r104.put(this.f539799q, r103);
        }

        public a(Context r100) {
            this.f539785c = -2;
            this.f539786d = -2;
            this.f539787e = 3;
            this.f539796n = true;
            this.f539797o = 300;
            this.f539799q = l.f539782b;
            this.f539802t = false;
            this.f539804v = "";
            this.f539805w = -1;
            this.f539783a = r100;
        }
    }

    static {
        f539781a = new HashMap();
        f539782b = "live_default_window";
    }

    public static b a(String r100) {
        if (StringUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return (b) ((HashMap) f539781a).get(r100);
    }
}
