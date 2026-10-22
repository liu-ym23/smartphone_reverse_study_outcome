package mu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableSharePermission;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements com.bytedance.ee.bear.share.export.f {
    public final String a;
    public final int b;
    public final BitableSharePermission c;

    public final String a() {
        return "";
    }

    public final boolean adminCanCross() {
        return false;
    }

    public final boolean canExport() {
        return true;
    }

    public final String d() {
        return "";
    }

    public final boolean e() {
        return false;
    }

    public final boolean externalAccess() {
        return false;
    }

    public final boolean g() {
        return true;
    }

    public final String h() {
        return "";
    }

    public final boolean i() {
        return false;
    }

    public final boolean isLinkShareAnyoneRead() {
        return false;
    }

    public final boolean isLinkShareInternalRead() {
        return false;
    }

    public final boolean isOwner() {
        return false;
    }

    public final boolean canShare() {
        return this.c.a.canShare();
    }

    public final boolean isLinkShareAnyoneEdit() {
        return this.c.b.isLinkShareAnyoneEdit();
    }

    public final boolean isLinkShareInternalEdit() {
        return this.c.b.isLinkShareInternalEdit();
    }

    public final int getDocType() {
        return this.b;
    }

    public final String getObjToken() {
        return this.a;
    }

    public final int getType() {
        return this.b;
    }

    public final String j() {
        return this.a;
    }

    public c(String r2, int r3, BitableSharePermission r4) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r4, "bitableSharePermission");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
