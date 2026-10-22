package com.larus.dora.impl.network;

import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0011\u001a\u00020\tHÆ\u0003J\t\u0010\u0012\u001a\u00020\tHÆ\u0003JG\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/network/DoraMessage;", "Ljava/io/Serializable;", "bizScene", "", "cmdId", "cmd", "cmdContent", "", "cmdIndex", "", "createTime", "<init>", "(IIILjava/lang/String;JJ)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraMessage implements Serializable {

    @SerializedName(DyVerifyEventConstants.EventParam.BIZ_SCENE)
    public int bizScene;

    @SerializedName("cmd")
    public int cmd;

    @SerializedName("cmd_content")
    public String cmdContent;

    @SerializedName("cmd_id")
    public int cmdId;

    @SerializedName("cmd_index")
    public long cmdIndex;

    @SerializedName("create_time")
    public long createTime;

    public DoraMessage() {
        this(0, 0, 0, null, 0, 0, 63, null);
    }

    public static /* synthetic */ DoraMessage copy$default(DoraMessage r100, int r110, int r111, int r112, String r113, long r114, long r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        int r101 = r100.bizScene;
    L7:
        if ((r116 & 2) == 0) goto L9;
        int r102 = r100.cmdId;
    L11:
        if ((r116 & 4) == 0) goto L13;
        int r103 = r100.cmd;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = r100.cmdContent;
    L19:
        if ((r116 & 16) == 0) goto L21;
        long r105 = r100.cmdIndex;
    L23:
        if ((r116 & 32) == 0) goto L25;
        long r106 = r100.createTime;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final int component1() {
        return this.bizScene;
    }

    public final int component2() {
        return this.cmdId;
    }

    public final int component3() {
        return this.cmd;
    }

    public final String component4() {
        return this.cmdContent;
    }

    public final long component5() {
        return this.cmdIndex;
    }

    public final long component6() {
        return this.createTime;
    }

    public final DoraMessage copy(int r110, int r111, int r112, String r113, long r114, long r115) {
        return new DoraMessage(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraMessage) == true) goto L8;
        return false;
    L8:
        DoraMessage r101 = (DoraMessage) r100;
        if (this.bizScene == r101.bizScene) goto L12;
        return false;
    L12:
        if (this.cmdId == r101.cmdId) goto L15;
        return false;
    L15:
        if (this.cmd == r101.cmd) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cmdContent, r101.cmdContent) == true) goto L21;
        return false;
    L21:
        if (this.cmdIndex == r101.cmdIndex) goto L24;
        return false;
    L24:
        if (this.createTime == r101.createTime) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.bizScene * 31) + this.cmdId) * 31) + this.cmd) * 31;
        String r101 = this.cmdContent;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = this.cmdIndex;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.createTime;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "DoraMessage(bizScene=" + this.bizScene + ", cmdId=" + this.cmdId + ", cmd=" + this.cmd + ", cmdContent=" + this.cmdContent + ", cmdIndex=" + this.cmdIndex + ", createTime=" + this.createTime + ')';
    }

    public DoraMessage(int r100, int r101, int r102, String r103, long r104, long r105) {
        this.bizScene = r100;
        this.cmdId = r101;
        this.cmd = r102;
        this.cmdContent = r103;
        this.cmdIndex = r104;
        this.createTime = r105;
    }

    public /* synthetic */ DoraMessage(int r100, int r101, int r102, String r103, long r110, long r111, int r112, DefaultConstructorMarker r113) {
        int r104 = 0;
        if ((r112 & 1) == 0) goto L5;
        int r114 = 0;
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r112 & 4) != 0) goto L15;
        r104 = r102;
    L15:
        if ((r112 & 8) == 0) goto L17;
        r103 = null;
    L17:
        String r106 = r103;
        if ((r112 & 16) == 0) goto L20;
        long r107 = -1;
    L22:
        if ((r112 & 32) == 0) goto L24;
        long r115 = -1;
    L25:
        this(r114, r105, r104, r106, r107, r115);
        return;
    L24:
        r115 = r111;
        goto L25
    L20:
        r107 = r110;
        goto L22
    L9:
        r105 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
