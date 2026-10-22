package com.ss.videoarch.liveplayer.config;

import tmc.a;

/* JADX INFO: loaded from: classes38.dex */
public class PlayerConfigParams {

    public static class NNSRParams {
        public a<Integer> BMFSRBackEnd;
        public a<Integer> BMFSRPoolSize;
        public a<Integer> BMFSRScaleType;
        public a<Integer> EnableBMFSR;
        public a<Integer> EnableDynamicSR;
        public a<Integer> EnableUseSRAfterInit;
        public a<Integer> Enabled;
        public a<Integer> FrameRateUpperBound;
        public a<Integer> LongerSideUpperBound;
        public a<Integer> SRAlgType;
        public a<String> SRModuleName;
        public a<Integer> ShorterSideUpperBound;
        public a<Integer> VBitrateLowerBoundInKbps;

        public NNSRParams() {
            this.Enabled = new a(0);
            this.VBitrateLowerBoundInKbps = new a(0);
            this.LongerSideUpperBound = new a(0);
            this.ShorterSideUpperBound = new a(0);
            this.FrameRateUpperBound = new a(0);
            this.SRAlgType = new a(0);
            this.EnableBMFSR = new a(0);
            this.BMFSRScaleType = new a(0);
            this.BMFSRBackEnd = new a(0);
            this.BMFSRPoolSize = new a(0);
            this.EnableDynamicSR = new a(0);
            this.EnableUseSRAfterInit = new a(0);
            this.SRModuleName = new a("");
        }
    }

    public PlayerConfigParams() {
    }
}
