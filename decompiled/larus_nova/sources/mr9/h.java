package mr9;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f514994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResourceAttachmentExtra f514995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UplinkFileEntity f514996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f514997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f514998e;

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        boolean r100 = false;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, null, r101, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f514994a == r101.f514994a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514995b, r101.f514995b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f514996c, r101.f514996c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f514997d, r101.f514997d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f514998e, r101.f514998e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f514994a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f514995b.hashCode()) * 31;
        UplinkFileEntity r102 = this.f514996c;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return ((((r101 + r103) * 31) + this.f514997d.hashCode()) * 31) + this.f514998e.hashCode();
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResourceCenterUploadParam(enabled=" + this.f514994a + ", preParseExtraParam=" + this.f514995b + ", entity=" + this.f514996c + ", onLocalProcessReady=" + this.f514997d + ", onUploadedToServer=" + this.f514998e + ')';
    }

    public static h a(h r100, UplinkFileEntity r101) {
        boolean r102 = r100.f514994a;
        ResourceAttachmentExtra r103 = r100.f514995b;
        Function0<Unit> r104 = r100.f514997d;
        Function0<Unit> r105 = r100.f514998e;
        Intrinsics.checkNotNullParameter(r103, "preParseExtraParam");
        Intrinsics.checkNotNullParameter(r104, "onLocalProcessReady");
        Intrinsics.checkNotNullParameter(r105, "onUploadedToServer");
        return new h(r102, r103, r101, r104, r105);
    }

    public /* synthetic */ h(boolean r110, ResourceAttachmentExtra r111, UplinkFileEntity r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r113 & 2) == 0) goto L9;
        ResourceAttachmentExtra r101 = new ResourceAttachmentExtra(null, null, null, null, null, 31, null);
    L11:
        if ((r113 & 4) == 0) goto L13;
        UplinkFileEntity r102 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        Function0 r103 = new f();
    L19:
        if ((r113 & 16) == 0) goto L21;
        Function0 r104 = new g();
    L22:
        this(r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = null;
        goto L22
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public h(boolean r100, ResourceAttachmentExtra r101, UplinkFileEntity r102, Function0<Unit> r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r101, "preParseExtraParam");
        Intrinsics.checkNotNullParameter(r103, "onLocalProcessReady");
        Intrinsics.checkNotNullParameter(r104, "onUploadedToServer");
        this.f514994a = r100;
        this.f514995b = r101;
        this.f514996c = r102;
        this.f514997d = r103;
        this.f514998e = r104;
    }
}
