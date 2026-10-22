package com.ss.android.bytedcert.flow.face;

import android.content.Context;
import android.graphics.Bitmap;
import com.ss.android.bytedcert.callback.FaceLiveInterruptListener;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.flow.base.CertParams;

/* JADX INFO: loaded from: classes34.dex */
public class FaceDetectFlowParams extends CertParams<Builder> {
    private final Bitmap bitmap;
    private final SDKCallBack.FaceLiveCallback faceLiveCallback;
    private final FaceLiveInterruptListener faceLiveInterruptListener;
    private final boolean isOffline;

    public static class Builder extends CertParams.Builder<Builder> {
        private Bitmap bitmap;
        private SDKCallBack.FaceLiveCallback faceLiveCallback;
        private FaceLiveInterruptListener faceLiveInterruptListener;
        private boolean isOffline;

        public FaceDetectFlowParams build() {
            return new FaceDetectFlowParams(this);
        }

        public Builder(Context r100) {
            super(r100);
        }

        public static /* synthetic */ SDKCallBack.FaceLiveCallback access$000(Builder r100) {
            return r100.faceLiveCallback;
        }

        public static /* synthetic */ FaceLiveInterruptListener access$100(Builder r100) {
            return r100.faceLiveInterruptListener;
        }

        public static /* synthetic */ Bitmap access$200(Builder r100) {
            return r100.bitmap;
        }

        public static /* synthetic */ boolean access$300(Builder r100) {
            return r100.isOffline;
        }

        public Builder setBitmap(Bitmap r100) {
            this.bitmap = r100;
            this.isOffline = true;
            return this;
        }

        public Builder setFaceLiveCallback(SDKCallBack.FaceLiveCallback r100) {
            this.faceLiveCallback = r100;
            return this;
        }

        public Builder setFaceLiveInterruptListener(FaceLiveInterruptListener r100) {
            this.faceLiveInterruptListener = r100;
            return this;
        }
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public SDKCallBack.FaceLiveCallback getFaceLiveCallback() {
        return this.faceLiveCallback;
    }

    public FaceLiveInterruptListener getFaceLiveInterruptListener() {
        return this.faceLiveInterruptListener;
    }

    public boolean isOffline() {
        return this.isOffline;
    }

    public FaceDetectFlowParams(Builder r100) {
        super(r100);
        this.faceLiveCallback = Builder.access$000(r100);
        this.faceLiveInterruptListener = Builder.access$100(r100);
        this.bitmap = Builder.access$200(r100);
        this.isOffline = Builder.access$300(r100);
    }
}
