package com.bytedance.ee.bear.middleground.permission.collaborator.askowner;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u007f\u00120\b\u0002\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00120\b\u0002\u0010\n\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0005`\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR9\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R9\u0010\n\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0005`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/askowner/AskOwnerModel$ResultData;", "Ljava/io/Serializable;", "failMembers", "Ljava/util/HashMap;", "", "", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/askowner/AskOwnerModel$FailMember;", "Lkotlin/collections/HashMap;", "failCount", "", "blockMembers", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/askowner/AskOwnerModel$BlockMember;", "blockCount", "<init>", "(Ljava/util/HashMap;ILjava/util/HashMap;I)V", "getFailMembers", "()Ljava/util/HashMap;", "getFailCount", "()I", "setFailCount", "(I)V", "getBlockMembers", "getBlockCount", "setBlockCount", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AskOwnerModel$ResultData implements Serializable {
    private int blockCount;
    private final HashMap<String, List<AskOwnerModel$BlockMember>> blockMembers;
    private int failCount;
    private final HashMap<String, List<AskOwnerModel$FailMember>> failMembers;

    public AskOwnerModel$ResultData() {
        this(null, 0, null, 0, 15, null);
    }

    public final int getBlockCount() {
        return this.blockCount;
    }

    public final HashMap<String, List<AskOwnerModel$BlockMember>> getBlockMembers() {
        return this.blockMembers;
    }

    public final int getFailCount() {
        return this.failCount;
    }

    public final HashMap<String, List<AskOwnerModel$FailMember>> getFailMembers() {
        return this.failMembers;
    }

    public final void setBlockCount(int r100) {
        this.blockCount = r100;
    }

    public final void setFailCount(int r100) {
        this.failCount = r100;
    }

    public AskOwnerModel$ResultData(HashMap<String, List<AskOwnerModel$FailMember>> r100, int r101, HashMap<String, List<AskOwnerModel$BlockMember>> r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "failMembers");
        Intrinsics.checkNotNullParameter(r102, "blockMembers");
        this.failMembers = r100;
        this.failCount = r101;
        this.blockMembers = r102;
        this.blockCount = r103;
    }

    public /* synthetic */ AskOwnerModel$ResultData(HashMap r100, int r101, HashMap r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new HashMap();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = new HashMap();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
