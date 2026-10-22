package com.facebook.imagepipeline.blurhash;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.core.PriorityThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public class BlurDecodeProducer {
    public static final int DEFAULT_MAX_NUM_THREADS = 0;
    private static final String TAG = "BlurDecode";
    private static Executor mDecodeExecutor;
    private BlurDecodeCallBack mBlurDecodeCallBack;
    private String mBlurHash;
    private BlurHashConfig mBlurHashConfig;
    private final Runnable mDoJobRunnable;

    public interface BlurDecodeCallBack {
        void decodeResult(Bitmap r100);
    }

    public void doJob() {
        mDecodeExecutor.execute(this.mDoJobRunnable);
    }

    static {
        DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
    }

    public static /* synthetic */ BlurHashConfig access$000(BlurDecodeProducer r100) {
        return r100.mBlurHashConfig;
    }

    public static /* synthetic */ String access$100(BlurDecodeProducer r100) {
        return r100.mBlurHash;
    }

    public static /* synthetic */ BlurDecodeCallBack access$200(BlurDecodeProducer r100) {
        return r100.mBlurDecodeCallBack;
    }

    public BlurDecodeProducer(String r100, BlurHashConfig r101, BlurDecodeCallBack r102) {
        Runnable r103 = new AnonymousClass1(this);
        this.mDoJobRunnable = r103;
        if (mDecodeExecutor != null) goto L5;
        mDecodeExecutor = PThreadExecutorsUtils.newFixedThreadPool(DEFAULT_MAX_NUM_THREADS, new PriorityThreadFactory(10, "BlurDecodeExecutor", true));
    L5:
        this.mBlurHash = r100;
        this.mBlurHashConfig = r101;
        this.mBlurDecodeCallBack = r102;
        mDecodeExecutor.execute(r103);
    }
}
