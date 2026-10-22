package com.bytedance.ee.bear.bitable.card.view.cell.link;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "offset", "", "hasMore", "", "linkTableName", "linkContent", "Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkContent;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkContent;)V", "getOffset", "()Ljava/lang/String;", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLinkTableName", "getLinkContent", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkContent;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkResult extends Result<Serializable> {
    private final Boolean hasMore;
    private final LinkContent linkContent;
    private final String linkTableName;
    private final String offset;

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final LinkContent getLinkContent() {
        return this.linkContent;
    }

    public final String getLinkTableName() {
        return this.linkTableName;
    }

    public final String getOffset() {
        return this.offset;
    }

    public LinkResult(String r100, Boolean r101, String r102, LinkContent r103) {
        this.offset = r100;
        this.hasMore = r101;
        this.linkTableName = r102;
        this.linkContent = r103;
    }

    public /* synthetic */ LinkResult(String r100, Boolean r101, String r102, LinkContent r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
