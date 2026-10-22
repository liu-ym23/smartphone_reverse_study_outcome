package jza;

import com.ss.android.lark.biz.officesdk.im.file.OpenFeishuFileSecurityBlockReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f501224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OpenFeishuFileSecurityBlockReason f501225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f501226c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f501224a == r101.f501224a) goto L12;
        return false;
    L12:
        if (this.f501225b == r101.f501225b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f501226c, r101.f501226c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f501224a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f501225b.hashCode()) * 31;
        f r102 = this.f501226c;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "OpenFeishuFileSecurityCheckResult(allowed=" + this.f501224a + ", blockReason=" + this.f501225b + ", uiConfig=" + this.f501226c + ')';
    }

    public /* synthetic */ e(OpenFeishuFileSecurityBlockReason r100) {
        this(false, r100, null);
    }

    public e(boolean r100, OpenFeishuFileSecurityBlockReason r101, f r102) {
        Intrinsics.checkNotNullParameter(r101, "blockReason");
        this.f501224a = r100;
        this.f501225b = r101;
        this.f501226c = r102;
    }
}
