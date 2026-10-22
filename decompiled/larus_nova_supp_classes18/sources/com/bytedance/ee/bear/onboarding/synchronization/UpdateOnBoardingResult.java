package com.bytedance.ee.bear.onboarding.synchronization;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class UpdateOnBoardingResult extends Result<Data> implements NonProguard {

    public static class Data implements NonProguard {
        public String context;
        public boolean is_done;

        public Data() {
        }

        public String toString() {
            return "UpdateOnBoardingResult.Data{is_done=" + this.is_done + ", context='" + this.context + "'}";
        }
    }

    public UpdateOnBoardingResult() {
    }
}
