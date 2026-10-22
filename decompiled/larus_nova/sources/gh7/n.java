package gh7;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public final class n implements dh7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f481302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f481303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f481304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f481305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f481306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f481307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f481308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f481309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Set<String> f481310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f481311j;

    public n() {
        throw null;
    }

    public n(Throwable r100, String r101, String r102, Map r103, Map r104, String r105, String r106, Set r107, List r110, int r111) {
        if ((r111 & 8) == 0) goto L6;
        r103 = new LinkedHashMap();
    L6:
        if ((r111 & 16) == 0) goto L9;
        r104 = new LinkedHashMap();
    L9:
        if ((r111 & 64) == 0) goto L12;
        r105 = "";
    L12:
        if ((r111 & 128) == 0) goto L15;
        r106 = "Unknown";
    L15:
        if ((r111 & 256) == 0) goto L18;
        r107 = new LinkedHashSet();
    L18:
        if ((r111 & 512) == 0) goto L20;
        r110 = new ArrayList();
    L20:
        this.f481302a = r100;
        this.f481303b = r101;
        this.f481304c = r102;
        this.f481305d = r103;
        this.f481306e = r104;
        this.f481307f = null;
        this.f481308g = r105;
        this.f481309h = r106;
        this.f481310i = r107;
        this.f481311j = r110;
    }
}
