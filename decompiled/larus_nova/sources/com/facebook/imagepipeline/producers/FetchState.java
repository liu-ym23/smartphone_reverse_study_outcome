package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class FetchState {
    private final Consumer<EncodedImage> mConsumer;
    private final ProducerContext mContext;

    @Nullable
    private Map<String, String> mEncodeImageExtraInfo;
    private long mLastIntermediateResultTimeMs;

    @Nullable
    private String mMd5;
    private boolean mNeedMd5;
    private int mOnNewResultStatusFlags;

    @Nullable
    private BytesRange mResponseBytesRange;

    @Nullable
    public List<Uri> getBackupUris() {
        return this.mContext.getImageRequest().getBackupUris();
    }

    public String getId() {
        return this.mContext.getId();
    }

    public ProducerListener getListener() {
        return this.mContext.getListener();
    }

    public Uri getUri() {
        return this.mContext.getImageRequest().getSourceUri();
    }

    public Consumer<EncodedImage> getConsumer() {
        return this.mConsumer;
    }

    public ProducerContext getContext() {
        return this.mContext;
    }

    @Nullable
    public Map<String, String> getEncodeImageExtraInfo() {
        return this.mEncodeImageExtraInfo;
    }

    public long getLastIntermediateResultTimeMs() {
        return this.mLastIntermediateResultTimeMs;
    }

    @Nullable
    public String getMd5() {
        return this.mMd5;
    }

    public int getOnNewResultStatusFlags() {
        return this.mOnNewResultStatusFlags;
    }

    @Nullable
    public BytesRange getResponseBytesRange() {
        return this.mResponseBytesRange;
    }

    public boolean needMd5() {
        return this.mNeedMd5;
    }

    public void setEncodeImageExtraInfo(@Nullable Map<String, String> r100) {
        this.mEncodeImageExtraInfo = r100;
    }

    public void setLastIntermediateResultTimeMs(long r100) {
        this.mLastIntermediateResultTimeMs = r100;
    }

    public void setMd5(String r100) {
        this.mMd5 = r100;
    }

    public void setNeedMd5(boolean r100) {
        this.mNeedMd5 = r100;
    }

    public void setOnNewResultStatusFlags(int r100) {
        this.mOnNewResultStatusFlags = r100;
    }

    public void setResponseBytesRange(BytesRange r100) {
        this.mResponseBytesRange = r100;
    }

    public FetchState(Consumer<EncodedImage> r100, ProducerContext r101) {
        this.mNeedMd5 = true;
        this.mConsumer = r100;
        this.mContext = r101;
        this.mLastIntermediateResultTimeMs = 0;
    }
}
