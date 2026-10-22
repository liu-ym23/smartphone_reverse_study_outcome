package com.larus.agents.impl.webfetch;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import com.larus.im.internal.jni.bean.DispatchCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\""}, d2 = {"Lcom/larus/agents/impl/webfetch/WebFetchResultPayload;", "", "commandId", "", "sourceDeviceId", "sourceAppId", "", "errorCode", ContainerPosition.BODY, "Lcom/larus/agents/impl/webfetch/WebFetchResultBody;", "command", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILcom/larus/agents/impl/webfetch/WebFetchResultBody;I)V", "getCommandId", "()Ljava/lang/String;", "getSourceDeviceId", "getSourceAppId", "()I", "getErrorCode", "getBody", "()Lcom/larus/agents/impl/webfetch/WebFetchResultBody;", "getCommand", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r {

    @SerializedName(ContainerPosition.BODY)
    private final n body;

    @SerializedName("command")
    private final int command;

    @SerializedName("command_id")
    private final String commandId;

    @SerializedName("error_code")
    private final int errorCode;

    @SerializedName("source_app_id")
    private final int sourceAppId;

    @SerializedName("source_device_id")
    private final String sourceDeviceId;

    public r() {
        this(null, null, 0, 0, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.commandId, r101.commandId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceDeviceId, r101.sourceDeviceId) == true) goto L15;
        return false;
    L15:
        if (this.sourceAppId == r101.sourceAppId) goto L18;
        return false;
    L18:
        if (this.errorCode == r101.errorCode) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.body, r101.body) == true) goto L24;
        return false;
    L24:
        if (this.command == r101.command) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.commandId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.sourceDeviceId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.sourceAppId) * 31) + this.errorCode) * 31;
        n r107 = this.body;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.command;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "WebFetchResultPayload(redacted)";
    }

    public r(String r100, String r101, int r102, int r103, n r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = null;
    L8:
        int r106 = 0;
        if ((r105 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = 0;
    L15:
        if ((r105 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r105 & 32) == 0) goto L20;
        r106 = DispatchCommand.GET_WEBPAGE_RESPONSE.value;
    L20:
        this.commandId = r100;
        this.sourceDeviceId = r101;
        this.sourceAppId = r102;
        this.errorCode = r103;
        this.body = r104;
        this.command = r106;
    }
}
