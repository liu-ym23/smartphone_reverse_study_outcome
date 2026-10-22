package vjc;

import com.ss.bytertc.engine.video.IVideoFrame;

/* JADX INFO: loaded from: classes40.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IVideoFrame f555453a;

    public /* synthetic */ a(IVideoFrame r100) {
        this.f555453a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f555453a.releaseRef();
    }
}
