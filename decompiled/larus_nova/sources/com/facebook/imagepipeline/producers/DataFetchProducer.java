package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.alipay.sdk.m.u.i;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import fyb.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class DataFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "DataFetchProducer";

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return PRODUCER_NAME;
    }

    public DataFetchProducer(PooledByteBufferFactory r100) {
        super(CallerThreadExecutor.getInstance(), r100);
    }

    public static byte[] getData(String r100) {
        Preconditions.checkArgument(r100.substring(0, 5).equals(a.KEY_DATA));
        int r101 = r100.indexOf(44);
        String r102 = r100.substring(r101 + 1, r100.length());
        if (isBase64(r100.substring(0, r101)) == false) goto L7;
        return Base64.decode(r102, 0);
    L7:
        return Uri.decode(r102).getBytes();
    }

    public static boolean isBase64(String r100) {
        if (r100.contains(i.f25853b) == true) goto L6;
        return false;
    L6:
        String[] r101 = r100.split(i.f25853b);
        return r101[r101.length - 1].equals(TTVideoEngineInterface.PLAY_API_KEY_BASE64);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public EncodedImage getEncodedImage(ImageRequest r100) throws IOException {
        byte[] r101 = getData(r100.getSourceUri().toString());
        return getByteBufferBackedEncodedImage(new ByteArrayInputStream(r101), r101.length);
    }
}
