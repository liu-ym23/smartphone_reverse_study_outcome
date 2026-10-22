package o50;

import com.ss.texturerender.VideoSurfaceTexture;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f522032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, a> f522033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Integer> f522034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f522035d;

    public final void b() {
        int r100 = this.f522032a;
        if (r100 == (-1)) goto L10;
        a r101 = this.f522033b.get(Integer.valueOf(r100));
        if (r101 == null) goto L8;
        r101.unbind();
    L8:
        this.f522032a = -1;
        return;
    }

    public b() {
        this.f522032a = -1;
        this.f522033b = new HashMap();
        this.f522034c = new HashMap();
    }

    public final int a(u50.a r100) {
        Intrinsics.checkNotNullParameter(r100, VideoSurfaceTexture.KEY_TEXTURE);
        boolean r101 = true;
        int r102 = this.f522035d + 1;
        this.f522035d = r102;
        this.f522033b.put(Integer.valueOf(r102), r100);
        if (r100.f548758a.length() > 0) goto L6;
        r101 = false;
    L6:
        if (r101 == false) goto L8;
        this.f522034c.put(r100.f548758a, Integer.valueOf(r102));
    L8:
        return r102;
    }
}
