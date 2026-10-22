package gr7;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import dr7.b;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f482366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f482367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f482368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f482369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f482370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f482371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f482372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f482373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f482374i;

    /* JADX INFO: renamed from: gr7.a$a, reason: collision with other inner class name */
    public static class C6060a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f482375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f482376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f482377c;

        public C6060a() {
            this.f482376b = "zh";
        }
    }

    public a(C6060a r100) {
        this.f482373h = 1000;
        this.f482366a = r100.f482375a;
        this.f482367b = r100.f482376b;
        this.f482368c = null;
        this.f482369d = null;
        this.f482370e = null;
        a(r100.f482377c);
        this.f482372g = null;
        this.f482373h = 1000;
        this.f482374i = null;
    }

    public final void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        this.f482371f = r100;
        return;
    L5:
        if (r100.length() <= 0) goto L9;
        if (r100.endsWith(HTTP.URL_DEFAULT) == false) goto L9;
        r100 = r100.substring(0, r100.length() - 1);
        goto L9
    }
}
