package ts6;

import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.media.o0;
import com.larus.media.v;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import lk9.g;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f547406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f547407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.larus.media.model.a f547408c = null;

    public static final class a implements v {
        public a() {
        }

        @Override // com.larus.media.v
        public final boolean b(g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            Map<String, o0.a> r101 = o0.f359131a;
            return o0.a(MediaScene.LOCAL_LIFE_VIDEO, r100.getScene());
        }

        @Override // com.larus.media.v
        public final void e(g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            v.a.d(r100);
            f r101 = c.f547407b;
            if (r101 == null) goto L5;
            r101.onInterrupt();
        L5:
            c.f547407b = null;
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            v.a.f(r100, r101);
            f r102 = c.f547407b;
            if (r102 == null) goto L6;
            r102.b(r101);
            return;
        }

        @Override // com.larus.media.v
        public final void d(g r100, g r101) {
            v.a.c(r100, r101);
        }

        @Override // com.larus.media.v
        public final void g(g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            v.a.g(r100, r101);
            f r102 = c.f547407b;
            if (r102 == null) goto L6;
            r102.a(r101);
            return;
        }

        @Override // com.larus.media.v
        public final void i(g r100, g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            v.a.e(r100, r101);
            f r102 = c.f547407b;
            if (r102 == null) goto L6;
            r102.onPause();
            return;
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(g r100, g r101, int r102) {
            return v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(g r100, g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            Map<String, o0.a> r103 = o0.f359131a;
            return o0.b(MediaScene.LOCAL_LIFE_VIDEO, r101.getScene());
        }
    }

    public c() {
    }

    static {
        f547406a = new c();
        f547408c = new com.larus.media.model.a(null, MediaScene.LOCAL_LIFE_VIDEO, false, 0, 2, false, 0, false, false, 0, false, new a(), DataLoaderHelper.DATALOADER_KEY_STRING_PRECISE_PRELOAD_CONFIG);
    }

    @Override // ts6.d
    public final void a() {
        Intrinsics.checkNotNullParameter(MediaScene.LOCAL_LIFE_VIDEO, "scene");
        if (Intrinsics.areEqual(MediaScene.LOCAL_LIFE_VIDEO, MediaScene.LOCAL_LIFE_VIDEO) == true) goto L5;
        return;
    L5:
        Lazy r100 = MediaResourceManager.f358950a;
        MediaResourceManager.a(f547408c);
        f547407b = null;
    }

    @Override // ts6.d
    public final void b(f r100, final e r101) {
        Intrinsics.checkNotNullParameter(MediaScene.LOCAL_LIFE_VIDEO, "scene");
        if (Intrinsics.areEqual(MediaScene.LOCAL_LIFE_VIDEO, MediaScene.LOCAL_LIFE_VIDEO) == true) goto L7;
        if (r101 == null) goto L9;
        r101.onResult(false);
        return;
    L9:
        return;
    L7:
        f547407b = r100;
        Lazy r102 = MediaResourceManager.f358950a;
        MediaResourceManager.m(f547408c, new ts6.a(r101), new b(r101), 0, 8);
    }
}
