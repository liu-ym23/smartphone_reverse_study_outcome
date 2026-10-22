package com.ss.android.bytedcert.flow.cert;

import android.content.Context;
import com.ss.android.bytedcert.callback.H5CallBack;
import com.ss.android.bytedcert.callback.IWebEventCallback;
import com.ss.android.bytedcert.callback.ProgressCallback;
import com.ss.android.bytedcert.flow.base.CertParams;
import com.ss.android.cert.manager.callback.CertResultCallback;

/* JADX INFO: loaded from: classes34.dex */
public class BytedCertFlowParams extends CertParams<Builder> {
    private final CertResultCallback certResultCallback;
    private final H5CallBack h5CallBack;
    private final ProgressCallback progressCallback;
    private final IWebEventCallback webEventCallback;

    public static class Builder extends CertParams.Builder<Builder> {
        private CertResultCallback certResultCallback;
        private H5CallBack h5CallBack;
        private ProgressCallback progressCallback;
        private IWebEventCallback webEventCallback;

        public BytedCertFlowParams build() {
            return new BytedCertFlowParams(this);
        }

        public Builder(Context r100) {
            super(r100);
        }

        public static /* synthetic */ H5CallBack access$000(Builder r100) {
            return r100.h5CallBack;
        }

        public static /* synthetic */ CertResultCallback access$100(Builder r100) {
            return r100.certResultCallback;
        }

        public static /* synthetic */ ProgressCallback access$200(Builder r100) {
            return r100.progressCallback;
        }

        public static /* synthetic */ IWebEventCallback access$300(Builder r100) {
            return r100.webEventCallback;
        }

        public Builder setCertResultCallback(CertResultCallback r100) {
            this.certResultCallback = r100;
            return this;
        }

        public Builder setH5CallBack(H5CallBack r100) {
            this.h5CallBack = r100;
            return this;
        }

        public Builder setProgressCallback(ProgressCallback r100) {
            this.progressCallback = r100;
            return this;
        }

        public Builder setWebEventCallback(IWebEventCallback r100) {
            this.webEventCallback = r100;
            return this;
        }
    }

    public CertResultCallback getCertResultCallback() {
        return this.certResultCallback;
    }

    public H5CallBack getH5CallBack() {
        return this.h5CallBack;
    }

    public ProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public IWebEventCallback getWebEventCallback() {
        return this.webEventCallback;
    }

    public BytedCertFlowParams(Builder r100) {
        super(r100);
        this.h5CallBack = Builder.access$000(r100);
        this.certResultCallback = Builder.access$100(r100);
        this.progressCallback = Builder.access$200(r100);
        this.webEventCallback = Builder.access$300(r100);
    }
}
