package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class GetMoveReviewerInfoPuller$Params implements NonProguard {
    public String dest_token;
    public String src_obj_token;
    public int src_obj_type;
    public String src_token;

    public String toString() {
        return "Params{src_token='" + yu5.c.j(this.src_token) + "', src_obj_token='" + yu5.c.j(this.src_obj_token) + "', src_obj_type=" + this.src_obj_type + ", dest_token='" + yu5.c.j(this.dest_token) + "'}";
    }

    public GetMoveReviewerInfoPuller$Params(String r1, String r2, int r3, String r4) {
        this.src_token = r1;
        this.src_obj_token = r2;
        this.src_obj_type = r3;
        this.dest_token = r4;
    }
}
