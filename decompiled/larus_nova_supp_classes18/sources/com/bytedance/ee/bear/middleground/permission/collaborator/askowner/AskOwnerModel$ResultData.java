package com.bytedance.ee.bear.middleground.permission.collaborator.askowner;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public final void setBlockCount(int r1) {
        this.blockCount = r1;
    }

    public final void setFailCount(int r1) {
        this.failCount = r1;
    }

    public AskOwnerModel$ResultData(HashMap<String, List<AskOwnerModel$FailMember>> r2, int r3, HashMap<String, List<AskOwnerModel$BlockMember>> r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "failMembers");
        Intrinsics.checkNotNullParameter(r4, "blockMembers");
        this.failMembers = r2;
        this.failCount = r3;
        this.blockMembers = r4;
        this.blockCount = r5;
    }

    public /* synthetic */ AskOwnerModel$ResultData(HashMap r2, int r3, HashMap r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = new HashMap();
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = new HashMap();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }
}
