package com.facebook.imagepipeline.backends.okhttp3;

import android.net.Uri;
import android.os.SystemClock;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: loaded from: classes23.dex */
public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState> {
    private static final String FETCH_TIME = "fetch_time";
    private static final String IMAGE_SIZE = "image_size";
    private static final String QUEUE_TIME = "queue_time";
    private static final String TOTAL_TIME = "total_time";

    @Nullable
    private final CacheControl mCacheControl;
    private final Call.a mCallFactory;
    private Executor mCancellationExecutor;

    public static class OkHttpNetworkFetchState extends FetchState {
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        public OkHttpNetworkFetchState(Consumer<EncodedImage> r100, ProducerContext r101) {
            super(r100, r101);
        }
    }

    public OkHttpNetworkFetcher(OkHttpClient r100) {
        this(r100, r100.dispatcher().executorService());
    }

    public static /* synthetic */ Executor access$000(OkHttpNetworkFetcher r100) {
        return r100.mCancellationExecutor;
    }

    public OkHttpNetworkFetcher(Call.a r100, Executor r101) {
        this(r100, r101, true);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> r100, ProducerContext r101) {
        return new OkHttpNetworkFetchState(r100, r101);
    }

    public void fetch(OkHttpNetworkFetchState r100, NetworkFetcher.Callback r101) {
        r100.submitTime = System.currentTimeMillis();
        Uri r102 = r100.getUri();
        Request.Builder r103 = new Request.Builder().url(r102.toString()).get();     // Catch: Exception -> L11
        CacheControl r104 = this.mCacheControl;     // Catch: Exception -> L11
        if (r104 == null) goto L6;
        r103.cacheControl(r104);     // Catch: Exception -> L11
    L6:
        BytesRange r105 = r100.getContext().getImageRequest().getBytesRange();     // Catch: Exception -> L11
        if (r105 == null) goto L9;
        r103.addHeader("Range", r105.toHttpRangeHeaderValue());     // Catch: Exception -> L11
    L9:
        fetchWithRequest(r100, r101, r103.build());     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        r101.onFailure(e);
    }

    public Map<String, String> getExtraMap(OkHttpNetworkFetchState r100, int r101) {
        HashMap r102 = new HashMap(4);
        r102.put(QUEUE_TIME, Long.toString(r100.responseTime - r100.submitTime));
        r102.put(FETCH_TIME, Long.toString(r100.fetchCompleteTime - r100.responseTime));
        r102.put(TOTAL_TIME, Long.toString(r100.fetchCompleteTime - r100.submitTime));
        r102.put(IMAGE_SIZE, Integer.toString(r101));
        return r102;
    }

    public void onFetchCompletion(OkHttpNetworkFetchState r100, int r101) {
        r100.fetchCompleteTime = SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ FetchState createFetchState(Consumer r100, ProducerContext r101) {
        return createFetchState(r100, r101);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ void fetch(FetchState r100, NetworkFetcher.Callback r101) {
        fetch((OkHttpNetworkFetchState) r100, r101);
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ Map getExtraMap(FetchState r100, int r101) {
        return getExtraMap((OkHttpNetworkFetchState) r100, r101);
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ void onFetchCompletion(FetchState r100, int r101) {
        onFetchCompletion((OkHttpNetworkFetchState) r100, r101);
    }

    public OkHttpNetworkFetcher(Call.a r100, Executor r101, boolean r102) {
        this.mCallFactory = r100;
        this.mCancellationExecutor = r101;
        if (r102 == false) goto L5;
        CacheControl r103 = new CacheControl.Builder().noStore().build();
    L6:
        this.mCacheControl = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }

    private void handleException(Call r100, Exception r101, NetworkFetcher.Callback r102) {
        if (r100.isCanceled() == false) goto L5;
        r102.onCancellation();
        return;
    L5:
        r102.onFailure(r101);
    }

    public void fetchWithRequest(final OkHttpNetworkFetchState r100, final NetworkFetcher.Callback r101, Request r102) {
        final Call r103 = this.mCallFactory.newCall(r102);
        r100.getContext().addCallbacks(new AnonymousClass1(this, r103));
        r103.enqueue(new AnonymousClass2(this, r100, r101));
    }

    public static /* synthetic */ void access$100(OkHttpNetworkFetcher r100, Call r101, Exception r102, NetworkFetcher.Callback r103) {
        r100.handleException(r101, r102, r103);
    }
}
