package zr2;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdk.revenue.toolbar.BubbleOpenLocalPanel;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a5 f573370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f573372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final py.k f573373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final py.k f573374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f573375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f573376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f573377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f573378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BubbleOpenLocalPanel f573379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f573380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final py.k f573381m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final py.k f573382n;

    public static final class a {
    }

    static {
    }

    public e() {
        throw null;
    }

    public final String toString() {
        return "IconBubbleCommand(scheme=" + this.f573371c + ", duration=" + this.f573372d + ", actionType=" + this.f573375g + ", messageType=" + this.f573376h + ')';
    }

    public e(String r110, a5 r111, String r112, int r113, py.k r210, py.k r211, int r212, int r213, Map r214, int r215, BubbleOpenLocalPanel r216, String r217, py.k r218, py.k r219, int r310) {
        py.k r100 = null;
        if ((r310 & 2) == 0) goto L5;
        a5 r101 = null;
    L7:
        if ((r310 & 4) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r310 & 8) == 0) goto L13;
        int r103 = 5;
    L15:
        if ((r310 & 16) == 0) goto L17;
        py.k r104 = null;
    L19:
        if ((r310 & 32) == 0) goto L21;
        py.k r105 = null;
    L22:
        int r106 = 0;
        if ((r310 & 64) == 0) goto L25;
        int r107 = 0;
    L27:
        if ((r310 & 128) != 0) goto L31;
        r106 = r213;
    L31:
        if ((r310 & 256) == 0) goto L33;
        Map r114 = MapsKt.emptyMap();
    L35:
        if ((r310 & 512) == 0) goto L37;
        int r115 = 1;
    L39:
        if ((r310 & 1024) == 0) goto L41;
        BubbleOpenLocalPanel r116 = null;
    L43:
        if ((r310 & 2048) == 0) goto L45;
        String r117 = null;
    L47:
        if ((r310 & 4096) == 0) goto L49;
        py.k r118 = null;
    L51:
        if ((r310 & 8192) != 0) goto L54;
        r100 = r219;
    L54:
        this.f573369a = r110;
        this.f573370b = r101;
        this.f573371c = r102;
        this.f573372d = r103;
        this.f573373e = r104;
        this.f573374f = r105;
        this.f573375g = r107;
        this.f573376h = r106;
        this.f573377i = r114;
        this.f573378j = r115;
        this.f573379k = r116;
        this.f573380l = r117;
        this.f573381m = r118;
        this.f573382n = r100;
        return;
    L49:
        r118 = r218;
        goto L51
    L45:
        r117 = r217;
        goto L47
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L25:
        r107 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L22
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
