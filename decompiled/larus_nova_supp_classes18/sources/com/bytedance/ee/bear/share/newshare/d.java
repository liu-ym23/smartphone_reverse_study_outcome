package com.bytedance.ee.bear.share.newshare;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T1, T2, T3, R> implements Function3 {
    public final /* synthetic */ ShareDocFragment a;

    public d(ShareDocFragment r1) {
        this.a = r1;
    }

    public final Object apply(Object r9, Object r10, Object r11) {
        IDocUserPermission r6 = (IDocUserPermission) r9;
        DocMetaInfo r5 = (DocMetaInfo) r10;
        DocVersion r4 = (DocVersion) r11;
        Intrinsics.checkNotNullParameter(r6, "docPermission");
        Intrinsics.checkNotNullParameter(r5, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r4, "version");
        return new ShareDocInfo(this.a.oa0().getType(), this.a.oa0().getUrl(), this.a.oa0().getToken(), r4, r5, r6, 960);
    }
}
