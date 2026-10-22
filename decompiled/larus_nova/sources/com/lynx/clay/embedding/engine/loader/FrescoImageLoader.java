package com.lynx.clay.embedding.engine.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public class FrescoImageLoader extends ResourceLoaderImpl.b {
    private static ArrayList<Integer> validEncodedType;
    private volatile boolean destroyed;
    private HashMap<ResourceLoaderCallback, DataSource<CloseableReference<PooledByteBuffer>>> pendingCallbacks;
    private HashMap<ResourceLoaderCallback, DataSource<CloseableReference<CloseableImage>>> pendingImages;

    public class a extends BaseBitmapDataSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f380728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ResourceLoaderCallback f380729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FrescoImageLoader f380730c;

        /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.loader.FrescoImageLoader$a$a, reason: collision with other inner class name */
        public class RunnableC4546a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Bitmap f380731a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f380732b;

            @Override // java.lang.Runnable
            public final void run() {
                Bitmap r100 = this.f380731a;     // Catch: Throwable -> L8
                if (r100 == null) goto L5;
                a r101 = this.f380732b;     // Catch: Throwable -> L8
                r101.f380729b.onSucceeded(FrescoImageLoader.access$000(r101.f380730c, r100));     // Catch: Throwable -> L8
            L6:
                a r102 = this.f380732b;     // Catch: Throwable -> L8
                r102.f380730c.removeImagePendingRequest(r102.f380729b);     // Catch: Throwable -> L8
                return;
            L5:
                this.f380732b.f380729b.onFailed("empty bitmap");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }

            public RunnableC4546a(a r100, Bitmap r101) {
                this.f380732b = r100;
                this.f380731a = r101;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DataSource f380733a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f380734b;

            public final void a() {
                if (this.f380733a.getFailureCause() == null) goto L5;
                this.f380734b.f380729b.onFailed(this.f380733a.getFailureCause().getMessage());
            L6:
                a r100 = this.f380734b;
                r100.f380730c.removeImagePendingRequest(r100.f380729b);
                return;
            L5:
                this.f380734b.f380729b.onFailed("");
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(a r100, DataSource r101) {
                this.f380734b = r100;
                this.f380733a = r101;
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            this.f380728a.post(new b(this, r100));
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public final void onNewResultImpl(Bitmap r100) {
            this.f380728a.post(new RunnableC4546a(this, r100));
        }

        public a(FrescoImageLoader r100, Handler r101, ResourceLoaderCallback r102) {
            this.f380730c = r100;
            this.f380728a = r101;
            this.f380729b = r102;
        }
    }

    public class b extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResourceLoaderCallback f380735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f380736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FrescoImageLoader f380737c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DataSource f380738a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f380739b;

            public final void a() {
                if (this.f380738a.getFailureCause() == null) goto L5;
                this.f380739b.f380735a.onFailed(this.f380738a.getFailureCause().getMessage());
            L6:
                b r100 = this.f380739b;
                r100.f380737c.removePendingRequest(r100.f380735a);
                return;
            L5:
                this.f380739b.f380735a.onFailed("");
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r100, DataSource r101) {
                this.f380739b = r100;
                this.f380738a = r101;
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r100) {
            this.f380736b.post(new a(this, r100));
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r100) {
            if (r100.isFinished() == true) goto L5;
            return;
        L5:
            CloseableReference<PooledByteBuffer> r101 = r100.getResult();
            if (r101 != null) goto L9;
            r100.close();
            return;
        L9:
            PooledByteBufferInputStream r102 = null;
            PooledByteBufferInputStream r103 = new PooledByteBufferInputStream(r101.get());     // Catch: Throwable -> L16
            byte[] r104 = new byte[r103.available()];     // Catch: Throwable -> L14
            r103.read(r104);     // Catch: Throwable -> L14
            this.f380735a.onSucceeded(r104);     // Catch: Throwable -> L14
            this.f380737c.removePendingRequest(this.f380735a);     // Catch: Throwable -> L14
            CloseableReference.closeSafely(r101);
            Closeables.closeQuietly(r103);
            return;
        L14:
            th = th;
            r102 = r103;
        L17:
            CloseableReference.closeSafely(r101);
            if (r102 == null) goto L20;
            Closeables.closeQuietly(r102);
        L20:
            throw th;
        L16:
            th = th;
            goto L17
        }

        public b(FrescoImageLoader r100, ResourceLoaderCallback r101, Handler r102) {
            this.f380737c = r100;
            this.f380735a = r101;
            this.f380736b = r102;
        }
    }

    static {
        validEncodedType = new ArrayList(Arrays.asList(new Integer[]{0, 2, 3, 4}));
    }

    public static FrescoImageLoader create() {
        return new FrescoImageLoader();
    }

    public FrescoImageLoader() {
        this.pendingCallbacks = new HashMap();
        this.pendingImages = new HashMap();
    }

    public static void Initialize(Context r100) {
        Fresco.initialize(r100);
    }

    private byte[] bitmapToByteArray(Bitmap r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        r100.compress(Bitmap.CompressFormat.PNG, 100, r101);
        return r101.toByteArray();
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl.b
    public void cancelAll(boolean r100) {
        if (this.destroyed == false) goto L5;
        return;
    L5:
        this.destroyed = r100;
        HashMap<ResourceLoaderCallback, DataSource<CloseableReference<PooledByteBuffer>>> r101 = this.pendingCallbacks;
        monitor-enter(r101);
        Iterator<DataSource<CloseableReference<PooledByteBuffer>>> r102 = this.pendingCallbacks.values().iterator();     // Catch: Throwable -> L29
    L9:
        if (r102.hasNext() == false) goto L13;
        DataSource<CloseableReference<PooledByteBuffer>> r103 = r102.next();     // Catch: Throwable -> L29
        if (r103 == null) goto L9;
        r103.close();     // Catch: Throwable -> L29
        goto L9
    L13:
        this.pendingCallbacks.clear();     // Catch: Throwable -> L29
        monitor-exit(r101);     // Catch: Throwable -> L29
        HashMap<ResourceLoaderCallback, DataSource<CloseableReference<CloseableImage>>> r104 = this.pendingImages;
        monitor-enter(r104);
        Iterator<DataSource<CloseableReference<CloseableImage>>> r105 = this.pendingImages.values().iterator();     // Catch: Throwable -> L26
    L19:
        if (r105.hasNext() == false) goto L23;
        DataSource<CloseableReference<CloseableImage>> r106 = r105.next();     // Catch: Throwable -> L26
        if (r106 == null) goto L19;
        r106.close();     // Catch: Throwable -> L26
        goto L19
    L23:
        this.pendingImages.clear();     // Catch: Throwable -> L26
        monitor-exit(r104);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    }

    public void removeImagePendingRequest(ResourceLoaderCallback r100) {
        HashMap<ResourceLoaderCallback, DataSource<CloseableReference<CloseableImage>>> r101 = this.pendingImages;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.pendingImages.containsKey(r100) == true) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L8:
        DataSource<CloseableReference<CloseableImage>> r102 = this.pendingImages.get(r100);     // Catch: Throwable -> L13
        this.pendingImages.remove(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        if (r102 == null) goto L17;
        r102.close();
        return;
    }

    public void removePendingRequest(ResourceLoaderCallback r100) {
        HashMap<ResourceLoaderCallback, DataSource<CloseableReference<PooledByteBuffer>>> r101 = this.pendingCallbacks;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.pendingCallbacks.containsKey(r100) == true) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L8:
        DataSource<CloseableReference<PooledByteBuffer>> r102 = this.pendingCallbacks.get(r100);     // Catch: Throwable -> L13
        this.pendingCallbacks.remove(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        if (r102 == null) goto L17;
        r102.close();
        return;
    }

    public static /* synthetic */ byte[] access$000(FrescoImageLoader r100, Bitmap r101) {
        return r100.bitmapToByteArray(r101);
    }

    private void loadDocodedImage(DataSource<CloseableReference<CloseableImage>> r100, ResourceLoaderCallback r101, boolean r102) {
        Handler r103 = new Handler(Looper.getMainLooper());
        if (r102 == true) goto L34;
        r100.subscribe(new a(this, r103, r101), UiThreadImmediateExecutorService.getInstance());
        this.pendingImages.put(r101, r100);
        return;
    L34:
        CloseableReference r104 = (CloseableReference) DataSources.waitForFinalResult(r100);     // Catch: Throwable -> L18
        if (r104 != null) goto L33;
    L12:
        r101.onFailed("failed to get result from data sources");     // Catch: Throwable -> L16
        r100.close();
        if (r104 == null) goto L36;
    L23:
        CloseableReference.closeSafely(r104);
        return;
    L36:
        return;
    L33:
        CloseableImage r105 = (CloseableImage) r104.get();     // Catch: Throwable -> L16
        if ((r105 instanceof CloseableBitmap) == false) goto L12;
        r101.onSucceeded(bitmapToByteArray(((CloseableBitmap) r105).getUnderlyingBitmap()));     // Catch: Throwable -> L16
        r100.close();
        CloseableReference.closeSafely(r104);
        return;
    L16:
        Throwable th10 = th;
    L31:
        r101.onFailed(th10.toString());     // Catch: Throwable -> L24
        r100.close();
        if (r104 != null) goto L23;
        return;
    L24:
        th = move-exception;
        r100.close();
        if (r104 == null) goto L28;
        CloseableReference.closeSafely(r104);
    L28:
        throw th;
    L18:
        th = move-exception;
        r104 = null;
        th10 = th;
        goto L31
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl.b
    public void load(int r100, String r101, ResourceLoaderCallback r102, boolean r103, boolean r104) {
        if (this.destroyed == true) goto L51;
        if (r102 != null) goto L7;
        return;
    L7:
        if (Fresco.hasBeenInitialized() == true) goto L10;
        r102.onFailed("Fresco has not been initialized!");
        return;
    L10:
        ImagePipeline r105 = Fresco.getImagePipeline();
        ImageRequest r106 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101)).build();
        CloseableReference r107 = null;
        PooledByteBufferInputStream r108 = null;
        r108 = null;
        if (validEncodedType.contains(Integer.valueOf(r106.getSourceUriType())) == true) goto L14;
        loadDocodedImage(r105.fetchDecodedImage(r106, null), r102, r103);
        return;
    L14:
        DataSource<CloseableReference<PooledByteBuffer>> r109 = r105.fetchEncodedImage(r106, null);
        if (r103 == true) goto L57;
        r109.subscribe(new b(this, r102, new Handler(Looper.getMainLooper())), UiThreadImmediateExecutorService.getInstance());
        HashMap<ResourceLoaderCallback, DataSource<CloseableReference<PooledByteBuffer>>> r110 = this.pendingCallbacks;
        monitor-enter(r110);
        this.pendingCallbacks.put(r102, r109);     // Catch: Throwable -> L48
        monitor-exit(r110);     // Catch: Throwable -> L48
        return;
    L48:
        th = move-exception;
        throw th;
    L57:
        CloseableReference r111 = (CloseableReference) DataSources.waitForFinalResult(r109);     // Catch: Throwable -> L29
        if (r111 == null) goto L21;
        PooledByteBufferInputStream r112 = new PooledByteBufferInputStream((PooledByteBuffer) r111.get());     // Catch: Throwable -> L27
        byte[] r113 = new byte[r112.available()];     // Catch: Throwable -> L52
        r112.read(r113);     // Catch: Throwable -> L52
        r102.onSucceeded(r113);     // Catch: Throwable -> L52
        r108 = r112;
    L22:
        r109.close();
        if (r111 == null) goto L25;
        CloseableReference.closeSafely(r111);
    L25:
        if (r108 == null) goto L63;
        Closeables.closeQuietly(r108);
        return;
    L63:
        return;
    L28:
        r107 = r111;
    L61:
        r102.onFailed("");     // Catch: Throwable -> L36
        r109.close();
        if (r107 == null) goto L34;
        CloseableReference.closeSafely(r107);
    L34:
        if (r112 == null) goto L65;
        Closeables.closeQuietly(r112);
        return;
    L65:
        return;
    L36:
        th = move-exception;
        r109.close();
        if (r107 == null) goto L40;
        CloseableReference.closeSafely(r107);
    L40:
        if (r112 == null) goto L42;
        Closeables.closeQuietly(r112);
    L42:
        throw th;
    L21:
        r102.onFailed("");     // Catch: Throwable -> L27
    L27:
        r112 = r108;
    L29:
        r112 = null;
        goto L61
    }
}
