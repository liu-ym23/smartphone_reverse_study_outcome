package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RNParamRegisterEventHandler implements NonProguard {
    public static final String SRC_INNER = "inner";
    public static final String SRC_OUTER = "outer";
    public String eventType;
    public String module;
    public String source;
    public String token;

    public RNParamRegisterEventHandler() {
    }

    public RNParamRegisterEventHandler(String r1, String r2, String r3) {
        this.token = r1;
        this.module = r2;
        this.eventType = r3;
        this.source = "";
    }

    public RNParamRegisterEventHandler(String r1, String r2, String r3, boolean r4) {
        this.token = r1;
        this.module = r2;
        this.eventType = r3;
        if (r4 == false) goto L5;
        String r5 = SRC_OUTER;
    L6:
        this.source = r5;
        return;
    L5:
        r5 = SRC_INNER;
        goto L6
    }
}
