package com.bytedance.ee.bear.drive.biz.preview.vc.connector;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends AbsFollowableContentProvider {
    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider
    public final Class<? extends e>[] c() {
        return new Class[]{com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.class, o65.b.class, m65.a.class, n65.a.class};
    }

    public final Map<String, l65.b> j() {
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("NOT_BLOCK_PREVIEW", new l65.b("BoxPreview", "drive_update")), TuplesKt.to("BLOCK_PREVIEW", new l65.b("DocxBoxPreview", "drive_update"))});
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider
    public final e d() {
        return new m65.a(j());
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider
    public final e g() {
        return new n65.a(j());
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider
    public final e h() {
        return new com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b(j());
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider
    public final e i() {
        return new o65.b(j(), this.f223809d);
    }

    public b(l65.f r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "followableContentManager");
        super(r100, r101, r102);
    }
}
