package com.bytedance.ee.bear.bitable.titlebar;

import android.content.Context;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/titlebar/BitableHeaderConfig;", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig;", "<init>", "()V", "bitableCatalog", "Lcom/bytedance/ee/bear/bitable/titlebar/BitableCatalogModel;", "getBitableCatalog", "()Lcom/bytedance/ee/bear/bitable/titlebar/BitableCatalogModel;", "setBitableCatalog", "(Lcom/bytedance/ee/bear/bitable/titlebar/BitableCatalogModel;)V", "getTitleIcon", "", "titleIconId", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableHeaderConfig extends CustomHeaderConfig {
    private BitableCatalogModel bitableCatalog;

    public BitableHeaderConfig() {
    }

    public final BitableCatalogModel getBitableCatalog() {
        return this.bitableCatalog;
    }

    public final void setBitableCatalog(BitableCatalogModel r1) {
        this.bitableCatalog = r1;
    }

    @Override // com.bytedance.ee.bear.document.customheader.CustomHeaderConfig
    public Integer getTitleIcon(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "titleIconId");
        Intrinsics.checkNotNullParameter(r3, "context");
        BitableCatalogModel r0 = this.bitableCatalog;
        if (r0 == null) goto L8;
        if (r0 != null) goto L9;
        return null;
    L9:
        return Integer.valueOf(r0.getIcon(r3));
    L8:
        return super.getTitleIcon(r2, r3);
    }
}
