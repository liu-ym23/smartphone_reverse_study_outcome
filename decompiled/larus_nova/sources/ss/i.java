package ss;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import com.bytedance.common.utility.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, b> f543314a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f543315b = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f543316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f543317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f543318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f543319d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f543320e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f543321f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f543322g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f543323h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f543324i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f543325j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public TimeInterpolator f543326k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f543327l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f543328m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f543329n;

        public a(Context r100) {
            this.f543318c = -2;
            this.f543319d = -2;
            this.f543322g = 3;
            this.f543325j = 300;
            this.f543327l = i.f543315b;
            this.f543329n = false;
            this.f543316a = r100;
        }
    }

    static {
        f543314a = new HashMap();
        f543315b = "live_default_window";
    }

    public static b a() {
        if (StringUtils.isEmpty("install_guide") == false) goto L7;
        return null;
    L7:
        return (b) ((HashMap) f543314a).get("install_guide");
    }
}
