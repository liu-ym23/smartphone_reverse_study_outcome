package mu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableSharePermission;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements com.bytedance.ee.bear.share.export.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f515749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitableSharePermission f515750c;

    @Override // com.bytedance.ee.bear.share.export.f
    public final String a() {
        return "";
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean adminCanCross() {
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean canExport() {
        return true;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String d() {
        return "";
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean e() {
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean externalAccess() {
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean g() {
        return true;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String h() {
        return "";
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean i() {
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareAnyoneRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareInternalRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isOwner() {
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean canShare() {
        return this.f515750c.f215332a.canShare();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareAnyoneEdit() {
        return this.f515750c.f215333b.isLinkShareAnyoneEdit();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareInternalEdit() {
        return this.f515750c.f215333b.isLinkShareInternalEdit();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final int getDocType() {
        return this.f515749b;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String getObjToken() {
        return this.f515748a;
    }

    public final int getType() {
        return this.f515749b;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String j() {
        return this.f515748a;
    }

    public c(String r100, int r101, BitableSharePermission r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "bitableSharePermission");
        this.f515748a = r100;
        this.f515749b = r101;
        this.f515750c = r102;
    }
}
