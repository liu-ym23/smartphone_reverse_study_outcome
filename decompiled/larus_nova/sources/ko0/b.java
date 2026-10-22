package ko0;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f504345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f504346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f504347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f504348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f504349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f504350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f504351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f504352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f504353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f504354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f504355k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f504356l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<String> f504357m;

    public b(String r110, String r111, String r112, String r210, String r211, String r212, Map r213, Map r214, Map r215, boolean r216, boolean r217, List r218, int r219) {
        String r100 = "";
        if ((r219 & 8) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r219 & 16) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r219 & 32) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r219 & 64) == 0) goto L17;
        Object r104 = "";
    L19:
        if ((r219 & 128) == 0) goto L21;
        Map r113 = new LinkedHashMap();
    L23:
        if ((r219 & 256) != 0) goto L27;
        r100 = null;
    L27:
        if ((r219 & 512) == 0) goto L29;
        Map r114 = new LinkedHashMap();
    L31:
        if ((r219 & 1024) == 0) goto L33;
        Map r115 = new LinkedHashMap();
    L34:
        boolean r116 = false;
        if ((r219 & 2048) == 0) goto L37;
        boolean r117 = false;
    L39:
        if ((r219 & 4096) != 0) goto L43;
        r116 = r217;
    L43:
        if ((r219 & 8192) == 0) goto L45;
        List r105 = new ArrayList();
    L46:
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r111, "launchFrom");
        Intrinsics.checkNotNullParameter(r112, "location");
        Intrinsics.checkNotNullParameter(r101, "entranceForm");
        Intrinsics.checkNotNullParameter(r102, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r103, "enterPosition");
        Intrinsics.checkNotNullParameter(r104, "anchorAction");
        Intrinsics.checkNotNullParameter(r113, "bdpLogExtra");
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r114, "queryExtra");
        Intrinsics.checkNotNullParameter(r115, "customFieldExtra");
        Intrinsics.checkNotNullParameter(r105, "serverScenes");
        this.f504345a = r110;
        this.f504346b = r111;
        this.f504347c = r112;
        this.f504348d = r101;
        this.f504349e = r102;
        this.f504350f = r103;
        this.f504351g = r113;
        this.f504352h = r100;
        this.f504353i = r114;
        this.f504354j = r115;
        this.f504355k = r117;
        this.f504356l = r116;
        this.f504357m = r105;
        return;
    L45:
        r105 = r218;
        goto L46
    L37:
        r117 = r216;
        goto L39
    L33:
        r115 = r215;
        goto L34
    L29:
        r114 = r214;
        goto L31
    L21:
        r113 = r213;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
