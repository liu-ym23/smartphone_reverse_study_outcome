package xi4;

import com.facebook.drawee.backends.pipeline.Fresco;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f563924a = null;

    static {
        f563924a = new a();
    }

    public a() {
    }

    @Override // xi4.b
    public final void a() {
        if (Fresco.getImagePipeline().isPaused() == false) goto L6;
        Fresco.getImagePipeline().resume();
        return;
    }

    @Override // xi4.b
    public final void b() {
        if (Fresco.getImagePipeline().isPaused() == true) goto L6;
        Fresco.getImagePipeline().pause();
        return;
    }
}
