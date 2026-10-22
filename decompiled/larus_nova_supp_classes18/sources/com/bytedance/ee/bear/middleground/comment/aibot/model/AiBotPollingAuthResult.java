package com.bytedance.ee.bear.middleground.comment.aibot.model;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AiBotPollingAuthResult extends Result<Data> implements NonProguard {
    public static final String STATUS_ERROR = "error";
    public static final String STATUS_EXPIRED = "expired";
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_SLOW_DOWN = "slow_down";
    public static final String STATUS_SUCCESS = "success";

    public static class Data implements NonProguard {
        public String message;
        public String status;

        public Data() {
        }
    }

    public AiBotPollingAuthResult() {
    }
}
