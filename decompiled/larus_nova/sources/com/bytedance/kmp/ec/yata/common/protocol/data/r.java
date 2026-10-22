package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.bytedance.kmp.ec.yata.common.platform.jsonadapter.YataFieldsAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010%\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R0\u0010\u000b\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/r;", "", "", "yataSession", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "protocolId", "b", "", "", "operations", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class r {

    @SerializedName("operations")
    @JsonAdapter(YataFieldsAdapter.class)
    private final List<Map<String, Object>> operations;

    @SerializedName("protocol_id")
    private final String protocolId;

    @SerializedName("yata_session")
    private final String yataSession;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.yataSession, r101.yataSession) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.protocolId, r101.protocolId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.operations, r101.operations) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.yataSession;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.protocolId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<Map<String, Object>> r107 = this.operations;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Patches(yataSession=" + this.yataSession + ", protocolId=" + this.protocolId + ", operations=" + this.operations + ')';
    }

    public r() {
        this.yataSession = null;
        this.protocolId = null;
        this.operations = null;
    }

    public final List<Map<String, Object>> a() {
        return this.operations;
    }

    public final String b() {
        return this.protocolId;
    }

    public final String c() {
        return this.yataSession;
    }
}
