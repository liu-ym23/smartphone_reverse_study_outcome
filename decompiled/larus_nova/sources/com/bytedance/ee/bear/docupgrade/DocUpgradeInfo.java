package com.bytedance.ee.bear.docupgrade;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/docupgrade/DocUpgradeInfo;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "status", "", "relateToken", "", "relateUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getStatus", "()I", "setStatus", "(I)V", "getRelateToken", "()Ljava/lang/String;", "setRelateToken", "(Ljava/lang/String;)V", "getRelateUrl", "setRelateUrl", "Companion", "docs-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocUpgradeInfo extends Result<Serializable> {
    public static final a Companion = null;
    public static final int NOT_UPGRADED = 0;
    public static final int UPGRADED = 2;
    public static final int UPGRADEDING = 1;
    private String relateToken;
    private String relateUrl;
    private int status;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DocUpgradeInfo() {
        this(0, null, null, 7, null);
    }

    public final String getRelateToken() {
        return this.relateToken;
    }

    public final String getRelateUrl() {
        return this.relateUrl;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setRelateToken(String r100) {
        this.relateToken = r100;
    }

    public final void setRelateUrl(String r100) {
        this.relateUrl = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public DocUpgradeInfo(int r100, String r101, String r102) {
        this.status = r100;
        this.relateToken = r101;
        this.relateUrl = r102;
    }

    public /* synthetic */ DocUpgradeInfo(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
