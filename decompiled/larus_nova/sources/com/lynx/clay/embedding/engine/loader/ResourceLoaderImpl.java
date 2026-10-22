package com.lynx.clay.embedding.engine.loader;

/* JADX INFO: loaded from: classes32.dex */
public class ResourceLoaderImpl extends ResourceLoader {
    static String LOADER_EMPTY_ERR = "The resource Loader is not configured on the service side";
    static c sProvider;
    FrescoImageLoader mImageLoader;
    b mLoader;

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f380741a;

        public a(b r100) {
            this.f380741a = r100;
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract void cancelAll(boolean r100);

        public void load(int r100, String r101, ResourceLoaderCallback r102, boolean r103, boolean r104) {
        }

        public void loadAsFile(String r100, d r101, boolean r102) {
        }
    }

    public interface c {
    }

    public static ResourceLoaderImpl create() {
        return new ResourceLoaderImpl();
    }

    public ResourceLoaderImpl() {
        b r100 = null;
        this.mLoader = null;
        this.mImageLoader = null;
        c r101 = sProvider;
        if (r101 == null) goto L5;
        r100 = ((a) r101).f380741a;
    L5:
        this.mLoader = r100;
    }

    public static void SetResourceLoader(b r100) {
        sProvider = new a(r100);
    }

    public static void SetResourceLoaderProvider(c r100) {
        sProvider = r100;
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoader
    public void cancelAll(boolean r100) {
        FrescoImageLoader r101 = this.mImageLoader;
        if (r101 == null) goto L5;
        r101.cancelAll(r100);
    L5:
        b r102 = this.mLoader;
        if (r102 == null) goto L9;
        r102.cancelAll(r100);
        return;
    }

    public void loadAsFile(String r100, d r101, boolean r102) {
        b r103 = this.mLoader;
        if (r103 == null) goto L5;
        r103.loadAsFile(r100, r101, r102);
        return;
    L5:
        h5a.a r104 = (h5a.a) r101;
        r104.a(LOADER_EMPTY_ERR);
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoader
    public void load(int r100, String r101, ResourceLoaderCallback r102, boolean r110, boolean r111) {
        b r103 = this.mLoader;
        if (r103 == null) goto L5;
        r103.load(r100, r101, r102, r110, r111);
        return;
    L5:
        r102.onFailed(LOADER_EMPTY_ERR);
    }
}
