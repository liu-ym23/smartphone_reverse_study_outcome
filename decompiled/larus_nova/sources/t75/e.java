package t75;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f544887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f544888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseOpenEntity f544889c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f544887a == r101.f544887a) goto L12;
        return false;
    L12:
        if (this.f544888b == r101.f544888b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f544889c, r101.f544889c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f544887a * 31) + this.f544888b) * 31) + this.f544889c.hashCode();
    }

    public final String toString() {
        return "DrivePreviewAiPageSnapshot(index=" + this.f544887a + ", totalCount=" + this.f544888b + ", entity=" + this.f544889c + ')';
    }

    public e(int r100, int r101, BaseOpenEntity r102) {
        Intrinsics.checkNotNullParameter(r102, "entity");
        this.f544887a = r100;
        this.f544888b = r101;
        this.f544889c = r102;
    }
}
