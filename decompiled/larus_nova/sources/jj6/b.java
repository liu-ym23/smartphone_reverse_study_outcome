package jj6;

import com.bytedance.live.livelink.kmp.api.base.video.VideoDataType;
import kotlin.jvm.internal.Intrinsics;
import qi6.e;

/* JADX INFO: loaded from: classes19.dex */
public class b extends yi6.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f499338f;

    public static final class a {
    }

    static {
    }

    public void a(qi6.a r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r100, "videoFrame");
        Intrinsics.checkNotNullParameter(r101, "extraDatas");
    }

    @Override // qi6.f
    public final String getName() {
        return this.f499338f;
    }

    @Override // yi6.b, qi6.f
    public void i() {
        e.f(this);
    }

    @Override // yi6.b, qi6.f
    public final void init() {
        e.a(this);
    }

    @Override // yi6.b, qi6.f
    public final void pause() {
        e.b(this);
    }

    @Override // yi6.b, qi6.f
    public void release() {
        e.d(this);
    }

    @Override // yi6.b, qi6.f
    public final void resume() {
        e.e(this);
    }

    @Override // yi6.b, qi6.f
    public void stop() {
        e.g(this);
    }

    public b(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        super(r100);
        this.f499338f = "VideoPublishPushNode";
    }

    @Override // yi6.b, qi6.f
    public final void m(qi6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        VideoDataType r101 = r100.getType();
        int r102 = c.f499339a[r101.ordinal()];
        Object r103 = null;
        if (r102 != 1) goto L5;
        Object r104 = r100.f533157g.get("extra_datas");
        if ((r104 instanceof Object[]) == false) goto L21;
        r103 = r104;
    L21:
        Object[] r105 = (Object[]) r103;
        if (r105 != null) goto L24;
        r105 = new Object[0];
    L24:
        a(r100, r105);
        return;
    L5:
        if (r102 != 2) goto L7;
    L9:
        Object r106 = r100.f533157g.get("extra_datas");
        if ((r106 instanceof Object[]) == false) goto L13;
        r103 = r106;
    L13:
        Object[] r107 = (Object[]) r103;
        if (r107 != null) goto L16;
        r107 = new Object[0];
    L16:
        a(r100, r107);
        return;
    L7:
        if (r102 == 3) goto L9;
    }
}
