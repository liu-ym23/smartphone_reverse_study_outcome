package com.ttnet.org.chromium.net;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class TTNetDiagnosisRequest {

    public static abstract class Builder {
        public Builder() {
        }

        public abstract TTNetDiagnosisRequest build();

        public abstract Builder setMultiNetAction(int r100);

        public abstract Builder setNetDetectType(int r100);

        public abstract Builder setRequestType(int r100);

        public abstract Builder setTargets(List<String> r100);

        public abstract Builder setTimeout(int r100);
    }

    public interface Callback {
        void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r100, String r101);
    }

    public TTNetDiagnosisRequest() {
    }

    public abstract void cancel();

    public abstract void doExtraCommand(String r100, String r101);

    public abstract void start();
}
