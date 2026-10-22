package t72;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.enteranim.EnterAnimWidget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f544877a = 0;

    /* JADX INFO: renamed from: t72.a$a, reason: collision with other inner class name */
    public static final class C7692a {
        public static String a(k r100) {
            Intrinsics.checkNotNullParameter(r100, "imageModel");
            List<String> r101 = r100.getUrls();
            Object r102 = null;
            if (r101 == null) goto L15;
            Iterator<T> r103 = r101.iterator();
        L6:
            if (r103.hasNext() == false) goto L11;
            Object r104 = r103.next();
            int r105 = a.f544877a;
            ImageRequest r106 = ImageRequest.fromUri((String) r104);
            CacheKey r107 = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(r106, null);
            if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(r107) == false) goto L6;
            r102 = r104;
        L11:
            return (String) r102;
        L15:
            return null;
        }
    }

    public static final class b extends BaseDataSubscriber<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f544878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f544879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f544880c;

        public final void a() {
            if (this.f544878a.isEmpty() == false) goto L5;
            ALogger.e("LocalImageProvider", "Failed to fetch resource " + this.f544879b.getUri());
            this.f544880c.getClass();
            return;
        L5:
            String r100 = (String) ListProtector.remove(this.f544878a, 0);
            ALogger.i("LocalImageProvider", "Trying alternative " + r100 + " of resource " + this.f544879b.getUri());
            Fresco.getImagePipeline().prefetchToDiskCache(ImageRequest.fromUri(r100), null).subscribe(this, UiThreadImmediateExecutorService.getInstance());
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<Void> r100) {
            if (r100 != null) goto L5;
        L7:
            ALogger.w("LocalImageProvider", "Alternative failed");
        L8:
            a();
            return;
        L5:
            if (r100.getFailureCause() == null) goto L7;
            ALogger.w("LocalImageProvider", "Alternative failed", r100.getFailureCause());
            goto L8
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<Void> r100) {
            Intrinsics.checkNotNull(r100);
            if (r100.isFinished() == false) goto L8;
            ALogger.i("LocalImageProvider", "Resource " + this.f544879b.getUri() + " fetched from network");
            EnterAnimWidget.d r101 = (EnterAnimWidget.d) this.f544880c;
            if (r101.f136591b.isViewValid() == false) goto L9;
            r101.f136591b.f136574b.b(r101.f136590a);
            return;
        L9:
            return;
        }

        public b(k r100, EnterAnimWidget.d r101) {
            Intrinsics.checkNotNullParameter(r100, "imageModel");
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f544879b = r100;
            this.f544880c = r101;
            List<String> r102 = r100.getUrls();
            if (r102 == null) goto L6;
            List<String> r103 = CollectionsKt.toMutableList(r102);
            if (r103 == null) goto L6;
        L7:
            this.f544878a = r103;
            return;
        L6:
            r103 = new ArrayList();
            goto L7
        }
    }

    public interface c {
    }

    static {
    }
}
