package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/push/PinAddV1;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "op", "", "getOp", "()Ljava/lang/String;", "setOp", "(Ljava/lang/String;)V", "objToken", "getObjToken", "setObjToken", "objType", "", "getObjType", "()I", "setObjType", "(I)V", "synergyUuid", "getSynergyUuid", "setSynergyUuid", "toString", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PinAddV1 implements NonProguard {

    @SerializedName(ResourceData.KEY_OBJ_TOKEN)
    private String objToken;

    @SerializedName("obj_type")
    private int objType;
    private String op;

    @SerializedName("synergy_uuid")
    private String synergyUuid;

    public String toString() {
        return "PinAddV1(objType=" + this.objType + ", synergyUuid=" + this.synergyUuid + ')';
    }

    public PinAddV1() {
        this.objType = e.e.b;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final String getOp() {
        return this.op;
    }

    public final String getSynergyUuid() {
        return this.synergyUuid;
    }

    public final void setObjToken(String r1) {
        this.objToken = r1;
    }

    public final void setObjType(int r1) {
        this.objType = r1;
    }

    public final void setOp(String r1) {
        this.op = r1;
    }

    public final void setSynergyUuid(String r1) {
        this.synergyUuid = r1;
    }
}
