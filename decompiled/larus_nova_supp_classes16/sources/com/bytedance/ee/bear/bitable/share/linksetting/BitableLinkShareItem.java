package com.bytedance.ee.bear.bitable.share.linksetting;

import com.bytedance.ee.bear.middleground.permission.setting.linkshare.LinkShareItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/linksetting/BitableLinkShareItem;", "Lcom/bytedance/ee/bear/middleground/permission/setting/linkshare/LinkShareItem;", "linkShareEntry", "", "description", "", "<init>", "(ILjava/lang/String;)V", "getLinkShareEntry", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableLinkShareItem extends LinkShareItem {
    private final int linkShareEntry;

    public final int getLinkShareEntry() {
        return this.linkShareEntry;
    }

    public BitableLinkShareItem(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "description");
        super(14, r3);
        this.linkShareEntry = r2;
    }
}
