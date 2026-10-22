package hl;

import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f485647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<CartNumWithBusinessLine> f485648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f485649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f485650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f485651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f485652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f485653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f485654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f485655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JSONObject f485656k;

    public l(int r100, String r101, List r102, boolean r103, i73.a r104, boolean r105, boolean r110, String r111, String r112, JSONObject r113, int r114) {
        if ((r114 & 4) == 0) goto L6;
        r101 = null;
    L6:
        if ((r114 & 16) == 0) goto L9;
        r102 = null;
    L9:
        if ((r114 & 32) == 0) goto L12;
        r103 = false;
    L12:
        if ((r114 & 64) == 0) goto L15;
        r104 = null;
    L15:
        if ((r114 & 128) == 0) goto L18;
        r105 = false;
    L18:
        if ((r114 & 512) == 0) goto L21;
        r110 = false;
    L21:
        if ((r114 & 1024) == 0) goto L24;
        r111 = null;
    L24:
        if ((r114 & 2048) == 0) goto L27;
        r112 = null;
    L27:
        if ((r114 & 4096) == 0) goto L29;
        r113 = null;
    L29:
        this.f485646a = r100;
        this.f485647b = r101;
        this.f485648c = r102;
        this.f485649d = r103;
        this.f485650e = r104;
        this.f485651f = r105;
        this.f485652g = null;
        this.f485653h = r110;
        this.f485654i = r111;
        this.f485655j = r112;
        this.f485656k = r113;
    }
}
