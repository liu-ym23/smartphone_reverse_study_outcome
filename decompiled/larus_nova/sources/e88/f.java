package e88;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.audioplayer.impl.music.a f471377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IVideoController f471378b;

    public f(com.larus.audioplayer.impl.music.a r100, IVideoController r101) {
        this.f471377a = r100;
        this.f471378b = r101;
    }

    @Override // com.larus.platform.api.l4
    public final void a(String r100, com.larus.video.impl.sdk.a r101) {
        if (r101 != null) goto L7;
        this.f471377a.f290269d = true;
        this.f471378b.release();
        return;
    L7:
        if (this.f471377a.f290270e == false) goto L10;
        FLogger.f375446a.i("MusicPlayEngine", "ignore videoModel ready after background audio takeover, musicId:" + this.f471377a.f290266a.f2189a);
        this.f471378b.release();
        return;
    L10:
        this.f471378b.j(r101, false);
        com.larus.audioplayer.impl.music.a r102 = this.f471377a;
        r102.f290268c = true;
        b r103 = r102.f290278m;
        if (r103 == null) goto L14;
        r103.run();
        return;
    }
}
