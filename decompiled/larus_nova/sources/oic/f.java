package oic;

import android.content.Context;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import nic.p;

/* JADX INFO: loaded from: classes40.dex */
public final class f implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qic.a f523503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nic.e f523504b;

    @Override // nic.p
    public final PlaybackParams a() {
        qic.a r100 = this.f523503a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // nic.p
    public final VideoInfo b() {
        qic.a r100 = this.f523503a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    @Override // nic.p
    public final long d() {
        qic.a r100 = this.f523503a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.d();
    }

    public final VideoModel e() {
        qic.a r100 = this.f523503a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getVideoModel();
    }

    @Override // nic.p
    public final TTVideoEngine f() {
        qic.a r100 = this.f523503a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f();
    }

    public final boolean g() {
        qic.a r100 = this.f523503a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.y() == false) goto L7;
        return true;
    }

    @Override // nic.p
    public Context getContext() {
        nic.e r100 = this.f523504b;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getContext();
    }

    @Override // nic.p
    public final int getCurrentPosition() {
        qic.a r100 = this.f523503a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCurrentPosition();
    }

    @Override // nic.p
    public final int getDuration() {
        qic.a r100 = this.f523503a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getDuration();
    }

    @Override // nic.p
    public final Resolution getResolution() {
        qic.a r100 = this.f523503a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getResolution();
    }

    @Override // nic.p
    public final boolean isPlaying() {
        qic.a r100 = this.f523503a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isPlaying() == false) goto L7;
        return true;
    }

    @Override // nic.p
    public final VideoEngineInfos c(String r100) {
        qic.a r101 = this.f523503a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.c(r100);
    }

    public f(qic.a r100, nic.e r101) {
        this.f523503a = r100;
        this.f523504b = r101;
    }
}
