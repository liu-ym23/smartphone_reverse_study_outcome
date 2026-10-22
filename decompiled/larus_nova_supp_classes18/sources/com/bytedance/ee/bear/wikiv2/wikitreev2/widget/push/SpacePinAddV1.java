package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/push/SpacePinAddV1;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "op", "", "getOp", "()Ljava/lang/String;", "setOp", "(Ljava/lang/String;)V", "spaceId", "getSpaceId", "setSpaceId", "synergyUuid", "getSynergyUuid", "setSynergyUuid", "toString", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpacePinAddV1 implements NonProguard {
    private String op;

    @SerializedName("space_id")
    private String spaceId;

    @SerializedName("synergy_uuid")
    private String synergyUuid;

    public SpacePinAddV1() {
    }

    public String toString() {
        return "SpacePinAddV1(spaceId=" + this.spaceId + ", synergyUuid=" + this.synergyUuid + ')';
    }

    public final String getOp() {
        return this.op;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final String getSynergyUuid() {
        return this.synergyUuid;
    }

    public final void setOp(String r1) {
        this.op = r1;
    }

    public final void setSpaceId(String r1) {
        this.spaceId = r1;
    }

    public final void setSynergyUuid(String r1) {
        this.synergyUuid = r1;
    }
}
