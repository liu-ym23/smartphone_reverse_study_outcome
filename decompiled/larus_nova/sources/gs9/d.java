package gs9;

import kotlin.jvm.internal.Intrinsics;
import zp9.m;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f482469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f482470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f482471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f482472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f482473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f482474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f482475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f482476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f482477i;

    public /* synthetic */ d(e r110, a r111, f r112, b r113, m r114, int r115) {
        String r100 = null;
        if ((r115 & 1) == 0) goto L5;
        e r101 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        a r102 = null;
    L11:
        if ((r115 & 4) == 0) goto L13;
        f r103 = null;
    L15:
        if ((r115 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r115 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r115 & 32) == 0) goto L25;
        b r106 = null;
    L27:
        if ((r115 & 64) == 0) goto L29;
        m r116 = null;
    L31:
        if ((r115 & 128) == 0) goto L33;
        String r117 = "ugc_video";
    L35:
        if ((r115 & 256) == 0) goto L37;
        r100 = "immersive_preview";
    L37:
        this(r101, r102, r103, r104, r105, r106, r116, r117, r100);
        return;
    L33:
        r117 = null;
        goto L35
    L29:
        r116 = r114;
        goto L31
    L25:
        r106 = r113;
        goto L27
    L21:
        r105 = true;
        goto L23
    L17:
        r104 = true;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public d(e r100, a r101, f r102, boolean r103, boolean r104, b r105, m r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r107, "detailVideoEngineTag");
        Intrinsics.checkNotNullParameter(r110, "detailVideoEngineSubTag");
        this.f482469a = r100;
        this.f482470b = r101;
        this.f482471c = r102;
        this.f482472d = r103;
        this.f482473e = r104;
        this.f482474f = r105;
        this.f482475g = r106;
        this.f482476h = r107;
        this.f482477i = r110;
    }
}
