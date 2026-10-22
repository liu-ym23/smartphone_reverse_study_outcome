package pl.droidsonroids.gif;

import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public abstract class j {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f529738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f529739b;

        @Override // pl.droidsonroids.gif.j
        public final GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f529738a.openFd(this.f529739b));
        }

        public a(AssetManager r100, String r101) {
            this.f529738a = r100;
            this.f529739b = r101;
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f529740a;

        @Override // pl.droidsonroids.gif.j
        public final GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.f529740a);
        }

        public b(String r100) {
            this.f529740a = r100;
        }
    }

    public static class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f529741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f529742b;

        @Override // pl.droidsonroids.gif.j
        public final GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.f529741a.openRawResourceFd(this.f529742b));
        }

        public c(Resources r100, int r101) {
            this.f529741a = r100;
            this.f529742b = r101;
        }
    }

    public abstract GifInfoHandle a() throws IOException;

    public j() {
    }
}
