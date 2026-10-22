package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes18.dex */
public class DesV3 implements NonProguard {

    /* JADX INFO: renamed from: op, reason: collision with root package name */
    public String f242184op;

    @SerializedName("op_uid")
    public String opUid;

    @SerializedName(DocViewModel.EXTRA_SPACE_ID)
    public String spaceId;

    public DesV3() {
    }

    public String toString() {
        return "DesV3{op='" + this.f242184op + "', spaceId='" + this.spaceId + "', opUid='" + this.opUid + "'}";
    }
}
