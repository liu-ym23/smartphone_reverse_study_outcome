package l2a;

import com.larus.video.impl.VideoDetailAdapter;
import com.larus.video.impl.widget.VideoView;

/* JADX INFO: loaded from: classes32.dex */
public final class t implements VideoView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoDetailAdapter f507186a;

    @Override // com.larus.video.impl.widget.VideoView.a
    public final void onPause() {
        VideoView.a r100 = this.f507186a.f375685g;
        if (r100 == null) goto L6;
        r100.onPause();
        return;
    }

    @Override // com.larus.video.impl.widget.VideoView.a
    public final void onPlay() {
        VideoView.a r100 = this.f507186a.f375685g;
        if (r100 == null) goto L6;
        r100.onPlay();
        return;
    }

    public t(VideoDetailAdapter r100) {
        this.f507186a = r100;
    }
}
