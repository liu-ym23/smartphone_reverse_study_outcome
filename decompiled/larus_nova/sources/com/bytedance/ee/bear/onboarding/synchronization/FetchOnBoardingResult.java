package com.bytedance.ee.bear.onboarding.synchronization;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public class FetchOnBoardingResult extends Result<Data> implements NonProguard {

    public static class Data implements NonProguard {
        public Map<String, Guide> guides;
        public String profile;
        public String type;

        public Data() {
        }

        public String toString() {
            return "Data{type='" + this.type + "', guides=" + this.guides + ", profile='" + this.profile + "'}";
        }
    }

    public static class Guide implements NonProguard {
        public String context;
        public boolean is_done;

        public Guide() {
        }

        public String toString() {
            return "Guide{is_done=" + this.is_done + ", context='" + this.context + "'}";
        }
    }

    public FetchOnBoardingResult() {
    }
}
