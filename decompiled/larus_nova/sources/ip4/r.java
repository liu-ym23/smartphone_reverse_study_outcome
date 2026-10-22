package ip4;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f495293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseOpenEntity f495294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<BaseOpenEntity> f495295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<SpaceThirdPartyOpenEntity> f495296d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.f495293a == r101.f495293a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495294b, r101.f495294b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495295c, r101.f495295c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495296d, r101.f495296d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f495293a * 31;
        BaseOpenEntity r101 = this.f495294b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f495295c.hashCode()) * 31) + this.f495296d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AttachmentPreviewTmpData(index=" + this.f495293a + ", originClickEntity=" + this.f495294b + ", localEntityList=" + this.f495295c + ", followEntityList=" + this.f495296d + ')';
    }

    public r(int r100, BaseOpenEntity r101, ArrayList<BaseOpenEntity> r102, ArrayList<SpaceThirdPartyOpenEntity> r103) {
        Intrinsics.checkNotNullParameter(r102, "localEntityList");
        Intrinsics.checkNotNullParameter(r103, "followEntityList");
        this.f495293a = r100;
        this.f495294b = r101;
        this.f495295c = r102;
        this.f495296d = r103;
    }
}
