package com.facebook.imagepipeline.blurhash2;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.core.PriorityThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public class PreviewBlurHashProducer {
    public static final int DEFAULT_MAX_NUM_THREADS = 0;
    private static final String TAG = "PreviewBlurHashProducer";
    private static Executor mDecodeExecutor;
    private static String mGlobalMetaData;
    private static String mGlobalVvicMetaData;
    private PreviewBlurDecodeCallBack mBlurDecodeCallBack;
    private String mBlurHash;
    private final Runnable mDoJobRunnable;
    private String mMetaData;
    private PreviewDealFailCallBack mPreviewDealFailCallBack;
    private PreviewHashConfig mPreviewHashConfig;

    public interface PreviewBlurDecodeCallBack {
        void decodeResult(Bitmap r100);
    }

    public interface PreviewDealFailCallBack {
        void decodeFailed(String r100);
    }

    public void doJob() {
        mDecodeExecutor.execute(this.mDoJobRunnable);
    }

    static {
        DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
    }

    public static /* synthetic */ String access$200() {
        return mGlobalVvicMetaData;
    }

    public static /* synthetic */ PreviewHashConfig access$000(PreviewBlurHashProducer r100) {
        return r100.mPreviewHashConfig;
    }

    public static /* synthetic */ String access$100(PreviewBlurHashProducer r100) {
        return r100.mBlurHash;
    }

    public static /* synthetic */ String access$300(PreviewBlurHashProducer r100) {
        return r100.mMetaData;
    }

    public static /* synthetic */ PreviewDealFailCallBack access$400(PreviewBlurHashProducer r100) {
        return r100.mPreviewDealFailCallBack;
    }

    public static /* synthetic */ PreviewBlurDecodeCallBack access$500(PreviewBlurHashProducer r100) {
        return r100.mBlurDecodeCallBack;
    }

    public static void setGlobalMetaData(String r100) {
        mGlobalMetaData = r100;
    }

    public static void setGlobalVvicMetaData(String r100) {
        mGlobalVvicMetaData = r100;
    }

    public PreviewBlurHashProducer(String r100, PreviewHashConfig r101, PreviewBlurDecodeCallBack r102) {
        this(r100, mGlobalMetaData, r101, r102);
    }

    public PreviewBlurHashProducer(String r100, PreviewHashConfig r101, PreviewBlurDecodeCallBack r102, PreviewDealFailCallBack r110) {
        this(r100, mGlobalMetaData, r101, r102, r110);
    }

    public PreviewBlurHashProducer(String r100, String r101, PreviewHashConfig r102, PreviewBlurDecodeCallBack r110) {
        this(r100, r101, r102, r110, null);
    }

    public PreviewBlurHashProducer(String r100, String r101, PreviewHashConfig r102, PreviewBlurDecodeCallBack r110, PreviewDealFailCallBack r111) {
        Runnable r103 = new AnonymousClass1(this);
        this.mDoJobRunnable = r103;
        if (mDecodeExecutor != null) goto L5;
        mDecodeExecutor = PThreadExecutorsUtils.newFixedThreadPool(DEFAULT_MAX_NUM_THREADS, new PriorityThreadFactory(10, "BlurDecodeExecutor", true));
    L5:
        this.mBlurHash = r100;
        this.mMetaData = r101;
        this.mPreviewHashConfig = r102;
        this.mBlurDecodeCallBack = r110;
        this.mPreviewDealFailCallBack = r111;
        mDecodeExecutor.execute(r103);
    }
}
