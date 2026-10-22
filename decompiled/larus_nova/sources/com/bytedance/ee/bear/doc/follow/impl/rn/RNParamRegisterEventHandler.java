package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class RNParamRegisterEventHandler implements NonProguard {
    public static final String SRC_INNER = "inner";
    public static final String SRC_OUTER = "outer";
    public String eventType;
    public String module;
    public String source;
    public String token;

    public RNParamRegisterEventHandler() {
    }

    public RNParamRegisterEventHandler(String r100, String r101, String r102) {
        this.token = r100;
        this.module = r101;
        this.eventType = r102;
        this.source = "";
    }

    public RNParamRegisterEventHandler(String r100, String r101, String r102, boolean r103) {
        this.token = r100;
        this.module = r101;
        this.eventType = r102;
        if (r103 == false) goto L5;
        String r104 = SRC_OUTER;
    L6:
        this.source = r104;
        return;
    L5:
        r104 = SRC_INNER;
        goto L6
    }
}
