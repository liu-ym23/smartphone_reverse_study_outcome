package com.bytedance.ee.bear.bitable.share.permission;

import com.bytedance.ee.bear.contract.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/permission/ShareTokenData;", "Lcom/bytedance/ee/bear/contract/Result;", "", "shareToken", "<init>", "(Ljava/lang/String;)V", "getShareToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareTokenData extends Result<String> {
    private final String shareToken;

    /* JADX WARN: Multi-variable type inference failed */
    public ShareTokenData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ShareTokenData copy$default(ShareTokenData r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.shareToken;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.shareToken;
    }

    public final ShareTokenData copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "shareToken");
        return new ShareTokenData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareTokenData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.shareToken, ((ShareTokenData) r100).shareToken) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.shareToken.hashCode();
    }

    public String toString() {
        return "ShareTokenData(shareToken=" + this.shareToken + ')';
    }

    public final String getShareToken() {
        return this.shareToken;
    }

    public ShareTokenData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "shareToken");
        this.shareToken = r100;
    }

    public /* synthetic */ ShareTokenData(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
