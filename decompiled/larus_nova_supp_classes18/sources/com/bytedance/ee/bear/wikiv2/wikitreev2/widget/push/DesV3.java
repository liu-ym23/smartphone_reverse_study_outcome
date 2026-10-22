package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DesV3 implements NonProguard {
    public String op;

    @SerializedName("op_uid")
    public String opUid;

    @SerializedName("space_id")
    public String spaceId;

    public DesV3() {
    }

    public String toString() {
        return "DesV3{op='" + this.op + "', spaceId='" + this.spaceId + "', opUid='" + this.opUid + "'}";
    }
}
