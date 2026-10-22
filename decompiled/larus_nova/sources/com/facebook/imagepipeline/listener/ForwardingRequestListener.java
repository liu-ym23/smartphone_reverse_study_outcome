package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ForwardingRequestListener extends BaseRequestListener {
    private static final String TAG = "ForwardingRequestListener";
    private final List<RequestListener> mRequestListeners;

    public ForwardingRequestListener(Set<RequestListener> r100) {
        this.mRequestListeners = new ArrayList(r100.size());
        Iterator<RequestListener> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        RequestListener r102 = r101.next();
        if (r102 == null) goto L4;
        this.mRequestListeners.add(r102);
        goto L4
    }

    public void addRequestListener(RequestListener r100) {
        this.mRequestListeners.add(r100);
    }

    public byte[] decrypt(InputStream r100) {
        int r101 = this.mRequestListeners.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if ((this.mRequestListeners.get(r102) instanceof AbsDiskWriteReadListener) == true) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        return ((AbsDiskWriteReadListener) this.mRequestListeners.get(r102)).decrypt(r100);
    L9:
        return null;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(String r100) {
        int r101 = this.mRequestListeners.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        this.mRequestListeners.get(r102).onRequestCancellation(r100);     // Catch: Exception -> L7
    L9:
        r102 = r102 + 1;
    L7:
        e = move-exception;
        onException("InternalListener exception in onRequestCancellation", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String r100) {
        int r101 = this.mRequestListeners.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (this.mRequestListeners.get(r102).requiresExtraMap(r100) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public ForwardingRequestListener(RequestListener... r100) {
        this.mRequestListeners = new ArrayList(r100.length);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        RequestListener r103 = r100[r102];
        if (r103 == null) goto L7;
        this.mRequestListeners.add(r103);
    L7:
        r102 = r102 + 1;
        goto L3
    }

    private void onException(String r100, Throwable r101) {
        FLog.e(TAG, r100, r101);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(String r100, String r101) {
        int r102 = this.mRequestListeners.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        this.mRequestListeners.get(r103).onProducerStart(r100, r101);     // Catch: Exception -> L7
    L9:
        r103 = r103 + 1;
    L7:
        e = move-exception;
        onException("InternalListener exception in onProducerStart", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(String r100, String r101, String r102) {
        int r103 = this.mRequestListeners.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        this.mRequestListeners.get(r104).onProducerEvent(r100, r101, r102);     // Catch: Exception -> L7
    L9:
        r104 = r104 + 1;
    L7:
        e = move-exception;
        onException("InternalListener exception in onIntermediateChunkStart", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(String r100, String r101, @Nullable Map<String, String> r102) {
        int r103 = this.mRequestListeners.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        this.mRequestListeners.get(r104).onProducerFinishWithCancellation(r100, r101, r102);     // Catch: Exception -> L7
    L9:
        r104 = r104 + 1;
    L7:
        e = move-exception;
        onException("InternalListener exception in onProducerFinishWithCancellation", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(String r100, String r101, @Nullable Map<String, String> r102) {
        int r103 = this.mRequestListeners.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        this.mRequestListeners.get(r104).onProducerFinishWithSuccess(r100, r101, r102);     // Catch: Exception -> L7
    L9:
        r104 = r104 + 1;
    L7:
        e = move-exception;
        onException("InternalListener exception in onProducerFinishWithSuccess", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener
    public void onRequestIntermediateResult(ImageRequest r100, String r101, boolean r102) {
        int r103 = this.mRequestListeners.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L12;
        RequestListener r105 = this.mRequestListeners.get(r104);
    L9:
        e = move-exception;
        onException("InternalListener exception in onRequestIntermediateResult", e);
    L11:
        r104 = r104 + 1;
        goto L3
    L6:
        if ((r105 instanceof BaseRequestListener) == false) goto L11;
        ((BaseRequestListener) r105).onRequestIntermediateResult(r100, r101, r102);     // Catch: Exception -> L9
        goto L11
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
        int r103 = this.mRequestListeners.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        this.mRequestListeners.get(r104).onRequestSuccess(r100, r101, r102);     // Catch: Exception -> L7
    L9:
        r104 = r104 + 1;
    L7:
        e = move-exception;
        onException("InternalListener exception in onRequestSuccess", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(String r100, String r101, boolean r102) {
        int r103 = this.mRequestListeners.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        this.mRequestListeners.get(r104).onUltimateProducerReached(r100, r101, r102);     // Catch: Exception -> L7
    L9:
        r104 = r104 + 1;
    L7:
        e = move-exception;
        onException("InternalListener exception in onProducerFinishWithSuccess", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(String r100, String r101, Throwable r102, @Nullable Map<String, String> r103) {
        int r104 = this.mRequestListeners.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L10;
        this.mRequestListeners.get(r105).onProducerFinishWithFailure(r100, r101, r102, r103);     // Catch: Exception -> L7
    L9:
        r105 = r105 + 1;
    L7:
        e = move-exception;
        onException("InternalListener exception in onProducerFinishWithFailure", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(ImageRequest r100, String r101, Throwable r102, boolean r103) {
        int r104 = this.mRequestListeners.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L10;
        this.mRequestListeners.get(r105).onRequestFailure(r100, r101, r102, r103);     // Catch: Exception -> L7
    L9:
        r105 = r105 + 1;
    L7:
        e = move-exception;
        onException("InternalListener exception in onRequestFailure", e);
        goto L9
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
        int r104 = this.mRequestListeners.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L10;
        this.mRequestListeners.get(r105).onRequestStart(r100, r101, r102, r103);     // Catch: Exception -> L7
    L9:
        r105 = r105 + 1;
    L7:
        e = move-exception;
        onException("InternalListener exception in onRequestStart", e);
        goto L9
    }
}
