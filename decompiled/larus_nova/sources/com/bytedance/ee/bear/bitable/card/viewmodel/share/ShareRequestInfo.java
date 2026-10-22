package com.bytedance.ee.bear.bitable.card.viewmodel.share;

import com.bytedance.ee.bear.share.IShareMeta;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRequestInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "shareMeta", "Lcom/bytedance/ee/bear/share/IShareMeta;", "shareRecordInfo", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "<init>", "(Lcom/bytedance/ee/bear/share/IShareMeta;Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;)V", "getShareMeta", "()Lcom/bytedance/ee/bear/share/IShareMeta;", "getShareRecordInfo", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareRequestInfo implements NonProguard {
    private final IShareMeta shareMeta;
    private final ShareRecordInfo shareRecordInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public ShareRequestInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final IShareMeta getShareMeta() {
        return this.shareMeta;
    }

    public final ShareRecordInfo getShareRecordInfo() {
        return this.shareRecordInfo;
    }

    public ShareRequestInfo(IShareMeta r100, ShareRecordInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "shareMeta");
        Intrinsics.checkNotNullParameter(r101, "shareRecordInfo");
        this.shareMeta = r100;
        this.shareRecordInfo = r101;
    }

    public /* synthetic */ ShareRequestInfo(IShareMeta r100, ShareRecordInfo r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = new DefaultShareMeta();
    L6:
        if ((r111 & 2) == 0) goto L8;
        r110 = new ShareRecordInfo(false, false, false, false, false, 31, null);
    L8:
        this(r100, r110);
    }
}
