package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.FetchState;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface NetworkFetcher<FETCH_STATE extends FetchState> {

    /* JADX INFO: loaded from: classes23.dex */
    public interface Callback {
        void onCancellation();

        void onFailure(Throwable r100);

        void onResponse(InputStream r100, int r101) throws IOException;
    }

    FETCH_STATE createFetchState(Consumer<EncodedImage> r100, ProducerContext r101);

    void fetch(FETCH_STATE r100, Callback r101);

    @Nullable
    Map<String, String> getExtraMap(FETCH_STATE r100, int r101);

    void onFetchCompletion(FETCH_STATE r100, int r101);

    boolean shouldPropagate(FETCH_STATE r100);
}
